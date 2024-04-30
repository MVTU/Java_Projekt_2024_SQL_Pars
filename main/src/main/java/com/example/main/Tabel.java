package com.example.main;

public class Tabel {
    String veeruNimi;
    String tabelAlias;
    String tabeliNimi;

    @Override
    public String toString() {
        return "Tabel{" +
                "veeruNimi='" + veeruNimi + '\'' +
                ", tabelAlias='" + tabelAlias + '\'' +
                "tabeliNimi='" + tabeliNimi + '\'' +
                '}';
    }



    public Tabel(String veeruNimi, String tabelAlias, String tabeliNimi) {
        this.veeruNimi = veeruNimi;
        this.tabelAlias = tabelAlias;
        this.tabeliNimi = tabeliNimi;
    }




}
