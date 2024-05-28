package Angajati;
import Persoana.Angajat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Receptionist extends Angajat {
    private String limbiStraine;

    public Receptionist(){}
    public Receptionist(String nume, String prenume, String dataNasterii, String adresa, String telefon,  String dataAngajarii, double salariu, int ore_saptamana, String limbiStraine) {
        super(nume, prenume, dataNasterii, adresa, telefon, dataAngajarii, salariu,ore_saptamana);
        this.limbiStraine = limbiStraine;
    }

    public  Receptionist(String[] v){
        super(v);
        this.limbiStraine = v[10];
    }
    public Receptionist(Receptionist r){
        super(r);
        this.limbiStraine = r.limbiStraine;
    }

    public String getLimbiStraine() {
        return limbiStraine;
    }

    public void addLimbiStraine(String limbiStraine) {
        this.limbiStraine = this.limbiStraine + limbiStraine;
    }

    public void setLimbiStraine(String limbiStraine) {
        this.limbiStraine = limbiStraine;
    }

    @Override
    public void afiseaza() {
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Post:\t Receptionist");
        System.out.println("Limbi Străine: " + getLimbiStraine() + "\n");
        super.afiseaza();
    }
    @Override
    public void writeInFile(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier, true))) {
            writer.write("Post:\t Receptionist\n");
            writer.write("Limbi Străine: " + getLimbiStraine() + "\n");
            writer.flush();
            super.writeInFile(numeFisier);
            writer.flush();
            writer.write("\n----------------------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}

