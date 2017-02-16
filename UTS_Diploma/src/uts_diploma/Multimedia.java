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
public class Multimedia extends Materi
{
    private String durasi;
    
    public String getDurasi()
    {
        return durasi;
    }
    public void setDurasi(String durasi)
    {
        this.durasi = durasi;
    }
    @Override
    public void openFile()
    {
        System.out.println("Tampilkan dengan menggunakan GOM Player");
    }
}
