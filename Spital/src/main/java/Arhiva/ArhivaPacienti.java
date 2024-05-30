package Arhiva;


import Persoana.Pacient;
import servicii.PersoanaService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class ArhivaPacienti extends PersoanaService<Pacient> {
    public ArhivaPacienti(){}
    @Override
    public void afiseazaIstoric() {
        for (Pacient p : this.persoane){
            p.afiseaza();
        }
    }

    public void writeInFile(String file){
        for (Pacient p: this.persoane){
            p.writeInFile(file);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (
                IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

    public void sorteazaDupaNume() {
        Collections.sort(this.persoane, new Comparator<Pacient>() {
            @Override
            public int compare(Pacient p1, Pacient p2) {
                return p1.getNume().compareTo(p2.getNume());
            }
        });
    }

    public void sorteazaDupaDataNasterii() {
        Collections.sort(this.persoane, new Comparator<Pacient>() {
            @Override
            public int compare(Pacient p1, Pacient p2) {
                return p1.getDataNasterii().compareTo(p2.getDataNasterii());
            }
        });
    }



}
