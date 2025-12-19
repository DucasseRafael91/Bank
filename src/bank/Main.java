package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CompteDao compteDao = new CompteDao();
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 3) {
            System.out.println("\n=== BANQUE ===");
            System.out.println("1. Voir tous les comptes");
            System.out.println("2. Choisir un compte (par index)");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    printAllComptes(compteDao);
                    break;

                case 2:
                    choisirCompteParIndex(compteDao, scanner);
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

    // Affiche les comptes avec leur index
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

    // Choisir un compte par index
    private static void choisirCompteParIndex(CompteDao compteDao, Scanner scanner) {
        ArrayList<Compte> allComptes = compteDao.findAll();

        printAllComptes(compteDao);

        System.out.print("\nEntrez l'index du compte : ");
        int index = scanner.nextInt();

        if (index >= 0 && index < allComptes.size()) {
            Compte compteChoisi = allComptes.get(index);

            System.out.println("\nCompte sélectionné :");
            System.out.println(
            	"ID : " + compteChoisi.getId() +
                "Titulaire : " + compteChoisi.getTitulaire() +
                " | Solde : " + compteChoisi.getSolde()
            );
        } else {
            System.out.println("❌ Index invalide.");
        }
    }
}
