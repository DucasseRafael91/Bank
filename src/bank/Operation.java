package bank;

import java.util.Date;

public class Operation {
    
    private int id;
    private String compte;
    private int type_operation;
    private double montant;
    private Date date;
    
    public Operation(String compte, int type_operation, double montant, Date date) {
        this.compte = compte;
        this.type_operation = type_operation;
        this.montant = montant;
        this.date = date;
    }

    // Getter et Setter pour id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et Setter pour compte
    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    // Getter et Setter pour type_operation
    public int getType_operation() {
        return type_operation;
    }

    public void setType_operation(int type_operation) {
        this.type_operation = type_operation;
    }

    // Getter et Setter pour montant
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    // Getter et Setter pour date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
