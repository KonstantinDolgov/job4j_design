create table exercisers(
     id serial primary key,
     name varchar(255)
 );

 create table athletes(
     id serial primary key,
     name varchar(255)
 );

 create table exercisers_athletes(
     id serial primary key,
     exerciser_id int references exercisers(id),
     athlete_id int references athletes(id)
 );