DROP TABLE PRODUCTOS;
DROP TABLE FABRICANTES;

CREATE TABLE FABRICANTES (
    CODIGO NUMBER(10),
    NOMBRE_FABRICANTE VARCHAR2(100),
    PRIMARY KEY(CODIGO)
    );
    
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (1, 'Fabricante A');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (2, 'Fabricante B');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (3, 'Fabricante C');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (4, 'Fabricante D');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (5, 'Fabricante E');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (6, 'Fabricante F');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (7, 'Fabricante G');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (8, 'Fabricante H');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (9, 'Fabricante I');
INSERT INTO FABRICANTES (CODIGO, NOMBRE_FABRICANTE) VALUES (10, 'Fabricante J');

CREATE TABLE PRODUCTOS (
    CODIGO NUMBER(10),
    NOMBRE VARCHAR2(100) NOT NULL,
    PRECIO NUMBER(8,2) NOT NULL,
    CODIGO_FABRICANTE NUMBER(10),
    PRIMARY KEY(CODIGO),
    FOREIGN KEY (CODIGO_FABRICANTE) REFERENCES FABRICANTES(CODIGO)
    );
    
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (1, 'Producto 1', 100.00, 1);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (2, 'Producto 2', 150.00, 2);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (3, 'Producto 3', 75.50, 3);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (4, 'Producto 4', 200.00, 4);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (5, 'Producto 5', 120.00, 5);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (6, 'Producto 6', 90.00, 6);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (7, 'Producto 7', 180.00, 7);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (8, 'Producto 8', 80.00, 8);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (9, 'Producto 9', 300.00, 9);
INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, CODIGO_FABRICANTE) VALUES (10, 'Producto 10', 250.00, 10);

    