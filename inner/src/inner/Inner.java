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
class Outer_Demo
{
   public int kk=2;
   
   //inner class
   public class Inner_Demo
   {
       
       int kk=0;
       int jj=kk;
       //num=0;
      public void print()
      {	   
         System.out.println("This is an inner class");
      }
   }
   //Accessing he inner class from the method within
   void display_Inner()
   {
       
      Inner_Demo inner = new Inner_Demo();
      System.out.println(inner.jj+"jaya bajingan");
      inner.print();
   }
}
