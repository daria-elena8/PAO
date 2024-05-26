package Angajati;
import Persoana.Angajat;
//package Persoana.Angajat;
import Specializare.Specializare;
public class Medic extends Angajat {
    private Specializare specializare;

    public Medic(){}
    public Medic(String nume, String prenume, String dataNasterii, String adresa, String telefon, String idAngajat, String dataAngajarii, double salariu, Specializare specializare) {
        super(nume, prenume, dataNasterii, adresa, telefon, idAngajat, dataAngajarii, salariu);
        this.specializare = specializare;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    @Override
    public void afiseaza() {
        super.afiseaza();
        System.out.println("Specializare: " + getSpecializare() + "\n");
    }
}
