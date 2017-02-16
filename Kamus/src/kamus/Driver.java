/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamus;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        //String bahasa = "harus#must , have to, should";
        //String[] kata = new String[2];1
        //kata = bahasa.split("#");
        //System.out.println(kata[0]);
        System.out.println("________KAMUS_______");
        boolean Continue=true;
        while(Continue)
        {
            System.out.println("1. Tambah Kata baru");
            System.out.println("2. Cari terjemahan");
            System.out.println("0. Keluar");
            Scanner in = new Scanner(System.in);
            int pilihan = in.nextInt();
            if(pilihan ==0)
            {
                Continue=false;
            }
            else
            {
                if(pilihan == 1)
                {
                    System.out.println("Masukkan kata inggrisnya");
                    String english=in.next();
                    System.out.println("Masukkan artinya :");
                    String indonesia =in.next();
                    System.out.println(Kamus.tambahKata(english, indonesia));
                }
                else if(pilihan == 2)
                {
                    System.out.println("Masukkan kata inggrisnya");
                    String english=in.next();
                    System.out.println(Kamus.terjemahkan(english));
                }
                else
                {
                    System.out.println("Masukan Salah");
                }
            }
        }
    }
    
}
