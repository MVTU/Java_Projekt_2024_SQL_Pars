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

    public ArrayList<Veerg> leiaVeerud() {
        StringBuilder tmpValjund = new StringBuilder();
        String suluAlgus = "(";
        String suluLõpp = ")";
        String koma = ",";
        int reaAlgus = 0;
        int reaLõpp = 0;
        boolean suluInd = false;
        ArrayList veerud = new ArrayList<Veerg>();
        for (int i = 0; i < valjund.length(); i++) {
            if (reaAlgus <= reaLõpp) {
                if (suluAlgus.equals(String.valueOf(valjund.charAt(i)))) {
                    suluInd = true;
                    //System.out.println("a");
                } else if (koma.equals(String.valueOf(valjund.charAt(i))) && !suluInd) {
                    //System.out.println("b");
                    reaLõpp = i;
                    veerud.add(new Veerg(valjund.substring(reaAlgus, reaLõpp), null, null));
                    reaAlgus = i;
                }
                //  else{
                //System.out.println(String.valueOf(valjund.charAt(i)));
                // }}
            }
            //System.out.println(valjund);
        }

    return (veerud);
    }
}
