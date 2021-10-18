package sample;

import javafx.beans.property.*;

public class Facture {

    private IntegerProperty numFacture;
    private StringProperty dateFacture;
    private DoubleProperty montant;

    //Constructor
    public Facture(){
        this.numFacture=new SimpleIntegerProperty();
        this.montant=new SimpleDoubleProperty();
        this.dateFacture= new SimpleStringProperty();
    }
    //Getters and Setters
    public int getNumFacture() {
        return numFacture.get();
    }

    public IntegerProperty numFactureProperty() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture.set(numFacture);
    }
    ///////////////////////////////

    public String getDateFacture() {
        return dateFacture.get();
    }

    public StringProperty dateFactureProperty() {
        return dateFacture;
    }

    public void setDateFacture(String dateFacture) {
        this.dateFacture.set(dateFacture);
    }
    ///////////////////////////////

    public double getMontant() {
        return montant.get();
    }

    public DoubleProperty montantProperty() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant.set(montant);
    }
}