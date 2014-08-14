package kz.arta.ext.z3950.model;

import javax.persistence.*;

/**
 * Created by timur on 25/07/2014 12:05.
 */
@Entity
@Table(name = "lib_configuration")
public class Library {

    public static final String FILDNAME_LIBNAME = "nameLib";
    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    /**
     * наименование библиотеки
     */
    @Column(name = "NAME")
    private String nameLib;
    /**
     * хост библиотеки для сервиса Z39.50
     */
    @Column(name = "HOST")
    private String zhost;
    /**
     * порт библиотеки для сервиса Z39.50
     */
    @Column(name = "PORT")
    private int zport;
    /**
     * база библиотеки для сервиса Z39.50
     */
    @Column(name = "DBNAME")
    private String zdb;
    /**
     * пользовател библиотеки для сервиса Z39.50
     */
    @Column(name = "LOGIN")
    private String zUser;
    /**
     * пароль библиотеки для сервиса Z39.50
     */
    @Column(name = "PASSWORD")
    private String zPwd;
    /**
     * Format библиотеки для сервиса Z39.50
     */
    @Column(name = "FORMAT")
    @Enumerated(EnumType.STRING)
    private FormatEnum zFormat;

    /**
     * Format библиотеки для сервиса Z39.50
     */
    @Column(name = "ENCODING")
    private String encoding = "UTF8";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameLib() {
        return nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }

    public String getZhost() {
        return zhost;
    }

    public void setZhost(String zhost) {
        this.zhost = zhost;
    }

    public int getZport() {
        return zport;
    }

    public void setZport(int zport) {
        this.zport = zport;
    }

    public String getZdb() {
        return zdb;
    }

    public void setZdb(String zdb) {
        this.zdb = zdb;
    }

    public String getzUser() {
        return zUser;
    }

    public void setzUser(String zUser) {
        this.zUser = zUser;
    }

    public String getzPwd() {
        return zPwd;
    }

    public void setzPwd(String zPwd) {
        this.zPwd = zPwd;
    }

    public FormatEnum getzFormat() {
        return zFormat;
    }

    public void setzFormat(FormatEnum zFormat) {
        this.zFormat = zFormat;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
