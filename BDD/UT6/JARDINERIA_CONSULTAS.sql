-- Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
SELECT CODIGO_OFICINA, CIUDAD FROM OFICINAS;

-- Devuelve un listado con la ciudad y el tele?fono de las oficinas de España.
SELECT CIUDAD, TELEFONO FROM OFICINAS 
    WHERE PAIS LIKE 'España';
    
-- Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
SELECT NOMBRE, APELLIDO1, APELLIDO2, EMAIL FROM EMPLEADOS
    WHERE CODIGO_JEFE=7;
    
-- Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
SELECT PUESTO, NOMBRE, APELLIDO1, APELLIDO2, EMAIL FROM EMPLEADOS WHERE CODIGO_EMPLEADO=CODIGO_JEFE;

-- Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
SELECT NOMBRE, APELLIDO1, APELLIDO2, PUESTO FROM EMPLEADOS
    WHERE PUESTO NOT LIKE '%Ventas%';
    
-- Devuelve un listado con el nombre de los todos los clientes espan?oles.
SELECT NOMBRE_CLIENTE FROM CLIENTES
    WHERE PAIS LIKE 'España';
    
-- Devuelve un listado con los distintos estados por los que puede pasar un pedido.
SELECT DISTINCT ESTADO FROM PEDIDOS;

-- Devuelve un listado con el co?digo de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar 
--aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
--Utilizando la función YEAR de MySQL.
--Utilizando la función DATE_FORMAT de MySQL.
--Sin utilizar ninguna de las funciones anteriores.
SELECT DISTINCT C.CODIGO_CLIENTE FROM CLIENTES C INNER JOIN
    PAGO P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE WHERE P.FECHA_PAGO LIKE '%2008%';
    
-- Devuelve un listado con el código de pedido, co?digo de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
SELECT CODIGO_PEDIDO, CODIGO_CLIENTE, FECHA_ESPERADA, FECHA_ENTREGA FROM PEDIDOS
    WHERE FECHA_ENTREGA>FECHA_ESPERADA;    

-- Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
SELECT * FROM PEDIDOS WHERE FECHA_ENTREGA LIKE '%2009%' AND ESTADO LIKE 'Rechazado';

-- Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
SELECT * FROM PEDIDOS WHERE MONTH(FECHA_ENTREGA)=1;

-- Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
SELECT DISTINCT FORMA_PAGO FROM PAGO;

-- Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
SELECT C.NOMBRE_CLIENTE, E.NOMBRE, E.APELLIDO1 FROM CLIENTES C 
    INNER JOIN EMPLEADOS E ON E.CODIGO_EMPLEADO=C.CODIGO_EMPLEADO_REP_VENTAS;
    
-- Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
SELECT C.NOMBRE_CLIENTE, E.CODIGO_EMPLEADO FROM CLIENTES C
    INNER JOIN EMPLEADOS E ON E.CODIGO_EMPLEADO=c.codigo_empleado_rep_ventas 
    INNER JOIN PAGO P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE;
    
-- Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que
--pertenece el representante.
SELECT C.NOMBRE_CLIENTE, E.NOMBRE, O.CIUDAD
    FROM CLIENTES C
    INNER JOIN OFICINAS O ON O.CIUDAD=C.CIUDAD
    INNER JOIN EMPLEADOS E ON E.CODIGO_EMPLEADO=C.CODIGO_EMPLEADO_REP_VENTAS
    INNER JOIN PAGO P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE;
    
-- Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la 
-- que pertenece el representante.
SELECT C.NOMBRE_CLIENTE, E.NOMBRE, O.CIUDAD FROM CLIENTES C
    INNER JOIN EMPLEADOS E ON E.CODIGO_EMPLEADO=c.codigo_empleado_rep_ventas
    INNER JOIN OFICINAS O ON O.CIUDAD=C.CIUDAD
    INNER JOIN PAGO P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
    WHERE P.CODIGO_CLIENTE IN NULL;
    
-- Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
SELECT O.LINEA_DIRECCION1, O.LINEA_DIRECCION2 FROM CLIENTES C 
    INNER JOIN OFICINAS O ON C.CIUDAD=O.CIUDAD
    WHERE O.CIUDAD LIKE 'Fuenlabrada';
    
-- Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
SELECT C.NOMBRE_CLIENTE, E.NOMBRE, O.CIUDAD FROM EMPLEADOS E
    INNER JOIN OFICINAS O ON E.CODIGO_OFICINA=O.CODIGO_OFICINA
    INNER JOIN CLIENTES C ON E.CODIGO_EMPLEADO=c.codigo_empleado_rep_ventas;
    
-- Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
SELECT E.NOMBRE, U.NOMBRE "NOMBRE JEFE"
    FROM EMPLEADOS E INNER JOIN EMPLEADOS U ON E.CODIGO_JEFE=U.CODIGO_EMPLEADO;

-- Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
SELECT C.NOMBRE_CLIENTE FROM CLIENTES C 
    INNER JOIN PEDIDOS P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
    WHERE P.ESTADO LIKE 'Retrasado';
    
-- Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
SELECT P.GAMA FROM CLIENTES C
    INNER JOIN PEDIDOS P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
    INNER JOIN DETALLE_PEDIDO X ON X.CODIGO_PEDIDO=P.CODIGO_PEDIDO
    INNER JOIN PRODUCTOS P ON P.CODIGO_PRODUCTO=X.CODIGO_PRODUCTO;

-- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT * FROM CLIENTES C
    LEFT JOIN PAGO P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
    WHERE P.CODIGO_CLIENTE IS NULL;
    
-- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
SELECT * FROM CLIENTES C 
    LEFT JOIN PEDIDOS P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
        WHERE P.CODIGO_CLIENTE IS NULL;
        
-- Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
SELECT * FROM CLIENTES C
    LEFT JOIN PEDIDOS P ON P.CODIGO_CLIENTE=C.CODIGO_CLIENTE
    LEFT JOIN PAGO X ON X.CODIGO_CLIENTE=C.CODIGO_CLIENTE
        WHERE P.CODIGO_CLIENTE IS NULL AND X.CODIGO_CLIENTE IS NULL;
    
-- Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
SELECT * FROM EMPLEADOS E
    LEFT JOIN OFICINAS O ON E.CODIGO_OFICINA=O.CODIGO_OFICINA
        WHERE O.CODIGO_OFICINA IS NULL;
        
-- Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina 
--donde trabajan.
SELECT * FROM EMPLEADOS E
    INNER JOIN OFICINAS O ON E.CODIGO_OFICINA=O.CODIGO_OFICINA
    LEFT JOIN CLIENTES C ON E.CODIGO_EMPLEADO=C.CODIGO_EMPLEADO_REP_VENTAS;
    
-- Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
SELECT * FROM EMPLEADOS E
    LEFT JOIN OFICINAS O ON O.CODIGO_OFICINA=E.CODIGO_OFICINA
    LEFT JOIN CLIENTES C ON e.codigo_empleado=c.codigo_empleado_rep_ventas
    WHERE O.CODIGO_OFICINA IS NULL AND c.codigo_empleado_rep_ventas IS NULL;

--Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción
--y la imagen del producto.
SELECT P.NOMBRE, P.DESCRIPCION FROM PRODUCTOS P
    LEFT JOIN DETALLE_PEDIDO X ON P.CODIGO_PRODUCTO=X.CODIGO_PRODUCTO
    LEFT JOIN PEDIDOS J ON X.CODIGO_PEDIDO=J.CODIGO_PEDIDO
        WHERE J.CODIGO_PEDIDO IS NULL;
    
-- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya
-- realizado la compra de algún producto de la gama Frutales.
SELECT O.CODIGO_POSTAL, O.CODIGO_OFICINA, O.CIUDAD
    FROM OFICINAS O
    LEFT JOIN EMPLEADOS E ON O.CODIGO_OFICINA=E.CODIGO_OFICINA
    LEFT JOIN CLIENTES C ON E.CODIGO_EMPLEADO=c.codigo_empleado_rep_ventas
    LEFT JOIN PEDIDOS P ON C.CODIGO_CLIENTE=P.CODIGO_CLIENTE
    LEFT JOIN DETALLE_PEDIDO X ON P.CODIGO_PEDIDO=X.CODIGO_PEDIDO
    LEFT JOIN PRODUCTOS J ON X.CODIGO_PRODUCTO=J.CODIGO_PRODUCTO
        WHERE J.GAMA LIKE 'Frutales' AND E.CODIGO_OFICINA IS NULL;
        
-- ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
SELECT ESTADO, COUNT(ESTADO) FROM PEDIDOS
    GROUP BY ESTADO
    ORDER BY ESTADO DESC;
    
-- Devuelve el nombre de los representantes de ventas y el nu?mero de clientes al que atiende cada uno.
SELECT E.NOMBRE, COUNT(*) FROM EMPLEADOS E
    INNER JOIN CLIENTES C ON E.CODIGO_EMPLEADO=c.codigo_empleado_rep_ventas
    GROUP BY E.NOMBRE;