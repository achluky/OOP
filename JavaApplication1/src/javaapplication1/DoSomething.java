/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Jayuk
 */
public class DoSomething {
    public static void main (String[] args)
    {
         int x = 3 ;
         String name = "Dark";
         x = x * 17;
         System.out.println("x is " + x);
         double d = Math.random();
         System.out.println("d is " + d);
         
         while(x > 12)
         {
             x = x - 1;
             System.out.println("x is " + x);
         }
    }
}
