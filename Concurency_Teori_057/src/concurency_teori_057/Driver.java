/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurency_teori_057;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        public static void main(String[] args) {
        Matriks matriks = new Matriks();
        MyThread a = new MyThread(matriks, 0);
        MyThread b = new MyThread(matriks, 1);
        MyThread c = new MyThread(matriks, 2);
        a.start();
        b.start();
        c.start();
        try{
            a.join();
            b.join();
            c.join();
        }
        catch(InterruptedException ie){
        
        }
        matriks.getHasil();
                
    }
    }
    
}
