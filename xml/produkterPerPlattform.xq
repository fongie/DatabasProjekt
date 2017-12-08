<Resultat>
{ 

for $s in distinct-values(//Plattform)
return <Plattform> { attribute namn { $s }, attribute 
antalprodukter { 

count(for $v in //Plattform where $v = $s return <N></N>)

 } }
 </Plattform>
}
</Resultat>