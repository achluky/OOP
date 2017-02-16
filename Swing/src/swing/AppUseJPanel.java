/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jayuk
 */
public class AppUseJPanel 
{
    private JFrame myFrame;
    private JTextField text;
    private JButton[] button;
    
    public AppUseJPanel()
    {
        myFrame = new JFrame("My Calc");
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    private void setText(String newText)
    {
        text.setText(newText);
    }
    public String getText()
    {
        return text.getText();
    }
    
    public void setLayout()
    {
        myFrame.setLayout(new BorderLayout());
    }
    public void addComponent()
    {
        myFrame.setJMenuBar(makeMenu());
        myFrame.add(makePanelUp(),BorderLayout.NORTH);
        myFrame.add(makePanelBottom(),BorderLayout.CENTER);
    }
    public void setPack()
    {
        myFrame.pack();
    }
    
    public JMenuBar makeMenu()
    {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem reset = new JMenuItem("Reset");
        file.add(reset);
        JMenuItem exit = new JMenuItem("Exit");
        file.addSeparator();
        file.add(exit);
        
        JMenu view = new JMenu("View");
        JMenuItem standard =  new JMenuItem("Standard");
        JMenuItem scientific = new JMenuItem("Scientific");
        view.add(standard);
        view.add(scientific);
        
        mb.add(view);
        return mb;
    }
    public JPanel makePanelUp()
    {
        JPanel panel = new JPanel(); 
        text = new JTextField(20); 
        panel.add(text);
        return panel;
    }
    
    public JPanel makePanelBottom()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints gb = new GridBagConstraints(); 
        panel.setLayout(new GridBagLayout()); 
        gb.gridwidth = 1; 
        gb.gridheight = 1; 
        gb.gridx = 0;
        gb.gridy = 0; 
        gb.fill = GridBagConstraints.BOTH;  
        panel.add(new JButton("First"), gb); 
        gb.gridx = 1; 
        panel.add(new JButton("Second"), gb);
        gb.gridx = 2; 
        panel.add(new JButton("Third"),gb); 
        gb.gridx = 0; gb.gridy++; gb.gridwidth = 3;  panel.add(new JButton("Fourth"), gb); 
        gb.gridy++; gb.gridwidth = 1;  panel.add(new JButton("Fifth"), gb); 
        gb.gridx = 1; gb.gridwidth = 2; gb.gridheight = 2;  panel.add(new JButton("Sixth"), gb); 
        return panel;
    }
    public static void main(String[] args) {
        AppUseJPanel uj = new AppUseJPanel();
        uj.setLayout();
        uj.addComponent();
        uj.setPack();
    }
 
}
