package main.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class KirjutaCSV {

        public void kirjuta(String failiNimi, ArrayList<String> tabeliNimed,ArrayList<String> veeruiNimed){
            String csvFile = "metadata.csv";


            try {
                // Loome OutputStreamWriter objekti, määrates UTF-8 kodeeringu
                Writer writer = new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8");

                // Kirjutame pealkirjarida
                writer.append("VäljundVeerg,SisendTabel,SisendVeerg,Failinimi\n");// sisu on ajutine test.


                // Kirjutame iga rea andmed CSV-faili (Tuleb Tsükkel)
                System.out.println(veeruiNimed.size());
                for(int i=0; i<veeruiNimed.size();i++){
                    String tabel = tabeliNimed.get(i);
                    String veerud = veeruiNimed.get(i);
                    writer.append("..."+","+tabel+","+veerud+ ","+failiNimi+"\n");
                }
/*
                for(String nimi : tabeliNimed) {
                    writer.append(","+nimi+",\n");
                }
                for(String veerg : veeruiNimed){
                    writer.append(","+veerg);
                }
                for(int i=0; i<tabeliNimed.size();i++){
                    writer.append(","+failiNimi) ;

                }
*/
                // Sulgeme CSV-faili kirjutaja
                writer.close();

                System.out.println("CSV-fail " + csvFile + " on edukalt loodud!");
            } catch (
                    IOException e) {
                e.printStackTrace();
        }
    }
}


