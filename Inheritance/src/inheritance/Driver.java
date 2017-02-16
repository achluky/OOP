/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args)
    {
        Person instructor1 = new Instructor("Umar Bakri", "jl.umar", "Bandung", 30,'L',"Strago","S1", 1000);
        System.out.println(instructor1.toString());
        Student Jj = new Student("Jj", "laguboti", "Sitoluama",21,'L',"32423423423","TI", 5, new StudentReport());
        System.out.println(Jj.toString());
        
    }
}
