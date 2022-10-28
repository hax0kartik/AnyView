package com.example.demo1.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConnectingPopup {

    Label status;
    Scene connectScene;
    Button stopButton;
    Image logoImage;
    ConnectingPopup(){
        status = new Label();
        stopButton = new Button("Stop");
        FileInputStream stream;
        try{
            stream = new FileInputStream("C:\\Users\\Kartik\\Desktop\\projects\\jp\\demo1\\src\\main\\resources\\logo.png");
            logoImage = new Image(stream);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        ImageView imageView = new ImageView(logoImage);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        VBox vBox = new VBox(imageView, status);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        HBox hbox = new HBox(stopButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-padding: 0 0 10 0;");
        BorderPane pane = new BorderPane();
        pane.setCenter(vBox);
        pane.setBottom(hbox);
        connectScene = new Scene(pane, 320, 240);
    }

    public Label getStatus() {
        return status;
    }

    public Scene getConnectScene() {
        return connectScene;
    }
}
