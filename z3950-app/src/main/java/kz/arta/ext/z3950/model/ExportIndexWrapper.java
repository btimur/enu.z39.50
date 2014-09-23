package kz.arta.ext.z3950.model;

import java.io.Serializable;

/**
 * Created by timur on 9/22/14.
 * для запуска индексации
 */
public class ExportIndexWrapper implements Serializable{
    private String uuid;
    private Integer startPosition;
    private Integer endPosition;

    public ExportIndexWrapper() {
    }

    public ExportIndexWrapper(String uuid, Integer startPosition, Integer endPosition) {
        this.uuid = uuid;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }
}
