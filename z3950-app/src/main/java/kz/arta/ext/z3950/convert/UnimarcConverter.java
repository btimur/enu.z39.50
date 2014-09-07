package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.FormatEnum;

/**
 * Created by timur on 9/4/2014 11:44 AM.
 */
public class UnimarcConverter extends AUnimarcConverter {
    @Override
    protected String getFormat() {
        return FormatEnum.UNIMARC.name();
    }
}
