/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubus.model;

import java.util.Observable;

/**
 *
 * @author Jayuk
 */
public class Kubus extends Observable
{
    private int rusuk;
    
    public Kubus(int rusuk)
    {
        this.rusuk = rusuk;
    }
    
    public int  getRusuk()
    {
        return rusuk;
    }
    
    public void setRusuk(int rusuk)
    {
        this.rusuk = rusuk;
        System.out.println("Rusuk diubah di model");
        setChanged();
        synchronized(this)
        {
            notifyAll();
        }
        notifyObservers();
    }
    
}
