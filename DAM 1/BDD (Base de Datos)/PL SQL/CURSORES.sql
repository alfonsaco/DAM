/*================================================================
    PARA ESTOS EJERCICIOS, USAMOS LA BASE DE DATOS "ALMACEN"
=================================================================*/
SET SERVEROUTPUT ON
SET VERIFY OFF

/* ####################  EJERCICIO 1  ####################
Visualizar por cada departamento los empleados que tiene, el total y la media de salario.
*/
DECLARE
    -- Cursor departamentos
    CURSOR C1 IS
        SELECT D.DPTO_COD, D.NOMBRE_DPTO FROM DEPARTAMENTOS D;
    REGDEP C1%ROWTYPE;
    
    -- Cursor empleados
    CURSOR C2(CODDEP DEPARTAMENTOS.DPTO_COD%TYPE) IS
        SELECT E.APELLIDO1, E.SALARIO, E.FECHA_INICIO, E.SEXO
            FROM EMPLEA2 E JOIN DEPARTAMENTOS D ON D.DPTO_COD=E.DPTO_COD;
    REGEMPLE C2%ROWTYPE;
    
    TOTAL_SALARIO NUMBER(8):=0;
    CONT NUMBER(8):=0;
    MEDIA_SALARIO NUMBER(8):=0;
BEGIN
    OPEN C1;
    LOOP
        FETCH C1 INTO REGDEP;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('NUM DEPARTAMENTO: ' || REGDEP.DPTO_COD ||
                            '       NOMBRE DEPARTAMENTO: ' || REGDEP.NOMBRE_DPTO);
        DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('APELLIDO             SEXO             SALARIO           FECHA ALTA');
        DBMS_OUTPUT.PUT_LINE('-------------    -------------      -------------      ------------');
        
        OPEN C2(REGDEP.DPTO_COD);
        LOOP
            FETCH C2 INTO REGEMPLE;
            EXIT WHEN C2%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(RPAD(REGEMPLE.APELLIDO1,23,' ') || 
                                 RPAD(REGEMPLE.SEXO,19,' ') ||
                                 RPAD(REGEMPLE.SALARIO,14,' ') ||
                                 REGEMPLE.FECHA_INICIO);
                                 
            TOTAL_SALARIO:=TOTAL_SALARIO+REGEMPLE.SALARIO;
            CONT:=CONT+1;
        END LOOP;
        CLOSE C2;
        DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------------');
    END LOOP;
    CLOSE C1;
    MEDIA_SALARIO:=TOTAL_SALARIO/CONT;
    DBMS_OUTPUT.PUT_LINE('TOTAL SALARIO: ' ||TOTAL_SALARIO || ' €');
    DBMS_OUTPUT.PUT_LINE('MEDIA SALARIO: ' || MEDIA_SALARIO || ' €');
END;
/