package Fisa_Medicala;

import Persoana.Pacient;

import java.util.List;

public class FisaMedicala {

    private static int id = 0;

    private int nrFisa;
    private Pacient pacient;

    private List<Diagnostic> diagnostice;

    public FisaMedicala() {}
    public FisaMedicala(Pacient pacient, List<Diagnostic> diagnostice){
        this.nrFisa = ++id;
        this.pacient = pacient;
        this.diagnostice = diagnostice;
    }

    public FisaMedicala(FisaMedicala fisaMedicala){
        this.pacient = fisaMedicala.getPacient();
        this.diagnostice = fisaMedicala.diagnostice;
    }

    public int getNrFisa(){
        return nrFisa;
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

    public void addDiagnostic(Diagnostic diagnostic){
        diagnostice.add(diagnostic);
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
