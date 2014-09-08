Данный модуль "skud-service" предназначен для интеграции со СКУД системой.
В задачу модуля входит получение UID карты сотрудника/читателя и возврат
идентификатора сотрудника/читателя

Обращение к сервису:
    1) Возвращает ID сотрудника по UID карты
        http://localhost:8080/skud-service/skud/rest/getUserIDByCardUID?cardUID=<Card UID>
    2) Возвращает ИИН сотрудника по UID карты
        http://localhost:8080/skud-service/skud/rest/getUserIinByCardUID?cardUID=<Card UID>
где,
    <Card UID> - UID карты сотрудника/читателя

Пример ссылки:
    http://localhost:8080/skud-service/skud/rest/getUserIDByCardUID?cardUID=2163679833

Настройка источника данных:
 1) Добавление jdbc драйверов в JBoss AS. Можно скачать по ссылке http://www.firebirdsql.org/en/jdbc-driver/
    - Открываем консоль администратора JBoss, вкладка Runtime и пункт Manage Deployments
    - Добавляем jar-файлы: jaybird-2.2.5.jar, connector-api-1.5.jar и включаем их (Кнопка Enable)
 2) Добавление источника данных:
    - Открываем консоль администратора JBoss, вкладка Profile и пункт Datasources
    - Добавляем источник данных со следующими параметрами (пример):
        Name: SkudDS
        JNDI: java:jboss/datasources/SkudDS
        Is enabled?: true
        Datasource Class:
        Driver: jaybird-2.2.5.jar
        Driver Class: org.firebirdsql.jdbc.FBDriver
        Connection URL: jdbc:firebirdsql://localhost:3050/C:/Fdatabase/SCD17K#.FDB