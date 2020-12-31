insert into fare(id, fare, flight_date, flight_number) values
(fare_seq.nextVal, '104', '22-JAN-16', 'BF104');
insert into fare(id, fare, flight_date, flight_number) values
(fare_seq.nextVal, '105', '22-JAN-16', 'BF105');
insert into fare values (fare_seq.nextVal, '106', '22-JAN-16',
'BF106');
commit;