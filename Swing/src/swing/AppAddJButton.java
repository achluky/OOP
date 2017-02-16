/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.*;

/**
 *
 * @author Jayuk
 */
public class AppAddJButton 
{
    private JFrame myFrame;
    private JLabel myLabel;
    private JButton myButton;
    
    public AppAddJButton()
    {
        myFrame = new JFrame("Add JLabel");
        myLabel =  new JLabel("Isi label");
        myButton =  new JButton("Click me");
        
        myFrame.setSize(200,100);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        
        
    }
    
    
    
}
