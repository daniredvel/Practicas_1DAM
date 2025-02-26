CREATE USER Gestor IDENTIFIED  BY 'A12345a';

GRANT ALL ON Usuarios.* TO Gestor;

CREATE DATABASE USUARIOS;

CREATE TABLE USUARIOS(
    id_usuario INT AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL ,
    email VARCHAR(60) NOT NULL ,
    pass VARCHAR(100) NOT NULL ,
    CONSTRAINT usuarios_pk PRIMARY KEY (id_usuario),
    CONSTRAINT usuarios_uk UNIQUE (nombre),
    CONSTRAINT usuarios_uk_1 UNIQUE (email)
);