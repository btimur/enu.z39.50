package kz.arta.ext.api.rest;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:25
 */
public class RestQueryContext {
    private String address;
    private String login;
    private String password;

    public RestQueryContext() {
    }

    public RestQueryContext(String address, String login, String password) {
        this.address = address;
        this.login = login;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
