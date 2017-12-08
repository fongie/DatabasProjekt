<Resultat>
{ 

for $s in distinct-values(//Spelserie)
return <Spelserie> { attribute Namn { $s } }

{
  for $g in //Spel
  where $g/SpelVersion/Spelserie = $s
  return <Produkt> { attribute Namn { $g/Namn } } </Produkt> 
} </Spelserie>
}
</Resultat>