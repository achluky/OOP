/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventhandler;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jayuk
 */
public class EventHandler 
{
    private JFrame myFrame; 
    private JLabel myLabel;
    private JButton myButton1;
    private JButton myButton2;
    private ClassEventHandler ch;  
 
    public EventHandler(String title)
    {
        myFrame = new JFrame(title);  
        myLabel = new JLabel("Default Text");
        myLabel.setOpaque(true);
        myLabel.setBackground(Color.lightGray);
        myButton1 = new JButton("Button1");  
        myButton2 = new JButton("Button2");
        //instansiasi event listener kelas
        ch = new ClassEventHandler();  
        System.out.println(myFrame.getLayout()); 
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(240,100);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setLayout()
    {
        myFrame.setLayout(new FlowLayout());  
    }
    
    private void addComponent()
    {  
        myFrame.add(myButton1);
        myFrame.add(myButton2);
        myFrame.add(myLabel);
    }
    private void addListener()
    {  
        myButton1.addMouseListener(ch);
        myButton2.addMouseListener(ch);
    }
    
    private class ClassEventHandler extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e) 
        {
            if (e.getSource() == myButton1)
                myLabel.setText("Button 1 clicked");
            else  
                myLabel.setText("Button 2 clicked");
        }
    }
    public static void main(String[] args) 
    {
        EventHandler deho =  new EventHandler("Event handling demo");
        deho.setLayout();
        deho.addComponent();
        deho.addListener();
    }
 
    
}
