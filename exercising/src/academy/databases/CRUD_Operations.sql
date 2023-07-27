use pet_shop;

CREATE TABLE cats (
    cat_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    breed VARCHAR(100),
    age INT,
    PRIMARY KEY (cat_id)
); 

INSERT INTO cats(name, breed, age) 
VALUES ('Ringo', 'Tabby', 4),
       ('Cindy', 'Maine Coon', 10),
       ('Dumbledore', 'Maine Coon', 11),
       ('Egg', 'Persian', 4),
       ('Misty', 'Tabby', 13),
       ('George Michael', 'Ragdoll', 9),
       ('Jackson', 'Sphynx', 7);
       
select name, age from cats;

select * from cats where age >= 8;

select cat_id from cats;

select name,breed from cats;

select name,age from cats where breed = 'Tabby';

select cat_id as id, age as kittyAge from cats where cat_id = age;

update cats set breed = 'Tabbby' where name = 'Ringo';

update cats set breed = 'Tabby' where breed = 'Tabbby';
select * from cats;

update cats set name = 'Jack' where name = 'Jackson';

update cats set breed = 'British Shorthair' where name = 'Ringo';

update cats set age = 12 where breed = 'Maine Coon';

select * from cats;

delete from cats where name = 'Egg';
drop table cats;

delete from cats where age = 4;

delete from cats where age = cat_id;

delete  from cats;