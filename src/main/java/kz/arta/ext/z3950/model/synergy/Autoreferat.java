package kz.arta.ext.z3950.model.synergy;

import kz.arta.ext.z3950.util.ApiFormField;

/**
 * Created by timur on 04/08/2014 21:21.
 * Авторефераты
 */
public class Autoreferat extends ABook {


    /**
     * Библиография
     */
    @ApiFormField(nameField = "320a",typeField = "textbox")
    private String f320a;

    /**
     * Ключевое слово
     */
    @ApiFormField(nameField = "610a",typeField = "textbox")
    private String f610a;

    /**
     * Автор
     */
    @ApiFormField(nameField = "700a",typeField = "textbox")
    private String f700a;

    /**
     * Номер ISBN
     */
    @ApiFormField(nameField = "010a",typeField = "textbox")
    private String f010a;

    /**
     * Цена
     */
    @ApiFormField(nameField = "010d",typeField = "textbox")
    private String f010d;

    /**
     * Язык основного текста
     */
    @ApiFormField(nameField = "101a",typeField = "listbox")
    private KeyObject f101a;

    /**
     * Заглавие
     */
    @ApiFormField(nameField = "200a",typeField = "textbox")
    private String f200a;

    /**
     * Материал(носитель)
     */
    @ApiFormField(nameField = "200b",typeField = "listbox")
    private KeyObject f200b;

    /**
     * Параллельное заглавие
     */
    @ApiFormField(nameField = "200d",typeField = "textbox")
    private String f200d;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "200e",typeField = "textbox")
    private String f200e;

    /**
     * Сведения об ответственности
     */
    @ApiFormField(nameField = "200f",typeField = "textbox")
    private String f200f;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "200h",typeField = "textbox")
    private String f200h;

    /**
     * Название части
     */
    @ApiFormField(nameField = "200i",typeField = "textbox")
    private String f200i;

    /**
     * Язык параллельного заглавия
     */
    @ApiFormField(nameField = "200z",typeField = "textbox")
    private String f200z;

    /**
     * Сведения об издании
     */
    @ApiFormField(nameField = "205a",typeField = "textbox")
    private String f205a;

    /**
     * Номер тома, части ист-ка
     */
    @ApiFormField(nameField = "207a",typeField = "textbox")
    private String f207a;

    /**
     * Место издания
     */
    @ApiFormField(nameField = "210a",typeField = "textbox")
    private String f210a;

    /**
     * Издательство
     */
    @ApiFormField(nameField = "210c",typeField = "textbox")
    private String f210c;

    /**
     * Год издания
     */
    @ApiFormField(nameField = "210d",typeField = "textbox")
    private String f210d;

    /**
     * Объём
     */
    @ApiFormField(nameField = "215a",typeField = "textbox")
    private String f215a;

    /**
     * Другие физические характеристики
     */
    @ApiFormField(nameField = "215c",typeField = "textbox")
    private String f215c;

    /**
     * Сопроводительный материал
     */
    @ApiFormField(nameField = "215e",typeField = "textbox")
    private String f215e;

    /**
     * Заглавие серии
     */
    @ApiFormField(nameField = "225a",typeField = "textbox")
    private String f225a;

    /**
     * Вид и объем электронного ресурса
     */
    @ApiFormField(nameField = "230a",typeField = "textbox")
    private String f230a;

    /**
     * Общие примечания
     */
    @ApiFormField(nameField = "300a",typeField = "textbox")
    private String f300a;

    /**
     * Примечание о содержании
     */
    @ApiFormField(nameField = "327a",typeField = "textbox")
    private String f327a;

    /**
     * Сведения об издании источника
     */
    @ApiFormField(nameField = "541e",typeField = "textbox")
    private String f541e;

    /**
     * Заглавие источника
     */
    @ApiFormField(nameField = "545a",typeField = "textbox")
    private String f545a;

    /**
     * Начальный элемент ввода ББК (Предметная рубрика)
     */
    @ApiFormField(nameField = "907a",typeField = "textbox")
    private String f907a;

    /**
     * Индекс УДК
     */
    @ApiFormField(nameField = "675a",typeField = "textbox")
    private String f675a;

    /**
     * Индекс ББК мас. библ
     */
    @ApiFormField(nameField = "907b",typeField = "textbox")
    private String f907b;

    /**
     * Прим. к электронному адресу
     */
    @ApiFormField(nameField = "856t",typeField = "textbox")
    private String f856t;

    /**
     * Электронный адрес ресурса
     */
    @ApiFormField(nameField = "8562",typeField = "textbox")
    private String f8562;

    /**
     * Тираж
     */
    @ApiFormField(nameField = "901b",typeField = "textbox")
    private String f901b;

    /**
     * Служебные отметки
     */
    @ApiFormField(nameField = "9015",typeField = "listbox")
    private KeyObject f9015;

    /**
     * Авторский знак
     */
    @ApiFormField(nameField = "908a",typeField = "textbox")
    private String f908a;

    /**
     * Вид содержания
     */
    @ApiFormField(nameField = "908b",typeField = "listbox")
    private KeyObject f908b;

    /**
     * Виды издания
     */
    @ApiFormField(nameField = "908c",typeField = "listbox")
    private KeyObject f908c;

    /**
     * Специальность
     */
    @ApiFormField(nameField = "910c",typeField = "listbox")
    private KeyObject f910c;

    /**
     * Год издания источника
     */
    @ApiFormField(nameField = "cmp-hqzf4n",typeField = "textbox")
    private String fcmp_hqzf4n;

    /**
     * Идентификатор записи
     */
    @ApiFormField(nameField = "idksdh",typeField = "textbox")
    private String fidksdh;

    /**
     * Уточнения
     */
    @ApiFormField(nameField = "cmp-phl5wf",typeField = "textbox")
    private String fcmp_phl5wf;

    /**
     * Ошибочный номер ISBN
     */
    @ApiFormField(nameField = "cmp-pl7j0m",typeField = "textbox")
    private String fcmp_pl7j0m;

    /**
     * Код страны
     */
    @ApiFormField(nameField = "cmp-gxvuqk",typeField = "textbox")
    private String fcmp_gxvuqk;

    /**
     * Номер
     */
    @ApiFormField(nameField = "cmp-7ryuow",typeField = "textbox")
    private String fcmp_7ryuow;

    /**
     * Ошибочный номер
     */
    @ApiFormField(nameField = "cmp-3h8iil",typeField = "textbox")
    private String fcmp_3h8iil;

    /**
     * Код страны
     */
    @ApiFormField(nameField = "cmp-u8yl9a",typeField = "textbox")
    private String fcmp_u8yl9a;

    /**
     * Номер
     */
    @ApiFormField(nameField = "cmp-5grpy9",typeField = "textbox")
    private String fcmp_5grpy9;

    /**
     * Ошибочный номер
     */
    @ApiFormField(nameField = "cmp-kaxb3b",typeField = "textbox")
    private String fcmp_kaxb3b;

    /**
     * Общие данные обработки
     */
    @ApiFormField(nameField = "cmp-0rjfra",typeField = "textbox")
    private String fcmp_0rjfra;

    /**
     * Дата ввода записи в файл
     */
    @ApiFormField(nameField = "cmp-hv1kyr",typeField = "textbox")
    private String fcmp_hv1kyr;

    /**
     * Тип даты публикации
     */
    @ApiFormField(nameField = "cmp-qb5k3a",typeField = "textbox")
    private String fcmp_qb5k3a;

    /**
     * Дата публикации 1
     */
    @ApiFormField(nameField = "cmp-dm9yst",typeField = "textbox")
    private String fcmp_dm9yst;

    /**
     * Дата публикации 2
     */
    @ApiFormField(nameField = "cmp-rcgb3o",typeField = "textbox")
    private String fcmp_rcgb3o;

    /**
     * Код целевого назначения
     */
    @ApiFormField(nameField = "cmp-1nagv7",typeField = "textbox")
    private String fcmp_1nagv7;

    /**
     * Правительственная публикация
     */
    @ApiFormField(nameField = "cmp-q44ozp",typeField = "textbox")
    private String fcmp_q44ozp;

    /**
     * Код модифицированной записи
     */
    @ApiFormField(nameField = "cmp-vj51eb",typeField = "textbox")
    private String fcmp_vj51eb;

    /**
     * Язык каталогизации
     */
    @ApiFormField(nameField = "cmp-xyq4ic",typeField = "textbox")
    private String fcmp_xyq4ic;

    /**
     * Код транслитерации
     */
    @ApiFormField(nameField = "cmp-gzp554",typeField = "textbox")
    private String fcmp_gzp554;

    /**
     * Наборы символов
     */
    @ApiFormField(nameField = "cmp-u42mya",typeField = "textbox")
    private String fcmp_u42mya;

    /**
     * Дополнительные наборы символов
     */
    @ApiFormField(nameField = "cmp-ayqko3",typeField = "textbox")
    private String fcmp_ayqko3;

    /**
     * Графика заглавия
     */
    @ApiFormField(nameField = "cmp-jikk5o",typeField = "textbox")
    private String fcmp_jikk5o;

    /**
     * Язык резюме
     */
    @ApiFormField(nameField = "cmp-tjky1y",typeField = "textbox")
    private String fcmp_tjky1y;

    /**
     * Язык оглавления
     */
    @ApiFormField(nameField = "cmp-flci2k",typeField = "textbox")
    private String fcmp_flci2k;

    /**
     * Язык промежуточного перевода, когда каталогизируемый документ переводится с языка оригинала
     */
    @ApiFormField(nameField = "cmp-zmwjf4",typeField = "textbox")
    private String fcmp_zmwjf4;

    /**
     * Язык оригинала
     */
    @ApiFormField(nameField = "cmp-55njih",typeField = "textbox")
    private String fcmp_55njih;

    /**
     * Страна публикации
     */
    @ApiFormField(nameField = "cmp-1m6no1",typeField = "textbox")
    private String fcmp_1m6no1;

    /**
     * Кодированные данные о книге
     */
    @ApiFormField(nameField = "cmp-b2xa27",typeField = "textbox")
    private String fcmp_b2xa27;

    /**
     * Коды иллюстраций
     */
    @ApiFormField(nameField = "cmp-1yd286",typeField = "textbox")
    private String fcmp_1yd286;

    /**
     * Коды формы содержания
     */
    @ApiFormField(nameField = "cmp-9t8svd",typeField = "textbox")
    private String fcmp_9t8svd;

    /**
     * Код конференции или совещания
     */
    @ApiFormField(nameField = "cmp-9isal0",typeField = "textbox")
    private String fcmp_9isal0;

    /**
     * Индикатор юбилейного издания
     */
    @ApiFormField(nameField = "cmp-qgcbp7",typeField = "textbox")
    private String fcmp_qgcbp7;

    /**
     * Индикатор указателя
     */
    @ApiFormField(nameField = "cmp-41syr8",typeField = "textbox")
    private String fcmp_41syr8;

    /**
     * Код литературного жанра
     */
    @ApiFormField(nameField = "cmp-dmjx3v",typeField = "textbox")
    private String fcmp_dmjx3v;

    /**
     * Код биографии
     */
    @ApiFormField(nameField = "cmp-sov3uf",typeField = "textbox")
    private String fcmp_sov3uf;

    /**
     * Кодированные данные сериального издания
     */
    @ApiFormField(nameField = "cmp-oa6frl",typeField = "textbox")
    private String fcmp_oa6frl;

    /**
     * Определитель типа сериального издания
     */
    @ApiFormField(nameField = "cmp-3nc17b",typeField = "textbox")
    private String fcmp_3nc17b;

    /**
     * Периодичность издания
     */
    @ApiFormField(nameField = "cmp-bnanu7",typeField = "textbox")
    private String fcmp_bnanu7;

    /**
     * Регулярность
     */
    @ApiFormField(nameField = "cmp-krwyo0",typeField = "textbox")
    private String fcmp_krwyo0;

    /**
     * Код вида материала
     */
    @ApiFormField(nameField = "cmp-7kimft",typeField = "textbox")
    private String fcmp_7kimft;

    /**
     * Код типа содержания
     */
    @ApiFormField(nameField = "cmp-pcmsp3",typeField = "textbox")
    private String fcmp_pcmsp3;

    /**
     * Индикатор материалов конференции
     */
    @ApiFormField(nameField = "cmp-oeua6l",typeField = "textbox")
    private String fcmp_oeua6l;

    /**
     * Код наличия титульного листа
     */
    @ApiFormField(nameField = "cmp-el2m8g",typeField = "textbox")
    private String fcmp_el2m8g;

    /**
     * Код наличия указателя
     */
    @ApiFormField(nameField = "cmp-j5rtst",typeField = "textbox")
    private String fcmp_j5rtst;

    /**
     * Код наличия кумулятивного указателя
     */
    @ApiFormField(nameField = "cmp-v3a2jt",typeField = "textbox")
    private String fcmp_v3a2jt;

    /**
     * Основное заглавие произведения другого автора
     */
    @ApiFormField(nameField = "cmp-tc6yjv",typeField = "textbox")
    private String fcmp_tc6yjv;

    /**
     * Последующие сведения об ответственности
     */
    @ApiFormField(nameField = "cmp-m2rf35",typeField = "textbox")
    private String fcmp_m2rf35;

    /**
     * Обозначение тома
     */
    @ApiFormField(nameField = "200v",typeField = "textbox")
    private String f200v;

    /**
     * Дополнительные сведения об издании
     */
    @ApiFormField(nameField = "205sfgsfgk",typeField = "textbox")
    private String f205sfgsfgk;

    /**
     * Сведения об ответственности,  относящиеся к изданию
     */
    @ApiFormField(nameField = "205f",typeField = "textbox")
    private String f205f;

    /**
     * Источник информации о нумерации
     */
    @ApiFormField(nameField = "cmp-o3ga4m",typeField = "textbox")
    private String fcmp_o3ga4m;

    /**
     * Размеры
     */
    @ApiFormField(nameField = "215d",typeField = "textbox")
    private String f215d;

    /**
     * Параллельное заглавие серии
     */
    @ApiFormField(nameField = "cmp-y1iiu1",typeField = "textbox")
    private String fcmp_y1iiu1;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "225e",typeField = "textbox")
    private String f225e;

    /**
     * Сведения об ответственности
     */
    @ApiFormField(nameField = "225f",typeField = "textbox")
    private String f225f;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "cmp-h3hq1g",typeField = "textbox")
    private String fcmp_h3hq1g;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "cmp-6ifobu",typeField = "textbox")
    private String fcmp_6ifobu;

    /**
     * Язык параллельного заглавия
     */
    @ApiFormField(nameField = "cmp-bd51jt",typeField = "textbox")
    private String fcmp_bd51jt;

    /**
     * Обозначение тома
     */
    @ApiFormField(nameField = "cmp-q1dd1v",typeField = "textbox")
    private String fcmp_q1dd1v;

    /**
     * ISSN серии
     */
    @ApiFormField(nameField = "225x",typeField = "textbox")
    private String f225x;

    /**
     * Периодичность
     */
    @ApiFormField(nameField = "cmp-505a02",typeField = "textbox")
    private String fcmp_505a02;

    /**
     * Даты периодичности
     */
    @ApiFormField(nameField = "cmp-ceyoio",typeField = "textbox")
    private String fcmp_ceyoio;

    /**
     * Текст примечания
     */
    @ApiFormField(nameField = "330a",typeField = "textbox")
    private String f330a;

    /**
     * 410 СЕРИЯ
     */
    @ApiFormField(nameField = "cmp-80g8dy",typeField = "textbox")
    private String fcmp_80g8dy;

    /**
     * 411 ПОДСЕРИЯ
     */
    @ApiFormField(nameField = "411",typeField = "textbox")
    private String f411;

    /**
     * 421 ПРИЛОЖЕНИЕ
     */
    @ApiFormField(nameField = "cmp-cmkm8l",typeField = "textbox")
    private String fcmp_cmkm8l;

    /**
     * 422 ИЗДАНИЕ, К КОТОРОМУ ОТНОСИТСЯ ПРИЛОЖЕНИЕ
     */
    @ApiFormField(nameField = "cmp-6dk42u",typeField = "textbox")
    private String fcmp_6dk42u;

    /**
     * 453 ПЕРЕВОД
     */
    @ApiFormField(nameField = "cmp-4q7bt8",typeField = "textbox")
    private String fcmp_4q7bt8;

    /**
     * 454 ОРИГИНАЛ
     */
    @ApiFormField(nameField = "cmp-o3c8o3",typeField = "textbox")
    private String fcmp_o3c8o3;

    /**
     * 461 УРОВЕНЬ НАБОРА
     */
    @ApiFormField(nameField = "cmp-s0ay8t",typeField = "textbox")
    private String fcmp_s0ay8t;

    /**
     * Данные связываемой записи
     */
    @ApiFormField(nameField = "cmp-k2c8mc",typeField = "textbox")
    private String fcmp_k2c8mc;

    /**
     * Параллельное заглавие
     */
    @ApiFormField(nameField = "cmp-jd2s86",typeField = "textbox")
    private String fcmp_jd2s86;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "cmp-wkocwv",typeField = "textbox")
    private String fcmp_wkocwv;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "cmp-sevakw",typeField = "textbox")
    private String fcmp_sevakw;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "cmp-vgpgyw",typeField = "textbox")
    private String fcmp_vgpgyw;

    /**
     * Язык заглавия
     */
    @ApiFormField(nameField = "cmp-id5s7p",typeField = "textbox")
    private String fcmp_id5s7p;

    /**
     * Заглавие обложки
     */
    @ApiFormField(nameField = "cmp-78isiw",typeField = "textbox")
    private String fcmp_78isiw;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "cmp-fsryh2",typeField = "textbox")
    private String fcmp_fsryh2;

    /**
     * Прежнее основное заглавие
     */
    @ApiFormField(nameField = "cmp-7prgul",typeField = "textbox")
    private String fcmp_7prgul;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "cmp-pkch5i",typeField = "textbox")
    private String fcmp_pkch5i;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "cmp-nfggxu",typeField = "textbox")
    private String fcmp_nfggxu;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "cmp-orr5va",typeField = "textbox")
    private String fcmp_orr5va;

    /**
     * Тома или даты выхода документа под прежним заглавием
     */
    @ApiFormField(nameField = "cmp-gbkw6y",typeField = "textbox")
    private String fcmp_gbkw6y;

    /**
     * ISSN прежнего заглавия
     */
    @ApiFormField(nameField = "cmp-2e4djs",typeField = "textbox")
    private String fcmp_2e4djs;

    /**
     * Ключевое заглавие
     */
    @ApiFormField(nameField = "cmp-c63clf",typeField = "textbox")
    private String fcmp_c63clf;

    /**
     * Уточнение
     */
    @ApiFormField(nameField = "cmp-wfenvg",typeField = "textbox")
    private String fcmp_wfenvg;

    /**
     * Перевод заглавия
     */
    @ApiFormField(nameField = "cmp-v9cvxg",typeField = "textbox")
    private String fcmp_v9cvxg;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "cmp-r47ddd",typeField = "textbox")
    private String fcmp_r47ddd;

    /**
     * Заглавие части
     */
    @ApiFormField(nameField = "cmp-fbw8yl",typeField = "textbox")
    private String fcmp_fbw8yl;

    /**
     * Язык перевода заглавия
     */
    @ApiFormField(nameField = "cmp-z8onot",typeField = "textbox")
    private String fcmp_z8onot;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-obue2m",typeField = "textbox")
    private String fcmp_obue2m;

    /**
     * Часть имени, отличная от начального элемента ввода
     */
    @ApiFormField(nameField = "cmp-jiuuyd",typeField = "textbox")
    private String fcmp_jiuuyd;

    /**
     * Дополнения к имени
     */
    @ApiFormField(nameField = "cmp-3j845c",typeField = "textbox")
    private String fcmp_3j845c;

    /**
     * Даты
     */
    @ApiFormField(nameField = "cmp-48s1hp",typeField = "textbox")
    private String fcmp_48s1hp;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "cmp-l2tlwo",typeField = "textbox")
    private String fcmp_l2tlwo;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-0riekw",typeField = "textbox")
    private String fcmp_0riekw;

    /**
     * Структурное подразделение
     */
    @ApiFormField(nameField = "cmp-yu795n",typeField = "textbox")
    private String fcmp_yu795n;

    /**
     * Дополнение к наименованию организации или уточнения
     */
    @ApiFormField(nameField = "cmp-ioso08",typeField = "textbox")
    private String fcmp_ioso08;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "cmp-chilh7",typeField = "textbox")
    private String fcmp_chilh7;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "cmp-3ntduj",typeField = "textbox")
    private String fcmp_3ntduj;

    /**
     * Дата проведения совещания
     */
    @ApiFormField(nameField = "cmp-jwv4hk",typeField = "textbox")
    private String fcmp_jwv4hk;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "cmp-nn7p92",typeField = "textbox")
    private String fcmp_nn7p92;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "cmp-aucr0w",typeField = "textbox")
    private String fcmp_aucr0w;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "cmp-yjkgyj",typeField = "textbox")
    private String fcmp_yjkgyj;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-si8n4a",typeField = "textbox")
    private String fcmp_si8n4a;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "cmp-4ts4dx",typeField = "textbox")
    private String fcmp_4ts4dx;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "cmp-ctryeb",typeField = "textbox")
    private String fcmp_ctryeb;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "cmp-gajp9c",typeField = "textbox")
    private String fcmp_gajp9c;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "cmp-yixkyu",typeField = "textbox")
    private String fcmp_yixkyu;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "cmp-2puodq",typeField = "textbox")
    private String fcmp_2puodq;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "cmp-num7gz",typeField = "textbox")
    private String fcmp_num7gz;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-7jziez",typeField = "textbox")
    private String fcmp_7jziez;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "cmp-3e9lq0",typeField = "textbox")
    private String fcmp_3e9lq0;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "cmp-kh3lsl",typeField = "textbox")
    private String fcmp_kh3lsl;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "cmp-9c7tzl",typeField = "textbox")
    private String fcmp_9c7tzl;

    /**
     * Издание
     */
    @ApiFormField(nameField = "cmp-2joh9k",typeField = "textbox")
    private String fcmp_2joh9k;

    /**
     * Язык издания
     */
    @ApiFormField(nameField = "cmp-y93ups",typeField = "textbox")
    private String fcmp_y93ups;

    /**
     * Индекс классификации
     */
    @ApiFormField(nameField = "686a",typeField = "textbox")
    private String f686a;

    /**
     * Книжный номер
     */
    @ApiFormField(nameField = "cmp-goivbk",typeField = "textbox")
    private String fcmp_goivbk;

    /**
     * Классификационная подрубрика
     */
    @ApiFormField(nameField = "cmp-wudvif",typeField = "textbox")
    private String fcmp_wudvif;

    /**
     * Код системы
     */
    @ApiFormField(nameField = "cmp-wz7irn",typeField = "textbox")
    private String fcmp_wz7irn;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "cmp-9t9dby",typeField = "textbox")
    private String fcmp_9t9dby;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "cmp-rghp7h",typeField = "textbox")
    private String fcmp_rghp7h;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "cmp-1jjlw8",typeField = "textbox")
    private String fcmp_1jjlw8;

    /**
     * Даты
     */
    @ApiFormField(nameField = "700f",typeField = "textbox")
    private String f700f;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "cmp-6fntbc",typeField = "textbox")
    private String fcmp_6fntbc;

    /**
     * Место работы/адрес
     */
    @ApiFormField(nameField = "700p",typeField = "textbox")
    private String f700p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7003",typeField = "textbox")
    private String f7003;

    /**
     * Код отношений
     */
    @ApiFormField(nameField = "cmp-jmx7so",typeField = "textbox")
    private String fcmp_jmx7so;

    /**
     * Начальный элемент ввода (Фамилия)
     */
    @ApiFormField(nameField = "cmp-3jipa9",typeField = "textbox")
    private String fcmp_3jipa9;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "701b",typeField = "textbox")
    private String f701b;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "cmp-toq7w4",typeField = "textbox")
    private String fcmp_toq7w4;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "cmp-lcj4dd",typeField = "textbox")
    private String fcmp_lcj4dd;

    /**
     * Даты
     */
    @ApiFormField(nameField = "701f",typeField = "textbox")
    private String f701f;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "cmp-bpm7o8",typeField = "textbox")
    private String fcmp_bpm7o8;

    /**
     * Место работы/адрес
     */
    @ApiFormField(nameField = "cmp-4ygna4",typeField = "textbox")
    private String fcmp_4ygna4;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7013",typeField = "textbox")
    private String f7013;

    /**
     * Код отношений
     */
    @ApiFormField(nameField = "cmp-u3i9al",typeField = "textbox")
    private String fcmp_u3i9al;

    /**
     * Начальный элемент ввода (Фамилия)
     */
    @ApiFormField(nameField = "cmp-jcyhz3",typeField = "textbox")
    private String fcmp_jcyhz3;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "cmp-tn35dc",typeField = "textbox")
    private String fcmp_tn35dc;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "cmp-e44po5",typeField = "textbox")
    private String fcmp_e44po5;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "cmp-lpeu86",typeField = "textbox")
    private String fcmp_lpeu86;

    /**
     * Даты
     */
    @ApiFormField(nameField = "cmp-7515ab",typeField = "textbox")
    private String fcmp_7515ab;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "cmp-9gog5t",typeField = "textbox")
    private String fcmp_9gog5t;

    /**
     * Место работы/адрес
     */
    @ApiFormField(nameField = "cmp-48xyin",typeField = "textbox")
    private String fcmp_48xyin;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "cmp-267n2z",typeField = "textbox")
    private String fcmp_267n2z;

    /**
     * Код отношений
     */
    @ApiFormField(nameField = "cmp-abkg6e",typeField = "textbox")
    private String fcmp_abkg6e;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-gsu5sp",typeField = "textbox")
    private String fcmp_gsu5sp;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "cmp-18wm4h",typeField = "textbox")
    private String fcmp_18wm4h;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "cmp-oex7h1",typeField = "textbox")
    private String fcmp_oex7h1;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "cmp-at9l93",typeField = "textbox")
    private String fcmp_at9l93;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "cmp-is3xn3",typeField = "textbox")
    private String fcmp_is3xn3;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "cmp-8dy2we",typeField = "textbox")
    private String fcmp_8dy2we;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "cmp-ka42ib",typeField = "textbox")
    private String fcmp_ka42ib;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "cmp-cpbxvv",typeField = "textbox")
    private String fcmp_cpbxvv;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "cmp-i9kssw",typeField = "textbox")
    private String fcmp_i9kssw;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "cmp-hidbhu",typeField = "textbox")
    private String fcmp_hidbhu;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-hmsw3x",typeField = "textbox")
    private String fcmp_hmsw3x;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "cmp-ke5q5n",typeField = "textbox")
    private String fcmp_ke5q5n;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "cmp-5uoxxb",typeField = "textbox")
    private String fcmp_5uoxxb;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "cmp-yr55hh",typeField = "textbox")
    private String fcmp_yr55hh;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "cmp-3e77q3",typeField = "textbox")
    private String fcmp_3e77q3;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "cmp-t7my6n",typeField = "textbox")
    private String fcmp_t7my6n;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "cmp-3yf6dn",typeField = "textbox")
    private String fcmp_3yf6dn;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "cmp-n7mu55",typeField = "textbox")
    private String fcmp_n7mu55;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "cmp-a09ea7",typeField = "textbox")
    private String fcmp_a09ea7;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "cmp-mqi9lf",typeField = "textbox")
    private String fcmp_mqi9lf;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "cmp-vbcmrb",typeField = "textbox")
    private String fcmp_vbcmrb;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "cmp-asnq3o",typeField = "textbox")
    private String fcmp_asnq3o;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "cmp-bbtzcb",typeField = "textbox")
    private String fcmp_bbtzcb;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "cmp-pxihly",typeField = "textbox")
    private String fcmp_pxihly;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "cmp-fnv0zo",typeField = "textbox")
    private String fcmp_fnv0zo;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "cmp-1k2pra",typeField = "textbox")
    private String fcmp_1k2pra;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "cmp-zjc5bd",typeField = "textbox")
    private String fcmp_zjc5bd;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "cmp-e849ad",typeField = "textbox")
    private String fcmp_e849ad;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "cmp-5h9v6b",typeField = "textbox")
    private String fcmp_5h9v6b;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "cmp-j8wyw2",typeField = "textbox")
    private String fcmp_j8wyw2;

    /**
     * Страна
     */
    @ApiFormField(nameField = "cmp-r56s00",typeField = "textbox")
    private String fcmp_r56s00;

    /**
     * Агентство
     */
    @ApiFormField(nameField = "cmp-hkvapz",typeField = "textbox")
    private String fcmp_hkvapz;

    /**
     * Дата составления
     */
    @ApiFormField(nameField = "cmp-6y932b",typeField = "textbox")
    private String fcmp_6y932b;

    /**
     * Сигла библиотеки
     */
    @ApiFormField(nameField = "901a",typeField = "listbox")
    private KeyObject f901a;

    /**
     * Штрих-код документа
     */
    @ApiFormField(nameField = "9016",typeField = "textbox")
    private String f9016;

    /**
     * Тематический рубрика
     */
    @ApiFormField(nameField = "cmp-5iri6j",typeField = "textbox")
    private String fcmp_5iri6j;

    /**
     * Факультет
     */
    @ApiFormField(nameField = "910a",typeField = "textbox")
    private String f910a;

    /**
     * Кафедра
     */
    @ApiFormField(nameField = "910b",typeField = "textbox")
    private String f910b;

    /**
     * Курс
     */
    @ApiFormField(nameField = "910d",typeField = "textbox")
    private String f910d;

    /**
     * Дисциплина
     */
    @ApiFormField(nameField = "911a",typeField = "textbox")
    private String f911a;

    /**
     * Номер гос.регистрации
     */
    @ApiFormField(nameField = "912a",typeField = "textbox")
    private String f912a;

    public String getF320a() {
        return f320a;
    }

    public void setF320a(String f320a) {
        this.f320a = f320a;
    }

    public String getF610a() {
        return f610a;
    }

    public void setF610a(String f610a) {
        this.f610a = f610a;
    }

    public String getF700a() {
        return f700a;
    }

    public void setF700a(String f700a) {
        this.f700a = f700a;
    }

    public String getF010a() {
        return f010a;
    }

    public void setF010a(String f010a) {
        this.f010a = f010a;
    }

    public String getF010d() {
        return f010d;
    }

    public void setF010d(String f010d) {
        this.f010d = f010d;
    }

    public KeyObject getF101a() {
        return f101a;
    }

    public void setF101a(KeyObject f101a) {
        this.f101a = f101a;
    }

    public String getF200a() {
        return f200a;
    }

    public void setF200a(String f200a) {
        this.f200a = f200a;
    }

    public KeyObject getF200b() {
        return f200b;
    }

    public void setF200b(KeyObject f200b) {
        this.f200b = f200b;
    }

    public String getF200d() {
        return f200d;
    }

    public void setF200d(String f200d) {
        this.f200d = f200d;
    }

    public String getF200e() {
        return f200e;
    }

    public void setF200e(String f200e) {
        this.f200e = f200e;
    }

    public String getF200f() {
        return f200f;
    }

    public void setF200f(String f200f) {
        this.f200f = f200f;
    }

    public String getF200h() {
        return f200h;
    }

    public void setF200h(String f200h) {
        this.f200h = f200h;
    }

    public String getF200i() {
        return f200i;
    }

    public void setF200i(String f200i) {
        this.f200i = f200i;
    }

    public String getF200z() {
        return f200z;
    }

    public void setF200z(String f200z) {
        this.f200z = f200z;
    }

    public String getF205a() {
        return f205a;
    }

    public void setF205a(String f205a) {
        this.f205a = f205a;
    }

    public String getF207a() {
        return f207a;
    }

    public void setF207a(String f207a) {
        this.f207a = f207a;
    }

    public String getF210a() {
        return f210a;
    }

    public void setF210a(String f210a) {
        this.f210a = f210a;
    }

    public String getF210c() {
        return f210c;
    }

    public void setF210c(String f210c) {
        this.f210c = f210c;
    }

    public String getF210d() {
        return f210d;
    }

    public void setF210d(String f210d) {
        this.f210d = f210d;
    }

    public String getF215a() {
        return f215a;
    }

    public void setF215a(String f215a) {
        this.f215a = f215a;
    }

    public String getF215c() {
        return f215c;
    }

    public void setF215c(String f215c) {
        this.f215c = f215c;
    }

    public String getF215e() {
        return f215e;
    }

    public void setF215e(String f215e) {
        this.f215e = f215e;
    }

    public String getF225a() {
        return f225a;
    }

    public void setF225a(String f225a) {
        this.f225a = f225a;
    }

    public String getF230a() {
        return f230a;
    }

    public void setF230a(String f230a) {
        this.f230a = f230a;
    }

    public String getF300a() {
        return f300a;
    }

    public void setF300a(String f300a) {
        this.f300a = f300a;
    }

    public String getF327a() {
        return f327a;
    }

    public void setF327a(String f327a) {
        this.f327a = f327a;
    }

    public String getF541e() {
        return f541e;
    }

    public void setF541e(String f541e) {
        this.f541e = f541e;
    }

    public String getF545a() {
        return f545a;
    }

    public void setF545a(String f545a) {
        this.f545a = f545a;
    }

    public String getF907a() {
        return f907a;
    }

    public void setF907a(String f907a) {
        this.f907a = f907a;
    }

    public String getF675a() {
        return f675a;
    }

    public void setF675a(String f675a) {
        this.f675a = f675a;
    }

    public String getF907b() {
        return f907b;
    }

    public void setF907b(String f907b) {
        this.f907b = f907b;
    }

    public String getF856t() {
        return f856t;
    }

    public void setF856t(String f856t) {
        this.f856t = f856t;
    }

    public String getF8562() {
        return f8562;
    }

    public void setF8562(String f8562) {
        this.f8562 = f8562;
    }

    public String getF901b() {
        return f901b;
    }

    public void setF901b(String f901b) {
        this.f901b = f901b;
    }

    public KeyObject getF9015() {
        return f9015;
    }

    public void setF9015(KeyObject f9015) {
        this.f9015 = f9015;
    }

    public String getF908a() {
        return f908a;
    }

    public void setF908a(String f908a) {
        this.f908a = f908a;
    }

    public KeyObject getF908b() {
        return f908b;
    }

    public void setF908b(KeyObject f908b) {
        this.f908b = f908b;
    }

    public KeyObject getF908c() {
        return f908c;
    }

    public void setF908c(KeyObject f908c) {
        this.f908c = f908c;
    }

    public KeyObject getF910c() {
        return f910c;
    }

    public void setF910c(KeyObject f910c) {
        this.f910c = f910c;
    }

    public String getFcmp_hqzf4n() {
        return fcmp_hqzf4n;
    }

    public void setFcmp_hqzf4n(String fcmp_hqzf4n) {
        this.fcmp_hqzf4n = fcmp_hqzf4n;
    }

    public String getFidksdh() {
        return fidksdh;
    }

    public void setFidksdh(String fidksdh) {
        this.fidksdh = fidksdh;
    }

    public String getFcmp_phl5wf() {
        return fcmp_phl5wf;
    }

    public void setFcmp_phl5wf(String fcmp_phl5wf) {
        this.fcmp_phl5wf = fcmp_phl5wf;
    }

    public String getFcmp_pl7j0m() {
        return fcmp_pl7j0m;
    }

    public void setFcmp_pl7j0m(String fcmp_pl7j0m) {
        this.fcmp_pl7j0m = fcmp_pl7j0m;
    }

    public String getFcmp_gxvuqk() {
        return fcmp_gxvuqk;
    }

    public void setFcmp_gxvuqk(String fcmp_gxvuqk) {
        this.fcmp_gxvuqk = fcmp_gxvuqk;
    }

    public String getFcmp_7ryuow() {
        return fcmp_7ryuow;
    }

    public void setFcmp_7ryuow(String fcmp_7ryuow) {
        this.fcmp_7ryuow = fcmp_7ryuow;
    }

    public String getFcmp_3h8iil() {
        return fcmp_3h8iil;
    }

    public void setFcmp_3h8iil(String fcmp_3h8iil) {
        this.fcmp_3h8iil = fcmp_3h8iil;
    }

    public String getFcmp_u8yl9a() {
        return fcmp_u8yl9a;
    }

    public void setFcmp_u8yl9a(String fcmp_u8yl9a) {
        this.fcmp_u8yl9a = fcmp_u8yl9a;
    }

    public String getFcmp_5grpy9() {
        return fcmp_5grpy9;
    }

    public void setFcmp_5grpy9(String fcmp_5grpy9) {
        this.fcmp_5grpy9 = fcmp_5grpy9;
    }

    public String getFcmp_kaxb3b() {
        return fcmp_kaxb3b;
    }

    public void setFcmp_kaxb3b(String fcmp_kaxb3b) {
        this.fcmp_kaxb3b = fcmp_kaxb3b;
    }

    public String getFcmp_0rjfra() {
        return fcmp_0rjfra;
    }

    public void setFcmp_0rjfra(String fcmp_0rjfra) {
        this.fcmp_0rjfra = fcmp_0rjfra;
    }

    public String getFcmp_hv1kyr() {
        return fcmp_hv1kyr;
    }

    public void setFcmp_hv1kyr(String fcmp_hv1kyr) {
        this.fcmp_hv1kyr = fcmp_hv1kyr;
    }

    public String getFcmp_qb5k3a() {
        return fcmp_qb5k3a;
    }

    public void setFcmp_qb5k3a(String fcmp_qb5k3a) {
        this.fcmp_qb5k3a = fcmp_qb5k3a;
    }

    public String getFcmp_dm9yst() {
        return fcmp_dm9yst;
    }

    public void setFcmp_dm9yst(String fcmp_dm9yst) {
        this.fcmp_dm9yst = fcmp_dm9yst;
    }

    public String getFcmp_rcgb3o() {
        return fcmp_rcgb3o;
    }

    public void setFcmp_rcgb3o(String fcmp_rcgb3o) {
        this.fcmp_rcgb3o = fcmp_rcgb3o;
    }

    public String getFcmp_1nagv7() {
        return fcmp_1nagv7;
    }

    public void setFcmp_1nagv7(String fcmp_1nagv7) {
        this.fcmp_1nagv7 = fcmp_1nagv7;
    }

    public String getFcmp_q44ozp() {
        return fcmp_q44ozp;
    }

    public void setFcmp_q44ozp(String fcmp_q44ozp) {
        this.fcmp_q44ozp = fcmp_q44ozp;
    }

    public String getFcmp_vj51eb() {
        return fcmp_vj51eb;
    }

    public void setFcmp_vj51eb(String fcmp_vj51eb) {
        this.fcmp_vj51eb = fcmp_vj51eb;
    }

    public String getFcmp_xyq4ic() {
        return fcmp_xyq4ic;
    }

    public void setFcmp_xyq4ic(String fcmp_xyq4ic) {
        this.fcmp_xyq4ic = fcmp_xyq4ic;
    }

    public String getFcmp_gzp554() {
        return fcmp_gzp554;
    }

    public void setFcmp_gzp554(String fcmp_gzp554) {
        this.fcmp_gzp554 = fcmp_gzp554;
    }

    public String getFcmp_u42mya() {
        return fcmp_u42mya;
    }

    public void setFcmp_u42mya(String fcmp_u42mya) {
        this.fcmp_u42mya = fcmp_u42mya;
    }

    public String getFcmp_ayqko3() {
        return fcmp_ayqko3;
    }

    public void setFcmp_ayqko3(String fcmp_ayqko3) {
        this.fcmp_ayqko3 = fcmp_ayqko3;
    }

    public String getFcmp_jikk5o() {
        return fcmp_jikk5o;
    }

    public void setFcmp_jikk5o(String fcmp_jikk5o) {
        this.fcmp_jikk5o = fcmp_jikk5o;
    }

    public String getFcmp_tjky1y() {
        return fcmp_tjky1y;
    }

    public void setFcmp_tjky1y(String fcmp_tjky1y) {
        this.fcmp_tjky1y = fcmp_tjky1y;
    }

    public String getFcmp_flci2k() {
        return fcmp_flci2k;
    }

    public void setFcmp_flci2k(String fcmp_flci2k) {
        this.fcmp_flci2k = fcmp_flci2k;
    }

    public String getFcmp_zmwjf4() {
        return fcmp_zmwjf4;
    }

    public void setFcmp_zmwjf4(String fcmp_zmwjf4) {
        this.fcmp_zmwjf4 = fcmp_zmwjf4;
    }

    public String getFcmp_55njih() {
        return fcmp_55njih;
    }

    public void setFcmp_55njih(String fcmp_55njih) {
        this.fcmp_55njih = fcmp_55njih;
    }

    public String getFcmp_1m6no1() {
        return fcmp_1m6no1;
    }

    public void setFcmp_1m6no1(String fcmp_1m6no1) {
        this.fcmp_1m6no1 = fcmp_1m6no1;
    }

    public String getFcmp_b2xa27() {
        return fcmp_b2xa27;
    }

    public void setFcmp_b2xa27(String fcmp_b2xa27) {
        this.fcmp_b2xa27 = fcmp_b2xa27;
    }

    public String getFcmp_1yd286() {
        return fcmp_1yd286;
    }

    public void setFcmp_1yd286(String fcmp_1yd286) {
        this.fcmp_1yd286 = fcmp_1yd286;
    }

    public String getFcmp_9t8svd() {
        return fcmp_9t8svd;
    }

    public void setFcmp_9t8svd(String fcmp_9t8svd) {
        this.fcmp_9t8svd = fcmp_9t8svd;
    }

    public String getFcmp_9isal0() {
        return fcmp_9isal0;
    }

    public void setFcmp_9isal0(String fcmp_9isal0) {
        this.fcmp_9isal0 = fcmp_9isal0;
    }

    public String getFcmp_qgcbp7() {
        return fcmp_qgcbp7;
    }

    public void setFcmp_qgcbp7(String fcmp_qgcbp7) {
        this.fcmp_qgcbp7 = fcmp_qgcbp7;
    }

    public String getFcmp_41syr8() {
        return fcmp_41syr8;
    }

    public void setFcmp_41syr8(String fcmp_41syr8) {
        this.fcmp_41syr8 = fcmp_41syr8;
    }

    public String getFcmp_dmjx3v() {
        return fcmp_dmjx3v;
    }

    public void setFcmp_dmjx3v(String fcmp_dmjx3v) {
        this.fcmp_dmjx3v = fcmp_dmjx3v;
    }

    public String getFcmp_sov3uf() {
        return fcmp_sov3uf;
    }

    public void setFcmp_sov3uf(String fcmp_sov3uf) {
        this.fcmp_sov3uf = fcmp_sov3uf;
    }

    public String getFcmp_oa6frl() {
        return fcmp_oa6frl;
    }

    public void setFcmp_oa6frl(String fcmp_oa6frl) {
        this.fcmp_oa6frl = fcmp_oa6frl;
    }

    public String getFcmp_3nc17b() {
        return fcmp_3nc17b;
    }

    public void setFcmp_3nc17b(String fcmp_3nc17b) {
        this.fcmp_3nc17b = fcmp_3nc17b;
    }

    public String getFcmp_bnanu7() {
        return fcmp_bnanu7;
    }

    public void setFcmp_bnanu7(String fcmp_bnanu7) {
        this.fcmp_bnanu7 = fcmp_bnanu7;
    }

    public String getFcmp_krwyo0() {
        return fcmp_krwyo0;
    }

    public void setFcmp_krwyo0(String fcmp_krwyo0) {
        this.fcmp_krwyo0 = fcmp_krwyo0;
    }

    public String getFcmp_7kimft() {
        return fcmp_7kimft;
    }

    public void setFcmp_7kimft(String fcmp_7kimft) {
        this.fcmp_7kimft = fcmp_7kimft;
    }

    public String getFcmp_pcmsp3() {
        return fcmp_pcmsp3;
    }

    public void setFcmp_pcmsp3(String fcmp_pcmsp3) {
        this.fcmp_pcmsp3 = fcmp_pcmsp3;
    }

    public String getFcmp_oeua6l() {
        return fcmp_oeua6l;
    }

    public void setFcmp_oeua6l(String fcmp_oeua6l) {
        this.fcmp_oeua6l = fcmp_oeua6l;
    }

    public String getFcmp_el2m8g() {
        return fcmp_el2m8g;
    }

    public void setFcmp_el2m8g(String fcmp_el2m8g) {
        this.fcmp_el2m8g = fcmp_el2m8g;
    }

    public String getFcmp_j5rtst() {
        return fcmp_j5rtst;
    }

    public void setFcmp_j5rtst(String fcmp_j5rtst) {
        this.fcmp_j5rtst = fcmp_j5rtst;
    }

    public String getFcmp_v3a2jt() {
        return fcmp_v3a2jt;
    }

    public void setFcmp_v3a2jt(String fcmp_v3a2jt) {
        this.fcmp_v3a2jt = fcmp_v3a2jt;
    }

    public String getFcmp_tc6yjv() {
        return fcmp_tc6yjv;
    }

    public void setFcmp_tc6yjv(String fcmp_tc6yjv) {
        this.fcmp_tc6yjv = fcmp_tc6yjv;
    }

    public String getFcmp_m2rf35() {
        return fcmp_m2rf35;
    }

    public void setFcmp_m2rf35(String fcmp_m2rf35) {
        this.fcmp_m2rf35 = fcmp_m2rf35;
    }

    public String getF200v() {
        return f200v;
    }

    public void setF200v(String f200v) {
        this.f200v = f200v;
    }

    public String getF205sfgsfgk() {
        return f205sfgsfgk;
    }

    public void setF205sfgsfgk(String f205sfgsfgk) {
        this.f205sfgsfgk = f205sfgsfgk;
    }

    public String getF205f() {
        return f205f;
    }

    public void setF205f(String f205f) {
        this.f205f = f205f;
    }

    public String getFcmp_o3ga4m() {
        return fcmp_o3ga4m;
    }

    public void setFcmp_o3ga4m(String fcmp_o3ga4m) {
        this.fcmp_o3ga4m = fcmp_o3ga4m;
    }

    public String getF215d() {
        return f215d;
    }

    public void setF215d(String f215d) {
        this.f215d = f215d;
    }

    public String getFcmp_y1iiu1() {
        return fcmp_y1iiu1;
    }

    public void setFcmp_y1iiu1(String fcmp_y1iiu1) {
        this.fcmp_y1iiu1 = fcmp_y1iiu1;
    }

    public String getF225e() {
        return f225e;
    }

    public void setF225e(String f225e) {
        this.f225e = f225e;
    }

    public String getF225f() {
        return f225f;
    }

    public void setF225f(String f225f) {
        this.f225f = f225f;
    }

    public String getFcmp_h3hq1g() {
        return fcmp_h3hq1g;
    }

    public void setFcmp_h3hq1g(String fcmp_h3hq1g) {
        this.fcmp_h3hq1g = fcmp_h3hq1g;
    }

    public String getFcmp_6ifobu() {
        return fcmp_6ifobu;
    }

    public void setFcmp_6ifobu(String fcmp_6ifobu) {
        this.fcmp_6ifobu = fcmp_6ifobu;
    }

    public String getFcmp_bd51jt() {
        return fcmp_bd51jt;
    }

    public void setFcmp_bd51jt(String fcmp_bd51jt) {
        this.fcmp_bd51jt = fcmp_bd51jt;
    }

    public String getFcmp_q1dd1v() {
        return fcmp_q1dd1v;
    }

    public void setFcmp_q1dd1v(String fcmp_q1dd1v) {
        this.fcmp_q1dd1v = fcmp_q1dd1v;
    }

    public String getF225x() {
        return f225x;
    }

    public void setF225x(String f225x) {
        this.f225x = f225x;
    }

    public String getFcmp_505a02() {
        return fcmp_505a02;
    }

    public void setFcmp_505a02(String fcmp_505a02) {
        this.fcmp_505a02 = fcmp_505a02;
    }

    public String getFcmp_ceyoio() {
        return fcmp_ceyoio;
    }

    public void setFcmp_ceyoio(String fcmp_ceyoio) {
        this.fcmp_ceyoio = fcmp_ceyoio;
    }

    public String getF330a() {
        return f330a;
    }

    public void setF330a(String f330a) {
        this.f330a = f330a;
    }

    public String getFcmp_80g8dy() {
        return fcmp_80g8dy;
    }

    public void setFcmp_80g8dy(String fcmp_80g8dy) {
        this.fcmp_80g8dy = fcmp_80g8dy;
    }

    public String getF411() {
        return f411;
    }

    public void setF411(String f411) {
        this.f411 = f411;
    }

    public String getFcmp_cmkm8l() {
        return fcmp_cmkm8l;
    }

    public void setFcmp_cmkm8l(String fcmp_cmkm8l) {
        this.fcmp_cmkm8l = fcmp_cmkm8l;
    }

    public String getFcmp_6dk42u() {
        return fcmp_6dk42u;
    }

    public void setFcmp_6dk42u(String fcmp_6dk42u) {
        this.fcmp_6dk42u = fcmp_6dk42u;
    }

    public String getFcmp_4q7bt8() {
        return fcmp_4q7bt8;
    }

    public void setFcmp_4q7bt8(String fcmp_4q7bt8) {
        this.fcmp_4q7bt8 = fcmp_4q7bt8;
    }

    public String getFcmp_o3c8o3() {
        return fcmp_o3c8o3;
    }

    public void setFcmp_o3c8o3(String fcmp_o3c8o3) {
        this.fcmp_o3c8o3 = fcmp_o3c8o3;
    }

    public String getFcmp_s0ay8t() {
        return fcmp_s0ay8t;
    }

    public void setFcmp_s0ay8t(String fcmp_s0ay8t) {
        this.fcmp_s0ay8t = fcmp_s0ay8t;
    }

    public String getFcmp_k2c8mc() {
        return fcmp_k2c8mc;
    }

    public void setFcmp_k2c8mc(String fcmp_k2c8mc) {
        this.fcmp_k2c8mc = fcmp_k2c8mc;
    }

    public String getFcmp_jd2s86() {
        return fcmp_jd2s86;
    }

    public void setFcmp_jd2s86(String fcmp_jd2s86) {
        this.fcmp_jd2s86 = fcmp_jd2s86;
    }

    public String getFcmp_wkocwv() {
        return fcmp_wkocwv;
    }

    public void setFcmp_wkocwv(String fcmp_wkocwv) {
        this.fcmp_wkocwv = fcmp_wkocwv;
    }

    public String getFcmp_sevakw() {
        return fcmp_sevakw;
    }

    public void setFcmp_sevakw(String fcmp_sevakw) {
        this.fcmp_sevakw = fcmp_sevakw;
    }

    public String getFcmp_vgpgyw() {
        return fcmp_vgpgyw;
    }

    public void setFcmp_vgpgyw(String fcmp_vgpgyw) {
        this.fcmp_vgpgyw = fcmp_vgpgyw;
    }

    public String getFcmp_id5s7p() {
        return fcmp_id5s7p;
    }

    public void setFcmp_id5s7p(String fcmp_id5s7p) {
        this.fcmp_id5s7p = fcmp_id5s7p;
    }

    public String getFcmp_78isiw() {
        return fcmp_78isiw;
    }

    public void setFcmp_78isiw(String fcmp_78isiw) {
        this.fcmp_78isiw = fcmp_78isiw;
    }

    public String getFcmp_fsryh2() {
        return fcmp_fsryh2;
    }

    public void setFcmp_fsryh2(String fcmp_fsryh2) {
        this.fcmp_fsryh2 = fcmp_fsryh2;
    }

    public String getFcmp_7prgul() {
        return fcmp_7prgul;
    }

    public void setFcmp_7prgul(String fcmp_7prgul) {
        this.fcmp_7prgul = fcmp_7prgul;
    }

    public String getFcmp_pkch5i() {
        return fcmp_pkch5i;
    }

    public void setFcmp_pkch5i(String fcmp_pkch5i) {
        this.fcmp_pkch5i = fcmp_pkch5i;
    }

    public String getFcmp_nfggxu() {
        return fcmp_nfggxu;
    }

    public void setFcmp_nfggxu(String fcmp_nfggxu) {
        this.fcmp_nfggxu = fcmp_nfggxu;
    }

    public String getFcmp_orr5va() {
        return fcmp_orr5va;
    }

    public void setFcmp_orr5va(String fcmp_orr5va) {
        this.fcmp_orr5va = fcmp_orr5va;
    }

    public String getFcmp_gbkw6y() {
        return fcmp_gbkw6y;
    }

    public void setFcmp_gbkw6y(String fcmp_gbkw6y) {
        this.fcmp_gbkw6y = fcmp_gbkw6y;
    }

    public String getFcmp_2e4djs() {
        return fcmp_2e4djs;
    }

    public void setFcmp_2e4djs(String fcmp_2e4djs) {
        this.fcmp_2e4djs = fcmp_2e4djs;
    }

    public String getFcmp_c63clf() {
        return fcmp_c63clf;
    }

    public void setFcmp_c63clf(String fcmp_c63clf) {
        this.fcmp_c63clf = fcmp_c63clf;
    }

    public String getFcmp_wfenvg() {
        return fcmp_wfenvg;
    }

    public void setFcmp_wfenvg(String fcmp_wfenvg) {
        this.fcmp_wfenvg = fcmp_wfenvg;
    }

    public String getFcmp_v9cvxg() {
        return fcmp_v9cvxg;
    }

    public void setFcmp_v9cvxg(String fcmp_v9cvxg) {
        this.fcmp_v9cvxg = fcmp_v9cvxg;
    }

    public String getFcmp_r47ddd() {
        return fcmp_r47ddd;
    }

    public void setFcmp_r47ddd(String fcmp_r47ddd) {
        this.fcmp_r47ddd = fcmp_r47ddd;
    }

    public String getFcmp_fbw8yl() {
        return fcmp_fbw8yl;
    }

    public void setFcmp_fbw8yl(String fcmp_fbw8yl) {
        this.fcmp_fbw8yl = fcmp_fbw8yl;
    }

    public String getFcmp_z8onot() {
        return fcmp_z8onot;
    }

    public void setFcmp_z8onot(String fcmp_z8onot) {
        this.fcmp_z8onot = fcmp_z8onot;
    }

    public String getFcmp_obue2m() {
        return fcmp_obue2m;
    }

    public void setFcmp_obue2m(String fcmp_obue2m) {
        this.fcmp_obue2m = fcmp_obue2m;
    }

    public String getFcmp_jiuuyd() {
        return fcmp_jiuuyd;
    }

    public void setFcmp_jiuuyd(String fcmp_jiuuyd) {
        this.fcmp_jiuuyd = fcmp_jiuuyd;
    }

    public String getFcmp_3j845c() {
        return fcmp_3j845c;
    }

    public void setFcmp_3j845c(String fcmp_3j845c) {
        this.fcmp_3j845c = fcmp_3j845c;
    }

    public String getFcmp_48s1hp() {
        return fcmp_48s1hp;
    }

    public void setFcmp_48s1hp(String fcmp_48s1hp) {
        this.fcmp_48s1hp = fcmp_48s1hp;
    }

    public String getFcmp_l2tlwo() {
        return fcmp_l2tlwo;
    }

    public void setFcmp_l2tlwo(String fcmp_l2tlwo) {
        this.fcmp_l2tlwo = fcmp_l2tlwo;
    }

    public String getFcmp_0riekw() {
        return fcmp_0riekw;
    }

    public void setFcmp_0riekw(String fcmp_0riekw) {
        this.fcmp_0riekw = fcmp_0riekw;
    }

    public String getFcmp_yu795n() {
        return fcmp_yu795n;
    }

    public void setFcmp_yu795n(String fcmp_yu795n) {
        this.fcmp_yu795n = fcmp_yu795n;
    }

    public String getFcmp_ioso08() {
        return fcmp_ioso08;
    }

    public void setFcmp_ioso08(String fcmp_ioso08) {
        this.fcmp_ioso08 = fcmp_ioso08;
    }

    public String getFcmp_chilh7() {
        return fcmp_chilh7;
    }

    public void setFcmp_chilh7(String fcmp_chilh7) {
        this.fcmp_chilh7 = fcmp_chilh7;
    }

    public String getFcmp_3ntduj() {
        return fcmp_3ntduj;
    }

    public void setFcmp_3ntduj(String fcmp_3ntduj) {
        this.fcmp_3ntduj = fcmp_3ntduj;
    }

    public String getFcmp_jwv4hk() {
        return fcmp_jwv4hk;
    }

    public void setFcmp_jwv4hk(String fcmp_jwv4hk) {
        this.fcmp_jwv4hk = fcmp_jwv4hk;
    }

    public String getFcmp_nn7p92() {
        return fcmp_nn7p92;
    }

    public void setFcmp_nn7p92(String fcmp_nn7p92) {
        this.fcmp_nn7p92 = fcmp_nn7p92;
    }

    public String getFcmp_aucr0w() {
        return fcmp_aucr0w;
    }

    public void setFcmp_aucr0w(String fcmp_aucr0w) {
        this.fcmp_aucr0w = fcmp_aucr0w;
    }

    public String getFcmp_yjkgyj() {
        return fcmp_yjkgyj;
    }

    public void setFcmp_yjkgyj(String fcmp_yjkgyj) {
        this.fcmp_yjkgyj = fcmp_yjkgyj;
    }

    public String getFcmp_si8n4a() {
        return fcmp_si8n4a;
    }

    public void setFcmp_si8n4a(String fcmp_si8n4a) {
        this.fcmp_si8n4a = fcmp_si8n4a;
    }

    public String getFcmp_4ts4dx() {
        return fcmp_4ts4dx;
    }

    public void setFcmp_4ts4dx(String fcmp_4ts4dx) {
        this.fcmp_4ts4dx = fcmp_4ts4dx;
    }

    public String getFcmp_ctryeb() {
        return fcmp_ctryeb;
    }

    public void setFcmp_ctryeb(String fcmp_ctryeb) {
        this.fcmp_ctryeb = fcmp_ctryeb;
    }

    public String getFcmp_gajp9c() {
        return fcmp_gajp9c;
    }

    public void setFcmp_gajp9c(String fcmp_gajp9c) {
        this.fcmp_gajp9c = fcmp_gajp9c;
    }

    public String getFcmp_yixkyu() {
        return fcmp_yixkyu;
    }

    public void setFcmp_yixkyu(String fcmp_yixkyu) {
        this.fcmp_yixkyu = fcmp_yixkyu;
    }

    public String getFcmp_2puodq() {
        return fcmp_2puodq;
    }

    public void setFcmp_2puodq(String fcmp_2puodq) {
        this.fcmp_2puodq = fcmp_2puodq;
    }

    public String getFcmp_num7gz() {
        return fcmp_num7gz;
    }

    public void setFcmp_num7gz(String fcmp_num7gz) {
        this.fcmp_num7gz = fcmp_num7gz;
    }

    public String getFcmp_7jziez() {
        return fcmp_7jziez;
    }

    public void setFcmp_7jziez(String fcmp_7jziez) {
        this.fcmp_7jziez = fcmp_7jziez;
    }

    public String getFcmp_3e9lq0() {
        return fcmp_3e9lq0;
    }

    public void setFcmp_3e9lq0(String fcmp_3e9lq0) {
        this.fcmp_3e9lq0 = fcmp_3e9lq0;
    }

    public String getFcmp_kh3lsl() {
        return fcmp_kh3lsl;
    }

    public void setFcmp_kh3lsl(String fcmp_kh3lsl) {
        this.fcmp_kh3lsl = fcmp_kh3lsl;
    }

    public String getFcmp_9c7tzl() {
        return fcmp_9c7tzl;
    }

    public void setFcmp_9c7tzl(String fcmp_9c7tzl) {
        this.fcmp_9c7tzl = fcmp_9c7tzl;
    }

    public String getFcmp_2joh9k() {
        return fcmp_2joh9k;
    }

    public void setFcmp_2joh9k(String fcmp_2joh9k) {
        this.fcmp_2joh9k = fcmp_2joh9k;
    }

    public String getFcmp_y93ups() {
        return fcmp_y93ups;
    }

    public void setFcmp_y93ups(String fcmp_y93ups) {
        this.fcmp_y93ups = fcmp_y93ups;
    }

    public String getF686a() {
        return f686a;
    }

    public void setF686a(String f686a) {
        this.f686a = f686a;
    }

    public String getFcmp_goivbk() {
        return fcmp_goivbk;
    }

    public void setFcmp_goivbk(String fcmp_goivbk) {
        this.fcmp_goivbk = fcmp_goivbk;
    }

    public String getFcmp_wudvif() {
        return fcmp_wudvif;
    }

    public void setFcmp_wudvif(String fcmp_wudvif) {
        this.fcmp_wudvif = fcmp_wudvif;
    }

    public String getFcmp_wz7irn() {
        return fcmp_wz7irn;
    }

    public void setFcmp_wz7irn(String fcmp_wz7irn) {
        this.fcmp_wz7irn = fcmp_wz7irn;
    }

    public String getFcmp_9t9dby() {
        return fcmp_9t9dby;
    }

    public void setFcmp_9t9dby(String fcmp_9t9dby) {
        this.fcmp_9t9dby = fcmp_9t9dby;
    }

    public String getFcmp_rghp7h() {
        return fcmp_rghp7h;
    }

    public void setFcmp_rghp7h(String fcmp_rghp7h) {
        this.fcmp_rghp7h = fcmp_rghp7h;
    }

    public String getFcmp_1jjlw8() {
        return fcmp_1jjlw8;
    }

    public void setFcmp_1jjlw8(String fcmp_1jjlw8) {
        this.fcmp_1jjlw8 = fcmp_1jjlw8;
    }

    public String getF700f() {
        return f700f;
    }

    public void setF700f(String f700f) {
        this.f700f = f700f;
    }

    public String getFcmp_6fntbc() {
        return fcmp_6fntbc;
    }

    public void setFcmp_6fntbc(String fcmp_6fntbc) {
        this.fcmp_6fntbc = fcmp_6fntbc;
    }

    public String getF700p() {
        return f700p;
    }

    public void setF700p(String f700p) {
        this.f700p = f700p;
    }

    public String getF7003() {
        return f7003;
    }

    public void setF7003(String f7003) {
        this.f7003 = f7003;
    }

    public String getFcmp_jmx7so() {
        return fcmp_jmx7so;
    }

    public void setFcmp_jmx7so(String fcmp_jmx7so) {
        this.fcmp_jmx7so = fcmp_jmx7so;
    }

    public String getFcmp_3jipa9() {
        return fcmp_3jipa9;
    }

    public void setFcmp_3jipa9(String fcmp_3jipa9) {
        this.fcmp_3jipa9 = fcmp_3jipa9;
    }

    public String getF701b() {
        return f701b;
    }

    public void setF701b(String f701b) {
        this.f701b = f701b;
    }

    public String getFcmp_toq7w4() {
        return fcmp_toq7w4;
    }

    public void setFcmp_toq7w4(String fcmp_toq7w4) {
        this.fcmp_toq7w4 = fcmp_toq7w4;
    }

    public String getFcmp_lcj4dd() {
        return fcmp_lcj4dd;
    }

    public void setFcmp_lcj4dd(String fcmp_lcj4dd) {
        this.fcmp_lcj4dd = fcmp_lcj4dd;
    }

    public String getF701f() {
        return f701f;
    }

    public void setF701f(String f701f) {
        this.f701f = f701f;
    }

    public String getFcmp_bpm7o8() {
        return fcmp_bpm7o8;
    }

    public void setFcmp_bpm7o8(String fcmp_bpm7o8) {
        this.fcmp_bpm7o8 = fcmp_bpm7o8;
    }

    public String getFcmp_4ygna4() {
        return fcmp_4ygna4;
    }

    public void setFcmp_4ygna4(String fcmp_4ygna4) {
        this.fcmp_4ygna4 = fcmp_4ygna4;
    }

    public String getF7013() {
        return f7013;
    }

    public void setF7013(String f7013) {
        this.f7013 = f7013;
    }

    public String getFcmp_u3i9al() {
        return fcmp_u3i9al;
    }

    public void setFcmp_u3i9al(String fcmp_u3i9al) {
        this.fcmp_u3i9al = fcmp_u3i9al;
    }

    public String getFcmp_jcyhz3() {
        return fcmp_jcyhz3;
    }

    public void setFcmp_jcyhz3(String fcmp_jcyhz3) {
        this.fcmp_jcyhz3 = fcmp_jcyhz3;
    }

    public String getFcmp_tn35dc() {
        return fcmp_tn35dc;
    }

    public void setFcmp_tn35dc(String fcmp_tn35dc) {
        this.fcmp_tn35dc = fcmp_tn35dc;
    }

    public String getFcmp_e44po5() {
        return fcmp_e44po5;
    }

    public void setFcmp_e44po5(String fcmp_e44po5) {
        this.fcmp_e44po5 = fcmp_e44po5;
    }

    public String getFcmp_lpeu86() {
        return fcmp_lpeu86;
    }

    public void setFcmp_lpeu86(String fcmp_lpeu86) {
        this.fcmp_lpeu86 = fcmp_lpeu86;
    }

    public String getFcmp_7515ab() {
        return fcmp_7515ab;
    }

    public void setFcmp_7515ab(String fcmp_7515ab) {
        this.fcmp_7515ab = fcmp_7515ab;
    }

    public String getFcmp_9gog5t() {
        return fcmp_9gog5t;
    }

    public void setFcmp_9gog5t(String fcmp_9gog5t) {
        this.fcmp_9gog5t = fcmp_9gog5t;
    }

    public String getFcmp_48xyin() {
        return fcmp_48xyin;
    }

    public void setFcmp_48xyin(String fcmp_48xyin) {
        this.fcmp_48xyin = fcmp_48xyin;
    }

    public String getFcmp_267n2z() {
        return fcmp_267n2z;
    }

    public void setFcmp_267n2z(String fcmp_267n2z) {
        this.fcmp_267n2z = fcmp_267n2z;
    }

    public String getFcmp_abkg6e() {
        return fcmp_abkg6e;
    }

    public void setFcmp_abkg6e(String fcmp_abkg6e) {
        this.fcmp_abkg6e = fcmp_abkg6e;
    }

    public String getFcmp_gsu5sp() {
        return fcmp_gsu5sp;
    }

    public void setFcmp_gsu5sp(String fcmp_gsu5sp) {
        this.fcmp_gsu5sp = fcmp_gsu5sp;
    }

    public String getFcmp_18wm4h() {
        return fcmp_18wm4h;
    }

    public void setFcmp_18wm4h(String fcmp_18wm4h) {
        this.fcmp_18wm4h = fcmp_18wm4h;
    }

    public String getFcmp_oex7h1() {
        return fcmp_oex7h1;
    }

    public void setFcmp_oex7h1(String fcmp_oex7h1) {
        this.fcmp_oex7h1 = fcmp_oex7h1;
    }

    public String getFcmp_at9l93() {
        return fcmp_at9l93;
    }

    public void setFcmp_at9l93(String fcmp_at9l93) {
        this.fcmp_at9l93 = fcmp_at9l93;
    }

    public String getFcmp_is3xn3() {
        return fcmp_is3xn3;
    }

    public void setFcmp_is3xn3(String fcmp_is3xn3) {
        this.fcmp_is3xn3 = fcmp_is3xn3;
    }

    public String getFcmp_8dy2we() {
        return fcmp_8dy2we;
    }

    public void setFcmp_8dy2we(String fcmp_8dy2we) {
        this.fcmp_8dy2we = fcmp_8dy2we;
    }

    public String getFcmp_ka42ib() {
        return fcmp_ka42ib;
    }

    public void setFcmp_ka42ib(String fcmp_ka42ib) {
        this.fcmp_ka42ib = fcmp_ka42ib;
    }

    public String getFcmp_cpbxvv() {
        return fcmp_cpbxvv;
    }

    public void setFcmp_cpbxvv(String fcmp_cpbxvv) {
        this.fcmp_cpbxvv = fcmp_cpbxvv;
    }

    public String getFcmp_i9kssw() {
        return fcmp_i9kssw;
    }

    public void setFcmp_i9kssw(String fcmp_i9kssw) {
        this.fcmp_i9kssw = fcmp_i9kssw;
    }

    public String getFcmp_hidbhu() {
        return fcmp_hidbhu;
    }

    public void setFcmp_hidbhu(String fcmp_hidbhu) {
        this.fcmp_hidbhu = fcmp_hidbhu;
    }

    public String getFcmp_hmsw3x() {
        return fcmp_hmsw3x;
    }

    public void setFcmp_hmsw3x(String fcmp_hmsw3x) {
        this.fcmp_hmsw3x = fcmp_hmsw3x;
    }

    public String getFcmp_ke5q5n() {
        return fcmp_ke5q5n;
    }

    public void setFcmp_ke5q5n(String fcmp_ke5q5n) {
        this.fcmp_ke5q5n = fcmp_ke5q5n;
    }

    public String getFcmp_5uoxxb() {
        return fcmp_5uoxxb;
    }

    public void setFcmp_5uoxxb(String fcmp_5uoxxb) {
        this.fcmp_5uoxxb = fcmp_5uoxxb;
    }

    public String getFcmp_yr55hh() {
        return fcmp_yr55hh;
    }

    public void setFcmp_yr55hh(String fcmp_yr55hh) {
        this.fcmp_yr55hh = fcmp_yr55hh;
    }

    public String getFcmp_3e77q3() {
        return fcmp_3e77q3;
    }

    public void setFcmp_3e77q3(String fcmp_3e77q3) {
        this.fcmp_3e77q3 = fcmp_3e77q3;
    }

    public String getFcmp_t7my6n() {
        return fcmp_t7my6n;
    }

    public void setFcmp_t7my6n(String fcmp_t7my6n) {
        this.fcmp_t7my6n = fcmp_t7my6n;
    }

    public String getFcmp_3yf6dn() {
        return fcmp_3yf6dn;
    }

    public void setFcmp_3yf6dn(String fcmp_3yf6dn) {
        this.fcmp_3yf6dn = fcmp_3yf6dn;
    }

    public String getFcmp_n7mu55() {
        return fcmp_n7mu55;
    }

    public void setFcmp_n7mu55(String fcmp_n7mu55) {
        this.fcmp_n7mu55 = fcmp_n7mu55;
    }

    public String getFcmp_a09ea7() {
        return fcmp_a09ea7;
    }

    public void setFcmp_a09ea7(String fcmp_a09ea7) {
        this.fcmp_a09ea7 = fcmp_a09ea7;
    }

    public String getFcmp_mqi9lf() {
        return fcmp_mqi9lf;
    }

    public void setFcmp_mqi9lf(String fcmp_mqi9lf) {
        this.fcmp_mqi9lf = fcmp_mqi9lf;
    }

    public String getFcmp_vbcmrb() {
        return fcmp_vbcmrb;
    }

    public void setFcmp_vbcmrb(String fcmp_vbcmrb) {
        this.fcmp_vbcmrb = fcmp_vbcmrb;
    }

    public String getFcmp_asnq3o() {
        return fcmp_asnq3o;
    }

    public void setFcmp_asnq3o(String fcmp_asnq3o) {
        this.fcmp_asnq3o = fcmp_asnq3o;
    }

    public String getFcmp_bbtzcb() {
        return fcmp_bbtzcb;
    }

    public void setFcmp_bbtzcb(String fcmp_bbtzcb) {
        this.fcmp_bbtzcb = fcmp_bbtzcb;
    }

    public String getFcmp_pxihly() {
        return fcmp_pxihly;
    }

    public void setFcmp_pxihly(String fcmp_pxihly) {
        this.fcmp_pxihly = fcmp_pxihly;
    }

    public String getFcmp_fnv0zo() {
        return fcmp_fnv0zo;
    }

    public void setFcmp_fnv0zo(String fcmp_fnv0zo) {
        this.fcmp_fnv0zo = fcmp_fnv0zo;
    }

    public String getFcmp_1k2pra() {
        return fcmp_1k2pra;
    }

    public void setFcmp_1k2pra(String fcmp_1k2pra) {
        this.fcmp_1k2pra = fcmp_1k2pra;
    }

    public String getFcmp_zjc5bd() {
        return fcmp_zjc5bd;
    }

    public void setFcmp_zjc5bd(String fcmp_zjc5bd) {
        this.fcmp_zjc5bd = fcmp_zjc5bd;
    }

    public String getFcmp_e849ad() {
        return fcmp_e849ad;
    }

    public void setFcmp_e849ad(String fcmp_e849ad) {
        this.fcmp_e849ad = fcmp_e849ad;
    }

    public String getFcmp_5h9v6b() {
        return fcmp_5h9v6b;
    }

    public void setFcmp_5h9v6b(String fcmp_5h9v6b) {
        this.fcmp_5h9v6b = fcmp_5h9v6b;
    }

    public String getFcmp_j8wyw2() {
        return fcmp_j8wyw2;
    }

    public void setFcmp_j8wyw2(String fcmp_j8wyw2) {
        this.fcmp_j8wyw2 = fcmp_j8wyw2;
    }

    public String getFcmp_r56s00() {
        return fcmp_r56s00;
    }

    public void setFcmp_r56s00(String fcmp_r56s00) {
        this.fcmp_r56s00 = fcmp_r56s00;
    }

    public String getFcmp_hkvapz() {
        return fcmp_hkvapz;
    }

    public void setFcmp_hkvapz(String fcmp_hkvapz) {
        this.fcmp_hkvapz = fcmp_hkvapz;
    }

    public String getFcmp_6y932b() {
        return fcmp_6y932b;
    }

    public void setFcmp_6y932b(String fcmp_6y932b) {
        this.fcmp_6y932b = fcmp_6y932b;
    }

    public KeyObject getF901a() {
        return f901a;
    }

    public void setF901a(KeyObject f901a) {
        this.f901a = f901a;
    }

    public String getF9016() {
        return f9016;
    }

    public void setF9016(String f9016) {
        this.f9016 = f9016;
    }

    public String getFcmp_5iri6j() {
        return fcmp_5iri6j;
    }

    public void setFcmp_5iri6j(String fcmp_5iri6j) {
        this.fcmp_5iri6j = fcmp_5iri6j;
    }

    public String getF910a() {
        return f910a;
    }

    public void setF910a(String f910a) {
        this.f910a = f910a;
    }

    public String getF910b() {
        return f910b;
    }

    public void setF910b(String f910b) {
        this.f910b = f910b;
    }

    public String getF910d() {
        return f910d;
    }

    public void setF910d(String f910d) {
        this.f910d = f910d;
    }

    public String getF911a() {
        return f911a;
    }

    public void setF911a(String f911a) {
        this.f911a = f911a;
    }

    public String getF912a() {
        return f912a;
    }

    public void setF912a(String f912a) {
        this.f912a = f912a;
    }
}

