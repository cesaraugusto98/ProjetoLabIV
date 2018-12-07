--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into CAT_CATEGORIA table

insert into CAT_CATEGORIA (CAT_NOME) VALUES('INFORMATICA');
insert into CAT_CATEGORIA (CAT_NOME) VALUES('GAMES');
insert into CAT_CATEGORIA (CAT_NOME) VALUES('CELULARES');

--rollback DELETE FROM CAT_CATEGORIA;