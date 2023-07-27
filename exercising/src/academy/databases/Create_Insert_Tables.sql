use pet_shop;

insert into dogs (name,breed,age)
VALUES('Leo','Malinoa',2),
		('Ema','Hound',14);
		
insert into dogs(name,breed,age)
VALUES('Dara','Bulgarian Hound',1);

select * from dogs;

insert into cats (name,breed,age)
values ('Raya','White cat',8),
		('Maci','Black cat',3);
		
select c.age from cats c where c.breed = 'White cat';


create table people (
first_name varchar(20),
last_name varchar(20),
age INT
);

insert into people (first_name,last_name,age)
VALUES('Tina','Belcher',13),
		('Bob','Belcher',14),
		('Calvin','Potter',24);
		
select * from people;
drop table people;

insert into people(first_name)
VALUES('Pesho');

create table people2(
	first_name varchar(25) default 'unnamed' not null,
	last_name varchar(20) default 'unnamed' not null ,
age INT not null
);

-- check how not null and default value works
insert into people2(first_name,age)
VALUES('Peshko',23);
select * from people2;

desc people2;

drop table people2;
-- introducing primary key
create table people3(
	person_id INT primary key Auto_increment,
	first_name varchar(25) default 'unnamed' not null,
	last_name varchar(20) default 'unnamed' not null ,
	age INT not null
);
drop table people3;

insert into people3 (first_name,last_name,age)
VALUES('Tina','Belcher',13),
		('Bob','Belcher',14),
		('Calvin','Potter',24);
select * from people3;
desc people3;

-- exercise create table and insert
create table employees(
	employee_id INT primary key auto_increment,
	last_name varchar(50) not null,
	first_name varchar(50) not null,
	middle_name varchar(50),
	age int not null,
	current_status varchar(25) not null default 'employed'
);
desc employees;

insert into employees(first_name,last_name,age)
VALUES('Thomas', 'Petrov',32);

select * from employees;

