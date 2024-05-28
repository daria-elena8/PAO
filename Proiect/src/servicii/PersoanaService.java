package servicii;

import Arhiva.ArhivaPacienti;
import Persoana.Persoana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PersoanaService<T extends Identificator> {

    protected List<T> persoane;

    public PersoanaService() {
        this.persoane = new ArrayList<>();
    }

    public void adaugaInregistrare(T persoana) {
        if (persoana != null) {
            persoane.add(persoana);
        } else {
            System.out.println("Persoana este null și nu a fost adăugată în listă.");
        }
    }

    public void adaugaInregistrari(List<T> persoane){
        for (T persoana : persoane) {
            if (persoana != null) {
                this.persoane.add(persoana);
            }
        }
    }
    public List<T> returneazaIstoric() {
        return persoane;
    }

    public void afiseazaIstoric() {
    }

//    public void writeInFile(String file) {
//    }
        public T findPersoanaDupaId(int id) {
        for (T persoana : persoane) {
            if (persoana.getId() == id) {
                return persoana;
            }
        }
        return null;
    }
    public void stergeInregistrare(Persoana persoana) {
        persoane.remove(persoana);
    }

//    public void sorteazaDupaId() {
//        Collections.sort(persoane, Comparator.comparingInt(Identificator::getId));
//    }
//    public void sorteazaDupaIdDescrescator() {
//        Collections.sort(persoane, (o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
//    }


}
