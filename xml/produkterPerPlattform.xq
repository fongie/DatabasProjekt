<Resultat>
{ 

for $s in distinct-values(//Plattform)
return <Plattform> { attribute namn { $s }, attribute 
antalprodukter { 

count(//Plattform[data() = $s])

 } }
 </Plattform>
}
</Resultat>
