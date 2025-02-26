CREATE TABLE TIPOS_CURSO (
cod_curso   CHAR (8)            CONSTRAINT cod_curso_pk PRIMARY KEY,
titulo      VARCHAR2(50)        CONSTRAINT cod_curso_uk1 UNIQUE,
duracion    NUMBER(3),
temario     CLOB
);

CREATE TABLE PROFESORES (
nif             CHAR (9)         CONSTRAINT profesores_pk    PRIMARY KEY,
nombre          VARCHAR2(50)     CONSTRAINT profesores_nn1   NOT NULL ,
apellido1       VARCHAR2(50)     CONSTRAINT profesores_nn2   NOT NULL ,
apellido2       VARCHAR2(50),
direccion       VARCHAR2(50),
telefono        CHAR(9)
);

CREATE TABLE CURSOS (
  n_curso       NUMBER(3)         CONSTRAINT cursos_pk PRIMARY KEY,
  fecha_inicio  TIMESTAMP,
  fecha_fin     TIMESTAMP,
  cod_curso     CHAR(8)           CONSTRAINT cursos_fk1 REFERENCES TIPOS_CURSO (COD_CURSO),
  nif_profesor  CHAR(9)           CONSTRAINT cursos_fk2 REFERENCES PROFESORES (NIF)
);

CREATE TABLE EMPRESAS (
  cif           CHAR(9)           CONSTRAINT empresas_pk  PRIMARY KEY,
  nombre        VARCHAR2(25)      CONSTRAINT empresas_uk1 UNIQUE CONSTRAINT empresas_nn1 NOT NULL,
  telefono      CHAR(9),
  direccion     VARCHAR2(50)
);

CREATE TABLE alumnos (
    nif         CHAR(9)           CONSTRAINT alumnos_pk PRIMARY KEY,
    nombre      VARCHAR2(50)      CONSTRAINT alumnos_nn1   NOT NULL ,
    apellido1   VARCHAR2(50)      CONSTRAINT alumnos_nn2   NOT NULL ,
    apellido2   VARCHAR2(50),
    direccion   VARCHAR2(50),
    telefono    CHAR(9),
    edad        NUMBER(2),
    cif         CHAR (9)          CONSTRAINT alumnos_fk1  REFERENCES EMPRESAS(cif)
);

CREATE TABLE ASISTIR (
  nif           CHAR(9)           CONSTRAINT asistir_fk1 REFERENCES ALUMNOS (nif),
  n_curso       NUMBER(3)         CONSTRAINT asistir_fk2 REFERENCES CURSOS (n_curso),
  nota          NUMBER(4,2),
                                  CONSTRAINT asistir_pk PRIMARY KEY (nif, n_curso)
);