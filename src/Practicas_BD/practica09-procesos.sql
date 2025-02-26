---------1
CREATE TABLE Tipos_apli (
    id_tipo NUMBER(2)    CONSTRAINT tipos_apli_pk PRIMARY KEY,
    tipo VARCHAR2(25)    CONSTRAINT tipos_apli_uk1 UNIQUE
                                        CONSTRAINt tips_apli_nn1 NOT NULL
);

CREATE TABLE Aplicaciones(
    n_aplicacion NUMBER(4) CONSTRAINT aplicaciones_pk PRIMARY KEY,
    nombre VARCHAR2(50)    CONSTRAINT aplicaciones_uk1 UNIQUE
               CONSTRAINT aplicaciones_nn1 NOT NULL,
    extension CHAR(3),
    id_tipo NUMBER(2) CONSTRAINT aplicaciones_fk1 REFERENCES tipos_apli
                        ON DELETE CASCADE
);

CREATE TABLE Procesos(
    n_aplicacion NUMBER(4) CONSTRAINT procesos_fk1 REFERENCES Aplicaciones
                            ON DELETE CASCADE,
    id_proceso NUMBER(3),
    nombre VARCHAR2(20) CONSTRAINT procesos_uk1 UNIQUE
                            CONSTRAINT procesos_nn1 NOT NULL,
    mem_minima NUMBER(5,1) CONSTRAINT procesos_ck CHECK (mem_minima>0),
    n_aplicacion_lanz NUMBER(4), --He cambiado el orden de estas columnas para que no haya problema de concordancia
    id_proceso_lanz NUMBER(3),
    CONSTRAINT procesos_pk PRIMARY KEY(n_aplicacion,id_proceso),
    CONSTRAINT procesos_fk2 FOREIGN KEY (n_aplicacion, id_proceso)
    REFERENCES procesos ON DELETE SET NULL
);



CREATE TABLE maquinas(
    n_maquina   NUMBER(3) CONSTRAINT maquinas_pk PRIMARY KEY,
    ip1 NUMBER(3) CONSTRAINT maquinas_nn1 NOT NULL
            CONSTRAINT  maquinas_ck1 CHECK(ip1>=0 AND ip1<=255),
    ip2 NUMBER(3) CONSTRAINT maquinas_nn2 NOT NULL
            CONSTRAINT  maquinas_ck2 CHECK(ip2>=0 AND ip2<=255),
    ip3 NUMBER(3) CONSTRAINT maquinas_nn3 NOT NULL
            CONSTRAINT  maquinas_ck3 CHECK(ip3>=0 AND ip3<=255),
    ip4 NUMBER(3) CONSTRAINT maquinas_nn4 NOT NULL
            CONSTRAINT  maquinas_ck4 CHECK(ip4>=0 AND ip4<=255),
    nombre VARCHAR2(45) CONSTRAINT maquinas_uk2 UNIQUE
                        CONSTRAINt maquinas_nn5 NOT NULL,
    memoria NUMBER(5,1),
    CONSTRAINT maquinas_uk1 UNIQUE(ip1,ip2,ip3,ip4)
);

CREATE TABLE procesos_lanzados(
    n_aplicacion NUMBER(4),
    id_proceso NUMBER(3),
    fecha_lanz TIMESTAMP,
    fecha_termino TIMESTAMP,
    bloqueado NUMBER(1) CONSTRAINT procesos_lanzados_ck1 CHECK(bloqueado IN (0,1)),
    n_maquina NUMBER(3) CONSTRAINT procesos_lanzados_fk2
            REFERENCES maquinas ON DELETE CASCADE,
    CONSTRAINT procesos_lanzados_pk PRIMARY KEY(n_aplicacion,id_proceso,fecha_lanz),
    CONSTRAINT procesos_lanzados_fk1 FOREIGN KEY (n_aplicacion, id_proceso)
                        REFERENCES procesos ON DELETE CASCADE
);


----------------------2
ALTER TABLE maquinas ADD(
                hd NUMBER(5,2),
                tipo CHAR(1) CONSTRAINT maquinas_ck5 CHECK(tipo in ('C','S'))
    );

-------------------------3
ALTER TABLE procesos_lanzados DROP CONSTRAINT procesos_lanzados_pk;
ALTER TABLE procesos_lanzados ADD(id_proceso_lanz NUMBER(12) CONSTRAINT procesos_lanzados_pk PRIMARY KEY );

-------------------------4
INSERT INTO Tipos_Apli(id_tipo, tipo)
    VALUES(1,'Procesador Texto');
INSERT INTO Aplicaciones(n_aplicacion, nombre, extension, id_tipo)
    VALUES(1,'Multiword','mut',1);

INSERT INTO Procesos VALUES(1,1,'WRD',250,null,null);
INSERT INTO Procesos VALUES(1,2,'WRHELP',250,1,1);

INSERT INTO Maquinas VALUES(1,212,34,56,7,'ELECTRO',512,250,'S');
INSERT INTO Maquinas VALUES(2,212,34,56,27,'MAGNUS',356,128,'C');
INSERT INTO Maquinas VALUES(3,97,23,45,6,'GREGOR',1024,512,'S');

INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                              VALUES(1,1,1,TO_DATE('17/12/2023','dd/mm/yyyy'),TO_DATE('19/12/2023','dd/mm/yyyy'),0,3);
INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                             VALUES(2,1,1,TO_DATE('18/12/2023','dd/mm/yyyy'),TO_DATE('19/12/2023','dd/mm/yyyy'),0,1);
INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                             VALUES(3,1,1,TO_DATE('18/12/2023','dd/mm/yyyy'),TO_DATE('20/12/2023','dd/mm/yyyy'),1,1);
INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                             VALUES(4,1,1,TO_DATE('19/12/2023','dd/mm/yyyy'),null,0,2);
INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                            VALUES(5,1,2,TO_DATE('19/12/2023','dd/mm/yyyy'),TO_DATE('22/12/2023'),1,1);
INSERT INTO Procesos_Lanzados(id_proceso_lanz, n_aplicacion, id_proceso, fecha_lanz, fecha_termino, bloqueado, n_maquina)
                            VALUES(6,1,2,TO_DATE('20/12/2023','dd/mm/yyyy'),null,1,2);

-------------------------5
COMMIT;

-----------------------6
UPDATE MAQUINAS SET ip2=37 WHERE ip1=212 AND ip2=34;


----------------------7
DELETE FROM procesos_lanzados
WHERE  fecha_lanz>=to_date('17/12/2023','dd/mm/yyyy') AND
              fecha_lanz<=to_date('18/12/2023','dd/mm/yyyy') AND
              bloqueado=1;
----------------------8
ROLLBACK;
UPDATE procesos_lanzados SET bloqueado=0
WHERE id_proceso=2 AND FECHA_LANZ='20/12/2023';

-----------------------9
-- Para hacer ese cambio, necesitamos primero modificar los procesos de esa máquina
-- Una idea posible es indicar NULL en la columna de la máquina de los procesos lanzados
UPDATE procesos_lanzados SET n_maquina=NULL WHERE n_maquina=3;
--Ahora modificamos el número de GREGOR
UPDATE maquinas SET N_MAQUINA=4 WHERE N_MAQUINA=3;
--Finalmente modificamos sus procesos lanzados
UPDATE procesos_lanzados SET n_maquina=4 WHERE n_maquina IS NULL;

--------------------10
UPDATE maquinas SET memoria = memoria * 2 WHERE tipo = 'S';



