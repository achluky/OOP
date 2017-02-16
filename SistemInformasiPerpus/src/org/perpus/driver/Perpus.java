
package org.perpus.driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Wira
 */
public class Perpus extends Application
{
 @Override
 public void start(Stage stage) throws Exception
 {
    Parent parent = FXMLLoader.load(getClass().getResource("/org/perpus/view/perpus.fxml"));
    Scene scene = new Scene(parent,800,600);
    stage.setScene(scene);
    stage.show();
 }

    
}

    
