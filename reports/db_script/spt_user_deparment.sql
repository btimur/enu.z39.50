DROP TABLE IF EXISTS `spt_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spt_department` (
  `DEPARTMENT_ID` varchar(80) NOT NULL COMMENT 'Идентификатор',
  `NUMBER` int(11) NOT NULL COMMENT 'Номер',
  `BRANCH` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Активный',
  `PARENT_ID` varchar(80) DEFAULT NULL COMMENT 'Предок',
  `NAME_RU` varchar(500) DEFAULT NULL COMMENT 'Наименование РУС',
  `NAME_KZ` varchar(500) DEFAULT NULL COMMENT 'Наименование КАЗ',
  `NAME_EN` varchar(500) DEFAULT NULL COMMENT 'Наименование АНГЛ',
  `POINTERS_CODE` varchar(500) DEFAULT NULL COMMENT 'Код',
  PRIMARY KEY (`DEPARTMENT_ID`),
  KEY `FK_SPT_DEP_DEP` (`PARENT_ID`),
  CONSTRAINT `FK_SPT_DEP_DEP` FOREIGN KEY (`PARENT_ID`) REFERENCES `spt_department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `spt_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spt_user` (
  `USER_ID` varchar(80) NOT NULL COMMENT 'Идентификатор',
  `NAME_RU` varchar(500) DEFAULT NULL COMMENT 'Наименование РУС',
  `POST` varchar(250) DEFAULT NULL COMMENT 'должность',
  `SEX_INDEX` int(11) NOT NULL COMMENT 'пол',
  `DEPARTMENT_ID` varchar(80) DEFAULT NULL COMMENT 'Департамент',
  `ST_CITY` varchar(250) DEFAULT NULL COMMENT 'город',
  `ST_REGION` varchar(250) DEFAULT NULL COMMENT 'регион',
  `ST_SUB_REGION` varchar(250) DEFAULT NULL COMMENT 'район',
  PRIMARY KEY (`USER_ID`),
  KEY `FK_SPT_USR_DEP` (`DEPARTMENT_ID`),
  CONSTRAINT `FK_SPT_USR_DEP` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `spt_department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

