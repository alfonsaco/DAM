SET SERVEROUTPUT ON
SET VERIFY OFF

-- MOSTRAR LOS NÚMEROS DE 1 A 100 CON UN WHILE
DECLARE
    -- Declaramos un número 1
    N1 NUMBER(5):=1;
BEGIN
    -- Abrimos un while
    WHILE (N1<=100)
    LOOP
        DBMS_OUTPUT.PUT_LINE(N1);
        N1:=N1+1;
    -- Se cierra el LOOP, que NO el WHILE
    END LOOP;
END;
/

-- MOSTRAR TODOS LOS NÚMEROS DE 1 A 100 CON UN FOR
DECLARE
    N2 NUMBER(5):=1;
BEGIN
    -- El I vendría a ser el (int i=0;) de Java
    FOR I IN 1..100
    LOOP
        DBMS_OUTPUT.PUT_LINE(N2);
        N2:=N2+1;
    END LOOP;
END;
/
    
-- MOSTRAR TODOS LOS NÚMEROS DE 1 A 100 CON UN LOOP
DECLARE 
    N3 NUMBER(5):=1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N3);
        EXIT WHEN N3=100;
        N3:=N3+1;
    END LOOP;
END;
/