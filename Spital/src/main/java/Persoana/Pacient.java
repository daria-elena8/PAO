package Persoana;
import Persoana.Fisa_Medicala.FisaMedicala;
import Persoana.Persoana;

import java.io.*;
import java.util.Scanner;

public class Pacient extends Persoana {

    private int idCounter = 0;
    protected int id;
    public Pacient() {}
    public Pacient(String nume, String prenume, String dataNasterii, String adresa, String telefon) {
        super(nume, prenume, dataNasterii, adresa, telefon);

    }

    public  Pacient(String[] v){
        super(v[1],v[2],v[3],v[4],v[5]);
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public static Pacient readPacient(String linie) {
        try {
            String[] valori = linie.split("\\s+");

            if (valori.length < 6) {
                throw new IOException("Nu sunt suficiente valori pentru a crea o persoana!");
            }

            Pacient pacient = new Pacient(valori);
            return pacient;

        } catch (IOException e) {
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
    }



//    public static Pacient readPacient(String numeF) throws IOException {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader((numeF)));
//            String linie;
//            StringBuilder stringBuilder = new StringBuilder();
//
//            while((linie = reader.readLine()) != null){
//                stringBuilder.append(linie);
//                stringBuilder.append(" ");
//            }
//            String[] valori = stringBuilder.toString().split("\\s+");
//            reader.close();
//
//            if (valori.length < 5){
//                throw new IOException("Nu sunt suficiente valori pentru a crea o persoana!");
//            }
//
//            Pacient pacient = new Pacient(valori);
//            return pacient;
//
//        }
//        catch (IOException e){
//            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
//            return null;
//        }
//    };


    @Override
    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("\nDetalii Personale Pacient:");
        super.afiseaza();
        System.out.println("\n");

    }

    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");
            writer.write("\nDetalii Personale Pacient: \n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();

//            writer.write("\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }


}


