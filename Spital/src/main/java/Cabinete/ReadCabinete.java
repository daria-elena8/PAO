package Cabinete;
import Cabinete.Cabinet;
import Arhiva.ArhivaCabinete;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReadCabinete {
    public static void readCabineteFromFile(ArhivaCabinete cabinete, String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split("\\s+");
                if (valori.length >= 2) {

                    Cabinet cabinet = new Cabinet(valori);

                    cabinete.adaugaCabinet(cabinet);
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fișier: " + e.getMessage());
        }
    }
}
