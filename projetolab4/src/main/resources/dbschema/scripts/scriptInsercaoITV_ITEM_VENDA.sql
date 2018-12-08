--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into VEN_VENDA table

INSERT INTO ITV_ITEM_VENDA (ITV_ID INT,PRO_ID,QTD_PRO,VEN_ID) VALUES(1,1,2,451);

--rollback DELETE FROM VEN_VENDA;