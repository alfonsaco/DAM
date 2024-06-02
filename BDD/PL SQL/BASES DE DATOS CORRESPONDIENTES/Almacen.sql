
DROP TABLE  suministros cascade constraints;
DROP TABLE  det_compras cascade constraints;
DROP TABLE  compras cascade constraints;
DROP TABLE empleados cascade constraints;
DROP TABLE almacenes cascade constraints;
DROP TABLE articulos cascade constraints;
DROP TABLE proveedores cascade constraints;

purge recyclebin;


CREATE TABLE ALMACENES
(
	CODALMA  number(5) NOT NULL,
	NOMBRE VARCHAR2(20),
	POBLACION VARCHAR2(30),
	FACTURACION  number(10,2),
	PRIMARY KEY (CODALMA)
);


CREATE TABLE ARTICULOS
(
	CODARTI  number(5) NOT NULL,
	DENOMINACION VARCHAR2(20),
	CATEGORIA VARCHAR2(10),
	PVP  number(6,2),
	STOCK  number(5),
	PRIMARY KEY (CODARTI)
);


CREATE TABLE COMPRAS
(
	NUM_COMPRA  number(5) NOT NULL,
	CODALMA  number(5) NOT NULL,
	FECHA DATE,
	PRIMARY KEY (NUM_COMPRA)
);


CREATE TABLE DET_COMPRAS
(
	NUM_COMPRA  number(5) NOT NULL,
	CODARTI  number(5) NOT NULL,
	UNIDADES  number(5),
	PRIMARY KEY (NUM_COMPRA, CODARTI)
);


CREATE TABLE EMPLEADOS
(
	CODEMPLE  number(5) NOT NULL,
	NOMBRE VARCHAR2(20),
	POBLACION VARCHAR2(30),
	FECHAALTA DATE,
	SALARIO  number(6,2),
	CODALMA  number(5) NOT NULL,
	CODJEFE  number(5),
	PRIMARY KEY (CODEMPLE)
);


CREATE TABLE PROVEEDORES
(
	CODPROV  number(5) NOT NULL,
	NOMBRE VARCHAR2(20),
	POBLACION VARCHAR2(30),
	ZONA VARCHAR2(10),
	COMISION  number(5),
	PRIMARY KEY (CODPROV)
);


CREATE TABLE SUMINISTROS
(
	CODPROV  number(5) NOT NULL,
	CODARTI  number(5) NOT NULL,
	PRIMARY KEY (CODPROV, CODARTI)
);



/* Create Foreign Keys */

ALTER TABLE COMPRAS
	ADD FOREIGN KEY (CODALMA)
	REFERENCES ALMACENES (CODALMA)

;


ALTER TABLE EMPLEADOS
	ADD FOREIGN KEY (CODALMA)
	REFERENCES ALMACENES (CODALMA)

;


ALTER TABLE DET_COMPRAS
	ADD FOREIGN KEY (CODARTI)
	REFERENCES ARTICULOS (CODARTI)

;


ALTER TABLE SUMINISTROS
	ADD FOREIGN KEY (CODARTI)
	REFERENCES ARTICULOS (CODARTI)
;


ALTER TABLE DET_COMPRAS
	ADD FOREIGN KEY (NUM_COMPRA)
	REFERENCES COMPRAS (NUM_COMPRA)
;


ALTER TABLE EMPLEADOS
	ADD FOREIGN KEY (CODJEFE)
	REFERENCES EMPLEADOS (CODEMPLE)

;


ALTER TABLE SUMINISTROS
	ADD FOREIGN KEY (CODPROV)
	REFERENCES PROVEEDORES (CODPROV)

;



/* ------------------------------------------------------ */
/* ---------- ENTRADA DE DATOS -------------------------- */
insert into almacenes values (1,'Almacén 1','Madrid', 50000);
insert into almacenes values (2,'Almacén 2','Madrid', 70000);
insert into almacenes values (3,'Almacén 3','Talavera', 80000);
insert into almacenes values (4,'Almacén 4','Sevilla', 40000);
insert into almacenes values (5,'Almacén 5','Sevilla', 55000);
insert into almacenes values (6,'Almacén 6','Madrid', 45000);
insert into almacenes values (7,'Almacén 7','Madrid', 55000);
insert into almacenes values (8,'Almacén 8','Alcalá', 10000);

/* --------------------- artículos ------------------------ */
insert into articulos values (1,'Artic 1','A', 10, 100);
insert into articulos values (2,'Artic 2','B', 15, 150);
insert into articulos values (3,'Artic 3','C', 20, 10);
insert into articulos values (4,'Artic 4','A', 25, 200);
insert into articulos values (5,'Artic 5','A', 30, 70);
insert into articulos values (6,'Artic 6','B', 12, 10);
insert into articulos values (7,'Artic 7','B', 24, 100);
insert into articulos values (8,'Artic 8','C', 15, 80);
insert into articulos values (9,'Artic 9','C', 60, 90);
insert into articulos values (10,'Artic 10','A', 70, 140);
insert into articulos values (11,'Artic 11','C', 60, 90);
insert into articulos values (12,'Artic 12','A', 70, 140);
insert into articulos values (13,'Artic 13','A', 50, 400);


/* --------------------- compras ------------------------ */
/* -- NUM_COMPRA - CODALMA -  FECHA ----------------- */ 

/* -- almacen 1  -- */ 

insert into compras select 1,1, sysdate -5 from dual;
insert into compras select 2,1, sysdate -4 from dual;
insert into compras select 3,1, sysdate -3 from dual;
insert into compras select 4,1, sysdate -1 from dual;

/* -- almacen 2  -- */ 
insert into compras select 5,2, sysdate -5 from dual;
insert into compras select 6,2, sysdate -4 from dual;

/* -- almacen 3  -- */ 
insert into compras select 7,3, sysdate -3 from dual;
insert into compras select 8,3, sysdate -1 from dual;

/* -- almacen 4  -- */ 
insert into compras select 9,4, sysdate -3 from dual;
insert into compras select 10,4, sysdate -1 from dual; 

/* -- almacen 5  -- */ 
insert into compras select 11,5, sysdate -5 from dual;
insert into compras select 12,5, sysdate -1 from dual;

/* -- almacen 6  -- */ 
insert into compras select 13,6, sysdate -5 from dual;
insert into compras select 14,6, sysdate -4 from dual;
insert into compras select 15,6, sysdate -3 from dual;
insert into compras select 16,6, sysdate -2 from dual;
insert into compras select 17,6, sysdate -1 from dual;

/* -- almacen 7 , compra sin detalle -- */ 
insert into compras select 18,7, sysdate -1 from dual;

/* -- ------------------- Detalle compras -------------  -- */ 
/* NUM_COMPRA , CODARTI, UNIDADES  ----------------- */
/* compra 1, almacen 1 */
insert into det_compras values( 1,1,10);
insert into det_compras values( 1,2,8);
insert into det_compras values( 1,3,20);
insert into det_compras values( 1,4,5);
insert into det_compras values( 1,5,15);

/* compra 2, almacen 1 */
insert into det_compras values( 2,2,5);
insert into det_compras values( 2,3,4);
insert into det_compras values( 2,4,10);
insert into det_compras values( 2,5,5);
insert into det_compras values( 2,6,5);
insert into det_compras values( 2,7,8);
insert into det_compras values( 2,8,5);

/* compra 3, almacen 1 */
insert into det_compras values( 3,5,4);
insert into det_compras values( 3,6,10);
insert into det_compras values( 3,7,5);
/* compra 4, almacen 1 */
insert into det_compras values( 4,1,5);
insert into det_compras values( 4,5,4);
insert into det_compras values( 4,6,10);
insert into det_compras values( 4,7,5);

/* -- compra 5 almacen 2  -- */ 
insert into det_compras values( 5,7,5);
insert into det_compras values( 5,8,10);
insert into det_compras values( 5,9,10);
insert into det_compras values( 5,10,15);

/* -- compra 6 almacen 2  -- */ 
insert into det_compras values( 6,3,5);
insert into det_compras values( 6,4,10);
insert into det_compras values( 6,5,10);
insert into det_compras values( 6,6,10);
insert into det_compras values( 6,7,10);
insert into det_compras values( 6,8,10);

/* -- compra 7 almacen 3  -- */ 
insert into det_compras values( 7,1,5);
insert into det_compras values( 7,2,10);
insert into det_compras values( 7,3,10);
insert into det_compras values( 7,10,15);

/* -- compra 8 almacen 3  -- */ 
insert into det_compras values( 8,2,5);
insert into det_compras values( 8,4,10);
insert into det_compras values( 8,5,10);
insert into det_compras values( 8,6,10);
insert into det_compras values( 8,7,10);
insert into det_compras values( 8,8,10);

/* -- compra 9 almacen 4  -- */ 
insert into det_compras values( 9,1,15);
insert into det_compras values( 9,3,10);
insert into det_compras values( 9,5,20);
insert into det_compras values( 9,7,15);
insert into det_compras values( 9,11,15);

/* -- compra 10 almacen 4  -- */ 
insert into det_compras values( 10,2,5);
insert into det_compras values( 10,4,10);
insert into det_compras values( 10,5,10);
insert into det_compras values( 10,6,10);
insert into det_compras values( 10,7,10);
insert into det_compras values( 10,8,15);
insert into det_compras values( 10,9,5);


/* -- compra 11 almacen 5  -- */ 
insert into det_compras values( 11,1,15);
insert into det_compras values( 11,3,10);


/* -- compra 12 almacen 5  -- */ 
insert into det_compras values( 12,1,5);
insert into det_compras values( 12,2,5);
insert into det_compras values( 12,6,8);
insert into det_compras values( 12,4,10);
insert into det_compras values( 12,7,10);
insert into det_compras values( 12,8,15);

/* -- compra 13 almacen 6  -- */ 
insert into det_compras values( 13,2,15);

/* -- compra 14 almacen 6  -- */ 
insert into det_compras values( 14,1,15);
insert into det_compras values( 14,8,10);
insert into det_compras values( 14,9,20);

/* -- compra 15 almacen 6  -- */ 
insert into det_compras values( 15,1,5);
insert into det_compras values( 15,2,5);
insert into det_compras values( 15,6,20);
insert into det_compras values( 15,9,10);
/* -- compra 16 almacen 6  -- */ 
insert into det_compras values( 16,1,15);
insert into det_compras values( 16,2,25);
insert into det_compras values( 16,3,5);
insert into det_compras values( 16,7,5);
insert into det_compras values( 16,8,10);
insert into det_compras values( 16,9,5);
insert into det_compras values( 16,10,15);
insert into det_compras values( 16,11,10);

/* -- compra 17 almacen 6  -- */ 
insert into det_compras values( 17,10,10);
insert into det_compras values( 17,11,10);



/* --------------------- empleados ------------------------ */
/* -- CODEMPLE - NOMBRE - POBLACION- FECHAALTA --SALARIO-----CODALMA-----CODJEFE----- */ 
/* -- almacen 1  -- */ 
insert into empleados 
   select 1,'Empleado 1','Madrid', sysdate -100, 1000, 1, null from dual;
insert into empleados 
   select 2,'Empleado 2','Madrid', sysdate -150, 1200, 1, 1 from dual;
insert into empleados 
   select 3,'Empleado 3','Madrid', sysdate -170, 1250, 1, 1 from dual;
insert into empleados 
   select 4,'Empleado 4','Alcalá de Henares', sysdate -190, 1350, 1, 3 from dual;
 
/* -- almacen 2  -- */ 
  insert into empleados 
   select 5,'Empleado 5','Madrid', sysdate -90, 1000, 2, null from dual;
insert into empleados 
   select 6,'Empleado 6','Coslada', sysdate -130, 1200, 2, 5 from dual;
insert into empleados 
   select 7,'Empleado 7','Madrid', sysdate -150, 1250, 2, 5 from dual;
insert into empleados 
   select 8,'Empleado 8','Alcalá de Henares', sysdate -190, 1350, 2, 5 from dual;
insert into empleados 
   select 9,'Empleado 9','Alcalá de Henares', sysdate -180, 1350, 2, 5 from dual;
   
  /* -- almacen 3  -- */ 
  insert into empleados 
   select 10,'Empleado 10','Talavera', sysdate -90, 1100, 3, null from dual;
insert into empleados 
   select 11,'Empleado 11','Talavera', sysdate -130, 1200, 3, 10 from dual;
insert into empleados 
   select 12,'Empleado 12','Talavera', sysdate -150, 1250, 3, 10 from dual;
insert into empleados 
   select 13,'Empleado 13','Oropesa', sysdate -190, 1350, 3, 10 from dual;
insert into empleados 
   select 14,'Empleado 14','Oropesa', sysdate -130, 1650, 3, 5 from dual;
insert into empleados 
   select 15,'Empleado 15','Talavera', sysdate -140, 1850, 3, 14 from dual;
insert into empleados 
   select 16,'Empleado 16','Talavera', sysdate -130, 1850, 3, 14 from dual;
   
    /* -- almacen 4  -- */ 
  insert into empleados 
   select 17,'Empleado 17','Sevilla', sysdate -90, 1200, 4, null from dual;
insert into empleados 
   select 18,'Empleado 18','Sevilla', sysdate -130, 1200, 4, 17 from dual;
insert into empleados 
   select 19,'Empleado 19','Jaén', sysdate -150, 1250, 4, 17 from dual;

/* --------------------- proveedores ------------------------ */
/* -- CODPROV - NOMBRE - POBLACION- ZONA --COMISION ---- */ 

insert into proveedores values (1,'Proveedor 1', 'Madrid', 'CENTRO', 1000);
insert into proveedores values (2,'Proveedor 2', 'Madrid', 'CENTRO', 1500);
insert into proveedores values (3,'Proveedor 3', 'Sevilla', 'SUR', 1700);
insert into proveedores values (4,'Proveedor 4', 'Toledo', 'CENTRO', 1660);
insert into proveedores values (5,'Proveedor 5', 'Madrid', 'CENTRO', 1500);
insert into proveedores values (6,'Proveedor 6', 'Cadiz', 'SUR', 1600);
insert into proveedores values (7,'Proveedor 7', 'Barcelona', 'CATALUÑA', 1900);
insert into proveedores values (8,'Proveedor 8', 'Madrid', 'CENTRO', 1000);
insert into proveedores values (9,'Proveedor 9', 'Madrid', 'CENTRO', 1500);
insert into proveedores values (10,'Proveedor 10', 'Jaén', 'SUR', 1700);
insert into proveedores values (11,'Proveedor 11', 'Toledo', 'CENTRO', 1600);
insert into proveedores values (12,'Proveedor 12', 'Valencia', 'LEVANTE', 1550);
insert into proveedores values (13,'Proveedor 13', 'Tarragona', 'CATALUÑA', 1670);
insert into proveedores values (14,'Proveedor 14', 'Gerona', 'CATALUÑA', 1800);
insert into proveedores values (15,'Proveedor 15', 'Alicante', 'LEVANTE', 1700);
insert into proveedores values (16,'Proveedor 16', 'Elche', 'LEVANTE', 1500);

/* --------------------- suministros ------------------------ */
/* -- CODPROV - CODARTI -  */ 
/* -- proveedor 1  -- */ 
insert into suministros values( 1,1);
insert into suministros values( 1,2);
insert into suministros values( 1,3);
insert into suministros values( 1,4);
/* -- proveedor 2  -- */ 
insert into suministros values( 2,1);
insert into suministros values( 2,2);
insert into suministros values( 2,3);
insert into suministros values( 2,4);
insert into suministros values( 2,5);
insert into suministros values( 2,6);
insert into suministros values( 2,7);
insert into suministros values( 2,8);

/* -- proveedor 3  -- */ 
insert into suministros values( 3,1);
insert into suministros values( 3,2);
insert into suministros values( 3,3);
insert into suministros values( 3,4);


/* -- proveedor 4  -- */ 
insert into suministros values( 4,5);
insert into suministros values( 4,6);
insert into suministros values( 4,7);
insert into suministros values( 4,8);

/* -- proveedor 5  -- */ 
insert into suministros values( 5,8);
insert into suministros values( 5,9);
insert into suministros values( 5,10);
insert into suministros values( 5,11);

/* -- proveedor 6  -- */ 
insert into suministros values( 6,3);
insert into suministros values( 6,4);
insert into suministros values( 6,5);

/* -- proveedor 7  -- */ 
insert into suministros values( 7,6);
insert into suministros values( 7,7);
insert into suministros values( 7,8);

/* -- proveedor 8  -- */ 
insert into suministros values( 8,1);
insert into suministros values( 8,2);
insert into suministros values( 8,3);

/* -- proveedor 9  -- */ 
insert into suministros values( 9,1);
insert into suministros values( 9,2);
insert into suministros values( 9,3);

/* -- proveedor 10  -- */ 
insert into suministros values( 10,1);

/* -- proveedor 11  -- */ 
insert into suministros values( 11,2);
insert into suministros values( 11,3);

/* -- proveedor 12  -- */ 
insert into suministros values( 12,1);

/* -- proveedor 13  -- */ 
insert into suministros values( 13,12);
insert into suministros values( 13,13);


/* -- proveedor 14  -- */ 
insert into suministros values( 14,11);

/* -- proveedor 15  -- */ 
insert into suministros values( 15,9);
insert into suministros values( 15,10);