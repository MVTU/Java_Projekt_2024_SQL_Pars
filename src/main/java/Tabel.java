package main.java;

public class Tabel {
    String tabelNimi;
    String tabelAlias;

    @Override
    public String toString() {
        return "Tabel{" +
                "tabelNimi='" + tabelNimi + '\'' +
                ", tabelAlias='" + tabelAlias + '\'' +
                '}';
    }

    public Tabel(String tabelNimi, String tabelAlias) {
        this.tabelNimi = tabelNimi;
        this.tabelAlias = tabelAlias;
    }
}
