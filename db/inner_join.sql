create table tool(
    id serial primary key,
    type varchar(255),
    model varchar(255)
);

create table worker(
    id serial primary key,
    name varchar(255),
    tool_id int references tool(id) unique
);

insert into tool(type, model) values ('lathe', '1K62');
insert into tool(type, model) values ('miller', '6T13');
insert into tool(type, model) values ('grinder', '3Д722');

insert into worker(name, tool_id) values ('Михалыч', 1);
insert into worker(name, tool_id) values ('Петрович', 2);
insert into worker(name, tool_id) values ('Федорыч', 3);
insert into worker(name) values ('Николаич');

select w.name, t.type, t.model
from worker as w join tool as t on w.tool_id = t.id;

select w.name as Имя, t.type as Тип, t.model as Модель
from worker as w join tool as t on w.tool_id = t.id;

select w.name as "Имя рабочего", t.type Тип, t.model Модель
from worker w join tool t on w.tool_id = t.id;