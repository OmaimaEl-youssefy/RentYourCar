package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utilisateur {

    private StringProperty name;
    private StringProperty password;
    private StringProperty conge;
    private StringProperty genre;

    //constructor
    public Utilisateur() {
        this.name = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.conge=new SimpleStringProperty();
        this.genre= new SimpleStringProperty();
    }

    //Getters and Setters
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
    ///////////////////////////////
    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    ///////////////////////////////
    public String getConge() {
        return conge.get();
    }

    public StringProperty congeProperty() {
        return conge;
    }

    public void setConge(String conge) {
        this.conge.set(conge);
    }
    ///////////////////////////////
    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }
}
