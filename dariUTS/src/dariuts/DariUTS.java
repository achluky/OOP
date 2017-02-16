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
public class DariUTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "dapot";
        String b = "dapot";
        System.out.println((a == b));
        String c = new String();
        System.out.println(a == c);
        
        A d = new A(5);
        A e = new A(5);
        System.out.println(d == e);
        System.out.println(d.equals(e));
            
    }
    
}
