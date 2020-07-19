# ConfigServer
ConfigServer

Properties can be checked http://127.0.0.1:7777/booking-service.properties
For JSON : http://127.0.0.1:7777/booking-service.json


gradle wrapper

docker build -t config-server:latest .
docker run --name config-server -d -p 127.0.0.1:7777:7777 -m 1G -t config-server 

to Test : http://127.0.0.1:7777/registration-service/default


Docker Remote
docker build -t kumarabhishek0809/config-server:latest .
docker push kumarabhishek0809/config-server 

docker run kumarabhishek0809/config-server 