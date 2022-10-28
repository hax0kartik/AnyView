package com.example.demo1.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

public class AuthenticationPopup {
    Scene authScene;

    AuthenticationPopup(){

        GridPane grid = new GridPane();
        BorderPane root = new BorderPane();

        Label user_id=new Label("Username:");
        user_id.setTextAlignment(TextAlignment.CENTER);
        user_id.setAlignment(Pos.CENTER);
        Label password = new Label("Password:");

        TextField tf=new TextField();
        PasswordField pf = new PasswordField();
        Button b = new Button("Okay");

        grid.addRow(1, user_id, tf);
        grid.addRow(2, password, pf);
        grid.setHgap(10);
        grid.setVgap(2);
        grid.setPadding(new Insets(0, 0, 0, 90));
        //grid.addRow(3, b);

        // Creating a graphic (image)
        Image img = new Image("C:\\Users\\Kartik\\Desktop\\projects\\jp\\demo1\\src\\main\\resources\\ic2.jpeg");
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        VBox vbox = new VBox();
        Label label = new Label("Authenticate to VNC Server");
        label.setAlignment(Pos.CENTER);

        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(view, label, grid);

        Button OK = new Button("OK");
        Button Cancel = new Button("Cancel");
        Cancel.setMinWidth(60);
        OK.setMinWidth(60);

        HBox buttonbox = new HBox(OK, Cancel);
        buttonbox.setAlignment(Pos.CENTER_RIGHT);
        buttonbox.setSpacing(10);
        buttonbox.setPadding(new Insets(0, 10, 5, 0));

        root.setCenter(vbox);
        root.setBottom(buttonbox);
        authScene = new Scene(root, 400, 200);
    }

    public Scene getAuthScene() {
        return authScene;
    }
}
