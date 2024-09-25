SET SERVEROUTPUT ON
SET VERIFY OFF

-- EJERCICIO 1
-- Procedimiento que se encarga de que, a partir de un nombre de Estadio, el cual en nuestro caso es el Ball Arena, te da los datos de los 
-- equipos que jugaros partidos en dicho estadio.
CREATE OR REPLACE PROCEDURE MOSTRAR_EQUIPOS_ESTADIO(N_ESTADIO PARTIDOS.ESTADIO%TYPE)
IS
    -- Creación del primer cursor, para darnos los partidos jugados en el estadio
    CURSOR C1 IS
        SELECT COD_PARTIDO,RESULTADO,FECHA,ESTADIO,EQUIPO_LOCAL,EQUIPO_VISITANTE FROM PARTIDOS 
            WHERE ESTADIO LIKE N_ESTADIO;
    REGPARTIDO C1%ROWTYPE;
    
    -- Creación del segundo cursor, para darnos información de los equipos que juegan en cada partido
    CURSOR C2 (E_LOCAL PARTIDOS.EQUIPO_LOCAL%TYPE) IS 
        SELECT * FROM EQUIPOS WHERE NOMBRE_EQUIPO=E_LOCAL;
    REGEQUIPO1 C2%ROWTYPE;
    
    CURSOR C3 (E_VISITANTE PARTIDOS.EQUIPO_VISITANTE%TYPE) IS 
        SELECT * FROM EQUIPOS WHERE NOMBRE_EQUIPO=E_VISITANTE;
    REGEQUIPO2 C3%ROWTYPE;
BEGIN
    OPEN C1;
    LOOP 
        FETCH C1 INTO REGPARTIDO;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('=========================================================================================================================');
        DBMS_OUTPUT.PUT_LINE('NOMBRE ESTADIO: '||REGPARTIDO.ESTADIO);
        DBMS_OUTPUT.PUT_LINE('=========================================================================================================================');
        DBMS_OUTPUT.PUT_LINE('NOMBRE EQUIPO     CIUDAD      CONFERENCIA      NUMERO MVPS      NUMERO CAMPEONATOS       CODIGO EQUIPO      ID DE MASCOTA');
        DBMS_OUTPUT.PUT_LINE('-------------    --------    -------------    ------------     --------------------     ---------------    --------------');
        
        OPEN C2(REGPARTIDO.EQUIPO_LOCAL);
        LOOP
            FETCH C2 INTO REGEQUIPO1;
            EXIT WHEN C2%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(RPAD(REGEQUIPO1.NOMBRE_EQUIPO,20,' ') ||
                                RPAD(REGEQUIPO1.CIUDAD,18,' ') ||
                                RPAD(REGEQUIPO1.CONFERENCIA,16,' ')||
                                RPAD(REGEQUIPO1.NUM_MPVS,23,' ') ||
                                RPAD(REGEQUIPO1.NUM_CAMPEONATOS,19,' ') ||
                                RPAD(REGEQUIPO1.CODIGO_EQUIPO,18,' ') ||
                                REGEQUIPO1.ID_MASCOTA);
        END LOOP;
        CLOSE C2;
        
        OPEN C3(REGPARTIDO.EQUIPO_VISITANTE);
        LOOP
            FETCH C3 INTO REGEQUIPO2;
            EXIT WHEN C3%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(RPAD(REGEQUIPO2.NOMBRE_EQUIPO,20,' ') ||
                                RPAD(REGEQUIPO2.CIUDAD,18,' ') ||
                                RPAD(REGEQUIPO2.CONFERENCIA,16,' ')||
                                RPAD(REGEQUIPO2.NUM_MPVS,23,' ') ||
                                RPAD(REGEQUIPO2.NUM_CAMPEONATOS,19,' ') ||
                                RPAD(REGEQUIPO2.CODIGO_EQUIPO,18,' ') ||
                                REGEQUIPO2.ID_MASCOTA);
        END LOOP;
        CLOSE C3;
        DBMS_OUTPUT.PUT_LINE('  ');
        
    END LOOP;
    CLOSE C1;
END;
/

-- Llamamos al procedimiento
DECLARE 
    NOMBRE_ESTADIO PARTIDOS.ESTADIO%TYPE:='%Ball%';
BEGIN
    MOSTRAR_EQUIPOS_ESTADIO(NOMBRE_ESTADIO);
END;
/




-- EJERCICIO 2
-- Creación de un trigger el cual se encargará de evitar que se inserten jugadores con un peso inferior a 40 kilogramos de peso
CREATE OR REPLACE TRIGGER TRIGGER_PESO 
BEFORE INSERT
ON JUGADORES FOR EACH ROW
DECLARE
BEGIN
    IF :NEW.PESO < 40 THEN
        RAISE_APPLICATION_ERROR(-20021, 'INSERCIÓN INVÁLIDA: No es posible agregar jugadores con un peso inferior a 40 kilogramos');
    END IF;
END;
/
-- Realizaremos una inserción de prueba
INSERT INTO JUGADORES VALUES ('Pepe','Domingo',25,'Escolta',1.95,20,'099',8,'534435L');