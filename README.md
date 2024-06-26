# Link gitile:

https://github.com/MVTU/Java_Projekt_2024_SQL_Pars.git \

Versioon 2 main asukoht: src/main/java/com/example/main/Main.java \ 

Vana versioon talletatud kausta V1: src/main/java/V1/Main.java

# Eesmärk

Antud projekti eesmärgiks on lihtsustada andmebaaside ja andmeaitade haldamise tööd. \
Äriloogika muutumisel või tabelite struktuuride ümberkujundamisel on mõnel juhul aeganõudev töö suuremate SQL päringute lahtiharutamine. \
Antud programm aitab luua selgust veergude tekitamisel kasutatud täpseid  alusandmeid ning võimaldab tekitada ka metaandmeid edasiseks kasutamiseks. \
Graafiline kasutajaliides võimaldab kasutajal valida uue faili nime ning hõlpsustab andmete vaatamist. \
Kasutajaliides pakub teavet omaenda funktsionaalsuse kohta. 

## Kasutus

Anna programmile ette enda SQL fail, näiteks SELECT.sql \
Kirjelda kas tahad ühte kindlat tagastusrida või kõiki. \
Programm kirjutab nõutud väljendi metadata.csv või enda poolt nimetatud faili töökausta vastavalt struktuurile VäljundVeerg, Sisendtabel,Sisendveerg,Failinimi

## Kirjeldus

Antud esimene versioon on spetsialiseerunud ühele kindlale failitüübile ehk tavalisele selectile. Praegu oskab programm tegeleda näitena toodud failis oleva tüübiga : SELECT.sql \
Programm eeldab, et on teada väljastatavad veergude nimed kui tahta ühe konkreetset rida. Kui on üks muutmata sisend siis võetakse veeru nimi ning kui on kasutatud süntaksi AS nimi, siis tagastatakse nimi. \
Veergude eristamisel ei tohiks programmi häirida sulud, aga veergude eristamine toimub läbi komade leidmise. Veergude ajal on siis see funktsioon pausil. \
Antud versioon ei tööta subquerydega.

## Töö kirjeldus

1) Mattias lõi esimese versiooni mis võttis sisendi, lõi selle kaheks osaks seoses sellega kus FROM on ning lõi klassid mis andmed erinevatesse tüüpidesse jagas.
2) Rando lõi faili lugemise ja kirjutamise osa.

Git sai kasutatud kui versioonide hoidjana kogu töö vältel.
Peale esimese sisendi loomist oli tarvis seda paar korda üle teha ehk töö järgis seda malli korduvalt.

Testimine käis vastavalt sisendfailile. Klasse kõigepealt lihtsalt kirjutas terminali ning lõpuks testisime vastavalt väljundfailile.

Versioon 2
1) Rando lisas graafilise osa, kus saab kasutaja kuvada infot, sisestada failinime, valida veeru rippmenüüst ja näha väljastavaid ridu ning nupu, mis avab loodud CSV faili. Samuti vea teated vigade korral.
2) Mattias lisas võimaluse kasutada klaviatuuri esialgsete andmete sisestamiseks, akna suurendamiseks ning lõppfaili nime muutmiseks.

## Probleemid ja kommentaarid

Algselt oleks võinud võtta konkreetsemad nõuded enda projektile, sai proovitud agiilselt arendada ehk kui esimene osa töötas siis sai lisatud kohe uus funktsioon.
Oleks pidanud rohkem mõtlema eestikeelsete väljendite peale, antud klassikirjeldused on vahest natukene segadused, aga ei panustanud aega teiste näidisprogrammide uurimisele.
Oleks võinud ka rohkem kokku mängida arendust, enamus tööd sai vist tehtud eraldi.
Valmis töö vastab esimesele visioonile, aga eks kasutamiseks oleks antud programmiga omajagu rohkem aega tegeleda. Praegune töö sai tehtud näite pealt, aga oleks tarvis kirjeldada ka kõik tahetud SQL-i tüübid mida kasutada.

Mattias panustas umbeks kaks õhtupoolikut. \
Rando panustas kuskil 16 tundi. 

Versioon kahel panustas Mattias 2 õhtupoolikut. \
Rando panustas kuskil 6-8h.





#### Versioonid ja plaan

1) Veergude eristamine
  -  Veerud on SELECT ja FROM-i vahel (Esimeses versioonis ei arvesta subselectiga enne FROM-e)  
  -  Veerud jaotuvad läbi komade
  -  Komad võivad veel esineda sulgude sees. Need komad ei erista väljund veerge.
  -  Esmane klass on veerg, tema isendid on siis erinevad veerud.
  -  Iga veeru sees on String veerg, String allikasVeerg ja String allikasTabel
3) Tabelite eristamine
4) Kasutajalt sisendi küsimine (küsib näiteks faili nime või veergu?)
5) Randomi kasutamine (tagasta suvaline veerg?)

##### Plaan edasiarenduseks

Programmil peaks olema graafiline liides mis küsib faili nime  \
Programm võiks ideaalis esitleda kõik saadaval olevad veerud \
Kasutaja saab hiire või klaviatuuri abil veeru valida \
Kui nimelist veerg mida kasutaja kirjeldab ei leitud, siis antakse teada \
Eelmise versiooni stiilis rea esitlemine oleks ideaal mingis textboxis \
Kui tarvis, siis saab lisada baasfunktsioone  SQL-i lugemiseks 



V 0.1
  - Hardcodetud sisendiga
  - Praegune pakett loob isendeid klassi Veerg mis näitavad siis lihtsalt iga tagastatava veeru koodi eraldi.
  - On olemas nimekiri tabelitest ja kasutatud aliastest, neid peab nüüd võrdlema veergudega ja välja tooma kasutatud tabelid igas veerus.


#### Funktsionaalsuse kirjeldus 

##### Sisend:
 - Veeru nimi ( sel 'a' , 'b' as c FROM dummy puhul saab mälu järgi esimene veerg nimeks a ja teise puhul c)
 - Veeru number (ehk SELECT 'a' as a , 'b' as b FROM dummy puhul on a == 1 ja b == 2 )
 - Tagasta suvaline ( rühmatöö näite nõue)
 - Väljundi piiramine või modifitseerimine ( näiteks -tabel annab ainult kõik kasutatud tabelid, -veerg annab ainult kõik veerud)

##### Väljund:

 ##### Prindi kõik tabelid ja veerud mida kasutati
  - Näiteks \
  CASE WHEN o.orders_id then '1' \
  when o.order_type = 'A' then '2' \
  else oi.order_inventory_type end AS Order_Mapped
  -  Võiks tagastada \
  Kasutatud tabelid ja veerud: \
  Orders , [orders_id, order_Type] \
  Order_Inventory, [order_inventory_type] 

#### Tekita metadata csv fail:
  VäljundVeerg SisendTabel SisendVeerg Failinimi \
  Order_Mapped Order, orders_id , sel.sql \
  Order_Mapped ,Order, order_Type, sel.sql \
  Order_Mapped, Order_Inventory , order_inventory_Type, sel.sql 




