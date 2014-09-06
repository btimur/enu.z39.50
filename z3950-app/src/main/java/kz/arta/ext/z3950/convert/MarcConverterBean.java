package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;

import javax.inject.Inject;

/**
 * Created by timur on 9/3/2014 12:34 PM.
 */
public class MarcConverterBean {

    @Inject
    private RusMarcConverter rusmarcConverter;

    @Inject
    private UnimarcConverter unimarcConverter;

    @Inject
    private UsmarcConverter usmarcConverter;

    public IMarcConverter getConverter(Library library) {
        if (FormatEnum.RUSMARC.name().equals(library.getzFormat())) {
            return rusmarcConverter;
        } else if (FormatEnum.UNIMARC.name().equals(library.getzFormat())) {
            return unimarcConverter;
        } else if (FormatEnum.USMARC.name().equals(library.getzFormat())) {
            return usmarcConverter;
        }
        return null;
    }
}
