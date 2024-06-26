package com.example.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class KirjutaCSV {

        public void kirjuta(List<String> väljundVeerg, ArrayList<String> sisendTabel, List<String> sisendVeerg, String failiNimi){
            String csvFile = "metadata.csv";

            try (Writer writer = new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8") ) {
                // Loome OutputStreamWriter objekti, määrates UTF-8 kodeeringu


                    // Kirjutame pealkirjarida
                writer.append("VäljundVeerg,SisendTabel,SisendVeerg,Failinimi\n");// sisu on ajutine test.


                    // Kirjutame iga rea andmed CSV-faili (Tuleb Tsükkel)

                for(
                    int i = 0; i<väljundVeerg.size();i++)

                    {

                        String tabel = (i < sisendTabel.size()) ? sisendTabel.get(i) : " ";
                        String veerud = (i < sisendVeerg.size()) ? sisendVeerg.get(i) : " ";
                        String väljund = (i < väljundVeerg.size() ? väljundVeerg.get(i) : " ");
                        writer.append(väljund + "," + tabel + "," + veerud + "," + failiNimi + "\n");

                    }

                    // Sulgeme CSV-faili kirjutaja
                writer.close();

                System.out.println("CSV-fail "+csvFile +" on edukalt loodud!");
                } catch(
                        IOException e){
                throw new RuntimeException("Faili ei suudetud luua", e);

            }

    }
    public void kirjuta(List<String> väljundVeerg, ArrayList<String> sisendTabel, List<String> sisendVeerg, String failiNimi, String uusFail){

        // Määra uus fail kui anti sisend


        String csvFile;
        if (uusFail == null || uusFail.trim().isEmpty()) {
            csvFile = "metadata.csv";
        }
        else {

            csvFile = uusFail + ".csv";
        }
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8")){
            // Loome OutputStreamWriter objekti, määrates UTF-8 kodeeringu



            // Kirjutame pealkirjarida
            writer.append("VäljundVeerg,SisendTabel,SisendVeerg,Failinimi\n");// sisu on ajutine test.


            // Kirjutame iga rea andmed CSV-faili (Tuleb Tsükkel)

            for(int i=0; i<väljundVeerg.size();i++) {

                String tabel = (i < sisendTabel.size()) ? sisendTabel.get(i) : " ";
                String veerud = (i < sisendVeerg.size()) ? sisendVeerg.get(i): " ";
                String väljund = (i < väljundVeerg.size() ? väljundVeerg.get(i): " ");
                writer.append(väljund + ","+tabel+","+ veerud + "," +failiNimi+"\n");

            }

            // Sulgeme CSV-faili kirjutaja
            writer.close();

            System.out.println("CSV-fail " + csvFile + " on edukalt loodud!");
        } catch (
                IOException e) {
            throw new RuntimeException("Faili ei suudetud luua", e);
        }
    }


}


