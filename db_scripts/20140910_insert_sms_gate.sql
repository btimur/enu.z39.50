delete from sms_gate;
INSERT INTO sms_gate(NAME_SMS, SURL, LOGIN, PWD, SCHARSET, SFORMAT, ENABLED, TRANSLIT, SORDER, DELETED, TEMPLATE, SUCESS_RESULT, MESSAGE_CONTEXT)
  VALUES('smsc', 'http://smsc.kz/', 'didar712', '1q2w3e4r', 'UTF8', 'UTF8', 0, 1, 1, 0, 'http://smsc.kz/sys/send.php?login=%ENU_LOGIN%&psw=%ENU_PWD%&phones=%ENU_PHONES%&mes=%ENU_MSG%', 'OK', N'Уважаемый %FULL_NAME%, книга %NAME_BOOK% %DATE_DELIVERY%, срок возврата %DATE_BACK%');
INSERT INTO sms_gate( NAME_SMS, SURL, LOGIN, PWD, SCHARSET, SFORMAT, ENABLED, TRANSLIT, SORDER, DELETED, TEMPLATE, SUCESS_RESULT, MESSAGE_CONTEXT)
  VALUES('smsfeedback', 'http://www.smsfeedback.ru/', 'didar712', '1q2w3e4r', 'UTF8', 'UTF8', 0, 1, 1, 0, 'http://api.smsfeedback.ru/messages/v2/send/?login=%ENU_LOGIN%&password=%ENU_PWD%&phone=%ENU_PHONES%&text=%ENU_MSG%', 'accepted', N'Уважаемый %FULL_NAME%, книга %NAME_BOOK% %DATE_DELIVERY%, срок возврата %DATE_BACK%');
INSERT INTO sms_gate(NAME_SMS, SURL, LOGIN, PWD, SCHARSET, SFORMAT, ENABLED, TRANSLIT, SORDER, DELETED, TEMPLATE, SUCESS_RESULT, MESSAGE_CONTEXT)
  VALUES('smsru', 'http://sms.ru', 'didar', '06d24b0b-4b81-7214-7d85-4f33f6711955', 'UTF-8', 'UTF-8', 1, 1, 1, 0, 'http://sms.ru/sms/send?test=1&api_id=%ENU_PWD%&to=%ENU_PHONES%&text=%ENU_MSG%', '100', N'Уважаемый %FULL_NAME%, книга %NAME_BOOK% %DATE_DELIVERY%, срок возврата %DATE_BACK%');

