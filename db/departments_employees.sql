create table employees(
    id serial primary key,
    name varchar(255)
);

create table departaments(
    id serial primary key,
    name varchar(255),
    employees_id int references employees(id)
);

create table teens(
    id serial primary key,
    name varchar(255),
	gender varchar(255)
);

insert into employees(name) values ('Иванова'), ('Петрова'), ('Сидорова'),
('Пушкин'), ('Лермонтов'), ('Хохлачев');

insert into departaments(name, employees_id) values ('Закупки', 1), ('Бухгалтерия', 2), ('Экономический', null),
('Безопасность', 3), ('ИТР', 4), ('ОГМ', 5), ('ОГЭ', 6);

insert into teens(name, gender) values ('Аня', 'Ж'), ('Коля', 'М'), ('Света', 'Ж'),
('Маша', 'Ж'), ('Лена', 'Ж'), ('Лёша', 'М'), ('Саша', 'М');

select * from employees e left join departaments d on d.employees_id = e.id;

select * from departaments d right join employees e on d.employees_id = e.id;

select * from departaments d full join employees e on d.employees_id = e.id;

select * from employees e cross join departaments d;

select * from departaments d left join employees e on d.employees_id = e.id
where e.id is null;

select * from departaments d left join employees e on d.employees_id = e.id
where e.id is not null;
select * from departaments d right join employees e on d.employees_id = e.id;

select n1.name, n1.gender, n2.name, n2.gender
from teens n1 cross join teens n2 where n1.gender != n2.gender;