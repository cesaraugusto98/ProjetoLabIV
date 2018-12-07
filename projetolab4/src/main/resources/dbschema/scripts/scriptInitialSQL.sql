CREATE USER 'Ecommerce'@'localhost' IDENTIFIED BY 'fatec';
DROP if exists USER 'Ecommerce'@'localhost';

GRANT ALL PRIVILEGES ON ecommerce.*  TO 'Ecommerce'@'localhost';

DROP if exists DATABASE lab04db;

CREATE DATABASE lab04db;

DROP if exists SCHEMA lab04db;

CREATE SCHEMA lab04db;

USE lab04db;