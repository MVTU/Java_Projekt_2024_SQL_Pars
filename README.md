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
  - Praegune pakett loob isendeid klassi Veerg mis näitavad siis lihtsalt iga tagastatava veeru koodi eraldi.
  - On olemas nimekiri tabelitest ja kasutatud aliastest, neid peab nüüd võrdlema veergudega ja välja tooma kasutatud tabelid igas veerus.



