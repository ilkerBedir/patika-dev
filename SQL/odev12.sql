--1.soru
select count(*) from film as f where f.length > (select avg(film.length) from film);

--2.soru
select count(*) from film as f where f.rental_rate = (select max(film.rental_rate) from film);

-- 3.soru
(select * from film where film.rental_rate = (select min(film.rental_rate) from film))
union
(select * from film where film.replacement_cost = (select min(film.replacement_cost) from film));

--4.soru
select * from customer join payment on payment.customer_id=customer.customer_id where payment.customer_id = (
select payment.customer_id from payment group by payment.customer_id order by count(customer_id) desc limit 1);


