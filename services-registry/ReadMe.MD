Local
docker build -t services-registry:latest .
docker run services-registry -d -p 127.0.0.1:8761:8761 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t services-registry 



Test
http://localhost:8761/


Docker Remote
gradle wrapper
docker build -t kumarabhishek0809/services-registry:latest .
docker push kumarabhishek0809/services-registry