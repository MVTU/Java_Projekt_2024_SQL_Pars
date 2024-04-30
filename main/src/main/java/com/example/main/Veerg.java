package com.example.main;

import java.util.ArrayList;

public class Veerg {

    public String veeruKood;
    public ArrayList<Tabel> allikasTabelid = new ArrayList<>();
    public String nimi;


    public Veerg(String veeruKood) {
        this.veeruKood = veeruKood;
    }

    public String getVeeruKood() {
        return veeruKood;
    }

    public void setVeeruKood(String veeruKood) {
        this.veeruKood = veeruKood;
    }

    public ArrayList<Tabel> getAllikasTabelid() {
        return allikasTabelid;
    }

    public void setAllikasTabelid(ArrayList<Tabel> allikasTabelid) {
        this.allikasTabelid = allikasTabelid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public ArrayList<Tabel> leiaSisendTabel() {
        String[] sõned = veeruKood.split(" ");
        for (int i = 0; i < sõned.length; i++) {
            String[] sõne = sõned[i].split("\\.");
            if (sõne.length == 2) {
                String[] aliasSplit = sõne[0].split("\\(") ;
                String alias;
                if(aliasSplit.length > 1){
                    alias = aliasSplit[aliasSplit.length-1];
                }
                else {
                    alias = sõne[0];
                }

                String tabel = sõne[1];
                Tabel uus = new Tabel(tabel, alias,null);
                allikasTabelid.add(uus);
                if (1 == sõned.length) {
                    nimi = tabel;
                    nimi = nimi.trim();
                }
            }
        }
        if (sõned.length > 2) {
            if (sõned[sõned.length - 2].trim().equalsIgnoreCase("AS")) {
                nimi = sõned[sõned.length - 1];
                nimi = nimi.trim();
            }
        }

        return  allikasTabelid;
        }







    @Override
    public String toString() {
        return "Veerg{" +
                "veeruKood='" + veeruKood + '\'' +
                ", allikasTabel='" + allikasTabelid + '\'' +
                ", väljundVeerg='" + nimi + '\'' +
                '}';

    }
}

