<Resultat>
{ 

for $s in distinct-values(//Spelserie)
return <Spelserie> { attribute Namn { $s }, attribute Plattform {$s/parent::*/Plattform} }

{
  for $g in //SpelVersion
  where $g/Spelserie = $s
  return <Produkt> { attribute Streckkod { $g/Streckkod }, attribute Namn { $g/parent::*/Namn } } </Produkt> 
} </Spelserie>
})
</Resultat>
