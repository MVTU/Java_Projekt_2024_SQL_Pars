package main.java;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;


public class Paring {

    public StringBuilder valjund;
    public StringBuilder sisend;

    public Paring(StringBuilder valjund, StringBuilder sisend) {
        this.valjund = valjund;
        this.sisend = sisend;
    }

    @Override
    public String toString() {
        return "Paring{" +
                "valjund='" + valjund + '\'' +
                ", sisend='" + sisend + '\'' +
                '}';
    }
    //Otsi väljastatavad veerud selectist
    public ArrayList<Veerg> leiaVeerud() {
        StringBuilder tmpValjund = new StringBuilder();
        String suluAlgus = "(";
        String suluLõpp = ")";
        String koma = ",";
        int reaAlgus = 0;
        int reaLõpp = 0;
        boolean suluInd = false;
        String selekt = "Select";
        ArrayList veerud = new ArrayList<Veerg>();
        for (int i = 0; i < valjund.length(); i++) {

            //Otsi sulu algust, et mitte arvestada sealseid komasid
             if (suluAlgus.equals(String.valueOf(valjund.charAt(i)))) {
                    suluInd = true;

                    //Kui pole sulgude sees ja on näha koma siis arvesta veeruks
                } else if (koma.equals(String.valueOf(valjund.charAt(i))) && !suluInd) {
                    reaLõpp = i;

                    // Eemalda select osa, eeldus on et valjund algab ilma tühikuteta
                    String[] selectTükk = valjund.substring(reaAlgus, reaLõpp).split("\\s+");
                    if (selekt.equalsIgnoreCase(selectTükk[0])) {
                        reaAlgus = reaAlgus + 6;
                    }
                    veerud.add(new Veerg(valjund.substring(reaAlgus, reaLõpp), null, null));
                    reaAlgus = i;
                }

        }

    return (veerud);
    }
    //Otsi tabelid ja nende aliased pärast from-i
    public ArrayList<Tabel> leiaSisend() {
        StringBuilder tmpValjund = new StringBuilder();
        String suluAlgus = "(";
        String suluLõpp = ")";
        String koma = ",";
        String from = "FROM";
        String join = "JOIN";
        int reaAlgus = 0;
        int reaLõpp = 0;
        boolean suluInd = false;
        String tabel;
        String alias;
        ArrayList tabelid = new ArrayList<Tabel>();
        String[] tükid = sisend.toString().split("\\s+");
        for (int i = 0; i < tükid.length; i++) {

                //Kui näed from-i siis võta järgnev tabel ja alias, järgnevalt sama joiniga
                if (from.equalsIgnoreCase(tükid[i])) {
                    tabel = tükid[i + 1];
                    alias = tükid[i + 2];
                    tabelid.add(new Tabel(tabel,alias));
                } else if (join.equalsIgnoreCase(tükid[i])) {
                    tabel = tükid[i + 1];
                    alias = tükid[i + 2];
                    tabelid.add(new Tabel(tabel,alias));
                }

        }

        return (tabelid);
    }

}
