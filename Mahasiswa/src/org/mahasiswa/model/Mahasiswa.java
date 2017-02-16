/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mahasiswa.model;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Observable
{
    String nim;
    String nama;
    double ipk;
    List<String> mataKuliah= null;
    List<Double> nilai=null;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, double ipk, List<String> mataKuliah, List<Double> nilai) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        setChanged();
        notifyObservers();
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        setChanged();
        notifyObservers();
        this.nama = nama;
    }

    public double getIpk() {
        for(double nilaitemp : nilai)
        {
            ipk = (ipk + nilaitemp)/2;
        }
        return ipk;
    }

    public List<String> getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(List<String> mataKuliah) {
        setChanged();
        notifyObservers();
        this.mataKuliah = mataKuliah;
    }

    public List<Double> getNilai() {
        return nilai;
    }

    public void setNilai(List<Double> nilai) {
        setChanged();
        notifyObservers();
        this.nilai = nilai;
    }
    
    
    
}
