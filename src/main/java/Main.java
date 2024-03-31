package main.java;
import java.nio.channels.OverlappingFileLockException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisetsa SQL failinimi: ");
        String failiNimi = scanner.nextLine();


        //Failid Essa = new Failid("SELECT.sql");
        Failid Essa = new Failid(failiNimi);
        //ystem.out.println(Essa.jaotaParing().toString());
        System.out.println(Essa.jaotaParing().leiaVeerud().toString());
        System.out.println(Essa.jaotaParing().leiaSisend().toString());

        //System.out.println(Essa.jaotaParing());


        //Kirjutab metadata CSV faili
        KirjutaCSV metadata = new KirjutaCSV();
        metadata.kirjuta(failiNimi);


        //System.out.println("hello");
        scanner.close();

    }


    }