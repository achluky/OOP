/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan;

import PerpustakaanDAO.AnggotaDAOImpl;
import PerpustakaanDAO.BukuDAOImpl;
import java.io.IOException;

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
        Anggota anggota;
        Buku buku;
        AnggotaDAOImpl anggotaDaoImpl = new AnggotaDAOImpl();
        BukuDAOImpl bukuDaoImpl = new BukuDAOImpl();
        buku = new Buku("123", "bokep", "andi", "aspa 1", "imajinasi tinggi");
        anggota = new Anggota("11s14057", "ajay", "tampan", "ugfye", "sjbfiuef", "sbefsev", "sebfyusvef");
        
        bukuDaoImpl.insertBuku(buku);
        anggotaDaoImpl.insertAnggota(anggota);
        
    }
    
}
