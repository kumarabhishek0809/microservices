docker build -t oauth-server:latest .
docker run --name oauth-server -d -p 127.0.0.1:8085:8085 -m 1G --env CONFIG_SERVER_URI=http://config-server:7777 -t oauth-server 

http://127.0.0.1:7777/oauth-server/default 

Docker Remote
docker build -t kumarabhishek0809/oauth-server:latest .
docker push kumarabhishek0809/oauth-server
