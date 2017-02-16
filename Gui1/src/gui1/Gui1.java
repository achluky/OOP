/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jayuk
 */
public class Gui1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me");
        JButton button1 = new JButton("Click");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(button);
        frame.getContentPane().add(button1);
        
        frame.setSize(300,200);
        button.setSize(10,10);
        
        frame.setVisible(true);
    }
    
}
