/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overload;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) {
        Overload jj = new Overload();
        double result;
        jj.demo(10);
        jj.demo(10, 20);
        result = jj.demo(5.0);
        System.out.println(result);
    }
}
