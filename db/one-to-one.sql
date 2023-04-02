create table serial_number(
    id serial primary key,
    number int
);

create table engine(
    id serial primary key,
    name varchar(255),
    serial_number_id int references serial_number(id) unique
);