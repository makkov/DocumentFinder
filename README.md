# Document Finder
Реализован soap web-service, содержащий в себе метод Result findNumber(Integer number).

Сервис ищет в текстовых документах полученное на вход число n. Возращается объект Result, происходит запись в базу данных.

**DB**:
- СУБД - Postgresql
- в pgAdmin создать БД result
- user: postgres
- password: postgres
- port: 5433
- [Скрипт для создания таблицы](https://github.com/makkov/DocumentFinder/blob/master/src/main/resources/createDB.sql)

**Генерация файлов**:

Для создания текстовых документов можно использвать [генератор файлов](https://github.com/makkov/FileGenerator)
