package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ClientController {

    @FXML private TextField CodeClient;
    @FXML private TextField nomClient;
    @FXML private TextField adresse;

    @FXML private TextField chercherIdClient;
    @FXML private TextField chercherCodeClient;
    @FXML private TextField chercherNomClient;
    @FXML private TextField chercherAdresse;

    @FXML private TableColumn<Client,Integer> colIdClient;
    @FXML private TableColumn<Client,Integer> colCodeClient;
    @FXML private TableColumn<Client,String> colNomClient;
    @FXML private TableColumn<Client,String> colAdresse;
    @FXML private TextArea resultConsole;
    @FXML private TableView clientTable;


    @FXML
    public void ajouter(ActionEvent event) throws SQLException,ClassNotFoundException {
        try{
            ClientDAO.ajouter(Integer.parseInt(CodeClient.getText()),nomClient.getText(),adresse.getText());
            resultConsole.setText("les coordonnées du client a été ajoutées ");
            ObservableList<Client> listeContrat= ClientDAO.getClient();
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
            ClientDAO.modifier(Integer.parseInt(chercherIdClient.getText()),Integer.parseInt(chercherCodeClient.getText()),chercherNomClient.getText(),chercherAdresse.getText());
            resultConsole.setText("les coordonnées du client ont été modifiées");
            ObservableList<Client> listeContrat= ClientDAO.getClient();
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
            ClientDAO.supprimer(Integer.parseInt(chercherIdClient.getText()));
            resultConsole.setText("les coordonnées du été suprimées");
            ObservableList<Client> listeContrat= ClientDAO.getClient();
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
            ObservableList< Client > list=ClientDAO.chercher(Integer.parseInt(chercherIdClient.getText()));
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
        colIdClient.setCellValueFactory(cellData -> cellData.getValue().IdClientProperty().asObject());
        colCodeClient.setCellValueFactory(cellData -> cellData.getValue().CodeClientProperty().asObject());
        colNomClient.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        colAdresse.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
        ObservableList<Client> listeClient= ClientDAO.getClient();
        populateTable(listeClient);
    }

    private void populateTable(ObservableList<Client> listeClient) {
        clientTable.setItems(listeClient);
    }

    @FXML
    public void afficherTout(ActionEvent event) throws SQLException,ClassNotFoundException{
        try{
            ObservableList<Client> listeClient= ClientDAO.getClient();
            populateTable(listeClient);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

}