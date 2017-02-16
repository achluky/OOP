/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype.pkg2;

/**
 *
 * @author Jayuk
 */
public class Rectangle extends Shape
{
    public Rectangle()
    {
        type = "Rectangle";
    }
    @Override
    void draw() 
    {
        System.out.println("inside Rectangle::draw() method.");
    }
    
}
