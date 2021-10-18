package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class FactureController {

    @FXML private TextField montant;
    @FXML private DatePicker dateFacture;

    @FXML private TextArea resultConsole;

    @FXML private TextField chercherNumFacture;
    @FXML private DatePicker chercherDateFacture;
    @FXML private TextField chercherMontant;

    @FXML private TableColumn<Facture,Integer> colNumFacture;
    @FXML private TableColumn<Facture,String> colDateFacture;
    @FXML private TableColumn<Facture,Double> colMontant;

    @FXML private TableView factureTable;


    @FXML
    public void ajouter(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            FactureDAO.ajouter(dateFacture.getValue(), Double.parseDouble(montant.getText()));
            resultConsole.setText("les donnees du facture ont été ajoutées");
            ObservableList<Facture> listeFacture=FactureDAO.getFacture();
            populateTable(listeFacture);
        } catch (SQLException e) {
            System.out.println("Exception occur in Insertion" + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void modifier(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            FactureDAO.modifier(Integer.parseInt(chercherNumFacture.getText()),chercherDateFacture.getValue(),Double.parseDouble(chercherMontant.getText()));
            resultConsole.setText("les donnees du facture ont été modifiées");
            ObservableList<Facture> listeFacture=FactureDAO.getFacture();
            populateTable(listeFacture);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            FactureDAO.supprimer(Integer.parseInt(chercherNumFacture.getText()));
            resultConsole.setText("les donnees du facture ont été suprimées");
            ObservableList<Facture> listeFacture=FactureDAO.getFacture();
            populateTable(listeFacture);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void chercher(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Facture> list=FactureDAO.chercher(Integer.parseInt(chercherNumFacture.getText()));
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
        colNumFacture.setCellValueFactory(cellData -> cellData.getValue().numFactureProperty().asObject());
        colDateFacture.setCellValueFactory(cellData -> cellData.getValue().dateFactureProperty());
        colMontant.setCellValueFactory(cellData -> cellData.getValue().montantProperty().asObject());
        ObservableList<Facture> listeFacture=FactureDAO.getFacture();
        populateTable(listeFacture);

    }

    private void populateTable(ObservableList< Facture> listeFacture) {
        factureTable.setItems(listeFacture);
    }

    @FXML private void afficherTout(ActionEvent event) throws ClassNotFoundException,SQLException
    {
        ObservableList<Facture> listeFacture = FactureDAO.getFacture();
        populateTable(listeFacture);
    }




}