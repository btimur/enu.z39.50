package kz.arta.ext.z3950.model.synergy;

/**
 * Created by timur on 12/07/2014 10:58.
 */
public class KeyObject {
    private String nameRu;
    private String key;


    public KeyObject(String key, String nameRu) {
        this.nameRu = nameRu;
        this.key = key;
    }

    public KeyObject() {
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
