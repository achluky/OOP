/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_diploma;

/**
 *
 * @author Jayuk
 */
public abstract class Materi 
{
    private final String nim = "11S14057";
    private final String nama   ="Jaya Haryono Manik";
    private final   int angkatan    = 2014;
    private String deksripsi;
    private int idMateri;
    private String judul;
    private String namaFile;

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    public int getIdMateri() {
        return idMateri;
    }

    public void setIdMateri(int idMateri) {
        this.idMateri = idMateri;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }
    
    public abstract void openFile();
}
