package sample;

import javafx.beans.property.*;

public class Client {

    private IntegerProperty IdClient;
    private IntegerProperty CodeClient;
    private StringProperty nomClient;
    private StringProperty adresse;

    //Constructor
    public Client(){
        this.IdClient=new SimpleIntegerProperty();
        this.CodeClient=new SimpleIntegerProperty();
        this.nomClient=new SimpleStringProperty();
        this.adresse= new SimpleStringProperty();
    }

    //Getters and Setters
    public int getIdClient() {
        return IdClient.get();
    }

    public IntegerProperty IdClientProperty() {
        return IdClient;
    }

    public void setIdClient(int codeClient) {
        this.IdClient.set(codeClient);
    }
    ///////////////////////////////
    public String getNomClient() {
        return nomClient.get();
    }

    public StringProperty nomClientProperty() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient.set(nomClient);
    }
    ///////////////////////////////
    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }
    ///////////////////////////////
    public int getCodeClient() {
        return CodeClient.get();
    }

    public IntegerProperty CodeClientProperty() {
        return CodeClient;
    }

    public void setCodeClient(int adresse) {
        this.CodeClient.set(adresse);
    }

}