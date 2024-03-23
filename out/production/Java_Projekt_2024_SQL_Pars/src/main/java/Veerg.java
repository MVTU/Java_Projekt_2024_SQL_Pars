package main.java;

public class Veerg {

    public String veerg;
           public String allikasVeerg;
                 public   String allikasTabel;


    public Veerg(String veerg, String allikasVeerg, String allikasTabel) {
        this.veerg = veerg;
        this.allikasVeerg = allikasVeerg;
        this.allikasTabel = allikasTabel;
    }

    @Override
    public String toString() {
        return "Veerg{" +
                "veerg='" + veerg + '\'' +
                ", allikasVeerg='" + allikasVeerg + '\'' +
                ", allikasTabel='" + allikasTabel + '\'' +
                '}';
    }
}

