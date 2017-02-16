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
public class ThreadPembagian implements Runnable
{
    private int bilangan;
    private int threadNumber;
    public ThreadPembagian(int bilangan,int threadNumber) 
    {
        this.bilangan = bilangan;
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() 
    {
        int totalTemp=0;
        totalTemp = 700/bilangan;
        System.out.println("Thread : "+threadNumber+" hasil = "+totalTemp+" (Pembagian)");
    }
}
