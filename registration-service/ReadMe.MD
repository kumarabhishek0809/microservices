docker build -t registration-service:latest .
docker run --name registration-service -d -p 127.0.0.1:8086:8086 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t registration-service 

http://127.0.0.1:7777/registration-service/default 

Docker Remote
docker build -t kumarabhishek0809/registration-service:latest .
docker push kumarabhishek0809/registration-service

docker-compose -f docker-compose-prometheus-grafana.yml up

docker pull prom/prometheus

##rabbit mq
guest/guest
localhost:15672

docker network create rabbitmq-cluster
docker network ls
docker-compose -f docker-compose-rabbit-mq.yaml up -d


docker run --name axonserver -p 8024:8024 -p 8124:8124 -v "/home/kumar/Downloads/AxonServer/AxonServer-4.5.4.1/config/data":/data -v "/home/kumar/Downloads/AxonServer/AxonServer-4.5.4.1/config/eventData":/eventData -v "/home/kumar/Downloads/AxonServer/AxonServer-4.5.4.1/config":/config axoniq/axonserver 