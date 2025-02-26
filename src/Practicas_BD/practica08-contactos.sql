CREATE TABLE usuarios(
  id_u NUMBER(20) CONSTRAINT usuarios_pk PRIMARY KEY,
  usuario VARCHAR2(30)  CONSTRAINT usuarios_uk1 UNIQUE
                        CONSTRAINT usuarios_nn1 NOT NULL,
  e_mail VARCHAR2(60) CONSTRAINT usuarios_uk2 UNIQUE
                        CONSTRAINT usuarios_nn2 NOT NULL,
  nombre VARCHAR2(30) CONSTRAINT usuarios_nn3 NOT NULL,
  apellido1 VARCHAR2(30) CONSTRAINT usuarios_nn4 NOT NULL,
  apellido2 VARCHAR2(30),
  passw VARCHAR2(100) CONSTRAINT usuarios_nn5 NOT NULL
);

CREATE TABLE contactos(
  id_u NUMBER(20)  CONSTRAINT contactos_fk1 REFERENCES usuarios
                    ON DELETE CASCADE ,
  usuario NUMBER(20)  CONSTRAINT contactos_fk2 REFERENCES usuarios,
  CONSTRAINT contactos_pk PRIMARY KEY(id_u,usuario),
  CONSTRAINT contactos_ck1 CHECK(id_u!=usuario)
);

create table post (
  id_u        NUMBER(20) CONSTRAINT post_fk1 REFERENCES usuarios
  ON DELETE CASCADE
                                     CONSTRAINT post_nn2 NOT NULL,
  pid         NUMBER(20) CONSTRAINT post_pk PRIMARY KEY,
  texto       VARCHAR2(1000)         CONSTRAINT post_nn1 NOT NULL,
  pid_rel     NUMBER(20) CONSTRAINT post_fk2 REFERENCES post
  ON DELETE SET NULL,
  publicacion DATE      CONSTRAINT post_nn3 NOT NULL
                        CONSTRAINT post_ck1
                          CHECK(publicacion>to_date('2/2/2017','dd/mm/yyyy')),
  duracion   INTERVAL DAY TO SECOND CONSTRAINT post_nn4 NOT NULL
);

CREATE TABLE ser_visible (
  id_u     NUMBER(20),
  usuario  NUMBER(20),
  pid      NUMBER(20) CONSTRAINT ser_visible_fk2 REFERENCES post,
  CONSTRAINT ser_visible_fk1 FOREIGN KEY (id_u, usuario)
  REFERENCES contactos(ID_U,usuario) ON DELETE CASCADE,
  CONSTRAINT ser_visible_pk PRIMARY KEY (id_u, usuario, pid)
);

-------------------------------------2
ALTER TABLE post ADD CONSTRAINT post_ck2 CHECK(duracion>=INTERVAL '30' MINUTE);
RENAME ser_visible TO compartir;
ALTER TABLE usuarios RENAME CONSTRAINT usuarios_pk TO superclave;
ALTER TABLE post MODIFY(publicacion DEFAULT SYSDATE);
ALTER TABLE usuarios DISABLE CONSTRAINT usuarios_nn5;
ALTER TABLE compartir ADD (visible CHAR(2) DEFAULT 'Si' CONSTRAINT compartir_ck3 CHECK(visible='Si' OR visible='No'));

-------------------------------------3
INSERT  INTO usuarios(id_u, usuario, e_mail, nombre, apellido1, apellido2, passw)
        VALUES(1,'ramongar','ramon@hotmail.com','Ramón','García','Ortigal',null);
INSERT  INTO usuarios(id_u, usuario, e_mail, nombre, apellido1, apellido2, passw)
        VALUES(2,'lurdita','lurdita@bbc.co.uk','Lourdes','Atienza',null,null);
INSERT  INTO usuarios(id_u, usuario, e_mail, nombre, apellido1, apellido2, passw)
        VALUES(3,'marioso','marioso19@yahoo.com','Marisol','Jiménez','del Oso',null);
INSERT  INTO usuarios(id_u, usuario, e_mail, nombre, apellido1, apellido2, passw)
        VALUES(4,'sercal','sercal1980@gmail.com','Francisco','Serrano','Calvo',null);

INSERT  INTO post(id_u, pid, texto, pid_rel, publicacion, duracion)
        VALUES(2,1,'Hola',null,to_date('16/12/2023','dd/mm/yyyy'),interval '7' day);
INSERT  INTO post(id_u, pid, texto, pid_rel, publicacion, duracion)
        VALUES(3,2,'Qué tal',1,to_date('17/12/2023','dd/mm/yyyy'),interval '10' day);
INSERT  INTO post(id_u, pid, texto, pid_rel, publicacion, duracion)
        VALUES(4,3,'Probando',null,to_date('18/12/2023','dd/mm/yyyy'),interval '5' hour);

INSERT INTO contactos(id_u, usuario) VALUES(2,3);
INSERT INTO contactos(id_u, usuario) VALUES(2,4);
INSERT INTO contactos(id_u, usuario) VALUES(3,2);

insert into compartir(id_u, usuario, pid) VALUES(2,3,1);
insert into compartir(id_u, usuario, pid) VALUES(2,4,1);
insert into compartir(id_u, usuario, pid) VALUES(3,2,2);

----------4
COMMIT;

---------5
UPDATE USUARIOS SET passw='12345';

---------6
UPDATE usuarios set e_mail='superlourdes@gmail.com' WHERE id_u=2;

---------7
DELETE FROM usuarios WHERE nombre='Ramón';