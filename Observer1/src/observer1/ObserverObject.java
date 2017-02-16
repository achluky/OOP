/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer1;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jayuk
 */
public class ObserverObject implements Observer
{

    @Override
    public void update(Observable o, Object arg) 
    {
        System.out.println("Diupdate");
    }
    
}
