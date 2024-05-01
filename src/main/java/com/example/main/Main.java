package com.example.main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.LabelView;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.input.KeyCode;
import static java.awt.Color.RED;
import static java.awt.SystemColor.text;

public class Main extends Application {
    private Stage primaryStage;
    private Stage secondaryStage;

    private TextField textField1;

    private List<Veerg> newVeergList;
    private String valikud;
    private java.awt.Desktop Desktop;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        //Esimene aken ("Sisesta failinimi")

        Label label1 = new Label("Sisesta failinimi:"); //faili sisestus küsimus.
        Label viga = new Label(""); //Hetkel tühi sõne vea jaoks.
        textField1 = new TextField(); // Texti ala failinimie sisestamise jaoks.

        Button submitButton1 = new Button("Kinnita"); //Nupp kirjutatud faili nime valimise jaoks | vea korral väljastab vea sõnumi.
        submitButton1.setOnAction(e -> handleSubmitButton1(viga)); //Vajutades realiseerib meetodi.
        textField1.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.ENTER){
        handleSubmitButton1(viga);
            }
                }); // Enterit vajutades realiseerib meetodi.

        Button submitButtonInfo = new Button("INFO");
        submitButtonInfo.setOnAction(e -> info());
        VBox root = new VBox(); //GUI juur
        root.getChildren().addAll(label1, textField1,submitButton1, viga, submitButtonInfo); //Lisab väljad aknasse

        Scene scene = new Scene(root, 300, 150); // akna mõõtmed
        primaryStage.setScene(scene);
        primaryStage.setTitle("Failinime Sisestamine"); //akna nimi.
        primaryStage.setResizable(true); //Akna suurst ei sa muuta.
        primaryStage.show();
    }

    private void handleSubmitButton1(Label viga) {
        //Kui vajutada "Kinnita" nupp failinime sisestamisel.
        String failiNimi = textField1.getText(); //Annab muutujale "failiNimi" väärtuseks sisestatud failinime.
        Stage stage1 = (Stage) textField1.getScene().getWindow();
        File fail = new File(failiNimi); //muutja "fail" - kontrollida, kas leidub sisestatud fail.

        try {
            if (failiNimi == null || failiNimi.isEmpty()) {
                //Kui TextField on tühi.
                throw new FileNotFoundException("VIGA: Sisestage failinimi");
            }
            if(!fail.exists()) {
                //Kui TextField'i sisestatud faili ei leidu.
            throw new FileNotFoundException("VIGA: faili ei leita");
            }

            //Alustab faili lahti harutamist.
            Failid Essa = new Failid(failiNimi);
            KirjutaCSV metadata = new KirjutaCSV();

            List<Veerg> newVeergList = new ArrayList<>();
            List<Tabel> newTabelList = new ArrayList<>();

            newVeergList = Essa.jaotaParing().leiaVeerud();
            newTabelList = Essa.jaotaParing().leiaSisend();
            this.newVeergList = newVeergList;

            //Listid, mis hoiavad infot, et pärast CSV faili kirjutada.
            List<String> väljundVeerg = new ArrayList<>();
            ArrayList<String> sisendTabel = new ArrayList<>();
            ArrayList<String> sisendVeerg = new ArrayList<>();

            stage1.close(); //Sulgeb faili sisestus akna.

            for (Veerg v : newVeergList) {
                //Mustri otsimine
                Pattern patternTabel = Pattern.compile("väljundVeerg='(.*?)'");
                Matcher matcherTabel = patternTabel.matcher(v.toString());

                Pattern patternTabel1 = Pattern.compile("veeruNimi='(.*?)'");
                Matcher matcherTabel1 = patternTabel1.matcher(v.toString());

                //Lisab väljundVeeru andmed Listi
                while (matcherTabel.find()) {
                    String nimi = matcherTabel.group(1);
                    väljundVeerg.add(nimi);
                    if (v.allikasTabelid.size() > 1) {
                        väljundVeerg.add(nimi.trim());
                    }
                }
                //Lisab sisendVeeru andmed Listi
                while (matcherTabel1.find()) {
                    String nimi = matcherTabel1.group(1);
                    if (nimi.endsWith(",")) {
                        nimi = nimi.substring(0, nimi.length() - 1);
                        sisendVeerg.add(nimi.trim());
                    } else
                        sisendVeerg.add(nimi.trim());
                }
                for (Tabel t : v.allikasTabelid) {
                    for (Tabel tAlias : newTabelList) {
                        if (tAlias.tabelAlias.equalsIgnoreCase(t.tabelAlias)) {
                            t.tabeliNimi = tAlias.tabeliNimi;
                            //Lisab sisendTabeli Listi
                            sisendTabel.add(t.tabeliNimi);
                            break;
                        }
                    }
                }
            }

            //Kirjutam CSV faili
            metadata.kirjuta(väljundVeerg, sisendTabel, sisendVeerg, failiNimi);


            //Loob teise akna, kus saab teha veeru valiku | näha ridu | avada loodud CSV faili.
            Stage secondaryStage = new Stage(); // Loo uus lava
            Label label2 = new Label("Vali veerg: ");
            javafx.scene.control.TextArea textiAla = new javafx.scene.control.TextArea(""); //Teksti ala, mis kuvab read graafiliselt.
            textiAla.setEditable(false); // Teskti ala ei saa muuta (sinna kirjutada jne)
            Label viga2 = new Label(""); //Tühi sõne juhul kui on vaja väljastada veateade.

            VBox root = new VBox(); //uus juur.

            ComboBox<String> rippMenüü = new ComboBox<>(); //Rippmenüü olemasolevate veergude valimiskes.
            Set<String> unikaalsus = new HashSet<>(väljundVeerg);
            rippMenüü.getItems().addAll(unikaalsus); //Lisab kõik valikud rippmenüüse.
            rippMenüü.getItems().add("kõik"); // Lisab siia listi ka sõne "kõik", et pärast saaks valida rippmenüüst.
            rippMenüü.setOnAction(e -> {
                //Annab "valikud" väärtuseks valitud veeru rippmenüüst.
                this.valikud = rippMenüü.getValue();
            });

            Button submitButton2 = new Button("Vali"); //Nupp, et väljastada valitud veeru read ekraanile.
            submitButton2.setOnAction(e -> handleSubmitButton2(textiAla, viga2)); //Nuppu vajutamisel realiseerib meetodi.
            Button submitButton3 = new Button("Ava loodud CSV fail"); //Nupp loodud CSV faili avamiseks.
            submitButton3.setOnAction(e -> openFile()); //Nuppu vajutamisel realiseerib meetodi.

            root.getChildren().addAll(label2, rippMenüü,viga2, submitButton2, submitButton3, textiAla); //Paigaldab vajamineva aknasse.

            Scene scene = new Scene(root, 1000, 600); //Aken2 suuurus.

            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Vali veerg");
            secondaryStage.setResizable(true); //Akna suurust ei sa muuta.

            secondaryStage.show();
        }catch (FileNotFoundException e){
            //Väljastb vea korral punaselt
            //vea kirjelduse TextField'i alla.
            viga.setTextFill(Color.RED);
            viga.setText(e.getMessage());
            //System.out.println(e.getMessage());
        }

    }
    private void handleSubmitButton2(TextArea textiAla, Label viga2){
        //Kui vajutada "Vali" nuppu veeru valimise aknas.
        String väljundVeeruNimi = valikud; //Annab "väljundVeeruNimi" valitud veeru väärtuse.
        StringBuilder koguTekst = new StringBuilder(); //StringBuilder, mida kasutame, kui valitakse "kõik".
        viga2.setText(""); //Kui viga ei ole, siis vea sõnumit ei ole.
        try {
            if(väljundVeeruNimi == null) {
                //Kui veeru valik on tühi, siis väljastakase vea teade, et tuleb valida veerg.
                throw new NullPointerException("Valige Veerg");
            }
        for(Veerg v : newVeergList) {
            //Kui valitakse "kõik".
            if (väljundVeeruNimi.equalsIgnoreCase("kõik") || väljundVeeruNimi.isEmpty()){
                //System.out.printlnv(.toString());
                koguTekst.append(v.toString()).append("\n");
                textiAla.setText(koguTekst.toString());

            }
            //Kui valitakse ainult üks veerg.
            if (v.getNimi() != null && v.getNimi().equalsIgnoreCase(väljundVeeruNimi)){
                //System.out.println(v.toString());
                textiAla.setText(v.toString());
                break;
            }
        }

    }catch (NullPointerException e){
            //Väljastab vea teate punaselt rippmenüü alla.
            System.out.println(e.getMessage());
            viga2.setTextFill(Color.RED);
            viga2.setText(e.getMessage());

        }
    }
    public void openFile(){
        //Meetod CSV faili avamiseks.
        //Kui vajutatakse nuppu "Ava loodud CSV fail".
        String filePath = "metadata.csv";
        try {
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void info(){
        //Aken programmi info kohta.
        Stage thirdStage = new Stage(); // Loo uus lava
        VBox root = new VBox(); //uus juur.
        //Väljastatav info tekst.
        String tekst = "Anna programmile ette enda SQL fail, näiteks SELECT.sql\n" +
                "Kirjelda kas tahad ühte kindlat tagastusrida või kõiki.\n" +
                "Programm kirjutab nõutud väljendi metadata.csv faili töökausta \n" +
                "vastavalt struktuurile VäljundVeerg, Sisendtabel,Sisendveerg,Failinimi";

        Label infoTekst = new Label(tekst);
        Button exit = new Button("Sulge"); //Nupp info akna sulgemiseks
        exit.setOnAction(e -> thirdStage.close()); //Nuppu vajutamisel sulgeb aken.
        root.getChildren().addAll(infoTekst,exit);
        Scene scene = new Scene(root, 500, 200); //Aken3 suuurus.
        thirdStage.setScene(scene);
        thirdStage.setTitle("Info");
        thirdStage.setResizable(false); //Akna suurust ei sa muuta.

        thirdStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}



    
