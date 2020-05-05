# BookingFlightTickets
BookingFlightTickets



docker run -i -p 127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD=root -d --name mysql mysql:5.7
docker exec -it 92fb9bb15fca mysql -uroot -proot


docker build -t booking-service:latest .
docker run -p 7777:7777 -t booking-service


Zipkin : http://localhost:9411/zipkin/
Eureka : http://localhost:8761/


##rabbit mq
guest/guest
localhost:15672

docker network create rabbitmq-cluster
docker network ls
docker-compose -f docker-compose-rabbit-mq.yaml up -d