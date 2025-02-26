CREATE TABLE Trabajadores (
    cod_trabajador NUMBER(3) CONSTRAINT trabajadores_pk PRIMARY KEY,
    nombre VARCHAR2(25)      CONSTRAINT trabajadores_nn1 NOT NULL,
    fecha_nac DATE
);
--Crea una tabla con cada columna separada por una coma, con sus tipos de datos y restricciones antes de la coma

SELECT * FROM USER_TABLES;
--Muestra las tablas del usuario

SELECT * FROM USER_CONSTRAINTS;
--Muestra las restricciones del usuario

CREATE TABLE Proyectos (
    ID_PROYECTO NUMBER(6)   CONSTRAINT Proyectos_pk PRIMARY KEY,
    NOMBRE VARCHAR2(30)     CONSTRAINT Nombre_uk1 UNIQUE CONSTRAINT nombre_nn1 NOT NULL,
    TIEMPO_PREY INTERVAL DAY TO SECOND
);
--Columna con dos restricciones, cada restriccion tiene que ir precedida por un CONSTRAINT

CREATE TABLE Intervenir (
    ID_PROYECTO     NUMBER(6) CONSTRAINT intervenir_fk1 REFERENCES Proyectos(ID_PROYECTO),
    COD_TRABAJADOR  NUMBER(3)CONSTRAINT intervenir_fk2 REFERENCES Trabajadores(COD_TRABAJADOR),
    TIEMPO          INTERVAL DAY TO SECOND,
    CONSTRAINT intervenir_pk primary key (ID_PROYECTO, COD_TRABAJADOR)
);
--Para poner restricciones iguales a varias columnas se escibe al final marcandolo con un parentesis separado por comas
--Para hacer un FK se usa REFERENCES para saber a que tabla y columna hace referencia

CREATE TABLE  Medios_Usados(
    id_medio        NUMBER(9)       CONSTRAINT Medios_Usados_pk PRIMARY KEY,
    id_proyecto     NUMBER(6)       CONSTRAINT Medios_Usados_nn1 NOT NULL,
    cod_trabajador  NUMBER(3)       CONSTRAINT medios_usados_nn2 NOT NULL,
    descripcion     VARCHAR2(100)   CONSTRAINT medios_usados_nn3 NOT NULL,
    CONSTRAINT medios_usados_fk1    FOREIGN KEY (id_proyecto, cod_trabajador)
                                    REFERENCES INTERVENIR(id_proyecto, cod_trabajador)
                                    ON DELETE CASCADE
);
--FK de varias columnas y politica ON DELETE CASCADE