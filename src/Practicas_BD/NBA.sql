CREATE TABLE CONFERENCIAS (
  id_conferencia NUMBER(1)      CONSTRAINT conferencias_pk PRIMARY KEY,
  nombre VARCHAR2(8)            CONSTRAINT conferencias_nn1 NOT NULL CONSTRAINT conferencias_uk1  UNIQUE,
  nombre_esp VARCHAR2(8)
);
CREATE TABLE DIVISIONES (
  id_division NUMBER(2)         CONSTRAINT divisiones_pk PRIMARY KEY ,
  nombre VARCHAR2(25)           CONSTRAINT divisiones_nn1 NOT NULL CONSTRAINT divisiones_uk1 UNIQUE ,
  nombre_esp VARCHAR2(25),
  id_conferencia NUMBER(1)      CONSTRAINT divisiones_nn2 NOT NULL CONSTRAINT divisiones_fk1 REFERENCES CONFERENCIAS(id_conferencia)
);
CREATE TABLE EQUIPOS (
  id_equipo NUMBER(2)           CONSTRAINT equipos_pk PRIMARY KEY ,
  nombre VARCHAR2(25)           CONSTRAINT equipos_nn1 NOT NULL ,
  ciudad VARCHAR2(25)           CONSTRAINT equipos_nn2 NOT NULL ,
  id_division NUMBER(2)         CONSTRAINT equipos_fk1 REFERENCES DIVISIONES(id_division),
  id_franquicia NUMBER(2),
  inicio NUMBER(4),
  fin NUMBER(4)
);
CREATE TABLE PARTIDOS (
  id_equipo_local NUMBER(2)     CONSTRAINT partidos_fk1 REFERENCES EQUIPOS(id_equipo),
  id_equipo_visita NUMBER(2)    CONSTRAINT partidos_fk2 REFERENCES EQUIPOS(id_equipo),
  fecha DATE,
  puntos_local NUMBER(3),
  puntos_visita NUMBER(3),
  prorrogas NUMBER(1),
  comentarios VARCHAR2(1000),
  juegan_casa CHAR(1)           CONSTRAINT partidos_nn1 NOT NULL,
  inicio_temp NUMBER(4)         CONSTRAINT partidos_nn2 NOT NULL ,
  fin_temp NUMBER(4)            CONSTRAINT partidos_nn3 NOT NULL ,
                                CONSTRAINT partidos_pk PRIMARY KEY (id_equipo_local, id_equipo_visita, fecha)
);