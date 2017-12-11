<Resultat>
{ 

for $s in distinct-values(//Spelskapare)
return <Skapare> { attribute Namn { $s } }

{
  for $g in //Spel
  where $g/Spelskapare = $s
  return <Spel> { attribute Namn { $g/Namn } } </Spel> 
} </Skapare>
}
</Resultat>
