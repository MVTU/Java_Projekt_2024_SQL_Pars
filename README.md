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


### Sisend:
 - Veeru nimi ( sel 'a' , 'b' as c FROM dummy puhul saab mälu järgi esimene veerg nimeks a ja teise puhul c)
 - Veeru number (ehk SELECT 'a' as a , 'b' as b FROM dummy puhul on a == 1 ja b == 2 )
 - Tagasta suvaline ( rühmatöö näite nõue)
 - Väljundi piiramine või modifitseerimine ( näiteks -tabel annab ainult kõik kasutatud tabelid, -veerg annab ainult kõik veerud)

### Väljund:

 #### Prindi kõik tabelid ja veerud mida kasutati
  - Näiteks
  CASE WHEN o.orders_id then '1' \
  when o.order_type = 'A' then '2' \
  else oi.order_inventory_type end 
  -  Võiks tagastada 
  Kasutatud tabelid ja veerud: \
  Orders , [orders_id, order_Type] \
  Order_Inventory, [order_inventory_type] 

#### Tekita metadata csv fail:
  Tabel Veerg Failinimi \
  Order, orders_id , sel.sql \ 
  Order, order_Type, sel.sql \ 
  Order_Inventory , order_inventory_Type, sel.sql 




