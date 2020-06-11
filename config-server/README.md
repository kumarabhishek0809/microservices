# ConfigServer
ConfigServer

Properties can be checked http://localhost:7777/booking-service.properties
For JSON : http://localhost:7777/booking-service.json


gradle wrapper

docker build -t config-server:latest .
docker run --name config-server -d -p 127.0.0.1:7777:7777 -m 1G -t config-server 
http://127.0.0.1:7777/spring-reactive/default


Docker Remote
docker build -t kumarabhishek0809/config-server:latest .
docker push kumarabhishek0809/config-server 