-- 2. Crear el art?culo ?Mantequilla desnatada?, que es fabricada por ?HELIOS?, pesa 300 gramos,
-- es de primera categor?a, lo vendemos a 2,5 ?, lo compramos a 2,25? y tenemos en stock 50
-- unidades. Consideramos que no conocemos el c?digo del fabricante ?HELIOS?, s?lo
-- conocemos su nombre.
INSERT INTO ARTICULOS VALUES 
    ((SELECT MAX(COD_ARTICULO)+1 FROM ARTICULOS), 'HELIOS', 1, 0.3, 'Primera', 2.5, 2.25, 50);

-- 3. A�ade un nuevo fabricante con los datos que t� quieres, de tal forma que el c�digo del
--fabricante, no se repita y sea �ltimo de los c�digos de fabricantes existentes.
INSERT INTO FABRICANTES VALUES (
    (SELECT MAX(COD_FABRICANTE)+1 FROM FABRICANTES), 'DON SIM�N', 'ESPA�A');

-- 4. Realiza hoy un pedido de 100 unidades en la tienda '0001-T' con el art�culo que tenga la
-- venta con mayor n�mero de unidades.
INSERT INTO VENTAS 
    SELECT '0001-T', COD_ARTICULO, SYSDATE, 100
    FROM VENTAS
    WHERE UNIDADES_VENDIDAS>=ALL
        (SELECT UNIDADES_VENDIDAS FROM VENTAS);

-- 5. Insertar un pedido de 100 unidades en la tienda '0001-T' con el art�culo que mayor n�mero
-- de ventas haya realizado.
INSERT INTO PEDIDOS
    SELECT '0001-T', COD_ARTICULO, SYSDATE, 100
    FROM PEDIDOS
    GROUP BY COD_ARTICULO
    HAVING COUNT(*)=
        (SELECT MAX(COUNT(UNIDADES_PEDIDAS)) FROM PEDIDOS
            GROUP BY COD_ARTICULO);
            
-- 6. Programar un pedido para dentro de 15 d�as del art�culo �Mantequilla�, para la tienda �La
-- gacela,� pidiendo un n�mero de unidades igual a la media de unidades vendidas de todos
-- los productos.
INSERT INTO PEDIDOS
VALUES (
    (SELECT COD_TIENDA FROM TIENDAS WHERE INITCAP(NOMBRE) LIKE 'La Gacela'),
    (SELECT COD_ARTICULO FROM ARTICULOS WHERE NOM_ARTICULO LIKE 'Mantequilla'),
    SYSDATE + 15,
    (SELECT AVG (UNIDADES_VENDIDAS) FROM VENTAS)
);
    
-- 7. Queremos programar un pedido, para dentro de una semana, para aquellos art�culos de los
-- que se hayan vendido m�s de 10 unidades. Para estos art�culos realizaremos un pedido de
-- 35 unidades para la tienda con cod_tienda 0006-T.
INSERT INTO PEDIDOS
SELECT '0006-T', COD_ARTICULO, TO_DATE (SYSDATE) + 7, 35
FROM VENTAS
GROUP BY COD_ARTICULO
HAVING SUM (UNIDADES_VENDIDAS) > 10;

-- 8. Ultramarinos Montse quiere trasladar su tienda a la Calle del Pilar,7 de Talavera de la
-- Reina, realiza los cambios necesarios.
UPDATE TIENDAS SET DIRECCION='Calle del Pilar, 7', CODPOSTAL=45600, POBLACION='Talavera de la Reina'
    WHERE NOMBRE LIKE 'Ultramarinos%';
    
-- 9. Cambiar todos los art�culos de 'Primera' categor�a a 'Segunda' categor�a del pa�s 'ITALIA'.
UPDATE ARTICULOS SET CATEGORIA='Segunda'
    WHERE CATEGORIA LIKE 'Primera'
        AND COD_FABRICANTE=
            (SELECT COD_FABRICANTE FROM FABRICANTES WHERE PAIS LIKE 'ITALIA');
            
-- 10. La tienda La Pasta Gansa ha adquirido la tienda Comestibles Rodolfo, de tal forma que deja
-- de existir son sus datos y pasa a tener todos los datos de la tienda La Pasta Gansa.
UPDATE TIENDAS SET 
   (NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL)=
    (SELECT NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL FROM TIENDAS WHERE 
        NOMBRE LIKE 'La Pasta%')
    WHERE NOMBRE LIKE '%Rodolfo';
    
-- 11. Realizar una rebaja del 10% en el precio actual de los art�culos, de aquellos art�culos de los
-- que no se haya realizado ninguna venta.
UPDATE ARTICULOS SET PRECIO_ACTUAL=(PRECIO_ACTUAL*0.90) 
    WHERE COD_ARTICULO NOT IN
        (SELECT COD_ARTICULO FROM VENTAS);
        
-- 12. Modificar las unidades pedidas de aquellos productos en los que las unidades pedidas
-- sean menores que las existencias del art�culo, de tal forma que se pida un 20% menos de
-- las existencias.
UPDATE PEDIDOS P SET UNIDADES_PEDIDAS=
    (SELECT EXISTENCIAS*0.8 FROM ARTICULOS A WHERE A.COD_ARTICULO=P.COD_ARTICULO)
        WHERE UNIDADES_PEDIDAS<
            (SELECT EXISTENCIAS FROM ARTICULOS A WHERE A.COD_ARTICULO=P.COD_ARTICULO);

-- 13. Actualizar las existencias de los art�culos de la tabla ARTICULOS. Consiste en sumar a las
-- existencias del producto, todas las unidades vendidas y restarle todas las unidades
-- pedidas.
UPDATE ARTICULOS A SET EXISTENCIAS=
    (EXISTENCIAS+
    (SELECT NVL(SUM(UNIDADES_VENDIDAS),0) FROM VENTAS V WHERE A.COD_ARTICULO=V.COD_ARTICULO)-
    (SELECT NVL(SUM(UNIDADES_PEDIDAS),0) FROM PEDIDOS P WHERE P.COD_ARTICULO=A.COD_ARTICULO));

-- 14. Crear una nueva tienda en LEON, los dem�s datos puedes poner los que quieras.
-- Ten en cuenta que el c�digo de la tienda est� formado siempre por un valor de cuatro
-- d�gitos XXXX m�s la inicial del nombre de la provincia donde se encuentra la tienda.
-- XXXX-letra
-- En nuestro caso tendremos que calcular XXXX como el siguiente valor al �ltimo c�digo
-- introducido y la letra la a�adiremos como un literal L, ya que la provincia es LE�N.
INSERT INTO TIENDAS
    VALUES ('000' || (SELECT COUNT(*)+1 FROM TIENDAS) || '-L',
            'Tiendas Pacheco','Calle del Santo Grial, n 3','Leon','LEON', 24001);
            
-- 15.Para la tienda anterior, de la que s�lo conocemos su nombre, aprovisiona hoy su almac�n
-- con todos los productos disponibles. De tal forma que pediremos los productos de la
-- siguiente forma:
-- ? 4 veces m�s de la media de las ventas de los productos de primera categor�a.
-- ? 3 veces m�s de la media de las ventas de los productos de segunda categor�a.


-- 16. Borrar todos los fabricantes. �Qu� sucede?
DELETE from FABRICANTES;

-- 17. Eliminar aquellas tiendas que no han realizado ventas
DELETE FROM TIENDAS
    WHERE COD_TIENDA NOT IN
        (SELECT COD_TIENDA FROM VENTAS);
        
-- 18. Borrar los pedidos de los art�culos 'Primera' categor�a cuyo pa�s de procedencia sea
-- 'B�LGICA'.
DELETE FROM PEDIDOS 
    WHERE COD_ARTICULO=
        (SELECT COD_ARTICULO FROM ARTICULOS WHERE CATEGORIA LIKE 'Primera')
    AND COD_ARTICULO=
        (SELECT COD_ARTICULO FROM ARTICULOS WHERE COD_FABRICANTE=
            (SELECT COD_FABRICANTE FROM FABRICANTES WHERE PAIS LIKE 'B�LGICA'));