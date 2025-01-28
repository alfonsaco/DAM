CREATE TABLE PERFUMES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    DISEÑADOR VARCHAR(50) NOT NULL,
    NOTAS VARCHAR(50) NOT NULL,
    PRECIO DECIMAL(10,2) NOT NULL
);

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


SELECT * FROM PERFUMES;