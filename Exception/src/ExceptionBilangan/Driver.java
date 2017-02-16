/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionBilangan;


/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        boolean loop=true;
        while(loop)
        {
        try
        {
            Bilangan.jumlahTotal();
           loop = false;
        }
        catch (ArrayIndexOutOfBoundsException aibe)
        {
            System.out.println("Error saat pengambilan indeks bilangan dari list");
            System.out.println(aibe);
        }
        catch (ArithmeticException ae)
        {
            System.out.println("Kesalahan aritmatik");
            System.out.println(ae);
        }
        }
    }
}
