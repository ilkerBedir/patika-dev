--1.soru
select rating from film group by rating;
--2.soru
select replacement_cost,count(*) from film group by replacement_cost having count(*)>50;
--3.soru
select store_id,count(*) from customer group by store_id;
--4.soru
select country_id,count(*) from city group by country_id order by count desc limit 1;