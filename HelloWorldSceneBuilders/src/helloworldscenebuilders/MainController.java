/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldscenebuilders;

import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Hello;

/**
 *
 * @author Jayuk
 */
public class MainController 
{
    @FXML
    private Label helloLabel;
    
    @FXML
    public void prosesKirimPesan(ActionEvent event)
    {
        helloLabel.setText(new Hello().getPesan());
    }
    @FXML
    public void prosesExit(ActionEvent event)
    {
        System.exit(0);
    }
    
}
