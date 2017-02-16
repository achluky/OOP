/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akademik;

import java.io.Serializable;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa implements Serializable
{
    private String nama;
    private String nim;
    
    public Mahasiswa()
    {
        
    }

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    @Override
    public String toString()
    {
        return "MHS : Nama :"+nama+"\tNim :"+nim;
    }
}
