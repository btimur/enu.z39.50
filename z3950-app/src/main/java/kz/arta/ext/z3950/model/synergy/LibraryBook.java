package kz.arta.ext.z3950.model.synergy;

import kz.arta.ext.z3950.util.ApiFormField;

import java.util.List;

/**
 * Created by timur on 04/08/2014 21:18.
 */
public class LibraryBook {
    /**
     * Библиография
     */
    @ApiFormField(nameField = "320a",typeField = "textbox", isList = true, parentTable ="dyntable_320a")
    private List<String> f320a;

    /**
     * Ключевое слово
     */
    @ApiFormField(nameField = "610a",typeField = "textbox", isList = true, parentTable = "dyntable_610a")
    private List<String> f610a;

    /**
     * Автор
     */
    @ApiFormField(nameField = "700a",typeField = "textbox", isList = true, parentTable = "dyntable_700a")
    private List<String> f700a;

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
    @ApiFormField(nameField = "001",typeField = "textbox")
    private String f001;

    /**
     * Уточнения
     */
    @ApiFormField(nameField = "010b",typeField = "textbox")
    private String f010b;

    /**
     * Ошибочный номер ISBN
     */
    @ApiFormField(nameField = "010z",typeField = "textbox")
    private String f010z;

    /**
     * Номер ISSN
     */
    @ApiFormField(nameField = "011a",typeField = "textbox")
    private String f011a;

    /**
     * Квалификация
     */
    @ApiFormField(nameField = "011b",typeField = "textbox")
    private String f011b;

    /**
     * Условия приобретения или цена
     */
    @ApiFormField(nameField = "011d",typeField = "textbox")
    private String f011d;

    /**
     * Aнулированный ISSN
     */
    @ApiFormField(nameField = "011y",typeField = "textbox")
    private String f011y;

    /**
     * Ошибочный ISSN.
     */
    @ApiFormField(nameField = "011z",typeField = "textbox")
    private String f011z;

    /**
     * Отпечатки пальцев
     */
    @ApiFormField(nameField = "012a",typeField = "textbox")
    private String f012a;

    /**
     * Код системы контроля отпечатка пальцев
     */
    @ApiFormField(nameField = "0122",typeField = "textbox")
    private String f0122;

    /**
     * Учреждение, к которому применяется область
     */
    @ApiFormField(nameField = "0125",typeField = "textbox")
    private String f0125;

    /**
     * Номер (ISMN)
     */
    @ApiFormField(nameField = "013a",typeField = "textbox")
    private String f013a;

    /**
     * Квалификация
     */
    @ApiFormField(nameField = "013b",typeField = "textbox")
    private String f013b;

    /**
     * Условия доступности и/или цена
     */
    @ApiFormField(nameField = "013d",typeField = "textbox")
    private String f013d;

    /**
     * Ошибочный ISMN
     */
    @ApiFormField(nameField = "013z",typeField = "textbox")
    private String f013z;

    /**
     * Ошибочный идентификатор статьи
     */
    @ApiFormField(nameField = "014a",typeField = "textbox")
    private String f014a;

    /**
     * Код системы
     */
    @ApiFormField(nameField = "014z",typeField = "textbox")
    private String f014z;

    /**
     * Идентификатор статьи
     */
    @ApiFormField(nameField = "0142",typeField = "textbox")
    private String f0142;

    /**
     * Номер (ISRN)
     */
    @ApiFormField(nameField = "015a",typeField = "textbox")
    private String f015a;

    /**
     * Квалификация
     */
    @ApiFormField(nameField = "015b",typeField = "textbox")
    private String f015b;

    /**
     * Условия доступности и/или цена
     */
    @ApiFormField(nameField = "015d",typeField = "textbox")
    private String f015d;

    /**
     * Аннулированный/Недействительный/Ошибочный ISRN
     */
    @ApiFormField(nameField = "015z",typeField = "textbox")
    private String f015z;

    /**
     * Номер (ISRC)
     */
    @ApiFormField(nameField = "016a",typeField = "textbox")
    private String f016a;

    /**
     * Квалификация
     */
    @ApiFormField(nameField = "016b",typeField = "textbox")
    private String f016b;

    /**
     * Условия доступности и/или цена
     */
    @ApiFormField(nameField = "016d",typeField = "textbox")
    private String f016d;

    /**
     * Ошибочный ISRC
     */
    @ApiFormField(nameField = "016z",typeField = "textbox")
    private String f016z;

    /**
     * Код страны
     */
    @ApiFormField(nameField = "020a",typeField = "textbox")
    private String f020a;

    /**
     * Номер
     */
    @ApiFormField(nameField = "020b",typeField = "textbox")
    private String f020b;

    /**
     * Ошибочный номер
     */
    @ApiFormField(nameField = "020z",typeField = "textbox")
    private String f020z;

    /**
     * Код страны
     */
    @ApiFormField(nameField = "021a",typeField = "textbox")
    private String f021a;

    /**
     * Номер
     */
    @ApiFormField(nameField = "021b",typeField = "textbox")
    private String f021b;

    /**
     * Ошибочный номер
     */
    @ApiFormField(nameField = "021z",typeField = "textbox")
    private String f021z;

    /**
     * Код страны
     */
    @ApiFormField(nameField = "022a",typeField = "textbox")
    private String f022a;

    /**
     * Номер
     */
    @ApiFormField(nameField = "022b",typeField = "textbox")
    private String f022b;

    /**
     * Ошибочный номер
     */
    @ApiFormField(nameField = "022z",typeField = "textbox")
    private String f022z;

    /**
     * Номер системы контроля
     */
    @ApiFormField(nameField = "035a",typeField = "textbox")
    private String f035a;

    /**
     * Аннулированный или недействительный контрольный номер
     */
    @ApiFormField(nameField = "035z",typeField = "textbox")
    private String f035z;

    /**
     * Общие данные обработки
     */
    @ApiFormField(nameField = "100a",typeField = "textbox")
    private String f100a;

    /**
     * Дата ввода записи в файл
     */
    @ApiFormField(nameField = "100a(1)",typeField = "textbox")
    private String f100a_1;

    /**
     * Тип даты публикации
     */
    @ApiFormField(nameField = "100a(2)",typeField = "textbox")
    private String f100a_2;

    /**
     * Дата публикации 1
     */
    @ApiFormField(nameField = "100a(3)",typeField = "textbox")
    private String f100a_3;

    /**
     * Дата публикации 2
     */
    @ApiFormField(nameField = "100a(4)",typeField = "textbox")
    private String f100a_4;

    /**
     * Код целевого назначения
     */
    @ApiFormField(nameField = "100a(5)",typeField = "textbox")
    private String f100a_5;

    /**
     * Правительственная публикация
     */
    @ApiFormField(nameField = "100a(6)",typeField = "textbox")
    private String f100a_6;

    /**
     * Код модифицированной записи
     */
    @ApiFormField(nameField = "100a(7)",typeField = "textbox")
    private String f100a_7;

    /**
     * Язык каталогизации
     */
    @ApiFormField(nameField = "100a(8)",typeField = "textbox")
    private String f100a_8;

    /**
     * Код транслитерации
     */
    @ApiFormField(nameField = "100a(9)",typeField = "textbox")
    private String f100a_9;

    /**
     * Наборы символов
     */
    @ApiFormField(nameField = "100a(10)",typeField = "textbox")
    private String f100a_10;

    /**
     * Дополнительные наборы символов
     */
    @ApiFormField(nameField = "100a(11)",typeField = "textbox")
    private String f100a_11;

    /**
     * Графика заглавия
     */
    @ApiFormField(nameField = "100a(12)",typeField = "textbox")
    private String f100a_12;

    /**
     * Язык резюме
     */
    @ApiFormField(nameField = "101d",typeField = "textbox")
    private String f101d;

    /**
     * Язык оглавления
     */
    @ApiFormField(nameField = "101e",typeField = "textbox")
    private String f101e;

    /**
     * Язык промежуточного перевода, когда каталогизируемый документ переводится с языка оригинала
     */
    @ApiFormField(nameField = "101b",typeField = "textbox")
    private String f101b;

    /**
     * Язык оригинала
     */
    @ApiFormField(nameField = "101c",typeField = "textbox")
    private String f101c;

    /**
     * Язык точного названия если это не основной язык текста, музыки из кинофильма и т.д
     */
    @ApiFormField(nameField = "101g",typeField = "textbox")
    private String f101g;

    /**
     * Язык либретто
     */
    @ApiFormField(nameField = "101h",typeField = "textbox")
    private String f101h;

    /**
     * язык сопроводительного материала (не кртакого изложения, резюме, либретто)
     */
    @ApiFormField(nameField = "101i",typeField = "textbox")
    private String f101i;

    /**
     * Язык подзагловока
     */
    @ApiFormField(nameField = "101j",typeField = "textbox")
    private String f101j;

    /**
     * Страна публикации
     */
    @ApiFormField(nameField = "102a",typeField = "textbox")
    private String f102a;

    /**
     * Кодированные данные о книге
     */
    @ApiFormField(nameField = "105a",typeField = "textbox")
    private String f105a;

    /**
     * Коды иллюстраций
     */
    @ApiFormField(nameField = "105a(1)",typeField = "textbox")
    private String f105a_1;

    /**
     * Коды формы содержания
     */
    @ApiFormField(nameField = "105a(2)",typeField = "textbox")
    private String f105a_2;

    /**
     * Код конференции или совещания
     */
    @ApiFormField(nameField = "105a(3)",typeField = "textbox")
    private String f105a_3;

    /**
     * Индикатор юбилейного издания
     */
    @ApiFormField(nameField = "105a(4)",typeField = "textbox")
    private String f105a_4;

    /**
     * Индикатор указателя
     */
    @ApiFormField(nameField = "105a(5)",typeField = "textbox")
    private String f105a_5;

    /**
     * Код литературного жанра
     */
    @ApiFormField(nameField = "105a(6)",typeField = "textbox")
    private String f105a_6;

    /**
     * Код биографии
     */
    @ApiFormField(nameField = "105a(7)",typeField = "textbox")
    private String f105a_7;

    /**
     * Кодированные данные сериального издания
     */
    @ApiFormField(nameField = "110a",typeField = "textbox")
    private String f110a;

    /**
     * Определитель типа сериального издания
     */
    @ApiFormField(nameField = "110a(1)",typeField = "textbox")
    private String f110a_1;

    /**
     * Периодичность издания
     */
    @ApiFormField(nameField = "110a(2)",typeField = "textbox")
    private String f110a_2;

    /**
     * Регулярность
     */
    @ApiFormField(nameField = "110a(3)",typeField = "textbox")
    private String f110a_3;

    /**
     * Код вида материала
     */
    @ApiFormField(nameField = "110a(4)",typeField = "textbox")
    private String f110a_4;

    /**
     * Код типа содержания
     */
    @ApiFormField(nameField = "110a(5)",typeField = "textbox")
    private String f110a_5;

    /**
     * Индикатор материалов конференции
     */
    @ApiFormField(nameField = "110a(6)",typeField = "textbox")
    private String f110a_6;

    /**
     * Код наличия титульного листа
     */
    @ApiFormField(nameField = "110a(7)",typeField = "textbox")
    private String f110a_7;

    /**
     * Код наличия указателя
     */
    @ApiFormField(nameField = "110a(8)",typeField = "textbox")
    private String f110a_8;

    /**
     * Код наличия кумулятивного указателя
     */
    @ApiFormField(nameField = "110a(9)",typeField = "textbox")
    private String f110a_9;

    /**
     * Шифрованные данные - Общие
     */
    @ApiFormField(nameField = "115a",typeField = "textbox")
    private String f115a;

    /**
     * Тип материала
     */
    @ApiFormField(nameField = "115a(1)",typeField = "textbox")
    private String f115a_1;

    /**
     * Форма презентации - видеозапись
     */
    @ApiFormField(nameField = "115a(12)",typeField = "textbox")
    private String f115a_12;

    /**
     * Основа материала эмульсии - визуальное проектирование
     */
    @ApiFormField(nameField = "115a(13)",typeField = "textbox")
    private String f115a_13;

    /**
     * Вторичный материал поддержки -визуальное проектирование
     */
    @ApiFormField(nameField = "115a(14)",typeField = "textbox")
    private String f115a_14;

    /**
     * Стандарт телерадиовещания - видеозапись
     */
    @ApiFormField(nameField = "115a(15)",typeField = "textbox")
    private String f115a_15;

    /**
     * Шифрованные данные кинофильма - архивный
     */
    @ApiFormField(nameField = "115b",typeField = "textbox")
    private String f115b;

    /**
     * Поколение/генерация
     */
    @ApiFormField(nameField = "115b(1)",typeField = "textbox")
    private String f115b_1;

    /**
     * Элементы производства
     */
    @ApiFormField(nameField = "115b(2)",typeField = "textbox")
    private String f115b_2;

    /**
     * Улучшенные катгории цвета для кинофильмов
     */
    @ApiFormField(nameField = "115b(3)",typeField = "textbox")
    private String f115b_3;

    /**
     * кино/фото
     */
    @ApiFormField(nameField = "115b(4)",typeField = "textbox")
    private String f115b_4;

    /**
     * Основа фильма
     */
    @ApiFormField(nameField = "115b(5)",typeField = "textbox")
    private String f115b_5;

    /**
     * Вид звука при пермещении изображения
     */
    @ApiFormField(nameField = "115b(6)",typeField = "textbox")
    private String f115b_6;

    /**
     * Вид запаса фильма или печати
     */
    @ApiFormField(nameField = "115b(7)",typeField = "textbox")
    private String f115b_7;

    /**
     * Стадия износа (повреждения)
     */
    @ApiFormField(nameField = "115b(8)",typeField = "textbox")
    private String f115b_8;

    /**
     * Законченность
     */
    @ApiFormField(nameField = "115b(9)",typeField = "textbox")
    private String f115b_9;

    /**
     * Дата проверки фильма
     */
    @ApiFormField(nameField = "115b(10)",typeField = "textbox")
    private String f115b_10;

    /**
     * Длина
     */
    @ApiFormField(nameField = "115a(2)",typeField = "textbox")
    private String f115a_2;

    /**
     * Цветной индикатор
     */
    @ApiFormField(nameField = "115a(3)",typeField = "textbox")
    private String f115a_3;

    /**
     * Звуковой индикатор
     */
    @ApiFormField(nameField = "115a(4)",typeField = "textbox")
    private String f115a_4;

    /**
     * Носитель информации для звкуа
     */
    @ApiFormField(nameField = "115a(5)",typeField = "textbox")
    private String f115a_5;

    /**
     * Ширина или размеры
     */
    @ApiFormField(nameField = "115a(6)",typeField = "textbox")
    private String f115a_6;

    /**
     * Форма выпуска - визуальное проектирование, кинофильм
     */
    @ApiFormField(nameField = "115a(7)",typeField = "textbox")
    private String f115a_7;

    /**
     * Техника - видеозапись, кинофильм
     */
    @ApiFormField(nameField = "115a(8)",typeField = "textbox")
    private String f115a_8;

    /**
     * Формат презентации - кинофильм
     */
    @ApiFormField(nameField = "115a(9)",typeField = "textbox")
    private String f115a_9;

    /**
     * Сопровождающий материал
     */
    @ApiFormField(nameField = "115a(10)",typeField = "textbox")
    private String f115a_10;

    /**
     * Форма выпуска - видеозапись
     */
    @ApiFormField(nameField = "115a(11)",typeField = "textbox")
    private String f115a_11;

    /**
     * 135 ПОЛЕ КОДИРОВАННЫХ ДАННЫХ: ЭЛЕКТРОННЫЕ РЕСУРСЫ
     */
    @ApiFormField(nameField = "135",typeField = "textbox")
    private String f135;

    /**
     * Основное заглавие произведения другого автора
     */
    @ApiFormField(nameField = "200c",typeField = "textbox")
    private String f200c;

    /**
     * Последующие сведения об ответственности
     */
    @ApiFormField(nameField = "200g",typeField = "textbox")
    private String f200g;

    /**
     * Обозначение тома
     */
    @ApiFormField(nameField = "200v",typeField = "textbox")
    private String f200v;

    /**
     * Дополнительные сведения об издании
     */
    @ApiFormField(nameField = "205b",typeField = "textbox")
    private String f205b;

    /**
     * Сведения об ответственности,  относящиеся к изданию
     */
    @ApiFormField(nameField = "205f",typeField = "textbox")
    private String f205f;

    /**
     * Источник информации о нумерации
     */
    @ApiFormField(nameField = "207z",typeField = "textbox")
    private String f207z;

    /**
     * Размеры
     */
    @ApiFormField(nameField = "215d",typeField = "textbox")
    private String f215d;

    /**
     * Параллельное заглавие серии
     */
    @ApiFormField(nameField = "225d",typeField = "textbox")
    private String f225d;

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
    @ApiFormField(nameField = "225h",typeField = "textbox")
    private String f225h;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "225i",typeField = "textbox")
    private String f225i;

    /**
     * Язык параллельного заглавия
     */
    @ApiFormField(nameField = "225z",typeField = "textbox")
    private String f225z;

    /**
     * Обозначение тома
     */
    @ApiFormField(nameField = "225v",typeField = "textbox")
    private String f225v;

    /**
     * ISSN серии
     */
    @ApiFormField(nameField = "225x",typeField = "textbox")
    private String f225x;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "301a",typeField = "textbox")
    private String f301a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "302a",typeField = "textbox")
    private String f302a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "303a",typeField = "textbox")
    private String f303a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "304a",typeField = "textbox")
    private String f304a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "305a",typeField = "textbox")
    private String f305a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "306a",typeField = "textbox")
    private String f306a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "307a",typeField = "textbox")
    private String f307a;

    /**
     *  Текст или заметки
     */
    @ApiFormField(nameField = "308a",typeField = "textbox")
    private String f308a;

    /**
     *  Текст или заметки
     */
    @ApiFormField(nameField = "310a",typeField = "textbox")
    private String f310a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "311a",typeField = "textbox")
    private String f311a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "312a",typeField = "textbox")
    private String f312a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "313a",typeField = "textbox")
    private String f313a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "314a",typeField = "textbox")
    private String f314a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "315a",typeField = "textbox")
    private String f315a;

    /**
     *  Текст или заметки
     */
    @ApiFormField(nameField = "316a",typeField = "textbox")
    private String f316a;

    /**
     * Учреждение к котороу применяется эта область
     */
    @ApiFormField(nameField = "3165",typeField = "textbox")
    private String f3165;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "317a",typeField = "textbox")
    private String f317a;

    /**
     * Учреждение к котороу применяется эта область
     */
    @ApiFormField(nameField = "3175",typeField = "textbox")
    private String f3175;

    /**
     * Действие
     */
    @ApiFormField(nameField = "318a",typeField = "textbox")
    private String f318a;

    /**
     * Идентификатор действия
     */
    @ApiFormField(nameField = "318b",typeField = "textbox")
    private String f318b;

    /**
     * Время действия
     */
    @ApiFormField(nameField = "318c",typeField = "textbox")
    private String f318c;

    /**
     * Интервал действия
     */
    @ApiFormField(nameField = "318d",typeField = "textbox")
    private String f318d;

    /**
     * Непредвиденные обстоятельства для действия
     */
    @ApiFormField(nameField = "318e",typeField = "textbox")
    private String f318e;

    /**
     * Разрешение
     */
    @ApiFormField(nameField = "318f",typeField = "textbox")
    private String f318f;

    /**
     * Юрисдикция
     */
    @ApiFormField(nameField = "318h",typeField = "textbox")
    private String f318h;

    /**
     * Методы действия
     */
    @ApiFormField(nameField = "318i",typeField = "textbox")
    private String f318i;

    /**
     * Участок действия
     */
    @ApiFormField(nameField = "318j",typeField = "textbox")
    private String f318j;

    /**
     * Агент Действия
     */
    @ApiFormField(nameField = "318k",typeField = "textbox")
    private String f318k;

    /**
     * Статус
     */
    @ApiFormField(nameField = "318l",typeField = "textbox")
    private String f318l;

    /**
     * Степень
     */
    @ApiFormField(nameField = "318n",typeField = "textbox")
    private String f318n;

    /**
     * Тип единицы
     */
    @ApiFormField(nameField = "318o",typeField = "textbox")
    private String f318o;

    /**
     * Непубличное примечание
     */
    @ApiFormField(nameField = "318p",typeField = "textbox")
    private String f318p;

    /**
     * Публичное примечание
     */
    @ApiFormField(nameField = "318r",typeField = "textbox")
    private String f318r;

    /**
     * Учреждение к котороу применяется эта область
     */
    @ApiFormField(nameField = "3185",typeField = "textbox")
    private String f3185;

    /**
     * Наименование источника
     */
    @ApiFormField(nameField = "321a",typeField = "textbox")
    private String f321a;

    /**
     * Период охвата
     */
    @ApiFormField(nameField = "321b",typeField = "textbox")
    private String f321b;

    /**
     * Международный стандартный номер
     */
    @ApiFormField(nameField = "321x",typeField = "textbox")
    private String f321x;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "322a",typeField = "textbox")
    private String f322a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "323a",typeField = "textbox")
    private String f323a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "324a",typeField = "textbox")
    private String f324a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "325a",typeField = "textbox")
    private String f325a;

    /**
     * Периодичность
     */
    @ApiFormField(nameField = "326a",typeField = "textbox")
    private String f326a;

    /**
     * Даты периодичности
     */
    @ApiFormField(nameField = "326b",typeField = "textbox")
    private String f326b;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "328a",typeField = "textbox")
    private String f328a;

    /**
     * Текст примечания
     */
    @ApiFormField(nameField = "330a",typeField = "textbox")
    private String f330a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "331a",typeField = "textbox")
    private String f331a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "332a",typeField = "textbox")
    private String f332a;

    /**
     * Текст примечания награды
     */
    @ApiFormField(nameField = "333a",typeField = "textbox")
    private String f333a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "336a",typeField = "textbox")
    private String f336a;

    /**
     * Текст или заметки
     */
    @ApiFormField(nameField = "337a",typeField = "textbox")
    private String f337a;

    /**
     * Источник для комлектования/подписки
     */
    @ApiFormField(nameField = "345a",typeField = "textbox")
    private String f345a;

    /**
     * Номер фонда
     */
    @ApiFormField(nameField = "345b",typeField = "textbox")
    private String f345b;

    /**
     * Среднее
     */
    @ApiFormField(nameField = "345c",typeField = "textbox")
    private String f345c;

    /**
     * Условия доступности
     */
    @ApiFormField(nameField = "345d",typeField = "textbox")
    private String f345d;

    /**
     * 410 СЕРИЯ
     */
    @ApiFormField(nameField = "410",typeField = "textbox")
    private String f410;

    /**
     * 411 ПОДСЕРИЯ
     */
    @ApiFormField(nameField = "411",typeField = "textbox")
    private String f411;

    /**
     * 421 ПРИЛОЖЕНИЕ
     */
    @ApiFormField(nameField = "421",typeField = "textbox")
    private String f421;

    /**
     * 422 ИЗДАНИЕ, К КОТОРОМУ ОТНОСИТСЯ ПРИЛОЖЕНИЕ
     */
    @ApiFormField(nameField = "422",typeField = "textbox")
    private String f422;

    /**
     * 453 ПЕРЕВОД
     */
    @ApiFormField(nameField = "453",typeField = "textbox")
    private String f453;

    /**
     * 454 ОРИГИНАЛ
     */
    @ApiFormField(nameField = "454",typeField = "textbox")
    private String f454;

    /**
     * 461 УРОВЕНЬ НАБОРА
     */
    @ApiFormField(nameField = "461",typeField = "textbox")
    private String f461;

    /**
     * Данные связываемой записи
     */
    @ApiFormField(nameField = "4631",typeField = "textbox")
    private String f4631;

    /**
     * Однородное название
     */
    @ApiFormField(nameField = "500a",typeField = "textbox")
    private String f500a;

    /**
     * Общее материальное обозначение
     */
    @ApiFormField(nameField = "500b",typeField = "textbox")
    private String f500b;

    /**
     * Номер секции или части
     */
    @ApiFormField(nameField = "500h",typeField = "textbox")
    private String f500h;

    /**
     * Номер секции или части
     */
    @ApiFormField(nameField = "500i",typeField = "textbox")
    private String f500i;

    /**
     * Форма подразделения
     */
    @ApiFormField(nameField = "500j",typeField = "textbox")
    private String f500j;

    /**
     * Дата публикации сведений
     */
    @ApiFormField(nameField = "500k",typeField = "textbox")
    private String f500k;

    /**
     * Форма подзаголовка
     */
    @ApiFormField(nameField = "500l",typeField = "textbox")
    private String f500l;

    /**
     * Язык (в части заголовка)
     */
    @ApiFormField(nameField = "500m",typeField = "textbox")
    private String f500m;

    /**
     * Разная информация
     */
    @ApiFormField(nameField = "500n",typeField = "textbox")
    private String f500n;

    /**
     * Версия (или дата версии)
     */
    @ApiFormField(nameField = "500q",typeField = "textbox")
    private String f500q;

    /**
     * Способ исполнения (для музыки)
     */
    @ApiFormField(nameField = "500r",typeField = "textbox")
    private String f500r;

    /**
     * Числовое обозначение (для музыки)
     */
    @ApiFormField(nameField = "500s",typeField = "textbox")
    private String f500s;

    /**
     * Ключ (для музыки)
     */
    @ApiFormField(nameField = "500u",typeField = "textbox")
    private String f500u;

    /**
     * Обозначение объема
     */
    @ApiFormField(nameField = "500v",typeField = "textbox")
    private String f500v;

    /**
     * Классифицированная учетная запись (для музыки)
     */
    @ApiFormField(nameField = "500w",typeField = "textbox")
    private String f500w;

    /**
     * Актуальное подразделение
     */
    @ApiFormField(nameField = "500x",typeField = "textbox")
    private String f500x;

    /**
     * Географическое подразделение
     */
    @ApiFormField(nameField = "500y",typeField = "textbox")
    private String f500y;

    /**
     * Хронологическое подразделение
     */
    @ApiFormField(nameField = "500z",typeField = "textbox")
    private String f500z;

    /**
     * Системный код
     */
    @ApiFormField(nameField = "5002",typeField = "textbox")
    private String f5002;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "5003",typeField = "textbox")
    private String f5003;

    /**
     * Коллективное однородное заглаиве
     */
    @ApiFormField(nameField = "501a",typeField = "textbox")
    private String f501a;

    /**
     * Общее материальное обозначение
     */
    @ApiFormField(nameField = "501b",typeField = "textbox")
    private String f501b;

    /**
     * Коллективный однородный подзаголовок
     */
    @ApiFormField(nameField = "501e",typeField = "textbox")
    private String f501e;

    /**
     * Форма подразделения
     */
    @ApiFormField(nameField = "501j",typeField = "textbox")
    private String f501j;

    /**
     * Дата публикации и пр.
     */
    @ApiFormField(nameField = "501k",typeField = "textbox")
    private String f501k;

    /**
     * Язык (когда часть заголовка)
     */
    @ApiFormField(nameField = "501m",typeField = "textbox")
    private String f501m;

    /**
     * Способ исполнения (для музыки)
     */
    @ApiFormField(nameField = "501r",typeField = "textbox")
    private String f501r;

    /**
     * Числовое обозначение (для музыки)
     */
    @ApiFormField(nameField = "501s",typeField = "textbox")
    private String f501s;

    /**
     * Ключ (для музыки)
     */
    @ApiFormField(nameField = "501u",typeField = "textbox")
    private String f501u;

    /**
     * Классифицированная учетная запись (для музыки)
     */
    @ApiFormField(nameField = "501w",typeField = "textbox")
    private String f501w;

    /**
     * Актуальное подразделение
     */
    @ApiFormField(nameField = "501x",typeField = "textbox")
    private String f501x;

    /**
     * Географическое подразделение
     */
    @ApiFormField(nameField = "501y",typeField = "textbox")
    private String f501y;

    /**
     * Хронологическое подразделение
     */
    @ApiFormField(nameField = "501z",typeField = "textbox")
    private String f501z;

    /**
     * Системный код
     */
    @ApiFormField(nameField = "5012",typeField = "textbox")
    private String f5012;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "5013",typeField = "textbox")
    private String f5013;

    /**
     * Форма относящаяся к рубрике
     */
    @ApiFormField(nameField = "502a",typeField = "textbox")
    private String f502a;

    /**
     * Форма подзаголовка
     */
    @ApiFormField(nameField = "502b",typeField = "textbox")
    private String f502b;

    /**
     * Месяц и день
     */
    @ApiFormField(nameField = "502d",typeField = "textbox")
    private String f502d;

    /**
     * Фамилия
     */
    @ApiFormField(nameField = "502e",typeField = "textbox")
    private String f502e;

    /**
     * Имя
     */
    @ApiFormField(nameField = "502f",typeField = "textbox")
    private String f502f;

    /**
     * Определитель имени собственного
     */
    @ApiFormField(nameField = "502h",typeField = "textbox")
    private String f502h;

    /**
     * Заглавие части
     */
    @ApiFormField(nameField = "502i",typeField = "textbox")
    private String f502i;

    /**
     * Год
     */
    @ApiFormField(nameField = "502j",typeField = "textbox")
    private String f502j;

    /**
     * Нумерация (арабская)
     */
    @ApiFormField(nameField = "502k",typeField = "textbox")
    private String f502k;

    /**
     * Нумерация (римская)
     */
    @ApiFormField(nameField = "502l",typeField = "textbox")
    private String f502l;

    /**
     * Местоположение
     */
    @ApiFormField(nameField = "502m",typeField = "textbox")
    private String f502m;

    /**
     * Учреждение в местоположении
     */
    @ApiFormField(nameField = "502n",typeField = "textbox")
    private String f502n;

    /**
     * Параллельное заглавие
     */
    @ApiFormField(nameField = "510a",typeField = "textbox")
    private String f510a;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "510e",typeField = "textbox")
    private String f510e;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "510h",typeField = "textbox")
    private String f510h;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "510i",typeField = "textbox")
    private String f510i;

    /**
     * Язык заглавия
     */
    @ApiFormField(nameField = "510z",typeField = "textbox")
    private String f510z;

    /**
     * Заглавие обложки
     */
    @ApiFormField(nameField = "512a",typeField = "textbox")
    private String f512a;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "512e",typeField = "textbox")
    private String f512e;

    /**
     * Добавочное заглавие титульного листа
     */
    @ApiFormField(nameField = "513a",typeField = "textbox")
    private String f513a;

    /**
     * Сведения относящиеся к заглавию
     */
    @ApiFormField(nameField = "513e",typeField = "textbox")
    private String f513e;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "513h",typeField = "textbox")
    private String f513h;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "513i",typeField = "textbox")
    private String f513i;

    /**
     * Прежнее основное заглавие
     */
    @ApiFormField(nameField = "520a",typeField = "textbox")
    private String f520a;

    /**
     * Сведения, относящиеся к заглавию
     */
    @ApiFormField(nameField = "520e",typeField = "textbox")
    private String f520e;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "520h",typeField = "textbox")
    private String f520h;

    /**
     * Наименование части
     */
    @ApiFormField(nameField = "520i",typeField = "textbox")
    private String f520i;

    /**
     * Тома или даты выхода документа под прежним заглавием
     */
    @ApiFormField(nameField = "520j",typeField = "textbox")
    private String f520j;

    /**
     * ISSN прежнего заглавия
     */
    @ApiFormField(nameField = "520x",typeField = "textbox")
    private String f520x;

    /**
     * Ключевое заглавие
     */
    @ApiFormField(nameField = "530a",typeField = "textbox")
    private String f530a;

    /**
     * Уточнение
     */
    @ApiFormField(nameField = "530b",typeField = "textbox")
    private String f530b;

    /**
     * Перевод заглавия
     */
    @ApiFormField(nameField = "541a",typeField = "textbox")
    private String f541a;

    /**
     * Номер части
     */
    @ApiFormField(nameField = "541h",typeField = "textbox")
    private String f541h;

    /**
     * Заглавие части
     */
    @ApiFormField(nameField = "541i",typeField = "textbox")
    private String f541i;

    /**
     * Язык перевода заглавия
     */
    @ApiFormField(nameField = "541z",typeField = "textbox")
    private String f541z;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "600a",typeField = "textbox")
    private String f600a;

    /**
     * Часть имени, отличная от начального элемента ввода
     */
    @ApiFormField(nameField = "600b",typeField = "textbox")
    private String f600b;

    /**
     * Дополнения к имени
     */
    @ApiFormField(nameField = "600c",typeField = "textbox")
    private String f600c;

    /**
     * Даты
     */
    @ApiFormField(nameField = "600f",typeField = "textbox")
    private String f600f;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "600x",typeField = "textbox")
    private String f600x;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "601a",typeField = "textbox")
    private String f601a;

    /**
     * Структурное подразделение
     */
    @ApiFormField(nameField = "601b",typeField = "textbox")
    private String f601b;

    /**
     * Дополнение к наименованию организации или уточнения
     */
    @ApiFormField(nameField = "601c",typeField = "textbox")
    private String f601c;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "601d",typeField = "textbox")
    private String f601d;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "601e",typeField = "textbox")
    private String f601e;

    /**
     * Дата проведения совещания
     */
    @ApiFormField(nameField = "601f",typeField = "textbox")
    private String f601f;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "601g",typeField = "textbox")
    private String f601g;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "601h",typeField = "textbox")
    private String f601h;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "601i",typeField = "textbox")
    private String f601i;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "605a",typeField = "textbox")
    private String f605a;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "605x",typeField = "textbox")
    private String f605x;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "605y",typeField = "textbox")
    private String f605y;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "601z",typeField = "textbox")
    private String f601z;

    /**
     * НАчальный элемент ввода
     */
    @ApiFormField(nameField = "606a",typeField = "textbox")
    private String f606a;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "606x",typeField = "textbox")
    private String f606x;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "606y",typeField = "textbox")
    private String f606y;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "606z",typeField = "textbox")
    private String f606z;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "607a",typeField = "textbox")
    private String f607a;

    /**
     * Тематическая подрубрика
     */
    @ApiFormField(nameField = "607x",typeField = "textbox")
    private String f607x;

    /**
     * Географическая подрубрика
     */
    @ApiFormField(nameField = "607y",typeField = "textbox")
    private String f607y;

    /**
     * Хронологическая подрубрика
     */
    @ApiFormField(nameField = "607z",typeField = "textbox")
    private String f607z;

    /**
     * Издание
     */
    @ApiFormField(nameField = "675v",typeField = "textbox")
    private String f675v;

    /**
     * Язык издания
     */
    @ApiFormField(nameField = "675z",typeField = "textbox")
    private String f675z;

    /**
     * Индекс классификации
     */
    @ApiFormField(nameField = "686a",typeField = "textbox")
    private String f686a;

    /**
     * Книжный номер
     */
    @ApiFormField(nameField = "686b",typeField = "textbox")
    private String f686b;

    /**
     * Классификационная подрубрика
     */
    @ApiFormField(nameField = "686c",typeField = "textbox")
    private String f686c;

    /**
     * Код системы
     */
    @ApiFormField(nameField = "6862",typeField = "textbox")
    private String f6862;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "700b",typeField = "textbox")
    private String f700b;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "700c",typeField = "textbox")
    private String f700c;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "700d",typeField = "textbox")
    private String f700d;

    /**
     * Даты
     */
    @ApiFormField(nameField = "700f",typeField = "textbox")
    private String f700f;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "700g",typeField = "textbox")
    private String f700g;

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
    @ApiFormField(nameField = "7004",typeField = "textbox")
    private String f7004;

    /**
     * Начальный элемент ввода (Фамилия)
     */
    @ApiFormField(nameField = "701a",typeField = "textbox")
    private String f701a;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "701b",typeField = "textbox")
    private String f701b;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "701c",typeField = "textbox")
    private String f701c;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "701d",typeField = "textbox")
    private String f701d;

    /**
     * Даты
     */
    @ApiFormField(nameField = "701f",typeField = "textbox")
    private String f701f;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "701g",typeField = "textbox")
    private String f701g;

    /**
     * Место работы/адрес
     */
    @ApiFormField(nameField = "701p",typeField = "textbox")
    private String f701p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7013",typeField = "textbox")
    private String f7013;

    /**
     * Код отношений
     */
    @ApiFormField(nameField = "7014",typeField = "textbox")
    private String f7014;

    /**
     * Начальный элемент ввода (Фамилия)
     */
    @ApiFormField(nameField = "702a",typeField = "textbox")
    private String f702a;

    /**
     * Часть имени, кроме начального элемента ввода
     */
    @ApiFormField(nameField = "702b",typeField = "textbox")
    private String f702b;

    /**
     * Дополнения к именам, кроме дат
     */
    @ApiFormField(nameField = "702c",typeField = "textbox")
    private String f702c;

    /**
     * Римские цифры
     */
    @ApiFormField(nameField = "702d",typeField = "textbox")
    private String f702d;

    /**
     * Даты
     */
    @ApiFormField(nameField = "702f",typeField = "textbox")
    private String f702f;

    /**
     * Расширение инициалов личного имени
     */
    @ApiFormField(nameField = "702g",typeField = "textbox")
    private String f702g;

    /**
     * Место работы/адрес
     */
    @ApiFormField(nameField = "702p",typeField = "textbox")
    private String f702p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7023",typeField = "textbox")
    private String f7023;

    /**
     * Код отношений
     */
    @ApiFormField(nameField = "7024",typeField = "textbox")
    private String f7024;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "710a",typeField = "textbox")
    private String f710a;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "710b",typeField = "textbox")
    private String f710b;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "710c",typeField = "textbox")
    private String f710c;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "710d",typeField = "textbox")
    private String f710d;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "710e",typeField = "textbox")
    private String f710e;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "710f",typeField = "textbox")
    private String f710f;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "710g",typeField = "textbox")
    private String f710g;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "710h",typeField = "textbox")
    private String f710h;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "710p",typeField = "textbox")
    private String f710p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7103",typeField = "textbox")
    private String f7103;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "711a",typeField = "textbox")
    private String f711a;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "711b",typeField = "textbox")
    private String f711b;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "711c",typeField = "textbox")
    private String f711c;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "711d",typeField = "textbox")
    private String f711d;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "711e",typeField = "textbox")
    private String f711e;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "711f",typeField = "textbox")
    private String f711f;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "711g",typeField = "textbox")
    private String f711g;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "711h",typeField = "textbox")
    private String f711h;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "711p",typeField = "textbox")
    private String f711p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7113",typeField = "textbox")
    private String f7113;

    /**
     * Начальный элемент ввода
     */
    @ApiFormField(nameField = "712a",typeField = "textbox")
    private String f712a;

    /**
     * Подразделение
     */
    @ApiFormField(nameField = "712b",typeField = "textbox")
    private String f712b;

    /**
     * Дополнение к наименованию или уточнения
     */
    @ApiFormField(nameField = "712c",typeField = "textbox")
    private String f712c;

    /**
     * Номер совещания
     */
    @ApiFormField(nameField = "712d",typeField = "textbox")
    private String f712d;

    /**
     * Место проведения совещания
     */
    @ApiFormField(nameField = "712e",typeField = "textbox")
    private String f712e;

    /**
     * Дата совещания
     */
    @ApiFormField(nameField = "712f",typeField = "textbox")
    private String f712f;

    /**
     * Инвертированный элемент
     */
    @ApiFormField(nameField = "712g",typeField = "textbox")
    private String f712g;

    /**
     * Часть наименования, отличная от начального элемента ввода и инвертированного элемента
     */
    @ApiFormField(nameField = "712h",typeField = "textbox")
    private String f712h;

    /**
     * Местонахождение организации
     */
    @ApiFormField(nameField = "712p",typeField = "textbox")
    private String f712p;

    /**
     * Номер авторитетной записи
     */
    @ApiFormField(nameField = "7123",typeField = "textbox")
    private String f7123;

    /**
     * Страна
     */
    @ApiFormField(nameField = "801a",typeField = "textbox")
    private String f801a;

    /**
     * Агентство
     */
    @ApiFormField(nameField = "801b",typeField = "textbox")
    private String f801b;

    /**
     * Дата составления
     */
    @ApiFormField(nameField = "801c",typeField = "textbox")
    private String f801c;

    /**
     * Имя хоста
     */
    @ApiFormField(nameField = "856a",typeField = "textbox")
    private String f856a;

    /**
     * Номер доступа
     */
    @ApiFormField(nameField = "856b",typeField = "textbox")
    private String f856b;

    /**
     * Сжатая информация
     */
    @ApiFormField(nameField = "856c",typeField = "textbox")
    private String f856c;

    /**
     * Дорожка
     */
    @ApiFormField(nameField = "856d",typeField = "textbox")
    private String f856d;

    /**
     * Дата и час консультации и доступа
     */
    @ApiFormField(nameField = "856e",typeField = "textbox")
    private String f856e;

    /**
     * Электронное название
     */
    @ApiFormField(nameField = "856f",typeField = "textbox")
    private String f856f;

    /**
     * Просессор запроса
     */
    @ApiFormField(nameField = "856g",typeField = "textbox")
    private String f856g;

    /**
     * Инструкции
     */
    @ApiFormField(nameField = "856h",typeField = "textbox")
    private String f856h;

    /**
     * Биты в секунду
     */
    @ApiFormField(nameField = "856i",typeField = "textbox")
    private String f856i;

    /**
     * Пароль
     */
    @ApiFormField(nameField = "856j",typeField = "textbox")
    private String f856j;

    /**
     * Вход в систему/логин
     */
    @ApiFormField(nameField = "856k",typeField = "textbox")
    private String f856k;

    /**
     * Контакты для помощи в доступе
     */
    @ApiFormField(nameField = "856l",typeField = "textbox")
    private String f856l;

    /**
     * Наименование месторасположения хоста
     */
    @ApiFormField(nameField = "856m",typeField = "textbox")
    private String f856m;

    /**
     * Операционная система
     */
    @ApiFormField(nameField = "856n",typeField = "textbox")
    private String f856n;

    /**
     * Порт
     */
    @ApiFormField(nameField = "856o",typeField = "textbox")
    private String f856o;

    /**
     * Электронный тип формата
     */
    @ApiFormField(nameField = "856p",typeField = "textbox")
    private String f856p;

    /**
     * Параметры настройки
     */
    @ApiFormField(nameField = "856q",typeField = "textbox")
    private String f856q;

    /**
     * Размер файла
     */
    @ApiFormField(nameField = "856r",typeField = "textbox")
    private String f856r;

    /**
     * Предельная эмуляция
     */
    @ApiFormField(nameField = "856s",typeField = "textbox")
    private String f856s;

    /**
     * Часы доступа
     */
    @ApiFormField(nameField = "856u",typeField = "textbox")
    private String f856u;

    /**
     * Номер контрольной записи
     */
    @ApiFormField(nameField = "856w",typeField = "textbox")
    private String f856w;

    /**
     * Непубличное примечание
     */
    @ApiFormField(nameField = "856x",typeField = "textbox")
    private String f856x;

    /**
     * Метод доступа
     */
    @ApiFormField(nameField = "856y",typeField = "textbox")
    private String f856y;

    /**
     * Публичное примечание
     */
    @ApiFormField(nameField = "856z",typeField = "textbox")
    private String f856z;

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
     * Алфавитный указатель
     */
    @ApiFormField(nameField = "909a",typeField = "textbox")
    private String f909a;

    /**
     * Тематический рубрика
     */
    @ApiFormField(nameField = "909b",typeField = "textbox")
    private String f909b;

    /**
     * Номер гос.регистрации
     */
    @ApiFormField(nameField = "912a",typeField = "textbox")
    private String f912a;

    public List<String> getF320a() {
        return f320a;
    }

    public void setF320a(List<String> f320a) {
        this.f320a = f320a;
    }

    public List<String> getF610a() {
        return f610a;
    }

    public void setF610a(List<String> f610a) {
        this.f610a = f610a;
    }

    public List<String> getF700a() {
        return f700a;
    }

    public void setF700a(List<String> f700a) {
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

    public String getF001() {
        return f001;
    }

    public void setF001(String f001) {
        this.f001 = f001;
    }

    public String getF010b() {
        return f010b;
    }

    public void setF010b(String f010b) {
        this.f010b = f010b;
    }

    public String getF010z() {
        return f010z;
    }

    public void setF010z(String f010z) {
        this.f010z = f010z;
    }

    public String getF011a() {
        return f011a;
    }

    public void setF011a(String f011a) {
        this.f011a = f011a;
    }

    public String getF011b() {
        return f011b;
    }

    public void setF011b(String f011b) {
        this.f011b = f011b;
    }

    public String getF011d() {
        return f011d;
    }

    public void setF011d(String f011d) {
        this.f011d = f011d;
    }

    public String getF011y() {
        return f011y;
    }

    public void setF011y(String f011y) {
        this.f011y = f011y;
    }

    public String getF011z() {
        return f011z;
    }

    public void setF011z(String f011z) {
        this.f011z = f011z;
    }

    public String getF012a() {
        return f012a;
    }

    public void setF012a(String f012a) {
        this.f012a = f012a;
    }

    public String getF0122() {
        return f0122;
    }

    public void setF0122(String f0122) {
        this.f0122 = f0122;
    }

    public String getF0125() {
        return f0125;
    }

    public void setF0125(String f0125) {
        this.f0125 = f0125;
    }

    public String getF013a() {
        return f013a;
    }

    public void setF013a(String f013a) {
        this.f013a = f013a;
    }

    public String getF013b() {
        return f013b;
    }

    public void setF013b(String f013b) {
        this.f013b = f013b;
    }

    public String getF013d() {
        return f013d;
    }

    public void setF013d(String f013d) {
        this.f013d = f013d;
    }

    public String getF013z() {
        return f013z;
    }

    public void setF013z(String f013z) {
        this.f013z = f013z;
    }

    public String getF014a() {
        return f014a;
    }

    public void setF014a(String f014a) {
        this.f014a = f014a;
    }

    public String getF014z() {
        return f014z;
    }

    public void setF014z(String f014z) {
        this.f014z = f014z;
    }

    public String getF0142() {
        return f0142;
    }

    public void setF0142(String f0142) {
        this.f0142 = f0142;
    }

    public String getF015a() {
        return f015a;
    }

    public void setF015a(String f015a) {
        this.f015a = f015a;
    }

    public String getF015b() {
        return f015b;
    }

    public void setF015b(String f015b) {
        this.f015b = f015b;
    }

    public String getF015d() {
        return f015d;
    }

    public void setF015d(String f015d) {
        this.f015d = f015d;
    }

    public String getF015z() {
        return f015z;
    }

    public void setF015z(String f015z) {
        this.f015z = f015z;
    }

    public String getF016a() {
        return f016a;
    }

    public void setF016a(String f016a) {
        this.f016a = f016a;
    }

    public String getF016b() {
        return f016b;
    }

    public void setF016b(String f016b) {
        this.f016b = f016b;
    }

    public String getF016d() {
        return f016d;
    }

    public void setF016d(String f016d) {
        this.f016d = f016d;
    }

    public String getF016z() {
        return f016z;
    }

    public void setF016z(String f016z) {
        this.f016z = f016z;
    }

    public String getF020a() {
        return f020a;
    }

    public void setF020a(String f020a) {
        this.f020a = f020a;
    }

    public String getF020b() {
        return f020b;
    }

    public void setF020b(String f020b) {
        this.f020b = f020b;
    }

    public String getF020z() {
        return f020z;
    }

    public void setF020z(String f020z) {
        this.f020z = f020z;
    }

    public String getF021a() {
        return f021a;
    }

    public void setF021a(String f021a) {
        this.f021a = f021a;
    }

    public String getF021b() {
        return f021b;
    }

    public void setF021b(String f021b) {
        this.f021b = f021b;
    }

    public String getF021z() {
        return f021z;
    }

    public void setF021z(String f021z) {
        this.f021z = f021z;
    }

    public String getF022a() {
        return f022a;
    }

    public void setF022a(String f022a) {
        this.f022a = f022a;
    }

    public String getF022b() {
        return f022b;
    }

    public void setF022b(String f022b) {
        this.f022b = f022b;
    }

    public String getF022z() {
        return f022z;
    }

    public void setF022z(String f022z) {
        this.f022z = f022z;
    }

    public String getF035a() {
        return f035a;
    }

    public void setF035a(String f035a) {
        this.f035a = f035a;
    }

    public String getF035z() {
        return f035z;
    }

    public void setF035z(String f035z) {
        this.f035z = f035z;
    }

    public String getF100a() {
        return f100a;
    }

    public void setF100a(String f100a) {
        this.f100a = f100a;
    }

    public String getF100a_1() {
        return f100a_1;
    }

    public void setF100a_1(String f100a_1) {
        this.f100a_1 = f100a_1;
    }

    public String getF100a_2() {
        return f100a_2;
    }

    public void setF100a_2(String f100a_2) {
        this.f100a_2 = f100a_2;
    }

    public String getF100a_3() {
        return f100a_3;
    }

    public void setF100a_3(String f100a_3) {
        this.f100a_3 = f100a_3;
    }

    public String getF100a_4() {
        return f100a_4;
    }

    public void setF100a_4(String f100a_4) {
        this.f100a_4 = f100a_4;
    }

    public String getF100a_5() {
        return f100a_5;
    }

    public void setF100a_5(String f100a_5) {
        this.f100a_5 = f100a_5;
    }

    public String getF100a_6() {
        return f100a_6;
    }

    public void setF100a_6(String f100a_6) {
        this.f100a_6 = f100a_6;
    }

    public String getF100a_7() {
        return f100a_7;
    }

    public void setF100a_7(String f100a_7) {
        this.f100a_7 = f100a_7;
    }

    public String getF100a_8() {
        return f100a_8;
    }

    public void setF100a_8(String f100a_8) {
        this.f100a_8 = f100a_8;
    }

    public String getF100a_9() {
        return f100a_9;
    }

    public void setF100a_9(String f100a_9) {
        this.f100a_9 = f100a_9;
    }

    public String getF100a_10() {
        return f100a_10;
    }

    public void setF100a_10(String f100a_10) {
        this.f100a_10 = f100a_10;
    }

    public String getF100a_11() {
        return f100a_11;
    }

    public void setF100a_11(String f100a_11) {
        this.f100a_11 = f100a_11;
    }

    public String getF100a_12() {
        return f100a_12;
    }

    public void setF100a_12(String f100a_12) {
        this.f100a_12 = f100a_12;
    }

    public String getF101d() {
        return f101d;
    }

    public void setF101d(String f101d) {
        this.f101d = f101d;
    }

    public String getF101e() {
        return f101e;
    }

    public void setF101e(String f101e) {
        this.f101e = f101e;
    }

    public String getF101b() {
        return f101b;
    }

    public void setF101b(String f101b) {
        this.f101b = f101b;
    }

    public String getF101c() {
        return f101c;
    }

    public void setF101c(String f101c) {
        this.f101c = f101c;
    }

    public String getF101g() {
        return f101g;
    }

    public void setF101g(String f101g) {
        this.f101g = f101g;
    }

    public String getF101h() {
        return f101h;
    }

    public void setF101h(String f101h) {
        this.f101h = f101h;
    }

    public String getF101i() {
        return f101i;
    }

    public void setF101i(String f101i) {
        this.f101i = f101i;
    }

    public String getF101j() {
        return f101j;
    }

    public void setF101j(String f101j) {
        this.f101j = f101j;
    }

    public String getF102a() {
        return f102a;
    }

    public void setF102a(String f102a) {
        this.f102a = f102a;
    }

    public String getF105a() {
        return f105a;
    }

    public void setF105a(String f105a) {
        this.f105a = f105a;
    }

    public String getF105a_1() {
        return f105a_1;
    }

    public void setF105a_1(String f105a_1) {
        this.f105a_1 = f105a_1;
    }

    public String getF105a_2() {
        return f105a_2;
    }

    public void setF105a_2(String f105a_2) {
        this.f105a_2 = f105a_2;
    }

    public String getF105a_3() {
        return f105a_3;
    }

    public void setF105a_3(String f105a_3) {
        this.f105a_3 = f105a_3;
    }

    public String getF105a_4() {
        return f105a_4;
    }

    public void setF105a_4(String f105a_4) {
        this.f105a_4 = f105a_4;
    }

    public String getF105a_5() {
        return f105a_5;
    }

    public void setF105a_5(String f105a_5) {
        this.f105a_5 = f105a_5;
    }

    public String getF105a_6() {
        return f105a_6;
    }

    public void setF105a_6(String f105a_6) {
        this.f105a_6 = f105a_6;
    }

    public String getF105a_7() {
        return f105a_7;
    }

    public void setF105a_7(String f105a_7) {
        this.f105a_7 = f105a_7;
    }

    public String getF110a() {
        return f110a;
    }

    public void setF110a(String f110a) {
        this.f110a = f110a;
    }

    public String getF110a_1() {
        return f110a_1;
    }

    public void setF110a_1(String f110a_1) {
        this.f110a_1 = f110a_1;
    }

    public String getF110a_2() {
        return f110a_2;
    }

    public void setF110a_2(String f110a_2) {
        this.f110a_2 = f110a_2;
    }

    public String getF110a_3() {
        return f110a_3;
    }

    public void setF110a_3(String f110a_3) {
        this.f110a_3 = f110a_3;
    }

    public String getF110a_4() {
        return f110a_4;
    }

    public void setF110a_4(String f110a_4) {
        this.f110a_4 = f110a_4;
    }

    public String getF110a_5() {
        return f110a_5;
    }

    public void setF110a_5(String f110a_5) {
        this.f110a_5 = f110a_5;
    }

    public String getF110a_6() {
        return f110a_6;
    }

    public void setF110a_6(String f110a_6) {
        this.f110a_6 = f110a_6;
    }

    public String getF110a_7() {
        return f110a_7;
    }

    public void setF110a_7(String f110a_7) {
        this.f110a_7 = f110a_7;
    }

    public String getF110a_8() {
        return f110a_8;
    }

    public void setF110a_8(String f110a_8) {
        this.f110a_8 = f110a_8;
    }

    public String getF110a_9() {
        return f110a_9;
    }

    public void setF110a_9(String f110a_9) {
        this.f110a_9 = f110a_9;
    }

    public String getF115a() {
        return f115a;
    }

    public void setF115a(String f115a) {
        this.f115a = f115a;
    }

    public String getF115a_1() {
        return f115a_1;
    }

    public void setF115a_1(String f115a_1) {
        this.f115a_1 = f115a_1;
    }

    public String getF115a_12() {
        return f115a_12;
    }

    public void setF115a_12(String f115a_12) {
        this.f115a_12 = f115a_12;
    }

    public String getF115a_13() {
        return f115a_13;
    }

    public void setF115a_13(String f115a_13) {
        this.f115a_13 = f115a_13;
    }

    public String getF115a_14() {
        return f115a_14;
    }

    public void setF115a_14(String f115a_14) {
        this.f115a_14 = f115a_14;
    }

    public String getF115a_15() {
        return f115a_15;
    }

    public void setF115a_15(String f115a_15) {
        this.f115a_15 = f115a_15;
    }

    public String getF115b() {
        return f115b;
    }

    public void setF115b(String f115b) {
        this.f115b = f115b;
    }

    public String getF115b_1() {
        return f115b_1;
    }

    public void setF115b_1(String f115b_1) {
        this.f115b_1 = f115b_1;
    }

    public String getF115b_2() {
        return f115b_2;
    }

    public void setF115b_2(String f115b_2) {
        this.f115b_2 = f115b_2;
    }

    public String getF115b_3() {
        return f115b_3;
    }

    public void setF115b_3(String f115b_3) {
        this.f115b_3 = f115b_3;
    }

    public String getF115b_4() {
        return f115b_4;
    }

    public void setF115b_4(String f115b_4) {
        this.f115b_4 = f115b_4;
    }

    public String getF115b_5() {
        return f115b_5;
    }

    public void setF115b_5(String f115b_5) {
        this.f115b_5 = f115b_5;
    }

    public String getF115b_6() {
        return f115b_6;
    }

    public void setF115b_6(String f115b_6) {
        this.f115b_6 = f115b_6;
    }

    public String getF115b_7() {
        return f115b_7;
    }

    public void setF115b_7(String f115b_7) {
        this.f115b_7 = f115b_7;
    }

    public String getF115b_8() {
        return f115b_8;
    }

    public void setF115b_8(String f115b_8) {
        this.f115b_8 = f115b_8;
    }

    public String getF115b_9() {
        return f115b_9;
    }

    public void setF115b_9(String f115b_9) {
        this.f115b_9 = f115b_9;
    }

    public String getF115b_10() {
        return f115b_10;
    }

    public void setF115b_10(String f115b_10) {
        this.f115b_10 = f115b_10;
    }

    public String getF115a_2() {
        return f115a_2;
    }

    public void setF115a_2(String f115a_2) {
        this.f115a_2 = f115a_2;
    }

    public String getF115a_3() {
        return f115a_3;
    }

    public void setF115a_3(String f115a_3) {
        this.f115a_3 = f115a_3;
    }

    public String getF115a_4() {
        return f115a_4;
    }

    public void setF115a_4(String f115a_4) {
        this.f115a_4 = f115a_4;
    }

    public String getF115a_5() {
        return f115a_5;
    }

    public void setF115a_5(String f115a_5) {
        this.f115a_5 = f115a_5;
    }

    public String getF115a_6() {
        return f115a_6;
    }

    public void setF115a_6(String f115a_6) {
        this.f115a_6 = f115a_6;
    }

    public String getF115a_7() {
        return f115a_7;
    }

    public void setF115a_7(String f115a_7) {
        this.f115a_7 = f115a_7;
    }

    public String getF115a_8() {
        return f115a_8;
    }

    public void setF115a_8(String f115a_8) {
        this.f115a_8 = f115a_8;
    }

    public String getF115a_9() {
        return f115a_9;
    }

    public void setF115a_9(String f115a_9) {
        this.f115a_9 = f115a_9;
    }

    public String getF115a_10() {
        return f115a_10;
    }

    public void setF115a_10(String f115a_10) {
        this.f115a_10 = f115a_10;
    }

    public String getF115a_11() {
        return f115a_11;
    }

    public void setF115a_11(String f115a_11) {
        this.f115a_11 = f115a_11;
    }

    public String getF135() {
        return f135;
    }

    public void setF135(String f135) {
        this.f135 = f135;
    }

    public String getF200c() {
        return f200c;
    }

    public void setF200c(String f200c) {
        this.f200c = f200c;
    }

    public String getF200g() {
        return f200g;
    }

    public void setF200g(String f200g) {
        this.f200g = f200g;
    }

    public String getF200v() {
        return f200v;
    }

    public void setF200v(String f200v) {
        this.f200v = f200v;
    }

    public String getF205b() {
        return f205b;
    }

    public void setF205b(String f205b) {
        this.f205b = f205b;
    }

    public String getF205f() {
        return f205f;
    }

    public void setF205f(String f205f) {
        this.f205f = f205f;
    }

    public String getF207z() {
        return f207z;
    }

    public void setF207z(String f207z) {
        this.f207z = f207z;
    }

    public String getF215d() {
        return f215d;
    }

    public void setF215d(String f215d) {
        this.f215d = f215d;
    }

    public String getF225d() {
        return f225d;
    }

    public void setF225d(String f225d) {
        this.f225d = f225d;
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

    public String getF225h() {
        return f225h;
    }

    public void setF225h(String f225h) {
        this.f225h = f225h;
    }

    public String getF225i() {
        return f225i;
    }

    public void setF225i(String f225i) {
        this.f225i = f225i;
    }

    public String getF225z() {
        return f225z;
    }

    public void setF225z(String f225z) {
        this.f225z = f225z;
    }

    public String getF225v() {
        return f225v;
    }

    public void setF225v(String f225v) {
        this.f225v = f225v;
    }

    public String getF225x() {
        return f225x;
    }

    public void setF225x(String f225x) {
        this.f225x = f225x;
    }

    public String getF301a() {
        return f301a;
    }

    public void setF301a(String f301a) {
        this.f301a = f301a;
    }

    public String getF302a() {
        return f302a;
    }

    public void setF302a(String f302a) {
        this.f302a = f302a;
    }

    public String getF303a() {
        return f303a;
    }

    public void setF303a(String f303a) {
        this.f303a = f303a;
    }

    public String getF304a() {
        return f304a;
    }

    public void setF304a(String f304a) {
        this.f304a = f304a;
    }

    public String getF305a() {
        return f305a;
    }

    public void setF305a(String f305a) {
        this.f305a = f305a;
    }

    public String getF306a() {
        return f306a;
    }

    public void setF306a(String f306a) {
        this.f306a = f306a;
    }

    public String getF307a() {
        return f307a;
    }

    public void setF307a(String f307a) {
        this.f307a = f307a;
    }

    public String getF308a() {
        return f308a;
    }

    public void setF308a(String f308a) {
        this.f308a = f308a;
    }

    public String getF310a() {
        return f310a;
    }

    public void setF310a(String f310a) {
        this.f310a = f310a;
    }

    public String getF311a() {
        return f311a;
    }

    public void setF311a(String f311a) {
        this.f311a = f311a;
    }

    public String getF312a() {
        return f312a;
    }

    public void setF312a(String f312a) {
        this.f312a = f312a;
    }

    public String getF313a() {
        return f313a;
    }

    public void setF313a(String f313a) {
        this.f313a = f313a;
    }

    public String getF314a() {
        return f314a;
    }

    public void setF314a(String f314a) {
        this.f314a = f314a;
    }

    public String getF315a() {
        return f315a;
    }

    public void setF315a(String f315a) {
        this.f315a = f315a;
    }

    public String getF316a() {
        return f316a;
    }

    public void setF316a(String f316a) {
        this.f316a = f316a;
    }

    public String getF3165() {
        return f3165;
    }

    public void setF3165(String f3165) {
        this.f3165 = f3165;
    }

    public String getF317a() {
        return f317a;
    }

    public void setF317a(String f317a) {
        this.f317a = f317a;
    }

    public String getF3175() {
        return f3175;
    }

    public void setF3175(String f3175) {
        this.f3175 = f3175;
    }

    public String getF318a() {
        return f318a;
    }

    public void setF318a(String f318a) {
        this.f318a = f318a;
    }

    public String getF318b() {
        return f318b;
    }

    public void setF318b(String f318b) {
        this.f318b = f318b;
    }

    public String getF318c() {
        return f318c;
    }

    public void setF318c(String f318c) {
        this.f318c = f318c;
    }

    public String getF318d() {
        return f318d;
    }

    public void setF318d(String f318d) {
        this.f318d = f318d;
    }

    public String getF318e() {
        return f318e;
    }

    public void setF318e(String f318e) {
        this.f318e = f318e;
    }

    public String getF318f() {
        return f318f;
    }

    public void setF318f(String f318f) {
        this.f318f = f318f;
    }

    public String getF318h() {
        return f318h;
    }

    public void setF318h(String f318h) {
        this.f318h = f318h;
    }

    public String getF318i() {
        return f318i;
    }

    public void setF318i(String f318i) {
        this.f318i = f318i;
    }

    public String getF318j() {
        return f318j;
    }

    public void setF318j(String f318j) {
        this.f318j = f318j;
    }

    public String getF318k() {
        return f318k;
    }

    public void setF318k(String f318k) {
        this.f318k = f318k;
    }

    public String getF318l() {
        return f318l;
    }

    public void setF318l(String f318l) {
        this.f318l = f318l;
    }

    public String getF318n() {
        return f318n;
    }

    public void setF318n(String f318n) {
        this.f318n = f318n;
    }

    public String getF318o() {
        return f318o;
    }

    public void setF318o(String f318o) {
        this.f318o = f318o;
    }

    public String getF318p() {
        return f318p;
    }

    public void setF318p(String f318p) {
        this.f318p = f318p;
    }

    public String getF318r() {
        return f318r;
    }

    public void setF318r(String f318r) {
        this.f318r = f318r;
    }

    public String getF3185() {
        return f3185;
    }

    public void setF3185(String f3185) {
        this.f3185 = f3185;
    }

    public String getF321a() {
        return f321a;
    }

    public void setF321a(String f321a) {
        this.f321a = f321a;
    }

    public String getF321b() {
        return f321b;
    }

    public void setF321b(String f321b) {
        this.f321b = f321b;
    }

    public String getF321x() {
        return f321x;
    }

    public void setF321x(String f321x) {
        this.f321x = f321x;
    }

    public String getF322a() {
        return f322a;
    }

    public void setF322a(String f322a) {
        this.f322a = f322a;
    }

    public String getF323a() {
        return f323a;
    }

    public void setF323a(String f323a) {
        this.f323a = f323a;
    }

    public String getF324a() {
        return f324a;
    }

    public void setF324a(String f324a) {
        this.f324a = f324a;
    }

    public String getF325a() {
        return f325a;
    }

    public void setF325a(String f325a) {
        this.f325a = f325a;
    }

    public String getF326a() {
        return f326a;
    }

    public void setF326a(String f326a) {
        this.f326a = f326a;
    }

    public String getF326b() {
        return f326b;
    }

    public void setF326b(String f326b) {
        this.f326b = f326b;
    }

    public String getF328a() {
        return f328a;
    }

    public void setF328a(String f328a) {
        this.f328a = f328a;
    }

    public String getF330a() {
        return f330a;
    }

    public void setF330a(String f330a) {
        this.f330a = f330a;
    }

    public String getF331a() {
        return f331a;
    }

    public void setF331a(String f331a) {
        this.f331a = f331a;
    }

    public String getF332a() {
        return f332a;
    }

    public void setF332a(String f332a) {
        this.f332a = f332a;
    }

    public String getF333a() {
        return f333a;
    }

    public void setF333a(String f333a) {
        this.f333a = f333a;
    }

    public String getF336a() {
        return f336a;
    }

    public void setF336a(String f336a) {
        this.f336a = f336a;
    }

    public String getF337a() {
        return f337a;
    }

    public void setF337a(String f337a) {
        this.f337a = f337a;
    }

    public String getF345a() {
        return f345a;
    }

    public void setF345a(String f345a) {
        this.f345a = f345a;
    }

    public String getF345b() {
        return f345b;
    }

    public void setF345b(String f345b) {
        this.f345b = f345b;
    }

    public String getF345c() {
        return f345c;
    }

    public void setF345c(String f345c) {
        this.f345c = f345c;
    }

    public String getF345d() {
        return f345d;
    }

    public void setF345d(String f345d) {
        this.f345d = f345d;
    }

    public String getF410() {
        return f410;
    }

    public void setF410(String f410) {
        this.f410 = f410;
    }

    public String getF411() {
        return f411;
    }

    public void setF411(String f411) {
        this.f411 = f411;
    }

    public String getF421() {
        return f421;
    }

    public void setF421(String f421) {
        this.f421 = f421;
    }

    public String getF422() {
        return f422;
    }

    public void setF422(String f422) {
        this.f422 = f422;
    }

    public String getF453() {
        return f453;
    }

    public void setF453(String f453) {
        this.f453 = f453;
    }

    public String getF454() {
        return f454;
    }

    public void setF454(String f454) {
        this.f454 = f454;
    }

    public String getF461() {
        return f461;
    }

    public void setF461(String f461) {
        this.f461 = f461;
    }

    public String getF4631() {
        return f4631;
    }

    public void setF4631(String f4631) {
        this.f4631 = f4631;
    }

    public String getF500a() {
        return f500a;
    }

    public void setF500a(String f500a) {
        this.f500a = f500a;
    }

    public String getF500b() {
        return f500b;
    }

    public void setF500b(String f500b) {
        this.f500b = f500b;
    }

    public String getF500h() {
        return f500h;
    }

    public void setF500h(String f500h) {
        this.f500h = f500h;
    }

    public String getF500i() {
        return f500i;
    }

    public void setF500i(String f500i) {
        this.f500i = f500i;
    }

    public String getF500j() {
        return f500j;
    }

    public void setF500j(String f500j) {
        this.f500j = f500j;
    }

    public String getF500k() {
        return f500k;
    }

    public void setF500k(String f500k) {
        this.f500k = f500k;
    }

    public String getF500l() {
        return f500l;
    }

    public void setF500l(String f500l) {
        this.f500l = f500l;
    }

    public String getF500m() {
        return f500m;
    }

    public void setF500m(String f500m) {
        this.f500m = f500m;
    }

    public String getF500n() {
        return f500n;
    }

    public void setF500n(String f500n) {
        this.f500n = f500n;
    }

    public String getF500q() {
        return f500q;
    }

    public void setF500q(String f500q) {
        this.f500q = f500q;
    }

    public String getF500r() {
        return f500r;
    }

    public void setF500r(String f500r) {
        this.f500r = f500r;
    }

    public String getF500s() {
        return f500s;
    }

    public void setF500s(String f500s) {
        this.f500s = f500s;
    }

    public String getF500u() {
        return f500u;
    }

    public void setF500u(String f500u) {
        this.f500u = f500u;
    }

    public String getF500v() {
        return f500v;
    }

    public void setF500v(String f500v) {
        this.f500v = f500v;
    }

    public String getF500w() {
        return f500w;
    }

    public void setF500w(String f500w) {
        this.f500w = f500w;
    }

    public String getF500x() {
        return f500x;
    }

    public void setF500x(String f500x) {
        this.f500x = f500x;
    }

    public String getF500y() {
        return f500y;
    }

    public void setF500y(String f500y) {
        this.f500y = f500y;
    }

    public String getF500z() {
        return f500z;
    }

    public void setF500z(String f500z) {
        this.f500z = f500z;
    }

    public String getF5002() {
        return f5002;
    }

    public void setF5002(String f5002) {
        this.f5002 = f5002;
    }

    public String getF5003() {
        return f5003;
    }

    public void setF5003(String f5003) {
        this.f5003 = f5003;
    }

    public String getF501a() {
        return f501a;
    }

    public void setF501a(String f501a) {
        this.f501a = f501a;
    }

    public String getF501b() {
        return f501b;
    }

    public void setF501b(String f501b) {
        this.f501b = f501b;
    }

    public String getF501e() {
        return f501e;
    }

    public void setF501e(String f501e) {
        this.f501e = f501e;
    }

    public String getF501j() {
        return f501j;
    }

    public void setF501j(String f501j) {
        this.f501j = f501j;
    }

    public String getF501k() {
        return f501k;
    }

    public void setF501k(String f501k) {
        this.f501k = f501k;
    }

    public String getF501m() {
        return f501m;
    }

    public void setF501m(String f501m) {
        this.f501m = f501m;
    }

    public String getF501r() {
        return f501r;
    }

    public void setF501r(String f501r) {
        this.f501r = f501r;
    }

    public String getF501s() {
        return f501s;
    }

    public void setF501s(String f501s) {
        this.f501s = f501s;
    }

    public String getF501u() {
        return f501u;
    }

    public void setF501u(String f501u) {
        this.f501u = f501u;
    }

    public String getF501w() {
        return f501w;
    }

    public void setF501w(String f501w) {
        this.f501w = f501w;
    }

    public String getF501x() {
        return f501x;
    }

    public void setF501x(String f501x) {
        this.f501x = f501x;
    }

    public String getF501y() {
        return f501y;
    }

    public void setF501y(String f501y) {
        this.f501y = f501y;
    }

    public String getF501z() {
        return f501z;
    }

    public void setF501z(String f501z) {
        this.f501z = f501z;
    }

    public String getF5012() {
        return f5012;
    }

    public void setF5012(String f5012) {
        this.f5012 = f5012;
    }

    public String getF5013() {
        return f5013;
    }

    public void setF5013(String f5013) {
        this.f5013 = f5013;
    }

    public String getF502a() {
        return f502a;
    }

    public void setF502a(String f502a) {
        this.f502a = f502a;
    }

    public String getF502b() {
        return f502b;
    }

    public void setF502b(String f502b) {
        this.f502b = f502b;
    }

    public String getF502d() {
        return f502d;
    }

    public void setF502d(String f502d) {
        this.f502d = f502d;
    }

    public String getF502e() {
        return f502e;
    }

    public void setF502e(String f502e) {
        this.f502e = f502e;
    }

    public String getF502f() {
        return f502f;
    }

    public void setF502f(String f502f) {
        this.f502f = f502f;
    }

    public String getF502h() {
        return f502h;
    }

    public void setF502h(String f502h) {
        this.f502h = f502h;
    }

    public String getF502i() {
        return f502i;
    }

    public void setF502i(String f502i) {
        this.f502i = f502i;
    }

    public String getF502j() {
        return f502j;
    }

    public void setF502j(String f502j) {
        this.f502j = f502j;
    }

    public String getF502k() {
        return f502k;
    }

    public void setF502k(String f502k) {
        this.f502k = f502k;
    }

    public String getF502l() {
        return f502l;
    }

    public void setF502l(String f502l) {
        this.f502l = f502l;
    }

    public String getF502m() {
        return f502m;
    }

    public void setF502m(String f502m) {
        this.f502m = f502m;
    }

    public String getF502n() {
        return f502n;
    }

    public void setF502n(String f502n) {
        this.f502n = f502n;
    }

    public String getF510a() {
        return f510a;
    }

    public void setF510a(String f510a) {
        this.f510a = f510a;
    }

    public String getF510e() {
        return f510e;
    }

    public void setF510e(String f510e) {
        this.f510e = f510e;
    }

    public String getF510h() {
        return f510h;
    }

    public void setF510h(String f510h) {
        this.f510h = f510h;
    }

    public String getF510i() {
        return f510i;
    }

    public void setF510i(String f510i) {
        this.f510i = f510i;
    }

    public String getF510z() {
        return f510z;
    }

    public void setF510z(String f510z) {
        this.f510z = f510z;
    }

    public String getF512a() {
        return f512a;
    }

    public void setF512a(String f512a) {
        this.f512a = f512a;
    }

    public String getF512e() {
        return f512e;
    }

    public void setF512e(String f512e) {
        this.f512e = f512e;
    }

    public String getF513a() {
        return f513a;
    }

    public void setF513a(String f513a) {
        this.f513a = f513a;
    }

    public String getF513e() {
        return f513e;
    }

    public void setF513e(String f513e) {
        this.f513e = f513e;
    }

    public String getF513h() {
        return f513h;
    }

    public void setF513h(String f513h) {
        this.f513h = f513h;
    }

    public String getF513i() {
        return f513i;
    }

    public void setF513i(String f513i) {
        this.f513i = f513i;
    }

    public String getF520a() {
        return f520a;
    }

    public void setF520a(String f520a) {
        this.f520a = f520a;
    }

    public String getF520e() {
        return f520e;
    }

    public void setF520e(String f520e) {
        this.f520e = f520e;
    }

    public String getF520h() {
        return f520h;
    }

    public void setF520h(String f520h) {
        this.f520h = f520h;
    }

    public String getF520i() {
        return f520i;
    }

    public void setF520i(String f520i) {
        this.f520i = f520i;
    }

    public String getF520j() {
        return f520j;
    }

    public void setF520j(String f520j) {
        this.f520j = f520j;
    }

    public String getF520x() {
        return f520x;
    }

    public void setF520x(String f520x) {
        this.f520x = f520x;
    }

    public String getF530a() {
        return f530a;
    }

    public void setF530a(String f530a) {
        this.f530a = f530a;
    }

    public String getF530b() {
        return f530b;
    }

    public void setF530b(String f530b) {
        this.f530b = f530b;
    }

    public String getF541a() {
        return f541a;
    }

    public void setF541a(String f541a) {
        this.f541a = f541a;
    }

    public String getF541h() {
        return f541h;
    }

    public void setF541h(String f541h) {
        this.f541h = f541h;
    }

    public String getF541i() {
        return f541i;
    }

    public void setF541i(String f541i) {
        this.f541i = f541i;
    }

    public String getF541z() {
        return f541z;
    }

    public void setF541z(String f541z) {
        this.f541z = f541z;
    }

    public String getF600a() {
        return f600a;
    }

    public void setF600a(String f600a) {
        this.f600a = f600a;
    }

    public String getF600b() {
        return f600b;
    }

    public void setF600b(String f600b) {
        this.f600b = f600b;
    }

    public String getF600c() {
        return f600c;
    }

    public void setF600c(String f600c) {
        this.f600c = f600c;
    }

    public String getF600f() {
        return f600f;
    }

    public void setF600f(String f600f) {
        this.f600f = f600f;
    }

    public String getF600x() {
        return f600x;
    }

    public void setF600x(String f600x) {
        this.f600x = f600x;
    }

    public String getF601a() {
        return f601a;
    }

    public void setF601a(String f601a) {
        this.f601a = f601a;
    }

    public String getF601b() {
        return f601b;
    }

    public void setF601b(String f601b) {
        this.f601b = f601b;
    }

    public String getF601c() {
        return f601c;
    }

    public void setF601c(String f601c) {
        this.f601c = f601c;
    }

    public String getF601d() {
        return f601d;
    }

    public void setF601d(String f601d) {
        this.f601d = f601d;
    }

    public String getF601e() {
        return f601e;
    }

    public void setF601e(String f601e) {
        this.f601e = f601e;
    }

    public String getF601f() {
        return f601f;
    }

    public void setF601f(String f601f) {
        this.f601f = f601f;
    }

    public String getF601g() {
        return f601g;
    }

    public void setF601g(String f601g) {
        this.f601g = f601g;
    }

    public String getF601h() {
        return f601h;
    }

    public void setF601h(String f601h) {
        this.f601h = f601h;
    }

    public String getF601i() {
        return f601i;
    }

    public void setF601i(String f601i) {
        this.f601i = f601i;
    }

    public String getF605a() {
        return f605a;
    }

    public void setF605a(String f605a) {
        this.f605a = f605a;
    }

    public String getF605x() {
        return f605x;
    }

    public void setF605x(String f605x) {
        this.f605x = f605x;
    }

    public String getF605y() {
        return f605y;
    }

    public void setF605y(String f605y) {
        this.f605y = f605y;
    }

    public String getF601z() {
        return f601z;
    }

    public void setF601z(String f601z) {
        this.f601z = f601z;
    }

    public String getF606a() {
        return f606a;
    }

    public void setF606a(String f606a) {
        this.f606a = f606a;
    }

    public String getF606x() {
        return f606x;
    }

    public void setF606x(String f606x) {
        this.f606x = f606x;
    }

    public String getF606y() {
        return f606y;
    }

    public void setF606y(String f606y) {
        this.f606y = f606y;
    }

    public String getF606z() {
        return f606z;
    }

    public void setF606z(String f606z) {
        this.f606z = f606z;
    }

    public String getF607a() {
        return f607a;
    }

    public void setF607a(String f607a) {
        this.f607a = f607a;
    }

    public String getF607x() {
        return f607x;
    }

    public void setF607x(String f607x) {
        this.f607x = f607x;
    }

    public String getF607y() {
        return f607y;
    }

    public void setF607y(String f607y) {
        this.f607y = f607y;
    }

    public String getF607z() {
        return f607z;
    }

    public void setF607z(String f607z) {
        this.f607z = f607z;
    }

    public String getF675v() {
        return f675v;
    }

    public void setF675v(String f675v) {
        this.f675v = f675v;
    }

    public String getF675z() {
        return f675z;
    }

    public void setF675z(String f675z) {
        this.f675z = f675z;
    }

    public String getF686a() {
        return f686a;
    }

    public void setF686a(String f686a) {
        this.f686a = f686a;
    }

    public String getF686b() {
        return f686b;
    }

    public void setF686b(String f686b) {
        this.f686b = f686b;
    }

    public String getF686c() {
        return f686c;
    }

    public void setF686c(String f686c) {
        this.f686c = f686c;
    }

    public String getF6862() {
        return f6862;
    }

    public void setF6862(String f6862) {
        this.f6862 = f6862;
    }

    public String getF700b() {
        return f700b;
    }

    public void setF700b(String f700b) {
        this.f700b = f700b;
    }

    public String getF700c() {
        return f700c;
    }

    public void setF700c(String f700c) {
        this.f700c = f700c;
    }

    public String getF700d() {
        return f700d;
    }

    public void setF700d(String f700d) {
        this.f700d = f700d;
    }

    public String getF700f() {
        return f700f;
    }

    public void setF700f(String f700f) {
        this.f700f = f700f;
    }

    public String getF700g() {
        return f700g;
    }

    public void setF700g(String f700g) {
        this.f700g = f700g;
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

    public String getF7004() {
        return f7004;
    }

    public void setF7004(String f7004) {
        this.f7004 = f7004;
    }

    public String getF701a() {
        return f701a;
    }

    public void setF701a(String f701a) {
        this.f701a = f701a;
    }

    public String getF701b() {
        return f701b;
    }

    public void setF701b(String f701b) {
        this.f701b = f701b;
    }

    public String getF701c() {
        return f701c;
    }

    public void setF701c(String f701c) {
        this.f701c = f701c;
    }

    public String getF701d() {
        return f701d;
    }

    public void setF701d(String f701d) {
        this.f701d = f701d;
    }

    public String getF701f() {
        return f701f;
    }

    public void setF701f(String f701f) {
        this.f701f = f701f;
    }

    public String getF701g() {
        return f701g;
    }

    public void setF701g(String f701g) {
        this.f701g = f701g;
    }

    public String getF701p() {
        return f701p;
    }

    public void setF701p(String f701p) {
        this.f701p = f701p;
    }

    public String getF7013() {
        return f7013;
    }

    public void setF7013(String f7013) {
        this.f7013 = f7013;
    }

    public String getF7014() {
        return f7014;
    }

    public void setF7014(String f7014) {
        this.f7014 = f7014;
    }

    public String getF702a() {
        return f702a;
    }

    public void setF702a(String f702a) {
        this.f702a = f702a;
    }

    public String getF702b() {
        return f702b;
    }

    public void setF702b(String f702b) {
        this.f702b = f702b;
    }

    public String getF702c() {
        return f702c;
    }

    public void setF702c(String f702c) {
        this.f702c = f702c;
    }

    public String getF702d() {
        return f702d;
    }

    public void setF702d(String f702d) {
        this.f702d = f702d;
    }

    public String getF702f() {
        return f702f;
    }

    public void setF702f(String f702f) {
        this.f702f = f702f;
    }

    public String getF702g() {
        return f702g;
    }

    public void setF702g(String f702g) {
        this.f702g = f702g;
    }

    public String getF702p() {
        return f702p;
    }

    public void setF702p(String f702p) {
        this.f702p = f702p;
    }

    public String getF7023() {
        return f7023;
    }

    public void setF7023(String f7023) {
        this.f7023 = f7023;
    }

    public String getF7024() {
        return f7024;
    }

    public void setF7024(String f7024) {
        this.f7024 = f7024;
    }

    public String getF710a() {
        return f710a;
    }

    public void setF710a(String f710a) {
        this.f710a = f710a;
    }

    public String getF710b() {
        return f710b;
    }

    public void setF710b(String f710b) {
        this.f710b = f710b;
    }

    public String getF710c() {
        return f710c;
    }

    public void setF710c(String f710c) {
        this.f710c = f710c;
    }

    public String getF710d() {
        return f710d;
    }

    public void setF710d(String f710d) {
        this.f710d = f710d;
    }

    public String getF710e() {
        return f710e;
    }

    public void setF710e(String f710e) {
        this.f710e = f710e;
    }

    public String getF710f() {
        return f710f;
    }

    public void setF710f(String f710f) {
        this.f710f = f710f;
    }

    public String getF710g() {
        return f710g;
    }

    public void setF710g(String f710g) {
        this.f710g = f710g;
    }

    public String getF710h() {
        return f710h;
    }

    public void setF710h(String f710h) {
        this.f710h = f710h;
    }

    public String getF710p() {
        return f710p;
    }

    public void setF710p(String f710p) {
        this.f710p = f710p;
    }

    public String getF7103() {
        return f7103;
    }

    public void setF7103(String f7103) {
        this.f7103 = f7103;
    }

    public String getF711a() {
        return f711a;
    }

    public void setF711a(String f711a) {
        this.f711a = f711a;
    }

    public String getF711b() {
        return f711b;
    }

    public void setF711b(String f711b) {
        this.f711b = f711b;
    }

    public String getF711c() {
        return f711c;
    }

    public void setF711c(String f711c) {
        this.f711c = f711c;
    }

    public String getF711d() {
        return f711d;
    }

    public void setF711d(String f711d) {
        this.f711d = f711d;
    }

    public String getF711e() {
        return f711e;
    }

    public void setF711e(String f711e) {
        this.f711e = f711e;
    }

    public String getF711f() {
        return f711f;
    }

    public void setF711f(String f711f) {
        this.f711f = f711f;
    }

    public String getF711g() {
        return f711g;
    }

    public void setF711g(String f711g) {
        this.f711g = f711g;
    }

    public String getF711h() {
        return f711h;
    }

    public void setF711h(String f711h) {
        this.f711h = f711h;
    }

    public String getF711p() {
        return f711p;
    }

    public void setF711p(String f711p) {
        this.f711p = f711p;
    }

    public String getF7113() {
        return f7113;
    }

    public void setF7113(String f7113) {
        this.f7113 = f7113;
    }

    public String getF712a() {
        return f712a;
    }

    public void setF712a(String f712a) {
        this.f712a = f712a;
    }

    public String getF712b() {
        return f712b;
    }

    public void setF712b(String f712b) {
        this.f712b = f712b;
    }

    public String getF712c() {
        return f712c;
    }

    public void setF712c(String f712c) {
        this.f712c = f712c;
    }

    public String getF712d() {
        return f712d;
    }

    public void setF712d(String f712d) {
        this.f712d = f712d;
    }

    public String getF712e() {
        return f712e;
    }

    public void setF712e(String f712e) {
        this.f712e = f712e;
    }

    public String getF712f() {
        return f712f;
    }

    public void setF712f(String f712f) {
        this.f712f = f712f;
    }

    public String getF712g() {
        return f712g;
    }

    public void setF712g(String f712g) {
        this.f712g = f712g;
    }

    public String getF712h() {
        return f712h;
    }

    public void setF712h(String f712h) {
        this.f712h = f712h;
    }

    public String getF712p() {
        return f712p;
    }

    public void setF712p(String f712p) {
        this.f712p = f712p;
    }

    public String getF7123() {
        return f7123;
    }

    public void setF7123(String f7123) {
        this.f7123 = f7123;
    }

    public String getF801a() {
        return f801a;
    }

    public void setF801a(String f801a) {
        this.f801a = f801a;
    }

    public String getF801b() {
        return f801b;
    }

    public void setF801b(String f801b) {
        this.f801b = f801b;
    }

    public String getF801c() {
        return f801c;
    }

    public void setF801c(String f801c) {
        this.f801c = f801c;
    }

    public String getF856a() {
        return f856a;
    }

    public void setF856a(String f856a) {
        this.f856a = f856a;
    }

    public String getF856b() {
        return f856b;
    }

    public void setF856b(String f856b) {
        this.f856b = f856b;
    }

    public String getF856c() {
        return f856c;
    }

    public void setF856c(String f856c) {
        this.f856c = f856c;
    }

    public String getF856d() {
        return f856d;
    }

    public void setF856d(String f856d) {
        this.f856d = f856d;
    }

    public String getF856e() {
        return f856e;
    }

    public void setF856e(String f856e) {
        this.f856e = f856e;
    }

    public String getF856f() {
        return f856f;
    }

    public void setF856f(String f856f) {
        this.f856f = f856f;
    }

    public String getF856g() {
        return f856g;
    }

    public void setF856g(String f856g) {
        this.f856g = f856g;
    }

    public String getF856h() {
        return f856h;
    }

    public void setF856h(String f856h) {
        this.f856h = f856h;
    }

    public String getF856i() {
        return f856i;
    }

    public void setF856i(String f856i) {
        this.f856i = f856i;
    }

    public String getF856j() {
        return f856j;
    }

    public void setF856j(String f856j) {
        this.f856j = f856j;
    }

    public String getF856k() {
        return f856k;
    }

    public void setF856k(String f856k) {
        this.f856k = f856k;
    }

    public String getF856l() {
        return f856l;
    }

    public void setF856l(String f856l) {
        this.f856l = f856l;
    }

    public String getF856m() {
        return f856m;
    }

    public void setF856m(String f856m) {
        this.f856m = f856m;
    }

    public String getF856n() {
        return f856n;
    }

    public void setF856n(String f856n) {
        this.f856n = f856n;
    }

    public String getF856o() {
        return f856o;
    }

    public void setF856o(String f856o) {
        this.f856o = f856o;
    }

    public String getF856p() {
        return f856p;
    }

    public void setF856p(String f856p) {
        this.f856p = f856p;
    }

    public String getF856q() {
        return f856q;
    }

    public void setF856q(String f856q) {
        this.f856q = f856q;
    }

    public String getF856r() {
        return f856r;
    }

    public void setF856r(String f856r) {
        this.f856r = f856r;
    }

    public String getF856s() {
        return f856s;
    }

    public void setF856s(String f856s) {
        this.f856s = f856s;
    }

    public String getF856u() {
        return f856u;
    }

    public void setF856u(String f856u) {
        this.f856u = f856u;
    }

    public String getF856w() {
        return f856w;
    }

    public void setF856w(String f856w) {
        this.f856w = f856w;
    }

    public String getF856x() {
        return f856x;
    }

    public void setF856x(String f856x) {
        this.f856x = f856x;
    }

    public String getF856y() {
        return f856y;
    }

    public void setF856y(String f856y) {
        this.f856y = f856y;
    }

    public String getF856z() {
        return f856z;
    }

    public void setF856z(String f856z) {
        this.f856z = f856z;
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

    public String getF909a() {
        return f909a;
    }

    public void setF909a(String f909a) {
        this.f909a = f909a;
    }

    public String getF909b() {
        return f909b;
    }

    public void setF909b(String f909b) {
        this.f909b = f909b;
    }

    public String getF912a() {
        return f912a;
    }

    public void setF912a(String f912a) {
        this.f912a = f912a;
    }
}
