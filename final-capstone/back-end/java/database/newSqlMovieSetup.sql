DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS showtimes CASCADE;
DROP TABLE IF EXISTS theaters CASCADE;
DROP TABLE IF EXISTS seats CASCADE;
DROP TABLE IF EXISTS orders CASCADE;

DROP SEQUENCE IF EXISTS seq_movie_id;
DROP SEQUENCE IF EXISTS seq_showtime_id;
DROP SEQUENCE IF EXISTS seq_theater_id;
DROP SEQUENCE IF EXISTS seq_seat_id;
DROP SEQUENCE IF EXISTS seq_order_id;

--Beginning of Movie Table--

CREATE SEQUENCE seq_movie_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
  --Create Table--
  
  CREATE TABLE movies (
       movie_id int DEFAULT nextval('seq_movie_id'::regclass) NOT NULL,
       title varchar(200) NOT NULL,
       release_date varchar(100) NOT NULL,
       isFeatured boolean NOT NULL,
       overview varchar(512),
       poster varchar(500),
       trailer_id varchar(500) NOT NULL,
       CONSTRAINT PK_movie PRIMARY KEY (movie_id)
       );
  --Inserting Movies--     
INSERT INTO movies (title, release_date, isFeatured, overview, poster, trailer_id) VALUES (
'Jurassic Park', 
'June 11, 1993', 
true, 
'A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA. 
Before opening day, he invites a team of experts and his two eager grandchildren to experience the park and help calm anxious investors. 
However, the park is anything but amusing as the security systems go off-line and the dinosaurs escape.', 
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9i3plLl89DHMz7mahksDaAo7HIS.jpg',
'KdGO9tL2DQ4'
);
  
INSERT INTO movies (title, release_date, isFeatured, overview, poster, trailer_id) VALUES (
'TENET', 
'September 9, 2020', 
true, 
'Armed with only one word - Tenet - and fighting for the survival of the entire world,
 the Protagonist journeys through a twilight world of international espionage on a mission 
 that will unfold in something beyond real time.',
 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg',
 'LdOM0x0XDMo'
 );

INSERT INTO movies (title, release_date, isFeatured, overview, poster, trailer_id) VALUES (
'Home Alone',
'November 16, 1990',
true,
'Eight-year-old Kevin McCallister makes the most of the situation after his family 
unwittingly leaves him behind when they go on Christmas vacation. But when a pair of bungling burglars 
set their sights on Kevins house, the plucky kid stands ready to defend his territory. 
By planting booby traps galore, adorably mischievous Kevin stands his ground as his frantic mother attempts 
to race home before Christmas Day.',
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9wSbe4CwObACCQvaUVhWQyLR5Vz.jpg',
'1iZBw5Qybuo'
);

INSERT INTO movies (title, release_date, isFeatured, overview, poster, trailer_id) VALUES (
'National Lampoon''s Christmas Vacation', 
'December 1, 1989', 
true, 
'It"s Christmas time and the Griswolds are preparing for a family seasonal celebration, 
but things never run smoothly for Clark, his wife Ellen and their two kids. 
Clark"s continual bad luck is worsened by his obnoxious family guests, but he manages to keep going knowing 
that his Christmas bonus is due soon.',
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/dm2KpvwzfyPduUK1yBATxPveSgd.jpg',
'NBTTipJX-h4'
);
--End Movie Table--

--Start Showtime Table--

CREATE SEQUENCE seq_showtime_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_theater_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
  


--Table Creation--

CREATE TABLE theaters(
theater_id int DEFAULT nextval('seq_theater_id'::regclass) NOT NULL,
CONSTRAINT PK_theater PRIMARY KEY (theater_id)

);

CREATE TABLE showtimes(
showtime_id int DEFAULT nextval('seq_showtime_id'::regclass) NOT NULL,
movie_id int NOT NULL,
theater_id int NOT NULL,
start_time varchar(50) NOT NULL,
dayOfWeek varchar(50) NOT NULL,
matinee boolean NOT NULL,
CONSTRAINT PK_showtime PRIMARY KEY (showtime_id)
);

ALTER TABLE showtimes ADD CONSTRAINT FK_movie FOREIGN KEY (movie_id) REFERENCES movies(movie_id);
ALTER TABLE showtimes ADD CONSTRAINT FK_theater FOREIGN KEY (theater_id) REFERENCES theaters(theater_id);

INSERT INTO theaters (theater_id) VALUES (1);
INSERT INTO theaters (theater_id) VALUES (2);
INSERT INTO theaters (theater_id) VALUES (3);
INSERT INTO theaters (theater_id) VALUES (4);


--Showtimes Data

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '11:00 AM', 'Monday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '7:00 PM', 'Monday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '11:00 AM', 'Monday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '7:00 PM', 'Monday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '11:00 AM', 'Monday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '7:00 PM', 'Monday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '11:00 AM', 'Monday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '7:00 PM', 'Monday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '11:15 AM', 'Tuesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '7:15 PM', 'Tuesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '11:15 AM', 'Tuesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '7:15 PM', 'Tuesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '11:15 AM', 'Tuesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '7:15 PM', 'Tuesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '11:15 AM', 'Tuesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '7:15 PM', 'Tuesday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '11:30 AM', 'Wednesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '7:30 PM', 'Wednesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '11:30 AM', 'Wednesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '7:30 PM', 'Wednesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '11:30 AM', 'Wednesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '7:30 PM', 'Wednesday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '11:30 AM', 'Wednesday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '7:30 PM', 'Wednesday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '11:45 AM', 'Thursday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '7:45 PM', 'Thursday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '11:45 AM', 'Thursday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '7:45 PM', 'Thursday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '11:45 AM', 'Thursday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '7:45 PM', 'Thursday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '11:45 AM', 'Thursday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '7:45 PM', 'Thursday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '10:00 AM', 'Friday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '8:00 PM', 'Friday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '10:00 AM', 'Friday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '8:00 PM', 'Friday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '10:00 AM', 'Friday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '8:00 PM', 'Friday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '10:00 AM', 'Friday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '8:00 PM', 'Friday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '10:15 AM', 'Saturday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '8:15 PM', 'Saturday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '10:15 AM', 'Saturday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '8:15 PM', 'Saturday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '10:15 AM', 'Saturday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '8:15 PM', 'Saturday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '10:15 AM', 'Saturday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '8:15 PM', 'Saturday', false);

INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '10:30 AM', 'Sunday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (1, 1, '8:30 PM', 'Sunday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '10:30 AM', 'Sunday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (2, 2, '8:30 PM', 'Sunday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '10:30 AM', 'Sunday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (3, 3, '8:30 PM', 'Sunday', false);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '10:30 AM', 'Sunday', true);
INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (4, 4, '8:30 PM', 'Sunday', false);


--Showtimes By Day Table--
        
CREATE SEQUENCE seq_seat_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;  
  
CREATE TABLE seats(
seat_id int DEFAULT nextval('seq_seat_id'::regclass) NOT NULL,
seat_name varchar (50) NOT NULL,
showtime_id int NOT NULL,
is_booked boolean,
CONSTRAINT PK_seats PRIMARY KEY(seat_id),
CONSTRAINT FK_showtime FOREIGN KEY (showtime_id) REFERENCES showtimes(showtime_id)
);

CREATE SEQUENCE seq_order_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;  
  
CREATE TABLE orders(
order_id int DEFAULT nextval('seq_order_id'::regclass) NOT NULL,
username varchar (100) NOT NULL,
full_name varchar (150) NOT NULL,
email varchar (300) NOT NULL,
billing_address varchar (300),
showtime_id int NOT NULL,
seats varchar (200) NOT NULL,
total_cost int NOT NULL,
CONSTRAINT PK_orders PRIMARY KEY(order_id),
CONSTRAINT FK_showtime FOREIGN KEY (showtime_id) REFERENCES showtimes(showtime_id)
);



