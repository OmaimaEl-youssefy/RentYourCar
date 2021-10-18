package sample;

import javafx.beans.property.*;

public class Reservation {

    private IntegerProperty codeReservation;
    private StringProperty dateReservation;
    private StringProperty dateDepart;
    private StringProperty dateRetour;
    private StringProperty reservationStatus;

    //Constructor
    public Reservation() {
        this.codeReservation = new SimpleIntegerProperty();
        this.dateReservation = new SimpleStringProperty();
        this.dateDepart = new SimpleStringProperty();
        this.dateRetour = new SimpleStringProperty();
        this.reservationStatus = new SimpleStringProperty();
    }

    //Getters and Setters
    public int getCodeReservation() {
        return codeReservation.get();
    }

    public IntegerProperty codeReservationProperty() {
        return codeReservation;
    }

    public void setCodeReservation(int codeReservation) {
        this.codeReservation.set(codeReservation);
    }
    ///////////////////////////////

    public String getDateReservation() {
        return dateReservation.get();
    }

    public StringProperty dateReservationProperty() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation.set(dateReservation);
    }
    ///////////////////////////////

    public String getDateDepart() {
        return dateDepart.get();
    }

    public StringProperty dateDepartProperty() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart.set(dateDepart);
    }
    ///////////////////////////////

    public String getDateRetour() {
        return dateRetour.get();
    }

    public StringProperty dateRetourProperty() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour.set(dateRetour);
    }
    ///////////////////////////////

    public String getReservationStatus() {
        return reservationStatus.get();
    }

    public StringProperty reservationStatusProperty() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus.set(reservationStatus);
    }
}
