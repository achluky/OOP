/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jayuk
 */
public class LoginWindow extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/LoginView.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
