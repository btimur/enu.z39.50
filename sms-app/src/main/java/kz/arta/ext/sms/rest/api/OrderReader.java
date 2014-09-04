package kz.arta.ext.sms.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.common.util.CodeConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by timur on 8/28/2014 11:10 AM.
 */
public class OrderReader extends AFormsReader {

    private SimpleDateFormat sfDate;
    private SimpleDateFormat sfDateTime;

    public OrderReader() {
        sfDate = new SimpleDateFormat(ConfigReader.getPropertyValue(CodeConstants.FORMAT_DATE));
        sfDateTime = new SimpleDateFormat(ConfigReader.getPropertyValue(CodeConstants.FORMAT_DATETIME));
    }

    public Order readOrder(RestQueryContext context, String dataUUID) {
        FormData orderData = readFormData(context, dataUUID);
        FormFieldsWrapper wrapper = orderData.convertToWrapper();
        Order order = new Order();
        order.setDataUUID(dataUUID);
        order.setDateofsdacha(fillDate(wrapper, order, "dateofsdacha"));
        order.setDateofvidacha(fillDate(wrapper, order, "dateofvidacha"));
        order.setIin(wrapper.getFormFieldMap().get("iin").getValue());
        order.setInvnum(wrapper.getFormFieldMap().get("invnum").getValue());
        order.setNameofbook(wrapper.getFormFieldMap().get("nameofbook").getValue());
        order.setUserid(wrapper.getFormFieldMap().get("userid").getValue());
        return order;
    }

    protected Date fillDate(FormFieldsWrapper wrapper, Order order, String field) {
        String dateofsdacha = wrapper.getFormFieldMap().get(field).getTimestamp();
        if (StringUtils.isNullOrEmpty(dateofsdacha)){
            return null;
        }
        try {
            return sfDateTime.parse(dateofsdacha);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
