/* 1.Obtener APELLIDOS y NOMBRE en un solo campo, que se llamará NOMBRE COMPLETO 
y la población, de la tabla ALUMNOS, de los alumnos que vivan en TALAVERA,
ordenado alfabéticamente por APELLIDOS. ¿Ves algo mejorable?*/

SELECT CONCAT(CONCAT(NOMBRE, ' '),APELLIDOS) "NOMBRE COMPLETO",
       POBLACION
FROM ALUMNOS 
WHERE TRIM(POBLACION) LIKE 'TALAVERA' OR 
      TRIM(POBLACION) LIKE 'TALAVERA DE LA REINA'
ORDER BY APELLIDOS;

/* 2. Obtener el NOMBRE en mayúsculas, CURSO y el NIVEL en minúsculas de la tabla ALUMNOS,
de los alumnos que estén en el segundo curso de un ciclo formativo, ordenado de tal forma
que aparezcan primero los alumnos de grado superior.
*/
SELECT UPPER(NOMBRE), CURSO, LOWER(NIVEL)
FROM ALUMNOS
WHERE CURSO=2 AND TRIM(NIVEL) LIKE 'CFG%'
ORDER BY NIVEL DESC;

/* 3. Mostrar NOMBRE, POBLACION (con sólo la primera letra en mayúsculas) y PROVINCIA (en
minúsculas), de la tabla ALUMNOS, de aquellos alumnos, que tengan un nombre compuesto.
No se pueden utilizar comodines. */
SELECT INITCAP(NOMBRE), INITCAP(POBLACION), LOWER(PROVINCIA)
FROM ALUMNOS
WHERE INSTR(TRIM(NOMBRE),' ')>0;

/* 4. Obtener la mejor nota (MEJOR Nota) y la peor nota (PEOR Nota), 
obtenida por los alumnos en cada una de las evaluaciones, de la tabla NOTAS_ALUMNOS. */
SELECT MAX(NOTA1) "MEJOR 1ª EVA", MIN(NOTA1) "PEOR 1ª EVA",
        MAX(NOTA2) "MEJOR 2ª EVA", MIN(NOTA2) "PEOR 2ª EVA",
        MAX(NOTA3) "MEJOR 3ª EVA", MIN(NOTA3) "PEOR 3ª EVA"
FROM NOTAS_ALUMNOS;

/* 5. Obtener APELLIDOS y NOMBRE en un solo campo, que se llamará NOMBRE COMPLETO, 
de la tabla ALUMNOS. 
El campo APELLIDOS tendrá una longitud de 20 caracteres (si el campo ocupa
menos de 20 caracteres rellenaremos con el carácter ‘.’ hasta completar los 20 caracteres).
No se puede utilizar la función CONCAT
MARTIN SANCHEZ......BLANCA */
SELECT RPAD(APELLIDOS,20,'.')||TRIM(NOMBRE) "NOMBRE COMPLETO"
FROM ALUMNOS;

/*6. Obtener TEMA de la tabla LIBRERIAS de los temas que empiecen por ‘GEO’ y 
acaben en ‘ia’ y tengan entre 5 y 20 ejemplares. */
SELECT TEMA 
FROM LIBRERIAS
WHERE UPPER(TRIM(TEMA)) LIKE 'GEO%' AND
      LOWER(TRIM(TEMA)) LIKE '%ia' AND
      EJEMPLARES BETWEEN 5 AND 20;


/* 7. Obtener cuantos TEMAS de la tabla LIBRERIAS de los temas que empiecen por ‘geo’ y 
acaben en ‘ia’ y tengan entre 5 y 20 ejemplares. */
SELECT COUNT(*) -- COUNT(TEMA)
FROM LIBRERIAS
WHERE LOWER(TRIM(TEMA)) LIKE 'geo%' AND
      LOWER(TRIM(TEMA)) LIKE '%ia' AND
      EJEMPLARES BETWEEN 5 AND 20;

/*
8. Obtener TEMA y cuantos TEMAS de la tabla LIBRERIAS de los temas que empiecen
por ‘geo’ y
acaben en ‘fia’ y tengan entre 5 y 20 ejemplares. ¿Qué resultados obtienes? Explica el
resultado obtenido. */
SELECT TEMA, COUNT(TEMA) -- COUNT(TEMA)
FROM LIBRERIAS
WHERE LOWER(TRIM(TEMA)) LIKE 'geo%' AND
      LOWER(TRIM(TEMA)) LIKE '%fia' AND
      EJEMPLARES BETWEEN 5 AND 20
GROUP BY TEMA;


/* 9. Obtener el NOMBRE, DIRECCION y PROVINCIA de la tabla ALUMNOS, 
de los alumnos que vivan
en la provincia de TOLEDO y que no vivan en el número de 20 de su calle 
o avenida. */
SELECT NOMBRE, DIRECCION, PROVINCIA
FROM ALUMNOS
WHERE PROVINCIA LIKE 'TOLEDO' AND 
      SUBSTR(TRIM(DIRECCION),LENGTH(TRIM(DIRECCION))-2,3) NOT LIKE ' 20'; --

/* 10. Obtener la media de las faltas, de todos los alumnos, 
de la primera evaluación con dos
decimales (MEDIA FALTAS 1ª EVALUACIÓN), la suma de las faltas de todos los alumnos, de la
segunda evaluación (SUMA FALTAS SEGUNDA EVALUACION), el número de alumnos que
tenemos actualmente (TOTAL ALUMNOS), de la tabla ALUMNOS. */
SELECT ROUND(AVG(FALTAS1),2) "MEDIA FALTAS",
       SUM(FALTAS2) "SUMA",
       COUNT(*)
FROM ALUMNOS;

/* 11. Obtener el NOMBRE, APELLIDOS, POBLACIÓN y la media de faltas, 
redondeado al entero superior de la tabla ALUMNOS, de los alumnos que tengan una 
media más de un tres, y menos de un 7, que se llamen ‘BLANCA’ de nombre, 
vivan en ‘TORRIJOS’ y se apelliden ‘LOPEZ’. */
SELECT NOMBRE, APELLIDOS, POBLACION, CEIL((FALTAS1+FALTAS2+FALTAS3)/3) "MEDIA FALTAS"
FROM ALUMNOS
WHERE (FALTAS1+FALTAS2+FALTAS3)/3 BETWEEN 3 AND 7
      AND TRIM(NOMBRE) LIKE 'BLANCA'
      AND TRIM(POBLACION) LIKE 'TORRIJOS' 
      AND TRIM(APELLIDOS) LIKE '%LOPEZ%';


/* 12. Obtener el mayor y el menor número de faltas en la tercera evaluación. */

/* 13. Obtener la media de las faltas, de todos los alumnos, 
de la tercera evaluación con dos decimales. No se puede utilizar la función AVG. */

SELECT SUM(FALTAS3)/COUNT(*) "FALTAS" FROM ALUMNOS;

/*

14. Obtener NOMBRE, APELLIDOS, DIRECCIÓN, POBLACION, PROVINCIA, además tendrás que
mostrar el CURSO y la CLASE en un solo campo que se llamará GRUPO y la media de faltas de
cada alumno, que se llamará FALTAS, de la tabla ALUMNOS, de los alumnos que tengan una
media de faltas superior a 5 faltas, ordenado por la media de las faltas.
El NOMBRE y los APELLIDOS, aparecerán con la primera letra en mayúscula y el resto en
minúscula.
La POBLACION, la PROVINCIA y la DIRECCIÓN, aparecerán en mayúsculas.
CURSO y CLASE, es decir GRUPO, aparecerá en minúsculas de la siguiente forma: ‘2ºc’
La media de faltas, es decir FALTAS, aparecerá con dos decimales.


15. Obtener sólo los APELLIDOS y la nota media de las tres evaluaciones, que se llamará NOTA
MEDIA de la tabla NOTAS_ALUMNOS, de aquellos alumnos que hayan aprobado todas las
evaluaciones. Ordenado alfabéticamente por APELLIDOS.
La NOTA MEDIA será el valor al entero inmediatamente superior a la nota media obtenida, y
los APELLIDOS aparecerán sin la coma al final.
16. Una vez hayas realizado la consulta del apartado anterior, realiza la misma consulta
cambiando que la NOTA MEDIA sea el valor al entero inmediatamente inferior a la nota media
obtenida. Observa los resultados obtenidos.
17. Una vez hayas realizado la consulta del apartado anterior, realiza la misma consulta
cambiando que la NOTA MEDIA se redondee a dos decimales. Observa los resultados
obtenidos.
18. Obtener NOMBRE, APELLIDOS y el segundo APELLIDO, que se llamara SEGUNDO APELLIDO de
la tabla ALUMNOS, de los alumnos que tengan de segundo apellido ‘martin’.
Aunque el criterio de selección sea en minúsculas, el SEGUNDO APELLIDO debe aparecer en
mayúsculas en la salida.
Realizar la consulta sin comodines.
19. Obtener NOMBRE y APELLIDOS de la tabla ALUMNOS, de los alumnos que tengan de primer
apellido ‘martin’.
Aunque el criterio de selección sea en minúsculas, el SEGUNDO APELLIDO debe aparecer en
mayúsculas en la salida.
Realizar la consulta sin comodines.

*/



/* 23.	Obtener NOMBRE, APELLIDOS y FECHA_NAC, en la salida aparecerá como 
FECHA DE NACIMIENTO, así como el nombre del mes y el número de días del mes en 
el que nacieron cada uno de los alumnos, de la tabla ALUMNOS, ordenado por fecha, 
de tal forma que aparezcan en primer lugar las fechas más recientes. */





/* 24.	Obtener el NOMBRE, APELLIDOS y el año de nacimiento, en la salida aparecerá 
como AÑO DE NACIMIENTO, de la tabla ALUMNOS, ordenado por el año de nacimiento. 
Cada uno de los resultados tendrá que aparecer con siguiente formato:
Blanca - Martin Sánchez nació en el año 2000 */

SELECT INITCAP(NOMBRE)||' - '|| INITCAP(APELLIDOS) ||' nació en el año ' || 
       TO_CHAR(FECHA_NAC,'YYYY')
FROM ALUMNOS;

/* 25.	Obtener el NOMBRE, APELLIDOS y FECHA_NAC de la tabla ALUMNOS de 
los alumnos nacidos en el año 2000. */

-- EXTRAER EL AÑO EN FORMATO CADENA
SELECT NOMBRE, APELLIDOS, FECHA_NAC
FROM ALUMNOS
WHERE TO_CHAR(FECHA_NAC, 'YYYY') = '2001';

-- EXTRAER EL AÑO EN FORMATO NUMÉRICO
SELECT NOMBRE, APELLIDOS, FECHA_NAC
FROM ALUMNOS
WHERE  EXTRACT (YEAR FROM FECHA_NAC) = 2001;

/* 26.	Obtener NOMBRE, FECHA_NAC, y la fecha FECHA_FORMATEADA, 
de la tabla ALUMNOS, la fecha formateada tendrá el siguiente formato:
 Nació el   12   de mayo de 2001 */
SELECT NOMBRE, FECHA_NAC, 
       'Nació el '||TO_CHAR(FECHA_NAC,'DD')||' de '||TO_CHAR(FECHA_NAC,'month')||
       ' de ' ||TO_CHAR(FECHA_NAC,'YYYY') "FECHA FORMATEADA"
FROM ALUMNOS;
 
/* 27.	Obtener el NOMBRE, APELLIDOS y el día de la semana en que nacieron
(en la salida aparecerá como DIA DE NACIMIENTO) de la tabla ALUMNOS. */

SELECT NOMBRE, APELLIDOS, TO_CHAR(FECHA_NAC,'day') "DIA DE NACIMIENTO"
FROM ALUMNOS;

/* 28.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y el año de nacimiento de 
cada alumno, de la tabla ALUMNOS de los alumnos nacidos en la década de los 80 
y en la primera década del siglo XXI. */
SELECT NOMBRE, APELLIDOS, FECHA_NAC, TO_CHAR(FECHA_NAC,'YYYY')
FROM ALUMNOS
WHERE FECHA_NAC BETWEEN '01/01/1980' AND '31/12/1989' OR
      FECHA_NAC BETWEEN '01/01/2000' AND '31/12/2009';

/* 29.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y el año de nacimiento de 
cada alumno, de la tabla ALUMNOS de los alumnos nacidos en la década de los 80,
en la década de los 90 y en la primera década del 2000, ordenado por el año 
de nacimiento. */
SELECT NOMBRE, APELLIDOS, FECHA_NAC, TO_CHAR(FECHA_NAC,'YYYY')
FROM ALUMNOS
WHERE FECHA_NAC BETWEEN '01/01/1980' AND '31/12/2009';

/* 30.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y la edad que tiene cada alumno, 
de la tabla ALUMNOS. */
SELECT NOMBRE, APELLIDOS, FECHA_NAC, TRUNC((SYSDATE-FECHA_NAC)/365) "EDAD"
FROM ALUMNOS;

SELECT NOMBRE, APELLIDOS, FECHA_NAC, FLOOR((SYSDATE-FECHA_NAC)/365) "EDAD"
FROM ALUMNOS;

SELECT NOMBRE, APELLIDOS, FECHA_NAC, TRUNC(MONTHS_BETWEEN(SYSDATE,FECHA_NAC)/12) "EDAD"
FROM ALUMNOS;

/* 31.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC de la tabla ALUMNOS, 
de aquellos alumnos cumplan años en los 2 próximos meses. */
SELECT NOMBRE, APELLIDOS, FECHA_NAC
FROM ALUMNOS
-- LOS QUE CUMPLEN EN EL MES ACTUAL HASTA FINAL DE MES
WHERE (EXTRACT(DAY FROM FECHA_NAC)>= EXTRACT (DAY FROM SYSDATE) AND
      EXTRACT(MONTH FROM FECHA_NAC)= EXTRACT (MONTH FROM SYSDATE)) OR
       -- LOS QUE NACEN EN EL MES SIGUIENTE
      (EXTRACT(MONTH FROM FECHA_NAC)= EXTRACT (MONTH FROM SYSDATE)+1) OR
      -- LOS QUE CUMPLEN DENTRO DE DOS MESES ANTES DE DIA ACTUAL
      (EXTRACT(DAY FROM FECHA_NAC)<= EXTRACT (DAY FROM SYSDATE) AND
      EXTRACT(MONTH FROM FECHA_NAC)= EXTRACT (MONTH FROM SYSDATE)+2) 
;

/* 32.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y la edad que tiene cada alumno, 
de la tabla ALUMNOS, de aquellos alumnos que sean menores de edad el mes que viene. */

SELECT NOMBRE, APELLIDOS, FECHA_NAC, 
       TRUNC(MONTHS_BETWEEN(SYSDATE,FECHA_NAC)/12) "EDAD"
FROM ALUMNOS
WHERE (MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 1),FECHA_NAC)/12)<18;

/* 33.	Obtener el NOMBRE, APELLIDOS concatenados y separados por una coma y 
un espacio, y el número y nombre de mes correspondiente de su nacimiento, 
así como el año, de la tabla de ALUMNOS. */
SELECT NOMBRE || ', ' || APELLIDOS,
       TO_CHAR(FECHA_NAC,'MM') "NUMERO MES", 
       TO_CHAR(FECHA_NAC, 'Month') "MES", 
       TO_CHAR(FECHA_NAC, 'YYYY') AÑO
    FROM ALUMNOS;

/* 34.	Obtener cuantos alumnos nacieron en el primer trimestre del año, 
de la tabla de ALUMNOS. */
SELECT COUNT(*) 
FROM ALUMNOS
WHERE TO_CHAR(FECHA_NAC,'Q')='1';

/* 35.	Convertir la cadena '010712' a fecha y visualizar su nombre de mes en
mayúsculas. */
SELECT TO_CHAR(TO_DATE('010712','DD/MM/YY'),'MONTH') FROM DUAL;


-- 36.	Convertir el número 127 a cadena y mostrar el NOMBRE de todos los alumnos si la conversión se ha realizado correctamente.
SELECT TO_CHAR(127,'$00G000G000D99') FROM DUAL;
SELECT TO_CHAR(12756780,'00G000G000D99L') FROM DUAL;

ALTER SESSION SET NLS_NUMERIC_CHARACTERS='/*';
ALTER SESSION SET NLS_NUMERIC_CHARACTERS=',.';

SELECT NOMBRE_ALUMNO, NVL (NOTA1, 0)

FROM NOTAS_ALUMNOS;


………………………………………………………………………………………………………………………………………………

37.	Obtener la media de las notas de la primera evaluación, la nota media de la segunda evaluación y la nota media de la tercera evaluación, de la tabla de NOTAS_ALUMNOS.
38.	Obtener la media de las notas de la primera evaluación, la nota media de la segunda evaluación y la nota media de la tercera evaluación, de la tabla de NOTAS_ALUMNOS, si hay algún valor que sea null tendremos que sustituirlo por el valor 0. Compara los resultados de esta consulta con el resultado obtenido en la consulta anterior.
39.	Obtener cuantas notas hay en la primera evaluación, cuantas notas hay en la segunda evaluación y cuantas notas hay en la tercera evaluación, de la tabla de NOTAS_ALUMNOS.


