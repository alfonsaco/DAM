/*1.	Mostrar el nombre el nombre y los apellidos del turista en un solo campo, el nombre del hotel, el nombre de la agencia, la fecha de 
inicio de la reserva, la fecha de finalización de la reserva y el precio de aquellos turistas que están actualmente alojados en un hotel o 
que todavía no se hayan alojado en su hotel  */
SELECT NOM_TURISTA || ' ' || APE_TURISTA "NOMBRE COMPLETO", H.NOM_HOTEL, A.NOM_AGENCIA, R.FECHA_INICIO, R.FECHA_FIN, R.PRECIO_RESERVA
    FROM TURISTAS T JOIN RESERVAS R ON R.COD_TURISTA=T.COD_TURISTA 
                    JOIN HOTELES H ON H.COD_HOTEL=R.COD_HOTEL
                    JOIN AGENCIAS A ON R.COD_AGENCIA=A.COD_AGENCIA
    WHERE FECHA_INICIO>SYSDATE OR SYSDATE BETWEEN FECHA_INICIO AND FECHA_FIN;


/*2.	Mostrar el nombre del turista, los apellidos del turista, que hayan realizado el tour, que más turistas han realizado. También 
mostraremos el nombre del tour. */
SELECT T.NOM_TURISTA, T.APE_TURISTA, V.NOM_TOUR FROM TURISTAS T
        JOIN REALIZA_TOUR X ON T.COD_TURISTA=X.COD_TURISTA
        JOIN TOURS V ON V.COD_TOUR=X.COD_TOUR
    WHERE V.COD_TOUR IN
        (SELECT X.COD_TOUR FROM REALIZA_TOUR 
            GROUP BY COD_TOUR HAVING COUNT(X.COD_TOUR)=
                (SELECT MAX(COUNT(COD_TOUR)) FROM REALIZA_TOUR GROUP BY COD_TOUR));
    

/*3.	Mostrar los nombre y apellidos de los turistas de aquellos turistas que hayan visitado monumentos de forma particular y hayan 
visitado monumentos realizando algún tour. LOS MONUMENTOS NO TIENE QUE SER LOS MISMO, ES SUFICIENTE CON QUE HAYAN VISITADO MONUMENTOS 
DE FORMA INDIVIDUAL O MEDIANTE UN TOUR. */
SELECT DISTINCT(NOM_TURISTA), APE_TURISTA FROM TURISTAS T 
        JOIN REALIZA_TOUR R ON R.COD_TURISTA=T.COD_TURISTA
        JOIN TOURS TX ON TX.COD_TOUR=R.COD_TOUR
        JOIN MONUMENTOS_TOUR M ON TX.COD_TOUR=M.COD_TOUR;


/*4.	Mostrar los el nombre y apellidos del turista, el nombre de los tours que ha realizado, el nombre y apellidos del guía con el 
que realizaron el tour, el nombre de los monumentos que ha visitado el turista de forma particular (sin realizar un tour) y el nombre 
del hotel en el que se ha alojado, de los turistas que tengan nacionalidad suiza.	*/


5.	Mostrar todos los datos de los guías que tengan como jefe a un guía que haya realizado algún tour en el que se visite el Museo Reina Sofía. 	1.25 Puntos.
Nota: ten en cuenta que Museo Reina Sofía lleva tilde en la tabla de monumentos.

6.	Se quiere promocionar la visita al Museo del prado de los turistas alemanes y belgas, por lo que se le ha ofertado una visita al museo hoy, con un 20% de descuento a los turistas alemanes y un 25% para los turistas belgas del precio de la entrada al monumento, en este caso al museo. La oferta ha sido aceptada por todos los turistas belgas y alemanes. 	1.25 Puntos.
Nota: ten en cuenta que Bélgica lleva tilde en la tabla de turistas.
7.	Se ha producido un error al introducir los precios de las entradas en la tabla de monumentos. Se desea subsanar el error actualizando el precio de entrada al monumento con el precio medio que han pagado los turistas que han visitado ese monumento de forma particular. Si no hay un monumento que ha sido visitado de forma particular, el precio de la entrada será de 100. 	1.25 Puntos.
8.	Borrar los datos de los turistas que no hayan visitado ningún monumento, ni de forma personal, ni mediante un tour y además no hayan realizado ninguna reserva.
