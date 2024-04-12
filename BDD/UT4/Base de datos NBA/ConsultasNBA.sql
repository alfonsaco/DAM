--Una consulta para extraer contenido de inter�s de las tablas con WHERE, con una condici�n
SELECT NOMBRE_JUGADOR, EDAD_JUGADOR FROM JUGADORES WHERE EDAD_JUGADOR>=30 ORDER BY EDAD_JUGADOR ASC;
--Esta consulta nos devolver� el nombre y edad del jugador (en orden ascendente) cuando este sea mayor de 29 a�os

--Una consulta para extraer contenido de inter�s de las tablas con WHERE, de varias condiciones usando operadores l�gicos entre las condiciones
SELECT NOMBRE_JUGADOR, PESO, ALTURA FROM JUGADORES WHERE PESO<100 AND ALTURA BETWEEN 1.85 AND 2.00 ORDER BY ALTURA DESC;
--Esta consulta nos devolver� el peso, nombre y altura del jugador, cuando pese menos de 100kg y mida entre 1,85 y 2 metros. La altura estar�
--ordenada de manera descendente

--Una consulta usando BETWEEN.
SELECT NOMBRE_EQUIPO, CODIGO_EQUIPO FROM EQUIPOS WHERE CODIGO_EQUIPO BETWEEN 0 AND 2 ORDER BY CODIGO_EQUIPO ASC;
--Esta consulta nos devolver� el nombre y el c�digo del equipo, cuando este est� entre 0 y 2, y lo ordenar� de manera ascendente

--Una consulta usando NOT IN.
SELECT * FROM JUGADORES WHERE CODIGO_EQUIPO NOT IN (4,1) ORDER BY CODIGO_EQUIPO DESC;
--Nos devolver� todas las columnas de la tabla jugadores de las filas que no tengan el c�digo equipo 4 y 1. Ordenar� el codigo de manera descendente

--Una consulta usando LIKE con comodines (%, _).
SELECT * FROM EQUIPOS WHERE NOMBRE_EQUIPO LIKE '_ngeles %' ORDER BY NUM_CAMPEONATOS ASC;
--Nos devolver� todas las columnas de equipos cuando el nombre del equipo contenga "ngeles", y lo ordenar� poniendo los numeros de campeontaos de manera
--ascendente

--Una consulta usando operadores aritm�ticos.
SELECT * FROM MASCOTAS WHERE NOMBRE<>'nevado' ORDER BY ID_MASCOTA ASC;
--Nos devolver� todas las columnas de la tabla mascotas cuando el nombre de la mascota sea "nevado", y orden�ndolo poniendo el id de la mascota de manera
--ascendente

--Una consulta de datos usando las funciones de columna MIN, MAX, SUM, AVG y COUNT
SELECT NOMBRE_JUGADOR AS "JUGADOR M�S JOVEN", EDAD_JUGADOR AS "EDAD" FROM JUGADORES WHERE EDAD_JUGADOR=(SELECT MIN(EDAD_JUGADOR) FROM JUGADORES) ORDER BY 1;
--Devolver� la edad m�s baja de los jugadores, junto con su nombre, con el nombre de "jugador m�s joven". Estar� ordenado en base a la primera columna
--seleccionada
SELECT NOMBRE_JUGADOR AS "JUGADOR M�S VIEJO", EDAD_JUGADOR AS "EDAD" FROM JUGADORES WHERE EDAD_JUGADOR=(SELECT MAX(EDAD_JUGADOR) FROM JUGADORES) ORDER BY 1;
--Devolver� la edad m�s alta de los jugadores, junto con su nombre, con el nombre de "jugador m�s viejo". Estar� ordenado en base a la primera columna
--seleccionada
SELECT SUM(PESO) AS "SUMA DE LOS PESOS" FROM JUGADORES WHERE PESO>80 ORDER BY 1;
--Devovler� la suma de todos los pesos de los jugadorers que sean mayores de 80kg, ordenado en base a la primera columna seleccionada
SELECT AVG(ALTURA) AS "ALTURA MEDIA" FROM JUGADORES WHERE EDAD_JUGADOR>=23 ORDER BY 1;
--Devovler� la media de todas las alturas de los jugadorers que tengan m�s de 22 a�os, ordenado en base a la primera columna seleccionada
SELECT COUNT(CIUDAD) AS "N� EQUIPOS DE LOS ANGELES" FROM EQUIPOS WHERE CIUDAD LIKE '%�ngeles' ORDER BY 1;
--Devovler� la cantidad de equipos que hay en Los Angeles, ordenado en base a la primera columna seleccionada