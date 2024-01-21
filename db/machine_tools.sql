create table tools
(
    id    serial primary key,
    model  varchar(50),
    year integer,
    type varchar(50)
);

insert into tools (model, year, type)
VALUES ('1K62', 5, 'lathe');
insert into tools (model, year, type)
VALUES ('6T13', 15, 'miller');
insert into tools (model, year, type)
VALUES ('3D722', 1, 'grinder');

begin transaction isolation level serializable;

select sum(year) from tools;

update tools set year = 1 where model = '1K62';

select sum(year) from tools;

update tools set year = 50 where model = '6T13';

commit;