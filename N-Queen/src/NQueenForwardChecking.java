/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class NQueenForwardChecking
{
    int board[][]= new int [4][4];
    int temp=0;
    void printSolution()
    {
        for (int y = 0; y < board.length; y++)
        {
            for (int x = 0; x < board.length; x++)
                System.out.print(" " + board[x][y]
                                 + " ");
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
    public boolean isSafe(int x,int y)
    {
        if(board[x][y]==-1)
            return false;
        return true;
    }
    public void placeMarker(int xTemp,int yTemp)
    {
        for(int x=xTemp+1;x<board.length;x++)
        {
            board[x][yTemp] = -1;
        }
        printSolution();
        
        for(int x=xTemp+1,y=yTemp+1;x<board.length&&y<board.length;x++,y++)
        {
            board[x][y]=-1;
        }
        printSolution();
        
        for(int x=xTemp+1,y=yTemp-1;x<board.length && y>0;x++,y--)
        {
            board[x][y]=-1;
        }
        printSolution();
    }
    public void solveUtil(int temp)
    {
        int queen =0;
        //board[x][y]
        //board[0][temp]=1;
        
        for(int x=temp;x<board.length;x++)
        {
            for(int y=0;y<board.length;y++)
            {
                if(isSafe(x, y))
                {
                    placeMarker(x,y);
                    board[x][y]=1;
                    queen++;
                    break;
                }
            }
        }
        if(queen<board.length)
        {
            System.out.println("Mengulangi");
            temp++;
            solveUtil(temp);
        }
        printSolution();
    }
    public void solve()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
                board[i][j]=0;
        }
    }
    public static void main(String args[])
    {
        NQueenForwardChecking Nqueen = new NQueenForwardChecking();
        Nqueen.solve();
    }
}
// This code is contributed by Abhishek Shankhadhar
