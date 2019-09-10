# AtividadeAvaliativa2

## Criar o arquivo `Dockerfile` do banco PostgreSQL
```
FROM postgres
ENV POSTGRES_DB segunda
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123

COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
```

## Criar o arquivo `Dockerfile` da aplicação
```
FROM payara/server-web
COPY target/dois.war $DEPLOY_DIR/dois.war
```

## criar o arquivo docker-compose.yml

version: "3"
services:
  postgres:
    container_name: db-atv2
    image: carlos/db-atv2
    build: ./postgres
    ports:
     - "5434:5432"
  web:
    container_name: app-atv2
    build: ./dois
    image: carlos/app-atv2
    depends_on: 
    - "postgres"
    ports:
     - "8082:8080"
     - 4848 
     - 8009 
     - 9009 
     - 8181 
     - 3700
    links:
     - "postgres:host-banco"


## executar a aplicação

docker-compose up --build

## Acessar a aplicação

*`http://localhost:8082/dois`: página principal com links para as outras páginas*  
*`http://localhost:8082/app/listpessoa`: listando as pessoas (usando JDBC)*  
*`http://localhost:8082/app/list`: listando os dependentes (usando JDBC)*  

