use book_shop;
CREATE TABLE books 
	(
		book_id INT NOT NULL AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);

INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

select
	*
from
	books;
desc books;


select
	concat(author_fname, ' ', author_lname) as full_name
from
	books; 

select
	concat_ws(' ', author_fname, author_lname) as full_name
from
	books; 

select
	substring(title, 1, 15)
from
	books; 
select
	substring(author_fname, 1, 1),
	author_fname
from
	books;

select
	concat(substr(title, 1, 10), '...') as 'short title'
from
	books;
	
select
	concat(substr(author_fname, 1, 1), '.', substr(author_lname, 1, 1) , '.')
from
	books; 
	

select
	replace(title, ' ', '_')
from
	books;

select
	*
from
	books;

select concat(author_fname,' ',reverse(author_fname)) from books;

select char_length(title) as 'title\'s lenght', title,author_lname from books; 

select lower(title) as 'lowercase title', title from books; 
select upper(title) as 'uppercase title', title from books; 

select insert(author_fname,3,0,author_lname) from books;

select left(author_fname,3) from books;
select right(author_fname,2) from books;
select repeat(title,3) from books;
select trim(author_fname) from books;

select upper(reverse('Why does my cat look at me with such hatred?'));

select replace(title,' ','->') from books;

select author_lname as forwards, reverse(author_lname) as backwards from books;

select upper(concat_ws(' ',author_fname,author_lname)) as 'full name in caps' from books; 

select concat(title,' was released in ',released_year) as blurb from books; 

select title, char_length(title) as 'character count' from books; 

select
	concat(substr(title, 1, 10), '...') as short_title,
	concat_ws(',', author_lname, author_fname) as author,
	concat(stock_quantity, ' in stock') as quantity
from
	books order by short_title;  

