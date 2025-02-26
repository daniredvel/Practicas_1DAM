CREATE TABLE  PERSONAS (
    id_persona NUMBER(3)    CONSTRAINT personas_pk PRIMARY KEY,
    nombre VARCHAR2(30)     CONSTRAINT personas_nn NOT NULL
);

--Cambia el nombre de una tabla
RENAME PERSONAS TO CLIENTES;

--Cambia una columna
ALTER TABLE CLIENTES RENAME COLUMN id_persona TO id_cliente;

--Cambia el nombre de una restricción
ALTER TABLE CLIENTES RENAME CONSTRAINT personas_pk TO clientes_pk;

--Cambia el nombre de una restricción
ALTER TABLE CLIENTES RENAME CONSTRAINT personas_nn TO clientes_nn1;

--Añadir una columna, los parentesis significan una lista de columnas

ALTER TABLE CLIENTES ADD(
    apellido_1 VARCHAR2(30) CONSTRAINT clientes_nn2 NOT NULL,
    apellido_2 VARCHAR2(30)
    );

--Eliminar una columna, NO es revocable
ALTER TABLE CLIENTES DROP(APELLIDO_2);

--Usada normalmente para modificar el tipo de datos
ALTER TABLE CLIENTES MODIFY(apellido_1 VARCHAR2(40));

--Introducir datos
INSERT INTO CLIENTES VALUES (1, 'Ana', 'Urruticoechea','1');
INSERT INTO CLIENTES VALUES (2, 'Gonzalo', 'Andrés','2');
INSERT INTO CLIENTES VALUES (3, 'Martín', 'López','3');

--Confirma la transacción
COMMIT;

--Borra la fila donde encuentra esa coincidencia
DELETE FROM CLIENTES WHERE nombre='Ana';

ALTER TABLE CLIENTES ADD (
    NIF char(9) CONSTRAINT  clientes_nn3 NOT NULL
                CONSTRAINT  clientes_uk UNIQUE
    );

--Valor por defecto
ALTER TABLE CLIENTES ADD(
    genro CHAR(1) DEFAULT 'H'
    );

--Tablas
SELECT * FROM USER_TABLES;
--Restricciones
SELECT * FROM USER_CONSTRAINTS;
--Columnas de las restricciones
SELECT * FROM USER_CONS_COLUMNS;
--Tabla CLIENTES
SELECT * FROM CLIENTES;