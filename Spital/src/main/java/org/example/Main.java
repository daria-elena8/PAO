package org.example;
import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaPacienti;
import Persoana.Fisa_Medicala.FisaMedicala;
import Persoana.*;
import Database.DAO.*;
import java.io.IOException;
import java.util.Scanner;

import servicii.Audit;

import static Persoana.ReadPersoana.readPersoanaFromFile;

public class Main {
    public static void main(String[] args) throws IOException {

            ArhivaPacienti pacienti = new ArhivaPacienti();
            ArhivaAngajati angajati = new ArhivaAngajati();
            String fileName = "D:\\Java\\PAO\\Spital\\src\\main\\java\\date_intrare.txt";
            readPersoanaFromFile(pacienti, angajati, fileName);


        Audit audit = new Audit();
        audit.logAction("Inserare Pacient");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMeniu:");
                System.out.println("1. Adaugă pacient");
                System.out.println("2. Adaugă angajat");
                System.out.println("3. Șterge pacient");
                System.out.println("4. Șterge angajat");
                System.out.println("5. Afișează toți pacienții");
                System.out.println("6. Afișează toți angajații");
                System.out.println("7. Ieșire");

                System.out.print("Alege opțiunea: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumă newline

                switch (option) {
                    case 1:
                        // Adaugă pacient
                        break;
                    case 2:
                        // Adaugă angajat
                        break;
                    case 3:
                        // Șterge pacient
                        break;
                    case 4:
                        // Șterge angajat
                        break;
                    case 5:
                        // Afișează toți pacienții
                        pacienti.afiseazaIstoric();
                        break;
                    case 6:
                        // Afișează toți angajații
                        angajati.afiseazaIstoric();
                        break;
                    case 7:
                        // Ieșire din aplicație
                        System.out.println("La revedere!");
                        return;
                    default:
                        System.out.println("Opțiune invalidă! Te rog să alegi o opțiune validă.");
                }
            }


//
//
//        // Inițializăm DAO-urile
//        PacientDAO pacientDAO = new PacientDAO();
//        FisaMedicalaDAO fisaMedicalaDAO = new FisaMedicalaDAO();
//
//        // Cream un pacient nou
//        Pacient pacient = new Pacient();
//        pacient.setNume("Popescu");
//        pacient.setPrenume("Ion");
//        pacient.setDataNasterii("01.01.1980");
//        pacient.setTelefon("0123456789");
//        pacient.setAdresa("Str. Exemplu, Nr. 1");
//
//        // Cream o fișă medicală nouă pentru acest pacient
//        FisaMedicala fisaMedicala = new FisaMedicala();
//        fisaMedicala.setDiagnostice("Diagnostic 1, Diagnostic 2");
//
//        // Salvăm fișa medicală și pacientul
//        pacientDAO.createWithFisa(pacient, fisaMedicala);
//
//        // Citim pacientul și fișa medicală pentru verificare
//        Pacient pacientCitit = pacientDAO.read(pacient.getId());
//        Persoana.Fisa_Medicala.FisaMedicala fisaCitita = fisaMedicalaDAO.read(fisaMedicala.getId());
//
//        // Afișăm datele citite
//        System.out.println("Pacient:");
//        System.out.println("ID: " + pacientCitit.getId());
//        System.out.println("Nume: " + pacientCitit.getNume());
//        System.out.println("Prenume: " + pacientCitit.getPrenume());
//        System.out.println("Data Nașterii: " + pacientCitit.getDataNasterii());
//        System.out.println("Telefon: " + pacientCitit.getTelefon());
//        System.out.println("Adresă: " + pacientCitit.getAdresa());
//
//        System.out.println("\nFișă Medicală:");
//        System.out.println("ID: " + fisaCitita.getId());
//        System.out.println("Diagnostice: " + fisaCitita.getDiagnostice());



    }
}