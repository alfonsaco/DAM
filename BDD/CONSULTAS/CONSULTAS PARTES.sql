/*CONSULTA 1*:
	Obtener un listado con el nombre y apellidos del profesor y el número de partes que ha puesto (“NUMERO DE PARTES”), ordenado 
    por el campo apellido. */
SELECT P.NOM_PROFESOR "NOMBRE", P.APE_PROFESOR "APELLIDOS", COUNT(PA.COD_PROFESOR) "CANTIDAD PARTES"
    FROM PROFESORES P JOIN PARTES PA ON P.COD_PROFESOR=PA.COD_PROFESOR
GROUP BY P.NOM_PROFESOR, P.APE_PROFESOR
ORDER BY P.APE_PROFESOR;


/* CONSULTA 2*:
	Mostrar Nombre,  el primer apellido como “PRIMER APELLIDOS”, el segundo apellido como “SEGUNDO APELLIDO” y la población todos 
    los alumnos menos los de 1ºE. Ordenado alfabéticamente por primer apellidos. Consideramos que los alumnos no tienen apellidos compuestos. 
	Ejemplo de cómo debe quedar:*/
SELECT NOM_ALUMNO, TRIM(INITCAP(SUBSTR(APE_ALUMNO, 1, INSTR(APE_ALUMNO,' ')-1))) AS "PRIMER APELLIDO", 
    TRIM(INITCAP(SUBSTR(APE_ALUMNO, INSTR(APE_ALUMNO,' '), LENGTH(APE_ALUMNO)))) AS "SEGUNDO APELLIDO", 
    TRIM(SUBSTR(DIR_ALUMNO, INSTR(DIR_ALUMNO,'$')+1,LENGTH(DIR_ALUMNO))) AS "POBLACION"
    FROM ALUMNOS
    WHERE GRUPO_ALUMNO!='1ºE';


/* CONSULTA 3 *:
	Mostrar el nombre y apellidos de los alumnos a los que se les puso un parte por ‘No traer el material’.   */
SELECT A.NOM_ALUMNO "NOMBRE", A.APE_ALUMNO "APELLIDO", I.NOM_INCIDENCIA "INCIDENCIA"
    FROM ALUMNOS A JOIN PARTES P ON A.COD_ALUMNO=P.COD_ALUMNO
                   JOIN INCIDENCIAS I ON I.COD_INCIDENCIA=P.COD_INCIDENCIA
    WHERE I.COD_INCIDENCIA=10;


/*CONSULTA 4 *:
	Obtener el nombre y apellidos de los alumnos de 1ºB que tienen más de 2 partes. */
SELECT A.NOM_ALUMNO "NOMBRE", A.APE_ALUMNO "APELLIDOS", COUNT(P.COD_ALUMNO) "PARTES"
        FROM ALUMNOS A JOIN PARTES P ON A.COD_ALUMNO=P.COD_ALUMNO
    GROUP BY A.NOM_ALUMNO, A.APE_ALUMNO, A.GRUPO_ALUMNO
        HAVING COUNT(P.COD_ALUMNO)>2
        AND A.GRUPO_ALUMNO='1ºB';


/* CONSULTA 5 *:	
	Obtener los datos de los profesores que tienen un email de gmail.com. Ordenar por apellidos. 
	Los datos deben indicarse EN UN SOLO CAMPO de la siguiente forma:
Apellidos, Nombre (mayúscula) – Grupo: grupo (si lo tiene, en caso contrario ‘Sin asignar). A continuación entre paréntesis, si
el profesor es de tipo 1, pondremos Funcionario de Carrera, si es de tipo 2, Interino. */
    SELECT P.APE_PROFESOR || ', ' || UPPER(P.NOM_PROFESOR) || ' - ' || 
            CASE
                WHEN GRUPO_PROFESOR IS NOT NULL THEN GRUPO_PROFESOR
                ELSE 'SIN ASIGNAR' 
                END
        || ' (' || DECODE(TIPO_PROFESOR, 1, 'Funcionario de Carrera',2, 'Interino') || ')'
        "RESULTADO"
        FROM PROFESORES P
    WHERE P.EMAIL_PROFESOR LIKE '%@gmail.com'
        ORDER BY APE_PROFESOR ASC;


/* CONSULTA 6 *:
Obtener el nombre y el apellido de los alumnos a los que les ha puesto un parte de expulsión el profesor Pedro Madrid. */
SELECT DISTINCT A.NOM_ALUMNO, A.APE_ALUMNO
    FROM ALUMNOS A JOIN PARTES P ON P.COD_ALUMNO=A.COD_ALUMNO
                   JOIN PROFESORES PR ON PR.COD_PROFESOR=P.COD_PROFESOR
    WHERE PR.NOM_PROFESOR='Pedro' AND PR.APE_PROFESOR='Madrid';
	
    
/* CONSULTA 7 * :
  	Se desea valorar si hay alguna relación entre la gravedad de los partes y la hora del día a la cual se ponen a los alumnos. 
    Tened en cuenta que la gravedad de un parte se valora con un número de puntos. Por tanto, hay que construir una consulta que muestre: 
	la hora del día, el número de partes y la media del número de puntos de dichos partes para profesores de tipo 2 y alumnos que 
    no sean de Talavera.  */


 
/* CONSULTA 8*:
	Obtener el nombre y el apellido del alumno que tiene más partes. Muestra también el número de partes. */
select nom_alumno, ape_alumno, count(cod_parte) "N?mero de partes"
from alumnos join partes
using(cod_alumno)
group by nom_alumno, ape_alumno
having count(cod_parte)=(select max(count(cod_alumno))
                        from partes
                        group by cod_alumno); 

/* CONSULTA 9:
	Muestra el nombre del alumno, el apellido, el codigo de expulsión, el periodo de expulsión y el nombre de las incidencia que 
    generaron la expulsión (pueden ser varias). Ordenado por codigo de expulsión. */


CONSULTA 10:
	Mostrar los nombres de las incidencias que generaron partes en 2017 para todo los alumnos de 1º de la ESO.  
