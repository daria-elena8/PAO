package Persoana;
import Persoana.Fisa_Medicala.FisaMedicala;
import Persoana.Persoana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pacient extends Persoana {

    protected Pacient() {}
    protected Pacient(String nume, String prenume, String dataNasterii, String adresa, String telefon) {
        super(nume, prenume, dataNasterii, adresa, telefon);
    }

    public  Pacient(String[] v){
        super(v[0],v[1],v[2],v[3],v[4]);
    }


    public int getId(){
        return 0;
    }

    public static Pacient readPacient(String numeF) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader((numeF)));
            String linie;
            StringBuilder stringBuilder = new StringBuilder();

            while((linie = reader.readLine()) != null){
                stringBuilder.append(linie);
                stringBuilder.append(" ");
            }
            String[] valori = stringBuilder.toString().split("\\s+");
            reader.close();

            if (valori.length < 5){
                throw new IOException("Nu sunt suficiente valori pentru a crea o persoana!");
            }
//            String nume = valori[0];
//            String prenume = valori[1];
//            String dataNasterii = valori[2];
//            String telefon = valori[3];
//            String adresa = valori[4];
            Pacient pacient = new Pacient(valori);
            return pacient;

        }
        catch (IOException e){
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
    };


    @Override
    public void afiseaza() {
        System.out.println("Detalii Personale Pacient:");
        super.afiseaza();

    }
}


