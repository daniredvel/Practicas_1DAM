CREATE TABLE tipos_apli(
    id_tipo             NUMBER(2)       CONSTRAINT tipos_apli_pk        PRIMARY KEY,
    tipo                VARCHAR2(25)    CONSTRAINT tipos_apli_uk1       UNIQUE CONSTRAINT   tipos_apli_nn1              NOT NULL
);
CREATE TABLE aplicaciones(
    n_aplicacion        NUMBER(4)       CONSTRAINT aplicaciones_pk      PRIMARY KEY,
    nombre              VARCHAR2(25)    CONSTRAINT aplicaciones_uk1     UNIQUE CONSTRAINT   aplicaciones_nn1            NOT NULL,
    extension           VARCHAR2(5),
    id_tipo             VARCHAR2(25)    CONSTRAINT aplicaciones_fk1     REFERENCES          tipos_apli(id_tipo)         ON DELETE CASCADE
                                        CONSTRAINT aplicaciones_nn2     NOT NULL
);
CREATE TABLE procesos(
    n_aplicacion        NUMBER(4)       CONSTRAINT procesos_fk1         REFERENCES          aplicaciones(n_aplicacion),
    id_proceso          NUMBER(3),
    extension           VARCHAR2(25)    CONSTRAINT procesos_uk1         UNIQUE
                                        CONSTRAINT procesos_nn1         NOT NULL,
    mem_minima          NUMBER(5,1)     CONSTRAINT proceos_ck1          CHECK               ( mem_minima>0 ),
    id_proceso_lanz     NUMBER(3),
    n_aplicacion_lanz   NUMBER(4),
                                        CONSTRAINT aplicaciones_pk      PRIMARY KEY         (n_aplicacion, id_proceso),
                                        CONSTRAINT aplicaciones_fk2     FOREIGN KEY         (n_aplicacion, id_proceso)  REFERENCES procesos(id_proceso, n_aplicacion)
);
CREATE TABLE maquinas(
    n_maquina           NUMBER(3)       CONSTRAINT maquinas_pk          PRIMARY KEY,
    ip1                 NUMBER(3)       CONSTRAINT maquinas_nn1         NOT NULL,
                                        CONSTRAINT maquinas_ck1         CHECK               (ip1>=0 AND ip1<=255),
    ip2                 NUMBER(3)       CONSTRAINT maquinas_nn2         NOT NULL,
                                        CONSTRAINT maquinas_ck2         CHECK               (ip1>=0 AND ip1<=255),
    ip3                 NUMBER(3)       CONSTRAINT maquinas_nn3         NOT NULL,
                                        CONSTRAINT maquinas_ck3         CHECK               (ip1>=0 AND ip1<=255),
    ip4                 NUMBER(3)       CONSTRAINT maquinas_nn4         NOT NULL,
                                        CONSTRAINT maquinas_ck4         CHECK               (ip1>=0 AND ip1<=255),
    nombre              VARCHAR2(45)    CONSTRAINT maquinas_uk2         UNIQUE
                                        CONSTRAINT maquinas_nn5         NOT NULL,
    memoria             NUMBER(5,1),
                                        CONSTRAINT maquinas_uk1         UNIQUE              (ip1,ip2, ip3, ip4)
                     );
CREATE TABLE procesos_lanzados(
    n_aplicacion        NUMBER(4),
    id_proceso          NUMBER(3),
    fecha_lanz          TIMESTAMP,
    fecha_termino       TIMESTAMP,
    bloqueado           NUMBER(1)       CONSTRAINT procesos_lanzados_ck1 CHECK              (bloqueado IN (0,1)),
    n_maquina           NUMBER(3)       CONSTRAINT procesos_lanzados_fk2 REFERENCES         maquinas(n_maquina)         ON DELETE CASCADE,
    n_aplicacion_lanz   NUMBER(4),
                                        CONSTRAINT aplicaciones_pk       PRIMARY KEY        (n_aplicacion, id_proceso, fecha_lanz),
                                        CONSTRAINT aplicaciones_fk1      FOREIGN KEY        (n_aplicacion, id_proceso)  REFERENCES procesos(n_aplicacion,id_proceso) ON DELETE CASCADE
);
