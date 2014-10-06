package kz.arta.ext.z3950.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by timur on 10/3/14.
 * Логин доступа для внешних пользователей
 */
@Entity
@Table(name = "EXTERNAL")
public class External implements IEntity {
    private Long id;
    private String login;
    private String pwd;
    private Timestamp dateAdd;
    private Timestamp dateEnd;
    private boolean block;
    private String descr;
    private boolean deleted;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PWD")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "DATE_ADD")
    public Timestamp getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Timestamp dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Basic
    @Column(name = "DATE_END")
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

//    @JsonProperty("isBlock")
    @Basic
    @Column(name = "IS_BLOCK")
    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
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
    @Column(name = "IS_DELETED")
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.deleted = deleted;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        External external = (External) o;

        if (!id.equals(external.id)) return false;
        if (block != external.block) return false;
        if (deleted != external.deleted) return false;
        if (dateAdd != null ? !dateAdd.equals(external.dateAdd) : external.dateAdd != null) return false;
        if (dateEnd != null ? !dateEnd.equals(external.dateEnd) : external.dateEnd != null) return false;
        if (descr != null ? !descr.equals(external.descr) : external.descr != null) return false;
        if (login != null ? !login.equals(external.login) : external.login != null) return false;
        return !(pwd != null ? !pwd.equals(external.pwd) : external.pwd != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (block ? 1 : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }
}
