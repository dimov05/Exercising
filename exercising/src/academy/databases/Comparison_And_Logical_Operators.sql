select * from books where released_year != 2003;

select * from books where title not like '% %';

select title,author_fname,author_lname from books where title not like '%a%';\

select * from books where released_year > 2003;

select * from books where pages > 500 and released_year  >= 2000;

select * from books where author_lname = 'Eggers' and released_year > 2010;

select * from books where author_lname = 'Eggers' or released_year > 2010;

select * from books where released_year between 2000 and 2015;

select * from books where pages between 150 and 201;

select * from books where pages not between 150 and 345;

select * from people where birthdate < '2005-01-01';

select * from people where hour(birthtime) > 9;

select cast('09:00:00' as time);

select * from people where birthtime between cast('09:00:00' as time) and cast('10:00:00' as time);

select title, author_lname from books where author_lname in ('Carver','Lahiri','Smith');

select title,released_year from books where released_year not in (2000,2005,2010,2015);

select title,released_year from books where released_year not in (2001,2003,2005,2007);

select title,released_year from books where released_year % 2 = 1;

select
	title,
	released_year,
		case 
			when released_year >= 2000 then 'Modern Lit'
		else '20th Century Lit'
	end as GENRE
from
	books;
	
select
	title,
	stock_quantity,
	case
		when stock_quantity between 0 and 50 then '*'
		when stock_quantity between 51 and 100 then '**'
		when stock_quantity between 101 and 150 then '***'
		when stock_quantity between 151 and 200 then '****'
		else '*****'
	end as rating
from
	books;
		

-- 0,1,1

select * from books where released_year < 1980;

select * from books where author_lname in ('Eggers', 'Chabon');

select * from books where author_lname = 'Lahiri' and released_year > 2000;

select * from books where pages between 100 and 200;

select * from books where left(author_lname,1) in ('C','S');

select title,author_lname,
case 
	when title like '%stories%' then 'Short Stories'
	when title in ('Just Kids','A heartbreaking Work of Staggering Genius') then 'Memoir'
	else 'Novel'
end as 'TYPE'
from books;

select author_fname,author_lname,
case 
	when count(*) = 1 then '1 book'
	else concat(count(*),' books')
end as count
 from books group by author_fname,author_lname;

















		