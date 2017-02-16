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
public class Jurnal extends Buku implements Fitur
{
    private String edisi;
    private String namaJurnal;
    private int tahun;
    private String volume;

    public String getEdisi() {
        return edisi;
    }

    public void setEdisi(String edisi) {
        this.edisi = edisi;
    }

    public String getNamaJurnal() {
        return namaJurnal;
    }

    public void setNamaJurnal(String namaJurnal) {
        this.namaJurnal = namaJurnal;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    @Override
    public String toString()
    {
        System.out.println("ISBN    :"+getISBN());
        System.out.println("Penerbit:"+getPenerbit());
        System.out.println("Edisi   :"+getEdisi());
        System.out.println("Nama jurnal :"+getNamaJurnal());
        System.out.println("Tahun       :"+getTahun());
        System.out.println("Volume      :"+getVolume());
        return null;
    }
    
}
