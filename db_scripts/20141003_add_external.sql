CREATE TABLE EXTERNAL  (
  ID        	bigint(20) AUTO_INCREMENT COMMENT 'идентификатор'  NOT NULL,
  LOGIN     	varchar(100) COMMENT 'пользователь'  NOT NULL,
  PWD       	varchar(500) COMMENT 'пароль'  NOT NULL,
  DATE_ADD  	datetime COMMENT 'дата добавления'  NOT NULL,
  DATE_END  	datetime COMMENT 'дата окончания'  NOT NULL,
  IS_BLOCK  	bit(1) COMMENT 'заблокирован'  NOT NULL DEFAULT b'0',
  DESCR     	varchar(4000) COMMENT 'описание'  NULL,
  IS_DELETED	bit(1) COMMENT 'признак удаления'  NOT NULL DEFAULT b'0',
  PRIMARY KEY(ID)
)

