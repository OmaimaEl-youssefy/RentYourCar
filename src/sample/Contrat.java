package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contrat {

    private IntegerProperty numContrat;
    private StringProperty dateContrat;
    private StringProperty dateEcheance;
    //Constructor
    public Contrat(){
        this.numContrat=new SimpleIntegerProperty();
        this.dateContrat=new SimpleStringProperty();
        this.dateEcheance=new SimpleStringProperty();
    }
    //Getters and Setters
    public int getNumContrat() {
        return numContrat.get();
    }

    public IntegerProperty numContratProperty() {
        return numContrat;
    }

    public void setNumContrat(int numContrat) {
        this.numContrat.set(numContrat);
    }
    ///////////////////////////////
    public String getDateContrat() {
        return dateContrat.get();
    }

    public StringProperty dateContratProperty() {
        return dateContrat;
    }

    public void setDateContrat(String dateContrat) {
        this.dateContrat.set(dateContrat);
    }
    ///////////////////////////////
    public String getDateEcheance() {
        return dateEcheance.get();
    }

    public StringProperty dateEcheanceProperty() {
        return dateEcheance;
    }

    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance.set(dateEcheance);
    }
}