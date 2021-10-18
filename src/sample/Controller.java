package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    //Controller du log In
    @FXML private BorderPane rootPane;

    @FXML private TextField userName;
    @FXML private PasswordField password;


    Alert alertBox1 = new Alert(Alert.AlertType.ERROR);
    Alert alertBox2 = new Alert(Alert.AlertType.INFORMATION);


    @FXML
    private void loadHome(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        try {
            String sql = "SELECT * from utilisateur ";
            ResultSet result = DBUtil.dbExecute(sql);
            while (result.next()) {
                if (result.getString("name").equals(userName.getText())) {
                    if (result.getString("password").equals(password.getText())) {
                        if (result.getString("conge").equals("non")) {
                            if (result.getString("genre").equals("root")) {
                                BorderPane pane = FXMLLoader.load(getClass().getResource("menu.fxml"));
                                rootPane.getChildren().setAll(pane);
                            } else {
                                BorderPane pane = FXMLLoader.load(getClass().getResource("userMenu.fxml"));
                                rootPane.getChildren().setAll(pane);
                            }
                        } else {

                            alertBox2.setTitle("warning");
                            alertBox2.setContentText("vous etes en congé vous ne pouvez pas consulter l'application");
                            alertBox2.setHeaderText(null);
                            alertBox2.show();
                        }
                    } else {

                        alertBox1.setTitle("warning");
                        alertBox1.setContentText("le nom d'utilisateur ou le mot de passe est incorrecte");
                        alertBox1.setHeaderText(null);
                        alertBox1.show();
                    }
                }
                continue;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }
}