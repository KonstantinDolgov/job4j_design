create table workers (
    id serial primary key,
    name varchar(50)
);

create table tools (
    id serial primary key,
    name varchar(50)
);

create table workplaces (
    id serial primary key,
    name varchar(200),
    tool_id integer references tools(id)
);

create table workshops (
    id serial primary key,
    workplace_id integer references workplaces(id),
    worker_id integer references workers(id)
);

insert into workers (name) values ('Петрович');
insert into workers (name) values ('Борисыч');
insert into workers (name) values ('Леонидыч');

insert into tools (name) values ('1Е61П');
insert into tools (name) values ('6Т13');
insert into tools (name) values ('Верстак');
insert into tools (name) values ('3Д722');

insert into workplaces (name, tool_id) values ('Токарный', 1);
insert into workplaces (name, tool_id) values ('Фрезерный', 2);
insert into workplaces (name, tool_id) values ('Слесарный', 3);
insert into workplaces (name, tool_id) values ('Шлифовальный', 4);

insert into workshops (workplace_id, worker_id) values (1, 1);
insert into workshops (workplace_id, worker_id) values (2, 1);
insert into workshops (workplace_id, worker_id) values (3, 2);
insert into workshops (workplace_id, worker_id) values (4, 3);
insert into workshops (workplace_id, worker_id) values (2, 1);
insert into workshops (workplace_id, worker_id) values (3, 2);

select w.name, count(t.name), t.name from workers as w
    join workshops ws on w.id = ws.worker_id
    join workplaces wp on ws.workplace_id = wp.id
    join tools t on wp.tool_id = t.id
    group by (w.name, t.name);