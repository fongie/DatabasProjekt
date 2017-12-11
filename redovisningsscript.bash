mysqldump -u root -p spelRvi > mysql.txt
mv mysql.txt redovisning/mysql.txt
cp xml/spelRvi.xml redovisning/spelRvi.xml

basex -ixml/spelRvi.xml xml/allaGenrer.xq > xml/allaGenrer.res
basex -ixml/spelRvi.xml xml/produktPerSpelserie.xq > xml/produktPerSpelserie.res
basex -ixml/spelRvi.xml xml/spelPerSkapare.xq > xml/spelPerSkapare.res
basex -ixml/spelRvi.xml xml/produkterPerPlattform.xq > xml/produkterPerPlattform.res

{
    echo -e "--------Textfil med XQuery-uttryck och exekveringsresultat--------"
    echo -e "\n\n--------XQuery för  att ta fram Alla Genrer:--------\n"
    cat xml/allaGenrer.xq 
    echo -e "\n--------Exekveringsresultat:--------\n"
    cat xml/allaGenrer.res 
    echo -e "\n\n--------XQuery för  att ta fram Spel per Skapare:--------\n"
    cat xml/spelPerSkapare.xq 
    echo -e "\n--------Exekveringsresultat:--------\n"
    cat xml/spelPerSkapare.res
    echo -e "\n\n--------XQuery för  att ta fram Antal Produkter per Plattform::--------\n"
    cat xml/produkterPerPlattform.xq 
    echo -e "\n--------Exekveringsresultat:--------\n"
    cat xml/produkterPerPlattform.res 
    echo -e "\n\n--------XQuery för  att ta fram Produkter per Spelserie:--------\n"
    cat xml/produktPerSpelserie.xq 
    echo -e "\n--------Exekveringsresultat:--------\n"
    cat xml/produktPerSpelserie.res 
} > xml/xquery.txt

cp xml/xquery.txt redovisning/xquery.txt
