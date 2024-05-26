package Persoana;
import Specializare.Specializare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Angajat extends Persoana {
    protected static int idAngajat;
    protected String dataAngajarii;
    protected double salariu;
    private int ore_saptamana;

    public Angajat() {}
    public Angajat(String nume, String prenume, String dataNasterii, String adresa, String telefon, String dataAngajarii, double salariu, int ore_saptamana) {
        super(nume, prenume, dataNasterii, adresa, telefon);
        this.idAngajat = ++idAngajat;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
        this.ore_saptamana = ore_saptamana;
    }

    public  Angajat(String[] v){
        super(v[0],v[1],v[2],v[3],v[4]);
        this.idAngajat = ++idAngajat;
        this.dataAngajarii = v[5];
        this.salariu = Double.parseDouble(v[6]);
        this.ore_saptamana = Integer.parseInt(v[7]);
    }


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
            /*String nume = valori[0];
            String prenume = valori[1];
            String dataNasterii = valori[2];
            String telefon = valori[3];
            String adresa = valori[4];
            String data_angajarii = valori[5];
            double salariu = double(valori[6]);
            int ore_sapt = int(valori[7]);*/
            Angajat angajat = new Angajat(valori);
            return angajat;

        }
        catch (IOException e){
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
    };

    public int getId(){ return idAngajat;}
    public int getIdAngajat() {
        return idAngajat;
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
        System.out.println("Detalii Personale Angajat: ");
        super.afiseaza();
        System.out.println("Detalii Profesionale Angajat: " + "\tSalariu: " + this.getSalariu()
                + "\tLucreaza: " + getOre_saptamana() + " ore/saptamana" );
    }

}




