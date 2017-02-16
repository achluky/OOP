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
public class Video extends Multimedia implements Fitur
{
    @Override
    public String toString()
    {
        System.out.println("Deskripsi   :"+getDeksripsi());
        System.out.println("ID Materi   :"+getIdMateri());
        System.out.println("Judul       :"+getJudul());
        System.out.println("Nama File   :"+getNamaFile());
        System.out.println("Durasi      :"+getDurasi());
        return null;
    }
}
