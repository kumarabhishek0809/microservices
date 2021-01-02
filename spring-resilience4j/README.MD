before starting this container below dependencies should be started. 
``-Eureka Discovery
``-Config-Server

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


docker build -t spring-resilience4j:latest .
docker run --name spring-resilience4j -d -p 127.0.0.1:8087:8087 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t spring-resilience4j 

http://127.0.0.1:7777/spring-resilience4j/default 

Docker Remote
docker build -t kumarabhishek0809/spring-resilience4j:latest .
docker push kumarabhishek0809/spring-resilience4j


http://localhost:7777/spring-resilience4j/default
http://localhost:8761/