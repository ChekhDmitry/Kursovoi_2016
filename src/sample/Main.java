package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage mainstage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainstage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("The 6th Code-Sense");
        Scene scn = new Scene(root);
        primaryStage.setScene(scn);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
