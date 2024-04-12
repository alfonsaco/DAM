--1. Aumentar el salario de todos los profesores en un 5%.
UPDATE PERSONAL
SET SALARIO = SALARIO * 1.5
WHERE FUNCION = 'PROFESOR';

--2. Cambiar la especialidad de un profesor específico.
UPDATE PROFESORES
SET ESPECIALIDAD = 'CIENCIAS'
WHERE DNI = 4123005;

--3. Cambiar el número de plazas de un centro educativo.
UPDATE CENTROS
SET NUM_PLAZAS = 600
WHERE COD_CENTRO = 10;

--4. Actualizar el número de teléfono de un centro educativo.
UPDATE CENTROS
SET TELEFONO = '965-887655'
WHERE COD_CENTRO = 10;

--5. Cambiar la función de un personal de administración a profesor.
UPDATE PERSONAL 
SET FUNCION = 'PROFESOR'
WHERE DNI = 4480099;

--6. Incrementar el salario en un 10% para todos los profesores que trabajan en centros con más de 300 plazas:
UPDATE PERSONAL
SET SALARIO = SALARIO * 1.1
WHERE FUNCION = 'PROFESOR' AND COD_CENTRO IN
(SELECT COD_CENTRO
FROM CENTROS
WHERE NUM_PLAZAS > 300
);


--7. Disminuir el salario en un 5% para todos los profesores de matemáticas.
UPDATE PERSONAL
SET SALARIO = SALARIO * 0.95
WHERE FUNCION = 'PROFESOR' AND DNI IN (
    SELECT DNI
    FROM PROFESORES
    WHERE ESPECIALIDAD = 'MATEMÁTICAS'
);

--8. Aumentar el salario en un 8% para los administrativos que tienen un salario menor que la media de los salarios de los administrativos.
UPDATE PERSONAL
SET SALARIO = SALARIO * 1.08
WHERE FUNCION = 'ADMINISTRATIVO' AND SALARIO < (
    SELECT AVG(SALARIO)
    FROM PERSONAL
    WHERE FUNCION = 'ADMINISTRATIVO'
);

--9. Cambiar la especialidad de los profesores de lengua a literatura si trabajan en centros de tipo "S" (Secundaria).
UPDATE PROFESORES
SET ESPECIALIDAD = 'LITERATURA'
WHERE ESPECIALIDAD = 'LENGUA' AND COD_CENTRO IN (
    SELECT COD_CENTRO
    FROM CENTROS
    WHERE TIPO_CENTRO = 'S'
);

--10. Reducir el número de plazas en un 10% para todos los centros que tienen más de 500 plazas.
UPDATE CENTROS
SET NUM_PLAZAS = NUM_PLAZAS * 0.9
WHERE COD_CENTRO IN (
    SELECT COD_CENTRO
    FROM CENTROS
    WHERE NUM_PLAZAS > 500
);

UPDATE CENTROS
SET NUM_PLAZAS = NUM_PLAZAS * 0.9
WHERE NUM_PLAZAS > 500;

--11. Modificar el número de plazas con un valor igual a la mitad en aquellos centros con menos de dos profesores.
UPDATE CENTROS 
SET NUM_PLAZAS = NUM_PLAZAS/2
WHERE COD_CENTRO IN  (
    SELECT COD_CENTRO FROM PROFESORES RIGHT JOIN CENTROS USING (COD_CENTRO)
    GROUP BY COD_CENTRO 
    HAVING COUNT(DNI) < 2
);

--12. Eliminar los centros que no tengan personal.
DELETE FROM CENTROS WHERE COD_CENTRO NOT IN (
    SELECT DISTINCT COD_CENTRO FROM PERSONAL
);

--13. Borrar al personal que esté en centros de menos de 300 plazas y con menos de dos profesores.
DELETE FROM PERSONAL WHERE COD_CENTRO IN(
    SELECT COD_CENTRO FROM CENTROS WHERE NUM_PLAZAS < 300
)
AND COD_CENTRO IN
(
    SELECT COD_CENTRO FROM PROFESORES RIGHT JOIN CENTROS USING (COD_CENTRO)
    GROUP BY COD_CENTRO HAVING COUNT(DNI) < 2
);

--14. Borrar a los profesores que estén en la tabla PROFESORES y que no estén en la tabla PERSONAL.
DELETE FROM PROFESORES WHERE DNI NOT IN (SELECT DNI FROM PERSONAL);

--15. Insertar un nuevo centro en la tabla CENTROS con la información que quieras.
INSERT INTO CENTROS (COD_CENTRO, TIPO_CENTRO, NOMBRE, DIRECCION, TELEFONO, NUM_PLAZAS)
VALUES ((SELECT MAX (COD_CENTRO) + 1 FROM CENTROS), 'S',
'Nuevo Instituto', 'C/Calle Principal 123', '122-456789', 400
);


--16. Insertar un nuevo centro cuyas plazas sean el máximo de plazas de todos los centros.
INSERT INTO CENTROS (COD_CENTRO , TIPO_CENTRO, NOMBRE, DIRECCION, TELEFONO, NUM_PLAZAS)
SELECT '30','S', 'Nuevo Centro', 'C/Direccion Nueva', '123-456789',
MAX(NUM_PLAZAS)
FROM CENTROS;

--17. Insertar un nuevo profesor en la tabla PERSONAL. El código del centro será 40, el DNI es 46267891, se llamará Carmen Luque Martínez y su salario será la media de todos los salarios.
INSERT INTO PERSONAL (COD_CENTRO, DNI, APELLIDOS, FUNCION, SALARIO)
VALUES ('40', 462-67891, 'Luque Martónez'
    
    );

--18. Se ha contratado un nuevo profesor de Lengua en el centro en el que trabaja Ana Rivera Silvestre. Insértalo en la tabla de personal con los datos que desees. Realizar el ejercicio utilizando JOIN.
INSERT INTO PERSONAL (COD_CENTRO, DNI, APELLIDOS, FUNCION, SALARIO)
SELECT PERSONAL.COD_CENTRO, 5555555, 'Nuevo Centro', 'PROFESOR', 250000
FROM PERSONAL JOIN PROFESORES USING (DNI)
WHERE PROFESORES.APELLIDOS = 'Rivera Silvestre, Ana';

--19. Insertar un nuevo centro en la tabla CENTROS. Añade la información que quieras, pero el numero de plazas debe ser el doble que el número de plazas del centro en el que trabaja Elisa Bueno Zarco. Realiza el ejercicio utilizando JOIN.
INSERT INTO CENTROS (COD_CENTRO , TIPO_CENTRO, NOMBRE, DIRECCION, TELEFONO, NUM_PLAZAS)
VALUES ('90', 'S', 'IES Ribera del Tajo', 'C/Doctor Miguel, ', '123-456788',
(2 * (SELECT NUM_PLAZAS
FROM CENTROS JOIN PERSONAL USING (COD_CENTRO)
WHERE PERSONAL.APELLIDOS = 'Bueno Zarco, Elisa')));

