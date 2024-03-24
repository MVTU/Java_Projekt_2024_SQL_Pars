package main.java;

public class Veerg {

    public String veeruKood;
           public String allikasVeerg;
                 public   Tabel allikasTabel;


    public Veerg(String veeruKood, String allikasVeerg, Tabel allikasTabel) {
        this.veeruKood = veeruKood;
        this.allikasVeerg = allikasVeerg;
        this.allikasTabel = allikasTabel;
    }


    @Override
    public String toString() {
        return "Veerg{" +
                "veeruKood='" + veeruKood + '\'' +
                ", allikasVeerg='" + allikasVeerg + '\'' +
                ", allikasTabel='" + allikasTabel + '\'' +
                '}';
    }
}

