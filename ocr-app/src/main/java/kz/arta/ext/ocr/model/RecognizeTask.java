package kz.arta.ext.ocr.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "STARTED")
    private boolean started;

    @Column(name = "DATE_ADD")
    private Date dateAdd;

    @Column(name = "DATE_START")
    private Date dateStart;

    @Column(name = "DATE_END")
    private Date dateEnd;

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
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
