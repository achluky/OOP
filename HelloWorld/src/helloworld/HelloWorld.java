/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jayuk
 */
public class HelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {
        Button button =  new Button("Klik");
        
        button.setOnAction(e -> System.out.println("Hello Wolrd"));
        
        Button exit = new Button("Exit");
        exit.setOnAction(e -> System.exit(0));
        StackPane root = new StackPane();
        root.getChildren().add(button);
        root.getChildren().add(exit);
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(HelloWorld.class,args);
    }
    
}
