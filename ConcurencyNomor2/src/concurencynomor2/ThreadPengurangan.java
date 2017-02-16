/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurencynomor2;

/**
 *
 * @author Jayuk
 */
public class ThreadPengurangan implements Runnable
{
    private int bilangan;
    private int threadNumber;
    public ThreadPengurangan(int bilangan,int threadNumber) 
    {
        this.bilangan = bilangan;
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() 
    {
        int totalTemp=0;
        for (int i = 1; i <= bilangan; i++) 
        {
            totalTemp = totalTemp + (100-i);
        }
        System.out.println("Thread : "+threadNumber+" hasil = "+totalTemp+" (Pengurangan)");
    }
}
