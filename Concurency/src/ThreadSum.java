/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class ThreadSum implements Runnable
{
    int numOfThread=0;

    public ThreadSum(int numOfThread) 
    {
        this.numOfThread = numOfThread;
    }

    
    
    @Override
    public void run() 
    {
        int resultTemp = 0;
        for(int i =0;i<Matriks.m;i++)
        {
            resultTemp += Matriks.data[i][numOfThread];
        }
        System.out.println("Thread "+numOfThread +"  "+resultTemp);
        Matriks.result[1][numOfThread] = resultTemp;
    }
    
}
