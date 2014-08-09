enu.z39.50
==========
![logo](src/main/webapp/img/arta.png)

##Настройка
* на сервере установить yaz
 * debian - apt-get install libyaz4-dev swig
 * windows - скачать и установить [дистрибутив](http://ftp.indexdata.dk/pub/yaz/win32/yaz_5.3.0.exe)
* на сервере установить переменные окружения для yaz
 * debian
    * LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/path/to/libyaz4j.so
    * export LD_LIBRARY_PATH
 * windows
    * set PATH=%PATH;C:\Program Files (x86)\YAZ\bin\yaz4j.dll
* Апдейт БД. Провести скрипт [init.sql](init.sql) на БД books
* Настройки JBOSS
 * Добавить датасорс к БД books 
    * Name - **BookDS**
    * JNDI - **java:jboss/datasources/BookDS**
 * Добавить JMS Queue
    * Name - **MigrateWorkerQueue**
    * JNDI - **java:jboss/queues/Synergy/MigrateWorkerQueue**
* Настроить конфиг [конфиг](esot.properties)
 * Выставить правильные настройки по подключению к серверу _synergy.address_, _user.login_, _user.password_
 * Выставить правильные идентифкаторы **Реестра заказов** _order.registry.uuid_, _order.form.uuid_
 * Скопировать файл настроек в jboss в конфигурации _(по умолчанию standalone/configuration)_
* Задеплоить war в JBOSS

 
##Запуск
Запустить приложение в бразере [migrate](http://localhost:8080/z3950/)
