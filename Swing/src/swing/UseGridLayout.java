/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jayuk
 */
public class UseGridLayout 
{
    private JFrame myFrame;
    public UseGridLayout()
    {
        myFrame = new JFrame("Grid Layout Demo");
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addComponent()
    {
        for(int x=1;x<13;x++)
        {
            myFrame.add(new JButton(""+x));
        }
    }
    public void setLayout()
    {
        myFrame.setLayout(new GridLayout(3,4));
    }
    public void setPack()
    {
        myFrame.pack();
    }
    public static void main(String[] args) {
        UseGridLayout ug = new UseGridLayout();
        ug.setLayout();
        ug.addComponent();
        ug.setPack();
    }
}
