/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer1;

import java.util.Observable;

/**
 *
 * @author Jayuk
 */
public class ObservableValue extends Observable
{
    int i = 0;

    public ObservableValue(int i) 
    {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) 
    {
        this.i = i;
        setChanged();
        notifyObservers();
    }
    
    
}
