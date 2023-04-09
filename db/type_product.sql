create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	expired_date date,
	price float,
    type_id int references type(id)
);

into type(name) values ('СЫР'), ('МОЛОКО'), ('МЯСО'), ('ОВОЩИ'), ('ФРУКТЫ');
insert into product(name, expired_date, price, type_id) values ('пошехонский', '21.04.2023', 45, 1),
('моцарелла', '02.03.2023', 120, 1), ('апельсин', '02.05.2023', 70, 5),
('говядина', '12.02.2023', 670, 3), ('мороженое эскимо', '20.04.2023', 87, 2),
('огурец', '29.04.2023', 129, 4);

select p.name, t.name
from product p
join type t on p.type_id = t.id
where t.name = 'СЫР';

select name
from product
where name like '%мороженое%';

select name, expired_date
from product
where expired_date < now();

select max(price) from product;

select t.name, count(*)
from type t
join product p on p.type_id = t.id
group by t.name;

select p.name, t.name
from product p
join type t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(*)
from type t
join product p on p.type_id = t.id
group by t.name
having count(*) < 10;

select p.name, t.name
from product p
join type t on p.type_id = t.id;