
Swagger
http://localhost:8085/swagger-ui.html#/

Actuator Health
http://localhost:8085/actuator/health

http://localhost:8085/actuator
http://localhost:8085/actuator/prometheus

Prometheus URL
http://localhost:9090/graph

Garfana Board
http://localhost:3000/login


docker build -t spring-reactive:latest .
docker run --name spring-reactive -d -p 127.0.0.1:8085:8085 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t spring-reactive 

http://127.0.0.1:7777/spring-reactive/default 

Docker Remote
docker build -t kumarabhishek0809/spring-reactive:latest .
docker push kumarabhishek0809/spring-reactive


http://localhost:7777/spring-reactive/default
http://localhost:8761/



EndPoints.
http://localhost:8085/v1/items
http://localhost:8085/fluxstream
http://localhost:8085/flux