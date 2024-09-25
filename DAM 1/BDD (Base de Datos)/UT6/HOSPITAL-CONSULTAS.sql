-- 1 Modifica a 60 el número de camas de la sala Cardiología del Hospital General.
UPDATE SALA
    SET NUM_CAMA=60
WHERE NOMBRE LIKE 'Cardiología';

-- 2 Aumenta el sueldo un 10% a los doctores del Hospital La Paz.
UPDATE PLANTILLA
    SET SALARIO=SALARIO*1.10
WHERE FUNCION LIKE 'Doctor%';

-- 3 La nueva dirección del Hospital San Carlos en Av. Universitaria. 
UPDATE HOSPITAL
    SET DIRECCION='Av. Universitaria'
WHERE NOMBRE='San Carlos';

-- 4 Modifica el turno de tarde a turno de mañana de los enfermeros que trabajen en el mismo hospital que el doctor Cajal R. (Consulta la tabla de doctores). 
UPDATE PLANTILLA
    SET TURNO='M'
WHERE FUNCION LIKE 'Enfer%' AND HOSPITAL_COD=
    (SELECT HOSPITAL_COD FROM PLANTILLA WHERE APELLIDO LIKE '%Cajal%');

-- 5 El número de camas del hospital San Carlos ahora es el doble del numero de camas de la Sala de Recuperación del Hospital La Paz. Realiza la modificación SIN utilizar HOSPITAL_COD=22.  
UPDATE HOSPITAL 
    SET NUM_CAMAS=
        ((SELECT NUM_CAMAS FROM HOSPITAL WHERE NOMBRE LIKE 'San%')*2)
WHERE NOMBRE LIKE 'La Paz%';

-- 6 EL ENFERMO CON NUMERO DE INSCRIPCIÓN 14024  SE HA MUDADO Y AHORA VIVE EN LA MISMA DIRECCIÓN DONDE SE ENCUENTRA EL HOSPITAL PROVINCIAL
UPDATE ENFERMO
    SET DIRECCION=
        (SELECT DIRECCION FROM HOSPITAL WHERE NOMBRE LIKE 'Provin%')
WHERE INsCRIPCION=14024;

-- 7 Cambiar el turno de tarde a turno de mañana para los enfermeros que trabajen en el hospital General. 
UPDATE PLANTILLA
    SET TURNO='M'
WHERE FUNCION LIKE 'Enfer%'
    AND HOSPITAL_COD=
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%General%');

-- 8 Han aumentado el sueldo un 10% a los doctores que trabajan en turno de noche. Realiza las modificaciones. 
UPDATE PLANTILLA
    SET SALARIO=SALARIO*1.10
WHERE FUNCION LIKE '%Doctor%' AND TURNO LIKE 'N';

-- 9. Han modificado el numero de camas de la sala de Maternidad del Hospital de La Paz. Debes restarle al numero de camas de esa sala la media de camas del hospital General y sumarle el doble de camas de la sala de Cuidados intensivos del Hospital Provincial. 
UPDATE HOSPITAL
    SET NUM_CAMAS=(NUM_CAMAS-
        (SELECT TRUNC((AVG(NUM_CAMA)),2) FROM SALA WHERE HOSPITAL_COD=18)
        +((SELECT NUM_CAMA FROM SALA WHERE HOSPITAL_COD=13 AND NOMBRE LIKE 'Cuidados%')*2))
WHERE NOMBRE LIKE 'La Paz';

--  10 Ha ingresado una nueva enferma, que vivía con la enferma Valentina Serrano, en el hospital San Carlos. Ingrésalo realizando dos consultas dentro del comando VALUES. 
INSERT INTO ENFERMO
    VALUES (
        66454,
        'Jimenez M.',
        (SELECT DIRECCION FROM ENFERMO WHERE APELLIDO LIKE '%Serrano%'),
        '06/06/1996',
        'M',
        123456781,
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San%')
        );

-- 11 Mañana le realizan a una mujer llamada Carmen Cuesta una operación de corazón en el Hospital en el que trabaja Hernesto Frank. Insértala donde corresponda.  (No utilices HOSPITAL_COD= 45).
INSERT INTO ENFERMO
    VALUES (
        99999,
        'Cuesta C.',
        'Calle Matadero',
        SYSDATE+1,
        'F',
        111111113,
        (SELECT HOSPITAL_COD FROM PLANTILLA WHERE apellido LIKE 'Frank H.%')
        );

-- 12 Inserta un nuevo Doctor de Cardiología en el Hospital que tenga mayor número de camas.
INSERT INTO DOCTOR
    VALUES  (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NUM_CAMAS>=ALL
            (SELECT NUM_CAMAS FROM HOSPITAL)),
        999,
        'Pepito',
        'Cardiologia'
        );

-- 13 Se ha abierto una nueva sala de Cuidados Intensivos con 124 camas en el hospital La Paz. Insértala sin utilizar Hospital_cod=22.
INSERT INTO SALA
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE 'La%'),
        3,
        'Cuidados Intensivos',
        124);

-- 14 Se ha contratado a un nuevo doctor en el hospital de la calle Atocha, la especialidad del doctor es la misma que la del doctor David Galo y el número de doctor es el siguiente que el del doctor Antonio López.
INSERT INTO DOCTOR
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE DIRECCION LIKE '%Atocha%'),
        (SELECT DOCTOR_NO FROM DOCTOR WHERE APELLIDO LIKE '%Lopez%')+1,
        'Tomasso',
        (SELECT ESPECIALIDAD FROM DOCTOR WHERE APELLIDO LIKE '%Galo%')
        );
        
-- 15 Insertar en la tabla de plantilla el doctor del ejercicio anterior. 
INSERT INTO PLANTILLA
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE DIRECCION LIKE '%Atocha%'),
        6,
        (SELECT DOCTOR_NO FROM DOCTOR WHERE APELLIDO LIKE '%Lopez%')+1,
        'Tomasso',
        'Doctor',
        'N',
        1345
        );

-- 16 Eliminar todos empleados de la tabla plantilla excepto los doctores.
DELETE FROM PLANTILLA 
    WHERE FUNCION NOT LIKE '%Doctor%';

-- 17 Eliminar los hospitales que no tienen enfermos
DELETE FROM HOSPITAL
    WHERE HOSPITAL_COD NOT IN
        (SELECT HOSPITAL_COD FROM ENFERMO);
