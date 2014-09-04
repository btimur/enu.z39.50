package kz.arta.ext.z3950.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;

/**
 * Created by timur on 8/22/2014 12:15 PM.
 */
@Entity
@Table(name = "blocks", schema = "", catalog = "z3950")
public class Block implements IEntity {
    private Long id;
    private String nameblock;
    private String descr;
    private String blnum;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAMEBLOCK")
    public String getNameblock() {
        return nameblock;
    }

    public void setNameblock(String nameblock) {
        this.nameblock = nameblock;
    }

    @Basic
    @Column(name = "DESCR")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Basic
    @Column(name = "BLNUM")
    public String getBlnum() {
        return blnum;
    }

    public void setBlnum(String blnum) {
        this.blnum = blnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block that = (Block) o;

        if (blnum != null ? !blnum.equals(that.blnum) : that.blnum != null) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nameblock != null ? !nameblock.equals(that.nameblock) : that.nameblock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameblock != null ? nameblock.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (blnum != null ? blnum.hashCode() : 0);
        return result;
    }
}
