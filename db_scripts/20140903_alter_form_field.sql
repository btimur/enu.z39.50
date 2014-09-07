ALTER TABLE FORMAT_FIELDS
ADD COLUMN FIELD_ALIAS VARCHAR(250) NULL COMMENT 'алиас поля' AFTER NOTES;



UPDATE format_fields SET FIELD_ALIAS ='title' WHERE FIELD_NAME = '200a' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='publishedPlace' WHERE FIELD_NAME = '210a' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='publishedDate' WHERE FIELD_NAME = '210d' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='keywords' WHERE FIELD_NAME = '610a' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='isbn' WHERE FIELD_NAME = '010a' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='authorSurename' WHERE FIELD_NAME = '700a' and MFormat='RUSMARC';
UPDATE format_fields SET FIELD_ALIAS ='authorName' WHERE FIELD_NAME = '700b' and MFormat='RUSMARC';