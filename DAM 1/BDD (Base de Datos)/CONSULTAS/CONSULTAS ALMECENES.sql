/*1.	Mostrar el nombre (apellidos y nombre) y el correo de los comerciales y el nombre y correo de los proveedores que hayan realizado 
alguna compra o alguna venta.
La salida debe ser sólo dos campos uno para todos los nombres y otro para todos los correos.
NOMBRE     CORREO
------------     ------------- */
(SELECT NOM_COMERCIAL || ' ' || APE_COMERCIAL, EMAIL_COMERCIAL
FROM VENTAS JOIN COMERCIALES USING (COD_COMERCIAL))
UNION 
(SELECT NOM_PROVEEDOR "NOMBRE COMERCIAL-PROVEEDOR", EMAIL_PROVEEDOR
FROM COMPRAS JOIN PROVEEDORES USING(COD_PROVEEDOR));


/*2.	Mostrar el nombre del proveedor, el nombre del producto, las unidades actuales del producto y el nombre del almacén de aquellos 
productos que se encuentren bajo mínimos o hayan caducado. 	*/
SELECT NOM_PROVEEDOR, NOM_PRODUCTO, UNI_ACT_PRODUCTO, NOM_ALMACEN
FROM PRODUCTOS PROD 
                   JOIN COMPRAS C ON (PROD.COD_PRODUCTO = C.COD_PRODUCTO) 
                    JOIN PROVEEDORES PROV ON (PROV.COD_PROVEEDOR=C.COD_PROVEEDOR)
                    JOIN ALMACENES A ON (PROD.COD_ALMACEN= A.COD_ALMACEN)
WHERE PROD.UNI_ACT_PRODUCTO < PROD.UNI_MIN_PRODUCTO OR 
                PROD.FECHA_CAD_PRODUCTO<SYSDATE;


/*3.	Mostrar el nombre del proveedor, el email de proveedores, el nombre del producto y la fecha de compra de los productos que más 
unidades se hayan comprado. 	*/
SELECT NOM_PROVEEDOR, EMAIL_PROVEEDOR, NOM_PRODUCTO, FECHA_COMPRA
FROM   PROVEEDORES JOIN COMPRAS USING (COD_PROVEEDOR)
                                          JOIN PRODUCTOS USING (COD_PRODUCTO)
WHERE COD_PRODUCTO IN (SELECT COD_PRODUCTO
                        FROM COMPRAS
                        GROUP BY COD_PRODUCTO
                        HAVING SUM(UNI_COMPRA) = (SELECT MAX(SUM(UNI_COMPRA)) 
                                                 FROM COMPRAS
                                                 GROUP BY COD_PRODUCTO));


/*4.	Mostrar todos los datos del comercial jefe de más edad. */
SELECT *
FROM COMERCIALES 
WHERE FEC_NAC_COMERCIAL = (SELECT MIN(FEC_NAC_COMERCIAL)
                                                            FROM COMERCIALES 
                                                            WHERE COD_COMERCIAL IN (SELECT COD_COMERCIAL_JEFE 
                                                                                                                  FROM COMERCIALES));


/*5.	Para cada cliente mostrar la venta en la que ha adquirido el producto más caro. De cada cliente mostraremos el nombre y 
apellidos del cliente, también mostraremos el nombre del producto, el precio de venta, las unidades de la venta y la fecha de la venta.*/
SELECT NOM_CLIENTE || ' ' || APE_CLIENTE, NOM_PRODUCTO, PRECIO_VENTA, UNI_VENTA, FECHA_VENTA
FROM PRODUCTOS P JOIN VENTAS V ON (P.COD_PRODUCTO= V.COD_PRODUCTO) 
                                        JOIN CLIENTES C ON(V.COD_CLIENTE=C.COD_CLIENTE)
WHERE PRECIO_VENTA = (SELECT MAX(PRECIO_VENTA) 
                                               FROM VENTAS 
                                               WHERE C.COD_CLIENTE= COD_CLIENTE);


/*6.	Mostrar el nombre del producto, el nombre del almacén y el total de unidades compradas, de aquellos productos que se haya comprado 
un total de unidades menor que la media de las unidades compradas del almacén del que procede el producto.	*/
SELECT NOM_PRODUCTO, NOM_ALMACEN, SUM(UNI_COMPRA)
FROM PRODUCTOS P JOIN COMPRAS C USING (COD_PRODUCTO) 
                                        JOIN ALMACENES USING (COD_ALMACEN)
GROUP BY NOM_PRODUCTO, NOM_ALMACEN
HAVING SUM(UNI_COMPRA) < (SELECT AVG(UNI_COMPRA)
                                                     FROM PRODUCTOS P JOIN COMPRAS C USING(COD_PRODUCTO)
                                                      WHERE P.COD_ALMACEN= COD_ALMACEN);


/*7.	Estamos muy disgustados ya que nos hemos equivocado al poner el precio de venta de los productos del ALMACEN NORTE, del ALMACEN SUR, 
y del ALMACEN ESTE. 	*/
UPDATE VENTAS V SET 
                PRECIO_VENTA = (SELECT PRECIO_PRODUCTO*1.05 
                                                 FROM PRODUCTOS
                                                 WHERE V.COD_PRODUCTO= COD_PRODUCTO)

WHERE COD_PRODUCTO IN (SELECT COD_PRODUCTO 
                                                  FROM PRODUCTOS JOIN ALMACENES USING(COD_ALMACEN)
                                                  WHERE NOM_ALMACEN IN ('ALMACEN NORTE', 'ALMACEN SUR',
                                                 'ALMACEN ESTE'));  