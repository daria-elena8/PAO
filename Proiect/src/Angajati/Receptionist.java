package Angajati;
import Persoana.Angajat;
public class Receptionist extends Angajat {
    private String limbiStraine;

    public Receptionist(){}
    public Receptionist(String nume, String prenume, String dataNasterii, String adresa, String telefon, String idAngajat, String dataAngajarii, double salariu, String limbiStraine) {
        super(nume, prenume, dataNasterii, adresa, telefon, idAngajat, dataAngajarii, salariu);
        this.limbiStraine = limbiStraine;
    }

    public String getLimbiStraine() {
        return limbiStraine;
    }

    public void addLimbiStraine(String limbiStraine) {
        this.limbiStraine = this.limbiStraine + limbiStraine;
    }

    public void setLimbiStraine(String limbiStraine) {
        this.limbiStraine = limbiStraine;
    }

    @Override
    public void afiseaza() {
        System.out.println("Limbi Străine: " + getLimbiStraine() + "\n");
    }
}

