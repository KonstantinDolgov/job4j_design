create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.13
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 100);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 7, 200);

create or replace function beforetax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.13
		where id = new.id;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger beforetax_trigger
    before insert
    on products
    for each row
    execute procedure beforetax();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 1, 1000);

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function hop()
    returns trigger as
$$
    BEGIN
		insert into history_of_price (name, price, date) values (new.name, new.price, now());
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history_of_price_trigger
    after insert
    on products
    for each row
    execute procedure hop();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 2, 2000);
