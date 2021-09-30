insert into product(product_type, description, weight)
VALUES('Food/drinks','Milk',1.0),('Home/Garden','Sponge',0.12),('Electronics','Battery',0.34),('Clothes','T-shirt',0.123);

insert into transactions(date_open)
 values (to_date('2021/09/22','YYYY/MM/DD')),(to_date('2021/09/23','YYYY/MM/DD')),(to_date('2021/09/24','YYYY/MM/DD'));

-- status: ready  given  assembling
insert into orders(client_id, status, product_id, count, transaction_id)
values (1,'ready',1,3,1),(2,'given',2,1,2),(1,'ready',3,1,1);

insert into couriers(id,name ,rating,telephone_number)
values(1,'Arut',5,'89452035631'),(2,'Morat',2,'89452135699'),(3,'Armen',1,'8945213533');