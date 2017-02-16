/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sia.model;

import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table;
/**
 *
 * @author Jayuk
 */
@Entity
@Table(name= "Mahasiswa")
public class Mahasiswa 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nim")
    private int nim;
    @Column(name = "nama")
    private String nama;
    @Column(name="indeksPrestasi")
    private double indeksPrestasi;
    @Column(name="jenisKelamin")
    private String jenisKelamin;

    public Mahasiswa() {
    }
    
    public Mahasiswa(int nim,String nama, double indeksPrestasi, String jenisKelamin) 
    {
        this.nim = nim;
        this.nama = nama;
        this.indeksPrestasi = indeksPrestasi;
        this.jenisKelamin = jenisKelamin;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getIndeksPrestasi() {
        return indeksPrestasi;
    }

    public void setIndeksPrestasi(double indeksPrestasi) {
        this.indeksPrestasi = indeksPrestasi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    
}
