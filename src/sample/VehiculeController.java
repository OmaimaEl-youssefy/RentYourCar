package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class VehiculeController {
    @FXML private DatePicker dateCirculation;
    @FXML private TextField numImmatriculation;
    @FXML private TextField marque;
    @FXML private TextField type;
    @FXML private TextField compteurKm;
    @FXML private TextField parking;
    ObservableList<String> carburantList = FXCollections.observableArrayList("Diesel","Essence","GPL","Bioéthanol");
    @FXML private ChoiceBox carburantBox;

    @FXML private TextArea resultConsole;

    @FXML private TextField chercherNumImmatriculation;
    @FXML private DatePicker chercherDateCirculation;
    @FXML private TextField chercherType;
    @FXML private TextField chercherMarque;
    @FXML private TextField chercherParking;
    @FXML private TextField chercherCompteurKm;
    @FXML private ChoiceBox<String> chercherCarburant;


    @FXML private TableColumn<Vehicule,String> colNumImmatriculation;
    @FXML private TableColumn<Vehicule,String> colMarque;
    @FXML private TableColumn<Vehicule,String> colType;
    @FXML private TableColumn<Vehicule,String> colCarburant;
    @FXML private TableColumn<Vehicule,Float> colCompteurKm;
    @FXML private TableColumn<Vehicule,String> colDateCirculation;
    @FXML private TableColumn<Vehicule,Integer> colParking;

    @FXML private TableView vehiculeTable;


    @FXML
    public void ajouter(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            VehiculeDAO.ajouter(dateCirculation.getValue(),numImmatriculation.getText(),marque.getText(),type.getText(),Integer.parseInt(parking.getText()),Float.parseFloat(compteurKm.getText()),status(carburantBox));
            resultConsole.setText("les donnees du véhicule ont été ajoutées");
            ObservableList<Vehicule> listeVehicule=VehiculeDAO.getVehicule();
            populateTable(listeVehicule);
        } catch (SQLException e) {
            System.out.println("Exception occur in Insertion" + e);
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void modifier(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            VehiculeDAO.modifier(chercherNumImmatriculation.getText(),chercherMarque.getText(),chercherType.getText(),Integer.parseInt(chercherParking.getText()),Float.parseFloat(chercherCompteurKm.getText()),chercherDateCirculation.getValue(),status(chercherCarburant));
            resultConsole.setText("les donnees du véhicule ont été modifiées");
            ObservableList<Vehicule> listeVehicule=VehiculeDAO.getVehicule();
            populateTable(listeVehicule);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            VehiculeDAO.supprimer(chercherNumImmatriculation.getText());
            resultConsole.setText("les donnees du véhicule ont été suprimées");
            ObservableList<Vehicule> listeVehicule=VehiculeDAO.getVehicule();
            populateTable(listeVehicule);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void chercher(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Vehicule> list=VehiculeDAO.chercher(chercherNumImmatriculation.getText());
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
        colNumImmatriculation.setCellValueFactory(cellData -> cellData.getValue().numImmatriculationProperty());
        colMarque.setCellValueFactory(cellData -> cellData.getValue().marqueProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        colParking.setCellValueFactory(cellData -> cellData.getValue().parkingProperty().asObject());
        colCompteurKm.setCellValueFactory(cellData -> cellData.getValue().compteurKmProperty().asObject());
        colDateCirculation.setCellValueFactory(cellData -> cellData.getValue().dateCirculationProperty());
        colCarburant.setCellValueFactory(cellData -> cellData.getValue().carburantProperty());
        //==================choice box=====================
        carburantBox.setValue("Diesel");
        carburantBox.setItems(carburantList);

        chercherCarburant.setValue("Diesel");
        chercherCarburant.setItems(carburantList);

        ObservableList<Vehicule> listeVehicule=VehiculeDAO.getVehicule();
        populateTable(listeVehicule);
    }

    public void populateTable(ObservableList<Vehicule> listeVehicule) {
        vehiculeTable.setItems(listeVehicule);
    }

    @FXML private void afficherTout(ActionEvent event) throws ClassNotFoundException,SQLException
    {
        ObservableList<Vehicule> listeVehicule = VehiculeDAO.getVehicule();
        populateTable(listeVehicule);
    }

    public static String status(ChoiceBox<String> carburantBox)
    {
        String status=carburantBox.getValue();
        return status;
    }
}
