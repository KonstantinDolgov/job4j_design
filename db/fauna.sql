create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('viper', 50000, '01.01.1762');
insert into fauna(name, avg_age, discovery_date)
values ('sword-fish', 15000, '05.09.1839');
insert into fauna(name, avg_age, discovery_date)
values ('racoon', 12000, null);
insert into fauna(name, avg_age, discovery_date)
values ('fly', 200, null);
insert into fauna(name, avg_age, discovery_date)
values ('snowman', 1000000000, '13.02.1953');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';
