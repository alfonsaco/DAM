/*A)	Mostrar el n�mero, el nombre, tipo y precio de las habitaciones que no se han alquilado nunca. Usar alias en los campos que lo necesiten. 
Formatos:
�	Nombre y tipo, may�sculas. 
�	Precio: con dos decimales y s�mbolo del euro. */
SELECT H.NUMHABITACION "NUMERO HABITACION", UPPER(H.NOMBREHABITACION), UPPER(H.TIPO), TO_CHAR(T.PRECIO,'9999.99L') "PRECIO"
    FROM HABITACIONES H JOIN TIPOSHABITACIONES T ON T.TIPO=H.TIPO
                    WHERE H.NUMHABITACION NOT IN
                        (SELECT NUMHABITACION FROM RESERVAS);


/* B)	Visualizar c�digo, la regi�n y el c�digo postal de los clientes de ESPA�A que se alojaron en habitaciones del tipo Twin. Poner alias en 
los campos que lo necesiten
Formatos:
�	C�digo: alfanum�rico de 4 caracteres, rellenar con 0s a la izquierda. 
�	Regi�n. Si el cliente vive en Madrid, deber� aparecer �MD�. Si vive en Castilla la Mancha, �CLM�. Para cualquier otro valor, �OTROS�.**/ 
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
            
            

/*C)	Visualizar el nombre y apellidos del cliente en UN SOLO CAMPO, el tel�fono y el c�digo postal, la fecha de entrada y la fecha
de salida, el n�mero de habitaci�n que reservaron, el tipo y el precio final (el precio final es el precio de la habitaci�n menos el 
descuento). Recuperar datos solo para clientes ESPA�OLES. Usar alias donde creas que es necesario. */
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

/*E)	Visualizar por cada habitaci�n, su n�mero, su nombre y el n�mero de reservas. Que salgan todas las habitaciones, las que no 
tienen reservas que salgan con 0 reservas. */
SELECT H.NUMHABITACION, H.NOMBREHABITACION, H.TIPO, COUNT(R.NUMHABITACION) "CANTIDAD DE RESERVAS"
    FROM RESERVAS R JOIN HABITACIONES H ON H.NUMHABITACION=R.NUMHABITACION
    GROUP BY H.NUMHABITACION, H.NOMBREHABITACION, H.TIPO
    ORDER BY H.NUMHABITACION; 

--F)	Mostrar los beneficios para cada habitaci�n. Los beneficios de cada reserva se calculan de la siguiente forma: 
--(PRECIO - DESCUENTO)*Numero D�as de alquiler. 
--En el listado debe aparecer el N�mero de la habitaci�n y el beneficio. El beneficio incluir� el s�mbolo del euro y ser� la
--cantidad obtenida redondeada con dos decimales. */
SELECT H.NUMHABITACION, TO_CHAR((T.PRECIO-R.DESCUENTO)*(FECHASALIDA-FECHAENTRADA),'9999.99L') "BENEFICIO" 
    FROM TIPOSHABITACIONES T JOIN HABITACIONES H ON H.TIPO=T.TIPO
                             JOIN RESERVAS R ON H.NUMHABITACION=R.NUMHABITACION;
