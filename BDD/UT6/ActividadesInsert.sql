/*1. Crear un fabricante con el código de fabricante, 50, nombre ‘HELIOS’, que tiene su sede en
España. Realiza la inserción indicando los nombres de los campos y sin indicar el nombre de
los campos que se van a insertar.*/


/*2. Crear el artículo “Mantequilla desnatada”, que es fabricada por ‘HELIOS’, pesa 300 gramos,
es de primera categoría, lo vendemos a 2,5 €, lo compramos a 2,25€ y tenemos en stock 50
unidades. Consideramos que no conocemos el código del fabricante ‘HELIOS’, sólo
conocemos su nombre.*/


/*3. Añade un nuevo fabricante con los datos que tú quieres, de tal forma que el código del
fabricante, no se repita y sea último de los códigos de fabricantes existentes.*/
INSERT INTO FABRICANTES
VALUES ((SELECT MAX (COD_FABRICANTE) + 1 FROM FABRICANTES), 'GALLINA BLANCA', 'ESPAÑA');

/*4. Realiza hoy un pedido de 100 unidades en la tienda '0001-T' con el artículo que tenga la
venta con mayor número de unidades.*/
INSERT INTO PEDIDOS
SELECT '0001-T', COD_ARTICULO, SYSDATE, 100
FROM VENTAS
WHERE UNIDADES_VENDIDAS = (SELECT MAX (UNIDADES_VENDIDAS)
FROM VENTAS);

/*5. Insertar un pedido de 100 unidades en la tienda '0001-T' con el artículo que mayor número
de ventas haya realizado.*/
INSERT INTO PEDIDOS
SELECT '0001-T', COD_ARTICULO, SYSDATE, 20
        FROM VENTAS
        GROUP BY COD_ARTICULO
        HAVING COUNT (*) = (SELECT MAX (COUNT (UNIDADES_VENDIDAS))
                    FROM VENTAS
                    GROUP BY COD_ARTICULO);

/*6. Programar un pedido para dentro de 15 días del artículo ‘Mantequilla’, para la tienda ‘La
gacela,’ pidiendo un número de unidades igual a la media de unidades vendidas de todos
los productos.*/
INSERT INTO PEDIDOS
VALUES (
    (SELECT COD_TIENDA FROM TIENDAS WHERE INITCAP(NOMBRE) LIKE 'La Gacela'),
    (SELECT COD_ARTICULO FROM ARTICULOS WHERE NOM_ARTICULO LIKE 'Mantequilla'),
    SYSDATE + 15,
    (SELECT AVG (UNIDADES_VENDIDAS) FROM VENTAS)
);

/*7. Queremos programar un pedido, para dentro de una semana, para aquellos artículos de los
que se hayan vendido más de 10 unidades. Para estos artículos realizaremos un pedido de
35 unidades para la tienda con cod_tienda 0006-T.*/
INSERT INTO PEDIDOS
SELECT '0006-T', COD_ARTICULO. TO_DATE (SYSDATE) + 7, 35
FROM VENTAS
GROUP BY COD_ARTICULO
HAVING SUM (UNIDAES_VENDIDAS) > 10;

/*8. Ultramarinos Montse quiere trasladar su tienda a la Calle del Pilar,7 de Talavera de la
Reina, realiza los cambios necesarios.*/
UPDATE TIENDAS SET DIRECCION = 'C. Pilar, 7', POBLACION = 'Talavera de la Reina', CODPOSTAL = 45600
WHERE NOMBRE LIKE 'Ultramarinos Montse';

--9. Cambiar todos los artículos de 'Primera' categoría a 'Segunda' categoría del país 'ITALIA'.
UPDATE ARTICULOS SET CATEGORIA='Segunda'
WHERE CATEGORIA = 'Primera' AND
    COD_FABRICANTE IN (SELECT COD_FABRICANTE
        FROM FABRICANTES
        WHERE UPPER(PAIS)='ITALIA');

/*10. La tienda La Pasta Gansa ha adquirido la tienda Comestibles Rodolfo, de tal forma que deja
de existir son sus datos y pasa a tener todos los datos de la tienda La Pasta Gansa.*/
UPDATE TIENDAS
SET (NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL)
    = (SELECT NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL
        FROM TIENDAS
        WHERE NOMBRE LIKE 'La Pasta Gansa')
WHERE NOMBRE LIKE 'Comestibles Rodolfo';

/*11. Realizar una rebaja del 10% en el precio actual de los artículos, de aquellos artículos de los
que no se haya realizado ninguna venta.*/
UPDATE ARTICULOS SET PRECIO_ACTUAL = PRECIO_ACTUAL *0.9
WHERE COD_ARTICULO NOT IN (SELECT COD_ARTICULO FROM VENTAS);

/*12. Modificar las unidades pedidas de aquellos productos en los que las unidades pedidas
sean menores que las existencias del artículo, de tal forma que se pida un 20% menos de
las existencias.*/
UPDATE PEDIDOS P SET UNIDADES_PEDIDAS = 
(SELECT EXISTENCIAS * 0.80
FROM ARTICULOS
WHERE COD_ARTICULO = P.COD_ARTICULO)
WHERE UNIDADES_PEDIDAS > 
    (SELECT EXISTENCIAS
    FROM ARTICULOS
    WHERE COD_ARTICULO = P.COD_ARTICULO);

/*13. Actualizar las existencias de los artículos de la tabla ARTICULOS. Consiste en sumar a las
existencias del producto, todas las unidades vendidas y restarle todas las unidades
pedidas.*/
UPDATE ARTICULOS A SET EXISTENCIAS = EXISTENCIAS 
    +
    (SELECT NVL (SUM (UNIDADES_VENDIDAS), 0)
    FROM VENTAS
    WHERE COD_ARTICULO = A.COD_ARTICULO)
    -
    (SELECT NVL (SUM(UNIDADES_PEDIDAS) , 0)
    FROM PEDIDOS
    WHERE COD_ARTICULO = A.COD_ARTICULO);

/*14. Crear una nueva tienda en LEON, los demás datos puedes poner los que quieras.
Ten en cuenta que el código de la tienda está formado siempre por un valor de cuatro
dígitos XXXX más la inicial del nombre de la provincia donde se encuentra la tienda.
    XXXX-letra
En nuestro caso tendremos que calcular XXXX como el siguiente valor al último código
introducido y la letra la añadiremos como un literal L, ya que la provincia es LEÓN.*/
INSERT INTO TIENDAS
VALUES ((SELECT TRIM(TO_CHAR(MAX (SUBSTR(COD_TIENDA,1,INSTR(COD_TIENDA,'-')-1))+1, '0000')) || '-L' FROM TIENDAS),
    'Huevería Ferretería el Martillo', 'C. Leopoldo Panero, 4', 'LEÓN', 'LEÓN', 24001);

/*15.Para la tienda anterior, de la que sólo conocemos su nombre, aprovisiona hoy su almacén
con todos los productos disponibles. De tal forma que pediremos los productos de la
siguiente forma:
? 4 veces más de la media de las ventas de los productos de primera categoría.
? 3 veces más de la media de las ventas de los productos de segunda categoría.
? 2 veces más de la media de las ventas de los productos de tercera categoría.*/
INSERT INTO PEDIDOS
    (SELECT
SELECT COD_TIENDA FROM TIENDAS WHERE NOMBRE LIKE 'HUEVERÍA FERRETERÍA DEL MARTILLO'),
    COD_ARTICULO,
    SYSDATE,
    DECODE (CATEGORIA,
'Primera',
(SELECT AVG(UNIDADES_VENDIDAS) * 4
FROM VENTAS JOIN ARTICULOS USING (COD_ARTICULO)
WHERE CATEGORIA LIKE 'Primera'),
'Segunda',
    (SELECT AVG(UNIDADES_VENDIAS) * 3
    FROM VENTAS JOIN ARTICULOS USING (COD_ARTICULO)
    WHERE CATEGORIA LIKE 'Segunda'),
'Tercera',
    (SELECT AVG(UNIDADES_VENDIDAS) * 2
    FROM VENTAS JOIN ARTICULOS USING (COD_ARTICULO)
    WHERE CATEGORIA LIKE 'Tercera')

FROM ARTICULOS);

--16. Borrar todos los fabricantes. ¿Qué sucede?
--No se puede
--17. Eliminar aquellas tiendas que no han realizado ventas.
DELETE FROM TIENDAS WHERE COD_TIENDA NOT IN 
(SELECT DISTINCT COD_TIENDA FROM VENTAS);

/*18. Borrar los pedidos de los artículos 'Primera' categoría cuyo país de procedencia sea
'BÉLGICA'.*/
DELETE FROM PEDIDOS 
WHERE COD_ARTICULO IN 
    (SELECT COD_ARTICULO
    FROM FABRICANTES JOIN ARTICULOS USING (COD_FABRICANTE)
    WHERE PAIS='BÉLGICA' AND CATEGORIA = 'Primera');


    

