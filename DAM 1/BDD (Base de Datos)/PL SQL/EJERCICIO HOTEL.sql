SET SERVEROUTPUT ON
SET VERIFY OFF

/* #####################  EJERCICIO 1  #####################
--------------------------------------------------------------------------------------------------------------------------------
Crea una función HABITACION_LIBRE que devuelva TRUE o FALSE. La función recibirá por parámetro un número de habitación y si la habitación 
está actualmente ocupada devolverá TRUE, de lo contrario, devolverá FALSE; Nota: la habitación se considerará libre si la fecha de hoy no está 
entre la fecha de inicio y la fecha de fin. 	
*/
CREATE OR REPLACE FUNCTION HABITACION_LIBRE(P_NUMHAB NUMBER)
RETURN BOOLEAN
IS  
    -- Contador para ver cuantas habitaciones hay de ese numero. SI hay mas de 1, es que esta ocupada
    CONT NUMBER(8):=0;
BEGIN
    -- Consulta para seleccionar el COUNT de habitaciones con un código
    SELECT COUNT(*) INTO CONT FROM RESERVAS 
        WHERE NUMHABITACION=P_NUMHAB AND SYSDATE BETWEEN FECHAENTRADA AND FECHASALIDA;
        
    IF CONT>0 THEN
        RETURN TRUE;
    ELSE 
        RETURN FALSE;
    END IF;
    -- Para lanzar la excepcion en caso de que sea NULL el numero de habitacion
    IF P_NUMHAB IS NULL THEN
        RAISE NO_DATA_FOUND;
    END IF;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error inesperado en la base de datos');
END;
/
-- Prueba unitaria de que la función funciona
DECLARE
    NUMERO_HABITACION RESERVAS.NUMHABITACION%TYPE:='&numero_hab';
BEGIN
    IF HABITACION_LIBRE(NUMERO_HABITACION)=TRUE THEN
        DBMS_OUTPUT.PUT_LINE('La habitacion '||NUMERO_HABITACION||' esta ocupada');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('La habitacion '||NUMERO_HABITACION||' esta libre');
    END IF;
END;
/
/* EJEMPLOS DE PRUEBAS:
        - Habitación libre: 103
        - Habitación ocupada: 302
*/



/* #####################  EJERCICIO 2  #####################
--------------------------------------------------------------------------------------------------------------------------------
Realiza un procedimiento llamado RESERVA_EXPRESS(HAB, CLI). El procedimiento servirá para hacer una reserva con entrada hoy y salida mañana. 
Recibirá por parámetro el número de la habitación y el cliente. 

Inicio
    si no habitacion_libre(hab) entonces
        'habitación no está libre'
    sino 
        Consultar Codigo Cliente
        Consultar Numero Habitacion
        Insertar en Reservas ((Ultima reserva+1), hab, cli, 0, hoy, hoy+1, 0)
    fin si
    Excepciones
        Cuando no se hayan encontrado datos entonces
            Si fue el codigo cliente entonces
                'Codigo cliente no válido'
            Si fue el número de la habitacion entonces
                'Código habitación no válido'
            fin si
        Cuando sea otra entonces
            'Error indeterminado'
Fin

Es OBLIGATORIO capturar la excepción NO_DATA_FOUND. No se pueden usar CONTADORES ni variables booleanas para controlar la inserción. 
*/
CREATE OR REPLACE PROCEDURE RESERVA_EXPRESS(V_NUMHAB RESERVAS.NUMHABITACION%TYPE, V_CODCLI RESERVAS.CODIGOCLIENTE%TYPE)
IS
    -- Declaramos contadores
    CONT_CLIENTE NUMBER(8):=0;
    CONT_HAB NUMBER(8):=0;
    -- Declaramos excepciones
    EXCEPCION_CLIENTE EXCEPTION;
    EXCEPCION_HAB EXCEPTION;
BEGIN
    IF HABITACION_LIBRE(V_NUMHAB)=TRUE THEN
        DBMS_OUTPUT.PUT_LINE('La habitacion '||V_NUMHAB||' esta ocupada');
    ELSE
        SELECT COUNT(*) INTO CONT_CLIENTE FROM CLIENTES
            WHERE CODIGOCLIENTE=V_CODCLI;
        SELECT COUNT(*) INTO CONT_HAB FROM HABITACIONES
            WHERE NUMHABITACION=V_NUMHAB;
        -- Lanzamos excepciones en caso de que el cliente no exista o la cama no exista
        IF CONT_CLIENTE=0 THEN
            RAISE EXCEPCION_CLIENTE;
        END IF;
        IF CONT_HAB=0 THEN
            RAISE EXCEPCION_HAB;
        END IF;
        -- Insercion
        INSERT INTO RESERVAS VALUES ((SELECT MAX(CODRESERVA) FROM RESERVAS)+1, V_NUMHAB,V_CODCLI,0,SYSDATE,SYSDATE+1,0);
        DBMS_OUTPUT.PUT_LINE('Datos insertados');
    END IF;
    
    -- Excepciones
    IF V_NUMHAB IS NULL THEN
        RAISE NO_DATA_FOUND;
    END IF;
    EXCEPTION 
        WHEN EXCEPCION_CLIENTE THEN
            DBMS_OUTPUT.PUT_LINE('Codigo cliente no válido');
        WHEN EXCEPCION_HAB THEN
            DBMS_OUTPUT.PUT_LINE('Código habitación no válido');
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Valor demasiado largo');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error indeterminado');
END;
/
-- Llamamos al procedimiento
DECLARE
    N_HAB RESERVAS.NUMHABITACION%TYPE:='&numero_habitacion';
    COD_CLIENTE RESERVAS.CODIGOCLIENTE%TYPE:='&codigo_cliente';
BEGIN
    RESERVA_EXPRESS(N_HAB, COD_CLIENTE);
END;
/


/* #####################  EJERCICIO 3  #####################
--------------------------------------------------------------------------------------------------------------------------------
a)	Añade un campo a la tabla HABITACIONES, llamado NUMRESERVAS.

b)	Actualiza el valor del campo NUMRESERVAS con el número de veces que se 
ha reservado cada habitación.

c)	Crea un TRIGGER que mantenga actualizado este campo en los siguientes casos:
a.	Al realizarse una nueva reserva, incrementando el valor del campo. 
b.	Cuando se produzca una cancelación (borrado), restando en uno el valor del campo.
c.	Cuando el usuario decida cambiar de habitación, sumando o restando según corresponda. Solo debe contemplarse la modificación del campo 
número de la habitación.
*/

-- A) Añadimos columna NUMRESERVAS a HABITACIONES
ALTER TABLE HABITACIONES ADD NUMRESERVAS NUMBER(8);

-- B) Actualizamos NUMRESERVAS
UPDATE HABITACIONES H SET H.NUMRESERVAS=
    (SELECT COUNT(*) FROM RESERVAS R WHERE R.NUMHABITACION=H.NUMHABITACION);
    
-- C) Creación de Trigger
CREATE OR REPLACE TRIGGER ACTUALIZAR_NUMRESERVAS
AFTER INSERT OR DELETE OR UPDATE
ON RESERVAS
FOR EACH ROW

BEGIN
    -- Inserción
    IF INSERTING THEN
        UPDATE HABITACIONES SET NUMRESERVAS=NUMRESERVAS+1
            WHERE NUMHABITACION=:NEW.NUMHABITACION;
    END IF;
    -- Delete
    IF DELETING THEN
        UPDATE HABITACIONES SET NUMRESERVAS=NUMRESERVAS-1
            WHERE NUMHABITACION=:OLD.NUMHABITACION;
    END IF;
    -- Modificación
    IF UPDATING('NUMHABITACION') THEN
        -- Resta a la que tengan el mismo codigo que el codigo anterior
        UPDATE HABITACIONES SET NUMRESERVAS=NUMRESERVAS-1
            WHERE NUMHABITACION=:OLD.NUMHABITACION;
        -- Suma a las que tengan el codigo nuevo
        UPDATE HABITACIONES SET NUMRESERVAS=NUMRESERVAS+1
            WHERE NUMHABITACION=:NEW.NUMHABITACION;
    END IF;
END;
/

-- Pruebas unitarias
INSERT INTO RESERVAS VALUES (29, 101,2,0,SYSDATE,SYSDATE+1,0);
UPDATE RESERVAS SET NUMHABITACION=103 WHERE CODRESERVA=29;
DELETE FROM RESERVAS WHERE CODRESERVA=29;



/* #####################  EJERCICIO 3  #####################
--------------------------------------------------------------------------------------------------------------------------------
Realizar un PROCEDURE haciendo uso de cursores que muestre para cada habitación, las reservas que ha tenido de la forma que aparece en el listado. 
Además, por habitación, hay que indicar cuántas de esas reservas han contratado camas supletorias. 
Al final del listado, habrá que informar sobre el NÚMERO DE CAMAS SUPLETORIAS TOTAL que han contratado los clientes y la media de camas por reserva. 
*/
CREATE OR REPLACE PROCEDURE MOSTRAR_RESERVAS_HAB
IS
    CURSOR C1 IS
        SELECT DISTINCT(NUMHABITACION), NOMBREHABITACION, TIPO FROM HABITACIONES;
    REGHABITACIONES C1%ROWTYPE;
    
    CURSOR C2 (NUMHAB RESERVAS.NUMHABITACION%TYPE) IS
        SELECT C.NOMBRECLIENTE, C.APELLIDO, C.PAIS, R.FECHAENTRADA, R.FECHASALIDA FROM CLIENTES C
            JOIN RESERVAS R ON C.CODIGOCLIENTE=R.CODIGOCLIENTE WHERE R.NUMHABITACION=NUMHAB;
    REGCLIENTES C2%ROWTYPE;
    
    TOTAL_SUPLEMETORIAS NUMBER(8);
    MEDIA_CAMAS NUMBER(8);
    SUM_SUPLETORIAS NUMBER(8):=0;
BEGIN
    SELECT SUM(CAMASSUPLETORIAS) INTO TOTAL_SUPLEMETORIAS FROM RESERVAS;
    SELECT AVG(CAMASSUPLETORIAS) INTO MEDIA_CAMAS FROM RESERVAS;
    
    OPEN C1;
    LOOP
        FETCH C1 INTO REGHABITACIONES;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('HABITACIÓN: ' || RPAD(REGHABITACIONES.NOMBREHABITACION,19,' ') ||
                             'NUMERO: ' || RPAD(REGHABITACIONES.NUMHABITACION,19,' ') ||
                             'TIPO: ' || REGHABITACIONES.TIPO);
        DBMS_OUTPUT.PUT_LINE('==============================================================================');
        DBMS_OUTPUT.PUT_LINE('CLIENTE                                   PAIS          ENTRADA         SALIDA');
        DBMS_OUTPUT.PUT_LINE('-----------------------------------   -------------  -------------  ----------');
        
        OPEN C2(REGHABITACIONES.NUMHABITACION);
        LOOP
            SELECT SUM(CAMASSUPLETORIAS) INTO SUM_SUPLETORIAS FROM RESERVAS
                WHERE NUMHABITACION=REGHABITACIONES.NUMHABITACION;
            FETCH C2 INTO REGCLIENTES;
            EXIT WHEN C2%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(RPAD(REGCLIENTES.NOMBRECLIENTE,7,' ') || ' ' || RPAD(REGCLIENTES.APELLIDO,30,' ') ||
                                RPAD(REGCLIENTES.PAIS,15,' ') ||
                                RPAD(REGCLIENTES.FECHAENTRADA,15
                                ,' ') ||
                                REGCLIENTES.FECHASALIDA);
        END LOOP;
        CLOSE C2;
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('RESERVAS CON CAMAS SUPLETORIAS: ' || SUM_SUPLETORIAS);
    DBMS_OUTPUT.PUT_LINE('==============================================================================');
    
    SUM_SUPLETORIAS:=0;
    END LOOP;
    CLOSE C1;
    DBMS_OUTPUT.PUT_LINE('NUMERO TOTAL DE CAMAS SUPLEMETORIAS: ' || TOTAL_SUPLEMETORIAS);
    DBMS_OUTPUT.PUT_LINE('MEDIA DE CAMAS POR RESERVA: ' || MEDIA_CAMAS || ' CAMAS');
END;
/

DECLARE
    
BEGIN
    MOSTRAR_RESERVAS_HAB;
END;
/