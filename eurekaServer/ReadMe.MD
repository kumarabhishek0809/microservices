docker build -t services-registry .
docker run -p 127.0.0.1:8761:8761 -t services-registry