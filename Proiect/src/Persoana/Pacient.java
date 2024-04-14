package Persoana;

import Fisa_Medicala.FisaMedicala;
import Specializare.Specializare;

public class Pacient extends Persoana{



    private int id = 0;
    public Persoana persoana;


    public Pacient(String nume, String prenume, String data, String adresa, String telefon){
        super(nume, prenume, data, adresa, telefon);
        id++;
    }

    public int getHowMany(){
       return id;
    }

    @Override
    public void afiseaza(){
        System.out.print("Pacientul " + this.getHowMany() + ": " );
        super.afiseaza();
    }
}
