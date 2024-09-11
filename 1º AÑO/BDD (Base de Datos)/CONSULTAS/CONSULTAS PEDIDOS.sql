/*CONSULTA 1:
	Mostrar de la tabla de pedidos la siguiente información para los pedidos que se entregaron en menos de 30 días en 2018.
•	Número:"Numero de Pedido".
•	Fecha:"Fecha de compra".
•	Gastos de envío:"Gastos de envío".2 dígitos parte entera y 2 parte decimal.Punto como separador decimal.Mostar símbolo del euro. 
•	Total como "Importe pedido".2 dígitos para la parte decimal. Mostrar el símbolo del euro. Usar los dígitos que sean necesario para la parte
entera. Todos los datos deben tener la misma longitud.             
*/
SELECT NUM "NUMERO DE PEDIDO", FECHA "FECHA COMPRA", TO_CHAR(GASTOS_ENVIO,'99.99L') "GASTOS DE ENVÍO", TO_CHAR(TOTAL,'999.99L')"IMPORTE PEDIDO" FROM PEDIDOS
    WHERE FECHA_PREVISTA-FECHA<30 AND FECHA LIKE '%/%/18';


/*CONSULTA 2:
	Mostrar el número de unidades que se han vendido de cada producto y el total. Ordenar por producto.  Del producto solo hay que mostar el
    código. Deberá aparecer:
*/
SELECT PRODUCTO, SUM(CANTIDAD) "SUMA", TO_CHAR(SUM(IMPORTE),'9999.99L') "TOTAL" FROM LINEAS
GROUP BY PRODUCTO ORDER BY PRODUCTO;


/*CONSULTA 3:
	Mostrar  Código, nombre y precio con un incremento del 20% para todos los productos con códigos comprendidos entre el 10002 y el 30002.
    Ordenar ascendentemente por código. (Poner alias en los campos)
•	Nombre en letras capitales sin espacios.
•	Precio: 2 dígitos para la parte entera (sin ceros) y dos para la decimal (con ceros). Separador decimal: coma. Símbolo del euro.
*/
SELECT CODIGO, TRIM(INITCAP(NOMBRE)), TO_CHAR(PRECIO*1.20,'9999.00L') "PRECIO INCREMENTADO" FROM PRODUCTOS
    WHERE CODIGO BETWEEN 10002 AND 30002
    ORDER BY CODIGO ASC;


/*CONSULTA 4:
	Nombre, primer apellido y segundo apellido (por separado), en letra capital de los clientes que son mayores de edad.  
Usar como alias de los campos “Nombre”, “Primer Apellido” y “Segundo Apellido” respectivamente. No deben aparecer espacios en blanco. */
SELECT TRIM(INITCAP(NOMBRE)), TRIM(INITCAP(SUBSTR(APELLIDOS, 1, INSTR(APELLIDOS,' ')-1))) AS "PRIMER APELLIDO", TRIM(INITCAP(SUBSTR(APELLIDOS, 1, INSTR(APELLIDOS,' ')-1))) AS "SEGUNDO APELLIDO"
    FROM CLIENTES WHERE EDAD>18;

/*CONSULTA 5 (Subconsulta):
	Seleccionar el número de pedido, la fecha, la fecha prevista de entrega y el total (mostar símbolo del euro) de los pedidos de clientes 
    nacidos entre 1980 y 1995 que no han sido entregados todavía. */
SELECT NUM, FECHA, FECHA_PREVISTA, TO_CHAR(TOTAL,'9999.99L') "TOTAL" FROM PEDIDOS
    WHERE CLIENTE=ANY
        (SELECT CODIGO FROM CLIENTES WHERE EDAD BETWEEN 29 AND 44);
        

/*CONSULTA 6(Multitabla):
	Código, nombre y número total de pedidos de los clientes que han       realizado más de un pedido. Ordena el resultado de tal manera que 
    salgan primero los clientes que han realizado más pedidos. Realiza la consulta con join y sin join. */
SELECT CODIGO, NOMBRE, COUNT(P.NUM) FROM CLIENTES C
    INNER JOIN PEDIDOS P ON P.CLIENTE=C.CODIGO
GROUP BY CODIGO, NOMBRE
    HAVING COUNT(P.NUM)>1
ORDER BY COUNT(P.NUM) DESC;


/*CONSULTA 7 (Subconsulta):
	Realiza una consulta que muestre el código, el nombre y el precio del producto más vendido.  */
SELECT CODIGO, NOMBRE, PRECIO FROM PRODUCTOS
    WHERE CODIGO=
        (SELECT PRODUCTO FROM LINEAS
            GROUP BY PRODUCTO HAVING SUM(CANTIDAD)>ANY
                (SELECT SUM(CANTIDAD) FROM LINEAS));


/*CONSULTA 8 (Subconsulta):
	Mostrar el código del producto, el nombre, el precio y los gastos de envío estimados para todos los productos que hayan sido vendidos alguna vez. Los gastos estimados se calcularán en función del artículo y el precio del mismo:
•	Para todos los pantalones, un 10% del precio de venta. 
•	Para todos los vestidos, un 5% del precio de venta
•	Para el resto, gratuitos. (Redondear al entero más cercano arriba) */
SELECT P.CODIGO, P.NOMBRE, P.PRECIO, (SELECT GASTOS_ENVIO FROM PEDIDOS WHERE NUM=
                                        (SELECT NUM_PEDIDO FROM LINEAS WHERE PRODUCTO=
                                            (SELECT CODIGO FROM PRODUCTOS)))
    FROM PRODUCTOS P
    WHERE P.CODIGO=
        (SELECT L.PRODUCTO FROM LINEAS L WHERE L.NUM_PEDIDO=
            (SELECT X.NUM FROM PEDIDOS X));


/*CONSULTA 9 (Subconsulta):
	Obtener todos los artículos (codigo, nombre y precio) que ha comprado 'Jose Luis Garcia Sanchez'.
Realizar con Subconsultas.  */
SELECT CODIGO, NOMBRE, PRECIO FROM PRODUCTOS
    WHERE CODIGO IN
        (SELECT PRODUCTO FROM LINEAS WHERE NUM_PEDIDO IN
            (SELECT NUM FROM PEDIDOS WHERE CLIENTE IN
                (SELECT CODIGO FROM CLIENTES WHERE NOMBRE LIKE 'Jose Luis%' AND APELLIDOS LIKE '%Garcia Sa%')));


/*CONSULTA 10 (Multitabla):
	Obtener nombre completo del cliente, el número de pedido y el total del pedido con importe más bajo realizado por el cliente más joven.*/
SELECT C.NOMBRE || ' ' || C.APELLIDOS "NOMBRE COMPLETO", P.NUM, P.TOTAL
    FROM CLIENTES C JOIN PEDIDOS P ON P.CLIENTE=C.CODIGO
WHERE C.EDAD=
    (SELECT MIN(EDAD) FROM CLIENTES);


/*CONSULTA EXTRA 11:
	Mostrar en el siguiente orden: el nombre del cliente, sus apellidos, el número del pedido, el número de línea, el nombre del producto, la
    cantidad, el precio del artículo y el importe total del PEDIDO DE MÁS VALOR. */
SELECT C.NOMBRE, C.APELLIDOS, P.NUM, L.NUM, X.NOMBRE, L.CANTIDAD, X.PRECIO, L.IMPORTE
    FROM CLIENTES C JOIN PEDIDOS P ON C.CODIGO=P.CLIENTE
                    JOIN LINEAS L ON P.NUM=L.NUM_PEDIDO
                    JOIN PRODUCTOS X ON X.CODIGO=L.PRODUCTO
WHERE PRECIO>=ALL
    (SELECT MAX(PRECIO) FROM PRODUCTOS);
