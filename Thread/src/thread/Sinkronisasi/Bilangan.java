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
public class Bilangan 
{
    private int angka;
    
    public Bilangan(int angka)
    {
        this.angka=angka;
    }
    public int getAngka()
    {
        return angka;
    }
    public void incrementAngka()
    {
        synchronized(this)
        {
            angka++;
        }
    }
}
