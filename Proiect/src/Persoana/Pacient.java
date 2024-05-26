package Persoana;

import Fisa_Medicala.Diagnostic;
import Fisa_Medicala.FisaMedicala;
import Specializare.Specializare;


public class Pacient extends Persoana {

    public Pacient() {}
    public Pacient(String nume, String prenume, String dataNasterii, String adresa, String telefon) {
        super(nume, prenume, dataNasterii, adresa, telefon);
    }

    @Override
    public void afiseaza() {
        System.out.println("Detalii Personale Pacient:");
        super.afiseaza();

    }
}


