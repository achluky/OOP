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
public class Temp
{
    public int N = 16;
    int col=0;
    int i=0;
    public Temp(int N) 
    {
        this.N=N;
    }

    
    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                if(board[i][j]==-1)
                    System.out.print(" " + board[i][j]+ "");
            else
                    System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }
    
    public void placeMarker(int board[][],int row, int col)
    {
        int i;
        int j;
        for(i=col;i<N;i++)
        {
            board[row][i]=-1;
            printSolution(board);
        }
        for (i=row, j=col; i<N && j<N; i++, j++)
        {
            board[i][j]= -1;
            printSolution(board);
        }
        for (i=row, j=col; i>0 && j<N; i--, j++)
        {
            board[i][j]= -1;
            printSolution(board);
        }
    }

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placeed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col)
    {
        if(board[row][col] == -1)
            return false;
        if(board[col][row]== 1)
            return false;
        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
    boolean solveNQUtil(int board[][], int col)
    {
        /* base case: If all queens are placed
           then return true */
        if (col >= N)
            return true;

        /* Consider this column and try placing
           this queen in all rows  one by one */
        for (i=0; i < N; i++)
        {
            /* Check if queen can be placed on
               board[i][col] */
            if (isSafe(board, i, col))
            {
                /* Place this queen in board[i][col] */
                
                placeMarker(board, i, col);
                board[i][col] = 1;
                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                {
                    return true;
                }

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
                i++;
                solveNQUtil(board, col);
                
            }
        }

        /* If queen can not be place in any row in
           this colum col, then return false */
        return false;
    }

    /* This function solves the N Queen problem using
       Backtracking.  It mainly uses  solveNQUtil() to
       solve the problem. It returns false if queens
       cannot be placed, otherwise return true and
       prints placement of queens in the form of 1s.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    boolean solveNQ()
    {
        int board [][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                board[i][j]=0;
            }
        }

        if (solveNQUtil(board, col) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }
        System.out.println("Solusi Ditemukan");
        removeMarker(board);
        printSolution(board);
        return true;
    }
    public void removeMarker(int board[][])
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(board[j][i] == -1)
                {
                    board[j][i]=0;
                }
            }
        }
    }
    // driver program to test above function
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Ukuran Papan Catur : ");
        int jumlahQueen = in.nextInt();
        Temp Queen = new Temp(jumlahQueen);
        Queen.solveNQ();
    }
}
// This code is contributed by Abhishek Shankhadhar
