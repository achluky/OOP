/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import akademik.Mahasiswa;
import akademik.dao.MahasiswaDaoImpl;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class DriverObjectStream 
{
    public static void main(String[] args) 
    {
        Mahasiswa m;
        MahasiswaDaoImpl mdi =  new MahasiswaDaoImpl();
        m = new Mahasiswa("Dapot", "123");
        mdi.insertMahasiswa(m);
        m = new Mahasiswa("Udin","124");
        mdi.insertMahasiswa(m);
        
        System.out.println("Searching data mahasiswa bernim 124");
        Mahasiswa ms = mdi.getMahasiswa("124");
        
        System.out.println(ms);
        
        List<Mahasiswa> mss = mdi.getAllMahasiswa();
        System.out.println("Daftar mahasiwa");
        
        for(Mahasiswa mm : mss)
        {
            System.out.println(mm);
        }
    }
}
