/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dariuts;

/**
 *
 * @author Jayuk
 */
public class A 
{
    private int counter;
    public A(int counter)
    {
        this.counter = counter;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof A)
        {
            A a = (A)obj;
            return counter > a.counter;
        }
        return false;
    }
    
}
