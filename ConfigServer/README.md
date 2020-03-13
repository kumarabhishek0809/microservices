# ConfigServer
ConfigServer

Properties can be checked http://localhost:7777/booking-service.properties
For JSON : http://localhost:7777/booking-service.json

docker build -t config-server:latest .
docker run -p 127.0.0.1:7777:7777 -t config-server