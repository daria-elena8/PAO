package Arhiva;
import Persoana.Angajat;
import java.util.List;
public class ArhivaAngajati{

    public static List<Angajat> inregistrari;

    public void adaugaInregistrare(Angajat angajat){
        inregistrari.add(angajat);
    };
    public void afiseazaIstoric(){
        for(Angajat ang : inregistrari){
            ang.afiseaza();
        }
    };




}
