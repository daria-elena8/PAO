import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaCabinete;
import Arhiva.ArhivaPacienti;
import servicii.PersoanaService;
import Persoana.*;
import Cabinete.*;

import java.io.IOException;

import static Cabinete.ReadCabinete.readCabineteFromFile;
import static Persoana.ReadPersoana.readPersoanaFromFile;

public class Main {
    public static void main(String[] args) throws IOException {

        //Pacient pacient1 = new Pacient("Andrei", "Andreescu", "07/02/2002", "21 FirstStreet", "0712345678");

        //pacient1.afiseaza();


        ArhivaPacienti pacienti = new ArhivaPacienti();
        ArhivaAngajati angajati = new ArhivaAngajati();
        String fileName = "D:\\Java\\PAO\\Proiect\\src\\date_intrare.txt";
        readPersoanaFromFile(pacienti, angajati, fileName);


        String writeFile = "D:\\Java\\PAO\\Proiect\\src\\date_iesire.txt";

        //pacienti.writeInFile(writeFile);
        //angajati.writeInFile(writeFile);
        ArhivaPacienti pac2 = new ArhivaPacienti();
        //pac2.adaugaInregistrari(pacienti.sorteazaDupaIdDescrescator());
        //pac2.afiseazaIstoric();

        String cabineteInFile = "D:\\Java\\PAO\\Proiect\\src\\date_intrare_cabinete.txt";
        ArhivaCabinete cabinete = new ArhivaCabinete();
        readCabineteFromFile(cabinete, cabineteInFile);
        cabinete.afiseazaCabinete();

    }
}