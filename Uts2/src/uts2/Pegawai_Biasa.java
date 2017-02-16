/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts2;

/**
 *
 * @author Bernando Lumban Raja
 */
public class Pegawai_Biasa extends Pegawai 
{    
    private double gaji;

    public Pegawai_Biasa() {
    }

    public Pegawai_Biasa(double gaji, String nik, String nama, int durasiKerja) {
        super(nik, nama, durasiKerja);
        this.gaji = gaji;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    } 
}
