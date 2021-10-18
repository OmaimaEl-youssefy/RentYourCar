package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class menuController {

    @FXML AnchorPane ap;
    @FXML BorderPane bp;

    @FXML private void loadFacture(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("facture.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadVehicule(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("vehicule.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadReservation(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("reservation.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadContrat(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("contrat.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadClient(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("client.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadUtilisateur(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("utilisateur.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadParking(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("parking.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadBarChart(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("barChart.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }
    @FXML private void loadFirstPage(ActionEvent event) throws IOException {
        AnchorPane pane = load(getClass().getResource("firstPage.fxml"));
        ap.getChildren().setAll(pane);
        bp.setCenter(ap);
    }

}
