package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CompteDao compteDao = new CompteDao();
        TypeOperationDao typeOperationDao = new TypeOperationDao();
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 3) {
            System.out.println("\n=== BANQUE ===");
            System.out.println("1. Voir tous les comptes");
            System.out.println("2. Choisir un compte et un type d'opération");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    printAllComptes(compteDao);
                    break;

                case 2:
                    choisirCompteEtOperation(compteDao, typeOperationDao, scanner);
                    break;

                case 3:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }

    // ================= COMPTES =================

    private static void printAllComptes(CompteDao compteDao) {
        ArrayList<Compte> allComptes = compteDao.findAll();
        System.out.println("\nListe des comptes :");

        for (int i = 0; i < allComptes.size(); i++) {
            Compte c = allComptes.get(i);
            System.out.println(
                i + " - " + c.getTitulaire() + " | Solde : " + c.getSolde()
            );
        }
    }

    // ================= OPERATIONS =================

    private static void printAllTypeOperations(TypeOperationDao dao) {
        ArrayList<TypeOperation> types = dao.findAll();
        System.out.println("\nTypes d'opération :");

        for (int i = 0; i < types.size(); i++) {
            System.out.println(i + " - " + types.get(i).getNom());
        }
    }

    // ================= SELECTION =================

    private static void choisirCompteEtOperation(
            CompteDao compteDao,
            TypeOperationDao typeOperationDao,
            Scanner scanner) {

        // ===== Choix du compte =====
        ArrayList<Compte> comptes = compteDao.findAll();
        printAllComptes(compteDao);

        System.out.print("\nEntrez l'index du compte : ");
        int indexCompte = scanner.nextInt();

        if (indexCompte < 0 || indexCompte >= comptes.size()) {
            System.out.println("❌ Index de compte invalide.");
            return;
        }

        Compte compteChoisi = comptes.get(indexCompte);

        // ===== Choix du type d'opération =====
        ArrayList<TypeOperation> operations = typeOperationDao.findAll();
        printAllTypeOperations(typeOperationDao);

        System.out.print("\nEntrez l'index du type d'opération : ");
        int indexOperation = scanner.nextInt();

        if (indexOperation < 0 || indexOperation >= operations.size()) {
            System.out.println("❌ Index de type d'opération invalide.");
            return;
        }

        TypeOperation operationChoisie = operations.get(indexOperation);

        // ===== Saisie du montant =====
        System.out.print("\nEntrez le montant : ");
        double montant = scanner.nextDouble();

        if (montant <= 0) {
            System.out.println("❌ Le montant doit être positif.");
            return;
        }

        // ===== RÉCAPITULATIF FINAL =====
        System.out.println("\n===== RÉCAPITULATIF DE L'OPÉRATION =====");
        System.out.println("Compte : " + compteChoisi.getTitulaire());
        System.out.println("Solde actuel : " + compteChoisi.getSolde());
        System.out.println("Type d'opération : " + operationChoisie.getNom());
        System.out.println("Montant : " + montant);
    }

}
