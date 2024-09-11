-- 1. Modifica una de las tablas de tu base de datos. Utiliza la estructura de subconsultas para realizar esa modificaci�n. 
---------------------------------------------------------------------------------------------------------------------
-- Con esta modificaci�n, cambiaremos de nombre a 'California' a los equipos los cuales tengan de nombre 'Atlanta', 
-- utilizando una subconsulta
UPDATE EQUIPOS
    SET CIUDAD = 'California'
WHERE NOMBRE_EQUIPO = (
        SELECT NOMBRE_EQUIPO
        FROM EQUIPOS
        WHERE CIUDAD = 'Atlanta');
        

-- 2. Inserta nueva informaci�n en una de tus tablas. 
---------------------------------------------------------------------------------------------------------------------
-- Insertaremos valores en la tabla JUGADORES. Estos valores son Bam, como nombre jugador, Adebayo de apellido. Su 
-- edad ser� 26, su altura de 2.06 y su peso de 116. La posici�n es Ala-Pivot, est� en el equipo de c�digo 3, y su DNI
-- es 65443322L, y el de su mentor 12634789Z.
INSERT INTO JUGADORES
    VALUES ('Bam', 'Adebayo', 26, 'Ala-pivot', 2.06, 116, '12634789Z', 3, '65443322L');


-- 3. Inserta informaci�n en una de tus tablas. Esa informaci�n debe proceder de otras tablas de tu base de datos. 
---------------------------------------------------------------------------------------------------------------------
-- Se insertan valores en la tabla PARTIDOS. Entre ellos, est� el c�digo 2342677901, un 
-- resultado en el partido de 99-77, la fecha actual, y un nombre de estadio, y nombres de equipo provenientes de la 
-- tabla EQUIPOS y PARTIDOS.
INSERT INTO PARTIDOS 
    VALUES ( 
        2342677901,
        '99-77',
        SYSDATE,
        (SELECT ESTADIO FROM PARTIDOS WHERE COD_PARTIDO=2345678901),
        (SELECT NOMBRE_EQUIPO FROM EQUIPOS WHERE CODIGO_EQUIPO=2),
        (SELECT NOMBRE_EQUIPO FROM EQUIPOS WHERE CODIGO_EQUIPO=10));
        

-- 4. Modifica alguna de tus tablas de tu base de datos. Utiliza JOIN (con sentido) para realizar la modificaci�n.
---------------------------------------------------------------------------------------------------------------------
-- Con esto, actualizamos la fecha a 2023-11-15 del partido en el cual juega el jugador con DNI 65478234P. Lo hacemos 
-- a trav�s de una subconsulta y un JOIN
UPDATE PARTIDOS
SET FECHA=TO_DATE('2023-11-15', 'YYYY-MM-DD') 
WHERE COD_PARTIDO IN 
    (SELECT JUEGAN.COD_PARTIDO FROM JUEGAN 
        INNER JOIN PARTIDOS ON JUEGAN.COD_PARTIDO=PARTIDOS.COD_PARTIDO
     WHERE JUEGAN.DNI_JUGADOR='65478234P');


-- 5. Elimina datos de alguna de tus tablas. Para realizar la eliminaci�n utiliza JOIN o la estructura de las subconsultas. 
---------------------------------------------------------------------------------------------------------------------
-- Eliminaremos de la tabla JUGADORES a los jugadores que pertenecen a Miami Heat, a trav�s de una subconsulta, y
-- a trav�s de otra, diremos tami�n que esos jugadores tienen que tener alg�n anillo
DELETE FROM JUGADORES
    WHERE CODIGO_EQUIPO IN 
        (SELECT CODIGO_EQUIPO FROM EQUIPOS WHERE NOMBRE_EQUIPO = 'Utah Jazz')
    AND 
        DNI_JUGADOR IN (SELECT DNI_JUGADOR FROM ANILLOS);
        
        
        
