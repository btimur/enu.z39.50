import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.data.DictionaryColumn;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * Created by timur on 8/27/2014 8:34 PM.
 */


public class DictionaryTest {
    @Test
    public void testDeserialize() throws IOException {
        Dictionary dictionary = new Dictionary();
        dictionary.setDictCode("apitest");
        ArrayList<DictionaryColumn> columns = new ArrayList<DictionaryColumn>();
        DictionaryColumn e = new DictionaryColumn();
        e.setCode("number");
        e.setValue("42");
        columns.add(e);
        DictionaryColumn e3 = new DictionaryColumn();
        e3.setCode("field_desc");
        e3.setValue("Тест переводов");
        columns.add(e3);
        DictionaryColumn e2 = new DictionaryColumn();
        e2.setCode("field_name");
        e2.setValue("Поле с переводами");
        e2.setValueRU("казахский");
        e2.setValueKZ("русский");
        e2.setValueEN("английский");
        columns.add(e2);
        dictionary.setColumns(columns);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));
        String s = objectMapper.writeValueAsString(dictionary);
        String test = "{\"dictCode\":\"apitest\",\"columns\":[{\"code\":\"number\",\"value\":\"42\"},{\"code\":\"field_desc\",\"value\":\"Тест переводов\"},{\"code\":\"field_name\",\"value\":\"Поле с переводами\",\"valueKZ\":\"русский\",\"valueRU\":\"казахский\",\"valueEN\":\"английский\"}]}";
        Assert.assertEquals(s,test);
    }
}
