use pet_shop;

create table dogs (
	name VARCHAR(25),
	breed VARCHAR(25),
	age INT
	);

create table cats (
	name VARCHAR(25),
	breed VARCHAR(25),
	age INT
	);
	
show tables;

show columns from dogs;

desc cats;

drop table pastries ;

create table pastries (
	name varchar(50),
	quantity int
);

desc pastries;