DECLARE
    cod EQUIPOS.CODIGO_EQUIPO%TYPE:='&cod';
    edad JUGADORES.EDAD_JUGADOR%TYPE:='&edad';
    -- Variable para contar cuantos registraos han sido modificados
    registros_modificados NUMBER(10);
BEGIN
    UPDATE
        JUGADORES
    SET EDAD_JUGADOR=edad
    WHERE CODIGO_EQUIPO=
        (SELECT CODIGO_EQUIPO
            FROM EQUIPOS
        WHERE CODIGO_EQUIPO=cod);
    -- Nos da la cantidad de registros modificados
    registros_modificados:=SQL%ROWCOUNT;
    
    IF registros_modificados > 0 THEN
        DBMS_OUTPUT.PUT_LINE('El jugador se modific�. Registros modificados: ' || registros_modificados);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay jugadores relacionados');
    END IF;
    
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error inesperado');
END;