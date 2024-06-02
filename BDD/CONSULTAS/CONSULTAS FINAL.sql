/*1-	Visualiza las asignaturas de tipo A asignadas a cursos cuyo precio sea 200 �. 
       En el listado debe aparecer el CODASIG (tres caracteres como aparece en la imagen), NOMBREASIG (may�scula) y DENOMINACI�N, en este 
       orden. Los alias de cada campo aparecen en la imagen. */
SELECT TO_CHAR(A.CODASIG,'000') "CODIGO", UPPER(A.NOMBREASIG) "ASIGNATURA", C.DENOMINACION "DENOMINACION CURSO", A.PRECIOASIG, A.TIPOASIG, A.CREDITOS, A.NUM_ALUMNOS FROM ASIGNATURAS A
    JOIN CURSOASIG X ON X.CODASIG=A.CODASIG
    JOIN CURSOS C ON X.CODCURSO=C.CODCURSO
    WHERE A.TIPOASIG='A' AND A.PRECIOASIG<200;
	

/*2-	 Visualizar el c�digo de los alumnos, el nombre, la direcci�n (en el formato que aparece en la imagen: poblaci�n, direcci�n), el
n�mero total de asignaturas y la nota media de todos los alumnos de Talavera:*/
SELECT A.CODALUM, A.NOMBRE, A.POBLACION || ',' || LPAD(A.DIRECCION,15,' ') "DIRECCION", COUNT(AG.CODASIG) "TOTAL ASIGNATURAS", AVG(M.NOTAASIG) "MEDIA"
    FROM ALUMNOS A
        JOIN MATRICULAS M ON A.CODALUM=M.CODALUM
        JOIN ASIGNATURAS AG ON AG.CODASIG=M.CODASIG
    GROUP BY A.CODALUM, A.NOMBRE, A.POBLACION || ',' || LPAD(A.DIRECCION,15,' ');


/*3-	Mostrar el c�digo del alumno, el nombre, la poblaci�n, el nombre del representante y el tel�fono del representante en este orden, 
ordenados por el c�digo del alumno.  No deben aparecer los alumnos representantes en el listado. */
SELECT 
    a.CODALUM,
    a.NOMBRE,
    a.POBLACION,
    r.NOMBRE AS NOMBRE_REPRESENTANTE,
    r.TELEF AS TELEFONO_REPRESENTANTE
FROM 
    ALUMNOS a
LEFT JOIN 
    ALUMNOS r
ON 
    a.CODREPRESENTANTE = r.CODALUM
WHERE 
    a.CODALUM NOT IN (SELECT DISTINCT CODREPRESENTANTE FROM ALUMNOS WHERE CODREPRESENTANTE IS NOT NULL)
ORDER BY 
    a.CODALUM;


/* 4-	Informaci�n de todos los cursos en los que ha estado matriculada ALICIA. */
SELECT C.CODCURSO, C.DENOMINACION, C.PRECIO, C.NIVEL, C.FECHA_ALTA FROM CURSOS C
        JOIN CURSOASIG X ON C.CODCURSO=X.CODCURSO
        JOIN ASIGNATURAS A ON A.CODASIG=X.CODASIG
        JOIN MATRICULAS M ON M.CODASIG=A.CODASIG
        JOIN ALUMNOS AL ON AL.CODALUM=M.CODALUM
    WHERE AL.NOMBRE LIKE '%Alicia%';
 

/*5.    Por cada curso el n�mero de asignaturas de cada tipo de asignatura. Obtener esta salida */
SELECT C.CODCURSO, C.DENOMINACION, 
        COUNT(CASE WHEN a.TIPOASIG = 'A' THEN 1 END) AS TIPO_A,
        COUNT(CASE WHEN a.TIPOASIG = 'B' THEN 1 END) AS TIPO_B,
        COUNT(CASE WHEN a.TIPOASIG = 'C' THEN 1 END) AS TIPO_C,
        COUNT(CASE WHEN a.TIPOASIG = 'D' THEN 1 END) AS TIPO_D
    FROM CURSOS C JOIN CURSOASIG X ON C.CODCURSO=X.CODCURSO
                  JOIN ASIGNATURAS A ON X.CODASIG=A.CODASIG
    GROUP BY C.CODCURSO, C.DENOMINACION;
    
 
/* 6-	 Obtener el c�digo del alumno y su nombre y el c�digo de las asignaturas y el nombre en las que est�n matriculados y pertenecen a un
curso de nivel avanzado. */
SELECT A.CODALUM, A.NOMBRE, AG.CODASIG, AG.NOMBREASIG
    FROM ALUMNOS A JOIN MATRICULAS M ON M.CODALUM=A.CODALUM
                   JOIN ASIGNATURAS AG ON AG.CODASIG=M.CODASIG
                   JOIN CURSOASIG X ON X.CODASIG=AG.CODASIG
                   JOIN CURSOS C ON X.CODCURSO=C.CODCURSO
    WHERE C.NIVEL LIKE '%Avanzado%'
    ORDER BY A.NOMBRE ASC;
