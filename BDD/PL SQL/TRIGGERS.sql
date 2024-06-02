/*================================================================
    PARA ESTOS EJERCICIOS, USAMOS LA BASE DE DATOS "DEPART"
=================================================================*/

/*  ###################  EJERCICIO 1  ###################
 Crea un disparador que se ejecute al insertar en DEPART, debe comprobar que el DEPT_NO sea mayor de 0, si no es así 
 hay que hacer que no se inserte el registro en la tabla.
*/
CREATE OR REPLACE TRIGGER COMPROBAR_DEPART BEFORE INSERT
ON DEPART
FOR EACH ROW
DECLARE
    EXCEPCION_MENOR_CERO EXCEPTION;
BEGIN
    IF :NEW.DEPT_NO<=0 THEN
        RAISE EXCEPCION_MENOR_CERO;
    END IF;
    
    EXCEPTION
        WHEN EXCEPCION_MENOR_CERO THEN
            -- Creamos la EXCEPTION. Recordemos que el número que le ponemos a la excepcion DEBE SER NEGATIVO
            RAISE_APPLICATION_ERROR(-20230, 'Número inválido. El número debe ser mayor de 0');
END;
/
-- Prueba unitaria
INSERT INTO DEPART VALUES (-20,'DINERO','BARCELONA');


/*  ###################  EJERCICIO 2  ###################
 Crear un trigger que se ejecute cuando se inserte en emple, hay que comprobar que el oficio sea uno de los que aparece en la tabla EMPLE.
 Abortar el trigger si no es un oficio de los que hay en la tabla 
*/
CREATE OR REPLACE TRIGGER COMPROBAR_OFICIO
BEFORE INSERT
ON EMPLE
FOR EACH ROW
DECLARE
    CONT NUMBER(8):=0;
    EXCEPCION_OFICIO EXCEPTION;
BEGIN
    -- Contador para que si no se encuentra ningun oficio, se quedará en 0, y eso significará que no hay ninguno igual
    -- por lo que este será inválido.
    SELECT COUNT(*) INTO CONT FROM EMPLE
        WHERE OFICIO=:NEW.OFICIO;
    -- Condición
    IF CONT=0 THEN
        RAISE EXCEPCION_OFICIO;
    END IF;
    
    EXCEPTION
        WHEN EXCEPCION_OFICIO THEN
            RAISE_APPLICATION_ERROR(-20022,'Oficio inválido.');
END;
/
SET SERVEROUTPUT ON
SET VERIFY OFF

DECLARE
    NOMBRE INT%TYPE:='&NOMBRE';
BEGIN
    DBMS_OUTPUT.PUT_LINE('HOLA MUNDO');
    DBMS_OUTPUT.PUT_LINE('PEGAR A NEGROS');
    DBMS_OUTPUT.PUT_LINE('HOLA AMACENES ASE');
    DBMS_OUTPUT.PUT_LINE('NOMBRE ES HOLA');
END;
-- Inserción válida
INSERT INTO EMPLE VALUES (4342,'PEREZ','EMPLEADO',4324,'06/08/88',200,2,10);
-- Inserción inválida
INSERT INTO EMPLE VALUES (4242,'PEREZ','CONDUCOR',7724,'06/08/88',200,2,10);


/*  ###################  EJERCICIO 3  ###################
  Crear un trigger que se ejecute cuando se borre un empleado con el oficio ‘PRESIDENTE’. En ese caso hacer que no se ejecute el borrado.
*/
CREATE OR REPLACE TRIGGER EVITAR_BORRADO_PRESIDENTE
BEFORE DELETE
ON EMPLE
FOR EACH ROW
BEGIN
    IF :OLD.OFICIO='PRESIDENTE' THEN
        RAISE_APPLICATION_ERROR(-20002,'No se puede borrar la siguiente fila. Contiene PRESIDENTE');
    END IF;
END;
/
-- Prueba del trigger
DELETE FROM EMPLE WHERE EMP_NO=7839;


/*  ###################  EJERCICIO 4  ###################
  Escribir un disparador que haga fallar cualquier operación de modificación del apellido o del número de un empleado, o que suponga una 
  subida de sueldo superior al 10% en la tabla EMPLE
*/
CREATE OR REPLACE TRIGGER EVITAR_CAMBIOS_EMPLE
BEFORE UPDATE
ON EMPLE
FOR EACH ROW
BEGIN
    IF :NEW.APELLIDO!=:OLD.APELLIDO THEN
        RAISE_APPLICATION_ERROR(-20031,'No se pueden modificar los apellidos');
    ELSIF :NEW.EMP_NO!=:OLD.EMP_NO THEN
        RAISE_APPLICATION_ERROR(-20032,'No se pueden modificar los números de empleado');
    ELSIF :NEW.SALARIO>(:OLD.SALARIO * 1.10) THEN
        RAISE_APPLICATION_ERROR(-20034,'No se puede subir el salario más de un 10%');
    END IF;
END;
/
-- Pruebas de cada UPDATE
UPDATE EMPLE SET EMP_NO=7738 WHERE EMP_NO=7777;
UPDATE EMPLE SET APELLIDO='RAJOY' WHERE APELLIDO='ARROYO';
UPDATE EMPLE SET SALARIO=SALARIO*1.21 WHERE EMP_NO=7777;


/*  ###################  EJERCICIO 5  ###################
  Añadir una columna a la tabla depart, con nombre num_emple. Esta columna debe almacenar el número de empleados de la tabla emple de 
  ese departamento. Se trata de mantener actualizado el número de empleados de la tabla emple que son del departamento. El trigger se va a 
  disparar cuando insertemos, borremos o modifiquemos en la tabla emple. 
*/
ALTER TABLE DEPART ADD NUM_EMPLE NUMBER;

UPDATE DEPART D SET NUM_EMPLE=
    (SELECT COUNT(*) FROM EMPLE E WHERE E.DEPT_NO=D.DEPT_NO);
    
CREATE OR REPLACE TRIGGER ACTUALIZAR_EMPLEADOS
AFTER INSERT OR DELETE OR UPDATE
ON EMPLE
FOR EACH ROW
BEGIN
    -- Inserciones
    IF INSERTING THEN
        UPDATE DEPART SET NUM_EMPLE=NUM_EMPLE+1 
            WHERE DEPT_NO=:NEW.DEPT_NO;
    END IF;
    -- Borrado
    IF DELETING THEN
        UPDATE DEPART SET NUM_EMPLE=NUM_EMPLE-1
            WHERE DEPT_NO=:OLD.DEPT_NO;
    END IF;
    -- Modificaciones
    IF UPDATING THEN
        UPDATE DEPART SET NUM_EMPLE=NUM_EMPLE+1 
            WHERE DEPT_NO=:NEW.DEPT_NO;
        UPDATE DEPART SET NUM_EMPLE=NUM_EMPLE-1
            WHERE DEPT_NO=:OLD.DEPT_NO;
    END IF;
END;
/
-- Pruebas
INSERT INTO EMPLE VALUES (3942,'GARCIA','EMPLEADO',4327,'06/08/88',200,2,10);
UPDATE EMPLE SET DEPT_NO=20 WHERE EMP_NO=3942;
DELETE FROM EMPLE WHERE EMP_NO=3942;


/*  ###################  EJERCICIO 6  ###################
  Escribe un trigger que permita auditar de la tabla EMPLE, las operaciones de inserción y borrado. 
  Para ello se creará la tabla AUDITAEMPLE con una columna de 200 caracteres.
  Cuando se produzca el evento insertar la fecha, la hora, el número de empleado, el apellido y la operación realizada, INSERCIÓN o BORRADO.	
*/
CREATE TABLE AUDITAEMPLE (
    MENSAJE VARCHAR2(500));

CREATE OR REPLACE TRIGGER AUDITAR_EMPLE
AFTER INSERT OR DELETE
ON EMPLE
FOR EACH ROW
DECLARE
    V_MENSAJE VARCHAR2(500):='';
BEGIN
    V_MENSAJE:=SYSDATE || '    ' || TO_CHAR(SYSDATE,'HH:MM:SS');

    IF INSERTING THEN
        V_MENSAJE:=V_MENSAJE || :NEW.DEPT_NO || '    ' || :NEW.APELLIDO || '    ' || 'INSERCION';
    END IF;
    
    IF DELETING THEN
        V_MENSAJE:=V_MENSAJE || :OLD.DEPT_NO || '    ' || :OLD.APELLIDO || '    ' || 'BORRADO';
    END IF;
    
    INSERT INTO AUDITAEMPLE VALUES (V_MENSAJE);
END;
/
-- Pruebas
INSERT INTO EMPLE VALUES (3942,'GARCIA','EMPLEADO',4327,'06/08/88',200,2,10);
DELETE FROM EMPLE WHERE EMP_NO=3942;


/*  ###################  EJERCICIO 7  ###################
  Realizar un trigger para controlar las modificaciones en la tabla EMPLE. Si ocurre una modificación se grabará en audita_emple, la fecha 
  y hora, el número de empleado, el apellido, la operación de MODIFICACIÓN, y además el valor anterior y nuevo de las columnas modificadas, 
  sólo de las columnas modificadas.
*/
CREATE TABLE AUDITA_EMPLE (
    MENSAJE VARCHAR2(500));
    
CREATE OR REPLACE TRIGGER AUDITAR_EMPLEADOS
AFTER INSERT OR DELETE OR UPDATE
ON EMPLE
FOR EACH ROW
DECLARE
    V_MENSAJE VARCHAR2(500):='';
BEGIN
    V_MENSAJE:= :OLD.EMP_NO || '   ' || :OLD.APELLIDO || '   ' || 'MODIFICACION   ';
    
    IF UPDATING ('OFICIO') THEN
        V_MENSAJE:=V_MENSAJE || 'NUEVO OFICIO:   ' || :NEW.OFICIO || '    ANTIGUO OFICIO:   ' || :OLD.OFICIO;
    END IF;
    IF UPDATING ('DIR') THEN
        V_MENSAJE:=V_MENSAJE || 'NUEVA DIRECCION:   ' || :NEW.DIR || '    ANTIGUA DIRECCION:   ' || :OLD.DIR;
    END IF;
    IF UPDATING ('FECHA ALTA') THEN
        V_MENSAJE:=V_MENSAJE || 'NUEVA FECHA:   ' || :NEW.FECHA_ALT || '    ANTIGUA FECHA:   ' || :OLD.FECHA_ALT;
    END IF;
    IF UPDATING ('SALARIO') THEN
        V_MENSAJE:=V_MENSAJE || 'NUEVO SALARIO:   ' || :NEW.SALARIO || '    ANTIGUO SALARIO:   ' || :OLD.SALARIO;
    END IF;
    IF UPDATING ('COMISION') THEN
        V_MENSAJE:=V_MENSAJE || 'NUEVA COMISION:   ' || :NEW.COMISION || '    ANTIGUA COMISION:   ' || :OLD.COMISION;
    END IF;
    
    INSERT INTO AUDITA_EMPLE VALUES (V_MENSAJE);
END;
/
-- Prueba
UPDATE EMPLE SET SALARIO=SALARIO-2304 WHERE EMP_NO=7654;