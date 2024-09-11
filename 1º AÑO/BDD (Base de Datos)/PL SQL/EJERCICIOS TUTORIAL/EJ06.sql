SET SERVEROUTPUT ON
SET VERIFY OFF


-- 15. crea una funcion a la que le pasaremos como parametros de entrada: MATRICULA, NUEVO_PRECIO_COMPRA. lA FUNCION MODIFICARA LOS DATOS DEL 
-- COCHE QUE TENGA LA MATRICULA INTRODUCIDA ACTUALIZANDO EL PRECIO_COMPRA DE LA SIGUIENTE FORMA:
-- Si precio_compra es nulo--> hacer un update en el campo precio_compra asignandole el valor de nuevo_precio_compra
-- Si no--> hacer un update en el campo precio_compra asignandole el valor de precio_compra+(precio_compra-nuevo_precio_compra)
-- la funcion devolvera el numero de filas actualizadas crea un bloque anonimo que ejecute la funcion anterior y muestre el resultado devuelto por 
-- la funcion
CREATE OR REPLACE FUNCTION MODIFICAR_COCHE(P_MATRICULA COCHE.MATRICULA%TYPE, P_NUEVO_PRECIO COCHE.PRECIO_COMPRA%TYPE)
RETURN NUMBER
IS
    P_MATRICULA COCHE.MATRICUL%TYPE:='';
    PRECIO COCHE.PRECIO_COMPRA%TYPE:='&n_precio';
BEGIN
    SELECT PRECIO_COMPRA INTO PRECIO FROM COCHE
        WHERE MATRICULA=P_MATRICULA;
        
    IF PRECIO_COMPRA IS NULL THEN
        UPDATE COCHE SET PRECIO_COMPRA=NUEVO_PRECIO;
    ELSE
        UPDATE COCHE SET PRECIO_COMPRA=PRECIO-P_NUEVO_PRECIO);
    END IF;
END;