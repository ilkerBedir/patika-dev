--1.test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
create table employee(
	id integer,
	name varchar(50),
	birthday date,
	email varchar(100)
);

--2.Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
insert into employee (id, name, birthday, email) values (1, 'Shawn', '2008-06-13', 'showse0@smh.com.au');
insert into employee (id, name, birthday, email) values (2, 'Helen-elizabeth', '1997-09-11', 'hsomerton1@businessweek.com');
insert into employee (id, name, birthday, email) values (3, 'Lavina', '2004-07-03', 'leustace2@independent.co.uk');
insert into employee (id, name, birthday, email) values (4, 'Carl', '2003-02-03', 'cbonwell3@bravesites.com');
insert into employee (id, name, birthday, email) values (5, 'Glenn', '2001-05-21', 'gdallicoat4@ox.ac.uk');
insert into employee (id, name, birthday, email) values (6, 'Layla', '2011-08-13', 'lmead5@telegraph.co.uk');
insert into employee (id, name, birthday, email) values (7, 'Evvy', '2014-01-03', 'eshufflebotham6@youtu.be');
insert into employee (id, name, birthday, email) values (8, 'Toinette', '2015-01-19', 'tolfert7@linkedin.com');
insert into employee (id, name, birthday, email) values (9, 'Ward', '2014-07-15', 'wwoolmore8@geocities.com');
insert into employee (id, name, birthday, email) values (10, 'Carlie', '2007-04-12', 'clatter9@eepurl.com');
insert into employee (id, name, birthday, email) values (11, 'Cordelia', '1994-04-11', 'cairtona@woothemes.com');
insert into employee (id, name, birthday, email) values (12, 'Francklin', null, null);
insert into employee (id, name, birthday, email) values (13, 'Whitby', '2016-02-21', 'wburfieldc@jalbum.net');
insert into employee (id, name, birthday, email) values (14, 'Carley', '1995-09-13', 'chenrysond@theglobeandmail.com');
insert into employee (id, name, birthday, email) values (15, 'Aldo', null, null);
insert into employee (id, name, birthday, email) values (16, 'Hobard', '1995-02-25', 'hamyesf@sogou.com');
insert into employee (id, name, birthday, email) values (17, 'Claresta', '1998-07-07', 'cgauntg@nasa.gov');
insert into employee (id, name, birthday, email) values (18, 'Pennie', '2010-06-30', 'pcasseyh@multiply.com');
insert into employee (id, name, birthday, email) values (19, 'Tadeas', '2000-09-07', 'tariesi@xing.com');
insert into employee (id, name, birthday, email) values (20, 'Beulah', '1993-06-04', 'bpiddlej@sciencedirect.com');
insert into employee (id, name, birthday, email) values (21, 'Jabez', '2003-02-10', 'jlorriek@opensource.org');
insert into employee (id, name, birthday, email) values (22, 'Agnese', '2001-11-08', 'aparkinsonl@youtu.be');
insert into employee (id, name, birthday, email) values (23, 'Karleen', '2016-02-18', 'kmccoym@senate.gov');
insert into employee (id, name, birthday, email) values (24, 'Riva', '2020-02-26', 'rcockingsn@cbsnews.com');
insert into employee (id, name, birthday, email) values (25, 'Tailor', '1998-01-25', 'tbennettso@gmpg.org');
insert into employee (id, name, birthday, email) values (26, 'Hettie', '2012-03-21', 'hdoddingp@latimes.com');
insert into employee (id, name, birthday, email) values (27, 'Murdock', '1998-11-09', 'mantoniettiq@businessinsider.com');
insert into employee (id, name, birthday, email) values (28, 'Tedda', '2018-02-18', 'tduffinr@cam.ac.uk');
insert into employee (id, name, birthday, email) values (29, 'Maynord', '2003-12-01', 'mchapelhows@about.com');
insert into employee (id, name, birthday, email) values (30, 'Lona', null, null);
insert into employee (id, name, birthday, email) values (31, 'Pinchas', '2011-08-16', 'pledraneu@phpbb.com');
insert into employee (id, name, birthday, email) values (32, 'Sansone', '2004-06-16', 'ssparkev@reference.com');
insert into employee (id, name, birthday, email) values (33, 'Jard', '1995-09-25', 'jettridgew@adobe.com');
insert into employee (id, name, birthday, email) values (34, 'Marcelline', null, null);
insert into employee (id, name, birthday, email) values (35, 'Arne', '2003-07-30', 'aladdsy@amazonaws.com');
insert into employee (id, name, birthday, email) values (36, 'Kaylil', '2003-07-05', 'kcolquittz@adobe.com');
insert into employee (id, name, birthday, email) values (37, 'Arvin', '2006-12-26', 'asimmgen10@ameblo.jp');
insert into employee (id, name, birthday, email) values (38, 'Deedee', '2010-08-16', 'dlawler11@newsvine.com');
insert into employee (id, name, birthday, email) values (39, 'Emogene', '2001-04-16', 'escopham12@simplemachines.org');
insert into employee (id, name, birthday, email) values (40, 'Pyotr', '2013-06-10', 'poakeby13@goo.ne.jp');
insert into employee (id, name, birthday, email) values (41, 'Tiff', '2011-03-20', 'tkingscote14@ucoz.ru');
insert into employee (id, name, birthday, email) values (42, 'Kimberley', '2009-11-21', 'kwenman15@google.fr');
insert into employee (id, name, birthday, email) values (43, 'Vivianne', null, null);
insert into employee (id, name, birthday, email) values (44, 'Willis', '2015-12-25', 'wduffree17@ow.ly');
insert into employee (id, name, birthday, email) values (45, 'May', '2015-08-24', 'mfairnie18@parallels.com');
insert into employee (id, name, birthday, email) values (46, 'Raine', '2008-07-11', 'rmetham19@flickr.com');
insert into employee (id, name, birthday, email) values (47, 'Florri', '2003-02-05', 'fmatteau1a@delicious.com');
insert into employee (id, name, birthday, email) values (48, 'Deeyn', '1991-01-28', 'dpiwall1b@discuz.net');
insert into employee (id, name, birthday, email) values (49, 'Rolph', '2008-11-10', 'rbothie1c@so-net.ne.jp');
insert into employee (id, name, birthday, email) values (50, 'John', '2014-06-11', 'jmusla1d@ihg.com');

--3.Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
update employee set id=51,name='ilker',birthday='2000-01-12',email='blabla@gmail' where id=5 returning * ;
update employee set id=52,name='deneme',birthday='2001-01-12',email='blaxbla@gmail' where name='Tiff' returning * ;
update employee set id=53,name='deneme2',birthday='2002-01-12',email='blacbla@gmail' where birthday='2009-11-21' returning * ;
update employee set id=54,name='deneme3',birthday='2003-01-12',email='blabvla@gmail' where email='rmetham19@flickr.com' returning * ;
update employee set id=55,name='deneme4',birthday='2004-01-12',email='blablba@gmail' where id=25 returning * ;

--4.Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
delete from employee where id=51;
delete from employee where name='deneme';
delete from employee where birthday='2002-01-12';
delete from employee where email='blabvla@gmail';
delete from employee where id=55;