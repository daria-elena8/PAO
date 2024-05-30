package org.example;

import Arhiva.ArhivaAngajati;
import Arhiva.ArhivaCabinete;
import Arhiva.ArhivaPacienti;
import Cabinete.Cabinet;
import DAO.CabinetDAO;
import DAO.FisaMedicalaDAO;
import DAO.PacientDAO;
import Persoana.Fisa_Medicala.Diagnostic;
import Persoana.Fisa_Medicala.FisaMedicala;
import Persoana.Pacient;
import servicii.AuditService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Cabinete.ReadCabinete.readCabineteFromFile;
import static Persoana.ReadPersoana.readPersoanaFromFile;

public class Main {
    public static void main(String[] args) throws IOException {


        ArhivaPacienti arhivaPacienti = new ArhivaPacienti();
        ArhivaAngajati arhivaAngajati = new ArhivaAngajati();
        ArhivaCabinete arhivaCabinete = new ArhivaCabinete();
        String date_intrare_persoane = "D:\\Java\\PAO\\Spital\\src\\main\\java\\date_intrare.txt";
        String date_intrare_cabinete = "D:\\Java\\PAO\\Spital\\src\\main\\java\\date_intrare_cabinete.txt";
        String date_iesire = "D:\\Java\\PAO\\Spital\\src\\main\\java\\date_iesire.txt";

        PacientDAO pacientDAO = new PacientDAO();
        FisaMedicalaDAO fisaMedicalaDAO = new FisaMedicalaDAO();
        CabinetDAO cabinetDAO = new CabinetDAO();
        AuditService auditService = new AuditService("D:\\Java\\PAO\\Spital\\src\\main\\java\\Audit.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Meniu ---");
            System.out.println("1. Adauga Pacient");
            System.out.println("2. Adauga Fisa Medicala");
            System.out.println("3. Adauga Cabinet");
            System.out.println("4. Afiseaza Pacienti");
            System.out.println("5. Afiseaza Fise Medicale");
            System.out.println("6. Afiseaza Cabinete");
            System.out.println("7. Cauta Pacient dupa ID");
            System.out.println("8. Cauta Fisa Medicala dupa ID");
            System.out.println("9. Cauta Cabinet dupa ID");
            System.out.println("10. Sterge Pacient dupa ID");
            System.out.println("11. Sterge Fisa Medicala dupa ID");
            System.out.println("12. Sterge Cabinet dupa ID");
            System.out.println("13. Adauga Persoane din Fisier Intrare");
            System.out.println("14. Adauga Cabinet din Fisier Intrare");
            System.out.println("15. Iesire");
            System.out.print("Alege o optiune: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Pacient pacient = new Pacient();
                    pacient.setAutoId();
                    System.out.print("Introduceti numele: ");
                    pacient.setNume(scanner.nextLine());
                    System.out.print("Introduceti prenumele: ");
                    pacient.setPrenume(scanner.nextLine());
                    System.out.print("Introduceti data nasterii (YYYY-MM-DD): ");
                    pacient.setDataNasterii(scanner.nextLine());
                    System.out.print("Introduceti telefonul: ");
                    pacient.setTelefon(scanner.nextLine());
                    System.out.print("Introduceti adresa: ");
                    pacient.setAdresa(scanner.nextLine());
                    pacientDAO.create(pacient);
                    auditService.logAction("CREATE PACIENT");
                    break;
                case 2:
                    FisaMedicala fisa = new FisaMedicala();
                    System.out.print("Introduceti ID-ul pacientului: ");
                    fisa.setIdPacient(scanner.nextInt());
                    scanner.nextLine(); // Consuma newline
                    System.out.print("Introduceti diagnosticele (separate prin virgula): ");
                    String diagnosticeStr = scanner.nextLine();
                    List<Diagnostic> diagnostice = Arrays.stream(diagnosticeStr.split(","))
                            .map(Diagnostic::valueOf)
                            .collect(Collectors.toList());
                    fisa.setDiagnostice(diagnostice);
                    fisaMedicalaDAO.create(fisa);
                    auditService.logAction("CREATE FISA_MEDICALA");
                    break;
                case 3:
                    Cabinet cabinet = new Cabinet();
                    cabinet.setAutoId();
                    System.out.print("Introduceti etaj: ");
                    cabinet.setEtaj(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Introduceti orar: ");
                    cabinet.setOrar(scanner.nextLine());
                    System.out.print("Introduceti ID Medic: ");
                    cabinet.setIdMedic(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Introduceti ID Asistent: ");
                    cabinet.setIdAsistent(Integer.parseInt(scanner.nextLine()));
                    cabinetDAO.create(cabinet);
                    auditService.logAction("CREATE CABINET");
                    break;
                case 4:
                    List<Pacient> pacienti = pacientDAO.readAll();
                    pacienti.forEach(p -> System.out.println(p.getId() + ": " + p.getNume() + " " + p.getPrenume() + "\tData Nasterii: " +  p.getDataNasterii() + "\tTelefon: " + p.getTelefon() + "\tAdresa: " + p.getAdresa()));
                    auditService.logAction("SHOW_ALL PACIENT");
                    break;
                case 5:
                    List<FisaMedicala> fise = fisaMedicalaDAO.readAll();
                    fise.forEach(f -> {
                        System.out.println("ID Fisa: " + f.getId());
                        System.out.println("ID Pacient: " + f.getIdPacient());
                        System.out.println("Diagnostice: " + f.getDiagnostice());
                    });
                    auditService.logAction("SHOW_ALL FISA_MEDICALA");
                    break;
                case 6:
                    List<Cabinet> cabinete = cabinetDAO.readAll();
                    cabinete.forEach(Main::displayDetailsCabinet);
                    auditService.logAction("SHOW_ALL CABINETE");
                    break;
                case 7:
                    System.out.print("Introduceti ID-ul pacientului: ");
                    int idPacient = scanner.nextInt();
                    scanner.nextLine();
                    Pacient p = pacientDAO.read(idPacient);
                    if (p != null) {
                        System.out.println(p.getId() + ": " + p.getNume() + " " + p.getPrenume() + "\tData Nasterii: " +  p.getDataNasterii() + "\tTelefon: " + p.getTelefon() + "\tAdresa: " + p.getAdresa());
                    } else {
                        System.out.println("Pacientul nu a fost gasit!");
                    }
                    auditService.logAction("FIND PACIENT");
                    break;
                case 8:
                    System.out.print("Introduceti ID-ul fisei medicale: ");
                    int idFisa = scanner.nextInt();
                    scanner.nextLine(); //
                    FisaMedicala f = fisaMedicalaDAO.read(idFisa);
                    if (f != null) {
                        System.out.println("ID Fisa: " + f.getId());
                        System.out.println("ID Pacient: " + f.getIdPacient());
                        System.out.println("Diagnostice: " + f.getDiagnostice());
                    } else {
                        System.out.println("Fisa medicala nu a fost gasita!");
                    }
                    auditService.logAction("FIND FISA_MEDICALA");
                    break;
                case 9:

                    System.out.print("Introduceti ID-ul cabinetului: ");
                    int idCabinet = scanner.nextInt();
                    scanner.nextLine(); //
                    Cabinet c = cabinetDAO.read(idCabinet);
                    if (c != null) {
                        displayDetailsCabinet(c);
                    } else {
                        System.out.println("Fisa medicala nu a fost gasita!");
                    }
                    auditService.logAction("FIND CABINET");
                    break;
                case 10:
                    System.out.print("Introduceti ID-ul Pacientului: ");
                    int idPacientDel = scanner.nextInt();
                    scanner.nextLine();
                    pacientDAO.delete(idPacientDel);
                    auditService.logAction("DELETE PACIENT");
                    break;
                case 11:
                    System.out.print("Introduceti ID-ul fisei medicale: ");
                    int idFisaDel = scanner.nextInt();
                    scanner.nextLine();
                    fisaMedicalaDAO.delete(idFisaDel);
                    auditService.logAction("DELETE FISA_MEDICALA");
                    break;

                case 12:
                    System.out.print("Introduceti ID-ul cabinetului: ");
                    int idCabinetDel = scanner.nextInt();
                    scanner.nextLine();
                    cabinetDAO.delete(idCabinetDel);
                    auditService.logAction("DELETE CABINET");
                    break;
                case 13:
                    System.out.println("\t\tSe citeste din fisier...\n");
                    readPersoanaFromFile(arhivaPacienti, arhivaAngajati, date_intrare_persoane);
                    System.out.println("\t\tCitire Reusita!\n");
                    auditService.logAction("READ_PERSOANA_FROM_FILE");
                    break;
                case 14:
                    System.out.println("\t\tSe citeste din fisier...\n");
                    readCabineteFromFile(arhivaCabinete, date_intrare_cabinete);
                    System.out.println("\t\tCitire Reusita!\n");
                    auditService.logAction("READ_CABINETE_FROM_FILE");
                    break;

                case 15:
                    System.out.println("Se sorteaza Pacientii in functie de nume...\n");
                    arhivaPacienti.sorteazaDupaNume();
                    System.out.println("Sortare Finalizata cu Succes!");
                    auditService.logAction("SORT PACIENT BY NAME");
                    break;

                case 16:
                    System.out.println("Se sorteaza Pacientii in functie de data nasterii...\n");
                    arhivaPacienti.sorteazaDupaDataNasterii();
                    System.out.println("Sortare Finalizata cu Succes!");
                    auditService.logAction("SORT PACIENT BY BIRTH DATE");
                    break;
                case 17:
                    System.out.println("Iesire...");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (choice != 15);


    }

    protected static void displayDetailsCabinet(Cabinet c) {
        System.out.println("ID Cabinet: " + c.getIdCabinet());
        System.out.println("Etaj: " + c.getEtaj());
        System.out.println("Orar Functionare: " + c.getOrar());
        System.out.println("ID Medic: " + c.getIdMedic());
        System.out.println("ID Asistent: " + c.getIdAsistent());
    }
}