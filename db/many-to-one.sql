create table mother(
    id serial primary key,
    name varchar(255)
);

create table child(
    id serial primary key,
    name varchar(255),
    mother_id int references mother(id)
);