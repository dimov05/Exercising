use book_shop;

select count(*) from books;

select count(distinct author_fname) from books;

select count(title) from books where title like '%the%';

select author_lname, count(*) as books_written from books group by author_lname order by books_written desc ;

select released_year, count(*) from books group by released_year;

select author_lname,count(author_lname) from books group by author_lname;

select MIN(released_year) from books;

select MIN(author_lname), Max(author_fname) from books;

select title, pages from books order by pages desc limit 1;

select title, pages from books where pages = (select max(pages) from books);

select min(released_year) from books;
select title, released_year from books where released_year = (select min(released_year) from books);

select author_lname, count(*) from books group by author_fname ,author_lname ;

select concat_WS(' ', author_fname,author_lname) as author, count(*) from books group by author;

select
	concat_ws(' ',author_fname,author_lname)  as author,
	count(*) as book_written,
	min(released_year) as earlies_released,
	max(released_year) as latest_released,
	Max(pages) as max_page_count
from
	books
group by
	author  ;

SET SESSION sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select author_lname,sum(pages) from books group by author_lname ; 

select sum(author_lname) from books;

select avg(pages) from books;

select released_year,avg(stock_quantity), count(*) from books group by released_year;

select released_year ,COUNT(*) from books group by released_year ;

select sum(stock_quantity) from books;

select concat_ws(' ',author_fname,author_lname) as author,avg(released_year) as avg_released_year from books group by author ;

select concat_ws(' ',author_fname,author_lname) as author, MAX(pages) from books ;
select 
		released_year as year,
		count(*) as books,
		cast(avg(pages) as decimal(10, 4)) as 'avg pages'
from
	books
group by
	released_year
order by
	released_year ;


select count(*) from books;













