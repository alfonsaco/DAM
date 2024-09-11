-- Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT NOMBRE, TO_CHAR(ROUND(PRECIO, 2),'9999.00L') 
    FROM PRODUCTOS;

-- Lista todas las columnas de la tabla producto.
select * FROM PRODUCTOS;

-- Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
SELECT NOMBRE, TO_CHAR(ROUND(PRECIO, 2), '9999.00') || '$' "PRECIO"
    FROM PRODUCTOS;
    
-- Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.
SELECT UPPER(NOMBRE), PRECIO
    FROM PRODUCTOS;
    
-- Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a minúscula.
SELECT LOWER(NOMBRE), PRECIO FROM PRODUCTOS;

-- Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres 
-- del nombre del fabricante.
SELECT NOMBRE_FABRICANTE, SUBSTR(INITCAP(NOMBRE_FABRICANTE),0,3)
    FROM FABRICANTES;
    
-- Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT NOMBRE, ROUND(PRECIO,2) FROM PRODUCTOS;

-- Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna 
-- cifra decimal.
SELECT NOMBRE, TRUNC(PRECIO) "PRECIO"
    FROM PRODUCTOS;

-- Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT CODIGO FROM FABRICANTES WHERE CODIGO IN (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);

SELECT F.CODIGO FROM FABRICANTES F, PRODUCTOS P WHERE F.CODIGO=P.CODIGO_FABRICANTE;

-- Lista el código de los fabricantes que tienen productos en la tabla producto, eliminando los códigos que aparecen repetidos.
SELECT DISTINCT F.CODIGO FROM FABRICANTES F, PRODUCTOS P WHERE P.CODIGO_FABRICANTE=F.CODIGO;

-- Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del precio). Cree un alias para la
-- columna que contiene el precio que se llame céntimos.
SELECT NOMBRE, (PRECIO*100) || ' cents' "PRECIO EN CÉNTIMOS"
    FROM PRODUCTOS;

-- Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE NOMBRE_FABRICANTE LIKE '%w%';

-- Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE NOMBRE_FABRICANTE LIKE '____';
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE LENGTH(NOMBRE_FABRICANTE)=4;

-- Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
SELECT NOMBRE FROM PRODUCTOS WHERE NOMBRE LIKE '%Pórtatil%';

-- Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
SELECT NOMBRE FROM PRODUCTOS WHERE NOMBRE LIKE '%Monitor%' AND PRECIO<215;

-- Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el 
-- precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
SELECT NOMBRE, PRECIO FROM PRODUCTOS 
    WHERE PRECIO>=180
    ORDER BY PRECIO DESC, NOMBRE ASC;
    
-- -- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
SELECT P.NOMBRE, P.PRECIO,F.NOMBRE_FABRICANTE
    FROM PRODUCTOS P, FABRICANTES F WHERE F.CODIGO=P.CODIGO_FABRICANTE;
    
-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado 
-- por el nombre del fabricante, por orden alfabético.
SELECT P.NOMBRE, F.NOMBRE_FABRICANTE, P.PRECIO
    FROM PRODUCTOS P, FABRICANTES F WHERE F.CODIGO=P.CODIGO_FABRICANTE
    ORDER BY NOMBRE_FABRICANTE ASC;
    
SELECT P.NOMBRE, F.NOMBRE_FABRICANTE, P.PRECIO
    FROM PRODUCTOS P INNER JOIN FABRICANTES F ON P.CODIGO_FABRICANTE=F.CODIGO
    ORDER BY NOMBRE_FABRICANTE ASC;
    
-- Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, de todos los productos de
-- la base de datos.
SELECT P.CODIGO, P.NOMBRE, F.CODIGO, F.NOMBRE_FABRICANTE
    FROM PRODUCTOS P, FABRICANTES F WHERE P.CODIGO_FABRICANTE=F.CODIGO;

-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE_FABRICANTE
    FROM PRODUCTOS P INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE
    WHERE P.PRECIO<=
    (SELECT MIN(PRECIO) FROM PRODUCTOS);
    
-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE_FABRICANTE
    FROM PRODUCTOS P INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE
    WHERE P.PRECIO>=
    (SELECT MAX(PRECIO) FROM PRODUCTOS);
    
-- Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT * FROM PRODUCTOS P INNER JOIN FABRICANTES F ON P.CODIGO_FABRICANTE=F.CODIGO
    WHERE F.NOMBRE_FABRICANTE LIKE 'Lenovo';
    
-- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€
SELECT * FROM PRODUCTOS P INNER JOIN FABRICANTES F 
    ON P.CODIGO_FABRICANTE=F.CODIGO
    WHERE F.NOMBRE_FABRICANTE LIKE 'Crucial'
    AND P.PRECIO>200;
    
-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. Sin utilizar el operador IN.
SELECT * FROM PRODUCTOS P INNER JOIN FABRICANTES F 
    ON F.CODIGO=P.CODIGO_FABRICANTE
    WHERE F.NOMBRE_FABRICANTE LIKE 'Asus' OR F.NOMBRE_FABRICANTE LIKE 'Hewlett-Packard' OR F.NOMBRE_FABRICANTE LIKE 'Seagate';
    
SELECT * FROM PRODUCTOS P INNER JOIN FABRICANTES F
    ON P.CODIGO_FABRICANTE=F.CODIGO 
    WHERE F.NOMBRE_FABRICANTE IN('Asus', 'Hewlett-Packard', 'Seagate');
    
-- Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.
SELECT P.NOMBRE, P.PRECIO FROM PRODUCTOS P 
    INNER JOIN FABRICANTES F ON P.CODIGO_FABRICANTE=F.CODIGO
    WHERE F.NOMBRE_FABRICANTE LIKE '%w%';
    
-- Devuelve un listado con el código y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.
SELECT F.CODIGO, F.NOMBRE_FABRICANTE FROM FABRICANTES F 
    WHERE F.CODIGO IN (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);
    
-- Devuelva un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. El listado 
-- deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT * FROM FABRICANTES F LEFT JOIN PRODUCTOS P
    ON F.CODIGO=P.CODIGO_FABRICANTE;
    
-- Devuelva un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT * FROM FABRICANTES F
    LEFT JOIN PRODUCTOS P ON F.CODIGO=P.CODIGO_FABRICANTE
    WHERE NOMBRE_FABRICANTE IS NULL;
    
-- Lista el nombre y el precio del producto más barato.
SELECT NOMBRE, MIN(PRECIO) FROM PRODUCTOS
    WHERE PRECIO=
    (SELECT MIN(PRECIO) FROM PRODUCTOS)
    GROUP BY NOMBRE;
    
-- Calcula la suma de los precios de todos los productos.
SELECT TO_CHAR(ROUND(SUM(PRECIO),2),'9999.00L') "SUMA DE RPECIO" FROM PRODUCTOS;

-- Calcula la media del precio de todos los productos del fabricante Asu
SELECT AVG(P.PRECIO) FROM PRODUCTOS P INNER JOIN FABRICANTES F 
    ON F.CODIGO=P.CODIGO_FABRICANTE WHERE F.NOMBRE_FABRICANTE LIKE 'Asus';
    
-- Calcula el precio más barato de todos los productos del fabricante Asus.
SELECT MIN(P.PRECIO) FROM PRODUCTOS P INNER JOIN FABRICANTES F 
    ON F.CODIGO=P.CODIGO_FABRICANTE WHERE F.NOMBRE_FABRICANTE LIKE 'Asus';
    
-- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
SELECT MAX(P.PRECIO) "PRECIO MÁXIMO", MIN(P.PRECIO) "PRECIO MÍNIMO", AVG(P.PRECIO) "PRECIO MEDIO", SUM(PRECIO) "TOTAL"
    FROM PRODUCTOS P INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE
    WHERE NOMBRE_FABRICANTE LIKE 'Crucial';
    
-- Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen 
-- ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene 
-- el resultado descendentemente por el número de productos.
SELECT F.NOMBRE_FABRICANTE, COUNT(*) FROM FABRICANTES F 
    LEFT JOIN PRODUCTOS P ON F.CODIGO=P.CODIGO_FABRICANTE
    GROUP BY F.NOMBRE_FABRICANTE
    ORDER BY COUNT(*) DESC;
    
-- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior
--a 200€. No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
SELECT P.CODIGO_FABRICANTE, MAX(P.PRECIO), MIN(P.PRECIO), SUM(P.PRECIO) "TOTAL"
    FROM PRODUCTOS P 
    GROUP BY CODIGO_FABRICANTE
    HAVING AVG(P.PRECIO)>200;
    
-- Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes 
-- que tienen un precio medio superior a 200€. Es necesario mostrar el nombre del fabricante.
SELECT F.NOMBRE_FABRICANTE, MAX(P.PRECIO), MIN(P.PRECIO), AVG(P.PRECIO), SUM(P.PRECIO) 
    FROM PRODUCTOS P INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE 
        WHERE P.PRECIO>200
        GROUP BY F.NOMBRE_FABRICANTE;
        
-- Calcula el número de productos que tienen un precio mayor o igual a 180€.
SELECT COUNT(*) FROM PRODUCTOS WHERE PRECIO>=180;
    
-- Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180€
SELECT F.NOMBRE_FABRICANTE, COUNT(*) FROM PRODUCTOS P 
    INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE
        WHERE P.PRECIO>=180
        GROUP BY F.NOMBRE_FABRICANTE;
        
-- Lista el precio medio los productos de cada fabricante, mostrando solamente el código del fabricante.
SELECT CODIGO_FABRICANTE, ROUND(AVG(PRECIO),2) "PRECIO MEDIO" FROM PRODUCTOS
    GROUP BY CODIGO_FABRICANTE;
    
-- Lista el precio medio de los productos de cada fabricante, mostrando solamente el nombre del fabricante.
SELECT F.NOMBRE_FABRICANTE, AVG(P.PRECIO) FROM PRODUCTOS P 
    INNER JOIN FABRICANTES F ON F.CODIGO=P.CODIGO_FABRICANTE
        GROUP BY F.NOMBRE_FABRICANTE;
        
-- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. 
-- No es necesario mostrar el nombre de los fabricantes que no tienen productos que cumplan la condición.
SELECT F.NOMBRE_FABRICANTE, COUNT(*) FROM FABRICANTES F
    INNER JOIN PRODUCTOS P ON F.CODIGO=P.CODIGO_FABRICANTE
        WHERE P.PRECIO>=220
        GROUP BY F.NOMBRE_FABRICANTE;
        
-- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. El 
-- listado debe mostrar el nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene productos con un precio superior o 
-- igual a 220€ deberá aparecer en el listado con un valor igual a 0 en el número de productos.
SELECT F.NOMBRE_FABRICANTE, COUNT(*) FROM FABRICANTES F
    LEFT JOIN PRODUCTOS P ON F.CODIGO=P.CODIGO_FABRICANTE 
        WHERE P.PRECIO>=220
        GROUP BY F.NOMBRE_FABRICANTE;

-- Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. El resultado debe tener tres columnas: nombre del producto, 
-- precio y nombre del fabricante. El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
SELECT P.NOMBRE, F.NOMBRE_FABRICANTE, MAX(P.PRECIO) FROM PRODUCTOS P
    INNER JOIN FABRICANTES F ON P.CODIGO_FABRICANTE=F.CODIGO
        GROUP BY P.NOMBRE, F.NOMBRE_FABRICANTE
        ORDER BY F.NOMBRE_FABRICANTE ASC;
        
-- Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT * FROM FABRICANTES
    WHERE CODIGO=
        (SELECT CODIGO_FABRICANTE FROM PRODUCTOS WHERE NOMBRE LIKE 'Lenovo');
        
-- Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT * FROM PRODUCTOS WHERE PRECIO=
    (SELECT MAX(PRECIO) FROM PRODUCTOS WHERE CODIGO_FABRICANTE=
        (SELECT CODIGO FROM FABRICANTES WHERE NOMBRE_FABRICANTE LIKE 'Lenovo'));
        
-- Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.
SELECT F.NOMBRE_FABRICANTE FROM FABRICANTES F INNER JOIN PRODUCTOS P 
    ON P.CODIGO_FABRICANTE=F.CODIGO 
        GROUP BY F.NOMBRE_FABRICANTE
        HAVING COUNT(*)=(SELECT COUNT(*) FROM FABRICANTES WHERE NOMBRE_FABRICANTE LIKE 'Lenovo');
        
-- Lista el nombre del producto más caro del fabricante Lenovo
SELECT P.NOMBRE FROM PRODUCTOS P INNER JOIN FABRICANTES F
    ON F.CODIGO=P.CODIGO_FABRICANTE WHERE P.PRECIO=
        (SELECT MAX(PRECIO) FROM FABRICANTES WHERE NOMBRE_FABRICANTE LIKE 'Lenovo');
        
-- Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.
SELECT NOMBRE FROM PRODUCTOS WHERE PRECIO>=ALL
    (SELECT PRECIO FROM PRODUCTOS);
    
-- Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.
SELECT NOMBRE FROM PRODUCTOS WHERE PRECIO<=ALL
    (SELECT PRECIO FROM PRODUCTOS);
    
-- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE CODIGO=ANY
    (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);

--Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando ALL o ANY).
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE CODIGO!=ALL
    (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);
    
-- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE CODIGO IN
    (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);
    
-- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE CODIGO NOT IN
    (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);

-- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
SELECT NOMBRE_FABRICANTE FROM FABRICANTES WHERE NOT EXISTS
    (SELECT CODIGO_FABRICANTE FROM PRODUCTOS);