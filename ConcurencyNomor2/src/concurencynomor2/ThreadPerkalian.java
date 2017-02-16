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
public class ThreadPerkalian implements Runnable
{
    private int bilangan;
    private int threadNumber;
    public ThreadPerkalian(int bilangan,int threadNumber) 
    {
        this.bilangan = bilangan;
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() 
    {
        int totalTemp=0;
        for (int i = 1; i <= bilangan/3; i++) 
        {
            if(totalTemp==0)
            {
                totalTemp=1;
                totalTemp =  totalTemp * (3*i);
            }
            else
            {
                totalTemp =  totalTemp * (3*i);
            }
        }
        System.out.println("Thread : "+threadNumber+" hasil = "+totalTemp+" (Perkalian)");
    }
    
}
