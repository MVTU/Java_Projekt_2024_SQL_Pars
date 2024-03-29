package main.java;

import java.util.ArrayList;

public class Veerg {

    public String veeruKood;
           public ArrayList<Tabel> allikasTabelid = new ArrayList<>();


    public Veerg(String veeruKood) {
        this.veeruKood = veeruKood;
    }

    public void leiaSisendTabel(){
        String[] sõned = veeruKood.split(" ");
        for (int i = 0; i < sõned.length; i++) {
            String[] sõne = sõned[i].split("\\.");
            if (sõne.length == 2){
            String alias = sõne[0];
            String tabel = sõne[1];
            Tabel uus = new Tabel(tabel,alias);
            allikasTabelid.add(uus);
            }
        }

        }



    @Override
    public String toString() {
        return "Veerg{" +
                "veeruKood='" + veeruKood + '\'' +
                ", allikasTabel='" + allikasTabelid + '\'' +
                '}';
    }
}

