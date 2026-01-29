
-- Script de Creación de la Base de Datos aaExoTrooper
-- Prefijos 'aa' aplicados a Tablas y Columnas

CREATE TABLE IF NOT EXISTS aaUsuario (
    aaIdUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    aaNombre TEXT NOT NULL,
    aaUsername TEXT NOT NULL UNIQUE,
    aaPassword TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS aaTipoArma (
    aaIdTipoArma INTEGER PRIMARY KEY AUTOINCREMENT,
    aaNombre TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS aaArma (
    aaIdArma INTEGER PRIMARY KEY AUTOINCREMENT,
    aaIdTipoArma INTEGER NOT NULL,
    aaNombre TEXT NOT NULL,
    FOREIGN KEY (aaIdTipoArma) REFERENCES aaTipoArma(aaIdTipoArma)
);

CREATE TABLE IF NOT EXISTS aaTipoExobot (
    aaIdTipoExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    aaNombre TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS aaExobot (
    aaIdExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    aaIdTipoExobot INTEGER NOT NULL,
    aaIdUsuario INTEGER,
    aaEntrenado INTEGER DEFAULT 0, -- 0: No, 1: Si
    aaNumeroAccion INTEGER DEFAULT 0,
    aaIdArma INTEGER,
    FOREIGN KEY (aaIdTipoExobot) REFERENCES aaTipoExobot(aaIdTipoExobot),
    FOREIGN KEY (aaIdUsuario) REFERENCES aaUsuario(aaIdUsuario),
    FOREIGN KEY (aaIdArma) REFERENCES aaArma(aaIdArma)
);

CREATE TABLE IF NOT EXISTS aaExoTracer (
    aaIdExoTracer INTEGER PRIMARY KEY AUTOINCREMENT,
    aaIdExobot INTEGER,
    aaNumeroAccion INTEGER,
    aaEnShow TEXT,
    FOREIGN KEY (aaIdExobot) REFERENCES aaExobot(aaIdExobot)
);

-- Datos Iniciales (Seed Data)
INSERT INTO aaUsuario (aaNombre, aaUsername, aaPassword) VALUES 
('Patricio Michael', 'patmic', '123'),
('Alan Alcivar', 'alan', '1302');

INSERT INTO aaTipoArma (aaNombre) VALUES ('Fusil / Revolver');
INSERT INTO aaTipoArma (aaNombre) VALUES ('GPS / Giroscopio');
INSERT INTO aaTipoArma (aaNombre) VALUES ('Misil / Mortero');
INSERT INTO aaTipoArma (aaNombre) VALUES ('BioSensor / BioEscaner');
INSERT INTO aaTipoArma (aaNombre) VALUES ('Laser / Bayoneta');

INSERT INTO aaTipoExobot (aaNombre) VALUES ('ExoAsalto');
INSERT INTO aaTipoExobot (aaNombre) VALUES ('ExoExplorador');
INSERT INTO aaTipoExobot (aaNombre) VALUES ('ExoInfanteria');
INSERT INTO aaTipoExobot (aaNombre) VALUES ('ExoMedico');
INSERT INTO aaTipoExobot (aaNombre) VALUES ('ExoComando');

-- Mapeo inicial de Armas (Simplificado para el ejemplo)
-- Se asume orden secuencial 1-5 corresponde a los tipos
INSERT INTO aaArma (aaIdTipoArma, aaNombre) VALUES (1, 'Fusil');
INSERT INTO aaArma (aaIdTipoArma, aaNombre) VALUES (2, 'GPS');
INSERT INTO aaArma (aaIdTipoArma, aaNombre) VALUES (3, 'Misil');
INSERT INTO aaArma (aaIdTipoArma, aaNombre) VALUES (4, 'BioSensor');
INSERT INTO aaArma (aaIdTipoArma, aaNombre) VALUES (5, 'Laser');
