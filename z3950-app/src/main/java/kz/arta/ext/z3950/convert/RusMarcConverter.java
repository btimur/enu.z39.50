package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.FormatEnum;

/**
 * Created by timur on 9/3/2014 12:36 PM.
 */
public class RusmarcConverter extends AUnimarcConverter {
    @Override
    protected String getFormat() {
        return FormatEnum.RUSMARC.name();
    }
}
