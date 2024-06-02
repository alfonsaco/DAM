SET SERVEROUTPUT ON
SET VERIFY OFF


-- ##########################  EJERCICIO 1  ##########################
/*
  Crear un procedimiento almacenado al que le pasaremos un código de academia, de tal forma que nos mostrará todos sus profesores y para 
  cada profesor los datos de los opositores que se han preparado en esa academia.
*/
CREATE OR REPLACE PROCEDURE MOSTRAR_PROFESORES(P_CODACA OPOSITOR_ACADEMIA_PROFESOR.COD_ACADEMIA%TYPE)
IS
    CURSOR C1 IS
        SELECT UNIQUE(P.COD_PROFESOR), P.APE_PROFESOR, P.NOM_PROFESOR, P.EMAIL_PROFESOR FROM PROFESORES P JOIN OPOSITOR_ACADEMIA_PROFESOR X ON X.COD_PROFESOR=P.COD_PROFESOR
            WHERE X.COD_ACADEMIA=P_CODACA;
    -- Rowtype del cursor 1
    REGPROFESORES C1%ROWTYPE;
    
    CURSOR C2 (CODPROF PROFESORES.COD_PROFESOR%TYPE) IS
        SELECT * FROM OPOSITORES O JOIN OPOSITOR_ACADEMIA_PROFESOR X ON X.COD_OPOSITOR=O.COD_OPOSITOR 
            WHERE CODPROF=X.COD_PROFESOR;
    -- Rowtype del cursor 2
    REGOPOSITORES C2%ROWTYPE;
    
    NOMBRE_ACADEMIA ACADEMIAS.NOM_ACADEMIA%TYPE;
    
    -- Contador, para decir al final la cantidad de profesores y alumnos hay en total
    CONTADOR_PROF NUMBER(8):=0;
    CONTADOR_ALUM NUMBER(8):=0;
BEGIN
    SELECT NOM_ACADEMIA INTO NOMBRE_ACADEMIA FROM ACADEMIAS
        WHERE COD_ACADEMIA=P_CODACA;
    DBMS_OUTPUT.PUT_LINE('NOMBRE DE LA ACADEMIA: '||NOMBRE_ACADEMIA);
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------');
    OPEN C1;
    LOOP
        FETCH C1 INTO REGPROFESORES;
        EXIT WHEN C1%NOTFOUND;
        -- If para ver la cantidad de profesores. En el caso de que se encuentre una fila en el C1, (Usando el %FOUND), se sumará
        -- 1 al contador
        IF C1%FOUND THEN
            CONTADOR_PROF:=CONTADOR_PROF+1;
        END IF;
        DBMS_OUTPUT.PUT_LINE('NOMBRE PROFESOR: '||REGPROFESORES.NOM_PROFESOR);
        DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('NOMBRE ALUMNO        APELLIDOS ALUMNO       FECHA NACIMIENTO');
        DBMS_OUTPUT.PUT_LINE('-------------        ----------------       ----------------');
        
        OPEN C2(REGPROFESORES.COD_PROFESOR);
        LOOP
            FETCH C2 INTO REGOPOSITORES;
            EXIT WHEN C2%NOTFOUND;
            IF C2%FOUND THEN
                CONTADOR_ALUM:=CONTADOR_ALUM+1;
            END IF;
            DBMS_OUTPUT.PUT_LINE(RPAD(INITCAP(REGOPOSITORES.NOM_OPOSITOR),21,' ') ||
                    RPAD(INITCAP(REGOPOSITORES.APE_OPOSITOR),23,' ') ||
                    REGOPOSITORES.FECHA_NAC);
        END LOOP;
        CLOSE C2;
        DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    END LOOP;
    CLOSE C1;
    DBMS_OUTPUT.PUT_LINE('TOTAL DE PROFESORES: ' || RPAD(CONTADOR_PROF, 19,' ') ||
                         'TOTAL DE ALUMNOS: ' || CONTADOR_ALUM);
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('DATOS NO ENCONTRADOS');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ERROR INESPERADO');
END;
/
-- Llamamos al procedimiento
DECLARE
    CODIGO OPOSITOR_ACADEMIA_PROFESOR.COD_ACADEMIA%TYPE:='&codigo';
BEGIN
    MOSTRAR_PROFESORES(CODIGO);
END;
/


--------------------------------------------------------------------------------------------------------------------------------------

-- ##########################  EJERCICIO 2  ##########################
/*
2.	Realizar un trigger para controlar las operaciones de inserción, modificación y borrado en la tabla de OPOSITORES. 
?	Si se realiza una operación de inserción se grabará en AUDITA_OPOSITORES, la fecha y la hora, “INSERCIÓN”.
?	Si se realiza una operación de modificación sobre los campos nombre, apellidos, se grabará en AUDITA_OPOSITORES, la fecha y hora, 
--“MODIFICACIÓN”, y además el valor anterior y nuevo de las columnas modificadas, sólo de las columnas modificadas.
?	Si se realiza una operación de borrado se grabará en AUDITA_OPOSITORES, la fecha y la hora, “BORRADO” y además todos los datos del 
--usuario que se ha borrado.
La tabla AUDITA_OPOSITORES, no existe, debes crearla utilizado el lenguaje de definición de datos, con un campo que tenga suficiente tamaño, 
--para almacenar los datos que se piden. Debes incluir el código para la creación de la tabla, junto con la respuesta a la pregunta.
*/

-- Creamos la tabla con el mensaje.
CREATE TABLE AUDITA_OPOSITORES (
    MENSAJE VARCHAR2(500));
    
-- Trigger
CREATE OR REPLACE TRIGGER CONTROLAR_OPOSITORES
AFTER INSERT OR UPDATE OR DELETE
ON OPOSITORES
FOR EACH ROW
DECLARE 
    P_MENSAJE VARCHAR2(500):='';
BEGIN
    -- Configuramos el mensaje inicial, para que ya vaya teniendo la fecha y hora siempre
    P_MENSAJE:='FECHA: ' || SYSDATE || '   HORA: ' || TO_CHAR(SYSDATE,'HH:MM:SS');
    -- Función de insertar
    IF INSERTING THEN 
        P_MENSAJE:=P_MENSAJE|| '   INSERCION';
    END IF;
    -- Función de borrar
    IF DELETING THEN
        P_MENSAJE:=P_MENSAJE|| '   BORRADO' || '   CODIGO: ' || :OLD.COD_OPOSITOR || '   NOMBRE: ' || :OLD.NOM_OPOSITOR || '   APELLIDOS: ' || :OLD.APE_OPOSITOR || '   FECHA NACIMIENTO: ' || :OLD.FECHA_NAC;
    END IF;
    -- Haremos un IF distinto para cada uno de los posibles casos
    IF UPDATING('NOM_OPOSITOR') THEN
        P_MENSAJE:=P_MENSAJE || '   NUEVO NOMBRE: ' || :NEW.NOM_OPOSITOR || '   ANTIGUO NOMBRE: ' || :OLD.NOM_OPOSITOR;
    END IF;
    IF UPDATING('APE_OPOSITOR') THEN
        P_MENSAJE:=P_MENSAJE || '   NUEVOS APELLIDOS: ' || :NEW.APE_OPOSITOR || '   ANTIGUOS APELLIDOS: ' || :OLD.APE_OPOSITOR;
    END IF;
    IF UPDATING('FECHA_NAC') THEN
        P_MENSAJE:=P_MENSAJE || '   NUEVA FECHA NACIMIENTO: ' || :NEW.FECHA_NAC || '   ANTIGUA FECHA NACIMIENTO: ' || :OLD.FECHA_NAC;
    END IF;
    -- Finalmente, tras haber hecho todos los posibles casos, agregamos el mensaje final a la tabla
    INSERT INTO AUDITA_OPOSITORES VALUES (P_MENSAJE);
END;
/

-- Pruebas de cada uno de los procedimientos
INSERT INTO OPOSITORES VALUES (100, 'Scott','Michael','20/04/88');
UPDATE OPOSITORES SET NOM_OPOSITOR='Dwigth' WHERE COD_OPOSITOR=100;
UPDATE OPOSITORES SET APE_OPOSITOR='Scruzt' WHERE COD_OPOSITOR=100;
UPDATE OPOSITORES SET FECHA_NAC='06/06/96' WHERE COD_OPOSITOR=100;
DELETE FROM OPOSITORES WHERE COD_OPOSITOR=100;