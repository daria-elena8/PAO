package Arhiva;
import servicii.*;

import Persoana.Angajat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class ArhivaAngajati extends PersoanaService<Angajat>{

    public ArhivaAngajati(){}

    @Override
    public void afiseazaIstoric() {
        for (Angajat a : this.persoane){
            a.afiseaza();
        }
    }

    public void writeInFile(String file) {
        for (Angajat a : this.persoane) {
            a.writeInFile(file);
        }
    }
}
