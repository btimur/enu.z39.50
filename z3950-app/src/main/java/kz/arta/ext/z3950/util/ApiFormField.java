package kz.arta.ext.z3950.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by timur on 12/07/2014 13:11.
 */
@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ApiFormField {

    String typeField();
    String nameField();

}
