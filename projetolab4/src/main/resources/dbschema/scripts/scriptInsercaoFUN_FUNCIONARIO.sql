--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into FUN_FUNCIONARIO table

INSERT INTO FUN_FUNCIONARIO (FUN_ID,FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) VALUE(131,'ANDERSON ROCHA','350.148.910-20','AndrGae','123456',11,'andersongaelrodrigorocha@land.com.br',3500.00,'GERENTE');
INSERT INTO FUN_FUNCIONARIO (FUN_ID,FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) VALUE(132,'JEAN RODRIGO','350.148.910-20','JeRod','654123',12,'rodrigoJean0512@.com',1600.00,'VENDEDOR');
INSERT INTO FUN_FUNCIONARIO (FUN_ID,FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) VALUE(133,'CARLOS SOUZA','350.148.910-20','SouzaCarlos','014789',13,'carlao01512@land.com.br',1700.00,'CAIXA');
INSERT INTO FUN_FUNCIONARIO (FUN_ID,FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) VALUE(134,'MARIA RITA','350.148.910-20','MaRitinha','456789',14,'ritaMia@land.com',1500.00,'VENDEDOR');
INSERT INTO FUN_FUNCIONARIO (FUN_ID,FUN_NOME,FUN_CPF,FUN_LOGIN,FUN_SENHA,END_ID,FUN_CONTATO,FUN_SALARIO,FUN_CARGO) VALUE(135,'JULIA MOREIRA','350.148.910-20','JuJu','124563',15,'jujumoreira2412@land.com.br',1600.00,'CAIXA');

--rollback DELETE FROM FUN_FUNCIONARIO;