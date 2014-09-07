ALTER TABLE blocks
ADD COLUMN zformat VARCHAR(50) NULL COMMENT 'формат';

update blocks set zformat='RUSMARC' where id <39;

INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(140, N'00Х Контрольные поля', N'00Х Контрольные поля', 'bl0', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(141, N'01Х-09X Номера, индексы, коды', N'01Х-09X Номера, индексы, коды', 'bl0', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(142, N'1ХX Основные поисковые признаки (заголовки, точки доступа)', N'1ХX Основные поисковые признаки (заголовки, точки доступа)', 'bl1', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(143, N'20Х-24X Поля заглавий', N'20Х-24X Поля заглавий', 'bl2', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(144, N'25Х-28X Сведения об издании, выходные данные и т. д.', N'25Х-28X Сведения об издании, выходные данные и т. д.', 'bl2', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(145, N'3ХХ Количественная/физическая характеристика', N'3ХХ Количественная/физическая характеристика', 'bl3', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(146, N'4ХХ Область серии', N'4ХХ Область серии', 'bl4', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(147, N'5ХХ Область примечания', N'5ХХ Область примечания', 'bl5', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(148, N'6ХX Поля предметного входа', N'6ХX Поля предметного входа', 'bl6', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(149, N'7ХX Добавочные поисковые признаки (точки доступа)', N'7ХX Добавочные поисковые признаки (точки доступа)', 'bl7', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(150, N'76X-78X Связывающие поисковые признаки', N'76X-78X Связывающие поисковые признаки', 'bl7', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(151, N'8XX-840 Добавочные поисковые признаки (точки доступа) на серию', N'8XX-840 Добавочные поисковые признаки (точки доступа) на серию', 'bl8', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(152, N'841-878 Фондовые данные', N'841-878 Фондовые данные', 'bl8', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(153, N'880 Данные в иной графике', N'880 Данные в иной графике', 'bl8', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(154, N'886 Поле MARC-формата, отличного от MARC 21', N'886 Поле MARC-формата, отличного от MARC 21', 'bl8', 'USMARC');
INSERT INTO blocks(id, nameBlock, descr, blnum, zformat)
VALUES(155, N'887 Поле формата, отличного от MARC', N'887 Поле формата, отличного от MARC', 'bl8', 'USMARC');



INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8666', '001', 140, N'Контрольный номер записи', 0, NULL, NULL, N'Контрольный номер записи', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8667', '003', 140, N'Принадлежность контрольного номера', 0, NULL, NULL, N'Принадлежность контрольного номера', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8668', '005', 140, N'Дата и время последней транзакции', 0, NULL, NULL, N'Дата и время последней транзакции', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8669', '006', 140, N'Дополнительные элементы данных фиксированной длины', 0, NULL, NULL, N'Дополнительные элементы данных фиксированной длины', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8670', '007', 140, N'Элементы данных фиксированной длины для физической характеристики', 0, NULL, NULL, N'Элементы данных фиксированной длины для физической характеристики', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8671', '008', 140, N'Элементы данных фиксированной длины
            ', 0, NULL, NULL, N'Элементы данных фиксированной длины
            ', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8672', '013', 141, N'Контрольные сведения о патенте', 0, NULL, NULL, N'Контрольные сведения о патенте', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8673', '013a', 141, N'- номер.', 1, NULL, NULL, N'- номер.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8674', '013b', 141, N'- страна.', 1, NULL, NULL, N'- страна.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8675', '013c', 141, N'- тип номера.', 1, NULL, NULL, N'- тип номера.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8676', '013d', 141, N'- дата.', 1, NULL, NULL, N'- дата.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8677', '013e', 141, N'- статус.', 1, NULL, NULL, N'- статус.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8678', '013f', 141, N'- сторона-участница.', 1, NULL, NULL, N'- сторона-участница.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8679', '0136', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8680', '0138', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8672, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8681', '015', 141, N'Номер в национальной библиографии', 0, NULL, NULL, N'Номер в национальной библиографии', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8682', '015a', 141, N'- номер документа в национальной библиографии.', 1, NULL, NULL, N'- номер документа в национальной библиографии.', 8681, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8683', '0152', 141, N'- источник номера.', 1, NULL, NULL, N'- источник номера.', 8681, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8684', '0156', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8681, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8685', '0158', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8681, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8686', '016', 141, N'Контрольный номер национального библиографического агентства', 0, NULL, NULL, N'Контрольный номер национального библиографического агентства', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8687', '016a', 141, N'- контрольный номер записи.', 1, NULL, NULL, N'- контрольный номер записи.', 8686, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8688', '016z', 141, N'- отменённый/ошибочный контрольный номер.', 1, NULL, NULL, N'- отменённый/ошибочный контрольный номер.', 8686, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8689', '0162', 141, N'- организация-источник контрольного номера.', 1, NULL, NULL, N'- организация-источник контрольного номера.', 8686, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8690', '0168', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8686, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8691', '017', 141, N'Номер регистрации авторского права или обязательного экземпляра', 0, NULL, NULL, N'Номер регистрации авторского права или обязательного экземпляра', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8692', '017a', 141, N'- номер регистрации авторского права или обязательного экземпляра.', 1, NULL, NULL, N'- номер регистрации авторского права или обязательного экземпляра.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8693', '017b', 141, N'- организация, присвоившая номер.', 1, NULL, NULL, N'- организация, присвоившая номер.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8694', '017d', 141, N'- дата регистрации авторского права.', 1, NULL, NULL, N'- дата регистрации авторского права.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8695', '017i', 141, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8696', '0172', 141, N'- источник номера.', 1, NULL, NULL, N'- источник номера.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8697', '0176', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8698', '0178', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8691, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8699', '020', 141, N'Международный стандартный номер книги (ISBN)', 0, NULL, NULL, N'Международный стандартный номер книги (ISBN)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8700', '020a', 141, N'- международный стандартный номер книги.', 1, NULL, NULL, N'- международный стандартный номер книги.', 8699, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8701', '020c', 141, N'- условия получения (цена, тираж).', 1, NULL, NULL, N'- условия получения (цена, тираж).', 8699, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8702', '020z', 141, N'- отменённый/ошибочный ISBN.', 1, NULL, NULL, N'- отменённый/ошибочный ISBN.', 8699, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8703', '0206', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8699, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8704', '0208', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8699, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8705', '022', 141, N'Международный стандартный номер сериального издания (ISSN)', 0, NULL, NULL, N'Международный стандартный номер сериального издания (ISSN)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8706', '022a', 141, N'- международный стандартный номер сериального издания.', 1, NULL, NULL, N'- международный стандартный номер сериального издания.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8707', '022y', 141, N'- ошибочный ISSN.', 1, NULL, NULL, N'- ошибочный ISSN.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8708', '022z', 141, N'- отменённый ISSN.', 1, NULL, NULL, N'- отменённый ISSN.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8709', '0222', 141, N'- источник номера.', 1, NULL, NULL, N'- источник номера.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8710', '0226', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8711', '0228', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8705, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8712', '024', 141, N'Прочие стандартные номера, индексы, шифры, коды', 0, NULL, NULL, N'Прочие стандартные номера, индексы, шифры, коды', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8713', '024a', 141, N'- стандартный номер, индекс, шифр, код.', 1, NULL, NULL, N'- стандартный номер, индекс, шифр, код.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8714', '024c', 141, N'- условия получения (цена, тираж).', 1, NULL, NULL, N'- условия получения (цена, тираж).', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8715', '024d', 141, N'- дополнительные коды, следующие за стандартным номером и т. д.', 1, NULL, NULL, N'- дополнительные коды, следующие за стандартным номером и т. д.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8716', '024z', 141, N'- отменённый/ошибочный номер, индекс, шифр, код.', 1, NULL, NULL, N'- отменённый/ошибочный номер, индекс, шифр, код.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8717', '0242', 141, N'- источник номера, индекса, шифра, кода.', 1, NULL, NULL, N'- источник номера, индекса, шифра, кода.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8718', '0246', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8719', '0248', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8712, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8720', '026', 141, N'Фингерпринт', 0, NULL, NULL, N'Фингерпринт', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8721', '026a', 141, N'- первая и вторая группы символов.', 1, NULL, NULL, N'- первая и вторая группы символов.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8722', '026b', 141, N'- третья и четвёртая группы символов.', 1, NULL, NULL, N'- третья и четвёртая группы символов.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8723', '026c', 141, N'- дата.', 1, NULL, NULL, N'- дата.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8724', '026d', 141, N'- номер тома или части.', 1, NULL, NULL, N'- номер тома или части.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8725', '026e', 141, N'- фингерпринт без разбивки на группы.', 1, NULL, NULL, N'- фингерпринт без разбивки на группы.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8726', '0262', 141, N'- использованное руководство.', 1, NULL, NULL, N'- использованное руководство.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8727', '0265', 141, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8728', '0266', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8729', '027', 141, N'Стандартный номер технического отчёта (STRN)', 0, NULL, NULL, N'Стандартный номер технического отчёта (STRN)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8730', '027a', 141, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 8729, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8731', '027z', 141, N'- отменённый/ошибочный номер.', 1, NULL, NULL, N'- отменённый/ошибочный номер.', 8729, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8732', '0276', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8729, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8733', '0278', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8729, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8734', '028', 141, N'Издательский номер', 0, NULL, NULL, N'Издательский номер', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8735', '028a', 141, N'- издательский номер.', 1, NULL, NULL, N'- издательский номер.', 8734, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8736', '028b', 141, N'- источник издательского номера.', 1, NULL, NULL, N'- источник издательского номера.', 8734, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8737', '0286', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8734, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8738', '0288', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8734, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8739', '031', 141, N'Музыкальный инципит', 0, NULL, NULL, N'Музыкальный инципит', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8740', '031a', 141, N'- порядковый номер произведения в каталогизируемой единице.', 1, NULL, NULL, N'- порядковый номер произведения в каталогизируемой единице.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8741', '031b', 141, N'- порядковый номер темпа в произведении.', 1, NULL, NULL, N'- порядковый номер темпа в произведении.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8742', '031c', 141, N'- порядковый номер инципита внутри темпа.', 1, NULL, NULL, N'- порядковый номер инципита внутри темпа.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8743', '031d', 141, N'- заглавие или заголовок инципита.', 1, NULL, NULL, N'- заглавие или заголовок инципита.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8744', '031e', 141, N'- наименование символа распева инципита (вокал).', 1, NULL, NULL, N'- наименование символа распева инципита (вокал).', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8745', '031g', 141, N'- ключ.', 1, NULL, NULL, N'- ключ.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8746', '031m', 141, N'- голос/инструмент.', 1, NULL, NULL, N'- голос/инструмент.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8747', '031n', 141, N'- обозначение тональности.', 1, NULL, NULL, N'- обозначение тональности.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8748', '031o', 141, N'- обозначение такта.', 1, NULL, NULL, N'- обозначение такта.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8749', '031p', 141, N'- музыкальная нотация.', 1, NULL, NULL, N'- музыкальная нотация.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8750', '031q', 141, N'- примечание', 1, NULL, NULL, N'- примечание', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8751', '031r', 141, N'- тональность.', 1, NULL, NULL, N'- тональность.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8752', '031s', 141, N'- код проверки правильности.', 1, NULL, NULL, N'- код проверки правильности.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8753', '031t', 141, N'- литературный инципит.', 1, NULL, NULL, N'- литературный инципит.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8754', '031u', 141, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8755', '031y', 141, N'- связывающий текст.', 1, NULL, NULL, N'- связывающий текст.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8756', '031z', 141, N'- примечание для ЭК.', 1, NULL, NULL, N'- примечание для ЭК.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8757', '0312', 141, N'- код системы.', 1, NULL, NULL, N'- код системы.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8758', '0316', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8759', '0318', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8739, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8760', '034', 141, N'Кодированные картографические математические данные', 0, NULL, NULL, N'Кодированные картографические математические данные', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8761', '034a', 141, N'- категория масштаба.', 1, NULL, NULL, N'- категория масштаба.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8762', '034b', 141, N'- постоянный линейный горизонтальный масштаб.', 1, NULL, NULL, N'- постоянный линейный горизонтальный масштаб.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8763', '034c', 141, N'- постоянный линейный вертикальный масштаб.', 1, NULL, NULL, N'- постоянный линейный вертикальный масштаб.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8764', '034d', 141, N'- координаты - самая западная долгота.', 1, NULL, NULL, N'- координаты - самая западная долгота.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8765', '034e ', 141, N'- координаты - самая восточная долгота.', 1, NULL, NULL, N'- координаты - самая восточная долгота.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8766', '034f', 141, N'- координаты - самая северная широта.', 1, NULL, NULL, N'- координаты - самая северная широта.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8767', '034g', 141, N'- координаты - самая южная широта.', 1, NULL, NULL, N'- координаты - самая южная широта.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8768', '034h', 141, N'- угловой масштаб.', 1, NULL, NULL, N'- угловой масштаб.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8769', '034j', 141, N'- склонение - северная граница.', 1, NULL, NULL, N'- склонение - северная граница.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8770', '034k', 141, N'- склонение - южная граница.', 1, NULL, NULL, N'- склонение - южная граница.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8771', '034m', 141, N'- прямое восхождение - восточная граница.', 1, NULL, NULL, N'- прямое восхождение - восточная граница.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8772', '034n', 141, N'- прямое восхождение - западная граница.', 1, NULL, NULL, N'- прямое восхождение - западная граница.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8773', '034p', 141, N'- равноденствие.', 1, NULL, NULL, N'- равноденствие.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8774', '034s', 141, N'- широта G-контура.', 1, NULL, NULL, N'- широта G-контура.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8775', '034t', 141, N'- долгота G-контура.', 1, NULL, NULL, N'- долгота G-контура.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8776', '0346', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8777', '0348', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8760, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8778', '035', 141, N'Контрольный номер системы', 0, NULL, NULL, N'Контрольный номер системы', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8779', '035a', 141, N'- контрольный номер системы.', 1, NULL, NULL, N'- контрольный номер системы.', 8778, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8780', '035z', 141, N'- отменённый/ошибочный контрольный номер системы.', 1, NULL, NULL, N'- отменённый/ошибочный контрольный номер системы.', 8778, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8781', '0356', 141, N'- связь.', 1, NULL, NULL, N'- связь.', 8778, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8782', '0358', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8778, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8783', '036', 141, N'Исходный рабочий номер файлов компьютерных данных', 0, NULL, NULL, N'Исходный рабочий номер файлов компьютерных данных', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8784', '036a', 141, N'- исходный рабочий номер.', 1, NULL, NULL, N'- исходный рабочий номер.', 8783, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8785', '036b', 141, N'- организация, присвоившая номер.', 1, NULL, NULL, N'- организация, присвоившая номер.', 8783, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8786', '0366', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8783, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8787', '0368', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8783, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8788', '037', 141, N'Данные для комплектования', 0, NULL, NULL, N'Данные для комплектования', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8789', '037a', 141, N'- номер по прейскуранту и т. д.', 1, NULL, NULL, N'- номер по прейскуранту и т. д.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8790', '037b', 141, N'- продавец, распространитель, издатель, изготовитель.', 1, NULL, NULL, N'- продавец, распространитель, издатель, изготовитель.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8791', '037c', 141, N'- условия получения, цена.', 1, NULL, NULL, N'- условия получения, цена.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8792', '037f', 141, N'- форма распространяемого материала.', 1, NULL, NULL, N'- форма распространяемого материала.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8793', '037g', 141, N'- дополнительные характеристики материала. ', 1, NULL, NULL, N'- дополнительные характеристики материала. ', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8794', '037n', 141, N'- примечание.', 1, NULL, NULL, N'- примечание.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8795', '0376', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8796', '0378', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8797', '038', 141, N'Организация, давшая права интеллектуальной собственности на содержимое записи', 0, NULL, NULL, N'Организация, давшая права интеллектуальной собственности на содержимое записи', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8798', '038a', 141, N'- код организации, давшей права интеллектуальной собственности на содержимое записи.', 1, NULL, NULL, N'- код организации, давшей права интеллектуальной собственности на содержимое записи.', 8797, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8799', '0386', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8797, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8800', '0388', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8797, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8801', '040', 141, N'Организация-создатель записи', 0, NULL, NULL, N'Организация-создатель записи', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8802', '040a', 141, N'- организация-создатель исходной библиографической записи.', 1, NULL, NULL, N'- организация-создатель исходной библиографической записи.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8803', '040b', 141, N'- язык каталогизации.', 1, NULL, NULL, N'- язык каталогизации.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8804', '040с', 141, N'- организация, переведшая запись в машиночитаемую форму.', 1, NULL, NULL, N'- организация, переведшая запись в машиночитаемую форму.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8805', '040d', 141, N'- организация, внёсшая в запись изменения.', 1, NULL, NULL, N'- организация, внёсшая в запись изменения.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8806', '040e', 141, N'- правила каталогизации.', 1, NULL, NULL, N'- правила каталогизации.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8807', '0406', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8808', '0408', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8801, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8809', '041', 141, N'Код языка', 0, NULL, NULL, N'Код языка', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8810', '041a', 141, N'- код языка текста.', 1, NULL, NULL, N'- код языка текста.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8811', '041b', 141, N'- код языка резюме, аннотации или подзаголовков.', 1, NULL, NULL, N'- код языка резюме, аннотации или подзаголовков.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8812', '041d', 141, N'- код языка звукозаписи вокального произведения или текста.', 1, NULL, NULL, N'- код языка звукозаписи вокального произведения или текста.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8813', '041e', 141, N'- код языка либретто.', 1, NULL, NULL, N'- код языка либретто.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8814', '041f', 141, N'- код языка оглавления.', 1, NULL, NULL, N'- код языка оглавления.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8815', '041g', 141, N'- код языка сопроводительного материала (не либретто).', 1, NULL, NULL, N'- код языка сопроводительного материала (не либретто).', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8816', '041h', 141, N'- код языка оригинала и/или промежуточных переводов текста.', 1, NULL, NULL, N'- код языка оригинала и/или промежуточных переводов текста.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8817', '0412', 141, N'- источник кода.', 1, NULL, NULL, N'- источник кода.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8818', '0416', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8819', '0418', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8809, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8820', '043', 141, N'Код географического региона', 0, NULL, NULL, N'Код географического региона', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8821', '043a', 141, N'- код географического региона.', 1, NULL, NULL, N'- код географического региона.', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8822', '043b', 141, N'- локальный код географического региона.', 1, NULL, NULL, N'- локальный код географического региона.', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8823', '043c', 141, N'- код ISO.', 1, NULL, NULL, N'- код ISO.', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8824', '0432', 141, N'- источник локального кода.', 1, NULL, NULL, N'- источник локального кода.', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8825', '0436', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8826', '0438', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8820, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8827', '044', 141, N'Код страны публикации/изготовления', 0, NULL, NULL, N'Код страны публикации/изготовления', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8828', '044a', 141, N'- MARC код страны публикации/изготовления.', 1, NULL, NULL, N'- MARC код страны публикации/изготовления.', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8829', '044b', 141, N'- локальный код места публикации/изготовления внутри страны.', 1, NULL, NULL, N'- локальный код места публикации/изготовления внутри страны.', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8830', '044c', 141, N'- код страны публикации/изготовления по ISO.', 1, NULL, NULL, N'- код страны публикации/изготовления по ISO.', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8831', '0442', 141, N'- источник локального кода.', 1, NULL, NULL, N'- источник локального кода.', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8832', '0446', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8833', '0448', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8827, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8834', '045', 141, N'Период времени, охватываемый содержанием документа', 0, NULL, NULL, N'Период времени, охватываемый содержанием документа', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8835', '045a', 141, N'- код периода времени.', 1, NULL, NULL, N'- код периода времени.', 8834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8836', '045b', 141, N'- форматированное обозначение периода времени с н. э. по 9999 до н. э.', 1, NULL, NULL, N'- форматированное обозначение периода времени с н. э. по 9999 до н. э.', 8834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8837', '045c', 141, N'- форматированное обозначение периода времени до 9999 до н.э.', 1, NULL, NULL, N'- форматированное обозначение периода времени до 9999 до н.э.', 8834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8838', '0456', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8839', '0458', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8840', '047', 141, N'Код жанра (формы) музыкального произведения', 0, NULL, NULL, N'Код жанра (формы) музыкального произведения', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8841', '047a', 141, N'- код жанра (формы).', 1, NULL, NULL, N'- код жанра (формы).', 8840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8842', '0478', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8843', '048', 141, N'Средства исполнения', 0, NULL, NULL, N'Средства исполнения', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8844', '048a', 141, N'- средство исполнения.', 1, NULL, NULL, N'- средство исполнения.', 8843, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8845', '048c', 141, N'- солист.', 1, NULL, NULL, N'- солист.', 8843, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8846', '0488', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8843, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8847', '052', 141, N'Код географической классификации', 0, NULL, NULL, N'Код географической классификации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8848', '052a', 141, N'- код географической классификации региона.', 1, NULL, NULL, N'- код географической классификации региона.', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8849', '052b', 141, N'- код географической классификации области региона.', 1, NULL, NULL, N'- код географической классификации области региона.', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8850', '052c', 141, N'- название населённого пункта.', 1, NULL, NULL, N'- название населённого пункта.', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8851', '0522', 141, N'- источник кода.', 1, NULL, NULL, N'- источник кода.', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8852', '0526', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8853', '0528', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8847, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8854', '066', 141, N'Наборы символов', 0, NULL, NULL, N'Наборы символов', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8855', '066a', 141, N'- исходный набор символов G0.', 1, NULL, NULL, N'- исходный набор символов G0.', 8854, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8856', '066b', 141, N'- исходный набор символов G1.', 1, NULL, NULL, N'- исходный набор символов G1.', 8854, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8857', '066c', 141, N'- иной набор символов G0 или G1.', 1, NULL, NULL, N'- иной набор символов G0 или G1.', 8854, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8858', '072', 141, N'Код предметной/тематической категории', 0, NULL, NULL, N'Код предметной/тематической категории', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8859', '072a', 141, N'- код предметной/тематической категории.', 1, NULL, NULL, N'- код предметной/тематической категории.', 8858, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8860', '072x', 141, N'- код нижестоящей предметной/тематической категории.', 1, NULL, NULL, N'- код нижестоящей предметной/тематической категории.', 8858, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8861', '0722', 141, N'- источник кода.', 1, NULL, NULL, N'- источник кода.', 8858, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8862', '0726', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8858, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8863', '0728', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8858, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8864', '080', 141, N'Индекс Универсальной десятичной классификации', 0, NULL, NULL, N'Индекс Универсальной десятичной классификации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8865', '080a', 141, N'- индекс Универсальной десятичной классификации.', 1, NULL, NULL, N'- индекс Универсальной десятичной классификации.', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8866', '080b', 141, N'- номер единицы.', 1, NULL, NULL, N'- номер единицы.', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8867', '080x', 141, N'- вспомогательное деление общего характера.', 1, NULL, NULL, N'- вспомогательное деление общего характера.', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8868', '0802', 141, N'- обозначение издания таблиц УДК.', 1, NULL, NULL, N'- обозначение издания таблиц УДК.', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8869', '0806', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8870', '0808', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8864, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8871', '084', 141, N'Индексы других классификаций/Индекс ББК', 0, NULL, NULL, N'Индексы других классификаций/Индекс ББК', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8872', '084a', 141, N'- индекс другой классификации/индекс ББК.', 1, NULL, NULL, N'- индекс другой классификации/индекс ББК.', 8871, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8873', '0842', 141, N'- источник индекса.', 1, NULL, NULL, N'- источник индекса.', 8871, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8874', '0846', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8871, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8875', '0848', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8871, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8876', '086', 141, N'Классификационный номер документа органа государственной власти', 0, NULL, NULL, N'Классификационный номер документа органа государственной власти', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8877', '086a', 141, N'- классификационный номер/номер документа.', 1, NULL, NULL, N'- классификационный номер/номер документа.', 8876, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8878', '086z', 141, N'- отменённый/ошибочный классификационный номер/номер документа.', 1, NULL, NULL, N'- отменённый/ошибочный классификационный номер/номер документа.', 8876, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8879', '0862', 141, N'- источник номера.', 1, NULL, NULL, N'- источник номера.', 8876, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8880', '0866', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8876, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8881', '0868', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8876, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8882', '088', 141, N'Номер отчёта', 0, NULL, NULL, N'Номер отчёта', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8883', '088a', 141, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 8882, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8884', '088z', 141, N'- отменённый/ошибочный номер отчёта.', 1, NULL, NULL, N'- отменённый/ошибочный номер отчёта.', 8882, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8885', '0886', 141, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8882, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8886', '0888', 141, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8882, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8887', '100', 142, N'Имя лица как основной поисковый признак (заголовок, содержащий имя лица)', 0, NULL, NULL, N'Имя лица как основной поисковый признак (заголовок, содержащий имя лица)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8888', '100a', 142, N'- имя лица.', 1, NULL, NULL, N'- имя лица.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8889', '100b', 142, N'- нумерация.', 1, NULL, NULL, N'- нумерация.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8890', '100c', 142, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8891', '100d', 142, N'- даты, относящиеся к имени.', 1, NULL, NULL, N'- даты, относящиеся к имени.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8892', '100e', 142, N'- роль лица относительно произведения.', 1, NULL, NULL, N'- роль лица относительно произведения.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8893', '100g', 142, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8894', '100j', 142, N'- принадлежность неизвестного автора к последователям, ученикам, сторонникам, школе и т. д.', 1, NULL, NULL, N'- принадлежность неизвестного автора к последователям, ученикам, сторонникам, школе и т. д.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8895', '100q', 142, N'- более полная форма имени.', 1, NULL, NULL, N'- более полная форма имени.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8896', '100u', 142, N'- место работы, членство или адрес лица.', 1, NULL, NULL, N'- место работы, членство или адрес лица.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8897', '1004', 142, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8898', '1006', 142, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8899', '1008', 142, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8887, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8900', '110', 142, N'Наименование коллектива/постоянной организации как основной поисковый признак (заголовок, содержащий наименование коллектива/постоянной организации)', 0, NULL, NULL, N'Наименование коллектива/постоянной организации как основной поисковый признак (заголовок, содержащий наименование коллектива/постоянной организации)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8901', '110a', 142, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 1, NULL, NULL, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8902', '110b', 142, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8903', '110c', 142, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8904', '110d', 142, N'- дата проведения мероприятия или подписания договора.', 1, NULL, NULL, N'- дата проведения мероприятия или подписания договора.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8905', '110e', 142, N'- роль коллектива относительно произведения.', 1, NULL, NULL, N'- роль коллектива относительно произведения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8906', '110f', 142, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8907', '110g', 142, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8908', '110k', 142, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8909', '110l', 142, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8910', '110n', 142, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8911', '110p', 142, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8912', '110t', 142, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8913', '110u', 142, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8914', '1104', 142, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8915', '1106', 142, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8916', '1108', 142, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8900, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8917', '111', 142, N'Наименование мероприятия/временного коллектива/организации как основной поисковый признак (заголовок, содержащий наименование мероприятия/временного коллектива/организации)', 0, NULL, NULL, N'Наименование мероприятия/временного коллектива/организации как основной поисковый признак (заголовок, содержащий наименование мероприятия/временного коллектива/организации)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8918', '111a', 142, N'- наименование мероприятия как начальный элемент ввода.', 1, NULL, NULL, N'- наименование мероприятия как начальный элемент ввода.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8919', '111c', 142, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8920', '111d', 142, N'- дата проведения мероприятия.', 1, NULL, NULL, N'- дата проведения мероприятия.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8921', '111e', 142, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8922', '111g', 142, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8923', '111n', 142, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8924', '111u', 142, N'- ', 1, NULL, NULL, N'- ', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8925', '1114', 142, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8926', '1116', 142, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8927', '1118', 142, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8917, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8928', '130', 142, N'Унифицированное заглавие как основной поисковый признак (заголовок, содержащий унифицированное заглавие)', 0, NULL, NULL, N'Унифицированное заглавие как основной поисковый признак (заголовок, содержащий унифицированное заглавие)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8929', '130a', 142, N'- унифицированное заглавие.', 1, NULL, NULL, N'- унифицированное заглавие.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8930', '130d', 142, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8931', '130f', 142, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8932', '130g', 142, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8933', '130h', 142, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8934', '130k', 142, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8935', '130l', 142, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8936', '130m', 142, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8937', '130n', 142, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8938', '130o', 142, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8939', '130p', 142, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8940', '130r', 142, N'- тональность.', 1, NULL, NULL, N'- тональность.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8941', '130s', 142, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8942', '1306', 142, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8943', '1308', 142, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8928, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8944', '210', 143, N'Сокращённое заглавие', 0, NULL, NULL, N'Сокращённое заглавие', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8945', '210a', 143, N'- сокращённое заглавие.', 1, NULL, NULL, N'- сокращённое заглавие.', 8944, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8946', '210b', 143, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 8944, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8947', '2102', 143, N'- источник сведений.', 1, NULL, NULL, N'- источник сведений.', 8944, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8948', '2106', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8944, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8949', '2108', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8944, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8950', '222', 143, N'Ключевое заглавие сериального издания', 0, NULL, NULL, N'Ключевое заглавие сериального издания', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8951', '222a', 143, N'- ключевое заглавие продолжающегося ресурса.', 1, NULL, NULL, N'- ключевое заглавие продолжающегося ресурса.', 8950, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8952', '222b', 143, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 8950, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8953', '2226', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8950, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8954', '2228', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8950, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8955', '240', 143, N'Условное заглавие', 0, NULL, NULL, N'Условное заглавие', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8956', '240a', 143, N'- условное заглавие.', 1, NULL, NULL, N'- условное заглавие.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8957', '240d', 143, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8958', '240f', 143, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8959', '240g', 143, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8960', '240h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8961', '240k', 143, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8962', '240l', 143, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8963', '240m', 143, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8964', '240n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8965', '240o', 143, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8966', '240p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8967', '240r', 143, N'- тональность.', 1, NULL, NULL, N'- тональность.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8968', '240s', 143, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8969', '2406', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8970', '2408', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8955, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8971', '242', 143, N'Перевод заглавия каталогизирующей организацией', 0, NULL, NULL, N'Перевод заглавия каталогизирующей организацией', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8972', '242a', 143, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8973', '242b', 143, N'- сведения, относящиеся к заглавию, и т . д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т . д.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8974', '242c', 143, N'- сведения об ответственности и т. д.', 1, NULL, NULL, N'- сведения об ответственности и т. д.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8975', '242h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8976', '242n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8977', '242p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8978', '242y', 143, N'- код языка перевода.', 1, NULL, NULL, N'- код языка перевода.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8979', '2426', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8980', '2428', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8971, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8981', '243', 143, N'Обобщающее заглавие', 0, NULL, NULL, N'Обобщающее заглавие', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8982', '243a', 143, N'- обобщающее заглавие.', 1, NULL, NULL, N'- обобщающее заглавие.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8983', '243d', 143, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8984', '243f', 143, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8985', '243g', 143, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8986', '243h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8987', '243k', 143, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8988', '243l', 143, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8989', '243m', 143, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8990', '243n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8991', '243o', 143, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8992', '243p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8993', '243r', 143, N'- тональность.', 1, NULL, NULL, N'- тональность.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8994', '243s', 143, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8995', '2436', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8996', '2438', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8981, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8997', '245', 143, N'Область заглавия и сведений об ответственности', 0, NULL, NULL, N'Область заглавия и сведений об ответственности', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8998', '245a', 143, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('8999', '245b', 143, N'- сведения, относящиеся к заглавию, и т. д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т. д.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9000', '245c', 143, N'- сведения об ответственности и т. д.', 1, NULL, NULL, N'- сведения об ответственности и т. д.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9001', '245f', 143, N'- дата создания произведения.', 1, NULL, NULL, N'- дата создания произведения.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9002', '245g', 143, N'- даты создания основной части содержимого.', 1, NULL, NULL, N'- даты создания основной части содержимого.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9003', '245h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9004', '245k', 143, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9005', '245n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9006', '245p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9007', '245s', 143, N'- версия, вариант и т. п.', 1, NULL, NULL, N'- версия, вариант и т. п.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9008', '2456', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9009', '2458', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 8997, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9010', '246', 143, N'Вариант заглавия', 0, NULL, NULL, N'Вариант заглавия', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9011', '246a', 143, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9012', '246b', 143, N'- сведения, относящиеся к заглавию, и т. д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т. д.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9013', '246f', 143, N'- обозначение тома и номер выпуска и/или дата.', 1, NULL, NULL, N'- обозначение тома и номер выпуска и/или дата.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9014', '246g', 143, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9015', '246h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9016', '246i', 143, N'- пояснительный текст.', 1, NULL, NULL, N'- пояснительный текст.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9017', '246n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9018', '246p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9019', '2465', 143, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9020', '2466', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9021', '2468', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9010, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9022', '247', 143, N'Предыдущее/прежнее заглавие продолжающегося ресурса', 0, NULL, NULL, N'Предыдущее/прежнее заглавие продолжающегося ресурса', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9023', '247a', 143, N'- заглавие сериального издания.', 1, NULL, NULL, N'- заглавие сериального издания.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9024', '247b', 143, N'- сведения, относящиеся к заглавию, и т. д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т. д.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9025', '247f', 143, N'- обозначение тома и номер выпуска и/или дата.', 1, NULL, NULL, N'- обозначение тома и номер выпуска и/или дата.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9026', '247g', 143, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9027', '247h', 143, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9028', '247n', 143, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9029', '247p', 143, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9030', '247x', 143, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9031', '2476', 143, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9032', '2478', 143, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9022, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9033', '250', 144, N'Область издания', 0, NULL, NULL, N'Область издания', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9034', '250a', 144, N'- сведения об издании.', 1, NULL, NULL, N'- сведения об издании.', 9033, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9035', '250b', 144, N'- сведения об ответственности, относящиеся к данному изданию.', 1, NULL, NULL, N'- сведения об ответственности, относящиеся к данному изданию.', 9033, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9036', '2506', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9033, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9037', '2508', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9033, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9038', '254', 144, N'Форма изложения нотного текста', 0, NULL, NULL, N'Форма изложения нотного текста', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9039', '254a', 144, N'- название формы изложения.', 1, NULL, NULL, N'- название формы изложения.', 9038, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9040', '2546', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9038, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9041', '2548', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9038, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9042', '255', 144, N'Математическая основа картографического произведения', 0, NULL, NULL, N'Математическая основа картографического произведения', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9043', '255a', 144, N'- масштаб.', 1, NULL, NULL, N'- масштаб.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9044', '255b', 144, N'- проекция.', 1, NULL, NULL, N'- проекция.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9045', '255c', 144, N'- координаты.', 1, NULL, NULL, N'- координаты.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9046', '255d', 144, N'- зона.', 1, NULL, NULL, N'- зона.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9047', '255e', 144, N'- равноденствие.', 1, NULL, NULL, N'- равноденствие.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9048', '255f', 144, N'- координатные пары внешнего G-контура.', 1, NULL, NULL, N'- координатные пары внешнего G-контура.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9049', '255g', 144, N'- координатные пары исключающего G-контура.', 1, NULL, NULL, N'- координатные пары исключающего G-контура.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9050', '2556', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9051', '2558', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9042, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9052', '256', 144, N'Характеристики электронного ресурса', 0, NULL, NULL, N'Характеристики электронного ресурса', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9053', '256a', 144, N'- характеристики электронного ресурса.', 1, NULL, NULL, N'- характеристики электронного ресурса.', 9052, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9054', '2566', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9052, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9055', '2568', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9052, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9056', '258', 144, N'Данные о филателистическом материале', 0, NULL, NULL, N'Данные о филателистическом материале', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9057', '258a', 144, N'- юрисдикция.', 1, NULL, NULL, N'- юрисдикция.', 9056, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9058', '258b', 144, N'- номинал.', 1, NULL, NULL, N'- номинал.', 9056, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9059', '2586', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9056, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9060', '2588', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9056, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9061', '260', 144, N'Область выходных данных', 0, NULL, NULL, N'Область выходных данных', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9062', '260a', 144, N'- место публикации, распространения, изготовления и т. д.', 1, NULL, NULL, N'- место публикации, распространения, изготовления и т. д.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9063', '260b', 144, N'- издательство, издатель, распространитель и т. д.', 1, NULL, NULL, N'- издательство, издатель, распространитель и т. д.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9064', '260c', 144, N'- дата издания, распространения и т. д.', 1, NULL, NULL, N'- дата издания, распространения и т. д.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9065', '260e', 144, N'- место печатания.', 1, NULL, NULL, N'- место печатания.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9066', '260f', 144, N'- типография.', 1, NULL, NULL, N'- типография.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9067', '260g', 144, N'- дата печатания.', 1, NULL, NULL, N'- дата печатания.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9068', '2603', 144, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9069', '2606', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9070', '2608', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9061, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9071', '263', 144, N'Планируемая дата публикации', 0, NULL, NULL, N'Планируемая дата публикации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9072', '263a', 144, N'- планируемая дата публикации.', 1, NULL, NULL, N'- планируемая дата публикации.', 9071, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9073', '2636', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9071, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9074', '2638', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9071, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9075', '270', 144, N'Адрес', 0, NULL, NULL, N'Адрес', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9076', '270a', 144, N'- адресные данные кроме тех, что записываются в другие подполя.', 1, NULL, NULL, N'- адресные данные кроме тех, что записываются в другие подполя.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9077', '270b', 144, N'- город.', 1, NULL, NULL, N'- город.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9078', '270c', 144, N'- область, край, штат.', 1, NULL, NULL, N'- область, край, штат.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9079', '270d', 144, N'- страна.', 1, NULL, NULL, N'- страна.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9080', '270e', 144, N'- почтовый код.', 1, NULL, NULL, N'- почтовый код.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9081', '270f', 144, N'- обращение (титул, звание, степень) к адресату.', 1, NULL, NULL, N'- обращение (титул, звание, степень) к адресату.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9082', '270g', 144, N'- адресат.', 1, NULL, NULL, N'- адресат.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9083', '270h', 144, N'- должность адресата.', 1, NULL, NULL, N'- должность адресата.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9084', '270i', 144, N'- тип адреса.', 1, NULL, NULL, N'- тип адреса.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9085', '270j', 144, N'- специально выделенный телефонный номер.', 1, NULL, NULL, N'- специально выделенный телефонный номер.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9086', '270l', 144, N'- факс.', 1, NULL, NULL, N'- факс.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9087', '270m', 144, N'- адрес электронной почты.', 1, NULL, NULL, N'- адрес электронной почты.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9088', '270n', 144, N'- номер TDD или TTY.', 1, NULL, NULL, N'- номер TDD или TTY.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9089', '270p', 144, N'- контактное лицо.', 1, NULL, NULL, N'- контактное лицо.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9090', '270q', 144, N'- обращение (титул, звание, степень) к контактному лицу.', 1, NULL, NULL, N'- обращение (титул, звание, степень) к контактному лицу.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9091', '270r', 144, N'- часы работы.', 1, NULL, NULL, N'- часы работы.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9092', '270z', 144, N'- неслужебное примечание.', 1, NULL, NULL, N'- неслужебное примечание.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9093', '2704', 144, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9094', '2706', 144, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9095', '2708', 144, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9075, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9096', '300', 145, N'Область количественной характеристики', 0, NULL, NULL, N'Область количественной характеристики', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9097', '300a', 145, N'- объём.', 1, NULL, NULL, N'- объём.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9098', '300b', 145, N'- прочее.', 1, NULL, NULL, N'- прочее.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9099', '300c', 145, N'- размеры.', 1, NULL, NULL, N'- размеры.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9100', '300e', 145, N'- сопроводительный материал. ', 1, NULL, NULL, N'- сопроводительный материал. ', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9101', '300f', 145, N'- тип единицы измерения.', 1, NULL, NULL, N'- тип единицы измерения.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9102', '300g', 145, N'- количество единиц измерения.', 1, NULL, NULL, N'- количество единиц измерения.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9103', '3003', 145, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9104', '3006', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9105', '3008', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9096, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9106', '306', 145, N'Продолжительность проигрывания/время звучания', 0, NULL, NULL, N'Продолжительность проигрывания/время звучания', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9107', '306a', 145, N'- продолжительность проигрывания.', 1, NULL, NULL, N'- продолжительность проигрывания.', 9106, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9108', '3066', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9106, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9109', '3068', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9106, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9110', '307', 145, N'Часы работы, доступа и т. д.', 0, NULL, NULL, N'Часы работы, доступа и т. д.', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9111', '307a', 145, N'- часы работы, доступа и т. д.', 1, NULL, NULL, N'- часы работы, доступа и т. д.', 9110, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9112', '307b', 145, N'- дополнительные сведения.', 1, NULL, NULL, N'- дополнительные сведения.', 9110, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9113', '3076', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9110, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9114', '3078', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9110, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9115', '310', 145, N'Периодичность в настоящее время', 0, NULL, NULL, N'Периодичность в настоящее время', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9116', '310a', 145, N'- периодичность в настоящее время.', 1, NULL, NULL, N'- периодичность в настоящее время.', 9115, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9117', '310b', 145, N'- дата введения текущей периодичности.', 1, NULL, NULL, N'- дата введения текущей периодичности.', 9115, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9118', '3106', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9115, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9119', '3108', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9115, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9120', '321', 145, N'Прежняя периодичность', 0, NULL, NULL, N'Прежняя периодичность', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9121', '321a', 145, N'- прежняя периодичность.', 1, NULL, NULL, N'- прежняя периодичность.', 9120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9122', '321b', 145, N'- даты существования прежней периодичности.', 1, NULL, NULL, N'- даты существования прежней периодичности.', 9120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9123', '3216', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9124', '3218', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9125', '340', 145, N'Физический носитель', 0, NULL, NULL, N'Физический носитель', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9126', '340a', 145, N'- материал и конфигурация.', 1, NULL, NULL, N'- материал и конфигурация.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9127', '340b', 145, N'- размеры.', 1, NULL, NULL, N'- размеры.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9128', '340c', 145, N'- материал, нанесённый на поверхность.', 1, NULL, NULL, N'- материал, нанесённый на поверхность.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9129', '340d', 145, N'- техника записи информации.', 1, NULL, NULL, N'- техника записи информации.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9130', '340e', 145, N'- основа.', 1, NULL, NULL, N'- основа.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9131', '340f', 145, N'- кратность, число оборотов.', 1, NULL, NULL, N'- кратность, число оборотов.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9132', '340h', 145, N'- местонахождение на носителе.', 1, NULL, NULL, N'- местонахождение на носителе.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9133', '340i', 145, N'- технические требования для доступа.', 1, NULL, NULL, N'- технические требования для доступа.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9134', '3403', 145, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9135', '3406', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9136', '3408', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9125, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9137', '342', 145, N'Геопространственные справочные данные', 0, NULL, NULL, N'Геопространственные справочные данные', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9138', '342a', 145, N'- название проекции.', 1, NULL, NULL, N'- название проекции.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9139', '342b', 145, N'- единицы измерения координат или расстояний.', 1, NULL, NULL, N'- единицы измерения координат или расстояний.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9140', '342c', 145, N'- разрешение по широте.', 1, NULL, NULL, N'- разрешение по широте.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9141', '342d', 145, N'- разрешение по долготе.', 1, NULL, NULL, N'- разрешение по долготе.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9142', '342e', 145, N'- главная параллель или центральная линия проекции.', 1, NULL, NULL, N'- главная параллель или центральная линия проекции.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9143', '342f', 145, N'- косая линия долготы.', 1, NULL, NULL, N'- косая линия долготы.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9144', '342g', 145, N'- долгота осевого меридиана или центра проекции.', 1, NULL, NULL, N'- долгота осевого меридиана или центра проекции.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9145', '342h', 145, N'- широта центра проекции или начала прямоугольных координат.', 1, NULL, NULL, N'- широта центра проекции или начала прямоугольных координат.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9146', '342i', 145, N'- условная ордината по перпендикулярному осевому меридиану направлению.', 1, NULL, NULL, N'- условная ордината по перпендикулярному осевому меридиану направлению.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9147', '342j', 145, N'- условная абсцисса по направлению осевого меридиана.', 1, NULL, NULL, N'- условная абсцисса по направлению осевого меридиана.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9148', '342k', 145, N'- масштабный коэффициент.', 1, NULL, NULL, N'- масштабный коэффициент.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9149', '342l', 145, N'- высота над поверхностью.', 1, NULL, NULL, N'- высота над поверхностью.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9150', '342m', 145, N'- азимутальный угол.', 1, NULL, NULL, N'- азимутальный угол.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9151', '342n', 145, N'- азимут или истинный азимут.', 1, NULL, NULL, N'- азимут или истинный азимут.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9152', '342o', 145, N'- номер Ландсет и его адрес.', 1, NULL, NULL, N'- номер Ландсет и его адрес.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9153', '342p', 145, N'- идентификатор зоны.', 1, NULL, NULL, N'- идентификатор зоны.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9154', '342q', 145, N'- название элипсоида.', 1, NULL, NULL, N'- название элипсоида.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9155', '342r', 145, N'- большая полуось элипсоида.', 1, NULL, NULL, N'- большая полуось элипсоида.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9156', '342s', 145, N'- знаменатель сжатия.', 1, NULL, NULL, N'- знаменатель сжатия.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9157', '342t', 145, N'- вертикальное разрешение.', 1, NULL, NULL, N'- вертикальное разрешение.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9158', '342u', 145, N'- вертикальное разрешение.', 1, NULL, NULL, N'- вертикальное разрешение.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9159', '342v', 145, N'- локальная плоская, локальная или другая проекция или сетка координат.', 1, NULL, NULL, N'- локальная плоская, локальная или другая проекция или сетка координат.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9160', '342w', 145, N'- информация о локальной плоской или локальной системе.', 1, NULL, NULL, N'- информация о локальной плоской или локальной системе.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9161', '3422', 145, N'- геопространственный метод.', 1, NULL, NULL, N'- геопространственный метод.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9162', '3426', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9163', '3428', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9137, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9164', '343', 145, N'Данные о плоских координатах', 0, NULL, NULL, N'Данные о плоских координатах', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9165', '343a', 145, N'- метод кодирования плоских координат.', 1, NULL, NULL, N'- метод кодирования плоских координат.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9166', '343b', 145, N'- единица измерения плоских координат.', 1, NULL, NULL, N'- единица измерения плоских координат.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9167', '343c', 145, N'- разрешение по оси абсцисс.', 1, NULL, NULL, N'- разрешение по оси абсцисс.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9168', '343d', 145, N'- разрешение по оси ординат.', 1, NULL, NULL, N'- разрешение по оси ординат.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9169', '343e', 145, N'- разрешение по расстоянию.', 1, NULL, NULL, N'- разрешение по расстоянию.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9170', '343f', 145, N'- разрешение по пеленгу.', 1, NULL, NULL, N'- разрешение по пеленгу.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9171', '343g', 145, N'- единица измерения пеленга.', 1, NULL, NULL, N'- единица измерения пеленга.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9172', '343h', 145, N'- ссылка на направление пеленга.', 1, NULL, NULL, N'- ссылка на направление пеленга.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9173', '343i', 145, N'- ссылка на меридиан пеленга.', 1, NULL, NULL, N'- ссылка на меридиан пеленга.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9174', '3436', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9175', '3438', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9164, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9176', '351', 145, N'Внутренняя организация материала', 0, NULL, NULL, N'Внутренняя организация материала', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9177', '351a', 145, N'- организация (структура) материала.', 1, NULL, NULL, N'- организация (структура) материала.', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9178', '351b', 145, N'- порядок сортировки.', 1, NULL, NULL, N'- порядок сортировки.', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9179', '351c', 145, N'- иерархический уровень.', 1, NULL, NULL, N'- иерархический уровень.', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9180', '3513', 145, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9181', '3516', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9182', '3518', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9176, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9183', '355', 145, N'Управление защитой информации от несанкционированного доступа', 0, NULL, NULL, N'Управление защитой информации от несанкционированного доступа', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9184', '355a', 145, N'- степень секретности.', 1, NULL, NULL, N'- степень секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9185', '355b', 145, N'- имеющие доступ к засекреченным данным внутри организации.', 1, NULL, NULL, N'- имеющие доступ к засекреченным данным внутри организации.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9186', '355c', 145, N'- иностранные государства, имеющие доступ к засекреченным данным.', 1, NULL, NULL, N'- иностранные государства, имеющие доступ к засекреченным данным.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9187', '355d', 145, N'- основание снижения степени или отмены секретности.', 1, NULL, NULL, N'- основание снижения степени или отмены секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9188', '355e', 145, N'- система классификации степени секретности.', 1, NULL, NULL, N'- система классификации степени секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9189', '355f', 145, N'- код страны использованной системы классификации.', 1, NULL, NULL, N'- код страны использованной системы классификации.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9190', '355g', 145, N'- дата понижения степени секретности.', 1, NULL, NULL, N'- дата понижения степени секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9191', '355h', 145, N'- дата отмены секретности.', 1, NULL, NULL, N'- дата отмены секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9192', '355j', 145, N'- код организации, изменившей степень секретности.', 1, NULL, NULL, N'- код организации, изменившей степень секретности.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9193', '3556', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9194', '3558', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9183, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9195', '357', 145, N'Авторский контроль за распространением', 0, NULL, NULL, N'Авторский контроль за распространением', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9196', '357a', 145, N'- пункт/статья/условия.', 1, NULL, NULL, N'- пункт/статья/условия.', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9197', '357b', 145, N'- автор, создатель и т. п.', 1, NULL, NULL, N'- автор, создатель и т. п.', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9198', '357c', 145, N'- имеющие право на получение материала.', 1, NULL, NULL, N'- имеющие право на получение материала.', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9199', '357g', 145, N'- прочие ограничения.', 1, NULL, NULL, N'- прочие ограничения.', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9200', '3576', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9201', '3578', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9195, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9202', '362', 145, N'Даты публикации и/или обозначение и номер тома', 0, NULL, NULL, N'Даты публикации и/или обозначение и номер тома', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9203', '362a', 145, N'- даты публикации и/или порядковое обозначение.', 1, NULL, NULL, N'- даты публикации и/или порядковое обозначение.', 9202, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9204', '362z', 145, N'- источник сведений.', 1, NULL, NULL, N'- источник сведений.', 9202, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9205', '3626', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9202, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9206', '3628', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9202, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9207', '365', 145, N'Розничная цена', 0, NULL, NULL, N'Розничная цена', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9208', '365a', 145, N'- код типа цены.', 1, NULL, NULL, N'- код типа цены.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9209', '365b', 145, N'- сумма.', 1, NULL, NULL, N'- сумма.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9210', '365c', 145, N'- код валюты.', 1, NULL, NULL, N'- код валюты.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9211', '365d', 145, N'- цена за (код).', 1, NULL, NULL, N'- цена за (код).', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9212', '365e', 145, N'- примечание к цене.', 1, NULL, NULL, N'- примечание к цене.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9213', '365f', 145, N'- цена действительна с.', 1, NULL, NULL, N'- цена действительна с.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9214', '365g', 145, N'- цена действительна до.', 1, NULL, NULL, N'- цена действительна до.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9215', '365h', 145, N'- добавленная стоимость 1.', 1, NULL, NULL, N'- добавленная стоимость 1.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9216', '365i', 145, N'- добавленная стоимость 2.', 1, NULL, NULL, N'- добавленная стоимость 2.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9217', '365j', 145, N'- код страны по ISO.', 1, NULL, NULL, N'- код страны по ISO.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9218', '365k', 145, N'- код страны по MARC.', 1, NULL, NULL, N'- код страны по MARC.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9219', '365m', 145, N'- организация.', 1, NULL, NULL, N'- организация.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9220', '3652', 145, N'- источник кода типа цены.', 1, NULL, NULL, N'- источник кода типа цены.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9221', '3656', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9222', '3658', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9207, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9223', '366', 145, N'Сведения для покупки у издателя', 0, NULL, NULL, N'Сведения для покупки у издателя', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9224', '366a', 145, N'- издательские краткие идентифицирующие сведения (заглавие).', 1, NULL, NULL, N'- издательские краткие идентифицирующие сведения (заглавие).', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9225', '366b', 145, N'- точная (подробная) дата публикации.', 1, NULL, NULL, N'- точная (подробная) дата публикации.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9226', '366c', 145, N'- код статуса публикации.', 1, NULL, NULL, N'- код статуса публикации.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9227', '366d', 145, N'-планируемая дата поступления в продажу. ', 1, NULL, NULL, N'-планируемая дата поступления в продажу. ', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9228', '366e', 145, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9229', '366f', 145, N'- код издательской скидки.', 1, NULL, NULL, N'- код издательской скидки.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9230', '366g', 145, N'- дата выхода из печати.', 1, NULL, NULL, N'- дата выхода из печати.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9231', '366j', 145, N'- код страны по ISO.', 1, NULL, NULL, N'- код страны по ISO.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9232', '366k', 145, N'- код страны по MARC.', 1, NULL, NULL, N'- код страны по MARC.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9233', '366m', 145, N'- организация.', 1, NULL, NULL, N'- организация.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9234', '3662', 145, N'- источник кода статуса публикации.', 1, NULL, NULL, N'- источник кода статуса публикации.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9235', '3666', 145, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9236', '3668', 145, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9223, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9237', '440', 146, N'Область серии/добавочный поисковый признак на заглавие серии', 0, NULL, NULL, N'Область серии/добавочный поисковый признак на заглавие серии', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9238', '440a', 146, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9239', '440n', 146, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9240', '440p', 146, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9241', '440v', 146, N'- обозначение и номер тома/порядковое обозначение.', 1, NULL, NULL, N'- обозначение и номер тома/порядковое обозначение.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9242', '440x', 146, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9243', '4406', 146, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9244', '4408', 146, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9237, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9245', '490', 146, N'Область серии', 0, NULL, NULL, N'Область серии', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9246', '490a', 146, N'- область серии.', 1, NULL, NULL, N'- область серии.', 9245, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9247', '490v', 146, N'- обозначение и номер тома/порядковое обозначение.', 1, NULL, NULL, N'- обозначение и номер тома/порядковое обозначение.', 9245, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9248', '490x', 146, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9245, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9249', '4906', 146, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9245, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9250', '4908', 146, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9245, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9251', '500', 147, N'Примечание общего характера', 0, NULL, NULL, N'Примечание общего характера', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9252', '500a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9251, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9253', '5003', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9251, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9254', '5005', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9251, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9255', '5006', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9251, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9256', '5008', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9251, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9257', '501', 147, N'Примечание о наличии в одной физической единице нескольких библиографических объектов/Владельческий или издательский конволют', 0, NULL, NULL, N'Примечание о наличии в одной физической единице нескольких библиографических объектов/Владельческий или издательский конволют', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9258', '501a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9259', '5015', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9260', '5016', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9261', '5018', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9262', '502', 147, N'Примечание к диссертации', 0, NULL, NULL, N'Примечание к диссертации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9263', '502a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9262, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9264', '5026', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9262, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9265', '5028', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9262, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9266', '504', 147, N'Примечание о наличии библиографических перечней и ссылок', 0, NULL, NULL, N'Примечание о наличии библиографических перечней и ссылок', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9267', '504a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9266, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9268', '504b', 147, N'- количество ссылок.', 1, NULL, NULL, N'- количество ссылок.', 9266, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9269', '5046', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9266, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9270', '5048', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9266, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9271', '505', 147, N'Форматированное примечание о содержании', 0, NULL, NULL, N'Форматированное примечание о содержании', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9272', '505a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9273', '505g', 147, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9274', '505r', 147, N'- сведения об ответственности.', 1, NULL, NULL, N'- сведения об ответственности.', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9275', '505t', 147, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9276', '505u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9277', '5056', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9278', '5058', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9271, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9279', '506', 147, N'Ограничения на доступ к материалу', 0, NULL, NULL, N'Ограничения на доступ к материалу', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9280', '506a', 147, N'- наименование ограничения.', 1, NULL, NULL, N'- наименование ограничения.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9281', '506b', 147, N'- лицо или организация, установившие ограничение.', 1, NULL, NULL, N'- лицо или организация, установившие ограничение.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9282', '506c', 147, N'- что необходимо для получения права доступа.', 1, NULL, NULL, N'- что необходимо для получения права доступа.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9283', '506d', 147, N'- на кого ограничение не распространяется.', 1, NULL, NULL, N'- на кого ограничение не распространяется.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9284', '506e', 147, N'- основание для введения ограничения.', 1, NULL, NULL, N'- основание для введения ограничения.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9285', '506u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9286', '5063', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9287', '5065', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9288', '5066', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9289', '5068', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9279, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9290', '510', 147, N'Примечание о цитировании/ссылках', 0, NULL, NULL, N'Примечание о цитировании/ссылках', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9291', '510a', 147, N'- наименование источника.', 1, NULL, NULL, N'- наименование источника.', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9292', '510b', 147, N'- охват.', 1, NULL, NULL, N'- охват.', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9293', '510c', 147, N'- местонахождение в источнике.', 1, NULL, NULL, N'- местонахождение в источнике.', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9294', '510x', 147, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9295', '5103', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9296', '5106', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9297', '5108', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9290, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9298', '513', 147, N'Вид отчёта и отчётный период', 0, NULL, NULL, N'Вид отчёта и отчётный период', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9299', '513a', 147, N'- вид отчёта.', 1, NULL, NULL, N'- вид отчёта.', 9298, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9300', '513b', 147, N'- отчётный период.', 1, NULL, NULL, N'- отчётный период.', 9298, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9301', '5136', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9298, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9302', '5138', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9298, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9303', '514', 147, N'Примечание о качестве данных ', 0, NULL, NULL, N'Примечание о качестве данных ', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9304', '514a', 147, N'- сведения о точности определения данных.', 1, NULL, NULL, N'- сведения о точности определения данных.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9305', '514b', 147, N'- оценка точности определения.', 1, NULL, NULL, N'- оценка точности определения.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9306', '514c', 147, N'- пояснения точности определения.', 1, NULL, NULL, N'- пояснения точности определения.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9307', '514d', 147, N'- сведения о постоянстве отношений и тестирования.', 1, NULL, NULL, N'- сведения о постоянстве отношений и тестирования.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9308', '514e', 147, N'- сведения о полноте.', 1, NULL, NULL, N'- сведения о полноте.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9309', '514f', 147, N'- сведения о точности измерения горизонтальных координат.', 1, NULL, NULL, N'- сведения о точности измерения горизонтальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9310', '514g', 147, N'- оценка точности измерения горизонтальных координат.', 1, NULL, NULL, N'- оценка точности измерения горизонтальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9311', '514h', 147, N'- пояснения точности измерения горизонтальных координат.', 1, NULL, NULL, N'- пояснения точности измерения горизонтальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9312', '514i', 147, N'- сведения о точности измерения вертикальных координат.', 1, NULL, NULL, N'- сведения о точности измерения вертикальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9313', '514j', 147, N'- оценка точности измерения вертикальных координат.', 1, NULL, NULL, N'- оценка точности измерения вертикальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9314', '514k', 147, N'- пояснения точности измерения вертикальных координат.', 1, NULL, NULL, N'- пояснения точности измерения вертикальных координат.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9315', '514m', 147, N'- закрытая облаками область (в процентах).', 1, NULL, NULL, N'- закрытая облаками область (в процентах).', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9316', '514u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9317', '514z', 147, N'- примечание для ЭК.', 1, NULL, NULL, N'- примечание для ЭК.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9318', '5146', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9319', '5148', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9303, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9320', '515', 147, N'Примечание об особенностях нумерации', 0, NULL, NULL, N'Примечание об особенностях нумерации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9321', '515a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9320, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9322', '5156', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9320, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9323', '5158', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9320, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9324', '516', 147, N'Примечание о типе компьютерного файла или данных', 0, NULL, NULL, N'Примечание о типе компьютерного файла или данных', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9325', '516a', 147, N'- тип компьютерного файла или данных.', 1, NULL, NULL, N'- тип компьютерного файла или данных.', 9324, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9326', '5166', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9324, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9327', '5168', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9324, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9328', '520', 147, N'Резюме, аннотация, реферат и т. д.', 0, NULL, NULL, N'Резюме, аннотация, реферат и т. д.', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9329', '520a', 147, N'- резюме, аннотация, реферат и т. д.', 1, NULL, NULL, N'- резюме, аннотация, реферат и т. д.', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9330', '520b', 147, N'- дополнительные сведения.', 1, NULL, NULL, N'- дополнительные сведения.', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9331', '520u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9332', '5203', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9333', '5206', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9334', '5208', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9328, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9335', '521', 147, N'Читательское назначение', 0, NULL, NULL, N'Читательское назначение', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9336', '521a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9335, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9337', '521b', 147, N'- источник сведений.', 1, NULL, NULL, N'- источник сведений.', 9335, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9338', '5213', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9335, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9339', '5216', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9335, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9340', '5218', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9335, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9341', '522', 147, N'Примечание о географическом регионе', 0, NULL, NULL, N'Примечание о географическом регионе', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9342', '522a', 147, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9341, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9343', '5226', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9341, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9344', '5228', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9341, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9345', '525', 147, N'Примечание о приложениях', 0, NULL, NULL, N'Примечание о приложениях', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9346', '525a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9345, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9347', '5256', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9345, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9348', '5258', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9345, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9349', '530', 147, N'Примечание о наличии документа в другой физической форме', 0, NULL, NULL, N'Примечание о наличии документа в другой физической форме', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9350', '530a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9351', '530b', 147, N'- распространитель.', 1, NULL, NULL, N'- распространитель.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9352', '530c', 147, N'- условия получения.', 1, NULL, NULL, N'- условия получения.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9353', '530d', 147, N'- номер для заказа.', 1, NULL, NULL, N'- номер для заказа.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9354', '530u', 147, N'- унифицированный определитель ресурса.', 1, NULL, NULL, N'- унифицированный определитель ресурса.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9355', '5303', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9356', '5306', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9357', '5308', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9349, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9358', '533', 147, N'Примечание о копиях', 0, NULL, NULL, N'Примечание о копиях', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9359', '533a', 147, N'- тип копии.', 1, NULL, NULL, N'- тип копии.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9360', '533b', 147, N'- место копирования.', 1, NULL, NULL, N'- место копирования.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9361', '533c', 147, N'- организация, ответственная за копирование.', 1, NULL, NULL, N'- организация, ответственная за копирование.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9362', '533d', 147, N'- дата копирования.', 1, NULL, NULL, N'- дата копирования.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9363', '533e', 147, N'- физическое описание копии.', 1, NULL, NULL, N'- физическое описание копии.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9364', '533f', 147, N'- область серии копии.', 1, NULL, NULL, N'- область серии копии.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9365', '533m', 147, N'- даты и/или порядковое обозначение воспроизведённых выпусков.', 1, NULL, NULL, N'- даты и/или порядковое обозначение воспроизведённых выпусков.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9366', '533n', 147, N'- примечание к копии.', 1, NULL, NULL, N'- примечание к копии.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9367', '5333', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9368', '5336', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9369', '5337', 147, N'- элементы данных фиксированной длины для копии.', 1, NULL, NULL, N'- элементы данных фиксированной длины для копии.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9370', '5338', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9358, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9371', '534', 147, N'Примечание об оригинале', 0, NULL, NULL, N'Примечание об оригинале', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9372', '534p', 147, N'- вводные слова.', 1, NULL, NULL, N'- вводные слова.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9373', '534a', 147, N'- основной поисковый признак записи на оригинал.', 1, NULL, NULL, N'- основной поисковый признак записи на оригинал.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9374', '534t', 147, N'- область заглавия оригинала.', 1, NULL, NULL, N'- область заглавия оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9375', '534b', 147, N'- область издания.', 1, NULL, NULL, N'- область издания.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9376', '534m', 147, N'- специфические характеристики.', 1, NULL, NULL, N'- специфические характеристики.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9377', '534c', 147, N'- выходные данные оригинала.', 1, NULL, NULL, N'- выходные данные оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9378', '534e', 147, N'- физические характеристики оригинала.', 1, NULL, NULL, N'- физические характеристики оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9379', '534f', 147, N'- область серии оригинала.', 1, NULL, NULL, N'- область серии оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9380', '534l', 147, N'- местонахождение оригинала.', 1, NULL, NULL, N'- местонахождение оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9381', '534n', 147, N'- примечание к оригиналу.', 1, NULL, NULL, N'- примечание к оригиналу.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9382', '534z', 147, N'- международный стандартный номер книги (ISBN).', 1, NULL, NULL, N'- международный стандартный номер книги (ISBN).', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9383', '534x', 147, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9384', '534k', 147, N'- ключевое заглавие оригинала.', 1, NULL, NULL, N'- ключевое заглавие оригинала.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9385', '5346', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9386', '5348', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9371, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9387', '535', 147, N'Примечание о местонахождении оригинала/дубликатов', 0, NULL, NULL, N'Примечание о местонахождении оригинала/дубликатов', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9388', '535a', 147, N'- держатель.', 1, NULL, NULL, N'- держатель.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9389', '535b', 147, N'- почтовый адрес.', 1, NULL, NULL, N'- почтовый адрес.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9390', '535c', 147, N'- страна.', 1, NULL, NULL, N'- страна.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9391', '535d', 147, N'- телефон, факс и т. д.', 1, NULL, NULL, N'- телефон, факс и т. д.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9392', '535g', 147, N'- код страны репозитария.', 1, NULL, NULL, N'- код страны репозитария.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9393', '5353', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9394', '5356', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9395', '5358', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9387, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9396', '536', 147, N'Примечание о проекте, контракте и т. д., по которому финансировалась подготовка материала', 0, NULL, NULL, N'Примечание о проекте, контракте и т. д., по которому финансировалась подготовка материала', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9397', '536a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9398', '536b', 147, N'- номер контракта.', 1, NULL, NULL, N'- номер контракта.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9399', '536c', 147, N'- номер гранта.', 1, NULL, NULL, N'- номер гранта.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9400', '536d', 147, N'- недифференциированный номер.', 1, NULL, NULL, N'- недифференциированный номер.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9401', '536e', 147, N'- номер раздела программы.', 1, NULL, NULL, N'- номер раздела программы.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9402', '536f', 147, N'- номер проекта.', 1, NULL, NULL, N'- номер проекта.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9403', '536g', 147, N'- номер задания.', 1, NULL, NULL, N'- номер задания.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9404', '536h', 147, N'- номер задачи/работы.', 1, NULL, NULL, N'- номер задачи/работы.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9405', '5366', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9406', '5368', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9396, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9407', '538', 147, N'Примечание о системных характеристиках и требованиях для электронного ресурса', 0, NULL, NULL, N'Примечание о системных характеристиках и требованиях для электронного ресурса', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9408', '538a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9409', '538i', 147, N'- пояснительный текст.', 1, NULL, NULL, N'- пояснительный текст.', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9410', '538u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9411', '5383', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9412', '5386', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9413', '5388', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9407, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9414', '540', 147, N'Примечание о правах на использование и воспроизведение', 0, NULL, NULL, N'Примечание о правах на использование и воспроизведение', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9415', '540a', 147, N'- сведения о правах.', 1, NULL, NULL, N'- сведения о правах.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9416', '540b', 147, N'- лицо/организация/должность и т. д., определившие права.', 1, NULL, NULL, N'- лицо/организация/должность и т. д., определившие права.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9417', '540c', 147, N'- документ, на основании которого введены ограничения.', 1, NULL, NULL, N'- документ, на основании которого введены ограничения.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9418', '540d', 147, N'- на кого ограничения не распространяются.', 1, NULL, NULL, N'- на кого ограничения не распространяются.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9419', '540u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9420', '5403', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9421', '5405', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9422', '5406', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9423', '5408', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9414, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9424', '541', 147, N'Непосредственный источник получения, приобретения', 0, NULL, NULL, N'Непосредственный источник получения, приобретения', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9425', '541a', 147, N'- получено от/из.', 1, NULL, NULL, N'- получено от/из.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9426', '541b', 147, N'- адрес.', 1, NULL, NULL, N'- адрес.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9427', '541c', 147, N'- метод приобретения.', 1, NULL, NULL, N'- метод приобретения.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9428', '541d', 147, N'- дата получения/приобретения.', 1, NULL, NULL, N'- дата получения/приобретения.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9429', '541e', 147, N'- регистрационный №, присвоенный при оформлении поступления.', 1, NULL, NULL, N'- регистрационный №, присвоенный при оформлении поступления.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9430', '541f', 147, N'- владелец.', 1, NULL, NULL, N'- владелец.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9431', '541h', 147, N'- цена покупки.', 1, NULL, NULL, N'- цена покупки.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9432', '541n', 147, N'- количество, объём.', 1, NULL, NULL, N'- количество, объём.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9433', '541o', 147, N'- наименование единицы измерения количества, объёма.', 1, NULL, NULL, N'- наименование единицы измерения количества, объёма.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9434', '5413', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9435', '5415', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9436', '5416', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9437', '5418', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9424, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9438', '544', 147, N'Примечание о местонахождении других архивных материалов', 0, NULL, NULL, N'Примечание о местонахождении других архивных материалов', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9439', '544a', 147, N'- держатель.', 1, NULL, NULL, N'- держатель.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9440', '544b', 147, N'- адрес.', 1, NULL, NULL, N'- адрес.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9441', '544c', 147, N'- страна.', 1, NULL, NULL, N'- страна.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9442', '544d', 147, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9443', '544e', 147, N'- происхождение.', 1, NULL, NULL, N'- происхождение.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9444', '544n', 147, N'- примечание о других материалах.', 1, NULL, NULL, N'- примечание о других материалах.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9445', '5443', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9446', '5446', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9447', '5448', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9438, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9448', '545', 147, N'Биографическая или историческая справка', 0, NULL, NULL, N'Биографическая или историческая справка', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9449', '545a', 147, N'- текст справки.', 1, NULL, NULL, N'- текст справки.', 9448, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9450', '545b', 147, N'- дополнительные сведения.', 1, NULL, NULL, N'- дополнительные сведения.', 9448, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9451', '545u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9448, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9452', '5456', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9448, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9453', '5458', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9448, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9454', '546', 147, N'Примечание о языке', 0, NULL, NULL, N'Примечание о языке', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9455', '546a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9454, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9456', '546b', 147, N'- система символов или алфавит.', 1, NULL, NULL, N'- система символов или алфавит.', 9454, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9457', '5463', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9454, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9458', '5466', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9454, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9459', '5468', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9454, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9460', '547', 147, N'Справка на предыдущее/прежнее заглавие продолжающегося ресурса', 0, NULL, NULL, N'Справка на предыдущее/прежнее заглавие продолжающегося ресурса', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9461', '547a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9460, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9462', '5476', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9460, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9463', '5478', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9460, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9464', '550', 147, N'Справка на издающий коллектив', 0, NULL, NULL, N'Справка на издающий коллектив', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9465', '550a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9464, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9466', '5506', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9464, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9467', '5508', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9464, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9468', '555', 147, N'Примечание о кумулятивном указателе/вспомогательных указателях', 0, NULL, NULL, N'Примечание о кумулятивном указателе/вспомогательных указателях', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9469', '555a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9470', '555b', 147, N'- источник получения указателей и т. д.', 1, NULL, NULL, N'- источник получения указателей и т. д.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9471', '555c', 147, N'- уровень контроля.', 1, NULL, NULL, N'- уровень контроля.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9472', '555d', 147, N'- библиографическая ссылка.', 1, NULL, NULL, N'- библиографическая ссылка.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9473', '555u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9474', '5553', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9475', '5556', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9476', '5558', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9468, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9477', '556', 147, N'Примечание о сопроводительной документации', 0, NULL, NULL, N'Примечание о сопроводительной документации', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9478', '556a', 147, N'- сведения о документации.', 1, NULL, NULL, N'- сведения о документации.', 9477, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9479', '556z', 147, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 9477, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9480', '5566', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9477, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9481', '5568', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9477, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9482', '561', 147, N'История бытования, владельцы', 0, NULL, NULL, N'История бытования, владельцы', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9483', '561a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9482, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9484', '5613', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9482, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9485', '5615', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9482, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9486', '5616', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9482, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9487', '5618', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9482, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9488', '562', 147, N'Идентифицирующие признаки копий или версий архивных и рукописных материалов', 0, NULL, NULL, N'Идентифицирующие признаки копий или версий архивных и рукописных материалов', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9489', '562a', 147, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9490', '562b', 147, N'- идентификация копии.', 1, NULL, NULL, N'- идентификация копии.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9491', '562c', 147, N'- идентификация версии.', 1, NULL, NULL, N'- идентификация версии.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9492', '562d', 147, N'- первоначально предполагаемая форма представления.', 1, NULL, NULL, N'- первоначально предполагаемая форма представления.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9493', '562e', 147, N'- количество копий.', 1, NULL, NULL, N'- количество копий.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9494', '5623', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9495', '5625', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9496', '5626', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9497', '5628', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9488, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9498', '563', 147, N'Примечание о переплёте', 0, NULL, NULL, N'Примечание о переплёте', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9499', '563a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9500', '563u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9501', '5633', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9502', '5635', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9503', '5636', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9504', '5638', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9498, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9505', '565', 147, N'Характеристики картотеки/файла учёта', 0, NULL, NULL, N'Характеристики картотеки/файла учёта', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9506', '565a', 147, N'- количество переменных.', 1, NULL, NULL, N'- количество переменных.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9507', '565b', 147, N'- наименование переменной.', 1, NULL, NULL, N'- наименование переменной.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9508', '565c', 147, N'- единица учёта.', 1, NULL, NULL, N'- единица учёта.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9509', '565d', 147, N'- охват.', 1, NULL, NULL, N'- охват.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9510', '565e', 147, N'- схема упорядочения.', 1, NULL, NULL, N'- схема упорядочения.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9511', '5653', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9512', '5656', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9513', '5658', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9505, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9514', '567', 147, N'Примечание о применённом методе', 0, NULL, NULL, N'Примечание о применённом методе', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9515', '567a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9514, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9516', '5676', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9514, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9517', '5678', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9514, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9518', '580', 147, N'Справка о связи описываемой единицы с другими материалами', 0, NULL, NULL, N'Справка о связи описываемой единицы с другими материалами', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9519', '580a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9518, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9520', '5806', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9518, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9521', '5808', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9518, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9522', '581', 147, N'Публикации об описываемом материале ', 0, NULL, NULL, N'Публикации об описываемом материале ', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9523', '581a', 147, N'- сведения о публикации или её библиографические данные.', 1, NULL, NULL, N'- сведения о публикации или её библиографические данные.', 9522, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9524', '581z', 147, N'- ISBN публикации.', 1, NULL, NULL, N'- ISBN публикации.', 9522, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9525', '5813', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9522, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9526', '5816', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9522, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9527', '5818', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9522, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9528', '583', 147, N'Операции с экземпляром', 0, NULL, NULL, N'Операции с экземпляром', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9529', '583a', 147, N'- операция с экземпляром.', 1, NULL, NULL, N'- операция с экземпляром.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9530', '583b', 147, N'- определитель операции.', 1, NULL, NULL, N'- определитель операции.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9531', '583c', 147, N'- дата и время операции.', 1, NULL, NULL, N'- дата и время операции.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9532', '583d', 147, N'- временной интервал операции.', 1, NULL, NULL, N'- временной интервал операции.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9533', '583e', 147, N'- условия, необходимые для выполнения операции.', 1, NULL, NULL, N'- условия, необходимые для выполнения операции.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9534', '583f', 147, N'- приказ, правила, в соответствии с которыми выполняется операция.', 1, NULL, NULL, N'- приказ, правила, в соответствии с которыми выполняется операция.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9535', '583h', 147, N'- ответственное лицо, подразделение, служба.', 1, NULL, NULL, N'- ответственное лицо, подразделение, служба.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9536', '583i', 147, N'- средства и техника выполнения.', 1, NULL, NULL, N'- средства и техника выполнения.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9537', '583j', 147, N'- место выполнения операции.', 1, NULL, NULL, N'- место выполнения операции.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9538', '583k', 147, N'- исполнитель.', 1, NULL, NULL, N'- исполнитель.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9539', '583l', 147, N'- состояние материала.', 1, NULL, NULL, N'- состояние материала.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9540', '583n', 147, N'- количество, объём.', 1, NULL, NULL, N'- количество, объём.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9541', '583o', 147, N'- наименование единицы измерения количества, объёма.', 1, NULL, NULL, N'- наименование единицы измерения количества, объёма.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9542', '583u', 147, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9543', '583x', 147, N'- служебное примечание.', 1, NULL, NULL, N'- служебное примечание.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9544', '583z', 147, N'- примечание для читателя.', 1, NULL, NULL, N'- примечание для читателя.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9545', '5832', 147, N'- источник термина.', 1, NULL, NULL, N'- источник термина.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9546', '5833', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9547', '5835', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9548', '5836', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9549', '5838', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9528, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9550', '584', 147, N'Обращаемость к материалу, темпы накопления', 0, NULL, NULL, N'Обращаемость к материалу, темпы накопления', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9551', '584a', 147, N'- темпы накопления.', 1, NULL, NULL, N'- темпы накопления.', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9552', '584b', 147, N'- частота использования.', 1, NULL, NULL, N'- частота использования.', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9553', '5843', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9554', '5845', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9555', '5846', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9556', '5848', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9550, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9557', '585', 147, N'Примечание об экспонировании', 0, NULL, NULL, N'Примечание об экспонировании', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9558', '585a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9557, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9559', '5853', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9557, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9560', '5855', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9557, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9561', '5856', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9557, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9562', '5858', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9557, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9563', '586', 147, N'Примечание о наградах', 0, NULL, NULL, N'Примечание о наградах', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9564', '586a', 147, N'- текст примечания.', 1, NULL, NULL, N'- текст примечания.', 9563, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9565', '5863', 147, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9563, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9566', '5866', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9563, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9567', '5868', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9563, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9568', '086', 147, N'Номер документа органа государственной власти', 0, NULL, NULL, N'Номер документа органа государственной власти', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9569', '086a', 147, N'- классификационный номер/номер документа.', 1, NULL, NULL, N'- классификационный номер/номер документа.', 9568, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9570', '086z', 147, N'- отменённый/ошибочный классификационный номер/номер документа.', 1, NULL, NULL, N'- отменённый/ошибочный классификационный номер/номер документа.', 9568, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9571', '0862', 147, N'- источник номера.', 1, NULL, NULL, N'- источник номера.', 9568, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9572', '0866', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9568, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9573', '0868', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9568, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9574', '246', 147, N'Вариант заглавия', 0, NULL, NULL, N'Вариант заглавия', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9575', '246a', 147, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9576', '246b', 147, N'- сведения, относящиеся к заглавию, и т. д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т. д.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9577', '246f', 147, N'- обозначение тома и номер выпуска и/или дата.', 1, NULL, NULL, N'- обозначение тома и номер выпуска и/или дата.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9578', '246g', 147, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9579', '246h', 147, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9580', '246i', 147, N'- пояснительный текст.', 1, NULL, NULL, N'- пояснительный текст.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9581', '246n', 147, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9582', '246p', 147, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9583', '2465', 147, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9584', '2466', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9585', '2468', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9574, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9586', '247', 147, N'Предыдущее/прежнее заглавие продолжающегося ресурса', 0, NULL, NULL, N'Предыдущее/прежнее заглавие продолжающегося ресурса', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9587', '247a', 147, N'- заглавие сериального издания.', 1, NULL, NULL, N'- заглавие сериального издания.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9588', '247b', 147, N'- сведения, относящиеся к заглавию, и т. д.', 1, NULL, NULL, N'- сведения, относящиеся к заглавию, и т. д.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9589', '247f', 147, N'- обозначение тома и номер выпуска и/или дата.', 1, NULL, NULL, N'- обозначение тома и номер выпуска и/или дата.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9590', '247g', 147, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9591', '247h', 147, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9592', '247n', 147, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9593', '247p', 147, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9594', '247x', 147, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9595', '2476', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9596', '2478', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9586, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9597', '310', 147, N'Периодичность в настоящее время', 0, NULL, NULL, N'Периодичность в настоящее время', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9598', '310a', 147, N'- периодичность в настоящее время.', 1, NULL, NULL, N'- периодичность в настоящее время.', 9597, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9599', '310b', 147, N'- дата введения текущей периодичности.', 1, NULL, NULL, N'- дата введения текущей периодичности.', 9597, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9600', '3106', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9597, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9601', '3108', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9597, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9602', '321', 147, N'Прежняя периодичность', 0, NULL, NULL, N'Прежняя периодичность', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9603', '321a', 147, N'- прежняя периодичность.', 1, NULL, NULL, N'- прежняя периодичность.', 9602, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9604', '321b', 147, N'- даты существования прежней периодичности.', 1, NULL, NULL, N'- даты существования прежней периодичности.', 9602, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9605', '3216', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9602, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9606', '3218', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9602, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9607', '362', 147, N'Даты публикации и/или обозначение и номер тома', 0, NULL, NULL, N'Даты публикации и/или обозначение и номер тома', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9608', '362a', 147, N'- даты публикации и/или порядковое обозначение.', 1, NULL, NULL, N'- даты публикации и/или порядковое обозначение.', 9607, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9609', '362z', 147, N'- источник сведений.', 1, NULL, NULL, N'- источник сведений.', 9607, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9610', '3626', 147, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9607, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9611', '3628', 147, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9607, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9612', '76X-78X', 147, N'Поля связывающих поисковых признаков', 0, NULL, NULL, N'Поля связывающих поисковых признаков', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9613', '600', 148, N'Имя лица как добавочный предметный поисковый признак (персоналия)', 0, NULL, NULL, N'Имя лица как добавочный предметный поисковый признак (персоналия)', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9614', '600a', 148, N'- имя лица.', 1, NULL, NULL, N'- имя лица.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9615', '600b', 148, N'- нумерация.', 1, NULL, NULL, N'- нумерация.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9616', '600c', 148, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9617', '600d', 148, N'- даты, относящиеся к имени.', 1, NULL, NULL, N'- даты, относящиеся к имени.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9618', '600e', 148, N'- роль лица относительно произведения.', 1, NULL, NULL, N'- роль лица относительно произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9619', '600f', 148, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9620', '600g', 148, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9621', '600h', 148, N'- физический носитель (обозначение материала). ', 1, NULL, NULL, N'- физический носитель (обозначение материала). ', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9622', '600j', 148, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 1, NULL, NULL, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9623', '600k', 148, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9624', '600l', 148, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9625', '600m', 148, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9626', '600n', 148, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9627', '600o', 148, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9628', '600p', 148, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9629', '600q', 148, N'- более полная форма имени.', 1, NULL, NULL, N'- более полная форма имени.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9630', '600r', 148, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9631', '600s', 148, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9632', '600t', 148, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9633', '600u', 148, N'- место работы, членство или адрес лица.', 1, NULL, NULL, N'- место работы, членство или адрес лица.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9634', '600v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9635', '600x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9636', '600y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9637', '600z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9638', '6002', 148, N'- источник рубрики или наименования понятия.', 1, NULL, NULL, N'- источник рубрики или наименования понятия.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9639', '6003', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9640', '6004', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9641', '6006', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9642', '6008', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9613, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9643', '610', 148, N'Наименование коллектива/постоянной организации как добавочный предметный поисковый признак', 0, NULL, NULL, N'Наименование коллектива/постоянной организации как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9644', '610a', 148, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 1, NULL, NULL, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9645', '610b', 148, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9646', '610c', 148, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9647', '610d', 148, N'- дата проведения мероприятия или подписания договора.', 1, NULL, NULL, N'- дата проведения мероприятия или подписания договора.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9648', '610e', 148, N'- роль коллектива относительно произведения.', 1, NULL, NULL, N'- роль коллектива относительно произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9649', '610f', 148, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9650', '610g', 148, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9651', '610h', 148, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9652', '610k', 148, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9653', '610l', 148, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9654', '610m', 148, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9655', '610n', 148, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9656', '610o', 148, N'- обозначение аранжировки. ', 1, NULL, NULL, N'- обозначение аранжировки. ', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9657', '610p', 148, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9658', '610r', 148, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9659', '610s', 148, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9660', '610t', 148, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9661', '610u', 148, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9662', '610v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9663', '610x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9664', '610y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9665', '610z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9666', '6102', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9667', '6103', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9668', '6104', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9669', '6106', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9670', '6108', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9643, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9671', '611', 148, N'Наименование мероприятия/временного коллектива/организации как добавочный предметный поисковый признак', 0, NULL, NULL, N'Наименование мероприятия/временного коллектива/организации как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9672', '611a', 148, N'- наименование мероприятия как начальный элемент ввода.', 1, NULL, NULL, N'- наименование мероприятия как начальный элемент ввода.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9673', '611c', 148, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9674', '611d', 148, N'- дата проведения мероприятия.', 1, NULL, NULL, N'- дата проведения мероприятия.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9675', '611e', 148, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9676', '611f', 148, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9677', '611g', 148, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9678', '611h', 148, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9679', '611k', 148, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9680', '611l', 148, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9681', '611n', 148, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9682', '611p', 148, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9683', '611s', 148, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9684', '611t', 148, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9685', '611u', 148, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9686', '611v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9687', '611x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9688', '611y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9689', '611z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9690', '6112', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9691', '6113', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9692', '6114', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9693', '6116', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9694', '6118', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9671, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9695', '630', 148, N'Унифицированное, условное, обобщающее заглавие как добавочный предметный поисковый признак', 0, NULL, NULL, N'Унифицированное, условное, обобщающее заглавие как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9696', '630a', 148, N'- унифицированное, условное, обобщающее заглавие.', 1, NULL, NULL, N'- унифицированное, условное, обобщающее заглавие.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9697', '630d', 148, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9698', '630e', 148, N'- роль/отношение.', 1, NULL, NULL, N'- роль/отношение.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9699', '630f', 148, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9700', '630g', 148, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9701', '630h', 148, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9702', '630k', 148, N'- форма, вид, жанр и т. д.', 1, NULL, NULL, N'- форма, вид, жанр и т. д.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9703', '630l', 148, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9704', '630m', 148, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9705', '630n', 148, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9706', '630o', 148, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9707', '630p', 148, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9708', '630r', 148, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9709', '630s', 148, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9710', '630t', 148, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9711', '630v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9712', '630x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9713', '630y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9714', '630z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9715', '6302', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9716', '6303', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9717', '6304', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9718', '6306', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9719', '6308', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9695, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9720', '648', 148, N'Хронологическое понятие как добавочный предметный поисковый признак', 0, NULL, NULL, N'Хронологическое понятие как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9721', '648a', 148, N'- хронологическое понятие.', 1, NULL, NULL, N'- хронологическое понятие.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9722', '648v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9723', '648x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9724', '648y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9725', '648z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9726', '6482', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9727', '6483', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9728', '6486', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9729', '6488', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9720, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9730', '650', 148, N'Тематическое понятие как добавочный предметный поисковый признак', 0, NULL, NULL, N'Тематическое понятие как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9731', '650a', 148, N'- тематическое понятие.', 1, NULL, NULL, N'- тематическое понятие.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9732', '650c', 148, N'- место, где произошло событие, явление и т. д.', 1, NULL, NULL, N'- место, где произошло событие, явление и т. д.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9733', '650d', 148, N'- даты.', 1, NULL, NULL, N'- даты.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9734', '650e', 148, N'- роль/отношение.', 1, NULL, NULL, N'- роль/отношение.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9735', '650v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9736', '650x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9737', '650y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9738', '650z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9739', '6502', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9740', '6503', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9741', '6504', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9742', '6506', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9743', '6508', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9730, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9744', '651', 148, N'Географическое название как добавочный предметный поисковый признак', 0, NULL, NULL, N'Географическое название как добавочный предметный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9745', '651a', 148, N'- географическое название.', 1, NULL, NULL, N'- географическое название.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9746', '651e', 148, N'- роль/отношение.', 1, NULL, NULL, N'- роль/отношение.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9747', '651v', 148, N'- типовое деление.', 1, NULL, NULL, N'- типовое деление.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9748', '651x', 148, N'- основное деление.', 1, NULL, NULL, N'- основное деление.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9749', '651y', 148, N'- хронологическое деление.', 1, NULL, NULL, N'- хронологическое деление.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9750', '651z', 148, N'- географическое деление.', 1, NULL, NULL, N'- географическое деление.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9751', '6512', 148, N'- источник рубрики или термина.', 1, NULL, NULL, N'- источник рубрики или термина.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9752', '6513', 148, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9753', '6514', 148, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9754', '6516', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9755', '6516', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9756', '6518', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9744, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9757', '653', 148, N'Неконтролируемые ключевые слова', 0, NULL, NULL, N'Неконтролируемые ключевые слова', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9758', '653a', 148, N'- ключевое слово.', 1, NULL, NULL, N'- ключевое слово.', 9757, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9759', '6536', 148, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9757, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9760', '6538', 148, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9757, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9761', '700', 149, N'Имя лица как добавочный поисковый признак', 0, NULL, NULL, N'Имя лица как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9762', '700a', 149, N'- имя лица.', 1, NULL, NULL, N'- имя лица.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9763', '700b', 149, N'- нумерация.', 1, NULL, NULL, N'- нумерация.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9764', '700c', 149, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9765', '700d', 149, N'- даты, относящиеся к имени.', 1, NULL, NULL, N'- даты, относящиеся к имени.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9766', '700e', 149, N'- роль лица относительно произведения.', 1, NULL, NULL, N'- роль лица относительно произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9767', '700f', 149, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9768', '700g', 149, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9769', '700h', 149, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9770', '700j', 149, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 1, NULL, NULL, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9771', '700k', 149, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9772', '700l', 149, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9773', '700m', 149, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9774', '700n', 149, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9775', '700o', 149, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9776', '700p', 149, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9777', '700q', 149, N'- более полная форма имени.', 1, NULL, NULL, N'- более полная форма имени.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9778', '700r', 149, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9779', '700s', 149, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9780', '700t', 149, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9781', '700u', 149, N'- место работы, членство или адрес лица.', 1, NULL, NULL, N'- место работы, членство или адрес лица.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9782', '700x', 149, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9783', '7003', 149, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9784', '7004', 149, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9785', '7005', 149, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9786', '7006', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9787', '7008', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9761, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9788', '710', 149, N'Наименование коллектива/постоянной организации как добавочный поисковый признак', 0, NULL, NULL, N'Наименование коллектива/постоянной организации как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9789', '710a', 149, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 1, NULL, NULL, N'- наименование коллектива или юрисдикции как начальный элемент ввода.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9790', '710b', 149, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9791', '710c', 149, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9792', '710d', 149, N'- дата проведения мероприятия или подписания договора.', 1, NULL, NULL, N'- дата проведения мероприятия или подписания договора.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9793', '710e', 149, N'- роль коллектива относительно произведения.', 1, NULL, NULL, N'- роль коллектива относительно произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9794', '710f', 149, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9795', '710g', 149, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9796', '710h', 149, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9797', '710k', 149, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9798', '710l', 149, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9799', '710m', 149, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9800', '710n', 149, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9801', '710o', 149, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9802', '710p', 149, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9803', '710r', 149, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9804', '710s', 149, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9805', '710t', 149, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9806', '710u', 149, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9807', '710x', 149, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9808', '7103', 149, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9809', '7104', 149, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9810', '7105', 149, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9811', '7106', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9812', '7108', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9788, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9813', '711', 149, N'Наименование мероприятия/временного коллектива/организации как добавочный поисковый признак', 0, NULL, NULL, N'Наименование мероприятия/временного коллектива/организации как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9814', '711a', 149, N'- наименование мероприятия как начальный элемент ввода.', 1, NULL, NULL, N'- наименование мероприятия как начальный элемент ввода.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9815', '711c', 149, N'- место проведения мероприятия. ', 1, NULL, NULL, N'- место проведения мероприятия. ', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9816', '711d', 149, N'- дата проведения мероприятия. ', 1, NULL, NULL, N'- дата проведения мероприятия. ', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9817', '711e', 149, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9818', '711f', 149, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9819', '711g', 149, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9820', '711h', 149, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9821', '711k', 149, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9822', '711l', 149, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9823', '711n', 149, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9824', '711p', 149, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9825', '711s', 149, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9826', '711t', 149, N'- заглавие произведения.', 1, NULL, NULL, N'- заглавие произведения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9827', '711u', 149, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9828', '711x', 149, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9829', '7113', 149, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9830', '7114', 149, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9831', '7115', 149, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9832', '7116', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9833', '7118', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9813, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9834', '720', 149, N'Неконтролируемое имя/наименование как добавочный поисковый признак', 0, NULL, NULL, N'Неконтролируемое имя/наименование как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9835', '720a', 149, N'- имя лица или наименование коллектива, мероприятия.', 1, NULL, NULL, N'- имя лица или наименование коллектива, мероприятия.', 9834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9836', '720e', 149, N'- роль лица или коллектива относительно произведения.', 1, NULL, NULL, N'- роль лица или коллектива относительно произведения.', 9834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9837', '7204', 149, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 9834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9838', '7206', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9839', '7208', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9834, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9840', '730', 149, N'Унифицированное, условное, обобщающее заглавие как добавочный поисковый признак', 0, NULL, NULL, N'Унифицированное, условное, обобщающее заглавие как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9841', '730a', 149, N'- унифицированное, условное, обобщающее заглавие.', 1, NULL, NULL, N'- унифицированное, условное, обобщающее заглавие.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9842', '730d', 149, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9843', '730f', 149, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9844', '730g', 149, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9845', '730h', 149, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9846', '730k', 149, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9847', '730l', 149, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9848', '730m', 149, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9849', '730n', 149, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9850', '730o', 149, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9851', '730p', 149, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9852', '730r', 149, N'- тональность.', 1, NULL, NULL, N'- тональность.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9853', '730s', 149, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9854', '730x', 149, N'- международный стандартный номер сериального издания (ISSN).', 1, NULL, NULL, N'- международный стандартный номер сериального издания (ISSN).', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9855', '7303', 149, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9856', '7305', 149, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9857', '7306', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9858', '7308', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9840, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9859', '740', 149, N'Неконтролируемое связанное/аналитическое заглавие как добавочный поисковый признак', 0, NULL, NULL, N'Неконтролируемое связанное/аналитическое заглавие как добавочный поисковый признак', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9860', '740a', 149, N'- неконтролируемое связанное/аналитическое заглавие.', 1, NULL, NULL, N'- неконтролируемое связанное/аналитическое заглавие.', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9861', '740h', 149, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9862', '740n', 149, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9863', '740p', 149, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9864', '7405', 149, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9865', '7406', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9866', '7408', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9859, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9867', '753', 149, N'Системные характеристики как добавочные поисковые признаки', 0, NULL, NULL, N'Системные характеристики как добавочные поисковые признаки', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9868', '753a', 149, N'- марка и модель машины.', 1, NULL, NULL, N'- марка и модель машины.', 9867, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9869', '753b', 149, N'- язык программирования.', 1, NULL, NULL, N'- язык программирования.', 9867, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9870', '753c', 149, N'- операционная система.', 1, NULL, NULL, N'- операционная система.', 9867, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9871', '7536', 149, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9867, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9872', '7538', 149, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9867, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9873', '760', 150, N'Поисковый признак на основную серию', 0, NULL, NULL, N'Поисковый признак на основную серию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9874', '760a', 150, N'- заголовок/основной поисковый признак записи на серию (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на серию (автор).', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9875', '760b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9876', '760c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9877', '760d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9878', '760g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9879', '760h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9880', '760i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9881', '760m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9882', '760n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9883', '760o', 150, N'- прочие индексы, коды, шифры и т. п.', 1, NULL, NULL, N'- прочие индексы, коды, шифры и т. п.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9884', '760s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9885', '760t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9886', '760w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9887', '760x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9888', '760y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9889', '7606', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9890', '7607', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9891', '7608', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9873, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9892', '762', 150, N'Поисковый признак на подсерию', 0, NULL, NULL, N'Поисковый признак на подсерию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9893', '762a', 150, N'- заголовок/основной поисковый признак записи на подсерию.', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на подсерию.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9894', '762b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9895', '762c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9896', '762d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9897', '762g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9898', '762h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9899', '762i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9900', '762m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9901', '762n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9902', '762o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9903', '762s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9904', '762t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9905', '762w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9906', '762x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9907', '762y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9908', '7626', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9909', '7627', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9910', '7628', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9892, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9911', '765', 150, N'Поисковый признак на публикацию на языке оригинала', 0, NULL, NULL, N'Поисковый признак на публикацию на языке оригинала', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9912', '765a', 150, N'- заголовок/основной поисковый признак записи на материал на языке оригинала.', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на материал на языке оригинала.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9913', '765b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9914', '765c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9915', '765d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9916', '765g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9917', '765h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9918', '765i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9919', '765k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9920', '765m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9921', '765n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9922', '765o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9923', '765r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9924', '765s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9925', '765t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9926', '765u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9927', '765w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9928', '765x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9929', '765y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9930', '765z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9931', '7656', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9932', '7657', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9933', '7658', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9911, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9934', '767', 150, N'Поисковый признак на перевод', 0, NULL, NULL, N'Поисковый признак на перевод', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9935', '767a', 150, N'- заголовок/основной поисковый признак записи на перевод (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на перевод (автор).', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9936', '767b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9937', '767c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9938', '767d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9939', '767g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9940', '767h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9941', '767i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9942', '767k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9943', '767m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9944', '767n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9945', '767o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9946', '767r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9947', '767s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9948', '767t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9949', '767u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9950', '767w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9951', '767x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9952', '767y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9953', '767z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9954', '7676', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9955', '7677', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9956', '7678', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9934, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9957', '770', 150, N'Поисковый признак на приложение/специальный выпуск', 0, NULL, NULL, N'Поисковый признак на приложение/специальный выпуск', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9958', '770a', 150, N'- заголовок/основной поисковый признак связываемой записи (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак связываемой записи (автор).', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9959', '770b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9960', '770c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9961', '770d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9962', '770g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9963', '770h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9964', '770i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9965', '770k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9966', '770m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9967', '770n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9968', '770o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9969', '770r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9970', '770s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9971', '770t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9972', '770u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9973', '770w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9974', '770x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9975', '770y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9976', '770z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9977', '7706', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9978', '7707', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9979', '7708', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9957, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9980', '772', 150, N'Поисковый признак на основную единицу, к которой относится приложение', 0, NULL, NULL, N'Поисковый признак на основную единицу, к которой относится приложение', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9981', '772a', 150, N'- заголовок/основной поисковый признак записи на основную единицу (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на основную единицу (автор).', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9982', '772b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9983', '772c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9984', '772d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9985', '772g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9986', '772h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9987', '772i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9988', '772k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9989', '772m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9990', '772n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9991', '772o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9992', '772r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9993', '772s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9994', '772t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9995', '772u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9996', '772w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9997', '772x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9998', '772y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('9999', '772z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10000', '7726', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10001', '7727', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10002', '7728', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 9980, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10003', '773', 150, N'Поисковый признак на основную единицу, составной частью которой является описываемый материал', 0, NULL, NULL, N'Поисковый признак на основную единицу, составной частью которой является описываемый материал', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10004', '773a', 150, N'- заголовок/основной поисковый признак основной записи (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак основной записи (автор).', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10005', '773b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10006', '773d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10007', '773g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10008', '773h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10009', '773i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10010', '773k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10011', '773m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10012', '773n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10013', '773o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10014', '773p', 150, N'- сокращённое заглавие.', 1, NULL, NULL, N'- сокращённое заглавие.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10015', '773q', 150, N'- нумерация и первая страница.', 1, NULL, NULL, N'- нумерация и первая страница.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10016', '773r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10017', '773s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10018', '773t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10019', '773u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10020', '773w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10021', '773x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10022', '773y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10023', '773z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10024', '7733', 150, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10025', '7736', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10026', '7737', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10027', '7738', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10003, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10028', '774', 150, N'Поисковый признак на составную часть', 0, NULL, NULL, N'Поисковый признак на составную часть', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10029', '774a', 150, N'- заголовок/основной поисковый признак записи на составную часть (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на составную часть (автор).', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10030', '774b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10031', '774c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10032', '774d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10033', '774g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10034', '774h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10035', '774i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10036', '774k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10037', '774m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10038', '774n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10039', '774o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10040', '774r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10041', '774s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10042', '774t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10043', '774u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10044', '774w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10045', '774x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10046', '774y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10047', '774z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10048', '7746', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10049', '7747', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10050', '7748', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10028, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10051', '775', 150, N'Поисковый признак на другое издание/редакцию', 0, NULL, NULL, N'Поисковый признак на другое издание/редакцию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10052', '775a', 150, N'- заголовок/основной поисковый признак записи на другое издание (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на другое издание (автор).', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10053', '775b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10054', '775c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10055', '775d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10056', '775e', 150, N'- код языка.', 1, NULL, NULL, N'- код языка.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10057', '775f', 150, N'- код страны.', 1, NULL, NULL, N'- код страны.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10058', '775g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10059', '775h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10060', '775i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10061', '775k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10062', '775m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10063', '775n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10064', '775o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10065', '775r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10066', '775s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10067', '775t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10068', '775u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10069', '775w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10070', '775x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10071', '775y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10072', '775z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10073', '7756', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10074', '7757', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10075', '7758', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10051, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10076', '776', 150, N'Поисковый признак на единицу в другой физической форме', 0, NULL, NULL, N'Поисковый признак на единицу в другой физической форме', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10077', '776a', 150, N'- заголовок/основной поисковый признак записи на материал в другой физической форме (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на материал в другой физической форме (автор).', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10078', '776b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10079', '776c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10080', '776d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10081', '776g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10082', '776h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10083', '776i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10084', '776k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10085', '776m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10086', '776n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10087', '776o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10088', '776r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10089', '776s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10090', '776t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10091', '776u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10092', '776w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10093', '776x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10094', '776y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10095', '776z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10096', '7766', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10097', '7767', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10098', '7768', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10076, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10099', '777', 150, N'Поисковый признак на единицу, изданную в одной обложке с описываемым материалом', 0, NULL, NULL, N'Поисковый признак на единицу, изданную в одной обложке с описываемым материалом', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10100', '777a', 150, N'- заголовок/основной поисковый признак связываемой записи (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак связываемой записи (автор).', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10101', '777b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10102', '777c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10103', '777d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10104', '777g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10105', '777h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10106', '777i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10107', '777k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10108', '777m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10109', '777n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10110', '777o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10111', '777s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10112', '777t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10113', '777w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10114', '777x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10115', '777y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10116', '7775', 150, N'- принадлежность поля организации.', 1, NULL, NULL, N'- принадлежность поля организации.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10117', '7776', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10118', '7777', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10119', '7778', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10099, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10120', '780', 150, N'Поисковый признак на предшествующее издание', 0, NULL, NULL, N'Поисковый признак на предшествующее издание', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10121', '780a', 150, N'- заголовок/основной поисковый признак связываемой записи (автор). ', 1, NULL, NULL, N'- заголовок/основной поисковый признак связываемой записи (автор). ', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10122', '780b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10123', '780c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10124', '780d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10125', '780g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10126', '780h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10127', '780i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10128', '780k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10129', '780m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10130', '780n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10131', '780o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10132', '780r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10133', '780s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10134', '780t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10135', '780u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10136', '780w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10137', '780x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10138', '780y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10139', '780z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10140', '7806', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10141', '7807', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10142', '7808', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10120, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10143', '785', 150, N'Поисковый признак на последующее издание', 0, NULL, NULL, N'Поисковый признак на последующее издание', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10144', '785a', 150, N'- заголовок/основной поисковый признак связываемой записи (автор).', 1, NULL, NULL, N'- заголовок/основной поисковый признак связываемой записи (автор).', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10145', '785b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10146', '785c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10147', '785d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10148', '785g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10149', '785h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10150', '785i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10151', '785k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10152', '785m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10153', '785n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10154', '785o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10155', '785r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10156', '785s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10157', '785t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10143, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10158', '786', 150, N'Поисковый признак на источник данных', 0, NULL, NULL, N'Поисковый признак на источник данных', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10159', '786a', 150, N'- заголовок/основной поисковый признак записи на источник данных (автор). ', 1, NULL, NULL, N'- заголовок/основной поисковый признак записи на источник данных (автор). ', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10160', '786b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10161', '786c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10162', '786d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10163', '786g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10164', '786h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10165', '786i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10166', '786k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10167', '786j', 150, N'- период времени.', 1, NULL, NULL, N'- период времени.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10168', '786k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10169', '786m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10170', '786n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10171', '786o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10172', '786p', 150, N'- сокращённое заглавие.', 1, NULL, NULL, N'- сокращённое заглавие.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10173', '786r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10174', '786s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10175', '786t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10176', '786u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10177', '786v', 150, N'- вклад источника в содержание.', 1, NULL, NULL, N'- вклад источника в содержание.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10178', '786w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10179', '786x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10180', '786y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10181', '786z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10182', '7866', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10183', '7867', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10184', '7868', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10158, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10185', '787', 150, N'Поисковый признак на единицу, связанную с описываемой прочими отношениями', 0, NULL, NULL, N'Поисковый признак на единицу, связанную с описываемой прочими отношениями', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10186', '787a', 150, N'- заголовок/основной поисковый признак связываемой записи (автор). ', 1, NULL, NULL, N'- заголовок/основной поисковый признак связываемой записи (автор). ', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10187', '787b', 150, N'- издание.', 1, NULL, NULL, N'- издание.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10188', '787c', 150, N'- идентифицирующие сведения.', 1, NULL, NULL, N'- идентифицирующие сведения.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10189', '787d', 150, N'- место издания, издательство/издатель и дата публикации.', 1, NULL, NULL, N'- место издания, издательство/издатель и дата публикации.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10190', '787g', 150, N'- сведения о связи.', 1, NULL, NULL, N'- сведения о связи.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10191', '787h', 150, N'- физическая характеристика связываемой единицы (издания).', 1, NULL, NULL, N'- физическая характеристика связываемой единицы (издания).', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10192', '787i', 150, N'- пояснительный текст/вводные слова.', 1, NULL, NULL, N'- пояснительный текст/вводные слова.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10193', '787k', 150, N'- область серии из связываемой записи.', 1, NULL, NULL, N'- область серии из связываемой записи.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10194', '787m', 150, N'- специфические данные.', 1, NULL, NULL, N'- специфические данные.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10195', '787n', 150, N'- примечание.', 1, NULL, NULL, N'- примечание.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10196', '787o', 150, N'- прочие индексы, коды и т. п.', 1, NULL, NULL, N'- прочие индексы, коды и т. п.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10197', '787r', 150, N'- номер отчёта.', 1, NULL, NULL, N'- номер отчёта.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10198', '787s', 150, N'- условное или обобщающее заглавие.', 1, NULL, NULL, N'- условное или обобщающее заглавие.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10199', '787t', 150, N'- заглавие.', 1, NULL, NULL, N'- заглавие.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10200', '787u', 150, N'- стандартный номер технического отчёта (STRN).', 1, NULL, NULL, N'- стандартный номер технического отчёта (STRN).', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10201', '787w', 150, N'- контрольный номер связываемой записи.', 1, NULL, NULL, N'- контрольный номер связываемой записи.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10202', '787x', 150, N'- ISSN.', 1, NULL, NULL, N'- ISSN.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10203', '787y', 150, N'- CODEN.', 1, NULL, NULL, N'- CODEN.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10204', '787z', 150, N'- ISBN.', 1, NULL, NULL, N'- ISBN.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10205', '7874', 150, N'- ', 1, NULL, NULL, N'- ', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10206', '7876', 150, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10207', '7877', 150, N'- контрольное подполе.', 1, NULL, NULL, N'- контрольное подполе.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10208', '7878', 150, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10185, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10209', '800', 151, N'Имя лица как добавочный поисковый признак на серию', 0, NULL, NULL, N'Имя лица как добавочный поисковый признак на серию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10210', '800a', 151, N'- имя лица.', 1, NULL, NULL, N'- имя лица.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10211', '800b', 151, N'- нумерация.', 1, NULL, NULL, N'- нумерация.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10212', '800c', 151, N'- идентифицирующие признаки.', 1, NULL, NULL, N'- идентифицирующие признаки.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10213', '800d', 151, N'- даты, относящиеся к имени.', 1, NULL, NULL, N'- даты, относящиеся к имени.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10214', '800e', 151, N'- роль лица относительно произведения.', 1, NULL, NULL, N'- роль лица относительно произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10215', '800f', 151, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10216', '800g', 151, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10217', '800h', 151, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10218', '800j', 151, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 1, NULL, NULL, N'- принадлежность неизвестного автора к последователям, ученикам сторонникам, школе и т. д.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10219', '800k', 151, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10220', '800l', 151, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10221', '800m', 151, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10222', '800n', 151, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10223', '800o', 151, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10224', '800p', 151, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10225', '800q', 151, N'- более полная форма имени.', 1, NULL, NULL, N'- более полная форма имени.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10226', '800r', 151, N'- тональность.', 1, NULL, NULL, N'- тональность.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10227', '800s', 151, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10228', '800t', 151, N'- заглавие серии.', 1, NULL, NULL, N'- заглавие серии.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10229', '800u', 151, N'- место работы, членство или адрес лица.', 1, NULL, NULL, N'- место работы, членство или адрес лица.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10230', '800v', 151, N'- обозначение и номер тома/порядковая нумерация.', 1, NULL, NULL, N'- обозначение и номер тома/порядковая нумерация.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10231', '8004', 151, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10232', '8006', 151, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10233', '8008', 151, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10209, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10234', '810', 151, N'Наименование коллектива/постоянной организации как добавочный поисковый признак на серию', 0, NULL, NULL, N'Наименование коллектива/постоянной организации как добавочный поисковый признак на серию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10235', '810a', 151, N'- наименование коллектива или юрисдикции как начальный элемент ввода. ', 1, NULL, NULL, N'- наименование коллектива или юрисдикции как начальный элемент ввода. ', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10236', '810b', 151, N'- структурное подразделение или наименование мероприятия, введённое под наименованием коллектива.', 1, NULL, NULL, N'- структурное подразделение или наименование мероприятия, введённое под наименованием коллектива.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10237', '810c', 151, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10238', '810d', 151, N'- дата проведения мероприятия или подписания договора.', 1, NULL, NULL, N'- дата проведения мероприятия или подписания договора.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10239', '810e', 151, N'- роль коллектива относительно произведения.', 1, NULL, NULL, N'- роль коллектива относительно произведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10240', '810f', 151, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10241', '810g', 151, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10242', '810h', 151, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10243', '810k', 151, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10244', '810l', 151, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10245', '810m', 151, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10246', '810n', 151, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10247', '810o', 151, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10248', '810p', 151, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10249', '810r', 151, N'- тональность.', 1, NULL, NULL, N'- тональность.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10250', '810s', 151, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10251', '810t', 151, N'- заглавие серии.', 1, NULL, NULL, N'- заглавие серии.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10252', '810u', 151, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10253', '810v', 151, N'- обозначение и номер тома/порядковая нумерация.', 1, NULL, NULL, N'- обозначение и номер тома/порядковая нумерация.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10254', '8104', 151, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10255', '8106', 151, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10256', '8108', 151, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10234, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10257', '811', 151, N'Наименование мероприятия/временного коллектива как добавочный поисковый признак на серию', 0, NULL, NULL, N'Наименование мероприятия/временного коллектива как добавочный поисковый признак на серию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10258', '811a', 151, N'- наименование мероприятия как начальный элемент ввода.', 1, NULL, NULL, N'- наименование мероприятия как начальный элемент ввода.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10259', '811c', 151, N'- место проведения мероприятия.', 1, NULL, NULL, N'- место проведения мероприятия.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10260', '811d', 151, N'- дата проведения мероприятия.', 1, NULL, NULL, N'- дата проведения мероприятия.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10261', '811e', 151, N'- структурное подразделение.', 1, NULL, NULL, N'- структурное подразделение.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10262', '811f', 151, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10263', '811g', 151, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10264', '811h', 151, N'- физический носитель (обозначение материала). ', 1, NULL, NULL, N'- физический носитель (обозначение материала). ', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10265', '811k', 151, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10266', '811l', 151, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10267', '811n', 151, N'- обозначение и номер части/секции/мероприятия.', 1, NULL, NULL, N'- обозначение и номер части/секции/мероприятия.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10268', '811p', 151, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10269', '811s', 151, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10270', '811t', 151, N'- заглавие серии.', 1, NULL, NULL, N'- заглавие серии.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10271', '811u', 151, N'- местонахождение или адрес.', 1, NULL, NULL, N'- местонахождение или адрес.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10272', '811v', 151, N'- обозначение и номер тома/порядковая нумерация.', 1, NULL, NULL, N'- обозначение и номер тома/порядковая нумерация.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10273', '8114', 151, N'- код отношения.', 1, NULL, NULL, N'- код отношения.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10274', '8116', 151, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10275', '8118', 151, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10257, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10276', '830', 151, N'Унифицированное, условное заглавие как добавочный поисковый признак на серию', 0, NULL, NULL, N'Унифицированное, условное заглавие как добавочный поисковый признак на серию', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10277', '830a', 151, N'- унифицированное, условное заглавие.', 1, NULL, NULL, N'- унифицированное, условное заглавие.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10278', '830d', 151, N'- дата подписания договора.', 1, NULL, NULL, N'- дата подписания договора.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10279', '830f', 151, N'- дата публикации.', 1, NULL, NULL, N'- дата публикации.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10280', '830g', 151, N'- прочие сведения.', 1, NULL, NULL, N'- прочие сведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10281', '830h', 151, N'- физический носитель (обозначение материала).', 1, NULL, NULL, N'- физический носитель (обозначение материала).', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10282', '830k', 151, N'- форма, вид, жанр и т. д. произведения.', 1, NULL, NULL, N'- форма, вид, жанр и т. д. произведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10283', '830l', 151, N'- язык произведения.', 1, NULL, NULL, N'- язык произведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10284', '830m', 151, N'- средство исполнения музыкального произведения.', 1, NULL, NULL, N'- средство исполнения музыкального произведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10285', '830n', 151, N'- обозначение и номер части/раздела произведения.', 1, NULL, NULL, N'- обозначение и номер части/раздела произведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10286', '830o', 151, N'- обозначение аранжировки.', 1, NULL, NULL, N'- обозначение аранжировки.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10287', '830p', 151, N'- заглавие части/раздела произведения.', 1, NULL, NULL, N'- заглавие части/раздела произведения.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10288', '830r', 151, N'- тональность.', 1, NULL, NULL, N'- тональность.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10289', '830s', 151, N'- версия, издание и т. д.', 1, NULL, NULL, N'- версия, издание и т. д.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10290', '830t', 151, N'- заглавие с титульного листа.', 1, NULL, NULL, N'- заглавие с титульного листа.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10291', '830v', 151, N'- обозначение и номер тома/порядковая нумерация.', 1, NULL, NULL, N'- обозначение и номер тома/порядковая нумерация.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10292', '8306', 151, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10293', '8308', 151, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10276, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10294', '850', 152, N'Организации-держатели', 0, NULL, NULL, N'Организации-держатели', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10295', '850a', 152, N'- организация-держатель.', 1, NULL, NULL, N'- организация-держатель.', 10294, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10296', '8508', 152, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10294, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10297', '852', 152, N'Местонахождение единицы хранения', 0, NULL, NULL, N'Местонахождение единицы хранения', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10298', '852a', 152, N'- местонахождение.', 1, NULL, NULL, N'- местонахождение.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10299', '852b', 152, N'- подразделение или фонд внутри организации.', 1, NULL, NULL, N'- подразделение или фонд внутри организации.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10300', '852c', 152, N'- местонахождение полки.', 1, NULL, NULL, N'- местонахождение полки.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10301', '852e', 152, N'- адрес.', 1, NULL, NULL, N'- адрес.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10302', '852f', 152, N'- кодированные данные об особенностях расстановки.', 1, NULL, NULL, N'- кодированные данные об особенностях расстановки.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10303', '852g', 152, N'- особенности расстановки.', 1, NULL, NULL, N'- особенности расстановки.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10304', '852h', 152, N'- классификационная часть шифра хранения.', 1, NULL, NULL, N'- классификационная часть шифра хранения.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10305', '852i', 152, N'- расстановочный признак.', 1, NULL, NULL, N'- расстановочный признак.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10306', '852j', 152, N'- шифр хранения.', 1, NULL, NULL, N'- шифр хранения.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10307', '852k', 152, N'- префикс шифра хранения.', 1, NULL, NULL, N'- префикс шифра хранения.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10308', '852l', 152, N'- расстановочная форма заглавия.', 1, NULL, NULL, N'- расстановочная форма заглавия.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10309', '852m', 152, N'- суффикс шифра хранения.', 1, NULL, NULL, N'- суффикс шифра хранения.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10310', '852n', 152, N'- код страны.', 1, NULL, NULL, N'- код страны.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10311', '852p', 152, N'- инвентарный номер.', 1, NULL, NULL, N'- инвентарный номер.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10312', '852q', 152, N'- неустранимые физические особенности экземпляра.', 1, NULL, NULL, N'- неустранимые физические особенности экземпляра.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10313', '852s', 152, N'- код составной части/статьи с обозначением авторского права и цены за копирование.', 1, NULL, NULL, N'- код составной части/статьи с обозначением авторского права и цены за копирование.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10314', '852t', 152, N'- порядковый номер комплекта/экземпляра.', 1, NULL, NULL, N'- порядковый номер комплекта/экземпляра.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10315', '852x', 152, N'- служебное примечание.', 1, NULL, NULL, N'- служебное примечание.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10316', '852z', 152, N'- примечание для пользователя.', 1, NULL, NULL, N'- примечание для пользователя.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10317', '8522', 152, N'- источник схемы расстановки.', 1, NULL, NULL, N'- источник схемы расстановки.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10318', '8523', 152, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10319', '8526', 152, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10320', '8528', 152, N'- порядковый номер.', 1, NULL, NULL, N'- порядковый номер.', 10297, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10321', '856', 152, N'Местонахождение электронного ресурса и доступ к нему', 0, NULL, NULL, N'Местонахождение электронного ресурса и доступ к нему', NULL, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10322', '856a', 152, N'- имя сервера/домена.', 1, NULL, NULL, N'- имя сервера/домена.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10323', '856b', 152, N'- номер для доступа.', 1, NULL, NULL, N'- номер для доступа.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10324', '856c', 152, N'- информация о сжатии.', 1, NULL, NULL, N'- информация о сжатии.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10325', '856d', 152, N'- путь.', 1, NULL, NULL, N'- путь.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10326', '856f', 152, N'- электронное имя.', 1, NULL, NULL, N'- электронное имя.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10327', '856h', 152, N'- имя пользователя.', 1, NULL, NULL, N'- имя пользователя.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10328', '856i', 152, N'- указания.', 1, NULL, NULL, N'- указания.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10329', '856j', 152, N'- количество битов в секунду.', 1, NULL, NULL, N'- количество битов в секунду.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10330', '856k', 152, N'- пароль.', 1, NULL, NULL, N'- пароль.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10331', '856l', 152, N'- вход/начало сеанса.', 1, NULL, NULL, N'- вход/начало сеанса.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10332', '856m', 152, N'- помощь.', 1, NULL, NULL, N'- помощь.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10333', '856n', 152, N'- местонахождение сервера.', 1, NULL, NULL, N'- местонахождение сервера.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10334', '856o', 152, N'- операционная система сервера.', 1, NULL, NULL, N'- операционная система сервера.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10335', '856p', 152, N'- порт.', 1, NULL, NULL, N'- порт.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10336', '856q', 152, N'- тип электронного формата.', 1, NULL, NULL, N'- тип электронного формата.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10337', '856r', 152, N'- структура.', 1, NULL, NULL, N'- структура.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10338', '856s', 152, N'- размер файла.', 1, NULL, NULL, N'- размер файла.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10339', '856t', 152, N'- эмуляция терминала.', 1, NULL, NULL, N'- эмуляция терминала.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10340', '856u', 152, N'- унифицированный определитель ресурса (URI).', 1, NULL, NULL, N'- унифицированный определитель ресурса (URI).', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10341', '856v', 152, N'- часы доступа к ресурсу.', 1, NULL, NULL, N'- часы доступа к ресурсу.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10342', '856w', 152, N'- контрольный номер записи.', 1, NULL, NULL, N'- контрольный номер записи.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10343', '856x', 152, N'- служебное примечание.', 1, NULL, NULL, N'- служебное примечание.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10344', '856y', 152, N'- справочный текст.', 1, NULL, NULL, N'- справочный текст.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10345', '856z', 152, N'- примечание для пользователя.', 1, NULL, NULL, N'- примечание для пользователя.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10346', '8562', 152, N'- способ доступа.', 1, NULL, NULL, N'- способ доступа.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10347', '8563', 152, N'- область применения данных поля.', 1, NULL, NULL, N'- область применения данных поля.', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10348', '8566', 152, N'-связь. ', 1, NULL, NULL, N'-связь. ', 10321, 'USMARC');
INSERT INTO format_fields(id, FIELD_NAME, BLOCK_ID, descr, IS_SUB_FIELD, IS_MANDATORY, IS_REPEATABLE, FIELD_COMMENT, PARENT_FIELD_ID, MFORMAT)
VALUES('10349', '8568', 152, N'- связь поля и её порядковый номер.', 1, NULL, NULL, N'- связь поля и её порядковый номер.', 10321, 'USMARC');


update format_fields
set FIELD_ALIAS='isbn'
where MFORMAT='USMARC' and FIELD_NAME='020a';
update format_fields
set FIELD_ALIAS='title'
where MFORMAT='USMARC' and FIELD_NAME='245a';
update format_fields
set FIELD_ALIAS='publishedPlace'
where MFORMAT='USMARC' and FIELD_NAME='260a';
update format_fields
set FIELD_ALIAS='publishedDate'
where MFORMAT='USMARC' and FIELD_NAME='260c';
update format_fields
set FIELD_ALIAS='keywords'
where MFORMAT='USMARC' and FIELD_NAME='653a';
update format_fields
set FIELD_ALIAS='authorSurename'
where MFORMAT='USMARC' and FIELD_NAME='100a';
update format_fields
set FIELD_ALIAS='authorName'
where MFORMAT='USMARC' and FIELD_NAME='100g';