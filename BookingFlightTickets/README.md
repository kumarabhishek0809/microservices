# BookingFlightTickets
BookingFlightTickets



docker run -i -p 127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD=root -d --name mysql mysql:5.7
docker exec -it 92fb9bb15fca mysql -uroot -proot


docker build -t booking-service:latest .
docker run -p 7777:7777 -t booking-service