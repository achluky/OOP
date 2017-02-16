/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubus.controller;

import java.io.IOException;
import kubus.model.Kubus;
import kubus.view.KubusViewConsole;

/**
 *
 * @author Jayuk
 */
public class KubusController 
{
    private KubusViewConsole viewConsole;
    private Kubus modelConsole;
    
    public KubusController(Kubus kubus, KubusViewConsole view)
    {
        this.modelConsole = kubus;
        viewConsole = view;
        kubus.addObserver(view);
    }
    
    public void mintaDuluRusuk() throws IOException
    {
        int rusuk = viewConsole.mintaDuluInputanRusuk();
        modelConsole.setRusuk(rusuk);
    }
    public double getVolume()
    {
        int rusuk = modelConsole.getRusuk();
        return rusuk*rusuk * rusuk;
    }
    public double LuasPermukaan()
    {
        int rusuk = modelConsole.getRusuk();
        return rusuk*6;
    }
    
}
