package Persoana;

import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaPacienti;
import servicii.PersoanaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class ReadPersoana {


    public static void readPersoanaFromFile(ArhivaPacienti pacientService, ArhivaAngajati angajatService, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                if (linie.startsWith("A")) {
                    Angajat angajat = Angajat.readAngajat(linie);
                    if (angajat != null) {
                        angajatService.adaugaInregistrare(angajat);
                    }
                } else if (linie.startsWith("P")) {
                    Pacient pacient = Pacient.readPacient(linie);
                    if (pacient != null) {
                        pacientService.adaugaInregistrare(pacient);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fișier: " + e.getMessage());
        }
    }
}