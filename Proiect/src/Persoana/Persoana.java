package Persoana;

public class Persoana {

    protected String Nume;
    protected String Prenume;
    protected String data_nasterii;
    protected String telefon;
    protected String adresa;

    Persoana(){}

    Persoana(String nume, String prenume, String data_nasterii, String adresa, String telefon){
        this.Nume = nume;
        this.Prenume = prenume;
        this.data_nasterii = data_nasterii;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public String getNume(){
        return this.Nume;
    }
    public void setNume(String nume){
        this.Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(String data_nasterii) {
        this.data_nasterii = data_nasterii;
    }


    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void afiseaza(){
        System.out.print( getNume() + " " + getPrenume() + " \tTelefon: " + getTelefon()
                + " \tAdresa: " + getAdresa() + ".");
    }

}
