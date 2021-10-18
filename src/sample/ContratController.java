package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;


public class ContratController {

    @FXML private DatePicker dateContrat;
    @FXML private DatePicker dateEcheance;

    @FXML private TextField chercherNumContrat;
    @FXML private DatePicker chercherdateContrat;
    @FXML private DatePicker chercherdateEcheance;

    @FXML private TextArea resultConsole;

    @FXML private TableColumn<Contrat,Integer> colNumContrat;
    @FXML private TableColumn<Contrat,String> coldateContrat;
    @FXML private TableColumn<Contrat,String> coldateEcheance;
    @FXML private TableView ContratTable;


    @FXML
    public void ajouter(ActionEvent event) throws SQLException,ClassNotFoundException {
        try{
            ContratDAO.ajouter(dateContrat.getValue(),dateEcheance.getValue());
            resultConsole.setText("les donnees du contarat ont été ajoutées");
            ObservableList<Contrat> listeContrat= ContratDAO.getContrat();
            populateTable(listeContrat);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    public void modifier(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ContratDAO.modifier(Integer.parseInt(chercherNumContrat.getText()),chercherdateContrat.getValue(),chercherdateEcheance.getValue());
            resultConsole.setText("les donnees du contrat ont été modifiées");
            ObservableList<Contrat> listeContrat= ContratDAO.getContrat();
            populateTable(listeContrat);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ContratDAO.supprimer(Integer.parseInt(chercherNumContrat.getText()));
            resultConsole.setText("les donnees du contrat ont été suprimées");
            ObservableList<Contrat> listeContrat= ContratDAO.getContrat();
            populateTable(listeContrat);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void chercher(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ObservableList<Contrat> list=ContratDAO.chercher(Integer.parseInt(chercherNumContrat.getText()));
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
        colNumContrat.setCellValueFactory(cellData -> cellData.getValue().numContratProperty().asObject());
        coldateContrat.setCellValueFactory(cellData -> cellData.getValue().dateContratProperty());
        coldateEcheance.setCellValueFactory(cellData -> cellData.getValue().dateEcheanceProperty());
        ObservableList<Contrat> listeContrat= ContratDAO.getContrat();
        populateTable(listeContrat);
    }

    private void populateTable(ObservableList<Contrat> listeContrat) {
        ContratTable.setItems(listeContrat);
    }

    @FXML
    public void afficherTout(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ObservableList<Contrat> listeContrat= ContratDAO.getContrat();
            populateTable(listeContrat);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }



}