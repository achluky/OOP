/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jayuk
 */
public class Absensi extends Application
{
    public static String namaAdmin;

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/absensi/view/MainView.fxml"));
        Scene scene = new Scene (parent, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
}
