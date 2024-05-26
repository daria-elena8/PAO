package servicii;

import Persoana.Persoana;

import java.util.ArrayList;
import java.util.List;
public abstract class PersoanaService<T extends Identificator> {

    protected List<T> persoane;

    public PersoanaService() {
        this.persoane = new ArrayList<>();
    }

    public void setPersoana(T persoana) {
        persoane.add(persoana);
    }
    public void setPersoane(List<T> persoane){
        this.persoane.addAll(persoane);
    }

    public List<T> getPersoane() {
        return persoane;
    }

    public T findPersoanaDupaId(int id) {
        for (T persoana : persoane) {
            if (persoana.getId() == id) {
                return persoana;
            }
        }
        return null;
    }
    public void deletePersoana(Persoana persoana) {
        persoane.remove(persoana);
    }
}
