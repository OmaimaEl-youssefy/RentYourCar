package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ReservationController {

    @FXML private DatePicker dateReservation;
    @FXML private DatePicker dateDepart;
    @FXML private DatePicker dateRetour;
    @FXML private TextField codeReservation;
    //************choice box**************
    ObservableList<String> reservationStatusList = FXCollections.observableArrayList("Validée","Non Validée","Annulée");
    @FXML private ChoiceBox reservationStatusBox;

    @FXML private TextArea resultConsole;

    @FXML private DatePicker chercherDateReservation;
    @FXML private DatePicker chercherDateDepart;
    @FXML private DatePicker chercherDateRetour;
    @FXML private TextField chercherCodeReservation;
    @FXML private ChoiceBox<String> chercherReservationStatus;

    @FXML private TableColumn<Reservation,Integer> colCodeReservation;
    @FXML private TableColumn<Reservation,String> colDateReservation;
    @FXML private TableColumn<Reservation,String> colDateDepart;
    @FXML private TableColumn<Reservation,String> colDateRetour;
    @FXML private TableColumn<Reservation,String> colReservationStatus;

    @FXML private TableView reservationTable;


    @FXML
    public void ajouter(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            ReservationDAO.ajouter(Integer.parseInt(codeReservation.getText()),dateReservation.getValue(),dateDepart.getValue(),dateRetour.getValue(),status(reservationStatusBox));
            resultConsole.setText("les donnees du résérvation ont été ajoutées ");
            ObservableList<Reservation> listeReservation=ReservationDAO.getReservation();
            populateTable(listeReservation);
        } catch (SQLException e) {
            System.out.println("Exception occur in Insertion" + e);
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void modifier(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ReservationDAO.modifier(Integer.parseInt(chercherCodeReservation.getText()),chercherDateReservation.getValue(),chercherDateDepart.getValue(),chercherDateRetour.getValue(),status(chercherReservationStatus));
            resultConsole.setText("les donnees ont été modifiées");
            ObservableList<Reservation> listeReservation=ReservationDAO.getReservation();
            populateTable(listeReservation);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ReservationDAO.supprimer(Integer.parseInt(chercherCodeReservation.getText()));
            resultConsole.setText("les donnees du résérvation ont été suprimées");
            ObservableList<Reservation> listeReservation=ReservationDAO.getReservation();
            populateTable(listeReservation);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void chercher(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Reservation> list=ReservationDAO.chercher(Integer.parseInt(chercherCodeReservation.getText()));
            if(list.size()>0){
                populateTable(list);
            }
            else {
                resultConsole.setText("pas de résultat");
            }

        }
        catch(SQLException  e){
            e.printStackTrace();

        }

    }
    @FXML
    public void initialize() throws Exception{
        colCodeReservation.setCellValueFactory(cellData -> cellData.getValue().codeReservationProperty().asObject());
        colDateReservation.setCellValueFactory(cellData -> cellData.getValue().dateReservationProperty());
        colDateDepart.setCellValueFactory(cellData -> cellData.getValue().dateDepartProperty());
        colDateRetour.setCellValueFactory(cellData -> cellData.getValue().dateRetourProperty());
        colReservationStatus.setCellValueFactory(cellData->cellData.getValue().reservationStatusProperty());
        ObservableList<Reservation> listeReservation=ReservationDAO.getReservation();
        populateTable(listeReservation);
        //==================choice box=====================
        reservationStatusBox.setValue("Validée");
        reservationStatusBox.setItems(reservationStatusList);

        chercherReservationStatus.setValue("Validée");
        chercherReservationStatus.setItems(reservationStatusList);
    }

    private void populateTable(ObservableList<Reservation> listeReservation) {
        reservationTable.setItems(listeReservation);
    }

    @FXML private void afficherTout(ActionEvent event) throws ClassNotFoundException,SQLException
    {
        ObservableList<Reservation> listeReservation = ReservationDAO.getReservation();
        populateTable(listeReservation);
    }

    public static String status(ChoiceBox<String> reservationStatusBox)
    {
        String status=reservationStatusBox.getValue();
        return status;
    }

    @FXML
    public void chercherReservation(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Reservation> list=ReservationDAO.chercherReservation(status(chercherReservationStatus));
            if(list.size()>0){
                populateTable(list);
            }
            else {
                resultConsole.setText("pas de résultat");
            }

        }
        catch(SQLException  e){
            e.printStackTrace();

        }

    }
}
