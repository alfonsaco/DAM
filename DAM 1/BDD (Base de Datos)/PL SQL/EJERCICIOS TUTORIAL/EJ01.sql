SET SERVEROUTPUT ON
SET VERIFY OFF

-- MOSTRAR HOLA MUNDO POR PANTALLA
BEGIN
    DBMS_OUTPUT.PUT_LINE('HOLA MUNDO');
END;

-- DECLARAR UNA VARIABLE NUM�RICA, Y DECIR SI ES MAYOR O MENOR DE 10
DECLARE 
    NUMERO NUMBER:='&a_numero';
BEGIN
    IF NUMERO<10 THEN
        DBMS_OUTPUT.PUT_LINE(NUMERO || ' es menor de 10');
    ELSIF NUMERO=10 THEN
        DBMS_OUTPUT.PUT_LINE(NUMERO || ' es igual a 10');
    ELSE
        DBMS_OUTPUT.PUT_LINE(NUMERO || ' es mayor de 10');
    END IF;
END;

-- DECLARAR VARIABLE NUM�RICA, PEDIR SU VALOR Y MOSTRARLO
DECLARE 
    MOSTRAR NUMBER:='&mostrar';
BEGIN
    DBMS_OUTPUT.PUT_LINE(MOSTRAR);
END;