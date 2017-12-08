<Resultat>
{ 
for $g in distinct-values(//Genre)
return <Genre> { attribute Namn { $g } } </Genre>
 }
</Resultat>