package Angajati;
import Persoana.Angajat;

public class AsistentMedical extends Angajat {
    private String medicAsociat;

    public AsistentMedical(){}
    public AsistentMedical(String nume, String prenume, String dataNasterii, String adresa, String telefon, String idAngajat, String dataAngajarii, double salariu, String medicAsociat) {
        super(nume, prenume, dataNasterii, adresa, telefon, idAngajat, dataAngajarii, salariu);
        this.medicAsociat = medicAsociat;
    }

    public String getMedicAsociat(){
        return this.medicAsociat;
    }
    public void setMedicAsociat(String medicAsociat) {
        this.medicAsociat = medicAsociat;
    }

    @Override
    public void afiseaza() {
        super.afiseaza();
        System.out.println("Medic Asociat: " + getMedicAsociat() + "\n");
    }
}
