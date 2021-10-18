package sample;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

       // Image image = new Image(getClass().getResourceAsStream("/sample.image/logo.png"));
        // primaryStage.getIcons().add(new Image("C:/Users/hp/Desktop/logo.png"));
        primaryStage.setTitle("IZO Application");
        primaryStage.setScene(new Scene(root, 1024, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
