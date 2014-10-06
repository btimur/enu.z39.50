DROP TABLE IF EXISTS `sms_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_order` (
  `ID` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT 'индентификатор',
  `DATA_UUID` varchar(50) NOT NULL COMMENT 'uid заказа',
  `USER_ID` varchar(50) NULL COMMENT 'uid пользователя',
  `FIO` varchar(250) NULL COMMENT 'фио пользователя',
  `IIN` varchar(50) NULL COMMENT 'иин пользователя',
  `NAME_BOOK` varchar(500) NULL COMMENT 'наименование книги',
  `INVNUM` varchar(250) NULL COMMENT 'инфентарный номер',
  `DATE_VIDACHI` datetime NULL COMMENT 'дата выдачи',
  `SROK_VOZVRATA` datetime NULL COMMENT 'срок возврата',
  `EXECUTED` bit(1) NOT NULL DEFAULT b'1' COMMENT 'выполнить',
  `SENDED` bit(1) NOT NULL DEFAULT b'0' COMMENT 'отправлен',
  `SMS_JURNAL_ID` bigint(20) NULL COMMENT 'ссылка журнал',
  `REG_DATE` datetime NOT NULL COMMENT 'дата регистрации',
  `SEND_DATE` datetime NULL COMMENT 'дата отправки',
   PRIMARY KEY (`ID`)
);
ALTER TABLE `sms_order`  ADD CONSTRAINT FK_SMS_ORDER_JURNAL FOREIGN KEY(`SMS_JURNAL_ID`)
REFERENCES `sms_jurnal` (`ID`);
