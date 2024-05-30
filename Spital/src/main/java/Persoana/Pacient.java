package Persoana;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pacient extends Persoana {

    private static int idCounter = 0;
    private int id;
    public Pacient() {}
    public Pacient(String nume, String prenume, String dataNasterii, String adresa, String telefon) {
        super(nume, prenume, dataNasterii, adresa, telefon);
        this.id = ++idCounter;
    }

    public  Pacient(String[] v){
        super(v[1],v[2],v[3],v[4],v[5]);
        this.id = ++idCounter;
    }

    public void setAutoId(){
        this.id = ++idCounter;
    }

    public int getId(){
        return id;
    }

    public void  setId(int id){
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


