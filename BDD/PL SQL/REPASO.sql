SET SERVEROUTPUT ON
SET VERIFY OFF

/*
    SE USA LA BASE DE DATOS ALMACEN
*/

/* ###################  EJERCICIO 3  ###################
   Crear un bloque de código que nos permita controlar si existe el artículo que introduzcamos por teclado. Si el artículo existe, 
   mostraremos todos los dados de sus proveedores por pantalla.
*/
CREATE OR REPLACE PROCEDURE EXISTENCIA_ARTICULO(P_CODARTI ARTICULOS.CODARTI%TYPE)
IS
    CONT NUMBER(8):=0;
    CURSOR C1 IS
        SELECT DISTINCT(P.CODPROV), P.NOMBRE, P.POBLACION, P.ZONA, P.COMISION, P.NUM_ARTIS FROM PROVEEDORES P 
                                    JOIN SUMINISTROS S ON P.CODPROV=S.CODPROV
                                    JOIN ARTICULOS A ON S.CODARTI=A.CODARTI;
    REGPROV C1%ROWTYPE;
BEGIN
    SELECT COUNT(*) INTO CONT FROM ARTICULOS 
        WHERE CODARTI=P_CODARTI;
    
    IF CONT>0 THEN
        DBMS_OUTPUT.PUT_LINE('EL ARTICULO SI EXISTE');
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
        OPEN C1;
        LOOP
            FETCH C1 INTO REGPROV;
            EXIT WHEN C1%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(REGPROV.CODPROV);
            DBMS_OUTPUT.PUT_LINE(REGPROV.NOMBRE);
            DBMS_OUTPUT.PUT_LINE(REGPROV.POBLACION);
            DBMS_OUTPUT.PUT_LINE(REGPROV.ZONA);
            DBMS_OUTPUT.PUT_LINE(REGPROV.COMISION);
            DBMS_OUTPUT.PUT_LINE(REGPROV.NUM_ARTIS);
            DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
        END LOOP;
        CLOSE C1;
    ELSE
        DBMS_OUTPUT.PUT_LINE('EL ARTICULO NO EXISTE');
    END IF;
END;
/
-- Llamamos al procedimiento
DECLARE
    CODIGO ARTICULOS.CODARTI%TYPE:='&codigo';
BEGIN
    EXISTENCIA_ARTICULO(CODIGO);
END;
/


/* ###################  EJERCICIO 5  ###################
  Crear un procedimiento al que le pasaremos desde un bloque de código como parámetro un número de compra (que introducirá el usuario) 
  para que nos muestre por pantalla la denominación de cada uno de los artículos de la compra, su categoría, las unidades vendidas en 
  una compra y el precio del artículo.
  Tendremos que comprobar que el número de la compra sea correcto, en caso de no ser correcto, no se realizará la llamada al procedimiento 
  y mostraremos un mensaje de error.
*/
CREATE OR REPLACE PROCEDURE MOSTRAR_COMPRAS(NUMCOMPRA COMPRAS.NUM_COMPRA%TYPE)
IS  
    -- Contador verificar existencia Numero compra
    CONT_COMPRA NUMBER(8):=0;
    
    -- Variables información compra
    NUMERO_COMPRA COMPRAS.NUM_COMPRA%TYPE;
    FECHA_COMPRA COMPRAS.FECHA%TYPE;
    
    CURSOR C1 IS
        SELECT A.DENOMINACION, A.CATEGORIA, X.UNIDADES, A.PVP 
            FROM ARTICULOS A JOIN DET_COMPRAS X ON A.CODARTI=X.CODARTI
                             JOIN COMPRAS C ON C.NUM_COMPRA=X.NUM_COMPRA
                        WHERE C.NUM_COMPRA=NUMCOMPRA;
    REGCOMPRA C1%ROWTYPE;
    
    -- Variables compras
    SUBTOTAL NUMBER(8):=0;
    TOTAL_ARTICULOS NUMBER(8):=0;
    TOTAL_UNIDADES NUMBER(8):=0;
    TOTAL_COMPRA NUMBER(8):=0;
BEGIN
    -- Seleccionamos el numero de compra y la fecha para ponerlo en las variables
    NUMERO_COMPRA:=NUMCOMPRA;
    SELECT FECHA INTO FECHA_COMPRA FROM COMPRAS
        WHERE NUM_COMPRA=NUMCOMPRA;

    -- Contador para ver si existe el Numero de compra
    SELECT COUNT(*) INTO CONT_COMPRA FROM COMPRAS
        WHERE NUM_COMPRA=NUMCOMPRA;
    
    IF CONT_COMPRA>0 THEN
        DBMS_OUTPUT.PUT_LINE('NUMERO DE COMPRA: ' || NUMERO_COMPRA || '                            FECHA COMPRA: ' || FECHA_COMPRA);
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('    DENOMINACION     CATEGORIA       UNIDADES    PRECIO     SUBTOTAL   ');
        DBMS_OUTPUT.PUT_LINE('    ------------     ---------       --------    ------     --------   ');
        
        OPEN C1;
        LOOP
            FETCH C1 INTO REGCOMPRA;
            EXIT WHEN C1%NOTFOUND;
            SUBTOTAL:=REGCOMPRA.UNIDADES*REGCOMPRA.PVP;
            TOTAL_COMPRA:=TOTAL_COMPRA+SUBTOTAL;
            DBMS_OUTPUT.PUT_LINE(LPAD(REGCOMPRA.DENOMINACION,15,' ') ||
                                 LPAD(REGCOMPRA.CATEGORIA,13,' ') || 
                                 LPAD(REGCOMPRA.UNIDADES,14,' ') ||
                                 LPAD(REGCOMPRA.PVP,10,' ') ||
                                 LPAD(SUBTOTAL,13,' '));
            TOTAL_ARTICULOS:=TOTAL_ARTICULOS+1;
            TOTAL_UNIDADES:=TOTAL_UNIDADES+REGCOMPRA.UNIDADES;
        END LOOP;
        CLOSE C1;
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('TOTAL ARTICULOS: ' || TOTAL_ARTICULOS || '       TOTAL UNIDADES: ' || TOTAL_UNIDADES || '       TOTAL COMPRA: ' || TOTAL_COMPRA);
    ELSE
        DBMS_OUTPUT.PUT_LINE(numcompra || ' NO DISPONIBLE EN LA BASE DE DATOS');
    END IF;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE(numcompra || ' NO DISPONIBLE EN LA BASE DE DATOS');
END;
/
-- Llamamos al método
DECLARE 
    NUMERO COMPRAS.NUM_COMPRA%TYPE:='&numero';
BEGIN
    MOSTRAR_COMPRAS(NUMERO);
END;
/


/* ###################  EJERCICIO 6  ###################
  Crear un procedimiento que a partir de un código de almacén nos muestre todas sus compras y para compra todos sus artículos. El código 
  de almacén se pasará como parámetro al procedimiento. En caso de que no exista el código del almacén, mostraremos un mensaje que así 
  lo indique y se realizará la llamada al procedimiento.
*/
CREATE OR REPLACE PROCEDURE COMPRAS_ALMACEN(P_CODALMA ALMACENES.CODALMA%TYPE)
IS
    -- Contador para verificar que l código existe
    CONT NUMBER(8):=0;
    EXCEPCION_X EXCEPTION;
    
    -- Esta variable la usaremos para poner el código en la cabecera
    COD_ALMACEN ALMACENES.CODALMA%TYPE;
    
    -- Cursor C1
    CURSOR C1 IS
        SELECT NUM_COMPRA FROM COMPRAS 
            WHERE CODALMA=P_CODALMA;
    REGCOMPRAS C1%ROWTYPE;
    
    -- Cursor C2
    CURSOR C2(V_NUMCOM COMPRAS.NUM_COMPRA%TYPE) IS
        SELECT A.DENOMINACION, A.PVP, X.UNIDADES FROM ARTICULOS A
            JOIN DET_COMPRAS X ON X.CODARTI=A.CODARTI
            JOIN COMPRAS C ON C.NUM_COMPRA=X.NUM_COMPRA
            WHERE C.NUM_COMPRA=V_NUMCOM;
    REGVALORES C2%ROWTYPE;
BEGIN
    SELECT COUNT(*) INTO CONT FROM ALMACENES
        WHERE CODALMA=P_CODALMA;
        
    IF CONT>0 THEN
        SELECT CODALMA INTO COD_ALMACEN FROM ALMACENES
                WHERE CODALMA=P_CODALMA;
        DBMS_OUTPUT.PUT_LINE('CODIGO DEL ALMACEN: ' || COD_ALMACEN);
        -- Primer cursor
        OPEN C1;
        LOOP
            FETCH C1 INTO REGCOMPRAS;
            EXIT WHEN C1%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE('NUMERO COMPRA: ' || REGCOMPRAS.NUM_COMPRA);
            DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------------');
            
            OPEN C2 (REGCOMPRAS.NUM_COMPRA);
            LOOP
                DBMS_OUTPUT.PUT_LINE('  DENOMINACION        UNIDADES        PRECIO');
                DBMS_OUTPUT.PUT_LINE('  ------------        --------        ------');
                DBMS_OUTPUT.PUT_LINE(LPAD(REGVALORES.DENOMINACION,10,' '));
            END LOOP;
            CLOSE C2;
            
        END LOOP;
        CLOSE C1;
    ELSE
        RAISE EXCEPCION_X;
    END IF;
    -- EXCEPCION    
    EXCEPTION
        WHEN EXCEPCION_X THEN
            DBMS_OUTPUT.PUT_LINE('Código no disponible en la base de datos');
END;
/
-- Llamamos a la función
DECLARE 
    CODIGO ALMACENES.CODALMA%TYPE:='&codigo';
BEGIN
    COMPRAS_ALMACEN(CODIGO);
END;
/