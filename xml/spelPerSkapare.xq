<Resultat>
{ 

for $s in //Spelskapare
return <Skapare> { attribute Namn { $s/Namn } }

{
  for $g in $s/Spel
  return <Spel> { attribute Namn { $g/Namn } } </Spel> 
} </Skapare>
}
</Resultat>
