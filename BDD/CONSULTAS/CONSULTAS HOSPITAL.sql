-- �Qui�nes son las enfermeras y enfermeros que trabajan en turnos de tarde o
-- ma�ana?
SELECT * FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%' AND TURNO LIKE 'T' OR TURNO LIKE 'M';


-- 2) Haz un listado de las enfermeras que ganen entre 2000 y 2500 Euros.
SELECT * FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%' AND SALARIO BETWEEN 2000 AND 2500;


-- 3) Visualiza el sueldo al a�o de los enfermeros y las enfermeras.
SELECT TO_CHAR((SALARIO*12), '999999.99L') "SALARIO ANUAL" FROM PLANTILLA WHERE FUNCION LIKE '%Enferm%';


-- 4) Mostrar, para todos los hospitales, el c�digo de hospital, el nombre completo del hospital y su nombre abreviado de tres letras 
--(a esta columna la podemos llamar ABR). Ordenar la recuperaci�n por esta abreviatura.
SELECT HOSPITAL_COD, NOMBRE, UPPER(SUBSTR(NOMBRE,0,3)) "ABR" FROM HOSPITAL 
    ORDER BY NOMBRE;


-- 5) En la tabla DOCTOR otorgar a cardiolog�a un c�digo de 1, a Psiquiatr�a un c�digo de 2, a Pediatr�a un c�digo de 3 y a cualquier 
--otra especialidad un c�digo de 4. Recuperar todos los doctores, su especialidad y el c�digo asignado.
SELECT ESPECIALIDAD, 
    CASE
        WHEN ESPECIALIDAD LIKE '%Cardio%' THEN 1
        WHEN ESPECIALIDAD LIKE '%Psiqui%' THEN 2
        WHEN ESPECIALIDAD LIKE '%Pedia%' THEN 3
        ELSE 4
    END AS "N�MERO ESPECIALIDAD" 
FROM DOCTOR;


-- 6) Encontrar el salario medio de los internos.
SELECT TO_CHAR(AVG(SALARIO),'9999.99L') "SALARIO MEDIO INTERNOS" FROM PLANTILLA
    WHERE FUNCION LIKE 'Intern%';


-- 7) Encontrar el salario m�s alto y el m�s bajo de la tabla de personal, as� como la diferencia entre los dos.
SELECT TO_CHAR(MAX(SALARIO),'9999.99L') "SALARIO MAXIMO", TO_CHAR(MIN(SALARIO),'9999.99L') "SALARIO M�NIMO", TO_CHAR(MAX(SALARIO)-MIN(SALARIO),'9999.99L') "DIFERENCIA SALARIO"
    FROM PLANTILLA;


-- 8) Calcular el n�mero de tareas distintas que hay, en total, en las salas 1 y 2 del hospital 22.
SELECT COUNT(DISTINCT(NOMBRE)) "TAREAS DISTINTAS" FROM SALA
    WHERE SALA_COD=1 OR SALA_COD=2 AND HOSPITAL_COD=22;

-- 9) Buscar qu� turnos tienen m�s de dos personas realizando un trabajo concreto.
SELECT TURNO, COUNT(*) "TRABAJADORES POR TURNO" FROM PLANTILLA
    GROUP BY TURNO HAVING COUNT(*)>2;

-- 10) Buscar qu� turnos tienen m�s de dos personas.
SELECT TURNO, COUNT(*) "TRABAJADORES POR TURNO" FROM PLANTILLA
    GROUP BY TURNO HAVING COUNT(*)>2;

-- 11) Listar, a partir de las tablas al inicio expuestas, el nombre de cada empleado, su trabajo y localizaci�n de su puesto de trabajo 
--(el nombre del hospital y c�digo de sala)
SELECT P.APELLIDO, P.FUNCION, H.DIRECCION, P.SALA_COD FROM PLANTILLA P
    JOIN HOSPITAL H ON P.HOSPITAL_COD=H.HOSPITAL_COD;

-- 12) Repetir la misma lista, excepto que en esta ocasi�n se obtendr� el nombre de la sala y el c�digo de hospital.
SELECT P.APELLIDO, P.FUNCION, S.NOMBRE, P.HOSPITAL_COD FROM PLANTILLA P
    JOIN SALA S ON P.SALA_COD=S.SALA_COD;

-- 13) Listar el nombre, la funci�n, el turno y el salario de todos los empleados que tienen un salario superior al salario m�s bajo del 
-- turno 'N'. Por favor ordenar el listado en orden descendente de salarios.
SELECT APELLIDO, FUNCION, TURNO, SALARIO FROM PLANTILLA 
    WHERE SALARIO>
        (SELECT MIN(SALARIO) FROM PLANTILLA WHERE TURNO LIKE 'N')
    ORDER BY SALARIO DESC;

-- 14) Listar el n�mero de empleados por sala y hospital, sacar las salas que no tienen a nadie.
SELECT SALA_COD, HOSPITAL_COD, COUNT(*) FROM PLANTILLA
GROUP BY SALA_COD, HOSPITAL_COD HAVING COUNT(SALA_COD)>0;

-- 15) Listar el n�mero de enfermos que tiene cada hospital. Visualizar tambi�n los hospitales que no tienen enfermos.
SELECT H.HOSPITAL_COD, COUNT(E.HOSPITAL_COD) AS NUM_ENFERMOS
FROM HOSPITAL H
LEFT JOIN ENFERMO E ON H.HOSPITAL_COD = E.HOSPITAL_COD
GROUP BY H.HOSPITAL_COD;

-- 16) Listar las salas y los empleados que tiene cada una. Sacar tambi�n las salas que no tenga a nadie
SELECT S.NOMBRE, S.SALA_COD, P.APELLIDO FROM SALA S
    LEFT JOIN PLANTILLA P ON S.SALA_COD=P.SALA_COD;
    
-- 17) Visualizar por cada hospital y sala el empleado con m�s salario.
SELECT HOSPITAL_COD, SALA_COD, TO_CHAR(MAX(SALARIO),'9999.99L') "SALARIO M�XIMO" FROM PLANTILLA
GROUP BY HOSPITAL_COD, SALA_COD 
    ORDER BY HOSPITAL_COD,SALA_COD ASC;
    
-- 18) Visualizar las salas compartidas por m�s de un hospital.
--c�digo_sala, nombre de sala , Cod_hospital, nombre_hosp
SELECT S.SALA_COD, S.NOMBRE, H.HOSPITAL_COD, H.NOMBRE
    FROM SALA S JOIN HOSPITAL H ON S.HOSPITAL_COD=H.HOSPITAL_COD;
    
-- 