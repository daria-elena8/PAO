package Angajati;
import Persoana.Angajat;
public class PersonalSecuritate extends Angajat {
    private boolean certificatSecuritate;

    public PersonalSecuritate() {}
    public PersonalSecuritate(String nume, String prenume, String dataNasterii, String adresa, String telefon, String idAngajat, String dataAngajarii, double salariu, boolean certificatSecuritate) {
        super(nume, prenume, dataNasterii, adresa, telefon, idAngajat, dataAngajarii, salariu);
        this.certificatSecuritate = certificatSecuritate;
    }

    public boolean isCertificatSecuritate() {
        return certificatSecuritate;
    }

    public void setCertificatSecuritate(boolean certificatSecuritate) {
        this.certificatSecuritate = certificatSecuritate;
    }

    @Override
    public void afiseaza() {
        super.afiseaza();
        System.out.println("Certificat securitate : " + (isCertificatSecuritate() ? "Da" : "No") + "\n");
    }
}
