# Verksamhetsregler för spelRvi databas

* Antingen en grupp eller en skapare gör ett spel
* Man *måste* ha antingen en spelskapargrupp eller spelskapare, båda kan inte vara noll.
* Man får inte bevaka en produkt som finns i lager

### Unika relationer

* Lagersaldo: Kombinationen av relationen till spelversion och relationen till butik är unik för lagersaldot
* Produktbevakning: Kombinationen av epost och vilket lagersaldo den bevakar är unikt


Implementation-tips:
- Testa databasen med olika data, t.ex spel som inte har serie, spel som har serie, spel som har spelseriegrupp, osv
