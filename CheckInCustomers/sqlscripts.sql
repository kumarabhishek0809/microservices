CREATE TABLESPACE tbs_checkinuser DATAFILE 'tbs_
checkinuser.dat' SIZE 10M AUTOEXTEND ON;

CREATE USER checkinuser IDENTIFIED BY checkinuser DEFAULT
TABLESPACE tbs_checkinuser QUOTA unlimited on tbs_checkinuser;

GRANT create session TO checkinuser;
GRANT create table TO checkinuser;
GRANT create sequence TO checkinuser;

drop table check_in_record cascade constraints;
drop sequence checkin_seq;
create sequence checkin_seq start with 1 increment by 1;
create table check_in_record (id number(19)primary key,
booking_id number(19) not null, check_in_time timestamp,
first_name varchar2(255), flight_date varchar2(255),
flight_number varchar2(255), last_name varchar2(255),
seat_number varchar2(255));