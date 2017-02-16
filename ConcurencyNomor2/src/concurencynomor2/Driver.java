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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] data =  {7,8,15,20,21,22};
        for(int i = 0 ; i<data.length;i++)
        {
            if(data[i]%7==0)
            {
                ThreadPembagian threadPembagian =  new ThreadPembagian(data[i], i+1);
                Thread thread =  new Thread(threadPembagian);
                thread.setPriority(10);
                thread.start();
            }
            else if(data[i]%5==0)
            {
                ThreadPengurangan threadPengurangan =  new ThreadPengurangan(data[i], i+1);
                Thread thread =  new Thread(threadPengurangan);
                thread.setPriority(3);
                thread.start();
            }
            else if(data[i]%3==0)
            {
                ThreadPerkalian threadPerkalian =  new ThreadPerkalian(data[i], i+1);
                Thread thread =  new Thread(threadPerkalian);
                thread.setPriority(2);
                thread.start();
            }
            else if(data[i]%2==0)
            {
                ThreadPenjumlahan threadPenjumlahan =  new ThreadPenjumlahan(data[i], i+1);
                Thread thread =  new Thread(threadPenjumlahan);
                thread.setPriority(1);
                thread.start();
            }
            
            
            
        }
    }
    
}
