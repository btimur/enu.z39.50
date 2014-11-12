DROP TABLE IF EXISTS `spt_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spt_region` (
  `ID` bigint(20) NOT NULL  COMMENT 'индентификатор',
  `NAME_RU` varchar(500) NULL COMMENT 'наименование',
  `PARENT_ID` bigint(20) NULL COMMENT 'ссылка предка',
  `TYPE` int(11) NOT NULL COMMENT 'тип',
   PRIMARY KEY (`ID`)
);
ALTER TABLE `spt_region`  ADD CONSTRAINT FK_SPT_REGION_PARENT FOREIGN KEY(`PARENT_ID`)
REFERENCES `spt_region` (`ID`);

INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(1, N'г. Астана', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(2, N'г. Алматы', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(3, N'Акмолинская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(4, N'Алматинская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(5, N'Атырауская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(6, N'Восточно-Казахстанская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(7, N'Жамбылская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(8, N'Западно-Казахстанская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(9, N'Карагандинская область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(10, N'Костанайская  область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(11, N'Кызылординская  область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(12, N'Павлодарская  область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(13, N'Северо-Казахстанскя  область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(14, N'Южно-Казахстанская  область', NULL, 1);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(15, N'Аккольский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(16, N'Аршалынский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(17, N'Астраханский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(18, N'Атбасарский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(19, N'Буландынский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(20, N'Бурабайский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(21, N'Егиндыкольский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(22, N'Енбекшильдерский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(23, N'Ерейментауский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(24, N'Есильский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(25, N'Жаксынский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(26, N'Жаркаинский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(27, N'Зерендинский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(28, N'Коргалжынский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(29, N'Сандыктауский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(30, N'Целиноградский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(31, N'Шортандинский район', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(32, N'г. Щучинск', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(33, N'г. Степногорск', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(34, N'г. Атбасар', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(35, N'г. Кокшетау', 3, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(36, N'Алакольский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(37, N'Аксуйский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(38, N'Балхашский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(39, N'Енбекшиказахский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(40, N'Ескельдинский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(41, N'Жамбылский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(42, N'Илийский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(43, N'Карасайский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(44, N'Каратальский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(45, N'Кербулакский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(46, N'Коксуский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(47, N'Панфиловский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(48, N'Райымбекский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(49, N'Саркандский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(50, N'Талгарский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(51, N'Уйгурский район', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(52, N'г. Талдыкорган', 4, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(53, N'Жылыойский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(54, N'Индерский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(55, N'Исатайский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(56, N'Кзылкогинский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(57, N'Курмангазинский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(58, N'Макатский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(59, N'Махамбетский район', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(60, N'г. Атырау', 5, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(61, N'Абайский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(62, N'Аягозский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(63, N'Бескарагайский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(64, N'Бородулихинский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(65, N'Глубоковский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(66, N'Жарминский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(67, N'Зайсанский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(68, N'Зыряновский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(69, N'Катон-Карагайский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(70, N'Кокпектинский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(71, N'Курчумский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(72, N'Тарбагатайский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(73, N'Уланский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(74, N'Урджарский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(75, N'Шемонаихинский район', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(76, N'г. Усть-Каменогорск', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(77, N'г. Сатпаево', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(78, N'г. Риддер', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(79, N'г. Семей', 6, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(80, N'Байзакский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(81, N'Жамбылский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(82, N'Жуалынский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(83, N'Кордайский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(84, N'Меркенский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(85, N'Мойынкумский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(86, N'Рыскуловский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(87, N'Сарысуский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(88, N'Таласский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(89, N'Шуский район', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(90, N'г. Тараз', 7, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(91, N'Акжаикский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(92, N'Бокейординский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(93, N'Бурлинский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(94, N'Джангалинский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(95, N'Жанибекский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(96, N'Зеленовский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(97, N'Казталовский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(98, N'Каратобинский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(99, N'Сырымский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(100, N'Таскалинский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(101, N'Теректинский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(102, N'Чингирлауский район', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(103, N'г. Уральск', 8, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(104, N'Абайский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(105, N'Актогайский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(106, N'Бухар-Жырауский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(107, N'Жанааркинский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(108, N'Каркаралинский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(109, N'Нуринский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(110, N'Осакаровский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(111, N'Улытауский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(112, N'Шетский район', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(113, N'г. Жезказган', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(114, N'г. Темиртау', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(115, N'г. Караганда', 9, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(116, N'Алтынсаринский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(117, N'Амангельдинский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(118, N'Аулиекольский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(119, N'Денисовский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(120, N'Джангельдинский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(121, N'Житикаринский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(122, N'Камыстинский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(123, N'Карабалыкский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(124, N'Карасуский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(125, N'Костанайский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(126, N'Мендыкаринский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(127, N'Наурзумский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(128, N'Сарыкольский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(129, N'Тарановский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(130, N'Узункольский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(131, N'Фёдоровский район', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(132, N'г. Аркалык', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(133, N'г. Рудный', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(134, N'г. Костанай', 10, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(135, N'Аральский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(136, N'Жалагашский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(137, N'Жанакорганский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(138, N'Казалинский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(139, N'Кармакшинский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(140, N'Сырдарьинский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(141, N'Шиелийский район', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(142, N'г. Кызылорда', 11, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(143, N'Актогайский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(144, N'Баянаульский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(145, N'Железинский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(146, N'Иртышский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(147, N'Качирский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(148, N'Лебяжинский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(149, N'Майский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(150, N'Павлодарский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(151, N'Успенский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(152, N'Щербактинский район', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(153, N'г. Павлодар', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(154, N'г. Экибастуз', 12, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(155, N'Айыртауский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(156, N'Акжарский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(157, N'Аккайынский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(158, N'Есильский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(159, N'Жамбылский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(160, N'Кызылжарский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(161, N'Мамлютский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(162, N'Район им. Габита Мусрепова', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(163, N'Район Магжана Жумабаева', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(164, N'Район Шал акына', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(165, N'Тайыншинский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(166, N'Тимирязевский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(167, N'Уалихановский район', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(168, N'г. Петропавловск', 13, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(169, N'Байдибекский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(170, N'Казыгуртский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(171, N'Мактааральский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(172, N'Ордабасинский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(173, N'Отырарский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(174, N'Сайрамский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(175, N'Сарыагашский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(176, N'Созакский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(177, N'Толебийский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(178, N'Тюлькубасский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(179, N'Шардаринский район', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(180, N'г. Туркестан', 14, 2);
INSERT INTO spt_region(ID, NAME_RU, PARENT_ID, TYPE)
  VALUES(181, N'г. Шымкент', 14, 2);

