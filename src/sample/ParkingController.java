package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ParkingController {
    @FXML private TextField numParking;
    @FXML private TextField capacite;
    @FXML private TextField rue;
    @FXML private TextField arrondissement;

    @FXML private TextField chercherNumPaking;
    @FXML private TextField chercherCapacite;
    @FXML private TextField chercherRue;
    @FXML private TextField chercherArrondissement;

    @FXML private TextField numVehicule;
    @FXML private TextField Park;

    @FXML private TableColumn<Parking,Integer> colParkingId;
    @FXML private TableColumn<Parking,Integer> colNumParking;
    @FXML private TableColumn<Parking,String> colcapacite;
    @FXML private TableColumn<Parking,String> colRue;
    @FXML private TableColumn<Parking,String> colArrondissement;
    @FXML private TableView parkingTable;

    //=======================parking vehicule====================
    @FXML TextField placeVide;
    @FXML private TableView parkingVehiculeTable;
    @FXML private TableColumn<Vehicule,String> colVehicule;

    //=======================choice box===========================
    ObservableList<Integer> parkingList = FXCollections.observableArrayList(1,2,3,4,5);
    @FXML private ChoiceBox parkingBox;
    //=============================================================

    @FXML public TextArea resultConsole;


    @FXML
    public void ajouter(ActionEvent event) throws SQLException,ClassNotFoundException {
        try{
            ParkingDAO.ajouter(Integer.parseInt(numParking.getText()),capacite.getText(),rue.getText(),arrondissement.getText());
            resultConsole.setText("les donnees du parking ont été ajoutées");
            parkingList.add(Integer.parseInt(numParking.getText()));
            ObservableList<Parking> listeParking= ParkingDAO.getParking();
            populateTable(listeParking);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    public void modifier(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ParkingDAO.modifier(Integer.parseInt(chercherNumPaking.getText()),chercherCapacite.getText(),chercherRue.getText(),chercherArrondissement.getText());
            resultConsole.setText("les donnees du parking ont été modifiées");
            ObservableList<Parking> listeParking= ParkingDAO.getParking();
            populateTable(listeParking);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ParkingDAO.supprimer(Integer.parseInt(chercherNumPaking.getText()));
            resultConsole.setText("les donnees du parking ont été suprimées");
            ObservableList<Parking> listeParking= ParkingDAO.getParking();
            populateTable(listeParking);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void chercher(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ObservableList< Parking > list=ParkingDAO.chercher(Integer.parseInt(chercherNumPaking.getText()));
            if(list.size()>0){
                populateTable(list);
            }
            else {
                resultConsole.setText("pas de résultat");
            }

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void initialize() throws Exception{
        colParkingId.setCellValueFactory(cellData -> cellData.getValue().parkingIdProperty().asObject());
        colNumParking.setCellValueFactory(cellData -> cellData.getValue().numParkingProperty().asObject());
        colcapacite.setCellValueFactory(cellData -> cellData.getValue().capaciteProperty());
        colRue.setCellValueFactory(cellData -> cellData.getValue().rueProperty());
        colArrondissement.setCellValueFactory(cellData -> cellData.getValue().arrondissementProperty());
        ObservableList<Parking> listeParking= ParkingDAO.getParking();
        populateTable(listeParking);
        //======================tableau parking vehicule==================
        colVehicule.setCellValueFactory(cellData -> cellData.getValue().numImmatriculationProperty());
        ObservableList<Vehicule> listeVehicule= VehiculeDAO.getVehicule();
        populateTableVehicule(listeVehicule);

        //==================choice box=====================
        parkingBox.setValue(1);
        parkingBox.setItems(parkingList);
    }

    private void populateTable(ObservableList<Parking> listeParking) {
        parkingTable.setItems(listeParking);
    }
    private void populateTableVehicule(ObservableList<Vehicule> listeVehicule) {
        parkingVehiculeTable.setItems(listeVehicule);
    }

    @FXML
    public void afficherTout(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ObservableList<Parking> listeParking=ParkingDAO.getParking();
            populateTable(listeParking);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    public void sortirVehicule(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ParkingDAO.sortirVehicule(numVehicule.getText());
            resultConsole.setText("les donnees ont été suprimées");
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void deposerVehicule(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            if((ParkingDAO.nombreDePlaceVide(Integer.parseInt(Park.getText()))!=0)){
            ParkingDAO.deposerVehicule(Integer.parseInt(Park.getText()),numVehicule.getText());
            resultConsole.setText("les donnees ont été ajouté");}
            else{
                resultConsole.setText("le parking est plein");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void restituerVehicule(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ParkingDAO.restituerVehicule(Integer.parseInt(Park.getText()),numVehicule.getText());
            resultConsole.setText("le numero park a été modifié ");
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    //========================afficher vehicule selon parking====================
    public static Integer status(ChoiceBox<Integer> parkingBox)
    {
        Integer status=parkingBox.getValue();
        return status;
    }
    //============================================================================
    @FXML
    public void chercherVehiculeSelonParking(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Vehicule> list=VehiculeDAO.chercherVehiculeSelonParking(status(parkingBox));
            if(list.size()>0){
                populateTableVehicule(list);
            }
            else {
                resultConsole.setText("pas de résultat");
            }
        }
        catch(SQLException  e){
            e.printStackTrace();
            throw e;
        }

    }

  @FXML
    public void nombreDeplaceVide(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            int var = ParkingDAO.nombreDePlaceVide(status(parkingBox));
            placeVide.setText(String.valueOf(var));
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }


}