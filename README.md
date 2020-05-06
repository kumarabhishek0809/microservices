# microservices
microservices/ConfigServer First Project To start.

#Eureka Server runs on 
Update Host file with multiple Peers.
sudo -i gedit /etc/hosts

http://eureka1:8761/
http://eureka2:8762/

#For Oracle DB.

check docker ps -a if oracle not present then pull otherwise run
docker pull store/oracle/database-enterprise:12.2.0.1
docker run --name oracleDB -p 5500:5500 -p 1521:1521 store/oracle/database-enterprise:12.2.0.1
docker start oracleDB


#For Booking Service We will Run Rabit MQ on Docker.
docker pull rabbitmq
docker run --name rabbitMQ -d -p 5672:5672 -p 15672:15672 rabbitmq

#For Load Balancer.

Change 1

