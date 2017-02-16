/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyfactory;

/**
 *
 * @author Jayuk
 */
public class ToyFactory extends AbstractFactory
{

    @Override
    public Toy getProduct(String toy) 
    {
        if (toy.equalsIgnoreCase("Boneka"))
            return new Boneka();
        else if (toy.equalsIgnoreCase("Buku"))
            return new Buku();
        else if (toy.equalsIgnoreCase("RemoteControl"))
            return new RemoteControl();
        else
            return null;
    }
    
}
