SET SERVEROUTPUT ON
SET VERIFY OFF

/*#######################  EJERCICIO 1  #########################
------------------------------------------------------------------------------------------------------------------------------------------
Crear un procedimiento almacenado al que le pasaremos un c�digo de avi�n, de tal forma que nos mostrar� todos sus vuelos y para cada vuelo 
los datos de los pasajeros que lo han reservado. Se debe indicar por cada vuelo, el n�mero de pasajeros y al final, el n�mero total de los 
pasajeros. 
*/

CREATE OR REPLACE PROCEDURE MOSTRAR_VUELOS(P_CODAVION AVIONES.COD_AVION%TYPE)
IS
    -- Primer cursor y el ROWTYPE
    CURSOR C1 IS
        SELECT V.COD_VUELO, V.ORIGEN_VUELO, V.DESTINO_VUELO, V.FECHA_VUELO, V.HORA_VUELO, V.COD_AVION
            FROM AVIONES A JOIN VUELOS V ON A.COD_AVION=V.COD_AVION
                WHERE V.COD_AVION=P_CODAVION;
    REGAVIONES C1%ROWTYPE;
    
    -- Segundo cursor y el ROWTYPE
    CURSOR C2(CODVUELO VUELOS.COD_VUELO%TYPE) IS
        SELECT P.COD_PASAJERO, P.APE_PASAJERO, P.NOM_PASAJERO, P.DIR_PASAJERO, P.TEL_PASAJERO 
            FROM PASAJEROS P JOIN RESERVAS R ON R.COD_PASAJERO=P.COD_PASAJERO
            JOIN VUELOS V ON R.COD_VUELO=V.COD_VUELO
            WHERE V.COD_VUELO=CODVUELO;
    REGPASAJEROS C2%ROWTYPE;
    
    -- Nombre del avi�n
    NOMBRE_AVION AVIONES.NOM_AVION%TYPE;
    
    -- Numeros de pasajeros
    NUMERO_PASAJEROS NUMBER(8):=0;
    NUMERO_PASAJEROS_TOTAL NUMBER(8):=0;
BEGIN
    -- Seleccionamos el nombre del avi�n
    SELECT NOM_AVION INTO NOMBRE_AVION FROM AVIONES WHERE COD_AVION=P_CODAVION;
    DBMS_OUTPUT.PUT_LINE('NOMBRE DEL AVI�N: '||NOMBRE_AVION);
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------------------------------------');
        
    -- Primer cursor
    OPEN C1;
    LOOP
        FETCH C1 INTO REGAVIONES;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ORIGEN VUELO: ' || RPAD(REGAVIONES.ORIGEN_VUELO, 19,' ') ||
                             'DESTINO VUELO: ' || RPAD(REGAVIONES.DESTINO_VUELO,18,' ') ||
                             'FECHA VUELO: ' || REGAVIONES.FECHA_VUELO);
        DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('  NOMBRE              APELLIDOS                   DIRECCI�N                  TEL�FONO  ');
        DBMS_OUTPUT.PUT_LINE('----------          -------------              --------------              ------------');
        -- Segundo cursor 
        OPEN C2(REGAVIONES.COD_VUELO);
        LOOP
            FETCH C2 INTO REGPASAJEROS;
            EXIT WHEN C2%NOTFOUND;
            -- Parte para ver la cantidad de pasajeros por vuelo. Para hacerlo sencillo, haremos una condicional como contador,
            -- ya que cada orden del LOOP es un nuevo pasajero
            IF C2%FOUND THEN
                NUMERO_PASAJEROS:=NUMERO_PASAJEROS+1;
            END IF;
            DBMS_OUTPUT.PUT_LINE(RPAD(REGPASAJEROS.NOM_PASAJERO,20,' ') ||
                                 RPAD(REGPASAJEROS.APE_PASAJERO,22,' ') ||
                                 RPAD(REGPASAJEROS.DIR_PASAJERO,33,' ') ||
                                 REGPASAJEROS.TEL_PASAJERO);
            NUMERO_PASAJEROS_TOTAL:=NUMERO_PASAJEROS_TOTAL+1;
        END LOOP;
        CLOSE C2;
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('                                                             NUMERO DE PASAJEROS: '||NUMERO_PASAJEROS);
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------------------------------------');
    NUMERO_PASAJEROS:=0;
    END LOOP;
    CLOSE C1;
    -- Total final
    DBMS_OUTPUT.PUT_LINE('N�MERO PASAJEROS TOTAL: ' || NUMERO_PASAJEROS_TOTAL);

    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No encontrado');
        WHEN OTHERS THEN 
            DBMS_OUTPUT.PUT_LINE('Error inesperado en la base de datos');
END;
/

-- Llamamos al procedimiento
DECLARE
    CODIGO VUELOS.COD_AVION%TYPE:='&codigo';
BEGIN
    MOSTRAR_VUELOS(CODIGO);
END;
/
/*
    %%%%%%%%%%%%%%%%%  RECORDATORIO  %%%%%%%%%%%%%%%%%
    Para declarar el segundo CURSOR, la VARIABLE que tenemos que pasarle es la que enlaza con el primer cursor.
    Es decir, con este ejemplo:
        CURSOR C2(CODVUELO VUELOS.COD_VUELO%TYPE;
            - CODVUELO es una variable que estamos creando
            - Lo otro es el tipo de dato
    En nuestro ejemplo, primero obtenems los vuelos con el C1. Luego con el C2, obtenemos los pasajeros que hay
    en ese vuelo, por tanto, lo que une al C1 del C2, es el c�digo del vuelo.
    Una vez declarado, al llamarlo pasa lo siguiente:
        OPEN C2(REGAVIONES.COD_VUELO);
            1. Utilizamos el ROWTYPE del C1, no del C2, ya que es de donde obtendremos el COD_VUELO
                para obtener los pasajeros
            2. Ponemos COD_VUELO ya que es el dato que queremos
        
        

/*#######################  EJERCICIO 2  ########################
------------------------------------------------------------------------------------------------------------------------------------------
    Realizar un trigger para controlar las operaciones de inserci�n, modificaci�n y borrado en la tabla de pasajeros. 
?	Si se realiza una operaci�n de inserci�n se grabar� en AUDITA_PASAJEROS la siguiente cadena: 
     �INSERCI�N [dd-mm-yy hh:mm]: cod_pasajero apellido_pasajero, nombre_pasajero�
?	Si se realiza una operaci�n de modificaci�n sobre los campos nombre, apellidos o direcci�n, se grabar� en AUDITA_PASAJEROS la siguiente cadena:
     �MODIFICACI�N [dd-mm-yy hh:mm]: cod_pasajero apellido_pasajero_ANTIGUO, nombre_pasajero_ANTIGUO cambia a apellido_pasajero_NUEVO, 
     nombre_pasajero_NUEVO�
?	Si se realiza una operaci�n de borrado se grabar� en AUDITA_PASAJEROS la siguiente cadena:
�BORRADO [dd-mm-yy hh:mm]: cod_pasajero �
La tabla AUDITA_PASAJEROS, no existe, debes crearla con un campo que tenga suficiente tama�o, para almacenar los datos que se piden.
*/*/
CREATE TABLE AUDITA_PASAJEROS (
    MENSAJE VARCHAR2(500));

-- Trigger
CREATE OR REPLACE TRIGGER CONTROL_OPERACIONES_VUELO
AFTER INSERT OR DELETE OR UPDATE
ON PASAJEROS
FOR EACH ROW
DECLARE
    P_MENSAJE VARCHAR2(500):='';
BEGIN
    -- Inserci�n
    IF INSERTING THEN
        P_MENSAJE:='INSERCION   ' || TO_CHAR(SYSDATE,'dd-mm-yy hh:mm') || ':   ' || :NEW.COD_PASAJERO || '   ' || :NEW.APE_PASAJERO || '   ' || :NEW.NOM_PASAJERO;
    END IF;
    
    -- Borrado
    IF DELETING THEN
        P_MENSAJE:='INSERCION   ' || TO_CHAR(SYSDATE,'dd-mm-yy hh:mm') || ':   ' || :OLD.COD_PASAJERO;
    END IF;
    
    -- Update
    IF UPDATING THEN
        P_MENSAJE:='MODIFICACION   ' || TO_CHAR(SYSDATE,'dd-mm-yy hh:mm') || ':   ' || :OLD.APE_PASAJERO || ' ' || :OLD.NOM_PASAJERO || ' cambia a ' || :NEW.APE_PASAJERO || ' ' || :NEW.NOM_PASAJERO;
    END IF;
    INSERT INTO AUDITA_PASAJEROS VALUES (P_MENSAJE);
END;
/

-- Pruebas para cada operaci�n
INSERT INTO PASAJEROS VALUES (100, 'Pepas','Llamas','Calle Klk','534534543');
UPDATE PASAJEROS SET NOM_PASAJERO='Guillermo' WHERE COD_PASAJERO=100;
UPDATE PASAJEROS SET APE_PASAJERO='Randy' WHERE COD_PASAJERO=100;
UPDATE PASAJEROS SET NOM_PASAJERO='Victor', APE_PASAJERO='Moncho' WHERE COD_PASAJERO=100;
DELETE PASAJEROS WHERE COD_PASAJERO=100;