
create database shop;
use shop;
create table customers (
	id int primary key auto_increment,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(50)

);

create table orders(
	id int primary key auto_increment,
	order_date DATE,
	amount DECIMAL(8,2),
	customer_id int,
	foreign key (customer_id) references customers(id) on delete CASCADE
);

INSERT INTO customers (first_name, last_name, email) 
VALUES ('Boy', 'George', 'george@gmail.com'),
       ('George', 'Michael', 'gm@gmail.com'),
       ('David', 'Bowie', 'david@gmail.com'),
       ('Blue', 'Steele', 'blue@gmail.com'),
       ('Bette', 'Davis', 'bette@aol.com');
       
       
INSERT INTO orders (order_date, amount, customer_id)
VALUES ('2016-02-10', 99.99, 1),
       ('2017-11-11', 35.50, 1),
       ('2014-12-12', 800.67, 2),
       ('2015-01-03', 12.50, 2),
       ('1999-04-11', 450.25, 5);
       
select * from customers;
select * from orders;


select id from customers where last_name = 'George';

select * from orders where customer_id = 1;

select * from orders where customer_id = (select id from customers where last_name = 'George');

select
	first_name,
	last_name,
	order_date,
	amount
from
	customers
join orders 
on
	customers.id = orders.customer_id;


select first_name,last_name,sum(amount) as sum from customers
join orders on orders.customer_id = customers.id
group by customers.first_name,customers.last_name
order by sum asc;

select first_name, last_name,ifnull(sum(amount),0) as money_spent from customers
left join orders on orders.customer_id = customers.id
group by first_name, last_name;

select first_name, last_name,order_date,amount from customers
right join orders on orders.customer_id = customers.id;

select first_name,last_name,order_date,amount from customers
right join orders on orders.customer_id = customers.id;

delete from customers where first_name = 'George';



drop table customers;
drop table orders;


create table students (
	id int primary key auto_increment,
	first_name varchar(50)
);

create table papers(
	id int primary key auto_increment,
	title varchar(50),
	grade int,
	student_id int,
	foreign key (student_id) references students(id) on delete CASCADE
);

drop table papers;
drop table students;
INSERT INTO students (first_name) VALUES 
('Caleb'), ('Samantha'), ('Raj'), ('Carlos'), ('Lisa');

INSERT INTO papers (student_id, title, grade ) VALUES
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);

select first_name,title,grade from students
join papers on students.id = papers.student_id
order by grade desc;

select first_name,title,grade from students
left join papers on students.id = papers.student_id;

select first_name,title,ifnull(grade,0) from students
left join papers on students.id = papers.student_id;

select first_name,ifnull(avg(grade),0) as average from students 
left join papers on students.id = papers.student_id
group by first_name order by average desc;

select first_name,ifnull(avg(grade),0) as average,
case 
	when ifnull(avg(grade),0) >= 75 then 'PASSING'
	else 'FAILING'
	end as passing_status
from students 
left join papers on students.id = papers.student_id
group by first_name order by average desc;

