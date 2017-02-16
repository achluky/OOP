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
@Table(name = "pasienonline")
public class PasienOnline implements Serializable 
{
    @Id
    @Column(name = "idPasienOnline")
    private int idPasienOnline;
    @Column(name="namaPasienOnline")
    private String namaPasienOnline;
    @Column(name="alamatPasienOnline")
    private String alamatPasienOnline;
    @Column(name = "tanggalLahirPasienOnline")
    private String tanggalLahirPasienOnline;
    @Column(name = "riwayatPenyakitPasienOnline")
    private String riwayatPenyakitPasienOnline;
    @Column(name="jenisKelaminPasienOnline")
    private String jenisKelaminPasienOnline;
    @Column(name = "keluhanPasienOnline")
    private String keluhanPasienOnline;
    @Column(name ="sudahDiperiksaDokter")
    private String sudahDiperiksaDokter;
    @Column(name = "penyakitPasienOnline")
    private String penyakitPasienOnline;
    @Column(name = "catatanPasienOnline")
    private String catatanPasienOnline;
    @Column(name = "tujuanRuangan")
    private String tujuanRuangan=null;

    public PasienOnline() 
    {
        
    }

    public PasienOnline(int idPasienOnline, String namaPasienOnline, String alamatPasienOnline, String tanggalLahirPasienOnline, String riwayatPenyakitPasienOnline, String jenisKelaminPasienOnline, String keluhanPasienOnline, String sudahDiperiksaDokter, String penyakitPasienOnline, String catatanPasienOnline) {
        this.idPasienOnline = idPasienOnline;
        this.namaPasienOnline = namaPasienOnline;
        this.alamatPasienOnline = alamatPasienOnline;
        this.tanggalLahirPasienOnline = tanggalLahirPasienOnline;
        this.riwayatPenyakitPasienOnline = riwayatPenyakitPasienOnline;
        this.jenisKelaminPasienOnline = jenisKelaminPasienOnline;
        this.keluhanPasienOnline = keluhanPasienOnline;
        this.sudahDiperiksaDokter = sudahDiperiksaDokter;
        this.penyakitPasienOnline = penyakitPasienOnline;
        this.catatanPasienOnline = catatanPasienOnline;
    }

    public String getTujuanRuangan() {
        return tujuanRuangan;
    }

    public void setTujuanRuangan(String tujuanRuangan) {
        this.tujuanRuangan = tujuanRuangan;
    }

    
    
    public String getPenyakitPasienOnline() {
        return penyakitPasienOnline;
    }

    public void setPenyakitPasienOnline(String penyakitPasienOnline) {
        this.penyakitPasienOnline = penyakitPasienOnline;
    }

    public String getCatatanPasienOnline() {
        return catatanPasienOnline;
    }

    public void setCatatanPasienOnline(String catatanPasienOnline) {
        this.catatanPasienOnline = catatanPasienOnline;
    }

    

    public int getIdPasienOnline() {
        return idPasienOnline;
    }

    public void setIdPasienOnline(int idPasienOnline) {
        this.idPasienOnline = idPasienOnline;
    }

    public String getNamaPasienOnline() {
        return namaPasienOnline;
    }

    public void setNamaPasienOnline(String namaPasienOnline) {
        this.namaPasienOnline = namaPasienOnline;
    }

    public String getAlamatPasienOnline() {
        return alamatPasienOnline;
    }

    public void setAlamatPasienOnline(String alamatPasienOnline) {
        this.alamatPasienOnline = alamatPasienOnline;
    }

    public String getTanggalLahirPasienOnline() {
        return tanggalLahirPasienOnline;
    }

    public void setTanggalLahirPasienOnline(String tanggalLahirPasienOnline) {
        this.tanggalLahirPasienOnline = tanggalLahirPasienOnline;
    }

    public String getRiwayatPenyakitPasienOnline() {
        return riwayatPenyakitPasienOnline;
    }

    public void setRiwayatPenyakitPasienOnline(String riwayatPenyakitPasienOnline) {
        this.riwayatPenyakitPasienOnline = riwayatPenyakitPasienOnline;
    }

    public String getJenisKelaminPasienOnline() {
        return jenisKelaminPasienOnline;
    }

    public void setJenisKelaminPasienOnline(String jenisKelaminPasienOnline) {
        this.jenisKelaminPasienOnline = jenisKelaminPasienOnline;
    }

    public String getKeluhanPasienOnline() {
        return keluhanPasienOnline;
    }

    public void setKeluhanPasienOnline(String keluhanPasienOnline) {
        this.keluhanPasienOnline = keluhanPasienOnline;
    }

    public String getSudahDiperiksaDokter() {
        return sudahDiperiksaDokter;
    }

    public void setSudahDiperiksaDokter(String sudahDiperiksaDokter) {
        this.sudahDiperiksaDokter = sudahDiperiksaDokter;
    }
    
    
}
