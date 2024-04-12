-- Esta consulta agrupa los equipos seg�n la conferencia, calcula el n�mero total de campeonatos ganados por cada conferencia y muestra el resultado ordenado de forma descendente.
SELECT conferencia, SUM(num_campeonatos) AS total_campeonatos
FROM EQUIPOS
GROUP BY conferencia
ORDER BY total_campeonatos DESC;


-- Esta consulta agrupa los jugadores seg�n la posici�n, calcula el promedio de la edad de los jugadores en cada posici�n y muestra solo las posiciones cuyo promedio de edad sea mayor a 25.
SELECT Posicion, AVG(Edad_jugador) AS promedio_edad
FROM JUGADORES
GROUP BY Posicion
HAVING AVG(Edad_jugador) > 25;


-- Esta consulta agrupa los integrantes seg�n el puesto, calcula el n�mero total de integrantes en cada puesto y muestra solo los puestos que tienen m�s de 1 integrante.
SELECT Puesto, COUNT(*) AS cantidad_integrantes
FROM INTEGRANTES
GROUP BY Puesto
HAVING COUNT(*) > 1;


-- Esta consulta agrupa los integrantes seg�n la ciudad en la que residen, calcula la cantidad total de integrantes en cada ciudad y muestra solo las ciudades que tienen m�s de 1 integrante.
SELECT Ciudad_integrante, COUNT(*) AS cantidad_integrantes
FROM INTEGRANTES
GROUP BY Ciudad_integrante
HAVING COUNT(*) > 1;


-- Esta consulta agrupa los equipos seg�n la ciudad en la que est�n ubicados, calcula el n�mero total de equipos en cada ciudad y muestra el resultado ordenado de forma descendente por el n�mero de equipos.
SELECT ciudad, COUNT(*) AS total_equipos
FROM EQUIPOS
GROUP BY ciudad
ORDER BY total_equipos DESC;
