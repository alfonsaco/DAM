SET SERVEROUTPUT ON
SET VERIFY OFF

/* Programa que lea de teclado un DNI de jugador con variables de sustituci�n y 
visualice el nombre, apellidos y posici�n del jugador. El listado que obtendremos es el siguiente:
DNI JUGADOR: XXXXXXXXX
NOMBRE     APELLIDO     POSICION     
-------   ----------- -------------
xxxxxx    xxxxxxxxxx    xxxxxxxxxx     
xxxxxx    xxxxxxxxxx    xxxxxxxxxx     

*/

DECLARE
    CURSOR C1 IS 
        SELECT NOMBRE_JUGADOR, APELLIDOS_JUGADOR, POSICION, EDAD_JUGADOR, DNI_JUGADOR
        FROM JUGADORES;
    -- Declaramos variable de tipo registro que se basa en la estructura de la tabla que recorre C1
    REG_C1 C1%ROWTYPE;
    DNI_JUGAGOR JUGADORES.DNI_JUGADOR%TYPE; -- DNI DEL JUGADOR
           
    DNI_INSERTADO JUGADORES.DNI_JUGADOR%TYPE;
    REG_JUG JUGADORES%ROWTYPE;
BEGIN
    DNI_INSERTADO:= '&DNI_INSERTADO'; -- Solicitar y asignar el DNI del jugador
    -- Buscamos el jugador con dicho DNI
    SELECT * INTO REG_JUG
    FROM JUGADORES
    WHERE UPPER(TRIM(DNI_JUGADOR)) = UPPER(TRIM(DNI_INSERTADO));
    
    DBMS_OUTPUT.PUT_LINE(' NOMBRE          APELLIDOS         POSICION         EDAD JUGADOR' );
    DBMS_OUTPUT.PUT_LINE('--------        -----------       ------------    ----------------');
    
    OPEN C1;
    FETCH C1 INTO REG_C1;
    
    WHILE C1%FOUND LOOP
        IF UPPER(REG_C1.DNI_JUGADOR) = UPPER(DNI_INSERTADO) THEN
            DBMS_OUTPUT.PUT_LINE(RPAD(REG_C1.NOMBRE_JUGADOR, 19, ' ') ||
                                 RPAD(REG_C1.APELLIDOS_JUGADOR, 19, ' ') ||
                                 RPAD(REG_C1.POSICION, 20, ' ') ||
                                 RPAD(REG_C1.EDAD_JUGADOR, 15, ' '));
        END IF;
        -- Obtenemos la fila de resultados en el cursor C1
        FETCH C1 INTO REG_C1;
    END LOOP;
    CLOSE C1;
    
EXCEPTION
    -- Excepcion para el caso en el que el dni introducido no esta disponible en la base de datos
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('EL DNI ' || DNI_INSERTADO || ' NO SE ENCUENTRA EN LA BASE DE DATOS');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error inesperado');
END;