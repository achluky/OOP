/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.ThreadFactrory;

import thread.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jayuk
 */
public class Kalkulator implements Runnable
{
    private int bilangan;
    
    public Kalkulator(int bilangan)
    {
        this.bilangan=bilangan;
    }

    @Override
    public void run() 
    {
        for(int i=0;i<=10;i++)
        {
            System.out.println(Thread.currentThread().getName()+ " "+ bilangan + " x " +i + " = " +(bilangan*i));
            System.out.println(Thread.currentThread().getName()+ " akan berhenti selama satu detik");
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
