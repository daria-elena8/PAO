package Persoana;
import Angajati.AsistentMedical;
import Angajati.Medic;
import Angajati.PersonalSecuritate;
import Angajati.Receptionist;
import Specializare.Specializare;

import java.io.*;
import java.util.Scanner;

public class Angajat extends Persoana {

    private static int idCounter = 0;
    protected int idAngajat;
    protected String dataAngajarii;
    protected double salariu;
    private int ore_saptamana;

    public Angajat() {}
    public Angajat(String nume, String prenume, String dataNasterii, String adresa, String telefon, String dataAngajarii, double salariu, int ore_saptamana) {
        super(nume, prenume, dataNasterii, adresa, telefon);
        this.idAngajat = ++idCounter;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
        this.ore_saptamana = ore_saptamana;
    }

    public  Angajat(String[] v){
        super(v[2],v[3],v[4],v[5],v[6]);
        this.idAngajat = ++idCounter;
        this.dataAngajarii = v[7];
        try{
            this.salariu = Double.parseDouble(v[8]);
            this.ore_saptamana = Integer.parseInt(v[9]);
        }catch (NumberFormatException e){
            System.out.println("Eroare la convertirea valorilor pentru salariu sau ore_saptamana: " + e.getMessage());
        }

    }


    public static Angajat readAngajat(String linie) {
        try {
            String[] valori = linie.split("\\s+");

            //System.out.println(valori[0]);
            if (valori.length < 10) {
                throw new IOException("Nu sunt suficiente valori pentru a crea un angajat!");
            }
            switch (valori[1]){
                case "A":
                    return new AsistentMedical(valori);
                case "M":
                    return new Medic(valori);
                    //break;
                case "S":
                    return new PersonalSecuritate(valori);
                    //break;
                case "R":
                    return new Receptionist(valori);
                    //break;
            }
        } catch (IOException e) {
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
        return null;
    }




    /*
    public static Angajat readAngajat(String numeF) throws IOException {
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

            if (valori.length < 7){
                throw new IOException("Nu sunt suficiente valori pentru a crea o persoana!");
            }
            String nume = valori[0];
            String prenume = valori[1];
            String dataNasterii = valori[2];
            String telefon = valori[3];
            String adresa = valori[4];
            String data_angajarii = valori[5];
            double salariu = double(valori[6]);
            int ore_sapt = int(valori[7]);
            Angajat angajat = new Angajat(valori);
            return angajat;

        }
        catch (IOException e){
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
    };

    */

    public int getId(){ return idAngajat;}
    public int getIdAngajat() {
        return idAngajat;
    }

    protected int getIdCounter(){
        return idCounter;
    }
    protected void incIdCounter(){
        idCounter++;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(String dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }


    public int getOre_saptamana() {
        return ore_saptamana;
    }

    public void setOre_saptamana(int ore_saptamana) {
        this.ore_saptamana = ore_saptamana;
    }



    @Override
    public void afiseaza(){
        System.out.println("\nDetalii Personale Angajat: ");
        super.afiseaza();
        System.out.println("\nDetalii Profesionale Angajat: " + "\nSalariu: " + this.getSalariu()
                + "\tLucreaza: " + getOre_saptamana() + " ore/saptamana." );
    }

    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("\nDetalii Personale Angajat: \n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();
            writer.write("\nDetalii Profesionale Angajat: " + "\nSalariu: " + this.getSalariu()
                    + "\tLucreaza: " + getOre_saptamana() + " ore/saptamana.\n");
            writer.flush();


        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

}




