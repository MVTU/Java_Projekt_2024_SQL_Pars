package main.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class KirjutaCSV {

        public void kirjuta(String failiNimi){
            String csvFile = "metadata.csv";


            try {
                // Loome OutputStreamWriter objekti, määrates UTF-8 kodeeringu
                Writer writer = new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8");

                // Kirjutame pealkirjarida
                writer.append("VäljundVeerg,SisendTabel,SisendVeerg,Failinimi\n");// sisu on ajutine test.

                // Kirjutame iga rea andmed CSV-faili (Tuleb Tsükkel)
                writer.append("Order_Mapped,Order,orders_id,"+ failiNimi + "\n");// sisu on ajutine test. (failinimi paigas)
                writer.append("Order_Mapped,Order,order_Type,"+ failiNimi + "\n");// sisu on ajutine test. (failinimi paigas)
                writer.append("Order_Mapped,Order_Inventory,order_inventory_Type," +failiNimi +"\n");// sisu on ajutine test. (failinimi paigas)

                // Sulgeme CSV-faili kirjutaja
                writer.close();

                System.out.println("CSV-fail " + csvFile + " on edukalt loodud!");
            } catch (
                    IOException e) {
                e.printStackTrace();
        }
    }
}


