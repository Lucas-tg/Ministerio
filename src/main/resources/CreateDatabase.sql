DROP TABLE pessoa CASCADE;
DROP TABLE ministro CASCADE;
DROP TABLE ministerio CASCADE;
DROP TABLE secretaria CASCADE;

-- CRIACAO DAS TABELAS
CREATE TABLE pessoa (
                        id_pessoa INTEGER NOT NULL AUTO_INCREMENT,
                        nome_pessoa VARCHAR2(50),
                        rg VARCHAR2(20),
                        cpf VARCHAR2(20)

);


CREATE TABLE ministro (
                            id_partido INTEGER NOT NULL AUTO_INCREMENT,
                            partido VARCHAR2(20)


);


CREATE TABLE ministerio (
                            id_ministerio INTEGER NOT NULL AUTO_INCREMENT,
                            nome_ministerio VARCHAR2(20),
                            totalCargosConfianca_ministerio INTEGER NOT NULL,
                            totalFuncionarios_ministerio INTEGER NOT NULL,
                            orcamento_ministerio DOUBLE NOT NULL
);

CREATE TABLE secretaria (
                            id_secretaria INTEGER NOT NULL AUTO_INCREMENT,
                            nome_secretaria VARCHAR2(20),
                            totalCargosConfianca_secretaria INTEGER NOT NULL,
                            totalFuncionarios_secretaria INTEGER NOT NULL,
                            orcamento_secretaria DOUBLE NOT NULL
);

-- RESTRICOES

-- PK
ALTER TABLE pessoa
    ADD CONSTRAINT pessoa_pk PRIMARY KEY (id_pessoa);

ALTER TABLE ministro
    ADD CONSTRAINT ministro_pk PRIMARY KEY (id_partido);

ALTER TABLE ministerio
    ADD CONSTRAINT ministerio_pk PRIMARY KEY (id_ministerio);

ALTER TABLE secretaria
    ADD CONSTRAINT secretaria_pk PRIMARY KEY (id_secretaria);

-- FK
-- Nao possui no momento

-- INSERINDO DADOS NAS TABELAS

-- ministerio
INSERT INTO ministerio(id_ministerio, nome_ministerio, totalCargosConfianca_ministerio,
                                totalFuncionarios_ministerio, orcamento_ministerio)
VALUES
(1, 'saude', 3, 30, 3000000.00),
(2, 'educao', 4, 40, 4000000.00),
(3, 'esporte', 5, 50, 5000000.00);

-- secretaria
INSERT INTO secretaria(id_secretaria, nome_secretaria, totalCargosConfianca_secretaria,
                                totalFuncionarios_secretaria, orcamento_secretaria)
VALUES
(1, 'trabalho', 6, 60, 7000000.00),
(2, 'saneamento', 7, 70, 7000000.00),
(3, 'habitacao', 8, 80, 8000000.00);
