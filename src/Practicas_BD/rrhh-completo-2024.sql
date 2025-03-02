CREATE USER rrhh IDENTIFIED BY "Herrera2024_" DEFAULT TABLESPACE DATA QUOTA 50M ON DATA ;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE MATERIALIZED VIEW TO rrhh;


CREATE TABLE rrhh.puestos(
    cod_puesto    NUMBER(2)     CONSTRAINT puestos_pk PRIMARY KEY,
    titulo_puesto VARCHAR2(50)  CONSTRAINT puestos_uk1 UNIQUE
        CONSTRAINT puestos_nn1 NOT NULL,
    salario_min   NUMBER(11,2),
    salario_max   NUMBER(11,2)
);

CREATE TABLE rrhh.localizaciones(
  cod_loc           NUMBER(3)    CONSTRAINT localizaciones_pk PRIMARY KEY,
  localidad         VARCHAR2(50) CONSTRAINT localizaciones_nn1 NOT NULL,
  direccion         VARCHAR2(50),
  cp                CHAR(5),
  provincia         VARCHAR2(25)
);

CREATE TABLE rrhh.empleados(
  cod_emp     NUMBER(4)    CONSTRAINT empleados_pk PRIMARY KEY,
  nombre      VARCHAR2(50) CONSTRAINT empleados_nn1 NOT NULL,
  apellido1   VARCHAR2(50) CONSTRAINT empleados_nn2 NOT NULL,
  apellido2   VARCHAR2(50),
  telefono    CHAR(9),
  direccion   VARCHAR2(50),
  email       VARCHAR2(50) CONSTRAINT empleados_uk  UNIQUE,
  cp          CHAR(5),
  localidad   VARCHAR2(50),
  provincia   VARCHAR2(25),
  cod_jefe    NUMBER(4)    CONSTRAINT empleados_fk1 REFERENCES rrhh.empleados
);

CREATE TABLE rrhh.departamentos(
  cod_dep     NUMBER(2)     CONSTRAINT departamentos_pk PRIMARY KEY,
  nombre_dep  VARCHAR2(25)  CONSTRAINT departamentos_uk1 UNIQUE
                            CONSTRAINT departamentos_nn1 NOT NULL,
  cod_resp    NUMBER(4)     CONSTRAINT departamentos_fk1 REFERENCES rrhh.empleados,
  cod_loc     NUMBER(3)     CONSTRAINT departamentos_fk2 REFERENCES rrhh.localizaciones
);


CREATE TABLE rrhh.contratos (
  cod_puesto  NUMBER(2)   CONSTRAINT contratos_fk1 REFERENCES rrhh.puestos,
  cod_emp     NUMBER(4)   CONSTRAINT contratos_fk2 REFERENCES rrhh.empleados,
  fecha_inicio DATE       CONSTRAINT contratos_nn1 NOT NULL,
  fecha_fin   DATE,
  cod_dep     NUMBER(3)   CONSTRAINT contratos_fk3 REFERENCES rrhh.departamentos,
  salario     NUMBER(11,2),
  CONSTRAINT contratos_pk PRIMARY KEY(cod_puesto,cod_emp,fecha_inicio)
);


INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (1, 'Dirección', 140000.00, 210000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (2, 'Analista', 115000.00, 150000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (3, 'Administrador de seguridad', 100000.00, 130000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (4, 'Desarrollador senior', 70000.00, 90000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (5, 'Desarrollador junior', 40000.00, 60000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (6, 'Probador', 25000.00, 35000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (7, 'DBA', 90000.00, 110000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (8, 'Operador DB', 30000.00, 40000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (9, 'Operador de sistemas', 30000.00, 50000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (10, 'Administrador de redes', 70000.00, 90000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (11, 'Administrador de sistemas', 80000.00, 110000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (12, 'Asistente al usuario', 20000.00, 35000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (13, 'Diseñador UX', 50000.00, 90000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (14, 'Responsable ventas', 80000.00, 100000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (15, 'Vendedor', 50000.00, 70000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (16, 'Dirección de ventas', 110000.00, 140000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (17, 'Especialista en IA', 80000.00, 110000.00);
INSERT INTO RRHH.PUESTOS (COD_PUESTO, TITULO_PUESTO, SALARIO_MIN, SALARIO_MAX) VALUES (18, 'Responsable IA', 120000.00, 150000.00);

commit;

INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (1, 'Palencia', 'C/ Mayor 32', '34001', 'Palencia');
INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (2, 'Palencia', 'C/ Roma 18', '34003', 'Palencia');
INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (3, 'Palencia', 'C/ Roma 17', '34003', 'Palencia');
INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (4, 'Villamuriel de Cerrato', 'C/ Las Viñas 7', '34190', 'Palencia');
INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (5, 'Villamuriel de Cerrato', 'C/ Industria s/n', '34190', 'Palencia');
INSERT INTO RRHH.LOCALIZACIONES (COD_LOC, LOCALIDAD, DIRECCION, CP, PROVINCIA) VALUES (6, 'Villamuriel de Cerrato', 'C/ Emprendimiento s/n', '34190', 'Palencia');

commit;

ALTER TABLE rrhh.departamentos  DISABLE CONSTRAINT departamentos_fk1;

INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (1, 'Ventas', 12, 1);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (2, 'Bases de Datos', 10, 2);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (3, 'Sistemas', 23, 2);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (4, 'Desarrollo', 3, 3);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (5, 'UX', 33, 3);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (6, 'Dirección', 2, 3);
INSERT INTO RRHH.DEPARTAMENTOS (COD_DEP, NOMBRE_DEP, COD_RESP, COD_LOC) VALUES (7, 'IA', null, 5);

commit;

ALTER TABLE rrhh.empleados DISABLE CONSTRAINT empleados_fk1;

INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (1, 'Eusebio', 'Mazagón', 'De Roa', '635432311', 'C/ Mayor 16', 'mazagon.eusebio@empresota.com', '34001', 'Palencia', 'Palencia', null);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (2, 'Rosa', 'Santiago', 'Ouviña', '745321123', 'C/ Los Milagros 2 1º B', 'santiago.rosa@empresota.com', '34192', 'Grijota', 'Palencia', null);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (3, 'Arturo', 'Jiménez', 'Vallés', '613212443', 'Avda Cardenal Cisneros 2 3ºC', 'jimenez.arturo@empresota.com', '34004', 'Palencia', 'Palencia', 2);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (4, 'Marisa', 'Calvo', 'Robles', '606727675', 'Avda Santander 18 1ºA', 'calvo.marisa@empresota.com', '34003', 'Palencia', 'Palencia', 2);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (5, 'Lope', 'Suanzes', 'Aranzábal', '656435211', 'C/ Camino de Sirga 99', 'suanzes.lope@empresota.com', '34190', 'Villamuriel de Cerrato', 'Palencia', 3);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (6, 'Marco', 'Lopez', 'Varga', '723652351', 'Camino San Román s/n', 'lopez.marco@empresota.com', '34005', 'Palencia', 'Palencia', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (7, 'Lourdes', 'Ansina', 'Valerón', '612324590', 'Avda José Zorrilla 12 7º C', 'ansina.lourdes@empresota.com', '47007', 'Valladolid', 'Valladolid', null);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (8, 'Maia', 'Lorenzo', 'Portalón', null, 'Avda Palencia 12 3º C ', 'lorenzo.maia@empresota.com', '47010', 'Valladolid', 'Valladolid', 5);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (9, 'Josefina', 'San Martín', 'Igualada', '789789789', 'C/ Conde de Vallellano 11 2º C', 'sanmartin.josefin@empresota.com', '34002', 'Palencia', 'Palencia', 5);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (10, 'Miguel', 'Real', 'Sánchez', '615626121', 'C/ Inés de Osorio 12 4º B', 'real.miguel@empresota.com', '34001', 'Palencia', 'Palencia', 16);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (11, 'Sandra', 'Donés', 'Mansilla', '675848123', 'C/ Nueva 12', 'dones.sandra@empresota.com', '47270', 'Cigales', 'Valladolid', 12);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (12, 'Jordi', 'Maceda', 'Llorens', '645212311', 'C/ Mayor Antigua 18 3º D', 'maceda.jordi@empresota.com', '34001', 'Palencia', 'Palencia', 2);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (13, 'Marisol', 'Hernández', 'Lopega', '673713211', 'Avda San Telmo 12 1º A', 'hernandez.marisol@empresota.com', '34004', 'Palencia', 'Palencia', 12);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (14, 'Ana', 'Sotorriba', 'Wagner', '712341231', 'C/ Armonio 5 2º D', 'sotorriba.ana@empresota.com', '47012', 'Valladolid', 'Valladolid', 12);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (15, 'Marta', 'Sotorriba', 'Wagner', '767239091', 'C/ Armonio 5 2º D', 'sotorriba.marta@empresota.com', '47012', 'Valladolid', 'Valladolid', 11);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (16, 'Estella', 'Wilder', null, '652398017', 'C/ Isabel I de Castilla 2º A', 'wilder.estella@empresota.com', '09400', 'Aranda de Duero', 'Burgos', 3);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (17, 'Alfonso', 'Horcada', 'Quirón', null, 'C/ Gil de Siloe', 'horcada.alfonso@empresota.com', '34001', 'Palencia', 'Palencia', 3);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (18, 'Pablo', 'Roncal', 'Vallés', '645623911', 'C/ Maria de Molina 2 1º A', 'roncal.pablo@empresota.com', '34004', 'Palencia', 'Palencia', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (19, 'Marta', 'Sánchez', 'García', '784367121', 'C/ Postas 12 2º B', 'sanchez.marta@empresota.com', '09400', 'Aranda de Duero', 'Burgos', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (20, 'Luis', 'Argal', 'Hombrada', '656677889', 'C/ Boteros 5', 'argal.luis@empresota.com', '34210', 'Dueñas', 'Palencia', 16);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (21, 'Marcos', 'Peña', 'Figueroa', '672901   ', 'C/ Tello Téllez 12 1º A', 'pena.marcos@empresota.com', '34004', 'Palencia', 'Palencia', 17);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (22, 'Marisa', 'Otxoa', 'Azurmendi', '658901902', 'C/ Los Tintes 13 2º A', 'otxoa.marisa@empresota.com', '34004', 'Palencia', 'Palencia', 18);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (23, 'Olga', 'Sebastián', 'Horcados', '789908781', 'Avda de Argentina 18 3º C', 'sebastian.olga@empresota.com', '34004', 'Palencia', 'Palencia', 2);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (24, 'Lorenzo', 'Benavente', 'Rodríguez', '669010231', 'Plaza Pío XII 4 2º F', 'benavente.lorenzo@empresota.com', '34001', 'Palencia', 'Palencia', 23);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (25, 'Sandra', 'Sánchez', 'León', '789876523', 'Calle la Nava 12', 'sanchez.sandra@empresota.com', '34192', 'Grijota', 'Palencia', 32);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (26, 'Arturo', 'Higuero', 'sánchez', '655771231', 'Calle la Nava 12', 'higuero.arturo@empresota.com', '34192', 'Grijota', 'Palencia', 33);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (27, 'Verónica', 'Leiba', 'Montón', '610947511', 'C/ Panaderas 1 3º C', 'leiba.veronica@empresota.com', '34001', 'Palencia', 'Palencia', 28);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (28, 'Agustín', 'López', 'García', '73200100 ', 'C/ Los Tintes 23 4º A', 'lopez.agustin@empresota.com', '34004', 'Palencia', 'Palencia', 10);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (29, 'Víctor', 'Llopart', 'Quirós', '672371231', 'Plaza Reina 3', 'llopart.victor@empresota.com', '34230', 'Palencia', 'Palencia', 28);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (30, 'Marga', 'Coloma', 'Herranz', '679876212', 'Avda Santander 18 2º A', 'coloma.marga@empresota.com', '34003', 'Palencia', 'Palencia', 3);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (31, 'Marcos', 'Luzón', 'Esguevillas', '675729121', 'C/ Nueva 23', 'luzon.marcos@empresota.com', '34190', 'Villamuriel de Cerrato', 'Palencia', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (32, 'Luisa', 'Serna', 'Capazo', '689987234', 'C/ Zarcillo 14', 'serna.luisa@empresota.com', '47270', 'Cigales', 'Valladolid', 16);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (33, 'Mark', 'Holmes', null, '782617121', 'C/ Mayor Antigua 16 1º A', 'holmes.mark@empresota.com', '34001', 'Palencia', 'Palencia', 3);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (34, 'Rita', 'Valón', 'Crespo', '635421121', 'C/ Bastas 17', 'valon.rita@empresota.com', '47260', 'Cabezón de Pisuerga', 'Valladolid', 33);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (35, 'María', 'Sánchez', 'Suárez', '756234121', 'C/ Bastas 17', 'sanchez.maria@empresota.com', '47260', 'Cabezón de Pisuerga', 'Valladolid', 16);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (36, 'Kurt', 'Stomper', null, null, 'Carretera Palencia s/n ', 'stomper.kurt@empresota.com', '34440', 'Fromista', 'Palencia', null);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (37, 'Nuño', 'Vivancos', 'Real', '674531231', 'Plaza de la Constitución 8 2º B', 'vivancos.nuno@empresota.com', '34004', 'Palencia', 'Palencia', 23);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (42, 'Marta', 'Calderón', 'Doliente', '732192030', 'C/ Alguacil 12 3ºA', 'marta.calderon@empresota.com', '47005', 'Valladolid', 'Valladolid', 23);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (43, 'Richard', 'O''Connell', null, '6532090  ', 'C/ Alguacil 12 3ºA', 'richar.o.connell@empresota.com', '47005', 'Valladolid', 'Valladolid', 16);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (44, 'Gadea', 'Olmedo', 'Arrizabalaga', null, 'Avda Cardenal Cisneros 34 3º C', 'gadea.olmedo@empresota.com', '34003', 'Palencia', 'palencia', 35);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (45, 'Sergio', 'Del amo', 'Lebrija', null, 'C/ La cuesta 8', 'sergio.del.amo@empresota.com', '34419', 'Villalobón', 'palencia', 32);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (46, 'Rodrigo', 'Caños', 'Vallés', '603987811', 'Avda Santander 12', 'rodrigo.canos@empresota.com', '34012', 'Palencia', 'Palencia', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (47, 'Lara', 'Arostegi', 'Solozábal', '702393910', 'C/ Las Vides 18', 'lara.arostegi@empresota.com', '47270', 'Cigales', 'Valladolid', 4);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (48, 'Mike', 'Graham', null, '691230924', 'C/ El puerto 12, 3º Izq', 'mike.graham2@empresota.com', '34210', 'Dueñas', 'Palencia', 24);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (38, 'Adriana', 'Gante', 'Ledesma', '623441441', 'C/ Mayor 15', 'adriana.gante@empresota.com', '47270', 'Cigales', 'Valladolid', 11);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (39, 'Luis', 'Salas', 'Bartoldi', null, 'Avda Santander 15 4º C', 'salas.luis@empresota.com', '34003', 'Palencia', 'Palencia', 14);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (40, 'Francisco', 'Salazar', 'Etxebesti', '878281881', 'C/ Romero 12', 'salazar.francisco@empresota.com', '34419', 'Villalobón', 'Palencia', null);
INSERT INTO RRHH.EMPLEADOS (COD_EMP, NOMBRE, APELLIDO1, APELLIDO2, TELEFONO, DIRECCION, EMAIL, CP, LOCALIDAD, PROVINCIA, COD_JEFE) VALUES (41, 'Rose', 'Hildegard', null, null, 'Avda Modesto Lafuente 13 1º A', 'hildegard.rose@empresota.com', '34002', 'Palencia', 'Palencia', 32);

ALTER TABLE rrhh.departamentos ENABLE CONSTRAINT departamentos_fk1;
ALTER TABLE rrhh.empleados ENABLE CONSTRAINT empleados_fk1;

commit;

INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (1, 1, DATE '2017-07-05', DATE '2019-07-05', 6, 170000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (2, 2, DATE '2017-07-05', DATE '2019-07-05', 4, 120000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (1, 2, DATE '2019-07-05', null, 6, 215000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 3, DATE '2017-07-05', DATE '2017-11-04', 4, 70000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (2, 3, DATE '2017-11-04', null, 4, 140000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (2, 4, DATE '2019-07-27', null, 4, 130000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 5, DATE '2017-07-05', DATE '2018-02-18', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 5, DATE '2018-02-18', DATE '2020-09-04', 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (2, 5, DATE '2020-09-04', null, 4, 125000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 6, DATE '2017-07-05', DATE '2018-02-17', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 6, DATE '2018-02-18', DATE '2023-03-13', 4, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 7, DATE '2017-07-05', DATE '2018-03-22', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 8, DATE '2018-03-22', DATE '2018-10-26', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 8, DATE '2018-10-26', null, 4, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 9, DATE '2018-07-11', DATE '2018-09-05', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 9, DATE '2018-09-05', DATE '2018-11-04', 4, 75000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (7, 9, DATE '2018-11-04', DATE '2019-02-27', 4, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 9, DATE '2019-02-27', null, 4, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (7, 10, DATE '2019-02-27', null, 4, 130000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 11, DATE '2018-09-06', DATE '2019-09-06', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 11, DATE '2019-09-06', DATE '2020-11-14', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (14, 11, DATE '2020-11-14', null, 1, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (14, 12, DATE '2017-07-05', DATE '2022-08-28', 1, 100000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (15, 13, DATE '2017-07-05', DATE '2019-09-08', 1, 55000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (14, 13, DATE '2019-09-04', DATE '2020-10-02', 1, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (15, 14, DATE '2018-01-05', DATE '2022-08-05', 1, 55000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (15, 15, DATE '2019-05-28', null, 1, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 16, DATE '2018-09-08', DATE '2019-09-08', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 16, DATE '2019-09-08', DATE '2021-05-07', 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (2, 16, DATE '2021-05-07', null, 4, 130000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 17, DATE '2018-09-08', DATE '2020-03-25', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 17, DATE '2020-03-25', null, 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 18, DATE '2018-09-08', DATE '2020-03-25', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 18, DATE '2020-03-25', null, 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 19, DATE '2020-03-25', DATE '2021-03-25', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 19, DATE '2021-03-25', null, 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 20, DATE '2020-03-25', DATE '2021-03-25', 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 20, DATE '2021-03-25', null, 4, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 21, DATE '2021-06-07', null, 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 22, DATE '2021-06-07', null, 4, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (9, 23, DATE '2018-09-06', DATE '2020-06-19', 3, 40000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (10, 23, DATE '2020-06-19', null, 3, 80000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (10, 24, DATE '2018-02-10', DATE '2020-06-19', 3, 70000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (3, 24, DATE '2020-06-19', null, 3, 135000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (9, 25, DATE '2020-06-19', null, 3, 30000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (6, 26, DATE '2019-05-12', DATE '2021-11-30', 4, 30000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (6, 27, DATE '2019-05-12', DATE '2020-07-04', 4, 30000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (8, 27, DATE '2020-07-04', null, 2, 40000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (8, 28, DATE '2018-03-25', DATE '2019-05-12', 2, 35000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (7, 28, DATE '2019-05-12', null, 2, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (8, 29, DATE '2020-05-08', null, 2, 35000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (12, 30, DATE '2018-01-18', null, 5, 35000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (12, 31, DATE '2020-02-07', null, 5, 35000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (11, 32, DATE '2018-01-10', null, 3, 100000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (13, 33, DATE '2017-12-10', null, 5, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (13, 34, DATE '2021-01-10', null, 5, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (6, 35, DATE '2019-09-14', DATE '2020-07-07', 4, 25000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 35, DATE '2020-07-07', DATE '2021-09-25', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (4, 35, DATE '2021-09-25', null, 4, 75000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (8, 37, DATE '2019-11-10', DATE '2020-08-20', 2, 30000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (9, 37, DATE '2020-08-21', DATE '2022-03-02', 3, 40000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (10, 42, DATE '2023-01-11', null, 3, 75000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (11, 43, DATE '2023-01-11', null, 3, 105000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 44, DATE '2023-03-09', null, 4, 38000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 45, DATE '2023-03-09', null, 4, 41000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (5, 26, DATE '2022-12-02', DATE '2023-03-03', 4, 45000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (13, 26, DATE '2023-03-03', null, 5, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (6, 46, DATE '2023-03-03', null, 4, 28000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (6, 47, DATE '2023-03-03', null, 4, 28000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (9, 48, DATE '2023-03-08', null, 3, 30000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (11, 37, DATE '2022-08-05', DATE '2023-03-13', 3, 75000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (14, 14, DATE '2022-08-05', null, 1, 90000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (16, 12, DATE '2022-08-28', null, 1, 130000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (15, 38, DATE '2022-08-28', null, 1, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (15, 39, DATE '2022-08-28', null, 1, 50000.00);
INSERT INTO RRHH.CONTRATOS (COD_PUESTO, COD_EMP, FECHA_INICIO, FECHA_FIN, COD_DEP, SALARIO) VALUES (9, 41, DATE '2022-08-28', null, 3, 40000.00);

commit;



