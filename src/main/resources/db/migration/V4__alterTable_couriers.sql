alter table delivery
drop constraint delivery_courier_id_fkey,
    add constraint delivery_courier_id_fkey
        foreign key (courier_id)
        references couriers(id)
        on delete cascade;