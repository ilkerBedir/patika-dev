--1.film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?
select count(*) from film as f where f.length > 
	(select avg(film.length) from film);

--2.film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?
select count(*) from film as f where f.rental_rate = 
	(select max(film.rental_rate) from film);

-- 3.film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
(
select * from film where film.rental_rate = 
	(select min(film.rental_rate) from film)
)
union
(
select * from film where film.replacement_cost = 
	(select min(film.replacement_cost) from film)
);

--4.payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
select * from customer join payment on payment.customer_id=customer.customer_id where payment.customer_id = 
(
	select payment.customer_id from payment group by payment.customer_id order by count(customer_id) desc limit 1
);


