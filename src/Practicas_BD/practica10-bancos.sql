----1

CREATE TABLE bancos(
  num_ba CHAR(4)      CONSTRAINT bancos_pk PRIMARY KEY,
  nombre VARCHAR2(25) CONSTRAINT bancos_uk1 UNIQUE
                      CONSTRAINT bancos_nn1 NOT NULL
);

CREATE TABLE clientes(
  id_cliente NUMBER(8)    CONSTRAINT clientes_pk PRIMARY KEY,
  nombre VARCHAR2(25)     CONSTRAINT clientes_nn1 NOT NULL,
  apellido1 VARCHAR2(25)  CONSTRAINT clientes_nn2 NOT NULL,
  apellido2 VARCHAR2(25),
  telefono CHAR(9),
  direccion VARCHAR2(50)
);

CREATE TABLE personal(
  id_persona NUMBER(3)    CONSTRAINT personal_pk PRIMARY KEY,
  nombre VARCHAR2(25)     CONSTRAINT personal_nn1 NOT NULL,
  apellido1 VARCHAR2(25)  CONSTRAINT personal_nn2 NOT NULL,
  apellido2 VARCHAR2(25),
  telefono CHAR(9),
  direccion VARCHAR2(50),
  id_jefe NUMBER(3) CONSTRAINT personal_fk1 REFERENCES personal ON DELETE SET NULL
);
CREATE TABLE sucursales(
  num_ba CHAR(4) CONSTRAINT sucursaesl_fk1 REFERENCES bancos ON DELETE CASCADE,
  num_su CHAR(4),
  direccion VARCHAR2(50),
  id_director NUMBER(3) CONSTRAINT sucursales_fk2 REFERENCES personal
                        CONSTRAINT sucursales_nn1 NOT NULL,
  id_interventor NUMBER(3) CONSTRAINT sucursales_fk3 REFERENCES personal,
  CONSTRAINT sucursales_pk PRIMARY KEY(num_ba,num_su)
);

CREATE TABLE cuentas(
  num_ba CHAR(4),
  num_su CHAR(4),
  control CHAR(2) CONSTRAINT cuentas_ck1 CHECK(control NOT IN ('60','35','17')),
  num_cu NUMBER(10),
  saldo NUMBER(20,5) DEFAULT 1000 CONSTRAINT cuentas_ck2 CHECK(saldo>=1000),
  id_cliente NUMBER(8) CONSTRAINT cuentas_fk2 REFERENCES clientes ON DELETE CASCADE,
  CONSTRAINT cuentas_fk1 FOREIGN KEY(num_ba,num_su) REFERENCES sucursales(num_ba, num_su) ON DELETE CASCADE ,
  CONSTRAINT cuentas_pk PRIMARY KEY(num_ba,num_su,control,num_cu)
);


-------2
--
ALTER TABLE bancos ADD CONSTRAINT bancos_ck1 CHECK(LENGTH(num_ba)=4);
--
ALTER TABLE personal ADD(
  nivel CHAR(1) DEFAULT 'B' CONSTRAINT personal_ck1 CHECK(nivel IN ('A','B','C'))
  );
--
ALTER TABLE cuentas RENAME CONSTRAINT cuentas_pk TO numero_completo_pk;
--
ALTER TABLE sucursales DROP CONSTRAINT sucursales_nn1;
--
ALTER TABLE clientes MODIFY(id_cliente CONSTRAINT clientes_nn3 NOT NULL);
--
RENAME personal TO trabajadores;

--------3
INSERT  INTO clientes(id_cliente, nombre, apellido1, apellido2,telefono, direccion)
        VALUES(1,'Fernando','Arriaga','Granados','979777877','C/Mayor 15 1º A');
INSERT  INTO clientes(id_cliente, nombre, apellido1, apellido2,telefono, direccion)
        VALUES(2,'Martina','Salazar','Merino','979506010','C/Mayor 15 1º A');
INSERT  INTO clientes(id_cliente, nombre, apellido1, apellido2,telefono, direccion)
        VALUES(3,'Cristina','Ollante','Buruaga','979777777','C/Londres 2');

INSERT INTO trabajadores(id_persona, nombre, apellido1, apellido2,telefono, direccion, id_jefe)
            VALUES(1,'Marcelo','Quirón','Crespo','601010101','Avda Los Ángeles 12 2ºA',null);
INSERT INTO trabajadores(id_persona, nombre, apellido1, apellido2,telefono, direccion, id_jefe)
            VALUES(2,'Martina','Salazar','Merino','602020202','C/ Dulce Pastora 18',1);
INSERT INTO trabajadores(id_persona, nombre, apellido1, apellido2,telefono, direccion, id_jefe)
            VALUES(3,'Luisa','Martín','Cóbreces','603030303','Plaza Roja 3º C',null);

INSERT INTO bancos(num_ba, nombre) VALUES ('0001','Banco del Cerrato');
INSERT INTO bancos(num_ba, nombre) VALUES ('0002','Banco de Campos');

INSERT INTO sucursales(num_ba, num_su, direccion, id_director, id_interventor)
       VALUES('0001','0001','C/ Mayor 30',1,2);
INSERT INTO sucursales(num_ba, num_su, direccion, id_director, id_interventor)
       VALUES('0001','0002','C/ San Luis s/n',3,null);
INSERT INTO sucursales(num_ba, num_su, direccion, id_director, id_interventor)
       VALUES('0002','0001','C/ Mayor 60',null,null);

INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0001','0001','10',1234567890,1,1900);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0001','0001','11',1234567891,2,1600);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0001','0001','16',1234567896,2,11900);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0001','0002','12',1234567892,3,2300);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0002','0001','13',1234567893,1,15000);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0002','0001','14',1234567894,1,23000);
INSERT INTO cuentas(num_ba, num_su, control, num_cu, id_cliente,saldo)
       VALUES('0002','0001','15',1234567895,3,14200);

COMMIT;


----4
UPDATE trabajadores SET apellido1='Pérez' WHERE nombre='Martina';

----5
UPDATE cuentas SET saldo=saldo*2 WHERE num_ba='0001';

----6
DELETE cuentas WHERE saldo BETWEEN 30000 AND 45000;

----7
ROLLBACK;

ALTER TABLE clientes ADD (
  telefono2 CHAR(9)
);

UPDATE clientes SET telefono2='609999999' WHERE id_cliente=1;


