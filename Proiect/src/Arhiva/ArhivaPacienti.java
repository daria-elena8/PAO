package Arhiva;
import Persoana.Pacient;

import java.util.List;

public class ArhivaPacienti {

    public static List<Pacient> inregistrari;

    public void adaugaInregistrare(Pacient pacient){
        inregistrari.add(pacient);
    };
    public void afiseazaIstoric(){
        for(Pacient pacient : inregistrari){
            pacient.afiseaza();
        }
    };


}
