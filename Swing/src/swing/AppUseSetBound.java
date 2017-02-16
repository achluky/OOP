/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jayuk
 */
public class AppUseSetBound 
{
    private JFrame myFrame;
    private JPanel myPanel;
    private JButton a;
    private JButton b;
    private JButton c;
    
    public AppUseSetBound()
    {
        myFrame =  new JFrame("No lay");
        myPanel =  new JPanel();
        a = new JButton("1");
        b = new JButton("2");
        c = new JButton("3");
        
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(240,220);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addComponent()
    {
        myFrame.add(myPanel);
        myPanel.add(a);
        a.setBounds(70,10,59,20);
        myPanel.add(b);
        b.setBounds(20,90,90,23);
        myPanel.add(c);
        c.setBounds(20, 10, 50, 30);
    }
    
    public void setLayout()
    {
        myPanel.setLayout(null);
    }
    public void setPack()
    {
        myFrame.pack();
    }
}
