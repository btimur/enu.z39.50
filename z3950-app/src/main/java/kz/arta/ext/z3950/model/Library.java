package kz.arta.ext.z3950.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;

/**
 * Класс - объект "Конфигурация подключения к библиотеке"
 */
@Entity
@Table(name = "lib_configuration")
public class Library implements IEntity {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    /**
     * наименование библиотеки
     */
    @Column(name = "NAME_LIB")
    private String nameLib;
    /**
     * хост библиотеки для сервиса Z39.50
     */
    @Column(name = "HOST_LIB")
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
    @Column(name = "PWD")
    private String zPwd;
    /**
     * Format библиотеки для сервиса Z39.50
     */
    @Column(name = "FORMAT_LIB")
    private String zFormat;

    /**
     * Format библиотеки для сервиса Z39.50
     */
    @Column(name = "ENCODING")
    private String encoding = kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8;

    /***
     * тип запросов
     * The following is supported: prefix for Prefix Query Notation (Type-1 Query); cql for CQL search (Type-2 Query),
     */
    @Column(name = "QUERY_TYPE")
    private String queryType;

    /***
     * тип запросов
     * The following is supported: prefix for Prefix Query Notation (Type-1 Query); cql for CQL search (Type-2 Query),
     */
    @Column(name = "USE_SEARCH")
    private boolean useSearch;

    @Transient
    private boolean countResult;

    @Transient
    private boolean load;

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


    public boolean isUseSearch() {
        return useSearch;
    }

    public void setUseSearch(boolean useSearch) {
        this.useSearch = useSearch;
    }

    public boolean isCountResult() {
        return countResult;
    }

    public void setCountResult(boolean countResult) {
        this.countResult = countResult;
    }

    public boolean isLoad() {
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", nameLib='" + nameLib + '\'' +
                ", zhost='" + zhost + '\'' +
                ", zport=" + zport +
                ", zdb='" + zdb + '\'' +
                ", zUser='" + zUser + '\'' +
                ", zPwd='" + zPwd + '\'' +
                ", zFormat='" + zFormat + '\'' +
                ", encoding='" + encoding + '\'' +
                ", queryType='" + queryType + '\'' +
                ", useSearch=" + useSearch +
                ", countResult=" + countResult +
                ", load=" + load +
                '}';
    }
}
