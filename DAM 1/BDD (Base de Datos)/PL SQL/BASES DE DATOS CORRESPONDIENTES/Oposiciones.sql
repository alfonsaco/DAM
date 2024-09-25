DROP TABLE academias CASCADE CONSTRAINTS;
DROP TABLE oposiciones CASCADE CONSTRAINTS;
DROP TABLE opositor_academia_profesor CASCADE CONSTRAINTS;
DROP TABLE opositor_profesor CASCADE CONSTRAINTS;
DROP TABLE opositor_oposicion_tribunal CASCADE CONSTRAINTS;
DROP TABLE opositores CASCADE CONSTRAINTS;
DROP TABLE profesores CASCADE CONSTRAINTS;
DROP TABLE tribunales CASCADE CONSTRAINTS;


CREATE TABLE academias (
    cod_academia   NUMBER(6) NOT NULL,
    nom_academia   VARCHAR2(50 CHAR) NOT NULL,
    dir_academia   VARCHAR2(50 CHAR) NOT NULL,
    tel_academia   VARCHAR2(12 CHAR)
);  
ALTER TABLE academias ADD CONSTRAINT academia_pk PRIMARY KEY ( cod_academia );

INSERT INTO ACADEMIAS VALUES(1,  'APRUEBO SEGURO',                              'Avenida del Caballero de la Triste Figura',    '913456987');
INSERT INTO ACADEMIAS VALUES(2,  'Centro de Formación SOLUCION.ES',    			'Calle de Margarita Fuente, 5',                 '919871987');
INSERT INTO ACADEMIAS VALUES(3,  'Cloud Formación TIC',                         'Calle de la Macarena',                         '911287628');
INSERT INTO ACADEMIAS VALUES(4,  'Academia Paraninfo',                          'Calle de Lasarte',                             '910265890');
INSERT INTO ACADEMIAS VALUES(5,  'PixelPro',                                    'Plaza de Lima',                                '912369875');
INSERT INTO ACADEMIAS VALUES(6,  'PG Centro de Formación',                      'Avenida Alcalde Felipe Ruíz Pérez' ,           '919996862');
INSERT INTO ACADEMIAS VALUES(7,  'PC CARRIER',                                  'Calle de los Arenales',                        '911212158');
INSERT INTO ACADEMIAS VALUES(8,  'Xsfera Agile Innovation',                     'Calle de Latoneros',                           '917895682');
INSERT INTO ACADEMIAS VALUES(9,  'Excelium Serv. de Formación',                 'Plaza de Rodolfo y Ernesto Halffter ',         '919156820');
INSERT INTO ACADEMIAS VALUES(10, 'Tajamar',                                     'Calle del Gavilán',                            '918296742');
INSERT INTO ACADEMIAS VALUES(11, 'New Horizons Madrid',                         'Pasaje de Grijalba' ,                          '915828787');
INSERT INTO ACADEMIAS VALUES(12, 'DigiPen Institute',      						'Plaza Rodrigo de Triana',                      '910302050');

CREATE TABLE oposiciones (
    cod_oposicion   NUMBER(6) NOT NULL,
    nom_oposicion   VARCHAR2(40 CHAR) NOT NULL,
    fecha           DATE NOT NULL,
    num_plazas      NUMBER(3) NOT NULL
);
ALTER TABLE oposiciones ADD CONSTRAINT oposiciones_pk PRIMARY KEY ( cod_oposicion );

INSERT INTO OPOSICIONES VALUES(1,  'Sistemas Informáticos',     TO_DATE('12/06/2021'),       30);
INSERT INTO OPOSICIONES VALUES(2,  'Matemáticas',               TO_DATE('15/06/2021'),       140);
INSERT INTO OPOSICIONES VALUES(3,  'Lengua y Literatura',       TO_DATE('16/06/2021'),       180);
INSERT INTO OPOSICIONES VALUES(4,  'Historia',                  TO_DATE('14/06/2021'),       100);
INSERT INTO OPOSICIONES VALUES(5,  'Inglés',                    TO_DATE('26/06/2021'),       120);
INSERT INTO OPOSICIONES VALUES(6,  'Educación Física',          TO_DATE('08/06/2021'),       40);
INSERT INTO OPOSICIONES VALUES(7,  'Comercio',                  TO_DATE('30/06/2021'),       12);
INSERT INTO OPOSICIONES VALUES(8,  'Biología',                  TO_DATE('18/06/2021'),       110);
INSERT INTO OPOSICIONES VALUES(9,  'Latín',                     TO_DATE('19/06/2021'),       8);
INSERT INTO OPOSICIONES VALUES(10, 'Filosofía',                 TO_DATE('20/06/2021'),       20);
INSERT INTO OPOSICIONES VALUES(11, 'Sistemas Electrónicos',     TO_DATE('01/07/2021'),       25);
INSERT INTO OPOSICIONES VALUES(12, 'Economía',                  TO_DATE('12/06/2021'),       45);
INSERT INTO OPOSICIONES VALUES(13, 'Francés',                   TO_DATE('23/06/2021'),       50);
INSERT INTO OPOSICIONES VALUES(14, 'Tecnología',                TO_DATE('14/06/2021'),       20);
INSERT INTO OPOSICIONES VALUES(15, 'Fisica y Química',          TO_DATE('25/06/2021'),       80);

CREATE TABLE opositores (
    cod_opositor   NUMBER(6) NOT NULL,
    ape_opositor   VARCHAR2(30 CHAR) NOT NULL,
    nom_opositor   VARCHAR2(30 CHAR) NOT NULL,
    fecha_nac      DATE NOT NULL
);
ALTER TABLE opositores ADD CONSTRAINT opositores_pk PRIMARY KEY ( cod_opositor );

INSERT INTO OPOSITORES VALUES(1,      'AGUILAR FERNANDEZ',       'PATRICIA ',        TO_DATE('30/12/1975'));
INSERT INTO OPOSITORES VALUES(2,      'AGUILAR LOPEZ',           'DULCE NOMBRE ',    TO_DATE('28/11/1985'));
INSERT INTO OPOSITORES VALUES(3,      'ALAMEDA DIAZ',            'BEATRIZ ',         TO_DATE('25/10/1988'));
INSERT INTO OPOSITORES VALUES(4,      'ALAMEDA MARTIN',          'EDUARDO ',         TO_DATE('22/01/1996'));
INSERT INTO OPOSITORES VALUES(5,      'ALAMINOS UTRILLA',        'BEATRIZ ',         TO_DATE('21/02/1990'));
INSERT INTO OPOSITORES VALUES(6,      'ALARCON CASAS',           'MIGUEL ANGEL ',    TO_DATE('21/12/1994'));
INSERT INTO OPOSITORES VALUES(7,      'ALARCON DELGADO',         'EMMA ',            TO_DATE('07/03/1997'));
INSERT INTO OPOSITORES VALUES(8,      'PEREZ MARTINEZ',          'SARA ',            TO_DATE('09/04/1990'));
INSERT INTO OPOSITORES VALUES(9,      'PEREZ MENDOZA',           'MARTA ',           TO_DATE('08/05/2000'));
INSERT INTO OPOSITORES VALUES(10,     'PEREZ MOLERO',            'JOSE ALBERTO ',    TO_DATE('12/06/1995'));
INSERT INTO OPOSITORES VALUES(11,     'PEREZ MORENO',            'ANA ROSA ',        TO_DATE('11/07/1995'));
INSERT INTO OPOSITORES VALUES(12,     'PEREZ PALOMARES',         'SERGIO ',          TO_DATE('10/06/1985'));
INSERT INTO OPOSITORES VALUES(13,     'PEREZ PEREZ',             'CRISTINA ',        TO_DATE('10/11/1995'));
INSERT INTO OPOSITORES VALUES(14,     'PEREZ PEREZ',             'SUSANA ',          TO_DATE('18/12/1973'));
INSERT INTO OPOSITORES VALUES(15,     'PEREZ RAMIREZ',           'PABLO ',           TO_DATE('19/10/1975'));
INSERT INTO OPOSITORES VALUES(16,     'ORTIZ NUÑEZ',             'BEATRIZ ',         TO_DATE('01/09/1988'));
INSERT INTO OPOSITORES VALUES(17,     'ORTIZ RODRIGO',           'SILVIA ',          TO_DATE('15/01/1989'));
INSERT INTO OPOSITORES VALUES(18,     'ORTIZ SAIZ',              'MARIA ASUNCION ',  TO_DATE('14/02/1992'));
INSERT INTO OPOSITORES VALUES(19,     'ORTIZ SANCHEZ',           'ELISA ',           TO_DATE('12/04/1993'));
INSERT INTO OPOSITORES VALUES(20,     'ORTIZ SILVESTRE',         'OMAR ',            TO_DATE('01/06/2005'));
INSERT INTO OPOSITORES VALUES(21,     'ORTIZ VERA',              'LAURA ',           TO_DATE('15/05/2000'));
INSERT INTO OPOSITORES VALUES(22,     'ORTUÑO ALBERTOS',         'EVA ',             TO_DATE('16/06/1990'));
INSERT INTO OPOSITORES VALUES(23,     'MUÑOZ GALAN',             'GUADALUPE ',       TO_DATE('17/10/1980'));
INSERT INTO OPOSITORES VALUES(24,     'MUÑOZ GARCIA',            'CESAR ',           TO_DATE('18/11/1985'));
INSERT INTO OPOSITORES VALUES(25,     'MUÑOZ GARCIA',            'MARIA ROSA ',      TO_DATE('05/01/1996'));
INSERT INTO OPOSITORES VALUES(26,     'MUÑOZ HERVAS',            'ANTONIO ',         TO_DATE('10/02/1992'));
INSERT INTO OPOSITORES VALUES(27,     'MUÑOZ HORTELANO',         'ANDRES ',          TO_DATE('25/03/2001'));
INSERT INTO OPOSITORES VALUES(28,     'MUÑOZ LOPEZ',             'MARIA AMPARO ',    TO_DATE('05/04/1992'));
INSERT INTO OPOSITORES VALUES(29,     'MUÑOZ MARTIN',            'BEATRIZ ',         TO_DATE('23/05/1993'));
INSERT INTO OPOSITORES VALUES(30,     'MUÑOZ-ALCON LLESTA',      'MELITONA ',        TO_DATE('25/06/1994'));
INSERT INTO OPOSITORES VALUES(31,     'MORENO GARCIA',           'MARIA ELSA ',      TO_DATE('18/12/1990'));
INSERT INTO OPOSITORES VALUES(32,     'MORENO HERNANDEZ',        'ROSA ',            TO_DATE('15/11/1991'));
INSERT INTO OPOSITORES VALUES(33,     'MORENO HURTADO',          'ILDEFONSO ',       TO_DATE('12/10/1990'));
INSERT INTO OPOSITORES VALUES(34,     'MORENO IÑIGO',            'MARTA ',           TO_DATE('01/01/1992'));
INSERT INTO OPOSITORES VALUES(35,     'MORENO JIMENEZ',          'ALBA ',            TO_DATE('05/05/1996'));
INSERT INTO OPOSITORES VALUES(36,     'MORENO LOPEZ',            'ANA BELEN ',       TO_DATE('25/05/1997'));
INSERT INTO OPOSITORES VALUES(37,     'MORENO LOPEZ',            'CRISTINA ',        TO_DATE('15/04/1998'));
INSERT INTO OPOSITORES VALUES(38,     'MORENO MARTINEZ',         'LUIS ',            TO_DATE('09/02/1990'));
INSERT INTO OPOSITORES VALUES(39,     'PALENCIA DONATE',         'PILAR ',           TO_DATE('02/03/1990'));
INSERT INTO OPOSITORES VALUES(40,     'PALOMINO ORTIZ',          'LOURDES ',         TO_DATE('03/04/1993'));
INSERT INTO OPOSITORES VALUES(41,     'PALOMO ARMUÑA',           'NOEMI ',           TO_DATE('12/07/1980'));
INSERT INTO OPOSITORES VALUES(42,     'PALOMO MARTIN',           'VICENTE ',         TO_DATE('19/09/1980'));
INSERT INTO OPOSITORES VALUES(43,     'PANADERO LOZANO',         'MARIA DOLORES ',   TO_DATE('29/01/1981'));
INSERT INTO OPOSITORES VALUES(44,     'PANTALEON HERRANZ',       'MARIA CRISTINA ',  TO_DATE('30/10/1980'));
INSERT INTO OPOSITORES VALUES(45,     'PAÑOS TORRECILLA',        'EVA MARIA ',       TO_DATE('01/10/1985'));
INSERT INTO OPOSITORES VALUES(46,     'PARDO GARCIA',            'ROSA MARIA',       TO_DATE('05/01/1986'));
INSERT INTO OPOSITORES VALUES(47,     'PISONERO BLANCO',         'MARIA',            TO_DATE('12/02/1986'));
INSERT INTO OPOSITORES VALUES(48,     'PLAZA ARAGON',            'MIRIAM',           TO_DATE('13/12/1986'));
INSERT INTO OPOSITORES VALUES(49,     'PLAZA CANO',              'JAVIER',           TO_DATE('14/12/1986'));
INSERT INTO OPOSITORES VALUES(50,     'PLAZA DEL CERRO',         'VIRGINIA',         TO_DATE('15/12/1986'));
INSERT INTO OPOSITORES VALUES(51,     'PLAZA ESPINOSA',          'INMACULADA',       TO_DATE('16/12/1986'));
INSERT INTO OPOSITORES VALUES(52,     'PLAZA MORALES',           'MARIA',            TO_DATE('17/11/1980'));
INSERT INTO OPOSITORES VALUES(53,     'PLAZA PERALO',            'SUSANA',           TO_DATE('18/02/1981'));
INSERT INTO OPOSITORES VALUES(54,     'RAMIREZ SANCHEZ',         'MARIA BEATRIZ',    TO_DATE('19/12/1982'));
INSERT INTO OPOSITORES VALUES(55,     'RAMIREZ SANCHEZ',         'ROCIO',            TO_DATE('10/06/1983'));
INSERT INTO OPOSITORES VALUES(56,     'RAMOS GONZALEZ',          'VIRGINIA',         TO_DATE('01/01/1984'));
INSERT INTO OPOSITORES VALUES(57,     'RAMOS SORIANO',           'LAURA',            TO_DATE('02/02/1985'));
INSERT INTO OPOSITORES VALUES(58,     'RANZ VALVERDE',           'ANA MARIA',        TO_DATE('03/03/1986'));
INSERT INTO OPOSITORES VALUES(59,     'RANZ VALVERDE',           'SERGIO',           TO_DATE('25/07/1976'));
INSERT INTO OPOSITORES VALUES(60,     'RASO DIAZ-GUERRA',        'ARANCHA',          TO_DATE('25/05/1976'));
INSERT INTO OPOSITORES VALUES(61,     'RAYA SABRIDO',            'ANDRES',           TO_DATE('26/12/1976'));
INSERT INTO OPOSITORES VALUES(62,     'REALES GUILLEN',          'MARIA TERESA',     TO_DATE('27/04/1976'));
INSERT INTO OPOSITORES VALUES(63,     'REBATO DOMINGUEZ',        'SONIA',            TO_DATE('28/04/1976'));
INSERT INTO OPOSITORES VALUES(64,     'RECIO LEON',              'MARIA CRISTINA',   TO_DATE('29/05/1987'));
INSERT INTO OPOSITORES VALUES(65,     'RECIO MORAN',             'AMAYA',            TO_DATE('30/06/1988'));
INSERT INTO OPOSITORES VALUES(66,     'RECUERO DIAZ',            'CRISTINA',         TO_DATE('01/07/1989'));
INSERT INTO OPOSITORES VALUES(67,     'REDONDO ALGARRA',         'MARIA ESTHER',     TO_DATE('10/08/1975'));
INSERT INTO OPOSITORES VALUES(68,     'REDONDO MORENO',          'MARIA ESTHER',     TO_DATE('11/09/1976'));
INSERT INTO OPOSITORES VALUES(69,     'REDONDO RESINO',          'MARTA',            TO_DATE('12/10/1967'));
INSERT INTO OPOSITORES VALUES(70,     'REDONDO SANCHEZ',         'OLGA',             TO_DATE('13/11/1978'));
INSERT INTO OPOSITORES VALUES(71,     'REFUSTA MANCHEÑO',        'MARCOS',           TO_DATE('14/12/1979'));
INSERT INTO OPOSITORES VALUES(72,     'REGIDOR NIETO',           'ENRIQUE',          TO_DATE('15/01/1970'));
INSERT INTO OPOSITORES VALUES(73,     'REINA ALVAREZ',           'JESUS',            TO_DATE('16/02/1971'));
INSERT INTO OPOSITORES VALUES(74,     'REINA MORENO',            'MARTA',            TO_DATE('17/03/1972'));
INSERT INTO OPOSITORES VALUES(75,     'REVUELTA CANTALAPIEDRA',  'JOSE',             TO_DATE('18/04/1973'));         
INSERT INTO OPOSITORES VALUES(76,     'REY AGUDO',               'ELENA MARIA',      TO_DATE('19/05/1977'));
INSERT INTO OPOSITORES VALUES(77,     'REY ROMERO',              'MARTA',            TO_DATE('20/06/1975'));
INSERT INTO OPOSITORES VALUES(78,     'RICA SANCHEZ',            'MARTA DE LA',      TO_DATE('25/12/1976'));
INSERT INTO OPOSITORES VALUES(79,     'RINCON SERRANO',          'MONICA',           TO_DATE('25/07/1977'));
INSERT INTO OPOSITORES VALUES(80,     'RIO LOPEZ',               'MILAGROS DEL',     TO_DATE('20/08/1978'));
INSERT INTO OPOSITORES VALUES(81,     'RIVAS CEBEIRA',           'LAURA',            TO_DATE('05/09/1979'));
INSERT INTO OPOSITORES VALUES(82,     'RIVAS MAZUECOS',          'SANDRA',           TO_DATE('01/10/1980'));
INSERT INTO OPOSITORES VALUES(83,     'RIVERA TRIGUERO',         'MARIA RAMONA',     TO_DATE('31/12/1981'));
INSERT INTO OPOSITORES VALUES(84,     'RIVERO BRAVO',            'ELVIRA DEL',       TO_DATE('29/11/1982'));
INSERT INTO OPOSITORES VALUES(85,     'RIVERO RUIZ',             'RAQUEL',           TO_DATE('26/10/1983'));
INSERT INTO OPOSITORES VALUES(86,     'ROA GORDO',               'SUSANA',           TO_DATE('01/09/1982'));
INSERT INTO OPOSITORES VALUES(87,     'ROBLEDO CASADO',          'EUSEBIO CESAR',    TO_DATE('05/08/1972'));

CREATE TABLE profesores (
    cod_profesor     NUMBER(6) NOT NULL,
    ape_profesor     VARCHAR2(30 CHAR) NOT NULL,
    nom_profesor     VARCHAR2(30 CHAR) NOT NULL,
    email_profesor   VARCHAR2(50 CHAR) NOT NULL
);
ALTER TABLE profesores ADD CONSTRAINT profesores_pk PRIMARY KEY ( cod_profesor );

 INSERT INTO profesores VALUES (1,  'Escalera',   'Adrian',   'adrian@gmail.com');
 INSERT INTO profesores VALUES (2,  'Sanchez',    'Francisco','francisco@gmail.com');
 INSERT INTO profesores VALUES (3,  'Lopez',      'Silvia',   'silvia@yahoo.es');
 INSERT INTO profesores VALUES (4,  'Cid',        'Juan',     'juan@yahoo.es');
 INSERT INTO profesores VALUES (5,  'Rodríguez',  'Anibal',   'anibal@gmail.com');
 INSERT INTO profesores VALUES (6,  'Gómez',      'Daniel',   'daniel@gmail.com');
 INSERT INTO profesores VALUES (7,  'Escalonilla','Marina',   'marina@gmail.com');
 INSERT INTO profesores VALUES (8,  'Viso',       'Alejandro','alejandro@telefonica.net');
 INSERT INTO profesores VALUES (9,  'Juarez',     'Amelia',   'ameliaj@gmail.com');
 INSERT INTO profesores VALUES (10, 'Martín',     'Amelia',   'ameliam@gmail.com');
 INSERT INTO profesores VALUES (11, 'Matute',     'Ana María','anamaria@hotmail.com');
 INSERT INTO profesores VALUES (12, 'Madrid',     'Pedro',    'pedro@hotmail.com');
 INSERT INTO profesores VALUES (13, 'Mérida',     'Antonia',  'antonia@hotmail.com');
 INSERT INTO profesores VALUES (14, 'Sánchez',    'Antonio',  'antonio@hotmail.com');
 INSERT INTO profesores VALUES (15, 'Bermudez',   'Beatriz',  'bermudez@gmail.com');
 INSERT INTO profesores VALUES (16, 'Salinero',   'Beatriz',  'salinero@hotmail.com');
 INSERT INTO profesores VALUES (17, 'Montes',     'Juoaquin', 'montes@gmail.com');
 INSERT INTO profesores VALUES (18, 'Sanz',       'Camilo',   'camilo@hotmail.com');
 INSERT INTO profesores VALUES (19, 'Rodrigo',    'Carlos',   'carlitos@gmail.com');
 INSERT INTO profesores VALUES (20, 'Valdepeñas', 'Carmen',   'carmen@yahoo.es');

CREATE TABLE tribunales (
    cod_tribunal   NUMBER(6) NOT NULL,
    nom_tribunal   VARCHAR2(30 CHAR) NOT NULL,
    ape_tribunal   VARCHAR2(30 CHAR) NOT NULL
);
ALTER TABLE tribunales ADD CONSTRAINT tribunales_pk PRIMARY KEY ( cod_tribunal );

INSERT INTO tribunales  VALUES(1,  'Juan',    'Juarez Muñoz' );
INSERT INTO tribunales  VALUES(2,  'Antonio', 'Fermín Sardinero');
INSERT INTO tribunales  VALUES(3,  'Marisa',  'Bermudez Loaisa');
INSERT INTO tribunales  VALUES(4,  'Marina',  'Lopez Saez');
INSERT INTO tribunales  VALUES(5,  'Jorge',   'Recuero Carrascosa');
INSERT INTO tribunales  VALUES(6,  'Luis',    'Martín Jiménez');
INSERT INTO tribunales  VALUES(7,  'Carmen',  'Bueno Lorente');
INSERT INTO tribunales  VALUES(8,  'Tobías',  'Lorente Sanchez');
INSERT INTO tribunales  VALUES(9,  'Lucia',   'Matamoros Toledo');
INSERT INTO tribunales  VALUES(10, 'Beatriz', 'Cid Romela');
INSERT INTO tribunales  VALUES(11, 'Pablo',   'Iniesta Alejo');
INSERT INTO tribunales  VALUES(12, 'Mauro',   'Gómez Gómez');
INSERT INTO tribunales  VALUES(13, 'Jesús',   'Perez Caminero');
INSERT INTO tribunales  VALUES(14, 'Marina',  'Rodríguez Gómez');
INSERT INTO tribunales  VALUES(15, 'Mariano', 'Romana Rodríguez');
INSERT INTO tribunales VALUES (16, 'Cristina','Parreño Andujar');
INSERT INTO tribunales VALUES (17, 'Maria',   'Parreño Garcia');
INSERT INTO tribunales VALUES (18, 'Sara',    'Partal Ureña');
INSERT INTO tribunales VALUES (19, 'Beatriz', 'Pascual Galan');
INSERT INTO tribunales VALUES (20, 'Aroa',    'Pascual Garcia');
INSERT INTO tribunales VALUES (21, 'Amelia',  'Pascual Rodriguez');
INSERT INTO tribunales VALUES (22, 'Marta',   'Pastor Garrido');
INSERT INTO tribunales VALUES (23, 'Maria',   'Pastor Ibanez');
INSERT INTO tribunales VALUES (24, 'Elena',   'Barrilero Vela');
INSERT INTO tribunales VALUES (25, 'Maria',   'Barrio Colmena');
INSERT INTO tribunales VALUES (26, 'Beatriz', 'Barroso Benitez');
INSERT INTO tribunales VALUES (27, 'Ana',     'Barroso Rubio');
INSERT INTO tribunales VALUES (28, 'Maria',   'Bascuñana Lopez');
INSERT INTO tribunales VALUES (29, 'Maria',   'Bastante Beldad');
INSERT INTO tribunales VALUES (30, 'Juan',    'Bastante Lopez');
INSERT INTO tribunales VALUES (31, 'Isabel',  'Batalla Lopez');
INSERT INTO tribunales VALUES (32, 'Monica',  'Bautista Garcia');
INSERT INTO tribunales VALUES (33, 'Soledad', 'Bautista Tenorio');
INSERT INTO tribunales VALUES (34, 'Maria',   'Bejar Martinez');
INSERT INTO tribunales VALUES (35, 'Ruben',   'Beldad Martin');
INSERT INTO tribunales VALUES (36, 'Maria',   'Belinchon Dominguez');
INSERT INTO tribunales VALUES (37, 'Rosario', 'Belinchon Fernandez');
INSERT INTO tribunales VALUES (38, 'Bernabe', 'Belmar Martinez');
INSERT INTO tribunales VALUES (39, 'Cristina','Benito Perez');
INSERT INTO tribunales VALUES (40, 'Mercedes','Benito Roldan');
INSERT INTO tribunales VALUES (41, 'Elima',   'Benito Romera');
INSERT INTO tribunales VALUES (42, 'Cesar',   'Benito Romero-Salazar');
INSERT INTO tribunales VALUES (43, 'Dolores', 'Berenguer Pereda');
INSERT INTO tribunales VALUES (44, 'Jesus',   'Bernal Juanes');
INSERT INTO tribunales VALUES (45, 'Rosario', 'Bernal Pastor');

CREATE TABLE opositor_academia_profesor (
    cod_opositor   NUMBER(6) NOT NULL,
    cod_academia   NUMBER(6) NOT NULL,
    cod_profesor   NUMBER(6) NOT NULL,
    precio         NUMBER(6,2) NOT NULL
);
ALTER TABLE opositor_academia_profesor ADD CONSTRAINT opositor_academia_profesor_pk PRIMARY KEY ( cod_profesor,cod_academia,
 cod_opositor );
 
INSERT INTO opositor_academia_profesor  VALUES(1,      1,      1,   200);
INSERT INTO opositor_academia_profesor  VALUES(2,      1,      1,   200);
INSERT INTO opositor_academia_profesor  VALUES(4,      1,      3,   200);
INSERT INTO opositor_academia_profesor  VALUES(5,      2,      4,   250);
INSERT INTO opositor_academia_profesor  VALUES(6,      2,      4,   250);
INSERT INTO opositor_academia_profesor  VALUES(7,      2,      4,   250);
INSERT INTO opositor_academia_profesor  VALUES(9,      3,      5,   250);
INSERT INTO opositor_academia_profesor  VALUES(11,     3,      5,   250);
INSERT INTO opositor_academia_profesor  VALUES(12,     3,      6,   250);
INSERT INTO opositor_academia_profesor  VALUES(15,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(16,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(18,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(19,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(20,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(21,     4,      8,   300);
INSERT INTO opositor_academia_profesor  VALUES(22,     5,      9,   275);
INSERT INTO opositor_academia_profesor  VALUES(25,     5,      9,   275);
INSERT INTO opositor_academia_profesor  VALUES(26,     5,      10,  275);
INSERT INTO opositor_academia_profesor  VALUES(27,     5,      10,  275);
INSERT INTO opositor_academia_profesor  VALUES(28,     5,      10,  275);
INSERT INTO opositor_academia_profesor  VALUES(29,     5,      10,  275);
INSERT INTO opositor_academia_profesor  VALUES(30,     5,      11,  275);
INSERT INTO opositor_academia_profesor  VALUES(31,     5,      11,  275);
INSERT INTO opositor_academia_profesor  VALUES(35,     6,      12,  200);
INSERT INTO opositor_academia_profesor  VALUES(36,     6,      12,  200);
INSERT INTO opositor_academia_profesor  VALUES(37,     6,      12,  200);
INSERT INTO opositor_academia_profesor  VALUES(39,     6,      12,  200);


CREATE TABLE opositor_profesor (
    cod_opositor   NUMBER NOT NULL,
    cod_profesor   NUMBER NOT NULL,
    precio         NUMBER(6,2) NOT NULL
);
ALTER TABLE opositor_profesor ADD CONSTRAINT opositor_profesor_pk PRIMARY KEY ( cod_profesor,cod_opositor );

INSERT INTO opositor_profesor  VALUES(46,      14,     800);
INSERT INTO opositor_profesor  VALUES(47,      14,     800);
INSERT INTO opositor_profesor  VALUES(51,      14,     850);
INSERT INTO opositor_profesor  VALUES(52,      14,     850);
INSERT INTO opositor_profesor  VALUES(54,      15,     750);
INSERT INTO opositor_profesor  VALUES(55,      16,     700);
INSERT INTO opositor_profesor  VALUES(56,      16,     700);
INSERT INTO opositor_profesor  VALUES(57,      16,     700);
INSERT INTO opositor_profesor  VALUES(58,      16,     700);
INSERT INTO opositor_profesor  VALUES(60,      16,     700);
INSERT INTO opositor_profesor  VALUES(61,      16,     700);
INSERT INTO opositor_profesor  VALUES(62,      17,     775);
INSERT INTO opositor_profesor  VALUES(63,      17,     775);
INSERT INTO opositor_profesor  VALUES(65,      17,     775);
INSERT INTO opositor_profesor  VALUES(66,      17,     775);
INSERT INTO opositor_profesor  VALUES(67,      17,     775);
INSERT INTO opositor_profesor  VALUES(71,      17,     775);
INSERT INTO opositor_profesor  VALUES(72,      17,     775);
INSERT INTO opositor_profesor  VALUES(73,      18,     800);
INSERT INTO opositor_profesor  VALUES(74,      18,     800);
INSERT INTO opositor_profesor  VALUES(75,      18,     800);
INSERT INTO opositor_profesor  VALUES(76,      18,     800);
INSERT INTO opositor_profesor  VALUES(79,      18,     800);
INSERT INTO opositor_profesor  VALUES(81,      18,     800);
INSERT INTO opositor_profesor  VALUES(82,      19,     890);
INSERT INTO opositor_profesor  VALUES(83,      19,     890);
INSERT INTO opositor_profesor  VALUES(84,      19,     890);


CREATE TABLE opositor_oposicion_tribunal (
    cod_opositor    NUMBER(6) NOT NULL,
    cod_oposicion   NUMBER(6) NOT NULL,
    cod_tribunal    NUMBER(6) NOT NULL,
    nota            NUMBER(4,2)
);
ALTER TABLE opositor_oposicion_tribunal ADD CONSTRAINT opositor_oposicion_tribunal_pk PRIMARY KEY ( cod_opositor,cod_oposicion,cod_tribunal );

INSERT INTO opositor_oposicion_tribunal  VALUES(1,      1,      1,   5.55);
INSERT INTO opositor_oposicion_tribunal  VALUES(1,      1,      2,   4.59);
INSERT INTO opositor_oposicion_tribunal  VALUES(1,      1,      3,   5.24);

INSERT INTO opositor_oposicion_tribunal  VALUES(2,      1,      1,   1.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(2,      1,      2,   2.54);
INSERT INTO opositor_oposicion_tribunal  VALUES(2,      1,      3,   2.24);

INSERT INTO opositor_oposicion_tribunal  VALUES(3,      1,      1,   7.02);
INSERT INTO opositor_oposicion_tribunal  VALUES(3,      1,      2,   8.10);
INSERT INTO opositor_oposicion_tribunal  VALUES(3,      1,      3,   7.68);

INSERT INTO opositor_oposicion_tribunal  VALUES(4,      1,      1,   0.5);
INSERT INTO opositor_oposicion_tribunal  VALUES(4,      1,      2,   0.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(4,      1,      3,   0.75);

INSERT INTO opositor_oposicion_tribunal  VALUES(5,      2,      4,   7.89);
INSERT INTO opositor_oposicion_tribunal  VALUES(5,      2,      5,   10.0);
INSERT INTO opositor_oposicion_tribunal  VALUES(5,      2,      6,   9.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(6,      2,      4,   5.75);
INSERT INTO opositor_oposicion_tribunal  VALUES(6,      2,      5,   6.02);
INSERT INTO opositor_oposicion_tribunal  VALUES(6,      2,      6,   5.85);

INSERT INTO opositor_oposicion_tribunal  VALUES(7,      2,      4,   7.5);
INSERT INTO opositor_oposicion_tribunal  VALUES(7,      2,      5,   6.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(7,      2,      6,   4.5);

INSERT INTO opositor_oposicion_tribunal  VALUES(8,      3,      7,   5.28);
INSERT INTO opositor_oposicion_tribunal  VALUES(8,      3,      8,   6.8);
INSERT INTO opositor_oposicion_tribunal  VALUES(8,      3,      9,   7.80);

INSERT INTO opositor_oposicion_tribunal  VALUES(9,      3,      7,   4.28);
INSERT INTO opositor_oposicion_tribunal  VALUES(9,      3,      8,   3.30);
INSERT INTO opositor_oposicion_tribunal  VALUES(9,      3,      9,   4.85);

INSERT INTO opositor_oposicion_tribunal  VALUES(10,     3,      7,   6.85);
INSERT INTO opositor_oposicion_tribunal  VALUES(10,     3,      8,   5.80);
INSERT INTO opositor_oposicion_tribunal  VALUES(10,     3,      9,   7.55);

INSERT INTO opositor_oposicion_tribunal  VALUES(11,     3,      7,   1.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(11,     3,      8,   2.30);
INSERT INTO opositor_oposicion_tribunal  VALUES(11,     3,      9,   2.20);

INSERT INTO opositor_oposicion_tribunal  VALUES(12,     3,      7,   5.02);
INSERT INTO opositor_oposicion_tribunal  VALUES(12,     3,      8,   4.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(12,     3,      9,   3.05);

INSERT INTO opositor_oposicion_tribunal  VALUES(13,     3,      7,   2.27);
INSERT INTO opositor_oposicion_tribunal  VALUES(13,     3,      8,   2.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(13,     3,      9,   2.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(14,     3,      7,   6.02);
INSERT INTO opositor_oposicion_tribunal  VALUES(14,     3,      8,   6.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(14,     3,      9,   5.05);

INSERT INTO opositor_oposicion_tribunal  VALUES(15,     4,      10,   5.05);
INSERT INTO opositor_oposicion_tribunal  VALUES(15,     4,      11,   6.36);
INSERT INTO opositor_oposicion_tribunal  VALUES(15,     4,      12,   7.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(16,     4,      10,   1.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(16,     4,      11,   3.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(16,     4,      12,   4.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(17,     4,      10,   9.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(17,     4,      11,   8.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(17,     4,      12,   7.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(18,     4,      10,   5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(18,     4,      11,   7.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(18,     4,      12,   6.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(19,     4,      10,   1.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(19,     4,      11,   2.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(19,     4,      12,   3.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(20,     4,      10,   4.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(20,     4,      11,   5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(20,     4,      12,   6.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(21,     4,      10,   5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(21,     4,      11,   4.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(21,     4,      12,   7.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(22,     5,      13,   9.63);
INSERT INTO opositor_oposicion_tribunal  VALUES(22,     5,      14,   9.83);
INSERT INTO opositor_oposicion_tribunal  VALUES(22,     5,      15,   8.39);

INSERT INTO opositor_oposicion_tribunal  VALUES(23,     5,      13,   2.12);
INSERT INTO opositor_oposicion_tribunal  VALUES(23,     5,      14,   2.45);
INSERT INTO opositor_oposicion_tribunal  VALUES(23,     5,      15,   2.78);

INSERT INTO opositor_oposicion_tribunal  VALUES(24,     5,      13,   2.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(24,     5,      14,   3.78);
INSERT INTO opositor_oposicion_tribunal  VALUES(24,     5,      15,   4.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(25,     5,      13,   5.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(25,     5,      14,   5.45);
INSERT INTO opositor_oposicion_tribunal  VALUES(25,     5,      15,   6.10);

INSERT INTO opositor_oposicion_tribunal  VALUES(26,     5,      13,  4.12);
INSERT INTO opositor_oposicion_tribunal  VALUES(26,     5,      14,  5.30);
INSERT INTO opositor_oposicion_tribunal  VALUES(26,     5,      15,  5.36);

INSERT INTO opositor_oposicion_tribunal  VALUES(27,     5,      13,  5.73);
INSERT INTO opositor_oposicion_tribunal  VALUES(27,     5,      14,  6.58);
INSERT INTO opositor_oposicion_tribunal  VALUES(27,     5,      15,  7.36);

INSERT INTO opositor_oposicion_tribunal  VALUES(28,     5,      13,  1.89);
INSERT INTO opositor_oposicion_tribunal  VALUES(28,     5,      14,  2.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(28,     5,      15,  1.45);

INSERT INTO opositor_oposicion_tribunal  VALUES(29,     5,      13,  5.78);
INSERT INTO opositor_oposicion_tribunal  VALUES(29,     5,      14,  5.58);
INSERT INTO opositor_oposicion_tribunal  VALUES(29,     5,      15,  5.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(30,     5,      13,  5.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(30,     5,      14,  5.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(30,     5,      15,  7.01);

INSERT INTO opositor_oposicion_tribunal  VALUES(31,     5,      13,  1.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(31,     5,      14,  4.59);
INSERT INTO opositor_oposicion_tribunal  VALUES(31,     5,      15,  3.78);

INSERT INTO opositor_oposicion_tribunal  VALUES(32,     5,      13,  5.69);
INSERT INTO opositor_oposicion_tribunal  VALUES(32,     5,      14,  6.21);
INSERT INTO opositor_oposicion_tribunal  VALUES(32,     5,      15,  6.00);

INSERT INTO opositor_oposicion_tribunal  VALUES(33,     6,      16,  9.90);
INSERT INTO opositor_oposicion_tribunal  VALUES(33,     6,      17,  9.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(33,     6,      18,  9.89);

INSERT INTO opositor_oposicion_tribunal  VALUES(34,     6,      16,  2.88);
INSERT INTO opositor_oposicion_tribunal  VALUES(34,     6,      17,  2.90);
INSERT INTO opositor_oposicion_tribunal  VALUES(34,     6,      18,  2.29);

INSERT INTO opositor_oposicion_tribunal  VALUES(35,     6,      16,  3.03);
INSERT INTO opositor_oposicion_tribunal  VALUES(35,     6,      17,  3.45);
INSERT INTO opositor_oposicion_tribunal  VALUES(35,     6,      18,  3.67);

INSERT INTO opositor_oposicion_tribunal  VALUES(36,     6,      16,  4.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(36,     6,      17,  4.89);
INSERT INTO opositor_oposicion_tribunal  VALUES(36,     6,      18,  4.39);

INSERT INTO opositor_oposicion_tribunal  VALUES(37,     6,      16,  5.09);
INSERT INTO opositor_oposicion_tribunal  VALUES(37,     6,      17,  4.90);
INSERT INTO opositor_oposicion_tribunal  VALUES(37,     6,      18,  4.99);

INSERT INTO opositor_oposicion_tribunal  VALUES(38,     6,      16,  4.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(38,     6,      17,  4.98);
INSERT INTO opositor_oposicion_tribunal  VALUES(38,     6,      18,  5.00);

INSERT INTO opositor_oposicion_tribunal  VALUES(39,     6,      16,  10.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(39,     6,      17,  10.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(39,     6,      18,  9.98);

INSERT INTO opositor_oposicion_tribunal  VALUES(40,     6,      16,  2.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(40,     6,      17,  4.20);
INSERT INTO opositor_oposicion_tribunal  VALUES(40,     6,      18,  6.69);

INSERT INTO opositor_oposicion_tribunal  VALUES(41,     6,      16,  6.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(41,     6,      17,  7.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(41,     6,      18,  7.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(42,     7,     18,  5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(42,     7,     19,  8.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(42,     7,     20,  4.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(43,     7,     18,  3.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(43,     7,     19,  4.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(43,     7,     20,  3.55);

INSERT INTO opositor_oposicion_tribunal  VALUES(44,     7,     18,  5.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(44,     7,     19,  4.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(44,     7,     20,  5.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(45,     7,     18,  7.78);
INSERT INTO opositor_oposicion_tribunal  VALUES(45,     7,     19,  8.65);
INSERT INTO opositor_oposicion_tribunal  VALUES(45,     7,     20,  6.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(46,     7,      18,   5.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(46,     7,      19,   5.77);
INSERT INTO opositor_oposicion_tribunal  VALUES(46,     7,      20,   5.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(47,     7,      18,   1.78);
INSERT INTO opositor_oposicion_tribunal  VALUES(47,     7,      19,   2.56);
INSERT INTO opositor_oposicion_tribunal  VALUES(47,     7,      20,   0.34);

INSERT INTO opositor_oposicion_tribunal  VALUES(48,     7,      18,   0.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(48,     7,      19,   0.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(48,     7,      20,   0.00);

INSERT INTO opositor_oposicion_tribunal  VALUES(49,     7,      18,   10.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(49,     7,      19,   10.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(49,     7,      20,   10.00);

INSERT INTO opositor_oposicion_tribunal  VALUES(50,     8,      21,   1.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(50,     8,      22,   2.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(50,     8,      23,   1.99);

INSERT INTO opositor_oposicion_tribunal  VALUES(51,     8,      21,   4.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(51,     8,      22,   4.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(51,     8,      23,   4.99);

INSERT INTO opositor_oposicion_tribunal  VALUES(52,     8,      21,   5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(52,     8,      22,   5.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(52,     8,      23,   5.23);

INSERT INTO opositor_oposicion_tribunal  VALUES(53,     8,      21,   4.23);
INSERT INTO opositor_oposicion_tribunal  VALUES(53,     8,      22,   2.34);
INSERT INTO opositor_oposicion_tribunal  VALUES(53,     8,      23,   4.67);

INSERT INTO opositor_oposicion_tribunal  VALUES(54,     8,      21,   8.54);
INSERT INTO opositor_oposicion_tribunal  VALUES(54,     8,      22,   8.87);
INSERT INTO opositor_oposicion_tribunal  VALUES(54,     8,      23,   8.90);

INSERT INTO opositor_oposicion_tribunal  VALUES(55,     8,      21,   7.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(55,     8,      22,   6.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(55,     8,      23,   3.20);

INSERT INTO opositor_oposicion_tribunal  VALUES(56,     8,      21,   2.25);
INSERT INTO opositor_oposicion_tribunal  VALUES(56,     8,      22,   5.00);
INSERT INTO opositor_oposicion_tribunal  VALUES(56,     8,      23,   7.25);

INSERT INTO opositor_oposicion_tribunal  VALUES(57,     8,      21,   3.45);
INSERT INTO opositor_oposicion_tribunal  VALUES(57,     8,      22,   4.56);
INSERT INTO opositor_oposicion_tribunal  VALUES(57,     8,      23,   4.50);

INSERT INTO opositor_oposicion_tribunal  VALUES(58,     8,      21,   9.99);
INSERT INTO opositor_oposicion_tribunal  VALUES(58,     8,      22,   8.89);
INSERT INTO opositor_oposicion_tribunal  VALUES(58,     8,      23,   9.09);

INSERT INTO opositor_oposicion_tribunal  VALUES(59,     8,      21,   6.67);
INSERT INTO opositor_oposicion_tribunal  VALUES(59,     8,      22,   6.53);
INSERT INTO opositor_oposicion_tribunal  VALUES(59,     8,      23,   7.89);

INSERT INTO opositor_oposicion_tribunal  VALUES(60,     9,      24,   3.54);
INSERT INTO opositor_oposicion_tribunal  VALUES(60,     9,      25,   6.30);
INSERT INTO opositor_oposicion_tribunal  VALUES(60,     9,      26,   6.58);

ALTER TABLE opositor_academia_profesor ADD CONSTRAINT cod_academia_fk FOREIGN KEY ( cod_academia )
    REFERENCES academias ( cod_academia );

ALTER TABLE opositor_oposicion_tribunal ADD CONSTRAINT cod_oposicion_fk FOREIGN KEY ( cod_oposicion )
    REFERENCES oposiciones ( cod_oposicion );

ALTER TABLE opositor_profesor ADD CONSTRAINT cod_opositor_fk FOREIGN KEY ( cod_opositor )
    REFERENCES opositores ( cod_opositor );

ALTER TABLE opositor_academia_profesor ADD CONSTRAINT cod_opositor_fkv1 FOREIGN KEY ( cod_opositor )
    REFERENCES opositores ( cod_opositor );

ALTER TABLE opositor_oposicion_tribunal ADD CONSTRAINT cod_opositor_fkv2 FOREIGN KEY ( cod_opositor )
    REFERENCES opositores ( cod_opositor )
NOT DEFERRABLE;

ALTER TABLE opositor_profesor ADD CONSTRAINT cod_profesor_fk FOREIGN KEY ( cod_profesor )
    REFERENCES profesores ( cod_profesor );

ALTER TABLE opositor_academia_profesor ADD CONSTRAINT cod_profesor_fkv1 FOREIGN KEY ( cod_profesor )
    REFERENCES profesores ( cod_profesor );

ALTER TABLE opositor_oposicion_tribunal ADD CONSTRAINT cod_tribunal_fk FOREIGN KEY ( cod_tribunal )
    REFERENCES tribunales ( cod_tribunal );
    


commit;
