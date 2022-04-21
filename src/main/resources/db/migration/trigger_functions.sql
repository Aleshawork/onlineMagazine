-- Триггерная функция для ведения аудита по удаленным  клиентам
CREATE OR REPLACE FUNCTION client_delete() returns trigger as
$$
    begin
        insert into client_historical_data(login,name,email) values
        (old.login,old.name,old.email);
        return old;

     end;
$$
LANGUAGE 'plpgsql';

-- Триггер на удаление из таблицы пользователей
create or replace trigger audit_client after delete on client
    for each row execute procedure client_delete();


-- Функция поиска кол-ва клиентов с заданным рейтингом
create or replace function find_count_with_rating(rat int ) returns int as
$$
    declare
        count_p integer;
        BEGIN
            select COUNT(*) into count_p from couriers where rating=rat;
            return count_p;
        END;
$$
language 'plpgsql'