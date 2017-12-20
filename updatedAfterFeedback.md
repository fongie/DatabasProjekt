# Uppdatering av projektet
> 2017-12-14

## Konceptuell modell
* Namn i Spel borde inte vara unik. Det motsäger identifieraren som finns till vänster.
* Recensent i Spelrecension borde inte vara unik. Enligt identifieraren är det en kombination.


`Vi tog bort UN för namn på Spel och UN för recensent på Spelrecension eftersom de inte är unika i sig, bara i kombination med andra attribut, precis som diagrammet beskriver i kommentarerna.`



## Logisk relationsdatabasmodell
* Spelserie är nu relaterad till en plattform. Det fanns ingen sådan association i den konceptuella modellen.
* Kolumner som tillåter NULL är inte markerade korrekt.
* Era AN är inte rätt. T ex i Spel och i Spelserie.


`Vi la till kopplingen mellan plattform och spelserie i Asta diagrammet (Konceptuell modell)`

`Ändrat så att NULL eller inte stämmer med Access (och Asta)`

`Namn ihop med spelskapargrupp och spelskaparperson blir en AN1 (är alltid unikt)`

## Modellen i Access
* Butik är inte rätt definierad. Kolla vilka kolumner som tillåter NULL och vilka unika index som finns.

`Fixade så att rätt fält var required`

## Data i Access
* Otillräcklig datavariation:
 * Inga två spel har samma namn
 * Inga två spel är skapade av samma grupp
 * Ingen epost har flera bevakningar av samma produkt (i olika butiker)
 * Ingen epost har flera bevakningar i samma butik (av olika produkter)
 * Ingen personskapare är med i flera grupper.
 * Inga två butiker har samma adress (i olika orter)
* Fel data:
 * Er verksamhetsregel säger att man inte får bevaka sådant som finns i lager, men ni har bevakningar där saldot är större än noll.
 * Ni har spelversioner i samma serie fast de inte har samma plattform.


`Vi har ändrat och lagt till det som saknats i alla punkter ovan`

`Sista punkten (va vi lite osäkra på vad Nikos menade). Ändade jag så att spel 3 fick Atari Arcade som plattform, den hade en annan plattform innan. Nu har alla spelversioner i som ligger i samma serie samma plattform.`

## XML Struktur
* Fixa så att Spel grupperas inuti Spelskapare
* Se till att inga spelserienamn inkluderar plattformen
* Lägg till streckkod på spelversioner

`Fixat så att javaprogrammet skriver ut på detta sätt nu. Lite osäker på vad som menas med att inga spelserienamn "inkluderar plattformen"? `

## XQuery
* Anpassa XQuery11 till nya strukturen

`Gjort`

* Fixa Xquery12

`Gjort`

* Fixa Xquery13 så att seriens plattform hanteras separat från seriens namn och så att streckkoden inkluderas i resultatet

## SQL
* Fixa SQL 3
