DROP TABLE IF EXISTS `sms_gate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_gate` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор',
  `NAME_SMS` varchar(500) NOT NULL COMMENT 'Наименование',
  `SURL` varchar(255) NOT NULL COMMENT 'Хост',
  `LOGIN` varchar(250) DEFAULT NULL COMMENT 'Логин',
  `PWD` varchar(250) DEFAULT NULL COMMENT 'Пароль',
  `SCHARSET` varchar(250) NOT NULL COMMENT 'Кодировка',
  `SFORMAT` varchar(250) NOT NULL COMMENT 'Формат',
  `ENABLED` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Активный',
  `TRANSLIT` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Переведен',
  `SORDER` int(11) NOT NULL COMMENT 'Номер',
  `DELETED` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Удален',
  `TEMPLATE` varchar(250) DEFAULT NULL COMMENT 'Шаблон',
  
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `sms_jurnal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_jurnal` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор',
  `DATE_SEND` datetime NOT NULL COMMENT 'Дата и время отправки',
  `IIN` varchar(20) NOT NULL COMMENT 'ИИН',
  `PHONE` varchar(50) NOT NULL COMMENT 'номер телефона',
  `MESSAGES` varchar(500) NULL COMMENT 'сообщение',
  `RESULTS` varchar(500) NULL COMMENT 'результат',
  `ORDER_UID` varchar(25) NULL COMMENT 'индентификатор заявки',
  `ORDER_BOOKNAME` varchar(250) DEFAULT NULL COMMENT 'наименование книги',
  `SMS_GATE_ID` bigint(20) NULL COMMENT 'ссылка на аккаунт',
  PRIMARY KEY (`ID`)
);

ALTER TABLE `sms_jurnal`  ADD CONSTRAINT FK_SMS_JURNAL_GATE FOREIGN KEY(`SMS_GATE_ID`)
REFERENCES `sms_gate` (`ID`);




