--liquibase formatted sql

--changeset kevin:201810202316
--comment: Criacao Todas as Tabelas

CREATE USER 'Ecommerce'@'localhost' IDENTIFIED BY 'fatec';

GRANT ALL PRIVILEGES ON ecommerce.*  TO 'Ecommerce'@'localhost';

CREATE DATABASE lab04db;

CREATE SCHEMA lab04db;

--rollback DROP SCHEMA lab04db;
--rollback DROP USER 'Ecommerce'@'localhost'
--rollback DROP DATABASE lab04db
