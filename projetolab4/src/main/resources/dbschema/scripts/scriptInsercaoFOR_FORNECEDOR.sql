--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into FOR_FORNECEDOR table

INSERT INTO FOR_FORNECEDOR (FOR_ID,END_ID,FOR_CNPJ,FOR_CONTATO,FOR_NOME_FANTASIA) VALUES(121,1,'35.572.611/0001-99','(11)39316564','ENTREGA_LOGO');
INSERT INTO FOR_FORNECEDOR (FOR_ID,END_ID,FOR_CNPJ,FOR_CONTATO,FOR_NOME_FANTASIA) VALUES(122,2,'71.184.566/0001-69','(11)39314698','TUDO_ORIGINAL');
INSERT INTO FOR_FORNECEDOR (FOR_ID,END_ID,FOR_CNPJ,FOR_CONTATO,FOR_NOME_FANTASIA) VALUES(123,3,'86.697.901/0001-08','(11)39314478','SEM_TAXA');
INSERT INTO FOR_FORNECEDOR (FOR_ID,END_ID,FOR_CNPJ,FOR_CONTATO,FOR_NOME_FANTASIA) VALUES(124,4,'86.697.901/0001-08','(12)39314478','SEM_TAXA');
INSERT INTO FOR_FORNECEDOR (FOR_ID,END_ID,FOR_CNPJ,FOR_CONTATO,FOR_NOME_FANTASIA) VALUES(125,5,'94.697.901/0341-08','(12)397433756','TUDO_ORIGINAL');



--rollback DELETE FROM FOR_FORNECEDOR;