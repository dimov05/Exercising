create table companies (
	name varchar(255) not null,
	address varchaR(255) not null,
	constraint name_address UNIQUE(name,address)
);
insert into companies (name,address)
values('bultrans','Plovdiv'),('britanic','Sofia');

use book_shop;
alter table companies
add column phone varchar(15);


alter table companies 
add column employee_count INT not null default 1;

drop table companies;



alter table companies 
drop column phone;

alter table suppliers  
rename to companies

alter table companies
rename column employee_count to count_of_employees;

alter table companies 
modify name varchar(100) default 'unknown';


select * from companies;

desc companies 

create table houses(
	purchase_price int not null,
	sale_price int not null,
	constraint sprice_gt_pprice check(sale_price >= purchase_price)
);
insert into houses(purchase_price,sale_price) values(100,200);
select * from houses;

alter table houses add constraint positive_pprice check(purchase_price >= 0);

insert into houses(purchase_price,sale_price)
values(-1,4);

alter table houses drop constraint positive_pprice;