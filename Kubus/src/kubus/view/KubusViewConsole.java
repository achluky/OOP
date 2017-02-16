/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubus.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;
import kubus.model.Kubus;

/**
 *
 * @author Jayuk
 */
public class KubusViewConsole implements Observer
{
    private Kubus kubus;
    
    public KubusViewConsole()
    {
        //this.kubus = kubus;
    }
    
    public void tampilkanKubusVersiConsole()
    {
        System.out.println("Kubus   :");
        System.out.println("Rusuk   :"+kubus.getRusuk());
        System.out.println("Volumen :"+kubus.getRusuk()*kubus.getRusuk()*kubus.getRusuk());
        System.out.println("L.Per   :"+kubus.getRusuk()*6);
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        if(o == kubus)
        {
            kubus = (Kubus) o;
            tampilkanKubusVersiConsole();
            System.out.println("Rusuk diubah");
        }
    }
    
    public int mintaDuluInputanRusuk() throws IOException
    {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(in);
        System.out.print("Masukkan Nilai Rusuk    :");
        return Integer.parseInt(console.readLine());
    }
    
}
