package Persoana;
import Specializare.Specializare;

public class Angajat extends Persoana {
    protected int idAngajat;
    protected String dataAngajarii;
    protected double salariu;
    private int ore_saptamana;

    public Angajat() {}
    public Angajat(String nume, String prenume, String dataNasterii, String adresa, String telefon, int idAngajat, String dataAngajarii, double salariu) {
        super(nume, prenume, dataNasterii, adresa, telefon);
        this.idAngajat = idAngajat;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
    }
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




