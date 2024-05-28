package Arhiva;


import Persoana.Angajat;
import Persoana.Pacient;
import servicii.Identificator;
import servicii.PersoanaService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArhivaPacienti extends PersoanaService<Pacient> {
    public ArhivaPacienti(){}
    @Override
    public void afiseazaIstoric() {
        for (Pacient p : this.persoane){
            p.afiseaza();
        }
    }
//    @Override
//    public void adaugaInregistrari(List<Pacient> persoane){
//        for (Pacient persoana : persoane) {
//            if (persoana != null) {
//                this.persoane.add(persoana);
//            }
//        }
//    }
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

    public ArhivaPacienti sorteazaDupaId() {
        ArhivaPacienti arhivaSortata = new ArhivaPacienti();
        arhivaSortata.adaugaInregistrari(persoane);
        Collections.sort(arhivaSortata.persoane, Comparator.comparingInt(Identificator::getId));
        return arhivaSortata;
    }

    public ArhivaPacienti sorteazaDupaIdDescrescator() {
        Collections.sort(persoane, (o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
        return this;
    }



}
