Java 8, Spring Boot, Spring Data, Apache Maven. БД H2


_____________________________________________________________
Information:

Файл postman.json для імпотру колекції в Postman.


_____________________________________________________________
Generation token:

Post: /authenticate
Body: 
{
    "name": "root"
}
_____________________________________________________________
User controller:

Header: Key = Authorization, Value = Token

Дістати всіх Users, в яких age більше за якесь значення
Get: /users_older_than?age=0

Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а 
Get: /users_by_article_color?color=green

Дістати унікальні name з Users, в яких більше ніж 3 Articles 
Get: /user/distinct

Зберегти User
Post: /user/add

_____________________________________________________________
Article controller:

Header: Key = Authorization, Value = Token

Зберегти Article
Post: /article/add
