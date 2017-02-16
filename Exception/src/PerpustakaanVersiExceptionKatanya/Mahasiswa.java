/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanVersiExceptionKatanya;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa 
{
    ArrayList<Buku> listBukuYangDiambil =  new ArrayList<>();

    public Mahasiswa() {
    }
    
    public void cariBuku(String id) throws BukuTidakAdaEksepsi
    {
        boolean ada=false;
        Buku buku = Perpustakaan.cariBuku(id);
        if (buku != null)
        {
            listBukuYangDiambil.add(buku);
            ada = true;
        }
        if(!ada)
        {
            System.out.println("Buku tidak ada");
        }
    }
    
    public void bacaBuku(String id) throws BukuBelumDiambilEksepsi
    {
        boolean ada = false;
        for(Buku buku : listBukuYangDiambil)
        {
            if(id.equalsIgnoreCase(buku.id))
            {
                System.out.println("Buku "+buku.id+" Dibaca");
                ada = true;
            }
            else
            {
                throw new BukuBelumDiambilEksepsi(id);
            }
            
        }
        if(!ada)
            System.out.println("Buku belum diambil");
    }
    
}
