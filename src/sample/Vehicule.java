package sample;

import javafx.beans.property.*;

public class Vehicule {

    private StringProperty numImmatriculation;
    private StringProperty marque;
    private StringProperty type;
    private StringProperty carburant;
    private FloatProperty compteurKm;
    private StringProperty dateCirculation;
    private IntegerProperty parking;

    //constructeur
    public Vehicule() {
        this.numImmatriculation = new SimpleStringProperty();
        this.marque = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
        this.carburant = new SimpleStringProperty();
        this.compteurKm = new SimpleFloatProperty();
        this.dateCirculation = new SimpleStringProperty();
        this.parking = new SimpleIntegerProperty();
    }
    //getters & setters
    public String getNumImmatriculation() {
        return numImmatriculation.get();
    }

    public StringProperty numImmatriculationProperty() {
        return numImmatriculation;
    }

    public void setNumImmatriculation(String numImmatriculation) {
        this.numImmatriculation.set(numImmatriculation);
    }
    ///////////////////////////////

    public String getMarque() {
        return marque.get();
    }

    public StringProperty marqueProperty() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque.set(marque);
    }
    ///////////////////////////////

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
    ///////////////////////////////

    public String getCarburant() {
        return carburant.get();
    }

    public StringProperty carburantProperty() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant.set(carburant);
    }
    ///////////////////////////////

    public Float getCompteurKm() {
        return compteurKm.get();
    }

    public FloatProperty compteurKmProperty() {
        return compteurKm;
    }

    public void setCompteurKm(Float compteurKm) {
        this.compteurKm.set(compteurKm);
    }
    ///////////////////////////////

    public String getDateCirculation() {
        return dateCirculation.get();
    }

    public StringProperty dateCirculationProperty() {
        return dateCirculation;
    }

    public void setDateCirculation(String dateCirculation) {
        this.dateCirculation.set(dateCirculation);
    }
    ///////////////////////////////

    public Integer getParking() {
        return parking.get();
    }

    public IntegerProperty parkingProperty() {
        return parking;
    }

    public void setParking(Integer parking) {
        this.parking.set(parking);
    }
}
