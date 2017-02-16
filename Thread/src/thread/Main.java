/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author Jayuk
 */
public class Main 
{
    public static void main(String[] args) throws InterruptedException 
    {
            Kalkulator kalkulator =  new Kalkulator(1);
            Thread thread1 = new Thread(kalkulator);
          
            thread1.start();
            try
            {
                thread1.join();
            }
            catch(InterruptedException ie)
            {
            }
    }
}
