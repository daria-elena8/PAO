package Arhiva;

import Cabinete.Cabinet;

import java.util.ArrayList;
import java.util.List;

public class ArhivaCabinete {
    private List<Cabinet> cabinete;

    public ArhivaCabinete() {
        this.cabinete = new ArrayList<>();
    }

    public void adaugaCabinet(Cabinet cabinet) {
        if (cabinet != null) {
            cabinete.add(cabinet);
        } else {
            System.out.println("Cabinetul este null și nu a fost adăugat în listă.");
        }
    }

    public void afiseazaCabinete() {
        for (Cabinet cabinet : cabinete) {
            cabinet.afiseaza();
        }
    }

    public void writeInFile(String file) {
        for (Cabinet cabinet : cabinete) {
            cabinet.writeInFile(file);
        }
    }

    public List<Cabinet> getCabinete() {
        return cabinete;
    }

    public void setCabinete(List<Cabinet> cabinete) {
        this.cabinete = cabinete;
    }
}
