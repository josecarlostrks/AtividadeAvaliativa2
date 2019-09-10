CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE pessoa(
    id serial,
    nome varchar (40), 
    cpf varchar (40) UNIQUE,
    id_dependente,
    PRIMARY KEY (id)
    FOREIGN KEY (id_dependente) REFERENCES dependente (id);
);

CREATE TABLE dependente(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    nome varchar (40), 
    nascimento date,
    PRIMARY KEY (id)
);
