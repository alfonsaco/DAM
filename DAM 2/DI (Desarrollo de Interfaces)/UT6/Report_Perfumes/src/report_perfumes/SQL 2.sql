-- Eliminar tablas existentes (en orden de dependencia)
DROP TABLE IF EXISTS VENTA_PERFUME;
DROP TABLE IF EXISTS VENTAS;
DROP TABLE IF EXISTS PERFUMES;

-------------------------------------------------
-- 1. Tabla de Perfumes
-------------------------------------------------
CREATE TABLE PERFUMES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    DISEÑADOR VARCHAR(50) NOT NULL,
    NOTAS VARCHAR(50) NOT NULL,
    PRECIO DECIMAL(10,2) NOT NULL
);

-- Insertar datos en PERFUMES
INSERT INTO PERFUMES (nombre, diseñador, notas, precio) VALUES 
('Stronger With You Intensily','Emporio Armani','Canela, Avainillado, Dulce, Ámbar',79.99),
('Jean Paul Gaultier Ultra Male','Jean Paul Gaultier','Avainillado, Afrutado, Dulce, Aromático',109.99),
('Dior Sauvage Elixir','Dior','Amaderado, Aromático, Especiado, Fresco',105.50),
('Bleu de Chanel Parfum','Chanel','Amaderado, Cítrico, Aromático, Fresco',120.00),
('Invictus Victory','Paco Rabanne','Ámbar, Vainilla, Amaderado, Dulce',95.99),
('Terre d’Hermès','Hermès','Amaderado, Terroso, Fresco, Cítrico',85.75),
('Le Male Le Parfum','Jean Paul Gaultier','Avainillado, Ambarado, Aromático, Especiado',99.50),
('Acqua di Giò Profumo','Giorgio Armani','Acuático, Amaderado, Aromático, Cítrico',102.00),
('1 Million Parfum','Paco Rabanne','Dulce, Amaderado, Floral, Tropical',92.80),
('Spicebomb Extreme','Viktor & Rolf','Especiado, Tabaco, Ambarado, Vainilla',98.60),
('Tom Ford Noir Extreme','Tom Ford','Avainillado, Dulce, Amaderado, Ambarado',115.00),
('Y Le Parfum','Yves Saint Laurent','Amaderado, Aromático, Dulce, Especiado',107.99);

INSERT INTO PERFUMES (nombre, diseñador, notas, precio) VALUES 
('Acqua di Gio Absolu', 'Giorgio Armani', 'Cítrico, Amaderado, Fresco, Aromático', 108.50),
('Eros Flame', 'Versace', 'Amaderado, Aromático, Dulce, Afrutado', 95.75),
('Nuit d’Issey Polaris', 'Issey Miyake', 'Especiado, Amaderado, Fresco, Oriental', 100.99),
('Allure Homme Sport', 'Chanel', 'Cítrico, Amaderado, Aromático, Fresco', 110.00),
('L’Homme Intense', 'Yves Saint Laurent', 'Amaderado, Aromático, Dulce, Fresco', 115.25),
('Code Profumo', 'Dolce & Gabbana', 'Amaderado, Oriental, Especiado, Dulce', 102.50),
('212 VIP Rosé', 'Carolina Herrera', 'Frutal, Floral, Dulce, Afrutado', 89.99),
('Oud Wood', 'Tom Ford', 'Amaderado, Aromático, Especiado, Terroso', 140.00),
('Le Male 100', 'Jean Paul Gaultier', 'Avainillado, Aromático, Dulce, Amaderado', 105.50),
('La Nuit de l’Homme', 'Yves Saint Laurent', 'Amaderado, Aromático, Dulce, Fresco', 98.75),
('Emporio Pure', 'Emporio Armani', 'Cítrico, Floral, Fresco, Amaderado', 88.99),
('Aqua Allegoria Mandarine Basilic', 'Giorgio Armani', 'Cítrico, Herbal, Fresco, Verde', 76.50),
('212 Men', 'Carolina Herrera', 'Cítrico, Amaderado, Especiado, Dulce', 99.90),
('Bad Boy', 'Carolina Herrera', 'Amaderado, Oriental, Dulce, Especiado', 109.50),
('Guilty Black', 'Calvin Klein', 'Amaderado, Aromático, Especiado, Dulce', 92.00),
('Olympéa', 'Paco Rabanne', 'Floral, Salado, Dulce, Amaderado', 84.75),
('Invictus Legend', 'Paco Rabanne', 'Amaderado, Aromático, Dulce, Cítrico', 107.30),
('The One For Men Eau de Parfum', 'Dolce & Gabbana', 'Amaderado, Tabaco, Oriental, Dulce', 112.00),
('Le Exclusif', 'Jean Paul Gaultier', 'Amaderado, Dulce, Especiado, Aromático', 120.50),
('Dior Homme Intense', 'Dior', 'Floral, Amaderado, Dulce, Aromático', 125.99);

-------------------------------------------------
-- 2. Tabla de Ventas
-------------------------------------------------
-- Ahora la tabla VENTAS solo registra el ID y la FECHA
CREATE TABLE VENTAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL
);

-------------------------------------------------
-- 3. Tabla intermedia: VENTA_PERFUME
-------------------------------------------------
-- Esta tabla relaciona una venta con un perfume, registrando además la cantidad y el precio unitario de ese perfume en la venta.
CREATE TABLE VENTA_PERFUME (
    venta_id INT NOT NULL,
    perfume_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (venta_id, perfume_id),
    FOREIGN KEY (venta_id) REFERENCES VENTAS(id),
    FOREIGN KEY (perfume_id) REFERENCES PERFUMES(id)
);

-------------------------------------------------
-- Inserción de Ventas y Detalles en VENTA_PERFUME
-------------------------------------------------
-- Venta 1: '2025-01-10' con PERFUME_ID = 3, CANTIDAD = 2, PRECIO_UNITARIO = 105.50
INSERT INTO VENTAS (fecha) VALUES ('2025-01-10');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (1, 3, 2, 105.50);

-- Venta 2: '2025-01-12' con PERFUME_ID = 1, CANTIDAD = 1, PRECIO_UNITARIO = 79.99
INSERT INTO VENTAS (fecha) VALUES ('2025-01-12');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (2, 1, 1, 79.99);

-- Venta 3: '2025-01-15' con PERFUME_ID = 15, CANTIDAD = 3, PRECIO_UNITARIO = 99.50
INSERT INTO VENTAS (fecha) VALUES ('2025-01-15');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (3, 15, 3, 99.50);

-- Venta 4: '2025-01-18' con PERFUME_ID = 7, CANTIDAD = 1, PRECIO_UNITARIO = 99.50
INSERT INTO VENTAS (fecha) VALUES ('2025-01-18');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (4, 7, 1, 99.50);

-- Venta 5: '2025-01-20' con PERFUME_ID = 22, CANTIDAD = 2, PRECIO_UNITARIO = 125.99
INSERT INTO VENTAS (fecha) VALUES ('2025-01-20');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (5, 22, 2, 125.99);

-- Venta 6: '2025-01-22' con PERFUME_ID = 12, CANTIDAD = 1, PRECIO_UNITARIO = 115.00
INSERT INTO VENTAS (fecha) VALUES ('2025-01-22');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (6, 12, 1, 115.00);

-- Venta 7: '2025-01-25' con PERFUME_ID = 28, CANTIDAD = 4, PRECIO_UNITARIO = 88.99
INSERT INTO VENTAS (fecha) VALUES ('2025-01-25');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (7, 28, 4, 88.99);

-- Venta 8: '2025-01-28' con PERFUME_ID = 30, CANTIDAD = 1, PRECIO_UNITARIO = 109.50
INSERT INTO VENTAS (fecha) VALUES ('2025-01-28');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (8, 30, 1, 109.50);

-- Venta 9: '2025-01-30' con PERFUME_ID = 5, CANTIDAD = 2, PRECIO_UNITARIO = 95.99
INSERT INTO VENTAS (fecha) VALUES ('2025-01-30');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (9, 5, 2, 95.99);

-- Venta 10: '2025-02-02' con PERFUME_ID = 18, CANTIDAD = 2, PRECIO_UNITARIO = 112.00
INSERT INTO VENTAS (fecha) VALUES ('2025-02-02');
INSERT INTO VENTA_PERFUME (venta_id, perfume_id, cantidad, precio_unitario) 
VALUES (10, 18, 2, 112.00);

-------------------------------------------------
-- Consultas de verificación
-------------------------------------------------
SELECT * FROM PERFUMES;
SELECT * FROM VENTAS;
SELECT * FROM VENTA_PERFUME;
