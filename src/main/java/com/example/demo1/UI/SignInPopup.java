package com.example.demo1.UI;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;

public class SignInPopup {
    Scene signInScene;

    SignInPopup(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
            signInScene = new Scene(fxmlLoader.load(), 520, 400);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public Scene getSignInScene() {
        return signInScene;
    }
}
