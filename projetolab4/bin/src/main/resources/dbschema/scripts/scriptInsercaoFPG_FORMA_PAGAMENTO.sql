--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into FPG_FORMA_PAGAMENTO table

INSERT INTO FPG_FORMA_PAGAMENTO VALUES(1,'DINHEIRO',0);
INSERT INTO FPG_FORMA_PAGAMENTO VALUES(2,'CHEQUE',0);
INSERT INTO FPG_FORMA_PAGAMENTO VALUES(3,'CARTAO DE DEBITO',0);
INSERT INTO FPG_FORMA_PAGAMENTO VALUES(4,'CARTAO DE CREDITO',0);

--rollback DELETE FROM FPG_FORMA_PAGAMENTO;