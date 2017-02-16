/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public  class Matriks 
{
    static int[][] data;
    static int[][] result;
    static int m, n;
    
    public Matriks()
    {
        
    }
    
    public static void  setUkuranMatriks(int m, int n)
    {
        data = new int[m][n];
        result =  new int[1][n];
        Matriks.m = m;
        Matriks.n = n;
    }
    public static int getM()
    {
        return m;
    }
    public static int getN()
    {
        return n;
    }
}
