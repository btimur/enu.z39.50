
update format_fields set FIELD_ALIAS='publisher' where MFORMAT='RUSMARC' and FIELD_NAME='210c';
update format_fields set FIELD_ALIAS='notes' where MFORMAT='RUSMARC' and FIELD_NAME='300a';
update format_fields set FIELD_ALIAS='thematic' where MFORMAT='RUSMARC' and FIELD_NAME='606a';

update format_fields set FIELD_ALIAS='publisher' where MFORMAT='UNIMARC' and FIELD_NAME='210c';
update format_fields set FIELD_ALIAS='notes' where MFORMAT='UNIMARC' and FIELD_NAME='300a';
update format_fields set FIELD_ALIAS='thematic' where MFORMAT='UNIMARC' and FIELD_NAME='606a';

update format_fields set FIELD_ALIAS='publisher' where MFORMAT='USMARC' and FIELD_NAME='260b';
update format_fields set FIELD_ALIAS='notes' where MFORMAT='USMARC' and FIELD_NAME='500a';
update format_fields set FIELD_ALIAS='thematic' where MFORMAT='USMARC' and FIELD_NAME='650a';