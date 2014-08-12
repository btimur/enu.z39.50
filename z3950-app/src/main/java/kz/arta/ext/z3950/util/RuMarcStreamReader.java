package kz.arta.ext.z3950.util;

import info.freelibrary.marc4j.converter.impl.AnselToUnicode;
import org.marc4j.Constants;
import org.marc4j.MarcException;
import org.marc4j.MarcReader;
import org.marc4j.converter.CharConverter;
import org.marc4j.marc.*;

import java.io.*;

/**
 * Created by timur on 09/08/2014 11:06.
 */
public class RuMarcStreamReader implements MarcReader {

    private DataInputStream input = null;

    private Record record;

    private MarcFactory factory;

    private String encoding = "ISO8859_1";

    private boolean override = false;

    private CharConverter converterAnsel = null;

    /**
     * Constructs an instance with the specified input stream.
     */
    public RuMarcStreamReader(InputStream input) {
        this(input, null);
    }

    /**
     * Constructs an instance with the specified input stream.
     */
    public RuMarcStreamReader(InputStream input, String encoding) {
        this.input =
                new DataInputStream((input.markSupported()) ? input
                        : new BufferedInputStream(input));
        factory = MarcFactory.newInstance();
        if (encoding != null) {
            this.encoding = encoding;
            override = true;
        }
    }

    /**
     * Returns true if the iteration has more records, false otherwise.
     */
    public boolean hasNext() {
        try {
            input.mark(10);
            if (input.read() == -1) {
                return false;
            }
            input.reset();
        } catch (IOException e) {
            throw new MarcException(e.getMessage(), e);
        }
        return true;
    }

    /**
     * Returns the next record in the iteration.
     *
     * @return Record - the record object
     */
    public Record next() {
        record = factory.newRecord();

        try {

            byte[] byteArray = new byte[24];
            input.readFully(byteArray);

            int recordLength = parseRecordLength(byteArray);
            byte[] recordBuf = new byte[recordLength - 24];
            input.readFully(recordBuf);
            parseRecord(record, byteArray, recordBuf, recordLength);
            return (record);
        } catch (EOFException e) {
            throw new MarcException("Premature end of file encountered", e);
        } catch (IOException e) {
            throw new MarcException("an error occured reading input", e);
        }
    }

    private void parseRecord(Record record, byte[] byteArray, byte[] recordBuf,
                             int recordLength) {
        Leader ldr;
        ldr = factory.newLeader();
        ldr.setRecordLength(recordLength);
        int directoryLength = 0;

        try {
            parseLeader(ldr, byteArray);
            directoryLength = ldr.getBaseAddressOfData() - (24 + 1);
        } catch (IOException e) {
            throw new MarcException("error parsing leader with data: " +
                    new String(byteArray), e);
        } catch (MarcException e) {
            throw new MarcException("error parsing leader with data: " +
                    new String(byteArray), e);
        }

        // if MARC 21 then check encoding
        switch (ldr.getCharCodingScheme()) {
            case ' ':
                if (!override) {
                    encoding = "ISO-8859-1";
                }
                break;
            case 'a':
                if (!override) {
                    encoding = "UTF8";
                }
        }
        record.setLeader(ldr);

        if ((directoryLength % 12) != 0) {
            throw new MarcException("invalid directory");
        }
        DataInputStream inputrec =
                new DataInputStream(new ByteArrayInputStream(recordBuf));
        int size = directoryLength / 12;

        String[] tags = new String[size];
        int[] lengths = new int[size];

        byte[] tag = new byte[3];
        byte[] length = new byte[4];
        byte[] start = new byte[5];

        String tmp;

        try {
            for (int i = 0; i < size; i++) {
                inputrec.readFully(tag);
                tmp = new String(tag);
                tags[i] = tmp;

                inputrec.readFully(length);
                tmp = new String(length);
                lengths[i] = Integer.parseInt(tmp);

                inputrec.readFully(start);
            }

            if (inputrec.read() != Constants.FT) {
                throw new MarcException(
                        "expected field terminator at end of directory");
            }

            for (int i = 0; i < size; i++) {
                getFieldLength(inputrec);

                // If tag is for a ControlField; else, try as DataField
                if (Constants.CF_TAG_PATTERN.matcher(tags[i]).find()) {
                    byteArray = new byte[lengths[i] - 1];
                    inputrec.readFully(byteArray);

                    if (inputrec.read() != Constants.FT) {
                        throw new MarcException(
                                "expected field terminator at end of field");
                    }

                    ControlField field = factory.newControlField();
                    field.setTag(tags[i]);
                    field.setData(getDataAsString(byteArray));
                    record.addVariableField(field);
                } else {
                    byteArray = new byte[lengths[i]];
                    inputrec.readFully(byteArray);

                    try {
                        record.addVariableField(parseDataField(tags[i],
                                byteArray));
                    } catch (IOException e) {
                        throw new MarcException(
                                "error parsing data field for tag: " + tags[i] +
                                        " with data: " + new String(byteArray),
                                e);
                    }
                }
            }

            if (inputrec.read() != Constants.RT) {
                throw new MarcException("expected record terminator");
            }
        } catch (IOException e) {
            throw new MarcException("an error occured reading input", e);
        }
    }

    private DataField parseDataField(String tag, byte[] field)
            throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(field);
        char ind1 = (char) bais.read();
        char ind2 = (char) bais.read();

        DataField dataField = factory.newDataField();
        dataField.setTag(tag);
        dataField.setIndicator1(ind1);
        dataField.setIndicator2(ind2);

        int code;
        int size;
        int readByte;
        byte[] data;
        Subfield subfield;
        while (true) {
            readByte = bais.read();
            if (readByte < 0) {
                break;
            }
            switch (readByte) {
                case Constants.US:
                    code = bais.read();
                    if (code < 0) {
                        throw new IOException("unexpected end of data field");
                    }
                    if (code == Constants.FT) {
                        break;
                    }
                    size = getSubfieldLength(bais);
                    data = new byte[size];
                    bais.read(data);
                    subfield = factory.newSubfield();
                    subfield.setCode((char) code);
                    subfield.setData(getDataAsString(data));
                    dataField.addSubfield(subfield);
                    break;
                case Constants.FT:
                    break;
            }
        }
        return dataField;
    }

    private int getFieldLength(DataInputStream bais) throws IOException {
        bais.mark(9999);
        int bytesRead = 0;
        while (true) {
            switch (bais.read()) {
                case Constants.FT:
                    bais.reset();
                    return bytesRead;
                case -1:
                    bais.reset();
                    throw new IOException("Field not terminated");
                case Constants.US:
                default:
                    bytesRead++;
            }
        }
    }

    private int getSubfieldLength(ByteArrayInputStream bais) throws IOException {
        bais.mark(9999);
        int bytesRead = 0;
        while (true) {
            switch (bais.read()) {
                case Constants.US:
                case Constants.FT:
                    bais.reset();
                    return bytesRead;
                case -1:
                    bais.reset();
                    throw new IOException("subfield not terminated");
                default:
                    bytesRead++;
            }
        }
    }

    private int parseRecordLength(byte[] leaderData) throws IOException {
        InputStreamReader isr =
                new InputStreamReader(new ByteArrayInputStream(leaderData),
                        "ISO-8859-1");
        int length = -1;
        char[] tmp = new char[5];
        isr.read(tmp);
        try {
            length = Integer.parseInt(new String(tmp));
        } catch (NumberFormatException e) {
            throw new MarcException("unable to parse record length", e);
        }
        return (length);
    }

    private void parseLeader(Leader ldr, byte[] leaderData) throws IOException {
        InputStreamReader isr =
                new InputStreamReader(new ByteArrayInputStream(leaderData),
                        "ISO-8859-1");
        char[] tmp = new char[5];
        isr.read(tmp);
        // Skip over bytes for record length, If we get here, its already been
        // computed.
        ldr.setRecordStatus((char) isr.read());
        ldr.setTypeOfRecord((char) isr.read());
        tmp = new char[2];
        isr.read(tmp);
        ldr.setImplDefined1(tmp);
        ldr.setCharCodingScheme((char) isr.read());
        char indicatorCount = (char) isr.read();
        char subfieldCodeLength = (char) isr.read();
        char baseAddr[] = new char[5];
        isr.read(baseAddr);
        tmp = new char[3];
        isr.read(tmp);
        ldr.setImplDefined2(tmp);
        tmp = new char[4];
        isr.read(tmp);
        ldr.setEntryMap(tmp);
        isr.close();
        try {
            ldr.setIndicatorCount(Integer.parseInt(String
                    .valueOf(indicatorCount)));
        } catch (NumberFormatException e) {
            throw new MarcException("unable to parse indicator count", e);
        }
        try {
            ldr.setSubfieldCodeLength(Integer.parseInt(String
                    .valueOf(subfieldCodeLength)));
        } catch (NumberFormatException e) {
            throw new MarcException("unable to parse subfield code length", e);
        }
        try {
            ldr.setBaseAddressOfData(Integer.parseInt(new String(baseAddr)));
        } catch (NumberFormatException e) {
            throw new MarcException("unable to parse base address of data", e);
        }

    }

    private String getDataAsString(byte[] bytes) {
        String dataElement = null;
        if (encoding.equals("UTF-8") || encoding.equals("UTF8")) {
            try {
                dataElement = new String(bytes, "UTF8");
            } catch (UnsupportedEncodingException e) {
                throw new MarcException("unsupported encoding", e);
            }
        } else if (encoding.equals("MARC-8") || encoding.equals("MARC8")) {
            if (converterAnsel == null) {
                converterAnsel = new AnselToUnicode();
            }
            dataElement = converterAnsel.convert(bytes);
        } else if (encoding.equals("ISO-8859-1") ||
                encoding.equals("ISO8859_1") || encoding.equals("ISO_8859_1")) {
            try {
                dataElement = new String(bytes, "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                throw new MarcException("unsupported encoding", e);
            }
        } else if (encoding.equals("cp1251") ||
                encoding.equals("cp-1251") || encoding.equals("windows-1251")) {
            try {
                dataElement = new String(bytes, "cp1251");
            } catch (UnsupportedEncodingException e) {
                throw new MarcException("unsupported encoding", e);
            }
        }

        return dataElement;
    }

}
