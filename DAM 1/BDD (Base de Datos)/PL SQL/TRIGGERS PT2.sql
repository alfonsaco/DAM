/*================================================================
    PARA ESTOS EJERCICIOS, USAMOS LA BASE DE DATOS "ALMACEN"
=================================================================*/

/*  ###################  EJERCICIO 8  ###################
  Crear la columna NUM_ARTIS dentro de la tabla proveedores. Num�rica de 4 d�gitos. Debe guardar el n�mero de art�culos que suministra el 
  proveedor. Realizar un trigger para mantener actualizada esa columna.
*/
ALTER TABLE PROVEEDORES ADD NUM_ARTIS NUMBER(4);

CREATE OR REPLACE TRIGGER ACTUALIZAR_PROVEEDORES
AFTER INSERT 
ON PROVEEDORES
FOR EACH ROW
DECLARE
    total_articulos NUMBER;
BEGIN
    -- Calcular el total de art�culos suministrados por el proveedor
    SELECT COUNT(*) INTO total_articulos
    FROM SUMINISTROS
    WHERE CODPROV = :NEW.CODPROV;

    -- Actualizar el valor en la tabla PROVEEDORES
    UPDATE PROVEEDORES
    SET NUM_ARTIS = total_articulos
    WHERE CODPROV = :NEW.CODPROV;

    INSERT INTO SUMINISTROS VALUES (1,12);
END;
/