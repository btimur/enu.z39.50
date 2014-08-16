DROP TABLE lib_configuration
GO

CREATE TABLE lib_configuration  (
  ID        	bigint(20) AUTO_INCREMENT COMMENT 'Идентификатор'  NOT NULL,
  NAME_LIB  	varchar(500) COMMENT 'Наименование'  NOT NULL,
  HOST_LIB  	varchar(255) COMMENT 'Хост'  NOT NULL,
  PORT      	int(11) COMMENT 'Порт'  NOT NULL,
  DBNAME    	varchar(50) COMMENT 'Имя базы'  NOT NULL,
  FORMAT_LIB	varchar(25) COMMENT 'Формат библиотеки'  NOT NULL,
  QUERY_TYPE	varchar(25) COMMENT 'тип запросов'  NOT NULL,
  LOGIN     	varchar(250) COMMENT 'Логин'  NULL,
  PWD       	varchar(250) COMMENT 'Пароль'  NULL,
  ENCODING  	varchar(25) COMMENT 'Кодирровка ответа'  NOT NULL,
  PRIMARY KEY(ID)
)
GO

ALTER TABLE lib_configuration
    ADD CONSTRAINT LIBNAME_UNIQ
	UNIQUE (NAME_LIB)