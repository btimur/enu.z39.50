CREATE TABLE RECOGNIZE_TASK  (
  ID        	bigint(20) AUTO_INCREMENT COMMENT 'идентификатор'  NOT NULL,
  UUID      	varchar(100) NOT NULL,
  FILE_PATH 	varchar(4000) COMMENT 'сетевая папка сканов'  NOT NULL,
  STARTED   	bit(1) COMMENT 'запущено распознавание'  NULL DEFAULT b'0',
  DATE_ADD  	datetime COMMENT 'дата добавления задачи'  NOT NULL,
  DATE_START	datetime COMMENT 'дата начала распознавания'  NULL,
  DATE_END  	datetime COMMENT 'дата окончания распознавания'  NULL,
  COMPLETED 	bit(1) COMMENT 'распознан'  NOT NULL DEFAULT b'0',
  ERROR     	longtext COMMENT 'ошибка распознавания'  NULL,
  FILE_END  	varchar(4000) COMMENT 'распознанный файл'  NULL,
  UPLOADED    bit(1) COMMENT 'Залито на Synergy'  NOT NULL DEFAULT b'0',
  PRIMARY KEY(ID)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  COMMENT = 'задачи распознавания';