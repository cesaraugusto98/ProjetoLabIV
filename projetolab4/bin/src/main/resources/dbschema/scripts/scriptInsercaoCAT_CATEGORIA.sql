--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into CAT_CATEGORIA table

insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES('INFORMATICA',1);
insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES('GAMES',2);
insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES('CELULARES',3);

--rollback DELETE FROM CAT_CATEGORIA;