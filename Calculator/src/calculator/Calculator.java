/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;  
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;  
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;  
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jayuk
 */
public class Calculator extends MouseAdapter
{
    private JFrame myFrame;
    private JTextField text;
    //private ClassEventhandler ch;
    ArrayList<JButton> buttonList =  new ArrayList<>(20);
            
    JButton  seven,eight,nine,five,six, four,two, one,three, zero;
    JButton mod,minus,diBagiX,gantiTanda,plus,point,hasil,backSpace, clear,divide,sqrt,multiply;
    
    
    public Calculator()
    {
        myFrame = new JFrame("Calculator");
        myFrame.setLocationRelativeTo(null);
        
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setText (String newText)
    {
        text.setText(newText);
    }
    public String getText ()
    {
        return text.getText();
    }
    
    public void setLayout(){
        myFrame.setLayout(new BorderLayout());
    }
    
    public void addComponent()
    {
        myFrame.setJMenuBar(makeMenu());
        myFrame.add(makePanelUp(),BorderLayout.NORTH);
        myFrame.add(makePanelBottom(),BorderLayout.CENTER);
    }
    private void addListener()
    {
        /*
        for(JButton buttonTemp : buttonList)
        {
            buttonTemp.addMouseListener(ch);
        }
        mod.addMouseListener(ch);
        minus.addMouseListener(ch);
        diBagiX.addMouseListener(ch);
        gantiTanda.addMouseListener(ch);
        plus.addMouseListener(ch);
        point.addMouseListener(ch);
        hasil.addMouseListener(ch);
        backSpace.addMouseListener(ch);
        clear.addMouseListener(ch);
        divide.addMouseListener(ch);
        sqrt.addMouseListener(ch);
        multiply.addMouseListener(ch);
        */
        one.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                text.setText("Jaya");
            }
        });
        clear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                text.setText("Jaya");
            }
        });
        
    }
    
    
    
    public void setPack()
    {
        myFrame.pack();
    }
    public JMenuBar makeMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(reset);
        file.addSeparator();
        file.add(exit);
        
        JMenu view = new JMenu("View");
        
        JMenuItem standard =  new JMenuItem("Standard");
        JMenuItem scientific =  new JMenuItem("Scientific");
        view.add(standard);
        view.add(scientific);
        
        menuBar.add(view);
        return menuBar;
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
        
        GridBagConstraints gridConstraints = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        
        
        gridConstraints.gridwidth = 3;
        gridConstraints.gridheight = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.fill = GridBagConstraints.BOTH;
        
        panel.add(backSpace = new JButton("Backspace"),gridConstraints);
        
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth  = 2;
        panel.add(clear = new JButton("C"), gridConstraints); 
        
        
        gridConstraints.gridy=0;
        gridConstraints.gridx=1;
        gridConstraints.gridwidth = 1;
        panel.add(seven = new JButton("7"),gridConstraints); 
        
        
        
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridwidth = 1;
        panel.add(eight = new JButton("8"),gridConstraints);
        //button[8] = eight;
        
        
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 1;
        gridConstraints.gridwidth = 1;
        panel.add(nine = new JButton("9"),gridConstraints);
        //button[9] = nine;
        
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 1;
        gridConstraints.gridwidth = 1;
        panel.add(divide = new JButton("/"),gridConstraints);
        
        
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 1;
        gridConstraints.gridwidth = 1;
        panel.add(sqrt = new JButton("sqrt"),gridConstraints);
        
        
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 2;
        gridConstraints.gridwidth = 1;
        panel.add(four= new JButton("4"),gridConstraints);
        //button[4] = four;
        
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridwidth = 1;
        panel.add(five= new JButton("5"),gridConstraints);
        //button[5]  =five;
        
        
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 2;
        gridConstraints.gridwidth = 1;
        panel.add(six= new JButton("6"),gridConstraints);
        //button[6] = six;
        
        
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 2;
        gridConstraints.gridwidth = 1;
        panel.add(multiply = new JButton("x"),gridConstraints);
        
        
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 2;
        gridConstraints.gridwidth = 1;
        panel.add(mod = new JButton("%"),gridConstraints);
        
        
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth = 1;
        panel.add(one= new JButton("1"),gridConstraints);
        //button[1] = one;
        
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth = 1;
        panel.add(two= new JButton("2"),gridConstraints);
        //button[2] = two;
        
        
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth = 1;
        panel.add(three=  new JButton("3"),gridConstraints);
        //button[3] = three;
        
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth = 1;
        
        panel.add((minus = new JButton("-")),gridConstraints);
        
        
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 3;
        gridConstraints.gridwidth = 1;
        panel.add(diBagiX = new JButton("1/x"),gridConstraints);
        
        gridConstraints.gridy = 0;
        gridConstraints.gridx = 4;
        gridConstraints.gridwidth = 1;
        panel.add(zero = new JButton("0"),gridConstraints);
        
        
        
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 4;
        gridConstraints.gridwidth = 1;
        
        panel.add(gantiTanda = new JButton("+/-"),gridConstraints);
        
        
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 4;
        gridConstraints.gridwidth = 1;
        panel.add(point = new JButton("."),gridConstraints);
        
        gridConstraints.gridy = 3;
        gridConstraints.gridx = 4;
        gridConstraints.gridwidth = 1;
        panel.add(plus  = new JButton("+"),gridConstraints);
        
        
        gridConstraints.gridy = 4;
        gridConstraints.gridx = 4;
        gridConstraints.gridwidth = 1;
        panel.add(hasil = new JButton("="),gridConstraints);
        
        buttonList.add(0,zero);
        buttonList.add(1,one);
        buttonList.add(2,two);
        buttonList.add(3,three);
        buttonList.add(4,four);
        buttonList.add(5,five);
        buttonList.add(6,six);
        buttonList.add(7,seven);
        buttonList.add(8,eight);
        buttonList.add(9,nine);
        
        
        return panel;
    }
}
