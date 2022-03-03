--1.soru
select c.country from country as c where (c.country like 'A%') and (c.country ilike '%a') ;

--2.soru
select c.country from country as c where c.country ilike '%_____n';

--3.soru
select title from film where (title like '%T%t%t%t%') ;

--4.soru
select * from film where (title like 'C%') and length>90 and rental_rate=2.99;