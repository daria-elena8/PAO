package Persoana.Fisa_Medicala;

import Persoana.Pacient;
import java.util.List;

public class FisaMedicala extends Pacient {

    private static int id = 0;

    private int nrFisa;
    private Pacient pacient;

    private String diagnostice;

    public FisaMedicala() {}
    public FisaMedicala(Pacient pacient, String diagnostice){
        this.nrFisa = ++id;
        this.pacient = pacient;
        this.diagnostice = diagnostice;
    }

    public FisaMedicala(FisaMedicala fisaMedicala){
        this.nrFisa = fisaMedicala.nrFisa;
        this.pacient = fisaMedicala.getPacient();
        this.diagnostice = fisaMedicala.diagnostice;
    }

    public int getNrFisa(){
        return nrFisa;
    }

    @Override
    public int getId(){
        return this.nrFisa;
    }
    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getDiagnostice() {
        return diagnostice;
    }

    public void setDiagnostice(String diagnostice) {
        this.diagnostice = diagnostice;
    }

    public void addDiagnostic(String diagnostic){
        diagnostice = diagnostice + diagnostic;
    }
    protected void afiseazadiagnostice(){
        System.out.println(this.diagnostice);
    }

    public void afiseaza(){
        System.out.print("\tFisa medicala " + this.nrFisa + ":\n");
        this.pacient.afiseaza();
        afiseazadiagnostice();
    }



}
