package Angajati;
import Persoana.Angajat;
//package Persoana.Angajat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Medic extends Angajat {
    private String specializare;



//    public AsistentMedical(String nume, String prenume, String dataNasterii, String adresa, String telefon, String dataAngajarii, double salariu,int ore_saptamana, String medicAsociat) {
//        super(nume, prenume, dataNasterii, adresa, telefon, dataAngajarii, salariu, ore_saptamana);

    public Medic(String nume, String prenume, String dataNasterii, String adresa, String telefon,  String dataAngajarii, double salariu,int ore_saptamana, String specializare) {
        super(nume, prenume, dataNasterii, adresa, telefon, dataAngajarii, salariu, ore_saptamana);
        this.specializare = specializare;
    }

    public  Medic(String[] v){
        super(v);
        this.specializare = v[10];
    }

    public Medic (Medic m ){
        super(m);
        this.specializare = m.specializare;
    }

    public Medic deepcopyMedic(Medic m){
        return new Medic(m);
    }


    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Post:\t Medic\n" + "Specializare: " + getSpecializare() + "\n");
        super.afiseaza();
    }

    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("Post:\t Medic\n" + "Specializare: " + getSpecializare() + "\n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

}
