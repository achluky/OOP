/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan;

import java.io.Serializable;

/**
 *
 * @author Jayuk
 */
public class Anggota implements Serializable
{
    private String id;
    private String nama;
    private String pekerjaan;
    private String tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private String agama;
    static int jumlahAnggota;
    
    Anggota()
    {
        
    }
    
    Anggota (String id, String nama, String pekerjaan, String tanggalLahir, String jenisKelamin, String alamat, String agama)
    {
        this.id = id;
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.agama = agama;
    }
    public String getID()
    {
        return id;
    }
    public void setID(String id)
    {
        this.id = id;
    }
    public String getNama()
    {
        return nama;
    }
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    public String getPekerjaan()
    {
        return pekerjaan;
    }
    public void setPekerjaan(String pekerjaan)
    {
        this.pekerjaan = pekerjaan;
    }
    public String getTanggalLahir()
    {
        return tanggalLahir;
    }
    public void setTanggalLahir(String tanggalLahir)
    {
        this.tanggalLahir = tanggalLahir;
    }
    public String getJenisKelamin()
    {
        return jenisKelamin;
    }
    public void setJenisKelamin(String jenisKelamin)
    {
        this.jenisKelamin = jenisKelamin;
    }
    public String getAlamat()
    {
        return alamat;
    }
    public void setAlamat(String alamat)
    {
            this.alamat = alamat;
    }
    public String getAgama()
    {
        return agama;
    }
    public void setAgama(String agama)
    {
        this.agama = agama;
    }
    public int getJumlahAnggota()
    {
        return jumlahAnggota;
    }
    public boolean checkJenisKelamin()
    {
        switch(jenisKelamin)
        {
            case"L": return true;
            case"P": return true;
            default: return false;
        }
    }
    public boolean checkPekerjaan()
    {
        switch(pekerjaan)
        {
            case"Mahasiswa": return true;
            case"Dosen" : return true;
            case"Staf" : return true;
            default: return false;
        }
    }
    @Override
    public String toString()
    {
        return "ID\t:"+id+"Nama\t:"+nama+"Pekerjaan\t:"+pekerjaan+"Tanggal Lahir\t:"+tanggalLahir+"JenisKelamin\t:"+jenisKelamin+
        "Alamat\t:"+alamat+
        "Agama\t:"+agama;
    }
}
