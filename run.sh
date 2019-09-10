# manualmente
#docker build -t carlos/bd ./postgres
#docker run -p 5433:5432 --name bd -d carlos/bd 
#cd app && mvn clean package && cd ..
#docker build -t carlos/app ./app
#docker run -p 8082:8080 --name app --link bd:host-banco carlos/app
#docker-compose
docker-compose up --build
