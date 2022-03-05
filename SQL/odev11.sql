actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.
actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak ikinci tabloda bulunmayan verileri sıralayalım.
İlk 3 sorguyu tekrar eden veriler için de yapalım.
--1.soru
(select first_name from actor) union (select first_name from customer); 
--2.soru
(select first_name from actor) intersect (select first_name from customer); 
--3.soru
(select first_name from actor) except (select first_name from customer); 
--4.soru
(select first_name from actor) union all (select first_name from customer); 
(select first_name from actor) intersect all (select first_name from customer); 
(select first_name from actor) except all (select first_name from customer); 