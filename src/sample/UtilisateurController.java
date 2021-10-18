package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class UtilisateurController {
    @FXML private TextField name;
    @FXML private TextField password;

    @FXML private TextArea resultConsole;

    @FXML private TextField chercherName;
    @FXML private TextField chercherPassword;
    @FXML private ChoiceBox<String> chercherconge;
    @FXML private ChoiceBox<String> cherchergenre;

    @FXML private TableColumn<Utilisateur,String> colName;
    @FXML private TableColumn<Utilisateur,String> colPassword;
    @FXML private TableColumn<Utilisateur,String> colConge;
    @FXML private TableColumn<Utilisateur,String> colGenre;

    ObservableList<String> congeList = FXCollections.observableArrayList("oui","non");
    @FXML private ChoiceBox congeBox;

    ObservableList<String> genreList = FXCollections.observableArrayList("root","user");
    @FXML private ChoiceBox genreBox;

    @FXML private TableView utilisateurTable;

    @FXML
    public void ajouter(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            UtilisateurDAO.ajouter(name.getText(),password.getText(),status(congeBox),status(genreBox));
            resultConsole.setText("les donnees de l'utilisateur ont été ajoutées");
            ObservableList<Utilisateur> listeUtilisateur=UtilisateurDAO.getUtilisateur();
            populateTable(listeUtilisateur);
        } catch (SQLException e) {
            System.out.println("Exception occur in Insertion" + e);
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void modifier(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            UtilisateurDAO.modifier(chercherName.getText(),chercherPassword.getText(),status(chercherconge),status(cherchergenre));
            resultConsole.setText("les donnees de l'utilisateur ont été modifiées");
            ObservableList<Utilisateur> listeUtilisateur=UtilisateurDAO.getUtilisateur();
            populateTable(listeUtilisateur);

        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void supprimer(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            UtilisateurDAO.supprimer(chercherName.getText());
            resultConsole.setText("les donnees de l'utilisateur ont été suprimées");
            ObservableList<Utilisateur> listeUtilisateur=UtilisateurDAO.getUtilisateur();
            populateTable(listeUtilisateur);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void chercher(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Utilisateur> list=UtilisateurDAO.chercher(chercherName.getText());
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
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colPassword.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        colConge.setCellValueFactory(cellData->cellData.getValue().congeProperty());
        colGenre.setCellValueFactory(cellData->cellData.getValue().genreProperty());

        //==================choice box=====================
        congeBox.setValue("oui");
        congeBox.setItems(congeList);

        genreBox.setValue("user");
        genreBox.setItems(genreList);

        chercherconge.setValue("oui");
        chercherconge.setItems(congeList);

        cherchergenre.setValue("user");
        cherchergenre.setItems(genreList);

        ObservableList<Utilisateur> listeUtilisateur=UtilisateurDAO.getUtilisateur();
        populateTable(listeUtilisateur);
    }

    private void populateTable(ObservableList<Utilisateur> listeUtilisateur) {
        utilisateurTable.setItems(listeUtilisateur);
    }
    //===============afficher tout=======================

    @FXML private void afficherTout(ActionEvent event) throws ClassNotFoundException,SQLException
    {
        ObservableList<Utilisateur> listeUtilisateur = UtilisateurDAO.getUtilisateur();
        populateTable(listeUtilisateur);
    }

    public static String status(ChoiceBox<String> congeBox)
    {
        String status=congeBox.getValue();
        return status;
    }

}
