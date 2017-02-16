package gui2;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Jayuk
 */
public class GUI2 {

    JButton button;
    public static void main(String[] args)
    {
        GUI2 gui = new GUI2();
        gui.go();
    }
    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("Click me");
        
        //button.addActionListener();
        
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
        button.setText("I've been clicked");
    }
    public void paintComponent(Graphics g)
    {
        //g.fillRect(0,0,this.getWidth(),this.getHeight());
        
    }
    
}
