-- Criação da Tabela locadora V1
CREATE TABLE locadora(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR (100),
    nome VARCHAR (100),
    marca VARCHAR (100),
    placa VARCHAR (100) NOT NULL UNIQUE,
    cambio VARCHAR (100),
    valor DECIMAL (10,2),
    dataretirada DATETIME,
    ativo TINYINT
);