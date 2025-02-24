SET SERVEROUTPUT ON
SET VERIFY OFF


-- MOSTRAR EL NOMBRE DE UN CLIENTE DADO SU CODIGO. CONTROLA EN CASO DE QUE NO SE ENCUENTRE, MOSTRANDO UN MENSAKE
DECLARE
    NOMBRE CLIENTES.NOMBRECLIENTE%TYPE;
    CODIGO CLIENTES.CODIGOCLIENTE%TYPE:='&codigo';
BEGIN
    SELECT NOMBRECLIENTE INTO NOMBRE FROM CLIENTES
        WHERE CODIGOCLIENTE=CODIGO;
    DBMS_OUTPUT.PUT_LINE('NOMBRE: '||NOMBRE);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Codigo no disponible en la base de datos');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error inesperado');
END;
/


-- FUNCI�N PARA DEVOLVER LA SUMA DE LOS PAGOS, PASANDO EL C�DIGO POR PAR�METRO. EN CASO DE QUE NO SE ENCUENTRE, DEVOLVEMOS -1
CREATE OR REPLACE FUNCTION SUMA_PAGOS(P_COD DETALLEPEDIDOS.CODIGOPEDIDO%TYPE)
RETURN NUMBER
IS
    SUMA NUMBER(10):=0;
BEGIN
    SELECT SUM(preciounidad) INTO SUMA FROM DETALLEPEDIDOS
        WHERE CODIGOPEDIDO=P_COD;
    RETURN SUMA;
END;
/

DECLARE
    CODIGO DETALLEPEDIDOS.CODIGOPEDIDO%TYPE:='&codigo';
    SUMA_TOTAL NUMBER(10):=SUMA_PAGOS(CODIGO);
BEGIN
    DBMS_OUTPUT.PUT_LINE('SUMA: '||SUMA_TOTAL);
    -- Condici�n para que salte la excepci�n si es NULL
    IF SUMA_TOTAL IS NULL THEN
        RAISE NO_DATA_FOUND;
    END IF;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe este c�digo en la base de datos');
END;
/