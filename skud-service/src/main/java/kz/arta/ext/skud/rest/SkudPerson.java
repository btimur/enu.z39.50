package kz.arta.ext.skud.rest;

/**
 * Created by Администратор on 12.09.2014.
 * JSON объект
 */
@SuppressWarnings("UnusedDeclaration")
public class SkudPerson {

    private String iin;

    public SkudPerson() {
    }

    public SkudPerson(String iin) {
        this.iin = iin;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }
}
