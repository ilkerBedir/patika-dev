--1.soru
select city.city,country.country from city join country on city.country_id=country.country_id;
--2.soru
select customer.first_name,customer.last_name,payment.payment_id from customer join payment on customer.customer_id=payment.customer_id;
--3.soru
select customer.first_name,customer.last_name,rental.rental_id from customer join rental on customer.customer_id=rental.customer_id;
