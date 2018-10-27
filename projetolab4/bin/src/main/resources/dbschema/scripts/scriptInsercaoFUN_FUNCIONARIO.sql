--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into FUN_FUNCIONARIO table

INSERT INTO FUN_FUNCIONARIO (FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) 
VALUE('Anderson Gael Rodrigo Rocha','350.148.910-20','AndrGae','123456',3,'andersongaelrodrigorocha_@land.com.br',3500.00,'Gerente');

--rollback DELETE FROM FUN_FUNCIONARIO;