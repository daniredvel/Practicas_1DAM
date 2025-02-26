CREATE DATABASE reservas;

CREATE USER reservas@localhost IDENTIFIED BY 'A12345a';

GRANT ALL ON reservas.* TO reservas@localhost;

USE reservas;

CREATE TABLE departamentos(
                              cod_departamento CHAR(3),
                              nombre VARCHAR(30) NOT NULL,
                              CONSTRAINT departamentos_uk1 UNIQUE (nombre),
                              CONSTRAINT departamerntos_pk PRIMARY KEY (cod_departamento)
);

CREATE TABLE salas(
      cod_sala CHAR(3),
      nombre VARCHAR(30) NOT NULL,
      CONSTRAINT salas_uk1 UNIQUE (cod_sala),
      CONSTRAINT salas_pk PRIMARY KEY (cod_sala)
);

CREATE TABLE reservas(
     cod_sala CHAR(3),
     cod_departamento char(3),
     fecha_inicio DATETIME,
     fecha_fin DATETIME,
     CONSTRAINT reservas_pk PRIMARY KEY (cod_sala, fecha_inicio),
     CONSTRAINT reservas_fk1 FOREIGN KEY (cod_sala) REFERENCES salas(cod_sala)
         ON DELETE CASCADE,
     CONSTRAINT reservas_fk2 FOREIGN KEY (cod_departamento) REFERENCES departamentos(cod_departamento)
         ON DELETE CASCADE,
    CONSTRAINT reservas_ck1 CHECK (fecha_inicio < fecha_fin)
);



INSERT INTO departamentos VALUES('VEN','dsadsadsa');

select * from reservas;