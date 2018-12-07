--liquibase formatted sql

--changeset kevin:201810211827
--comment:Insert registers into END_ENDERECO table

insert into END_ENDERECO (END_CEP,END_COMPLEMENTO) VALUES('12235330','CASA');
insert into END_ENDERECO (END_CEP,END_COMPLEMENTO) VALUES('01023-902','EDIFICIO');
insert into END_ENDERECO (END_CEP,END_COMPLEMENTO) VALUES('69315-332','CASA');


--rollback DELETE FROM END_ENDERECO;