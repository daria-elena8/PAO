package Persoana.Fisa_Medicala;

import java.util.List;

public class FisaMedicala {

    private static int id = 0;

    private int nrFisa;
    private int idPacient;

    private List<Diagnostic> diagnostice;

    public FisaMedicala() {}

    public FisaMedicala(int pacient){
        this.nrFisa = ++id;
        this.idPacient = pacient;

    }
    public FisaMedicala(int pacient, List<Diagnostic> diagnostice){
        this.nrFisa = ++id;
        this.idPacient = pacient;
        this.diagnostice = diagnostice;
    }

    public FisaMedicala(FisaMedicala fisaMedicala){
        this.nrFisa = fisaMedicala.nrFisa;
        this.idPacient = fisaMedicala.getIdPacient();
        this.diagnostice = fisaMedicala.diagnostice;
    }

    public int getNrFisa(){
        return nrFisa;
    }

    public void setAutoId(){
        this.nrFisa = ++id;
    }
    public void setNrFisa(int nr){
        this.nrFisa = nr;
    }
    public int getId(){
        return this.nrFisa;
    }
    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int pacient) {
        this.idPacient = pacient;
    }

    public List<Diagnostic> getDiagnostice() {
        return this.diagnostice;
    }

    public void setDiagnostice(List<Diagnostic> diagnostice) {
        this.diagnostice = diagnostice;
    }

    public void addDiagnostic(Diagnostic diagnostic){
        diagnostice.add(diagnostic);
    }
    protected void afiseazadiagnostice(){
        System.out.print("Diagnostice:\n");
        for(Diagnostic d : diagnostice){
            System.out.println(d + ", ");
        }
    }

    public void afiseaza(){
        System.out.print("\tFisa medicala " + this.nrFisa + " \tidPacient: " + this.getIdPacient() );
        afiseazadiagnostice();
    }



}
