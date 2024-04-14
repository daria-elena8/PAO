package Fisa_Medicala;

import Persoana.Pacient;

import java.util.List;

public class FisaMedicala {

    static int id = 0;

    int nrFisa;
    Pacient pacient;

    List<Diagnostic> diagnostice;

    FisaMedicala(Pacient pacient, List<Diagnostic> diagnostice){
        this.nrFisa = id;
        this.pacient = pacient;
        this.diagnostice = diagnostice;
    }

    FisaMedicala(FisaMedicala fisaMedicala){
        this.pacient = fisaMedicala.getPacient();
        this.diagnostice = fisaMedicala.diagnostice;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public List<Diagnostic> getDiagnostice() {
        return diagnostice;
    }

    public void setDiagnostice(List<Diagnostic> diagnostice) {
        this.diagnostice = diagnostice;
    }

    protected void afiseazadiagnostice(){
        for(Diagnostic d : diagnostice){
            System.out.println(d + ", ");
        }
    }

    public void afiseaza(){
        System.out.print("\tFisa medicala " + this.nrFisa + ":\n");
        this.pacient.afiseaza();
        afiseazadiagnostice();
    }



}
