package Persoana;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import servicii.Identificator;

public abstract class Persoana implements Identificator {
    protected String nume;
    protected String prenume;
    protected String dataNasterii;
    protected String telefon;
    protected String adresa;

    public Persoana() {}
    public Persoana(String nume, String prenume, String dataNasterii, String adresa, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public Persoana( Persoana p){
        this.nume = p.nume;
        this.prenume = p.prenume;
        this.dataNasterii = p.dataNasterii;
        this.telefon = p.telefon;
        this.adresa = p.adresa;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void afiseaza(){
        System.out.print( getNume() + " " + getPrenume() + " \tTelefon: " + getTelefon()
                + " \tAdresa: " + getAdresa() + ".");
    }

    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.flush();
            writer.write( getNume() + " " + getPrenume() + "\tTelefon: " + getTelefon()
                    + "\tAdresa: " + getAdresa() + ".\n");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}
