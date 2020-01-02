package sample;

import helpingClasses.WindowStyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {

    WelcomeController welcomeController = new WelcomeController();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginWindow.fxml"));
        Parent root = loader.load();
        welcomeController = loader.getController();
        primaryStage.setTitle("GreenCube");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setOnShowing(event -> welcomeController.rotateCube());
        WindowStyle.allowDrag(root, primaryStage);
        WindowStyle.stageDimension(primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);





    }
}