import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* implementation of Algorithm 5.1 with a graphical display added */

public class NQueens2 {

    private int[] queencol;
    private int queencount = -1, numsol = 0;
    private int boardsize;
    private JButton[][] board;
    private JPanel boardpanel;
    private JTextArea solnumtext;
    private JPanel wholepanel;
    private ImageIcon ii = new ImageIcon("crown.gif");
    private int sleepAmount;
    private int timesCalled = 0;

    public Component createComponents(int howmany, int sleepAmount) {
       this.sleepAmount = sleepAmount;
       wholepanel = new JPanel();
       wholepanel.setLayout(new BorderLayout());
       boardsize = howmany;
       boardpanel = new JPanel();
       boardpanel.setLayout(new GridLayout(boardsize,boardsize));

       board = new JButton[boardsize][boardsize];
       for (int i = 0; i < boardsize; i++)
          for (int j = 0; j < boardsize; j++) {
             board[i][j] = new JButton();
             boardpanel.add(board[i][j]);
          }

       wholepanel.add("Center", boardpanel);
       solnumtext = new JTextArea(10,20);
       JScrollPane scroller = new JScrollPane(solnumtext);
       wholepanel.add("South", scroller);
       solnumtext.setEditable(false);
       queencol = new int[boardsize];

       return wholepanel;
    }

    private void gotosleep() {
       gotosleep(sleepAmount);
    }

    private void gotosleep(int howlong) {
       try {
          Thread.sleep(howlong);
       }
       catch (InterruptedException e) {}
    }

    public void queens(int i) {
       int j;
       timesCalled++;
       if (promising(i)) {
          if (i == boardsize-1) {
             gotosleep(sleepAmount);
             writeBoard();
          }
          else
             for (j = 0; j < boardsize; j++) {
                queencol[i+1] = j;
                queens(i+1);
             } 
       }
    }

    private boolean promising(int i)
    {
       int k;
       boolean answer;

       k = 0;  // Java array subscripts start at 0
       answer = true;
       while (k < i && answer) {
          // check if any queen threatens the one in the ith row
          if (queencol[i] == queencol[k] || Math.abs(queencol[i]-queencol[k]) == i-k)
             answer = false;
          k++;
       }
       return answer;
    }


    private void writeBoard() {
       numsol++;
       solnumtext.append("Solution " + numsol + "\n");
       for (int i = 0; i < queencol.length; i++)
          solnumtext.append("Queen " + (i + 1) + " at column " + (queencol[i] + 1) +                            "\n");

       for (int i = 0; i < boardsize; i++)
          for (int j = 0; j < boardsize; j++) {
             if (j == queencol[i])
                board[i][j].setIcon(ii);
             else
                board[i][j].setIcon(null);
          }
    }

    public static void main(String[] args) {
       NQueens2 nq = new NQueens2();
       JFrame nqf;
       int howmany;
       int sleepAmount = 0;

       String laf = UIManager.getSystemLookAndFeelClassName();
       try {
          UIManager.setLookAndFeel(laf);
       }
       catch (UnsupportedLookAndFeelException exc) {
          System.out.println("Unsupported: " + laf);
       }
       catch (Exception exc) {
          System.out.println("Error loading: " + laf);
       }

       if (args.length == 0)
          howmany = 8;
       else {
          try {
             howmany = Integer.parseInt(args[0]);
          }
          catch (NumberFormatException ne) {
             howmany = 4;
          }
          try {
             sleepAmount = Integer.parseInt(args[1]);
          }
          catch (Exception e) {
          }
       }
       nqf = new JFrame("N Queens " + howmany);
       Component contents = nq.createComponents(howmany, sleepAmount);
       nqf.getContentPane().add(contents,BorderLayout.CENTER);
       nqf.setBackground(Color.white);
       nqf.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
             System.exit(0);
          }
       });
       nqf.setSize(400, 400);
       nqf.show();
       //nq.addqueen();
       nq.queens(-1);  // remember array subscripts start at 0
       nq.solnumtext.append("Total of " + nq.numsol +
                             " solutions\n" + "Recursive calls: " +
                             nq.timesCalled);
    }
}

