/* 1.Obtener APELLIDOS y NOMBRE en un solo campo, que se llamar� NOMBRE COMPLETO 
y la poblaci�n, de la tabla ALUMNOS, de los alumnos que vivan en TALAVERA,
ordenado alfab�ticamente por APELLIDOS. �Ves algo mejorable?*/

SELECT CONCAT(CONCAT(NOMBRE, ' '),APELLIDOS) "NOMBRE COMPLETO",
       POBLACION
FROM ALUMNOS 
WHERE TRIM(POBLACION) LIKE 'TALAVERA' OR 
      TRIM(POBLACION) LIKE 'TALAVERA DE LA REINA'
ORDER BY APELLIDOS;

/* 2. Obtener el NOMBRE en may�sculas, CURSO y el NIVEL en min�sculas de la tabla ALUMNOS,
de los alumnos que est�n en el segundo curso de un ciclo formativo, ordenado de tal forma
que aparezcan primero los alumnos de grado superior.
*/
SELECT UPPER(NOMBRE), CURSO, LOWER(NIVEL)
FROM ALUMNOS
WHERE CURSO=2 AND TRIM(NIVEL) LIKE 'CFG%'
ORDER BY NIVEL DESC;

/* 3. Mostrar NOMBRE, POBLACION (con s�lo la primera letra en may�sculas) y PROVINCIA (en
min�sculas), de la tabla ALUMNOS, de aquellos alumnos, que tengan un nombre compuesto.
No se pueden utilizar comodines. */
SELECT INITCAP(NOMBRE), INITCAP(POBLACION), LOWER(PROVINCIA)
FROM ALUMNOS
WHERE INSTR(TRIM(NOMBRE),' ')>0;

/* 4. Obtener la mejor nota (MEJOR Nota) y la peor nota (PEOR Nota), 
obtenida por los alumnos en cada una de las evaluaciones, de la tabla NOTAS_ALUMNOS. */
SELECT MAX(NOTA1) "MEJOR 1� EVA", MIN(NOTA1) "PEOR 1� EVA",
        MAX(NOTA2) "MEJOR 2� EVA", MIN(NOTA2) "PEOR 2� EVA",
        MAX(NOTA3) "MEJOR 3� EVA", MIN(NOTA3) "PEOR 3� EVA"
FROM NOTAS_ALUMNOS;

/* 5. Obtener APELLIDOS y NOMBRE en un solo campo, que se llamar� NOMBRE COMPLETO, 
de la tabla ALUMNOS. 
El campo APELLIDOS tendr� una longitud de 20 caracteres (si el campo ocupa
menos de 20 caracteres rellenaremos con el car�cter �.� hasta completar los 20 caracteres).
No se puede utilizar la funci�n CONCAT
MARTIN SANCHEZ......BLANCA */
SELECT RPAD(APELLIDOS,20,'.')||TRIM(NOMBRE) "NOMBRE COMPLETO"
FROM ALUMNOS;

/*6. Obtener TEMA de la tabla LIBRERIAS de los temas que empiecen por �GEO� y 
acaben en �ia� y tengan entre 5 y 20 ejemplares. */
SELECT TEMA 
FROM LIBRERIAS
WHERE UPPER(TRIM(TEMA)) LIKE 'GEO%' AND
      LOWER(TRIM(TEMA)) LIKE '%ia' AND
      EJEMPLARES BETWEEN 5 AND 20;


/* 7. Obtener cuantos TEMAS de la tabla LIBRERIAS de los temas que empiecen por �geo� y 
acaben en �ia� y tengan entre 5 y 20 ejemplares. */
SELECT COUNT(*) -- COUNT(TEMA)
FROM LIBRERIAS
WHERE LOWER(TRIM(TEMA)) LIKE 'geo%' AND
      LOWER(TRIM(TEMA)) LIKE '%ia' AND
      EJEMPLARES BETWEEN 5 AND 20;

/*
8. Obtener TEMA y cuantos TEMAS de la tabla LIBRERIAS de los temas que empiecen
por �geo� y
acaben en �fia� y tengan entre 5 y 20 ejemplares. �Qu� resultados obtienes? Explica el
resultado obtenido. */
SELECT TEMA, COUNT(TEMA) -- COUNT(TEMA)
FROM LIBRERIAS
WHERE LOWER(TRIM(TEMA)) LIKE 'geo%' AND
      LOWER(TRIM(TEMA)) LIKE '%fia' AND
      EJEMPLARES BETWEEN 5 AND 20
GROUP BY TEMA;


/* 9. Obtener el NOMBRE, DIRECCION y PROVINCIA de la tabla ALUMNOS, 
de los alumnos que vivan
en la provincia de TOLEDO y que no vivan en el n�mero de 20 de su calle 
o avenida. */
SELECT NOMBRE, DIRECCION, PROVINCIA
FROM ALUMNOS
WHERE PROVINCIA LIKE 'TOLEDO' AND 
      SUBSTR(TRIM(DIRECCION),LENGTH(TRIM(DIRECCION))-2,3) NOT LIKE ' 20'; --

/* 10. Obtener la media de las faltas, de todos los alumnos, 
de la primera evaluaci�n con dos
decimales (MEDIA FALTAS 1� EVALUACI�N), la suma de las faltas de todos los alumnos, de la
segunda evaluaci�n (SUMA FALTAS SEGUNDA EVALUACION), el n�mero de alumnos que
tenemos actualmente (TOTAL ALUMNOS), de la tabla ALUMNOS. */
SELECT ROUND(AVG(FALTAS1),2) "MEDIA FALTAS",
       SUM(FALTAS2) "SUMA",
       COUNT(*)
FROM ALUMNOS;

/* 11. Obtener el NOMBRE, APELLIDOS, POBLACI�N y la media de faltas, 
redondeado al entero superior de la tabla ALUMNOS, de los alumnos que tengan una 
media m�s de un tres, y menos de un 7, que se llamen �BLANCA� de nombre, 
vivan en �TORRIJOS� y se apelliden �LOPEZ�. */
SELECT NOMBRE, APELLIDOS, POBLACION, CEIL((FALTAS1+FALTAS2+FALTAS3)/3) "MEDIA FALTAS"
FROM ALUMNOS
WHERE (FALTAS1+FALTAS2+FALTAS3)/3 BETWEEN 3 AND 7
      AND TRIM(NOMBRE) LIKE 'BLANCA'
      AND TRIM(POBLACION) LIKE 'TORRIJOS' 
      AND TRIM(APELLIDOS) LIKE '%LOPEZ%';


/* 12. Obtener el mayor y el menor n�mero de faltas en la tercera evaluaci�n. */

/* 13. Obtener la media de las faltas, de todos los alumnos, 
de la tercera evaluaci�n con dos decimales. No se puede utilizar la funci�n AVG. */

SELECT SUM(FALTAS3)/COUNT(*) "FALTAS" FROM ALUMNOS;

/*

14. Obtener NOMBRE, APELLIDOS, DIRECCI�N, POBLACION, PROVINCIA, adem�s tendr�s que
mostrar el CURSO y la CLASE en un solo campo que se llamar� GRUPO y la media de faltas de
cada alumno, que se llamar� FALTAS, de la tabla ALUMNOS, de los alumnos que tengan una
media de faltas superior a 5 faltas, ordenado por la media de las faltas.
El NOMBRE y los APELLIDOS, aparecer�n con la primera letra en may�scula y el resto en
min�scula.
La POBLACION, la PROVINCIA y la DIRECCI�N, aparecer�n en may�sculas.
CURSO y CLASE, es decir GRUPO, aparecer� en min�sculas de la siguiente forma: �2�c�
La media de faltas, es decir FALTAS, aparecer� con dos decimales.


15. Obtener s�lo los APELLIDOS y la nota media de las tres evaluaciones, que se llamar� NOTA
MEDIA de la tabla NOTAS_ALUMNOS, de aquellos alumnos que hayan aprobado todas las
evaluaciones. Ordenado alfab�ticamente por APELLIDOS.
La NOTA MEDIA ser� el valor al entero inmediatamente superior a la nota media obtenida, y
los APELLIDOS aparecer�n sin la coma al final.
16. Una vez hayas realizado la consulta del apartado anterior, realiza la misma consulta
cambiando que la NOTA MEDIA sea el valor al entero inmediatamente inferior a la nota media
obtenida. Observa los resultados obtenidos.
17. Una vez hayas realizado la consulta del apartado anterior, realiza la misma consulta
cambiando que la NOTA MEDIA se redondee a dos decimales. Observa los resultados
obtenidos.
18. Obtener NOMBRE, APELLIDOS y el segundo APELLIDO, que se llamara SEGUNDO APELLIDO de
la tabla ALUMNOS, de los alumnos que tengan de segundo apellido �martin�.
Aunque el criterio de selecci�n sea en min�sculas, el SEGUNDO APELLIDO debe aparecer en
may�sculas en la salida.
Realizar la consulta sin comodines.
19. Obtener NOMBRE y APELLIDOS de la tabla ALUMNOS, de los alumnos que tengan de primer
apellido �martin�.
Aunque el criterio de selecci�n sea en min�sculas, el SEGUNDO APELLIDO debe aparecer en
may�sculas en la salida.
Realizar la consulta sin comodines.

*/



/* 23.	Obtener NOMBRE, APELLIDOS y FECHA_NAC, en la salida aparecer� como 
FECHA DE NACIMIENTO, as� como el nombre del mes y el n�mero de d�as del mes en 
el que nacieron cada uno de los alumnos, de la tabla ALUMNOS, ordenado por fecha, 
de tal forma que aparezcan en primer lugar las fechas m�s recientes. */





/* 24.	Obtener el NOMBRE, APELLIDOS y el a�o de nacimiento, en la salida aparecer� 
como A�O DE NACIMIENTO, de la tabla ALUMNOS, ordenado por el a�o de nacimiento. 
Cada uno de los resultados tendr� que aparecer con siguiente formato:
Blanca - Martin S�nchez naci� en el a�o 2000 */

SELECT INITCAP(NOMBRE)||' - '|| INITCAP(APELLIDOS) ||' naci� en el a�o ' || 
       TO_CHAR(FECHA_NAC,'YYYY')
FROM ALUMNOS;

/* 25.	Obtener el NOMBRE, APELLIDOS y FECHA_NAC de la tabla ALUMNOS de 
los alumnos nacidos en el a�o 2000. */

-- EXTRAER EL A�O EN FORMATO CADENA
SELECT NOMBRE, APELLIDOS, FECHA_NAC
FROM ALUMNOS
WHERE TO_CHAR(FECHA_NAC, 'YYYY') = '2001';

-- EXTRAER EL A�O EN FORMATO NUM�RICO
SELECT NOMBRE, APELLIDOS, FECHA_NAC
FROM ALUMNOS
WHERE  EXTRACT (YEAR FROM FECHA_NAC) = 2001;

/* 26.	Obtener NOMBRE, FECHA_NAC, y la fecha FECHA_FORMATEADA, 
de la tabla ALUMNOS, la fecha formateada tendr� el siguiente formato:
 Naci� el   12   de mayo de 2001 */
SELECT NOMBRE, FECHA_NAC, 
       'Naci� el '||TO_CHAR(FECHA_NAC,'DD')||' de '||TO_CHAR(FECHA_NAC,'month')||
       ' de ' ||TO_CHAR(FECHA_NAC,'YYYY') "FECHA FORMATEADA"
FROM ALUMNOS;
 
/* 27.	Obtener el NOMBRE, APELLIDOS y el d�a de la semana en que nacieron
(en la salida aparecer� como DIA DE NACIMIENTO) de la tabla ALUMNOS. */

SELECT NOMBRE, APELLIDOS, TO_CHAR(FECHA_NAC,'day') "DIA DE NACIMIENTO"
FROM ALUMNOS;

/* 28.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y el a�o de nacimiento de 
cada alumno, de la tabla ALUMNOS de los alumnos nacidos en la d�cada de los 80 
y en la primera d�cada del siglo XXI. */
SELECT NOMBRE, APELLIDOS, FECHA_NAC, TO_CHAR(FECHA_NAC,'YYYY')
FROM ALUMNOS
WHERE FECHA_NAC BETWEEN '01/01/1980' AND '31/12/1989' OR
      FECHA_NAC BETWEEN '01/01/2000' AND '31/12/2009';

/* 29.	Obtener el NOMBRE, APELLIDOS, FECHA_NAC y el a�o de nacimiento de 
cada alumno, de la tabla ALUMNOS de los alumnos nacidos en la d�cada de los 80,
en la d�cada de los 90 y en la primera d�cada del 2000, ordenado por el a�o 
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
de aquellos alumnos cumplan a�os en los 2 pr�ximos meses. */
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
un espacio, y el n�mero y nombre de mes correspondiente de su nacimiento, 
as� como el a�o, de la tabla de ALUMNOS. */
SELECT NOMBRE || ', ' || APELLIDOS,
       TO_CHAR(FECHA_NAC,'MM') "NUMERO MES", 
       TO_CHAR(FECHA_NAC, 'Month') "MES", 
       TO_CHAR(FECHA_NAC, 'YYYY') A�O
    FROM ALUMNOS;

/* 34.	Obtener cuantos alumnos nacieron en el primer trimestre del a�o, 
de la tabla de ALUMNOS. */
SELECT COUNT(*) 
FROM ALUMNOS
WHERE TO_CHAR(FECHA_NAC,'Q')='1';

/* 35.	Convertir la cadena '010712' a fecha y visualizar su nombre de mes en
may�sculas. */
SELECT TO_CHAR(TO_DATE('010712','DD/MM/YY'),'MONTH') FROM DUAL;


-- 36.	Convertir el n�mero 127 a cadena y mostrar el NOMBRE de todos los alumnos si la conversi�n se ha realizado correctamente.
SELECT TO_CHAR(127,'$00G000G000D99') FROM DUAL;
SELECT TO_CHAR(12756780,'00G000G000D99L') FROM DUAL;

ALTER SESSION SET NLS_NUMERIC_CHARACTERS='/*';
ALTER SESSION SET NLS_NUMERIC_CHARACTERS=',.';

SELECT NOMBRE_ALUMNO, NVL (NOTA1, 0)

FROM NOTAS_ALUMNOS;


������������������������������������������������������

37.	Obtener la media de las notas de la primera evaluaci�n, la nota media de la segunda evaluaci�n y la nota media de la tercera evaluaci�n, de la tabla de NOTAS_ALUMNOS.
38.	Obtener la media de las notas de la primera evaluaci�n, la nota media de la segunda evaluaci�n y la nota media de la tercera evaluaci�n, de la tabla de NOTAS_ALUMNOS, si hay alg�n valor que sea null tendremos que sustituirlo por el valor 0. Compara los resultados de esta consulta con el resultado obtenido en la consulta anterior.
39.	Obtener cuantas notas hay en la primera evaluaci�n, cuantas notas hay en la segunda evaluaci�n y cuantas notas hay en la tercera evaluaci�n, de la tabla de NOTAS_ALUMNOS.


