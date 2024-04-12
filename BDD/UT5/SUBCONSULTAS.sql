-- Esta consulta devuelve todos los jugadores que tienen una altura mayor que la altura promedio de todos los jugadores.
SELECT Nombre_jugador, Altura
FROM JUGADORES
WHERE Altura > (SELECT AVG(Altura) FROM JUGADORES);


-- Esta consulta devuelve los partidos donde al menos uno de los equipos es de la conferencia Este.
SELECT *
FROM PARTIDOS
WHERE equipo_local IN (SELECT nombre_equipo FROM EQUIPOS WHERE conferencia = 'Este')
   OR equipo_visitante IN (SELECT nombre_equipo FROM EQUIPOS WHERE conferencia = 'Este');


-- Esta consulta devuelve los jugadores que no han sido asignados con ningún anillo.
SELECT Nombre_jugador
FROM JUGADORES
WHERE DNI_jugador NOT IN (SELECT DNI_jugador FROM ANILLOS);


-- Consulta: Obtener los nombres de los equipos que tienen jugadores que han ganado al menos un anillo.
SELECT nombre_equipo
FROM EQUIPOS
WHERE codigo_equipo IN (
    SELECT codigo_equipo
    FROM JUGADORES
    WHERE DNI_jugador IN (
        SELECT DNI_jugador
        FROM ANILLOS
    )
);


-- Esta consulta devuelve los nombres de los equipos que han ganado al menos un partido.
SELECT nombre_equipo
FROM EQUIPOS
WHERE codigo_equipo IN (SELECT codigo_equipo FROM JUEGAN);
