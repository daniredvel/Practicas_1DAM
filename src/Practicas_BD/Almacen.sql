CREATE TABLE TIPOS_PIEZA (
    tipo CHAR(2)                    CONSTRAINT tipos_pieza_pk PRIMARY KEY,
    descripcion VARCHAR2(25)        CONSTRAINT tipos_pieza_nn1 NOT NULL
);
CREATE TABLE EMPRESAS (
    cif CHAR(9)                     CONSTRAINT empresas_pk PRIMARY KEY ,
    nombre VARCHAR2(50)             CONSTRAINT empresas_uk1 UNIQUE CONSTRAINT empresas_nn1 NOT NULL ,
    telefono CHAR(9) ,
    direccion VARCHAR2(50) ,
    localidad VARCHAR2(50) ,
    provincia VARCHAR2(30)
);
CREATE TABLE PIEZAS (
    tipo CHAR(2)                    CONSTRAINT piezas_fk1 REFERENCES TIPOS_PIEZA(tipo),
    modelo NUMBER(2) ,
    precio_venta NUMBER(11,4)       CONSTRAINT piezas_nn1 NOT NULL,
                                    CONSTRAINT piezas_pk PRIMARY KEY (tipo, modelo)
);
CREATE TABLE SUMNINISTROS (
    tipo CHAR(2) ,
    modelo NUMBER(2) ,
    cif CHAR(9)                     CONSTRAINT suministros_fk2 REFERENCES EMPRESAS(cif),
    precio_compra NUMBER(11,4)      CONSTRAINT suministors_nn1 NOT NULL ,
                                    CONSTRAINT suministros_pk PRIMARY KEY (tipo, modelo, cif),
                                    CONSTRAINT suministros_fk1 FOREIGN KEY (tipo, modelo) REFERENCES PIEZAS(tipo, modelo)
);
CREATE TABLE PEDIDOS (
    n_pedido NUMBER(4)              CONSTRAINT pedidos_pk PRIMARY KEY ,
    cif CHAR(9)                     CONSTRAINT pedidos_nn1 NOT NULL CONSTRAINT pedidos_fk1 REFERENCES EMPRESAS(cif),
    fecha DATE                      CONSTRAINT pedidos_nn2 NOT NULL
);
CREATE TABLE ALMACENES (
    n_almacen NUMBER(2)             CONSTRAINT almacenes_pk PRIMARY KEY ,
    descripcion VARCHAR2(1000)      CONSTRAINT almacenes_nn1 NOT NULL ,
    direccion VARCHAR(100)
);
CREATE TABLE EXISTENCIAS (
    tipo CHAR(2) ,
    modelo NUMBER(2) ,
    n_almacen NUMBER(2)             CONSTRAINT existencias_fk2 REFERENCES ALMACENES(n_almacen),
    cantidad NUMBER(9)              CONSTRAINT existencias_nn1 NOT NULL ,
                                    CONSTRAINT existencias_pk PRIMARY KEY (tipo, modelo, n_almacen),
                                    CONSTRAINT existencias_fk1 FOREIGN KEY (tipo, modelo) REFERENCES PIEZAS(tipo, modelo)
);
CREATE TABLE LINEAS_PEDIDO (
    tipo CHAR(2)                    CONSTRAINT lineas_pedido_nn1 NOT NULL ,
    modelo NUMBER(2)                CONSTRAINT lineas_pedido_nn2 NOT NULL ,
    n_pedido NUMBER(4)              CONSTRAINT lineas_pedido_fk1 REFERENCES PEDIDOS(n_pedido),
    n_linea NUMBER(2) ,
    cantidad NUMBER(5) ,
    precio NUMBER(11,4),
                                    CONSTRAINT lineas_pedido_pk PRIMARY KEY (n_pedido, n_linea),
                                    CONSTRAINT lineas_pediso_fk2 FOREIGN KEY (tipo, modelo) REFERENCES PIEZAS(tipo, modelo)
);
