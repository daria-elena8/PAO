package Persoana;
import Specializare.Specializare;

public class Angajat extends Persoana{

    private static int idAng = 0;
    private Specializare specializare;
    private int salariu;
    private int ore_saptamana;

    Angajat(String nume, String prenume, String data, String adresa, String telefon, Specializare specializare, int salariu, int ore){
        super(nume, prenume, data, adresa, telefon);
        this.specializare = specializare;
        this.salariu = salariu;
        this.ore_saptamana = ore;
        idAng++;
    }

    public int getHowMany(){
        return idAng;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    public int getSalariu() {
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
        System.out.println("Angajatul " + this.getHowMany() + ": " + this.getNume() + " " + this.getPrenume()
                + "\tSpecializare: " + this.getSpecializare() + "\tSalariu: " + this.getSalariu()
                + "\tLucreaza: " + getOre_saptamana() + " ore/saptamana" );
    }


}
