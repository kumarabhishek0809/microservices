# BookingFlightTickets
BookingFlightTickets

Docker Oracle Start

check docker ps -a if oracle not present then pull otherwise run
docker pull sath89/oracle-12c
docker run --name oracleDB -p 5500:5500 -p 1521:1521 sath89/oracle-12c
docker start oracleDB

