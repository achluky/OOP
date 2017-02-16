/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JFrame;

/**
 *
 * @author Jayuk
 */
public class Driver extends JFrame{
    public Driver(String title)
    {
        super(title);
    }

    public static void main(String[] args) 
    {
        Driver driver = new Driver("Demo extends JFrame");
        driver.setSize(300,300);
        driver.setVisible(true);
        driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        driver.setLocationRelativeTo(null);
    }
    
}
