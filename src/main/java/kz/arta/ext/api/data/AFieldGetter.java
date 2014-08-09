package kz.arta.ext.api.data;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 06.05.14
 * Time: 5:11
 */
public abstract class AFieldGetter implements IFieldGetter{

    @Override
    public void prepareDictionary(Dictionary dictionary, Object obj) {

    }

    @Override
    public String getId(int i, Object obj) {
        return getKeyField(obj);
    }
}
