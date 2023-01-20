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
showtime_id int NOT NULL,
seats varchar (200) NOT NULL,
total_cost int NOT NULL,
showtime_date varchar(200),
CONSTRAINT PK_orders PRIMARY KEY(order_id),
CONSTRAINT FK_showtime FOREIGN KEY (showtime_id) REFERENCES showtimes(showtime_id)
);



