CREATE TABLE usuarios (
    id_u        NUMBER(20),
    usuario     VARCHAR2(30)            CONSTRAINT usuarios_uk1 UNIQUE CONSTRAINT usuarios_nn1 NOT NULL,
    e_mail      VARCHAR2(60)            CONSTRAINT usuarios_uk2 UNIQUE CONSTRAINT usuarios_nn2 NOT NULL,
    nombre      VARCHAR2(30)            CONSTRAINT usuarios_nn3 NOT NULL,
    apellido1   VARCHAR2(30)            CONSTRAINT usuarios_nn4 NOT NULL,
    apellido2   VARCHAR2(30),
    passw       VARCHAR2(100)           CONSTRAINT usuarios_nn5 NOT NULL,
                                        CONSTRAINT usuarios_pk PRIMARY KEY (id_u)
);
CREATE TABLE contactos (
    id_u        NUMBER(20)              CONSTRAINT contactos_fk1 REFERENCES usuarios(id_u) ON DELETE CASCADE,
    contacto    NUMBER(20)              CONSTRAINT contactos_fk2 REFERENCES usuarios(id_u) ON DELETE CASCADE,
                                        CONSTRAINT contactos_pk PRIMARY KEY (id_u, contacto),
                                        CONSTRAINT contactos_check CHECK (id_u != contacto)
);
CREATE TABLE post (
    id_u        NUMBER(20)              CONSTRAINT post_nn2 NOT NULL CONSTRAINT post_fk1 REFERENCES usuarios(id_u),
    pid         NUMBER(20),
    texto       VARCHAR2(1000)          CONSTRAINT post_nn1 NOT NULL,
    pid_rel     NUMBER(20)              CONSTRAINT post_fk2 REFERENCES post(pid) ON DELETE SET NULL,
    publicacion DATE                    CONSTRAINT post_nn3 NOT NULL ,
    duracion    INTERVAL DAY TO SECOND  CONSTRAINT post_nn4 NOT NULL,
                                        CONSTRAINT post_pk PRIMARY KEY (pid),
                                        CONSTRAINT check_publicacion CHECK (publicacion > TO_DATE('2/2/2017' , 'DD/MM/YYYY')) --¿Formato de la fecha?
);
CREATE TABLE ser_visible (
    id_u        NUMBER(20),
    contacto    NUMBER(20),
    pid         NUMBER(20)              CONSTRAINT ser_visible_fk2 REFERENCES post(pid),
                                        CONSTRAINT ser_visible_pk PRIMARY KEY (id_u, contacto, pid),
                                        CONSTRAINT ser_visible_fk1  FOREIGN KEY(id_u, contacto) REFERENCES contactos(id_u, contacto)
);

ALTER TABLE POST ADD (
CHECK (duracion > '30')
);

RENAME SER_VISIBLE TO COMPARTIR;

ALTER TABLE USUARIOS RENAME CONSTRAINT USUARIOS_PK TO SUPERCLAVE;

ALTER TABLE USUARIOS DROP CONSTRAINT usuarios_nn5;

ALTER TABLE POST ADD(
    visible CHAR(2) DEFAULT 'SI' CHECK ( visible = 'SI' OR visible = 'NO' )
    );

ALTER TABLE POST MODIFY (
    publicacion DEFAULT SYSDATE
    );

