/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jayuk
 */
public class AppAddJTextField 
{
    private JFrame myFrame;
    private JLabel myLabel;
    private JButton myButton;
    private JTextField myTextField;
    
    public AppAddJTextField()
    {
        myFrame = new JFrame("Add JLabel");
        myLabel = new JLabel("Isi label");
        myButton = new JButton("Click Me");
        myTextField =  new JTextField();
        
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(200,100);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addCompoenent()
    {
        myFrame.add(myLabel);
        myFrame.add(myButton);
        myFrame.add(myTextField);
    }
    public void setLayout()
    {
        myFrame.setLayout(new FlowLayout());
    }
    public static void main(String[] args) {
        AppAddJTextField textField = new AppAddJTextField();
        textField.addCompoenent();
        textField.setLayout();
        
    }
}
