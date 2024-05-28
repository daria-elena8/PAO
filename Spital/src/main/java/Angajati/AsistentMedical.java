package Angajati;
import Persoana.Angajat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AsistentMedical extends Angajat {
    private String medicAsociat;


    public AsistentMedical(String nume, String prenume, String dataNasterii, String adresa, String telefon, String dataAngajarii, double salariu,int ore_saptamana, String medicAsociat) {
        super(nume, prenume, dataNasterii, adresa, telefon, dataAngajarii, salariu, ore_saptamana);
        this.medicAsociat = medicAsociat;
    }

    public  AsistentMedical(String[] v){
        super(v);
        this.medicAsociat = v[10];
    }

    public AsistentMedical(AsistentMedical a) {
        super(a);
        this.medicAsociat = a.medicAsociat;
    }


    public AsistentMedical deepcopyAsistentMedical( AsistentMedical a){
        return new AsistentMedical(a);
    }
    public String getMedicAsociat(){
        return this.medicAsociat;
    }
    public void setMedicAsociat(String medicAsociat) {
        this.medicAsociat = medicAsociat;
    }

    @Override
    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Post:\t Asistent Medical");
        System.out.println("Medic Asociat: " + getMedicAsociat() + "\n");
        super.afiseaza();

    }

    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("Post:\t Asistent Medical\n");
            writer.write("Medic Asociat: " + getMedicAsociat() + "\n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}
