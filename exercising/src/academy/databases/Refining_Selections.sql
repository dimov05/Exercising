use book_shop;

INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);
           
select * from books;

select distinct author_lname from books;
select distinct released_year from books;

select distinct concat_ws(' ',author_fname,author_lname) from books; 

select distinct author_fname,author_lname from books;

select book_id, title,pages, released_year  from books order by released_year,pages limit 5;
select book_id, title,pages,released_year from books order by released_year desc limit 10;

select title,author_fname,author_lname from books where author_fname like '%id%';
select author_fname from books where author_fname like '____';

select title from books where title like '%stories%';
select title, pages from books order by pages desc limit 1;

select concat_ws(' - ', title,released_year) from books order by released_year desc limit 3; 

select title, author_lname from books where author_lname like '% %';  

select title, released_year, stock_quantity from books order by stock_quantity  limit 3;

select title, author_lname from books order by author_lname, title;

select upper(concat('my favorite author is ',author_fname,' ', author_lname,'!')) as yell from books order by author_lname;