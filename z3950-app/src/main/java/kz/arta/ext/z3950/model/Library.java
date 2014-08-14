package kz.arta.ext.z3950.model;

/**
 * Created by timur on 25/07/2014 12:05.
 */
public class Library {
    /**
     * идентификатор
     */
    private Long id;
    /**
     * наименование библиотеки
     */
    private String nameLib;
    /**
     * хост библиотеки для сервиса Z39.50
     */
    private String zhost;
    /**
     * порт библиотеки для сервиса Z39.50
     */
    private int zport;
    /**
     * база библиотеки для сервиса Z39.50
     */
    private String zdb;
    /**
     * пользовател библиотеки для сервиса Z39.50
     */
    private String zUser;
    /**
     * пароль библиотеки для сервиса Z39.50
     */
    private String zPwd;
    /**
     * Format библиотеки для сервиса Z39.50
     */
    private String zFormat;

    /**
     * Format библиотеки для сервиса Z39.50
     */
    private String encoding = "UTF8";

    /***
     * тип запросов
     * The following is supported: prefix for Prefix Query Notation (Type-1 Query); cql for CQL search (Type-2 Query),
     */
    private String queryType;

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

    public String getzFormat() {
        return zFormat;
    }

    public void setzFormat(String zFormat) {
        this.zFormat = zFormat;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
