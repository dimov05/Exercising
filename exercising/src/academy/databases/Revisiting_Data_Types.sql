create table products (price DECIMAL(5,2));
use products;

insert into products (price)
values (4.50);

insert into products (price)
values (100.50);
select * from products;

create table numbers (x float, y double);

insert into numbers (x,y) values( 1.123,1.123);

insert into numbers (x,y) values( 1.123456789123456,1.123456789123456123456);

select * from numbers;

create table people (
	name varchar(100),
	birthdate DATE,
	birthtime TIME,
	birthdt DATETIME
);

insert into people (name,birthdate,birthtime,birthdt)
values('Elthon','1999-04-05','09:15:22', '1999-04-05 09:15:22');


insert into people (name,birthdate,birthtime,birthdt)
values('Gosho','1969-10-05','11:00:00', '1969-10-05 11:00:00');
insert into people (name,birthdate,birthtime,birthdt)
values('Pesho','1987-11-25','06:25:12', '1987-11-25 06:25:12');

insert into people(name,birthdate,birthtime,birthdt)
values("Mimi",CURDATE(),CURTIME(),NOW());

select birthdate, dayofweek(birthdate), dayofyear(birthdate), monthname(birthdate)  from people;

select concat_ws(' ',monthname(birthdate), day(birthdate), year(birthdate)) from people; 

select date_format(birthdate,'%a %d %M') from people; 

select birthdt, date_format(birthdt,'Born on: %r') from people; 

select birthdate from people;

select birthdate, datediff(curdate(),birthdate) from people; 

select date_sub(curdate(), interval 1 year);

select birthdate, date_add(birthdate, interval 18 year)  from people;

select name,birthdate, year(birthdate + interval 21 year) as will_be_21 from people ;

create table captions(
	text varchar(150),
	created_at timestamp default current_timestamp,
	updated_at timestamp on update current_timestamp
);

drop table captions;
insert into captions(text) values('just me and the boys chillin'),('sunset');


insert into captions(text) values('random timestamp');
update captions set text='i love live!!' where text = 'random timestamp';

select * from captions;

create table inventory (
	item_name varchar(100),
	price DECIMAL(8,2),
	quantity int
);

select now();
select curdate();

select date_format(curdate(),'%W'); 

select date_format(curdate(),'%m/%d/%Y');

select date_format(now(),'%M %D at %H:%i');

create table tweets (  
	content VARCHAR(150),
	username varchar(50),
	created_at TIMESTAMP default CURRENT_TIMESTAMP()
);

INSERT INTO tweets (content, username) VALUES('this is my first tweet', 'coltscat');
SELECT * FROM tweets;
 
INSERT INTO tweets (content, username) VALUES('this is my second tweet', 'coltscat');
SELECT * FROM tweets;

select * from tweets;





select * from people;
