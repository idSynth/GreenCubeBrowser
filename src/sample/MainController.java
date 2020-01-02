package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.security.Key;

public class MainController {

    @FXML
    TextField linkTextField;

    @FXML
    WebView webView;

    WebEngine webEngine;




    public void loadUrl(String url) {
        if (!(url.startsWith("http://") || url.startsWith("https://")))
        {
            url = "http://" + url;
        }
        webEngine.load(url);
    }

    public void init()
    {
        //TODO "http://google.com" should be replaced with homePage variable that can be set in settings
        linkTextField.setText("http://google.com");
        String url = linkTextField.getText();
        webEngine = webView.getEngine();
        webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246");
        loadUrl(url);

        linkTextField.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                loadUrl(linkTextField.getText());
            }
        });

        webEngine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> observable,
                 Worker.State oldValue,
                 Worker.State newValue) -> {
                    if( newValue != Worker.State.SUCCEEDED ) {
                        return;
                    }
                    linkTextField.setText(webEngine.getLocation());
                } );
    }

    public void goBack() {
        webEngine.executeScript("history.back()");
    }

    public void goFwd() {
        webEngine.executeScript("history.forward()");
    }

    public void reloadAction() {
        webEngine.reload();
    }

    public void searchAction() {
        loadUrl(linkTextField.getText());
    }


 }

