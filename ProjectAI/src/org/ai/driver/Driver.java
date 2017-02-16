/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ai.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.ai.algorithm.NQueenWithForwardChecking;
import org.ai.algorithm.NQuenWithBackTracking;
import org.ai.algorithm.NQueenWithGenetika;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        while(true)
        {
            System.out.println("Jenis Algorithm");
            System.out.println("1. BackTracking");
            System.out.println("2. Forward Checking");
            System.out.println("3. Genetika");
            System.out.println("Jenis Algoritma yang ingin digunakan ?");
            Scanner in =  new Scanner(System.in);
            int pilihan =  in.nextInt();
            if(pilihan == 1)
            {
                System.out.println("Masukkan Ukuran Board   : ");
                int ukuranBoard = in.nextInt();
                NQuenWithBackTracking nQueenBackTrack = new NQuenWithBackTracking(ukuranBoard);
                nQueenBackTrack.solveIt();
                nQueenBackTrack.printNumSols();
            }
            else if(pilihan == 2)
            {
                System.out.print("Masukkan Ukuran Board   : ");
                NQueenWithForwardChecking nQueenForwardChecking = new NQueenWithForwardChecking();
                int ukuranBoard =in.nextInt();
                int[] X = new int[ukuranBoard];
                nQueenForwardChecking.placeNQueens(X,ukuranBoard,0);
                nQueenForwardChecking.printResult(ukuranBoard);
            }
            else if(pilihan == 3)
            {
                System.out.println("Masukkan Ukuran Board   : ");
                int ukuranBoard = in.nextInt();
                NQueenWithGenetika nQueen = new NQueenWithGenetika(ukuranBoard);
                nQueen.algorithm();
            }
            else
            {
                System.out.println("Inputan Salah");
            }
        }
    }
}
