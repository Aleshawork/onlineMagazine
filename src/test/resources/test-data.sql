insert into contact(adress,telephone_number)
values('Moscov, Popovo 21 2','89651085632'),('Moscov, Tolstogo 5 1','89652075689');



insert into client(login,password,name,email,contact_id,status)
values('Alesha','1234','Alexey','alesha@mail.ru',1,'on'),
      ('Egorushka','1234','Egor','egor@mail.ru',2,'on');

-- product and transaction init
insert into product(product_type, description, weight)
VALUES('Food/drinks','Milk',1.0),('Home/Garden','Sponge',0.12),('Electronics','Battery',0.34),('Clothes','T-shirt',0.123);

insert into transactions(date_open)
values (to_date('2021/09/22','YYYY/MM/DD')),(to_date('2021/09/23','YYYY/MM/DD')),(to_date('2021/09/24','YYYY/MM/DD'));

-- status: ready  given  assembling
insert into orders(client_id, status, product_id, count, transaction_id)
values (1,'ready',1,3,1),(2,'given',2,1,2),(1,'ready',3,1,1);