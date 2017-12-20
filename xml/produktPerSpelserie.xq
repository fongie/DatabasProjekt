<Resultat>
{ 

for $s in distinct-values(//Spelserie)
return <Spelserie> { attribute Namn { $s }, attribute Plattform {distinct-values(//SpelVersion[Spelserie = $s]/Plattform)} }

{
  for $g in //SpelVersion
  where $g/Spelserie = $s
  return <Produkt> { attribute Streckkod { $g/Streckkod }, attribute Namn { $g/parent::*/Namn } } </Produkt> 
} </Spelserie>
})
</Resultat>
