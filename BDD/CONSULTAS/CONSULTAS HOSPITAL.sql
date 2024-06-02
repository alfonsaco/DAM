-- ¿Quiénes son las enfermeras y enfermeros que trabajan en turnos de tarde o
-- mañana?
SELECT * FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%' AND TURNO LIKE 'T' OR TURNO LIKE 'M';


-- 2) Haz un listado de las enfermeras que ganen entre 2000 y 2500 Euros.
SELECT * FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%' AND SALARIO BETWEEN 2000 AND 2500;


-- 3) Visualiza el sueldo al año de los enfermeros y las enfermeras.
SELECT TO_CHAR((SALARIO*12), '999999.99L') "SALARIO ANUAL" FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%';


-- 4) Mostrar, para todos los hospitales, el código de hospital, el nombre completo del hospital y su nombre abreviado de tres letras 
--(a esta columna la podemos llamar ABR). Ordenar la recuperación por esta abreviatura.
SELECT HOSPITAL_COD, NOMBRE, UPPER(SUBSTR(NOMBRE,0,3)) "ABR" FROM HOSPITAL 
    ORDER BY NOMBRE;


-- 5) En la tabla DOCTOR otorgar a cardiología un código de 1, a Psiquiatría un código de 2, a Pediatría un código de 3 y a cualquier 
--otra especialidad un código de 4. Recuperar todos los doctores, su especialidad y el código asignado.
SELECT ESPECIALIDAD, 
    CASE
        WHEN ESPECIALIDAD LIKE '%Cardio%' THEN 1
        WHEN ESPECIALIDAD LIKE '%Psiqui%' THEN 2
        WHEN ESPECIALIDAD LIKE '%Pedia%' THEN 3
        ELSE 4
    END AS "NÚMERO ESPECIALIDAD" 
FROM DOCTOR;


-- 6) Encontrar el salario medio de los internos.
SELECT TO_CHAR(AVG(SALARIO),'9999.99L') "SALARIO MEDIO INTERNOS" FROM PLANTILLA
    WHERE FUNCION LIKE 'Intern%';


-- 7) Encontrar el salario más alto y el más bajo de la tabla de personal, así como la diferencia entre los dos.
SELECT TO_CHAR(MAX(SALARIO),'9999.99L') "SALARIO MAXIMO", TO_CHAR(MIN(SALARIO),'9999.99L') "SALARIO MÍNIMO", TO_CHAR(MAX(SALARIO)-MIN(SALARIO),'9999.99L') "DIFERENCIA SALARIO"
    FROM PLANTILLA;


-- 8) Calcular el número de tareas distintas que hay, en total, en las salas 1 y 2 del hospital 22.
SELECT COUNT(DISTINCT(NOMBRE)) "TAREAS DISTINTAS" FROM SALA
    WHERE SALA_COD=1 OR SALA_COD=2 AND HOSPITAL_COD=22;

-- 9) Buscar qué turnos tienen más de dos personas realizando un trabajo concreto.
SELECT TURNO, COUNT(*) "TRABAJADORES POR TURNO" FROM PLANTILLA
    GROUP BY TURNO HAVING COUNT(*)>2;

-- 10) Buscar qué turnos tienen más de dos personas.
SELECT TURNO, COUNT(*) "TRABAJADORES POR TURNO" FROM PLANTILLA
    GROUP BY TURNO HAVING COUNT(*)>2;

-- 11) Listar, a partir de las tablas al inicio expuestas, el nombre de cada empleado, su trabajo y localización de su puesto de trabajo 
--(el nombre del hospital y código de sala)
SELECT P.APELLIDO, P.FUNCION, H.DIRECCION, P.SALA_COD FROM PLANTILLA P
    JOIN HOSPITAL H ON P.HOSPITAL_COD=H.HOSPITAL_COD;

-- 12) Repetir la misma lista, excepto que en esta ocasión se obtendrá el nombre de la sala y el código de hospital.
SELECT P.APELLIDO, P.FUNCION, S.NOMBRE, P.HOSPITAL_COD FROM PLANTILLA P
    JOIN SALA S ON P.SALA_COD=S.SALA_COD;

-- 13) Listar el nombre, la función, el turno y el salario de todos los empleados que tienen un salario superior al salario más bajo del 
-- turno 'N'. Por favor ordenar el listado en orden descendente de salarios.
SELECT APELLIDO, FUNCION, TURNO, SALARIO FROM PLANTILLA 
    WHERE SALARIO>
        (SELECT MIN(SALARIO) FROM PLANTILLA WHERE TURNO LIKE 'N')
    ORDER BY SALARIO DESC;

-- 14) Listar el número de empleados por sala y hospital, sacar las salas que no tienen a nadie.
SELECT SALA_COD, HOSPITAL_COD, COUNT(*) FROM PLANTILLA
GROUP BY SALA_COD, HOSPITAL_COD HAVING COUNT(SALA_COD)>0;

-- 15) Listar el número de enfermos que tiene cada hospital. Visualizar también los hospitales que no tienen enfermos.
SELECT H.HOSPITAL_COD, COUNT(E.HOSPITAL_COD) AS NUM_ENFERMOS
FROM HOSPITAL H
LEFT JOIN ENFERMO E ON H.HOSPITAL_COD = E.HOSPITAL_COD
GROUP BY H.HOSPITAL_COD;

-- 16) Listar las salas y los empleados que tiene cada una. Sacar también las salas que no tenga a nadie
SELECT S.NOMBRE, S.SALA_COD, P.APELLIDO FROM SALA S
    LEFT JOIN PLANTILLA P ON S.SALA_COD=P.SALA_COD;
    
-- 17) Visualizar por cada hospital y sala el empleado con más salario.
SELECT HOSPITAL_COD, SALA_COD, TO_CHAR(MAX(SALARIO),'9999.99L') "SALARIO MÁXIMO" FROM PLANTILLA
GROUP BY HOSPITAL_COD, SALA_COD 
    ORDER BY HOSPITAL_COD,SALA_COD ASC;
    
-- 18) Visualizar las salas compartidas por más de un hospital.
--código_sala, nombre de sala , Cod_hospital, nombre_hosp
SELECT S.SALA_COD, S.NOMBRE, H.HOSPITAL_COD, H.NOMBRE
    FROM SALA S JOIN HOSPITAL H ON S.HOSPITAL_COD=H.HOSPITAL_COD;
    
-- 