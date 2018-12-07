--liquibase formatted sql

--changeset kevin:201810202316
--comment: Criacao Todas as Tabelas

Create table END_ENDERECO(
	END_ID INT NOT NULL AUTO_INCREMENT,
    END_CEP VARCHAR(9),
    END_COMPLEMENTO VARCHAR(50),
    PRIMARY KEY (END_ID)
);


Create table FOR_FORNECEDOR(
	FOR_ID INT NOT NULL AUTO_INCREMENT,
	END_ID INT NOT NULL,
	FOR_CNPJ VARCHAR(20) NOT NULL,
	FOR_CONTATO VARCHAR(12) NOT NULL,
	FOR_NOME_FANTASIA VARCHAR(50) NOT NULL,
    PRIMARY KEY (FOR_ID),
	FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
);

CREATE TABLE CLI_CLIENTE(
	CLI_ID INT NOT NULL AUTO_INCREMENT,
    CLI_NOME VARCHAR(50) NOT NULL,
    CLI_CPF VARCHAR(20) NOT NULL,
    END_ID INT NOT NULL,
    CLI_CONTATO VARCHAR(20) NOT NULL,
    PRIMARY KEY(CLI_ID),
    FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
);

CREATE TABLE FUN_FUNCIONARIO(
	FUN_ID INT NOT NULL AUTO_INCREMENT,
    FUN_NOME VARCHAR(50) NOT NULL,
    FUN_CPF VARCHAR(20) NOT NULL,
    FUN_LOGIN VARCHAR(30) NOT NULL,
    FUN_SENHA VARCHAR(12) NOT NULL,
    END_ID INT NOT NULL,
    FUN_CONTATO VARCHAR(50) NOT NULL,
    FUN_SALARIO DECIMAL(12,2) NOT NULL,
    FUN_CARGO VARCHAR(40) NOT NULL,
    PRIMARY KEY(FUN_ID),
    FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
);	

CREATE TABLE EST_ESTOQUE(
	EST_ID INT NOT NULL AUTO_INCREMENT,
    EST_QTD INT NOT NULL,
    EST_LOCALIZACAO VARCHAR(100) NOT NULL,
    PRIMARY KEY (EST_ID)
);

CREATE TABLE PRO_PRODUTO(
	PRO_ID INT NOT NULL AUTO_INCREMENT,
    PRO_NOME VARCHAR(50) NOT NULL,
    PRO_PRECO DECIMAL(12,2) NOT NULL,
    PRO_CUSTO DECIMAL(12,2) NOT NULL,
    FOR_ID INT NOT NULL,
    CAT_ID INT NOT NULL,
    EST_ID INT NOT NULL,
    PRIMARY KEY (PRO_ID),
    FOREIGN KEY (CAT_ID) REFERENCES CAT_CATEGORIA(CAT_ID),
    FOREIGN KEY (EST_ID) REFERENCES EST_ESTOQUE(EST_ID)
); 

CREATE TABLE VEN_VENDA(
	VEN_ID INT AUTO_INCREMENT,
	CLI_ID INT NOT NULL,
    FPG_ID INT NOT NULL,
    PRIMARY KEY (VEN_ID),
    FOREIGN KEY(CLI_ID) REFERENCES CLI_CLIENTE(CLI_ID),
    FOREIGN KEY(FPG_ID) REFERENCES FPG_FORMA_PAGAMENTO(FPG_ID)
);

CREATE TABLE MET_MOVIMENTO_ENTRADA(
	MET_ID INT NOT NULL AUTO_INCREMENT,
	VEN_ID INT NOT NULL,
	MET_FATA DATETIME,
	MET_DESCRICAO VARCHAR(30),
	PRIMARY KEY (MET_ID),
	FOREIGN KEY (VEN_ID) REFERENCES VEN_VENDA(VEN_ID)
);

CREATE TABLE FPG_FORMA_PAGAMENTO(
	FPG_ID INT NOT NULL AUTO_INCREMENT,
	FPG_FORMA_PAGAMENTO VARCHAR(40),
	FPG_DESCONTO_PAGAMENTO DECIMAL(2,2),
    PRIMARY KEY (FPG_ID)
);

CREATE TABLE CAT_CATEGORIA(
	CAT_ID INT NOT NULL AUTO_INCREMENT,
    CAT_NOME VARCHAR(30),
    PRIMARY KEY(CAT_ID)
);

CREATE TABLE MES_MOVIMENTO_SAIDA(
	MES_ID INT NOT NULL AUTO_INCREMENT,
	FOR_ID INT NOT NULL,
	PRO_ID INT NOT NULL,
	MES_QTD INT DEFAULT 0,
	MES_DATA DATETIME NOT NULL,
	MES_DESCRICAO VARCHAR(30),
	PRIMARY KEY (MES_ID),
	FOREIGN KEY (FOR_ID) REFERENCES FOR_FORNECEDOR(FOR_ID),
	FOREIGN KEY (PRO_ID) REFERENCES PRO_PRODUTO(PRO_ID)
);

CREATE TABLE ITV_ITEM_VENDA(
	ITV_ID INT AUTO_INCREMENT,
    PRO_ID INT,
    QTD_PRO INT,
    VEN_ID INT,
    PRIMARY KEY (ITV_ID),
    
    FOREIGN KEY(VEN_ID) REFERENCES VEN_VENDA(VEN_ID),
    FOREIGN KEY(PRO_ID) REFERENCES PRO_PRODUTO(PRO_ID)
);



--rollback DROP TABLE END_ENDERECO;
--rollback DROP TABLE FOR_FORNECEDOR;
--rollback DROP TABLE CLI_CLIENTE;
--rollback DROP TABLE FUN_FUNCIONARIO;
--rollback DROP TABLE EST_ESTOQUE;
--rollback DROP TABLE VEN_VENDA;
--rollback DROP TABLE MET_MOVIMENTO_ENTRADA;
--rollback DROP TABLE FPG_FORMA_PAGAMENTO;
--rollback DROP TABLE CAT_CATEGORIA;
--rollback DROP TABLE MES_MOVIMENTO_SAIDA;
--rollback DROP TABLE PRO_PRODUTO;
--rollback DROP TABLE ITV_ITEM_VENDA;