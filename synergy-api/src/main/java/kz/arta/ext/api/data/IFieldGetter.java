package kz.arta.ext.api.data;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 06.05.14
 * Time: 3:24
 */
public interface IFieldGetter {
    String getId(int i, Object obj);
    String getKeyField(Object obj);
    void prepareDictionary(Dictionary dictionary, Object obj);
}
