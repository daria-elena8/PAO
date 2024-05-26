import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaPacienti;
import servicii.PersoanaService;
import Persoana.*;

import java.io.IOException;

import static Persoana.ReadPersoana.readPersoanaFromFile;

public class Main {
    public static void main(String[] args) throws IOException {

        //Pacient pacient1 = new Pacient("Andrei", "Andreescu", "07/02/2002", "21 FirstStreet", "0712345678");

        //pacient1.afiseaza();


        ArhivaPacienti pacienti = new ArhivaPacienti();
        ArhivaAngajati angajati = new ArhivaAngajati();
        String fileName = "D:\\Java\\PAO\\Proiect\\src\\date_intrare.txt";
        readPersoanaFromFile(pacienti, angajati, fileName);

       pacienti.afiseazaIstoric();
       angajati.afiseazaIstoric();
        String writeFile = "D:\\Java\\PAO\\Proiect\\src\\date_iesire.txt";

        pacienti.writeInFile(writeFile);
        angajati.writeInFile(writeFile);

    }
}