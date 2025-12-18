package bank;

public class Compte {
	
	private int id;
	private String titulaire;
	private double solde;
	
    // Constructeur
    public Compte(String titulaire, double solde) {
        this.id = id;
        this.titulaire = titulaire;
        this.solde = solde;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getTitulaire() {
        return titulaire;
    }
    
    public double getSolde() {
        return solde;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }
    
    public void setSolde(double solde) {
        this.solde = solde;
    }

}

