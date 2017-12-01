DROP DATABASE spelRvi;

CREATE DATABASE spelRvi
DEFAULT CHARACTER SET utf8;

USE spelRvi;

CREATE TABLE Spelskapargrupp
(
    namn VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE Spelskapare
(
    spelskaparID INT NOT NULL PRIMARY KEY,
    namn VARCHAR(100) NOT NULL
);

CREATE TABLE Medlemskap
(
    spelskapargrupp VARCHAR(100) NOT NULL,
    spelskapare INT NOT NULL,

    PRIMARY KEY(spelskapargrupp, spelskapare),

    FOREIGN KEY(spelskapargrupp) REFERENCES Spelskapargrupp(namn) ON UPDATE CASCADE,
    FOREIGN KEY(spelskapare) REFERENCES Spelskapare(spelskaparID) ON UPDATE CASCADE
);

CREATE TABLE Spel
(
    spelID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    namn VARCHAR(100) NOT NULL,
    beskrivning VARCHAR(1000),
    spelskapargrupp VARCHAR(100),
    spelskaparperson INT,

    FOREIGN KEY(spelskapargrupp) REFERENCES Spelskapargrupp(namn) ON UPDATE CASCADE,
    FOREIGN KEY(spelskaparperson) REFERENCES Spelskapare(spelskaparID) ON UPDATE CASCADE
);

CREATE TABLE Genre
(
    namn VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE SpelGenre
(
    genre VARCHAR(100) NOT NULL,
    spel INT NOT NULL,

    PRIMARY KEY (genre, spel),

    FOREIGN KEY(genre) REFERENCES Genre(namn) ON UPDATE CASCADE,
    FOREIGN KEY(spel) REFERENCES Spel(spelID) ON UPDATE CASCADE
);

CREATE TABLE Innehallsklassificering
(
    namn VARCHAR(100) NOT NULL PRIMARY KEY,
    beskrivning VARCHAR(1000)
);

CREATE TABLE SpelInnehallsklassificering
(
    innehallsklassificering VARCHAR(100) NOT NULL,
    spel INT NOT NULL,

    PRIMARY KEY(innehallsklassificering, spel),

    FOREIGN KEY(innehallsklassificering) REFERENCES Innehallsklassificering(namn) ON UPDATE CASCADE,
    FOREIGN KEY(spel) REFERENCES Spel(spelID) ON UPDATE CASCADE
);
