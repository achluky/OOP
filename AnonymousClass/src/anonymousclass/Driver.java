/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousclass;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Animal animal = new Animal()
        {
            @Override
            public void sound() 
            {
                System.out.println("mi mi mi mi");
            }
           
        };
        animal.sound();
        Animal babi = new Babi()
        {
            
        };
        babi.sound();
    }
    
}

class Babi extends Animal
{

    @Override
    public void sound() 
    {
        System.out.println("ngok ");
    }
    
}