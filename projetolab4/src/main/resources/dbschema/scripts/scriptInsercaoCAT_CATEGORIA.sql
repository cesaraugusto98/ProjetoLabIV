--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into CAT_CATEGORIA table

insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES(1,'INFORMATICA');
insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES(2,'GAMES');
insert into CAT_CATEGORIA (CAT_ID,CAT_NOME) VALUES(3, 'CELULARES');

--rollback DELETE FROM CAT_CATEGORIA;