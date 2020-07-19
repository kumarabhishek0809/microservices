docker build -t api-gateway:latest .
docker run --name api-gateway -d -p 127.0.0.1:7020:7020 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t api-gateway 

Docker Remote
docker build -t kumarabhishek0809/api-gateway:latest .
docker push kumarabhishek0809/api-gateway