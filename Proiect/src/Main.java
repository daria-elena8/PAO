import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaCabinete;
import Arhiva.ArhivaPacienti;
import servicii.PersoanaService;
import Persoana.*;
import Cabinete.*;
import Persoana.Fisa_Medicala.*;
import Database.DAO.*;
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

//        String cabineteInFile = "D:\\Java\\PAO\\Proiect\\src\\date_intrare_cabinete.txt";
//        ArhivaCabinete cabinete = new ArhivaCabinete();
//        readCabineteFromFile(cabinete, cabineteInFile);
//        cabinete.afiseazaCabinete();

        // Inițializăm DAO-urile
        PacientDAO pacientDAO = new PacientDAO();
        FisaMedicalaDAO fisaMedicalaDAO = new FisaMedicalaDAO();

        // Cream un pacient nou
        Pacient pacient = new Pacient();
        pacient.setNume("Popescu");
        pacient.setPrenume("Ion");
        pacient.setDataNasterii("01.01.1980");
        pacient.setTelefon("0123456789");
        pacient.setAdresa("Str. Exemplu, Nr. 1");

        // Cream o fișă medicală nouă pentru acest pacient
        FisaMedicala fisaMedicala = new FisaMedicala();
        fisaMedicala.setDiagnostice("Diagnostic 1, Diagnostic 2");

        // Salvăm fișa medicală și pacientul
        pacientDAO.createWithFisa(pacient, fisaMedicala);

        // Citim pacientul și fișa medicală pentru verificare
        Pacient pacientCitit = pacientDAO.read(pacient.getId());
        FisaMedicala fisaCitita = fisaMedicalaDAO.read(fisaMedicala.getId());

        // Afișăm datele citite
        System.out.println("Pacient:");
        System.out.println("ID: " + pacientCitit.getId());
        System.out.println("Nume: " + pacientCitit.getNume());
        System.out.println("Prenume: " + pacientCitit.getPrenume());
        System.out.println("Data Nașterii: " + pacientCitit.getDataNasterii());
        System.out.println("Telefon: " + pacientCitit.getTelefon());
        System.out.println("Adresă: " + pacientCitit.getAdresa());

        System.out.println("\nFișă Medicală:");
        System.out.println("ID: " + fisaCitita.getId());
        System.out.println("Diagnostice: " + fisaCitita.getDiagnostice());



    }
}