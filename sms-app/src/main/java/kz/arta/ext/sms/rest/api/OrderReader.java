package kz.arta.ext.sms.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.CodeConstants;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.model.synergy.Order;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by timur on 8/28/2014 11:10 AM.
 */
public class OrderReader extends AFormsReader {

    private SimpleDateFormat sfDateTime;

    public OrderReader() {
        sfDateTime = new SimpleDateFormat(ConfigReader.getPropertyValue(CodeConstants.FORMAT_DATETIME));
    }

    public Order readOrder(RestQueryContext context, String dataUUID) {
        FormData orderData = readFormData(context, dataUUID);
        FormFieldsWrapper wrapper = orderData.convertToWrapper();
        Order order = new Order();
        order.setDataUUID(dataUUID);
        order.setSrokvozvrata(fillDate(wrapper, "srokvozvrata"));
        order.setDateofvidacha(fillDate(wrapper, "dateofvidacha"));
        order.setIin(getValue(wrapper, "iin"));
        order.setInvnum(getValue(wrapper, "invnum"));
        order.setUserid(getValue(wrapper, "userid"));
        order.setNameofbook(getValue(wrapper, "nameofbook"));
        return order;
    }

    private String GetNameBooks(RestQueryContext context, String UserId, Date srokvozvrata ) {
        //todo получение списка книг
        List<String> bookNames = new ArrayList<String>();

        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (String intValue : bookNames) {
            if(!isFirst)
            {
                stringBuilder.append(", ");
            }
            stringBuilder.append(intValue);
            isFirst = false;
        }

        if (stringBuilder.toString().length() > kz.arta.ext.sms.util.CodeConstants.MAX_SIZE_NAMRBOOK) {
            return String.format("кол-во %d книг", bookNames.size());
        }
            return stringBuilder.toString();
    }

    private String getValue(FormFieldsWrapper wrapper, String iin) {
        FormField field = wrapper.getFormFieldMap().get(iin);
        return field != null ? field.getValue() : null;
    }

    protected Date fillDate(FormFieldsWrapper wrapper, String field) {
        String dateofsdacha = wrapper.getFormFieldMap().get(field).getKey();
        if (StringUtils.isNullOrEmpty(dateofsdacha)) {
            return null;
        }
        try {
            return sfDateTime.parse(dateofsdacha);

        } catch (ParseException e) {
            log.error("error parse date " + dateofsdacha, e);
        }
        return null;
    }

    public void unblockProcess(RestQueryContext context, BlockSignalMessage blockSignalMessage) throws IOException {
        String query = String.format("/rest/api/processes/signal?signal=got_agree&m1=resolution&value1=SEND_SMS_OK&executionID=%s",
                blockSignalMessage.getExecutionID());
        String resultData = doGetQuery(context, query);
        log.info("unblock process ID {} return data -{}", blockSignalMessage.getExecutionID(), resultData);
    }
}
