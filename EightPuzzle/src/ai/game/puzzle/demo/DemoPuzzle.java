/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game.puzzle.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author Jayuk
 */
public class DemoPuzzle extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/ai/game/puzzle/view/puzzleBoard.fxml"));
        Scene scene = new Scene(parent,Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
