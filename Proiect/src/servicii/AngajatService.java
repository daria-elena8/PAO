package servicii;
import Persoana.Angajat;
import Angajati.*;

import java.util.ArrayList;
import java.util.List;
public class AngajatService {


    private List<Angajat> angajati;

    public AngajatService() {
        this.angajati = new ArrayList<>();
    }

    public void adaugaAngajat(Angajat angajat) {
        angajati.add(angajat);
    }

    public List<Angajat> obtineTotiAngajatii() {
        return angajati;
    }

    public Angajat gasesteAngajatDupaId(int id) {
        for (Angajat angajat : angajati) {
            if (angajat.getIdAngajat() == id) {
                return angajat;
            }
        }
        return null;
    }

    // Șterge un angajat
    public void stergeAngajat(Angajat angajat) {
        angajati.remove(angajat);
    }
}
