package Arhiva;

import Cabinete.Cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
//    public void readFromFile(String file) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String linie;
//            while ((linie = reader.readLine()) != null) {
//                String[] valori = linie.split("\\s+");
//                if (valori.length >= 3) {
//                    int idCabinet = Integer.parseInt(valori[0]);
//                    String etaj = valori[1];
//                    String orar = valori[2];
//                    Cabinet cabinet = new Cabinet(etaj, orar);
//                    cabinet.setIdCabinet(idCabinet);
//                    cabinete.add(cabinet);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Eroare la citirea din fișier: " + e.getMessage());
//        }
//    }

    public List<Cabinet> getCabinete() {
        return cabinete;
    }

    public void setCabinete(List<Cabinet> cabinete) {
        this.cabinete = cabinete;
    }
}
