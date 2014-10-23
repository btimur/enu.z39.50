package kz.arta.ext.ocr.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by timur on 9/25/14.
 * Задача для распознавания
 */
@Entity
@Table(name = "RECOGNIZE_TASK")
public class RecognizeTask implements IEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_UUID")
    private String dataUUID;

    @Column(name = "DOC_ID")
    private String docId;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "STARTED")
    private boolean started;

    @Column(name = "DATE_ADD")
    private Timestamp dateAdd;

    @Column(name = "DATE_START")
    private Timestamp dateStart;

    @Column(name = "DATE_END")
    private Timestamp dateEnd;

    @Column(name = "COMPLETED")
    private boolean completed;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "FILE_END")
    private String fileEnd;

    @Column(name = "UPLOADED")
    private boolean uploaded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataUUID() {
        return dataUUID;
    }

    public void setDataUUID(String dataUUID) {
        this.dataUUID = dataUUID;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public Timestamp getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Timestamp dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getFileEnd() {
        return fileEnd;
    }

    public void setFileEnd(String fileEnd) {
        this.fileEnd = fileEnd;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
