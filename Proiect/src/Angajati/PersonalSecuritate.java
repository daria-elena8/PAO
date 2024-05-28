package Angajati;
import Persoana.Angajat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonalSecuritate extends Angajat {
    private String certificatSecuritate;

    public PersonalSecuritate() {}
    public PersonalSecuritate(String nume, String prenume, String dataNasterii, String adresa, String telefon, String dataAngajarii, double salariu, int ore_saptamana, String certificatSecuritate) {
        super(nume, prenume, dataNasterii, adresa, telefon, dataAngajarii, salariu,ore_saptamana);
        this.certificatSecuritate = certificatSecuritate;
    }
    public  PersonalSecuritate(String[] v){
        super(v);
        this.certificatSecuritate = v[10];
    }
    public PersonalSecuritate(PersonalSecuritate p){
        super(p);
        this.certificatSecuritate = p.certificatSecuritate;
    }

    public String isCertificatSecuritate() {
        return certificatSecuritate;
    }

    public void setCertificatSecuritate(String certificatSecuritate) {
        this.certificatSecuritate = certificatSecuritate;
    }

    @Override
    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Post:\t Personal Securitate");
        System.out.println("Certificat securitate : " + isCertificatSecuritate() + "\n");
        super.afiseaza();
    }

    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("Post:\t Personal Securitate\n");
            writer.write("Certificat securitate : " + isCertificatSecuritate() + "\n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

}
