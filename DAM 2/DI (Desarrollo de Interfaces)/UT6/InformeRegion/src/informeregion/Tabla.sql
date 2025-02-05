CREATE DATABASE PokemonDB2;

USE PokemonDB2;


CREATE TABLE Pokemon (
    PokemonID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Tipo VARCHAR(20) NOT NULL,
    Altura DECIMAL(5,2) NOT NULL,
    Peso DECIMAL(5,2) NOT NULL
);

CREATE TABLE Movimiento (
    MovimientoID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Tipo VARCHAR(20) NOT NULL,
    Poder INT,
    Precisión DECIMAL(5,2)
);

CREATE TABLE Pokemon_Movimiento (
    PokemonID INT,
    MovimientoID INT,
    NivelAprendido INT,
    PRIMARY KEY(PokemonID, MovimientoID),
    FOREIGN KEY(PokemonID) REFERENCES Pokemon(PokemonID),
    FOREIGN KEY(MovimientoID) REFERENCES Movimiento(MovimientoID)
);

-- Insertar Pokémon
INSERT INTO Pokemon (Nombre, Tipo, Altura, Peso)
VALUES ('Charmander', 'Fuego', 0.6, 8.5),
       ('Squirtle', 'Agua', 0.5, 9.0),
       ('Bulbasaur', 'Planta', 0.7, 6.9);

-- Insertar Movimientos
INSERT INTO Movimiento (Nombre, Tipo, Poder, Precisión)
VALUES ('Llamarada', 'Fuego', 110, 85),
       ('Hidrobomba', 'Agua', 110, 80),
       ('Hoja Afilada', 'Planta', 90, 95),
       ('Ataque Rápido', 'Normal', 40, 100);

-- Relacionar Pokémon con Movimientos
INSERT INTO Pokemon_Movimiento (PokemonID, MovimientoID, NivelAprendido)
VALUES (1, 1, 36), 
       (2, 2, 36), 
       (3, 3, 32), 
       (1, 4, 15),
       (2, 4, 10);
