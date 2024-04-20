CREATE DATABASE assistencia_tecnica WITH ENCODING='UTF8';



CREATE TABLE ufs(
    id                      SERIAL PRIMARY KEY,    
    descricao               VARCHAR(255) NOT NULL,
    codigo                  INT NOT NULL
);

CREATE TABLE cidades(
    id                      SERIAL PRIMARY KEY,
    descricao               VARCHAR(255) NOT NULL,
    codigo                  INT NOT NULL,
    id_uf                   INT REFERENCES ufs(id)
);

CREATE TABLE enderecos(
    id                      SERIAL PRIMARY KEY,
    rua                     VARCHAR(255) NOT NULL,
    numero                  VARCHAR(25),
    bairro                  VARCHAR(255) NOT NULL,
    cep                     VARCHAR(20) NOT NULL,
    id_cidade               INT REFERENCES cidades(id)
);

CREATE TABLE empresas(
    id                      SERIAL PRIMARY KEY,
    nome_fantasia           VARCHAR(255) NOT NULL,
    cnpj                    VARCHAR(14) NOT NULL UNIQUE,
    logo                    BYTEA,
    slogan                  VARCHAR(255),
    id_endereco             INT REFERENCES enderecos(id)
);

CREATE TABLE clientes(
    id                      SERIAL PRIMARY KEY,
    nome                    VARCHAR(255) NOT NULL,
    cpf                     VARCHAR(11) NOT NULL UNIQUE,
    data_nascimento         DATE,
    email                   VARCHAR(100),
    id_endereco             INT REFERENCES enderecos(id)
);

CREATE TABLE ordens_servico(
    id                      SERIAL PRIMARY KEY,
    observacao              VARCHAR(255),
    data_abertura           TIMESTAMP NOT NULL, 
    data_saida              TIMESTAMP,
    username_responsavel    VARCHAR(100) NOT NULL,
    id_cliente              INT NOT NULL REFERENCES clientes(id),
    id_empresa              INT NOT NULL REFERENCES empresas(id)
);

CREATE TABLE itens_ordem_servico(
    id                      SERIAL PRIMARY KEY,
    descricao               VARCHAR(255) NOT NULL,
    preco                   BIGINT NOT NULL,
    id_ordem_servico        INT NOT NULL REFERENCES ordens_servico(id)
);
