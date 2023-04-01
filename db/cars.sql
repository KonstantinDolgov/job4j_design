create table cars (
    id serial primary key,
    name text,
	color varchar(255),
	year int,
	diesel bit
);
insert into cars (name, color, year, diesel ) values ('Toyota', 'white', 2003, '0');
update cars set diesel = '1';
delete from cars;
select * from cars;