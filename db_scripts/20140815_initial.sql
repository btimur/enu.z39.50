DROP TABLE IF EXISTS lib_configuration;

CREATE TABLE lib_configuration (
  ID bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор',
  NAME_LIB varchar(500) NOT NULL COMMENT 'Наименование',
  HOST_LIB varchar(255) NOT NULL COMMENT 'Хост',
  PORT int(11) NOT NULL COMMENT 'Порт',
  DBNAME varchar(50) NOT NULL COMMENT 'Имя базы',
  FORMAT_LIB varchar(25) NOT NULL COMMENT 'Формат библиотеки',
  QUERY_TYPE varchar(25) NOT NULL COMMENT 'тип запросов',
  LOGIN varchar(250) DEFAULT NULL COMMENT 'Логин',
  PWD varchar(250) DEFAULT NULL COMMENT 'Пароль',
  ENCODING varchar(25) NOT NULL COMMENT 'Кодирровка ответа',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='список библиотек для поиска';
