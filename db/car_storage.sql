create table car_bodies(
    id serial primary key,
    name varchar(255)
);

create table car_engines(
    id serial primary key,
    name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('Седан'), ('Пикап'), ('Хэтчбек'),
('Кабриолет'), ('Кросовер'), ('Внедорожник');

insert into car_engines(name) values ('Бензин'), ('Дизель'), ('Гибрид');

insert into car_transmissions(name) values ('Механика'), ('Автомат'), ('Робот');

insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota', 3, 1, 2), ('Nissan', 1, 2, 1),
('Москвич', null, null, null), ('Audi', 2, 3, 3), ('Жигули', 6, null, 1), ('Ёпмобиль', null, 3, null);

select c.name, cb.name, ce.name, ct.name
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id;

select cb.name, c.name
from cars c
right join car_bodies cb on c.body_id = cb.id
where c.name is null;

select ce.name, c.name
from cars c
right join car_engines ce on c.engine_id = ce.id
where c.name is null;

select ct.name, c.name
from cars c
right join car_transmissions ct on c.transmission_id = ct.id
where c.name is null;