package kz.arta.ext.sport.util;

import kz.arta.ext.api.config.ConfigReader;

/**
 * Created by admin on 21.10.14.
 */
public class CodeConstants {
    public static final String FEMALE_GROUP = "Женская сборная";
    public static final String MALE_GROUP = "Мужская сборная";
    public static final String FACT_FORM = "Фактические данные";

    public static final String FEMALE_JUNIOR = "Юниоры";
    public static final String FEMALE_YOUTH = "Молодежная категория";
    public static final String FEMALE_ABULT = "Взрослая категория";

    public static final String ZHENSKAYA_BORBA = "zhenskaya_borba";

    public static final String JUNIOR = "uniory";
    public static final String YOUTH = "molodezhnaya";
    public static final String ABULT = "vzroslaya";
    public static final String NATSIONAL = "natsionaln";
    public static final String OBLAST_CONTENT = "область";

    public static final String[] CITES = {"Астана", "Алматы"};
    public static final String WRESTLING = "volnaya_borba";
    public static final String GRECO_WRESTLING = "greko-rimskaya_borba";
    public static final String ABULT_CATEGORY = "Взрослая категория";
    public static final String YOUTH_CATEGORY = "Молодежная категория";
    public static final String JUNIOR_CATEGORY = "Юниор";
    public static final String REGION_EMPTY = "Спортсмены у которых не указан район";

    public static final String NSK = "НСК";


    public static final int MALE_INDEX = 1;
    public static final int FEMALE_INDEX = 2;
    public static final String ROOT_DEPARTMENT = ConfigReader.getPropertyValue("federation.root.uuid");

}
