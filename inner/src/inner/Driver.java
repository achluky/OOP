/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inner;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
   public static void main(String args[]){
      //Instantiating the outer class 
      Outer_Demo outer = new Outer_Demo();
      //Accessing the display_Inner() method.
      outer.display_Inner();
   }

}
