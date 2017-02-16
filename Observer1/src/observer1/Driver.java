/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer1;

/**
 *
 * @author Jayuk
 */
public class Driver {

    
    public static void main(String[] args) 
    {
        ObservableValue ov = new ObservableValue(10);
        ObserverObject oo =  new ObserverObject();
        ov.addObserver(oo);
        ov.setI(30);
        
        if(ov.hasChanged())
            System.out.println("benar");
    }
    
}
