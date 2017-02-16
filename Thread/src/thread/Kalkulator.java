/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

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
        for(int i=0;i<=100000000;i++)
        {
            bilangan= bilangan + bilangan -1 +1 /10 * 10 %2;
        }
    }
}
