USE spelRvi;

-- Should not allow Spel or Innehallsklassificering without name
INSERT INTO Spel(beskrivning) VALUES ('en beskrivning');
INSERT INTO Innehallsklassificering(beskrivning) VALUES ('en beskrivning');

-- Should not allow a genre without a connected game
INSERT INTO SpelGenre(genre) VALUES (2);

-- Should not allow a spelID which doesnt exist (we dont have 100 games)
INSERT INTO SpelGenre(spel, genre) VALUES (100, 2);

-- similarly
INSERT INTO Medlemskap(spelskapargrupp) VALUES (2);
INSERT INTO Medlemskap(spelskapargrupp, spelskapare) VALUES (100, 2);

-- Should not allow a spelskapare without a name
INSERT INTO Spelskapare(spelskaparID) VALUES(25);

-- Should not allow a spelskapargrupp inside spel who doesnt exist
INSERT INTO Spel(namn, beskrivning, spelskapargrupp) VALUES ('TestSpel', 'Beskrivning', 'DennaGruppFinnsInte');
