package Persoana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadPersoana {


    public static void readPersoana(String numeF)throws IOException{
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(numeF));
            int ch;
            ch = reader.read();
            if (ch == 'A')
                Angajat.readAngajat(numeF);
            else if (ch == 'P') {
                Pacient.readPacient(numeF);
            }
        } finally {
            if (reader != null)
                reader.close();
        }
    };

}
