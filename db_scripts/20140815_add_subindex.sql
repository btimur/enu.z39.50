DROP TABLE subindex
  GO

CREATE TABLE subindex  (
  ID        	bigint(20) AUTO_INCREMENT COMMENT 'Идентификатор'  NOT NULL,
  FORMAT_LIB	varchar(25) COMMENT 'Формат библиотеки'  NOT NULL,
  FIELD	varchar(50) COMMENT 'поле'  NOT NULL,
  TAG     	char(1) COMMENT 'тег'  NULL,
  SUBINDEX       	int(11) COMMENT 'индекс подполя'  NULL,
  START       	int(11) COMMENT 'начало индекса подполя'  NULL,
  END       	int(11) COMMENT 'окончания индекса подполя'  NULL,
  PRIMARY KEY(ID)
)
  GO
