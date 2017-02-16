/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.Sinkronisasi;

/**
 *
 * @author Jayuk
 */
public class MyThread extends Thread
{
    private Bilangan bilangan;
    
    public MyThread(Bilangan bilangan)
    {
        this.bilangan = bilangan;
    }
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            bilangan.incrementAngka();
        }
    }
    
}
