CREATE TABLESPACE tbs_bookinguser DATAFILE 'tbs_bookinguser.dat' SIZE 10M AUTOEXTEND ON;

CREATE USER bookinguser IDENTIFIED BY bookinguser DEFAULT
TABLESPACE tbs_bookinguser QUOTA unlimited on tbs_bookinguser;

GRANT create session TO bookinguser;
GRANT create table TO bookinguser;
GRANT create sequence TO bookinguser;


drop table booking_record cascade constraints;

drop table inventory cascade constraints;
drop table passenger cascade constraints;
drop sequence booking_seq;
drop sequence inventory_seq;
drop sequence passenger_seq;

create sequence booking_seq start with 1 increment by 1;
create sequence inventory_seq start with 1 increment by 1;
create sequence passenger_seq start with 1 increment by 1;
create table booking_record (id number(19) primary key,
booking_date timestamp, destination varchar2(255), fare
varchar2(255), flight_date varchar2(255), flight_number
varchar2(255), origin varchar2(255), status varchar2(255));
create table inventory (id number(19) primary key, available
number(10) not null, flight_date varchar2(255), flight_number
varchar2(255));
create table passenger (id number(19) primary key, first_name
varchar2(255), gender varchar2(255), last_name varchar2(255),
booking_id number(19) references booking_record(id));


insert into inventory (flight_number, flight_date, available,id) values
('BF100', '22-JAN-16', 100, inventory_seq.nextVal);
insert into inventory (flight_number, flight_date, available,id) values
('BF101', '22-JAN-16', 100, inventory_seq.nextVal);
insert into inventory (flight_number, flight_date, available,id) values
('BF102', '22-JAN-16', 100, inventory_seq.nextVal);
insert into inventory (flight_number, flight_date, available,id) values
('BF103', '22-JAN-16', 100, inventory_seq.nextVal);
insert into inventory (flight_number, flight_date, available,id) values
('BF104', '22-JAN-16', 100, inventory_seq.nextVal);

insert into inventory (flight_number, flight_date, available, id) values
('BF105', '22-JAN-16', 100, inventory_seq.nextVal);
insert into inventory (flight_number, flight_date, available, id) values
('BF106', '22-JAN-16', 100, inventory_seq.nextVal);
commit;