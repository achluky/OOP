/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

import java.io.Serializable;
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
@Table(name = "faktur")
public class Faktur implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFaktur;
    @Column(name = "hargaObat")
    private double hargaObat;
    @Column(name ="biayaDokter")
    private double biayaDokter;
    @Column(name = "daftarIdDokter")
    private String daftarIdDokter;
    @Column(name ="daftarIdObat")
    private String daftarIdObat;

    public Faktur() {
    }

    public Faktur(int idFaktur, double hargaObat, double biayaDokter, String daftarIdDokter, String daftarIdObat) {
        this.idFaktur = idFaktur;
        this.hargaObat = hargaObat;
        this.biayaDokter = biayaDokter;
        this.daftarIdDokter = daftarIdDokter;
        this.daftarIdObat = daftarIdObat;
    }

    public int getIdFaktur() {
        return idFaktur;
    }

    public void setIdFaktur(int idFaktur) {
        this.idFaktur = idFaktur;
    }

    public double getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }

    public double getBiayaDokter() {
        return biayaDokter;
    }

    public void setBiayaDokter(double biayaDokter) {
        this.biayaDokter = biayaDokter;
    }

    public String getDaftarIdDokter() {
        return daftarIdDokter;
    }

    public void setDaftarIdDokter(String daftarIdDokter) {
        this.daftarIdDokter = daftarIdDokter;
    }

    public String getDaftarIdObat() {
        return daftarIdObat;
    }

    public void setDaftarIdObat(String daftarIdObat) {
        this.daftarIdObat = daftarIdObat;
    }
    
    
}
