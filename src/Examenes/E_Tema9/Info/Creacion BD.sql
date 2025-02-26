CREATE DATABASE EXAMEN_PENSAMIENTOS;
USE EXAMEN_PENSAMIENTOS;
CREATE USER ADMIN_PENSAMIENTOS IDENTIFIED BY 'A12345a';
GRANT SELECT,INSERT,DELETE ON * TO ADMIN_PENSAMIENTOS;


CREATE TABLE USUARIOS(
                         nombre VARCHAR(100) NOT NULL ,
                         PRIMARY KEY usuaarios_pk (nombre),
                         CONSTRAINT usuarios_uk1 UNIQUE (nombre)
);

CREATE TABLE PENSAMIENTOS(
                             nombre VARCHAR(100) NOT NULL,
                             cod_pensamiento INT NOT NULL,
                             pensamiento VARCHAR(200) NOT NULL,
                             fecha DATETIME NOT NULL,
                             PRIMARY KEY pensmientos_pk (cod_pensamiento),
                             FOREIGN KEY pensamientos_fk1 (nombre) REFERENCES USUARIOS(nombre)
);
