package main.java;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Kasutaja Sisend
        System.out.println("Sisesta SQL failinimi: ");
        String failiNimi = scanner.nextLine();

        System.out.println("Sisesta tahetud veeru nimi või kõik: ");
        String väljundVeeruNimi = scanner.nextLine();

        Failid Essa = new Failid(failiNimi);
        KirjutaCSV metadata = new KirjutaCSV();

        List<Veerg> newVeergList = new ArrayList<>();
        List<Tabel> newTabelList = new ArrayList<>();

        newVeergList = Essa.jaotaParing().leiaVeerud();
        newTabelList = Essa.jaotaParing().leiaSisend();

        List<String> väljundVeerg = new ArrayList<>();
        ArrayList<String> sisendTabel = new ArrayList<>();
        ArrayList<String> sisendVeerg = new ArrayList<>();

        for(Veerg v : newVeergList){

            //Mustri otsimine
            Pattern patternTabel = Pattern.compile("väljundVeerg='(.*?)'");
            Matcher matcherTabel = patternTabel.matcher(v.toString());


            Pattern patternTabel1 = Pattern.compile("veeruNimi='(.*?)'");
            Matcher matcherTabel1 = patternTabel1.matcher(v.toString());


            //Lisab väljundVeeru andmed Listi
            while (matcherTabel.find()) {
                String nimi = matcherTabel.group(1);
                väljundVeerg.add(nimi);
                if (v.allikasTabelid.size() > 1){
                    väljundVeerg.add(nimi.trim());
                }
            }
            //Lisab sisendVeeru andmed Listi
            while (matcherTabel1.find()) {
                String nimi = matcherTabel1.group(1);
                if (nimi.endsWith(",")) {
                    nimi = nimi.substring(0, nimi.length() - 1);
                    sisendVeerg.add(nimi.trim());
                }
                else
                    sisendVeerg.add(nimi.trim());
            }
            for (Tabel t: v.allikasTabelid){
                for (Tabel tAlias : newTabelList){
                    if (tAlias.tabelAlias.equalsIgnoreCase(t.tabelAlias)){
                        t.tabeliNimi = tAlias.tabeliNimi;

                        //Lisab sisendTabeli Listi
                        sisendTabel.add(t.tabeliNimi.trim());

                        break;
                    }
                }
            }
        }

        //int taisJuhuarv = (int)Math.round(Math.random()*newVeergList.length()+ 0);

        for(Veerg v : newVeergList) {
            if (väljundVeeruNimi.equalsIgnoreCase("kõik") || väljundVeeruNimi.isEmpty()){
                System.out.println(v.toString());
            }
           /* if (väljundVeeruNimi.equalsIgnoreCase("suvaline"))
            {

            }*/
            if (v.getNimi().equalsIgnoreCase(väljundVeeruNimi)){
                System.out.println(v.toString());
                break;
            }
        }

        //Kirjutam CSV faili
        metadata.kirjuta(väljundVeerg, sisendTabel, sisendVeerg, failiNimi);

        scanner.close();
    }
}



    
