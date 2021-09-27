create table if not exists contact(
    id serial primary key,
    adress varchar(120),
    telephone_number varchar(11)
    );

create table if not exists client(
    id serial primary key,
    login varchar(30),
    password varchar(30),
    name varchar(25),
    email varchar(30),
    contact_id int references contact(id),
    status varchar(4)
    );

create table if not exists warehouse(
     id serial primary key,
     name varchar(25),
    adress varchar(60)
    );

create table if not exists transactions(
  id serial primary key,
  date_open timestamp
);

create table if not exists product(
    id serial primary key,
    product_type varchar(25),
    description varchar(100),
    weight numeric(4,3)
    );

create table if not exists orders(
    id serial primary key,
    client_id int references client(id),
    status varchar(10),
    product_id int references product(id),
    count int,
    transaction_id int references transactions(id)
    );

create table if not exists couriers(
    id serial primary key,
    name varchar(30),
    rating int,
    telephone_number varchar(11)

    );

create table if not exists delivery(
    id serial primary key,
    client_id int references client(id),
    warehouse_id int references warehouse(id),
    date timestamp,
    transaction_id int references transactions(id),
    deliviry_cost int,
    courier_id int references couriers(id)
    );

create table if not exists accounting_product(
    id serial primary key,
    product_id int references product(id),
    count int,
    warehouse_id int references warehouse(id)
    );