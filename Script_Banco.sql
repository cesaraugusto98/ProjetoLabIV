DROP DATABASE lab04db;

CREATE DATABASE lab04db;

DROP SCHEMA lab04db;

CREATE SCHEMA lab04db;

DROP USER 'Ecommerce'@'localhost';

CREATE USER 'Ecommerce'@'localhost' IDENTIFIED BY 'fatec';

GRANT ALL PRIVILEGES ON ecommerce.*  TO 'Ecommerce'@'localhost';

USE lab04db;

Create table END_ENDERECO(
	END_ID INT NOT NULL AUTO_INCREMENT,
    END_CEP VARCHAR(8),
    END_COMPLEMENTO VARCHAR(50),
    PRIMARY KEY (END_ID)
);

CREATE TABLE CLI_CLIENTE(
	CLI_ID INT NOT NULL AUTO_INCREMENT,
    CLI_NOME VARCHAR(50) NOT NULL,
    CLI_CPF VARCHAR(20) NOT NULL,
    END_ID INT NOT NULL,
    CLI_CONTATO VARCHAR(12) NOT NULL,
    PRIMARY KEY(CLI_ID),
    FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
);

CREATE TABLE CAT_CATEGORIA(
	CAT_ID INT NOT NULL AUTO_INCREMENT,
    CAT_NOME VARCHAR(30),
    PRIMARY KEY(CAT_ID)
);

CREATE TABLE EST_ESTOQUE(
	EST_ID INT NOT NULL AUTO_INCREMENT,
    EST_QTD INT NOT NULL,
    EST_LOCALIZACAO VARCHAR(100),
	PRIMARY KEY(EST_ID)
);

CREATE TABLE FOR_FORNECEDOR(
	FOR_ID INT NOT NULL AUTO_INCREMENT,
    END_ID INT NOT NULL,
    FOR_CNPJ VARCHAR(16) NOT NULL,
    FOR_CONTATO VARCHAR(12) NOT NULL,
    FOR_NOME_FANTASIA VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(FOR_ID),
    FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
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
    FOREIGN KEY (FOR_ID) REFERENCES FOR_FORNECEDOR(FOR_ID),
    FOREIGN KEY (CAT_ID) REFERENCES CAT_CATEGORIA(CAT_ID),
	FOREIGN KEY (EST_ID) REFERENCES EST_ESTOQUE(EST_ID)
);

CREATE TABLE FPG_FORMA_PAGAMENTO(
	FPG_ID INT AUTO_INCREMENT,
    FPG_FORMA_PAGAMENTO VARCHAR(40) NOT NULL,
    FPG_DESCONTO_PAGAMENTO DECIMAL(2,2),
    PRIMARY KEY(FPG_ID)
);

CREATE TABLE FUN_FUNCIONARIO(
	FUN_ID INT NOT NULL AUTO_INCREMENT,
    FUN_NOME VARCHAR(50) NOT NULL,
    FUN_CPF VARCHAR(20) NOT NULL,
    FUN_LOGIN VARCHAR(30) NOT NULL,
    FUN_SENHA VARCHAR(12) NOT NULL,
    END_ID INT NOT NULL,
    FUN_CONTATO VARCHAR(12) NOT NULL,
    FUN_SALARIO DECIMAL(12,2) NOT NULL,
    FUN_CARGO VARCHAR(40) NOT NULL,
    
    PRIMARY KEY(FUN_ID),
    FOREIGN KEY (END_ID) REFERENCES END_ENDERECO(END_ID)
);

CREATE TABLE VEN_VENDA(
	VEN_ID INT AUTO_INCREMENT,
    CLI_ID INT,
    FPG_ID INT NOT NULL,
    FUN_ID INT NOT NULL,
    VEN_DATA DATETIME NOT NULL,
    PRIMARY KEY (VEN_ID),
	
    FOREIGN KEY(CLI_ID) REFERENCES CLI_CLIENTE(CLI_ID),
    FOREIGN KEY(FUN_ID) REFERENCES FUN_FUNCIONARIO(FUN_ID),
    FOREIGN KEY(FPG_ID) REFERENCES FPG_FORMA_PAGAMENTO(FPG_ID)
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

CREATE TABLE MES_MOVIMENTO_SAIDA(
	MES_ID INT AUTO_INCREMENT,
    VEN_ID INT NOT NULL,
    MES_DATA DATETIME NOT NULL,
    MES_DESCRICAO VARCHAR(30) NOT NULL,
    
    PRIMARY KEY (MES_ID),
    FOREIGN KEY (VEN_ID) REFERENCES VEN_VENDA(VEN_ID)
);

CREATE TABLE MET_MOVIMENTO_ENTRADA(
	MET_ID INT AUTO_INCREMENT,
    FOR_ID INT NOT NULL,
    PRO_ID INT NOT NULL,
    MET_QTD INT NOT NULL,
    MET_DATA DATETIME NOT NULL,
    MET_DESCRICAO VARCHAR(30) NOT NULL,
    
    PRIMARY KEY (MET_ID),
    FOREIGN KEY (FOR_ID) REFERENCES FOR_FORNECEDOR(FOR_ID),
    FOREIGN KEY (PRO_ID) REFERENCES PRO_PRODUTO(PRO_ID)
);