-- 1. Eliminar todos los pacientes del Hospital código 18 (Hospital General).
DELETE FROM ENFERMO
    WHERE HOSPITAL_COD=
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%General%');

-- 2. Actualizar el número de habitación (SALA_COD) de todas las unidades de cuidados intensivos (UCI) a 8 en todos los hospitales.
UPDATE SALA
    SET SALA_COD=8
WHERE NOMBRE LIKE '%Cuidados%';

-- 3. Insertar un nuevo registro de doctor en la tabla DOCTOR. Asignar Hospital código 22 (La Paz), número de doctor 999, apellido 'Jones T.' y especialidad 'Neurocirugía'.
INSERT INTO DOCTOR
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%Paz%'),
        999,
        'Jones T.',
        'Neurocirugia'
        );

-- 4. Eliminar todas las enfermeras (FUNCION = 'Enfermera') de la tabla de personal (PLANTILLA) que trabajan en el turno de noche (TURNO = 'N').
DELETE FROM PLANTILLA
    WHERE FUNCION LIKE '%Enfermera%' AND TURNO LIKE '%N%';

-- 5. Actualizar el salario (SALARIO) de todos los empleados del departamento de cardiología (SALA.NOMBRE = 'Cardiología') a 4000, asegurando que solo afecte a los médicos (PLANTILLA.FUNCION = 'Doctor').
UPDATE PLANTILLA
    SET SALARIO=4000
WHERE SALA_COD IN
    (SELECT SALA_COD FROM SALA WHERE NOMBRE LIKE '%Cardio%')
AND FUNCION LIKE '%Doctor%';

-- 6. Eliminar todas las habitaciones (SALA) que no estén asociadas a ningún paciente (ENFERMO).
DELETE FROM SALA
    WHERE HOSPITAL_COD NOT IN
        (SELECT HOSPITAL_COD FROM ENFERMO);

-- 7. Actualizar el doctor asignado a la habitación número 3 del Hospital código 13 (Hospital Provincial) al doctor número 435 (Lopez A.), asegurando 
-- que la actualización solo afecte a los médicos (PLANTILLA.FUNCION = 'Doctor').


-- 8. Insertar nuevos registros de empleados en la tabla de personal (PLANTILLA) para dos nuevas enfermeras (FUNCION = 'Enfermera') que trabajan en el
-- turno de mañana (TURNO = 'M') en la sala de recuperación (SALA.NOMBRE = 'Recuperación') del Hospital código 45 (San Carlos). Asignarles los números
-- de empleado 7890 y 8890, y apellidos 'Garcia S.' y 'Martinez A.', respectivamente.
INSERT INTO PLANTILLA
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San Carlos%'),
        (SELECT SALA_COD FROM SALA WHERE NOMBRE LIKE '%Recuperación%' AND HOSPITAL_COD=
            (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San Carlos%')),
        7890,
        'Garcia S.',
        'Enfermera',
        'M',
        2345);
INSERT INTO PLANTILLA
    VALUES (
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San Carlos%'),
        (SELECT SALA_COD FROM SALA WHERE NOMBRE LIKE '%Recuperación%' AND HOSPITAL_COD=
            (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San Carlos%')),
        8890,
        'Martinez A.',
        'Enfermera',
        'M',
        2333);
        
     
-- 9. Eliminar todos los hospitales (HOSPITAL) que no tengan personal (PLANTILLA.HOSPITAL_COD no está en (SELECT HOSPITAL_COD FROM PLANTILLA)) o 
-- pacientes (ENFERMO.HOSPITAL_COD no está en (SELECT HOSPITAL_COD FROM ENFERMO)).
DELETE FROM HOSPITAL
    WHERE HOSPITAL_COD NOT IN
        (SELECT HOSPITAL_COD FROM HOSPITAL)
    AND HOSPITAL_COD NOT IN
        (SELECT HOSPITAL_COD FROM ENFERMO);

-- 10. Actualizar el salario (SALARIO) de todos los médicos (PLANTILLA.FUNCION = 'Doctor') que trabajan en el departamento de psiquiatría 
-- (SALA.NOMBRE = 'Psiquiatría') a un valor que sea un 10% superior a su salario actual.
UPDATE PLANTILLA
    SET SALARIO=(SALARIO*1.10)
WHERE FUNCION LIKE '%Doctor%' AND SALA_COD IN
    (SELECT SALA_COD FROM SALA WHERE NOMBRE LIKE '%Psiqui%');

-- 11. Eliminar todas las habitaciones con 5 o menos camas (NUM_CAMA <= 5) en los hospitales con código 13 (Provincial) y 22 (La Paz).
DELETE FROM SALA
    WHERE NUM_CAMA<=5 AND HOSPITAL_COD=
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%Provincial%')
    AND HOSPITAL_COD=
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%La Paz%');
-- 12. Actualizar el turno (TURNO) de todos los empleados (PLANTILLA) que trabajan en la sala de maternidad (SALA.NOMBRE = 'Maternidad') al turno de 
-- tarde (TURNO = 'T'), excepto para los doctores (PLANTILLA.FUNCION = 'Doctor').
UPDATE PLANTILLA
    SET TURNO='T'
WHERE SALA_COD IN
    (SELECT SALA_COD FROM SALA WHERE NOMBRE LIKE '%Maternidad%')
AND FUNCION NOT LIKE '%Doctor%';

-- 13. Insertar nuevos registros de pacientes (ENFERMO) para tres nuevos pacientes con los siguientes datos:
-- Hospital código 18 (Hospital General):
-- Apellido: 'Pérez L.'
-- Dirección: 'Bravo Murillo 34'
-- Fecha de nacimiento: '25/12/1970'
-- Sexo: 'M'
-- NSS: 333333333
-- Hospital código 22 (La Paz):
INSERT INTO ENFERMO
    VALUES (
        12344,
        'Perez L.',
        'Bravo Murillo 34',
        '25/12/1970',
        'M',
        333333333,
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%General%')
        );
-- Apellido: 'Gómez R.'
-- Dirección: 'Paseo de la Castellana 120'
-- Fecha de nacimiento: '01/01/1985'
-- Sexo: 'F'
-- NSS: 444444444
-- Hospital código 45 (San Carlos):
INSERT INTO ENFERMO
    VALUES (
        55565,
        'Gómez R.',
        'P. la Castellana 120',
        '01/01/1985',
        'F',
        444444444,
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%La Paz%'));
-- Apellido: 'Díaz M.'
-- Dirección: 'Carabanchel Alto 10'
-- Fecha de nacimiento: '15/08/1965'
-- Sexo: 'M'
-- NSS: 555555555
-- Eliminar todos los doctores (DOCTOR) que no tengan pacientes asignados (no hay registros en ENFERMO con DOCTOR_NO igual al DOCTOR_NO del doctor).
INSERT INTO ENFERMO
    VALUES (
        69879,
        'Díaz M.',
        'Carabanchel Alto 10',
        '15/08/1965',
        'M',
        55555555,
        (SELECT HOSPITAL_COD FROM HOSPITAL WHERE NOMBRE LIKE '%San Carlos%')
        );
    
-- Actualizar la especialidad (ESPECIALIDAD) de todos los doctores (DOCTOR) que trabajan en el departamento de cardiología (SALA.NOMBRE = 
-- 'Cardiología') a 'Cardiología intervencionista'.
UPDATE DOCTOR
    SET ESPECIALIDAD='Cardiologia Int'
WHERE hospital_cod IN
    (SELECT HOSPITAL_COD FROM SALA WHERE NOMBRE LIKE '%Cardio%');

-- Insertar nuevos registros de pacientes (ENFERMO) para dos nuevos pacientes, asignándoles el doctor con la especialidad de 'Cardiología 
-- intervencionista' con menor número de pacientes asignados en el Hospital código 22 (La Paz).

-- Eliminar todos los hospitales (HOSPITAL) que no tengan ninguna especialidad médica (no hay registros en DOCTOR con HOSPITAL_COD igual al 
-- HOSPITAL_COD del hospital).
DELETE FROM HOSPITAL
    WHERE 

-- Realizar un análisis de la carga de trabajo de los doctores (DOCTOR), mostrando el número de pacientes que tiene asignado cada doctor en cada
-- hospital. El resultado debe ordenarse por hospital y por número de pacientes de mayor a menor.