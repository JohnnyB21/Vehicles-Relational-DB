show databases;

CREATE database  vehicles;
use vehicles;

create table cars (
id int(11) not null auto_increment,
make varchar(20) not null,
model varchar(20) not null,
year_manufactured int(4) not null,
primary key (id)
);

desc cars;

INSERT into cars(make, model, year_manufactured) values("Infinit", "Q50", 2020);
select * from cars;

update cars set year_manufactured = 2017 where id = 9;



