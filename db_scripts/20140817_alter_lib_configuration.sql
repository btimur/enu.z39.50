ALTER TABLE lib_configuration
ADD COLUMN USE_SEARCH bit(1) COMMENT 'Использовать при поиске' NOT NULL DEFAULT b'1';

