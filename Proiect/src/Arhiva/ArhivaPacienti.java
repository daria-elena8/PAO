package Arhiva;


import Persoana.Angajat;
import Persoana.Pacient;
import servicii.PersoanaService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
}
