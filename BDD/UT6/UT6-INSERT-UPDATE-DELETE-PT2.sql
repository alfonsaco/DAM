-- ################## ACTIVIDADES INSERT, DELETE, UPDATE ###################
UPDATE  PERSONAL
    SET SALARIO=(SALARIO*1.05) 
WHERE FUNCION LIKE 'PROFESOR';

-- 2. Cambiar la especialidad de un profesor espec�fico.
UPDATE PROFESORES
    SET ESPECIALIDAD=(SELECT ESPECIALIDAD FROM PROFESORES WHERE DNI=9800990)
    WHERE DNI=4123005;
    
-- 3. Cambiar el n�mero de plazas de un centro educativo.
UPDATE CENTROS
    SET NUM_PLAZAS=400
WHERE COD_CENTRO=22;

-- 4. 4. Actualizar el n�mero de tel�fono de un centro educativo.
UPDATE CENTROS
    SET TELEFONO='56487766'
WHERE TELEFONO='925-443400';

-- 5. Cambiar la funci�n de un personal de administraci�n a profesor.
UPDATE PERSONAL
    SET FUNCION='PROFESOR'
WHERE COD_CENTRO=10;

-- 66. Incrementar el salario en un 10% para todos los profesores que trabajan en centros con m�s de 300 plazas:
UPDATE PERSONAL
    SET SALARIO=(SALARIO*1.1)
WHERE FUNCION LIKE 'PROFESOR'
    AND COD_CENTRO IN
        (SELECT COD_CENTRO FROM CENTROS WHERE NUM_PLAZAS>300);
        
-- 7. Disminuir el salario en un 5% para todos los profesores de matem�ticas
UPDATE PERSONAL
    SET SALARIO=SALARIO*0.95
WHERE FUNCION LIKE 'PROFESOR'
    AND dni IN 
        (SELECT DNI
        FROM PROFESORES WHERE ESPECIALIDAD='MATEM�TICAS');
        
-- 8. Aumentar el salario en un 8% para los administrativos que tienen un salario menor que la media de los salarios de los administrativos.
UPDATE PERSONAL
    SET SALARIO=SALARIO*1.08
WHERE FUNCION LIKE 'ADMINISTRATIVO'
    AND SALARIO<
        (SELECT AVG(SALARIO) FROM PERSONAL WHERE FUNCION LIKE 'ADMINISTRATIVO');
        
-- 9. Cambiar la especialidad de los profesores de lengua a literatura si trabajan en centros de tipo "S" (Secundaria).
UPDATE PROFESORES
    SET ESPECIALIDAD='LITERATURA'
WHERE ESPECIALIDAD LIKE 'LENGUA'
    AND COD_CENTRO IN
        (SELECT COD_CENTRO FROM CENTROS WHERE TIPO_CENTRO LIKE 'S');
        
-- 10. Reducir el n�mero de plazas en un 10% para todos los centros que tienen m�s de 500 plazas.
UPDATE CENTROS
    SET NUM_PLAZAS=TRUNC(NUM_PLAZAS, 0)*0.9
WHERE NUM_PLAZAS>500;

-- 11. Modificar el n�mero de plazas con un valor igual a la mitad en aquellos centros con menos de dos profesores.
UPDATE CENTROS
    SET NUM_PLAZAS=NUM_PLAZAS
WHERE 

-- 12. Eliminar los centros que no tengan personal.


-- 13. Borrar al personal que est� en centros de menos de 300 plazas y con menos de dos profesores.


-- 14. Borrar a los profesores que est�n en la tabla PROFESORES y que no est�n en la tabla PERSONAL.


-- 15. Insertar un nuevo centro en la tabla CENTROS con la informaci�n que quieras.


-- 16. Insertar un nuevo centro cuyas plazas sean el m�ximo de plazas de todos los centros.


-- 17. Insertar un nuevo profesor en la tabla PERSONAL. El c�digo del centro ser� 40, el DNI es 46267891, se llamar� Carmen Luque Mart�nez y su salario ser� la media de todos los salarios.

-- 18. Se ha contratado un nuevo profesor de Lengua en el centro en el que trabaja Ana Rivera Silvestre. Ins�rtalo en la tabla de personal con los datos que desees. Realizar el ejercicio utilizando JOIN.


-- 19. Insertar un nuevo centro en la tabla CENTROS. A�ade la informaci�n que quieras, pero el numero de plazas debe ser el doble que el n�mero de plazas del centro en el que trabaja Elisa Bueno Zarco. Realiza el ejercicio utilizando JOIN.








-- �########## VISTAS ##############
CREATE USER NuevoUsuario IDENTIFIED BY contrase�a123
DEFAULT TABLESPACE USUARIOS
QUOTA 100M ON USUARIOS;

ALTER USER UsuarioLimitado IDENTIFIED BY nuevaclase
TEMPORARY TABLESPACE TEMP;

DROP USER UsuarioEliminado;

DROP USER UusarioEliminado2 CASCADE;

ALTER USER Usuario5 IDENTIFIED BY nuevoacceso;

ALTER USER Uusario6 DEFAULT TABLESPACE Usuarios;

--10
GRANT SELECT ON Clientes TO usuario;
--11
GRANT ALL ON VENTAS TO Usuario11;
