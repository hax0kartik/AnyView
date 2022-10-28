package com.example.demo1.UI;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;

public class SignUpPopup {
    Scene signUpScene;

    SignUpPopup(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
            signUpScene = new Scene(fxmlLoader.load(), 520, 400);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public Scene getSignUpScene() {
        return signUpScene;
    }
}
