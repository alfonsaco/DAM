/*A)	Mostrar el número, el nombre, tipo y precio de las habitaciones que no se han alquilado nunca. Usar alias en los campos que lo necesiten. 
Formatos:
•	Nombre y tipo, mayúsculas. 
•	Precio: con dos decimales y símbolo del euro. */
SELECT H.NUMHABITACION "NUMERO HABITACION", UPPER(H.NOMBREHABITACION), UPPER(H.TIPO), TO_CHAR(T.PRECIO,'9999.99L') "PRECIO"
    FROM HABITACIONES H JOIN TIPOSHABITACIONES T ON T.TIPO=H.TIPO
                    WHERE H.NUMHABITACION NOT IN
                        (SELECT NUMHABITACION FROM RESERVAS);


/* B)	Visualizar código, la región y el código postal de los clientes de ESPAÑA que se alojaron en habitaciones del tipo Twin. Poner alias en 
los campos que lo necesiten
Formatos:
•	Código: alfanumérico de 4 caracteres, rellenar con 0s a la izquierda. 
•	Región. Si el cliente vive en Madrid, deberá aparecer “MD”. Si vive en Castilla la Mancha, “CLM”. Para cualquier otro valor, “OTROS”.**/ 
SELECT TO_CHAR(CODIGOCLIENTE,'0000'), 
    CASE
        WHEN REGION LIKE 'Madrid' THEN 'MD'
        WHEN REGION LIKE '%Mancha' THEN 'CLM'
        ELSE 'OTROS'
        END "REGION",
        CODIGOPOSTAL FROM CLIENTES
    WHERE PAIS LIKE 'ESPA%' AND CODIGOCLIENTE IN
        (SELECT CODIGOCLIENTE FROM RESERVAS WHERE NUMHABITACION IN
            (SELECT NUMHABITACION FROM HABITACIONES WHERE TIPO LIKE 'Twin'));
            
            

/*C)	Visualizar el nombre y apellidos del cliente en UN SOLO CAMPO, el teléfono y el código postal, la fecha de entrada y la fecha
de salida, el número de habitación que reservaron, el tipo y el precio final (el precio final es el precio de la habitación menos el 
descuento). Recuperar datos solo para clientes ESPAÑOLES. Usar alias donde creas que es necesario. */
SELECT C.NOMBRECLIENTE || ' ' || C.APELLIDO "NOMBRE", C.TELEFONO, C.CODIGOPOSTAL, R.FECHAENTRADA, R.FECHASALIDA, R.NUMHABITACION, H.TIPO, 
        TO_CHAR(T.PRECIO-R.DESCUENTO,'9999.99L') "PRECIO FINAL"
    FROM CLIENTES C JOIN RESERVAS R ON C.CODIGOCLIENTE=R.CODIGOCLIENTE
                    JOIN HABITACIONES H ON H.NUMHABITACION=R.NUMHABITACION
                    JOIN TIPOSHABITACIONES T ON T.TIPO=H.TIPO
    WHERE PAIS LIKE '%ESPA%';


/*D)	Visualizar los datos de las habitaciones que menos se han reservado.*/
SELECT *
FROM HABITACIONES
WHERE NUMHABITACION IN (
    SELECT NUMHABITACION
    FROM RESERVAS
    GROUP BY NUMHABITACION
    HAVING COUNT(*) = (
        SELECT MIN(cnt)
        FROM (
            SELECT COUNT(*) AS cnt
            FROM RESERVAS
            GROUP BY NUMHABITACION)));

/*E)	Visualizar por cada habitación, su número, su nombre y el número de reservas. Que salgan todas las habitaciones, las que no 
tienen reservas que salgan con 0 reservas. */
SELECT H.NUMHABITACION, H.NOMBREHABITACION, H.TIPO, COUNT(R.NUMHABITACION) "CANTIDAD DE RESERVAS"
    FROM RESERVAS R JOIN HABITACIONES H ON H.NUMHABITACION=R.NUMHABITACION
    GROUP BY H.NUMHABITACION, H.NOMBREHABITACION, H.TIPO
    ORDER BY H.NUMHABITACION; 

--F)	Mostrar los beneficios para cada habitación. Los beneficios de cada reserva se calculan de la siguiente forma: 
--(PRECIO - DESCUENTO)*Numero Días de alquiler. 
--En el listado debe aparecer el Número de la habitación y el beneficio. El beneficio incluirá el símbolo del euro y será la
--cantidad obtenida redondeada con dos decimales. */
SELECT H.NUMHABITACION, TO_CHAR((T.PRECIO-R.DESCUENTO)*(FECHASALIDA-FECHAENTRADA),'9999.99L') "BENEFICIO" 
    FROM TIPOSHABITACIONES T JOIN HABITACIONES H ON H.TIPO=T.TIPO
                             JOIN RESERVAS R ON H.NUMHABITACION=R.NUMHABITACION;
