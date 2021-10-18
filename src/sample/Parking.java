package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Parking {
    private IntegerProperty parkingId;
    private IntegerProperty numParking;
    private StringProperty capacite;
    private StringProperty rue;
    private StringProperty arrondissement;
    private IntegerProperty park;

    //Getters and Setters
    public Parking(){
        this.numParking=new SimpleIntegerProperty();
        this.capacite=new SimpleStringProperty();
        this.rue=new SimpleStringProperty();
        this.arrondissement=new SimpleStringProperty();
        this.parkingId=new SimpleIntegerProperty();
        this.park=new SimpleIntegerProperty();
    }
    //Getters and Setters
    public int getParkingId() {
        return parkingId.get();
    }

    public IntegerProperty parkingIdProperty() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId.set(parkingId);
    }
    ///////////////////////////////

    public int getNumParking() {
        return numParking.get();
    }

    public IntegerProperty numParkingProperty() {
        return numParking;
    }

    public void setNumParking(int numParking) {
        this.numParking.set(numParking);
    }
    ///////////////////////////////

    public String getCapacite() {
        return capacite.get();
    }

    public StringProperty capaciteProperty() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite.set(capacite);
    }
    ///////////////////////////////

    public String getRue() {
        return rue.get();
    }

    public StringProperty rueProperty() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue.set(rue);
    }
    ///////////////////////////////

    public String getArrondissement() {
        return arrondissement.get();
    }

    public StringProperty arrondissementProperty() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement.set(arrondissement);
    }
    ///////////////////////////////

    public int getPark() {
        return park.get();
    }

    public IntegerProperty parkProperty() {
        return park;
    }

    public void setPark(int park) { this.park.set(park); }

}