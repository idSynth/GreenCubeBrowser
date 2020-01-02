package sample;

import helpingClasses.FXResizeHelper;
import helpingClasses.WindowStyle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;


public class WelcomeController {

    @FXML
    Box greenCube;

    @FXML
    Button closeButton;

    @FXML
    Button loginButton;


    public void rotateCube()
    {
        final Timeline rotationTimeline = new Timeline();
        rotationTimeline.setCycleCount(Timeline.INDEFINITE);
        rotationTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(10000),
                new KeyValue(greenCube.rotateProperty(), 360)));

        rotationTimeline.play();

        final Timeline scaleTimeline = new Timeline();
        scaleTimeline.setCycleCount(Timeline.INDEFINITE);
        scaleTimeline.setAutoReverse(true);
        scaleTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2500),
                new KeyValue(greenCube.depthProperty(), 15)));
        scaleTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2500),
                new KeyValue(greenCube.heightProperty(), 15)));
        scaleTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2500),
                new KeyValue(greenCube.widthProperty(), 15)));

        scaleTimeline.play();
    }

    MainController mainController = new MainController();

    public void loginAction(ActionEvent event) throws Exception
    {
        Stage mainStage = new Stage();
        FXMLLoader loader = new FXMLLoader(WelcomeController.class.getResource("mainWindowLite.fxml"));
        Parent root = loader.load();
        mainController = loader.getController();
        mainStage.setTitle("GreenCube");
        mainStage.setScene(new Scene(root, 960, 600));
        mainStage.show();
        mainController.init();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void closeAction()
    {
        Platform.exit();
    }
}