package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Failid{

    String failid;

    public Failid(String failid) {
        this.failid = failid;
    }

    public Paring jaotaParing() {
        StringBuilder valjund = new StringBuilder();
        StringBuilder sisend = new StringBuilder() ;
        try (Scanner sc = new Scanner(new File(failid), "UTF-8")) {
            StringBuilder blokk = new StringBuilder();
            boolean fromOlemas = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("FROM")) {
                    fromOlemas = true;
                }
                if (fromOlemas) {
                    sisend.append(line).append('\n');
                } else {
                    valjund.append(line).append('\n');
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Paring uusParing = new Paring(valjund, sisend);
        return(uusParing);
    }

    @Override
    public String toString() {
        return "Failid{" +
                "failid='" + failid + '\'' +
                '}';
    }
}