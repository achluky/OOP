/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gracia
 */
@Entity
@Table(name = "obatterpilih")
public class ObatTerpilih implements Serializable 
{
    @Id
    @Column(name = "idObatTerpilih")
    private int idobatTerpilih;
    @Column(name = "idPasienOnline")
    private int idPasienOnline;
    @Column(name= "namaObat")
    private String namaObat;
    @Column(name="hargaObat")
    private double hargaObat;
    @Column(name = "komposisi")
    private String kompisisi;
    @Column(name = "jenisObat")
    private String jenisObat;
    @Column(name = "takaran")
    private String takaran;

    public ObatTerpilih() {
    }

    public ObatTerpilih(int idobatTerpilih, int idPasienOnline, String namaObat, double hargaObat, String kompisisi, String jenisObat, String takaran) {
        this.idobatTerpilih = idobatTerpilih;
        this.idPasienOnline = idPasienOnline;
        this.namaObat = namaObat;
        this.hargaObat = hargaObat;
        this.kompisisi = kompisisi;
        this.jenisObat = jenisObat;
        this.takaran = takaran;
    }

    public int getIdobatTerpilih() {
        return idobatTerpilih;
    }

    public void setIdobatTerpilih(int idobatTerpilih) {
        this.idobatTerpilih = idobatTerpilih;
    }

    public int getIdPasienOnline() {
        return idPasienOnline;
    }

    public void setIdPasienOnline(int idPasienOnline) {
        this.idPasienOnline = idPasienOnline;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public double getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }

    public String getKompisisi() {
        return kompisisi;
    }

    public void setKompisisi(String kompisisi) {
        this.kompisisi = kompisisi;
    }

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }

    public String getTakaran() {
        return takaran;
    }

    public void setTakaran(String takaran) {
        this.takaran = takaran;
    }
}
