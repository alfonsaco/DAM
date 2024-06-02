--SET VERIFY OFF
--SET SERVEROUTPUT ON


-- EJERCICIO 1
-- Pediremos al usuario que agregue datos en la tabla EQUIPOS. En caso de que estén mal introducidos, mostraremos un mensaje de ERROR
-- mediante EXCEPCIONES
DECLARE
    equ_nom EQUIPOS.NOMBRE_EQUIPO%TYPE:='&equ_nom';
    equ_ciu EQUIPOS.CIUDAD%TYPE:='&equ_ciu';
    equ_con EQUIPOS.CONFERENCIA%TYPE:='&equ_con';
    equ_mvp EQUIPOS.NUM_MPVS%TYPE:='&equ_mvp';
    equ_cam EQUIPOS.NUM_CAMPEONATOS%TYPE:='&equ_cam';
    equ_cod EQUIPOS.CODIGO_EQUIPO%TYPE:='&equ_cod';
    equ_mas EQUIPOS.ID_MASCOTA%TYPE:='&equ_mas';
BEGIN
    INSERT INTO
        EQUIPOS
    VALUES (equ_nom, equ_ciu, equ_con, equ_mvp, equ_cam, equ_cod, equ_mas);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Elemento duplicado');
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Valores fuera del rango permitido, o valor negativo');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error inesperado');
END;


-- EJERCICIO 2
-- En esta ocasión, modificaremos la edad de un jugador, cuyo codigo de equipo es el mismo que el código de equipo
-- que se establece a continuación. También se dicen el número de registros que fueron modificados
DECLARE
    cod EQUIPOS.CODIGO_EQUIPO%TYPE:='&cod';
    edad JUGADORES.EDAD_JUGADOR%TYPE:='&edad';
    registros_modificados NUMBER(10);
BEGIN
    UPDATE
        JUGADORES
    SET EDAD_JUGADOR=edad
    WHERE CODIGO_EQUIPO=
        (SELECT CODIGO_EQUIPO
            FROM EQUIPOS
        WHERE CODIGO_EQUIPO=cod);
    
    registros_modificados:=SQL%ROWCOUNT;
    
    IF registros_modificados > 0 THEN
        DBMS_OUTPUT.PUT_LINE('El jugador se modificó. Registros modificados: ' || registros_modificados);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay jugadores relacionados');
    END IF;
    
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error inesperado');
END;