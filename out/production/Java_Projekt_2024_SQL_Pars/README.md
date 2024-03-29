TODO

1) Veergude eristamine
  -  Veerud on SELECT ja FROM-i vahel (Esimeses versioonis ei arvesta subselectiga enne FROM-e)
  -  Veerud jaotuvad läbi komade
  -  Komad võivad veel esineda sulgude sees. Need komad ei erista väljund veerge.
  -  Esmane klass on veerg, tema isendid on siis erinevad veerud.
  -  Iga veeru sees on String veerg, String allikasVeerg ja String allikasTabel
3) Tabelite eristamine
4) Kasutajalt sisendi küsimine (küsib näiteks faili nime või veergu?)
5) Randomi kasutamine (tagasta suvaline veerg?)



V 0.1
  - Hardcodetud sisendiga
  - Praegune pakett loob klasse veerg mis näitavad siis lihtsalt iga tagastatava veeru koodi eraldi.
  - Edasi peaks neist siis välja võtma tabeli nimed ja andmebaasid, selleks on tarvis võtta kõik tabelid mis tulevad siis pärast märksõnu from või join. Peale tabelite nimesid on aliased mida saab siis meie praegusega klassiga siduda

