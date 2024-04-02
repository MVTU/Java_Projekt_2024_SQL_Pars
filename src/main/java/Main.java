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
        System.out.println("Sisetsa SQL failinimi: ");
        String failiNimi = scanner.nextLine();
        KirjutaCSV metadata = new KirjutaCSV();


        //Failid Essa = new Failid("SELECT.sql");
        Failid Essa = new Failid(failiNimi);
        String sisend1 = Essa.jaotaParing().leiaVeerud().toString();
        //ystem.out.println(Essa.jaotaParing().toString());
        System.out.println(Essa.jaotaParing().leiaVeerud().toString());
        System.out.println(Essa.jaotaParing().leiaSisend().toString());

        //Kirjutab metadata CSV faili
        Pattern patternTabel = Pattern.compile("tabelNimi='(.*?)'");
        Matcher matcherTabel = patternTabel.matcher(Essa.jaotaParing().leiaSisend().toString());

        Pattern pattern = Pattern.compile("tabelNimi='(.*?)'");
        Matcher matcher = pattern.matcher(sisend1);
        // alias = Pattern.compile("tabelAlia='(.*?)'");

        ArrayList<String> tabelNimed = new ArrayList<>();
        ArrayList<String> veeruKoodid = new ArrayList<>();
        // Leidke iga ühilduvus ja lisage tabelNimi väärtus ArrayListi
        while (matcherTabel.find()) {
            String tabelNimi = matcherTabel.group(1);
            tabelNimed.add(tabelNimi);
        }
        while (matcher.find()) {
            String veeruKood = matcher.group(1);
            veeruKoodid.add(veeruKood);
        }
        VäljundVeerg välVeerg = new VäljundVeerg();
        List<String> väljundVeerg = välVeerg.test(failiNimi);

        metadata.kirjuta(väljundVeerg, tabelNimed, veeruKoodid, failiNimi);

        scanner.close();
    }
}



    