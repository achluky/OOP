package basic;

import java.util.*;
/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //memanggil constructor untuk menciptakan objek
        Mahasiswa m= new Mahasiswa();
        
        //merubah nama dari objek mahasiswa
        m.nama = "Andi";
        m.nim = "1201013";
        m.ubahNama("Dapot");
        //m.ubahNamaDosenWali("Polma");
        Mahasiswa.ubahNamaDosenWali("Polma");
        
        //mencetak informasi dari objek mahasiswa
        System.out.println("N:" +m.nama + "\tNim" + m.nim);
    }
}
