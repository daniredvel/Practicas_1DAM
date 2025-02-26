---------------1

CREATE TABLE canales(
  id_canal NUMBER(2) CONSTRAINT canales_pk PRIMARY KEY,
  nombre VARCHAR2(509)  CONSTRAINT canales_uk1 UNIQUE
                        CONSTRAINT canales_nn1 NOT NULL
);

CREATE TABLE programas(
  id_prg NUMBER(4) CONSTRAINT programas_pk PRIMARY KEY,
  nombre VARCHAR2(50) CONSTRAINT programas_uk1 UNIQUE
                      CONSTRAINT programas_nn1 NOT NULL,
  es_serie CHAR(1) DEFAULT 'S' CONSTRAINT programas_nn2 NOT NULL
    CONSTRAINT programas_ck1 CHECK(es_serie IN ('S','N'))
);

CREATE TABLE temporadas(
  id_prg NUMBER(4) CONSTRAINT temporadas_fk1 REFERENCES programas,
  n_temporada NUMBER(2),
  nombre VARCHAR2(50),
  año_inicio NUMBER(4),
  año_fin NUMBER(4),
  CONSTRAINT temporadas_pk PRIMARY KEY(id_prg,n_temporada)
);

CREATE TABLE capitulos(
  id_prg NUMBER(4),
  n_temporada NUMBER(2),
  n_capitulo NUMBER(3),
  titulo VARCHAR2(50) CONSTRAINT capitulos_nn1 NOT NULL,
  duracion INTERVAL DAY TO SECOND DEFAULT INTERVAL '50' MINUTE,
  CONSTRAINT capitulos_fk1 FOREIGN KEY (id_prg,n_temporada) REFERENCES temporadas,
  CONSTRAINT capitulos_pk PRIMARY KEY(id_prg,n_temporada,n_capitulo)
);

CREATE TABLE emisiones(
  id_canal NUMBER(2) CONSTRAINT emisiones_fk1 REFERENCES canales
                      ON DELETE CASCADE,
  id_prg NUMBER(4),
  n_temporada NUMBER(2),
  n_capitulo NUMBER(3),
  fecha TIMESTAMP,
  id_prg_suelto NUMBER(4),
  CONSTRAINT emisiones_pk PRIMARY KEY(id_canal,id_prg,n_temporada,n_capitulo),
  CONSTRAINT emisiones_fk2 FOREIGN KEY (id_prg,n_temporada,n_capitulo)
                          REFERENCES capitulos(id_prg,n_temporada,n_capitulo) ON DELETE CASCADE
);


------------------2
--
ALTER TABLE emisiones DROP CONSTRAINT emisiones_pk;
ALTER TABLE emisiones ADD(id_emision NUMBER(6) CONSTRAINT emisiones_pk PRIMARY KEY);
---
ALTER TABLE temporadas ADD CONSTRAINT temporadas_ck1 CHECK (año_fin>=año_inicio OR año_fin IS NULL);
---
ALTER TABLE programas DROP CONSTRAINT programas_ck1;
ALTER TABLE programas MODIFY (es_serie NUMBER(1) DEFAULT 1 CONSTRAINT programas_ck1 CHECK(es_serie IN(0,1)));
-----
ALTER TABLE emisiones ADD CONSTRAINT emisiones_ck1 CHECK(
  (id_canal IS NULL AND id_prg IS NULL AND n_temporada IS NULL AND n_capitulo IS NULL
    AND id_prg_suelto IS NOT NULL) OR
  (id_canal IS NOT NULL AND id_prg IS NOT NULL AND n_temporada IS NOT NULL AND n_capitulo IS NOT NULL AND id_prg_suelto IS  NULL)
  );

--------------3
INSERT INTO canales VALUES (1,'TV1');
INSERT INTO programas VALUES (1,'Ochentame otra vez',1);
INSERT INTO temporadas (id_prg, n_temporada,año_inicio, año_fin) VALUES (1,1,2019,2019);
INSERT INTO capitulos VALUES (1,1,1,'La republica de las letras',NULL );
INSERT INTO emisiones VALUES (1,1,1,1,to_date('4/2/2023 00:05','dd/mm/yyyy hh24:mi'),NULL ,1);

INSERT INTO capitulos VALUES  (1,1,2,'actrices del momento',interval '1' hour );
INSERT INTO emisiones VALUES (1,1,1,2,to_date('4/2/2023 1:00','dd/mm/yyyy hh24:mi'),NULL,2);

INSERT INTO programas VALUES (2,'la noche 24h',1);
INSERT INTO emisiones(id_canal, id_prg, n_temporada, n_capitulo, fecha, id_prg_suelto,id_emision)
VALUES (null,null,null,null,to_date('4/2/2023 1:00','dd/mm/yyyy hh24:mi'),2,3);

INSERT INTO canales VALUES (2,'FOX');
INSERT INTO programas VALUES (3,'Hawai 5.0',1);
INSERT INTO temporadas VALUES (3,5,NULL ,2017,2018);
INSERT INTO capitulos VALUES (3,5,3,'kanalu hope loa',interval '45' minute );
INSERT into emisiones VALUES (2,3,5,3,to_date('4/2/2023 0:02','dd/mm/yyyy hh24:mi'),null,4);


INSERT INTO capitulos VALUES (3,5,4,'na la ilio',interval '41' minute );
INSERT into emisiones VALUES (2,3,5,4,to_date('4/2/2023 0:50','dd/mm/yyyy hh24:mi'),null,5);

INSERT INTO programas VALUES (4,'the tunnel',1);
INSERT INTO temporadas VALUES (4,1,'venganza',2018,null);
INSERT INTO capitulos VALUES (4,1,1,'episodio1',null);
INSERT INTO emisiones VALUES (2,4,1,1,to_date('4/2/2023 1:32','dd/mm/yyyy hh24:mi'),null,6);


-----4
UPDATE emisiones SET fecha=fecha+INTERVAL '5' MINUTE WHERE id_canal=2;

---5
UPDATE programas SET nombre='El tunel' WHERE nombre='the tunnel';


---6
ALTER TABLE canales ADD (cable NUMBER(1) DEFAULT 0 CONSTRAINT canales_ck1 CHECK ( cable IN (0,1) ));
UPDATE canales SET cable=0 WHERE id_canal=1;

