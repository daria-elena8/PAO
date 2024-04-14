package domain;

import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaPacienti;
public class Spital {

    private static String nume_spital;
    private static int numar_angajati = 0;
    private static int numar_cabinete;
    private static int numar_laboratoare;
    private ArhivaAngajati angajati;
    private ArhivaPacienti pacienti;

    public Spital(String nume_spital, int numar_angajati, int numar_cabinete, int numar_laboratoare) {
        this.nume_spital = nume_spital;
        this.numar_angajati = numar_angajati;
        this.numar_cabinete = numar_cabinete;
        this.numar_laboratoare = numar_laboratoare;

    }

    public static String getNume_spital() {
        return nume_spital;
    }

    public static void setNume_spital(String nume_spital) {
        Spital.nume_spital = nume_spital;
    }

    public static int getNumar_angajati() {
        return numar_angajati;
    }

    public static void setNumar_angajati(int numar_angajati) {
        Spital.numar_angajati = numar_angajati;
    }

    public static int getNumar_cabinete() {
        return numar_cabinete;
    }

    public static void setNumar_cabinete(int numar_cabinete) {
        Spital.numar_cabinete = numar_cabinete;
    }

    public static int getNumar_laboratoare() {
        return numar_laboratoare;
    }

    public static void setNumar_laboratoare(int numar_laboratoare) {
        Spital.numar_laboratoare = numar_laboratoare;
    }







}
