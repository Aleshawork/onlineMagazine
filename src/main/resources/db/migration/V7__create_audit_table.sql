-- Таблица для аудита, запись производиться при помощи триггера: audit_client
-- Триггерная функция : client_delete()
create table client_historical_data(
    id serial,
    login varchar(30),
    name varchar(30),
    email varchar(30)

);