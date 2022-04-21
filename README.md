# onlineMagazine
Примитивный сервис для управления и мониторинга онлайн заказов товаров (Курсовая)  
Сервис не использует ORM, прямая работа с jdbc (базовое условие)

## Технологии 
• Spring Boot  
• Spring JdbcTemplate - используется для классов Repository  
• PostgreSql  
• Junit 5 - все классы Repository покрыты Spring тестами тестами, для тестов используется H2 db  
• Flyway - для управления миграциями  
