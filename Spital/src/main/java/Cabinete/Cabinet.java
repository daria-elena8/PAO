package Cabinete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cabinet {
    protected static int counterCabinete = 0;
    public int idCabinet;
    public int etaj;
    public String orar;

    public int idMedic;
    public int idAsistent;


    public Cabinet(){}
    public Cabinet(int etaj, String orar){
        this.idCabinet = ++counterCabinete;
        this.etaj = etaj;
        this.orar = orar;

    }
    public Cabinet(int etaj, String orar, int idMedic, int idAsistent){
        this.idCabinet = ++counterCabinete;
        this.etaj = etaj;
        this.orar = orar;
        this.idMedic = idMedic;
        this.idAsistent = idAsistent;

    }
    public static Cabinet matchConstructor(String[] v){
        if(v.length>2){
            return new Cabinet(Integer.parseInt(v[0]),v[1],Integer.parseInt(v[2]), Integer.parseInt(v[3]));
        }
        else {
            return new Cabinet(Integer.parseInt(v[0]),v[1]);
        }
    }

    public void setAutoId(){
        this.idCabinet = ++counterCabinete;
    }
    public static int getCounterCabinete() {
        return counterCabinete;
    }

    public static void setCounterCabinete(int counterCabinete) {
        Cabinet.counterCabinete = counterCabinete;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public int getIdAsistent() {
        return idAsistent;
    }

    public void setIdAsistent(int idAsistent) {
        this.idAsistent = idAsistent;
    }

    public int getIdCabinet() {
        return idCabinet;
    }

    public void setIdCabinet(int idCabinet) {
        this.idCabinet = idCabinet;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public String getOrar() {
        return orar;
    }

    public void setOrar(String orar) {
        this.orar = orar;
    }

    public static Cabinet readCabinet(String linie) {
        try {
            String[] valori = linie.split("\\s+");
            if (valori.length < 2) {
                throw new IOException("Nu sunt suficiente valori pentru a crea un angajat!");
            }
            return matchConstructor(valori);
        } catch (IOException e) {
            System.out.println("Modificati sau alegeti un fisier avand informatii in formatul corespunzator\nEroare: " + e.getMessage());
            return null;
        }
    }

    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Id Cabinet:\t" + getIdCabinet() + "\tEtaj:\t" + getEtaj() +"\tOrar:\t" + getOrar() +  "\n");
    }

    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("Id Cabinet:\t" + getIdCabinet() + "\tEtaj:\t" + getEtaj() +"\tOrar:\t" + getOrar() +  "\n");
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }


}
