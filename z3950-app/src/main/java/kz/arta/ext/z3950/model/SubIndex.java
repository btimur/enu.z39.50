package kz.arta.ext.z3950.model;

import javax.persistence.*;

/**
 * Created by timur on 8/15/2014 2:48 PM.
 */
@Entity
@Table(name = "subindex")
public class SubIndex implements IEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FORMAT_LIB")
    private String format;

    @Column(name = "FIELD")
    private String field;

    @Column(name = "TAG")
    private char tag;

    @Column(name = "SUBINDEX")
    private Integer subindex;

    @Column(name = "START")
    private Integer start;

    @Column(name = "END")
    private Integer end;

    public SubIndex() {
    }

    public SubIndex(String field, char tag, Integer subindex, Integer start, Integer end) {
        this.field = field;
        this.tag = tag;
        this.subindex = subindex;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getSubindex() {
        return subindex;
    }

    public void setSubindex(Integer subindex) {
        this.subindex = subindex;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public char getTag() {
        return tag;
    }

    public void setTag(char tag) {
        this.tag = tag;
    }
}
