package bank;

public class Main {

    public static void main(String[] args) {
        CompteDao compteDao = new CompteDao();
        Compte compte = compteDao.findById("FR-1111-2222");

        System.out.println(compte.getTitulaire());
    }
}
