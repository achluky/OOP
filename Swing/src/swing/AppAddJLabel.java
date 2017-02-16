/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jayuk
 */
public class AppAddJLabel {
    private JFrame myFrame;
    private JLabel myLabel;
    
    public AppAddJLabel()
    {
        myFrame = new JFrame("Add JLabel");
        myLabel = new JLabel("Isi Label");
        
        myFrame.setSize(200,100);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addComponent()
    {
        myFrame.add(myLabel);
    }
    
    public static void main(String[] args) {
        new AppAddJLabel().addComponent();
    }
    
}
