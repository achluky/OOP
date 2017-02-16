/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

import java.util.ArrayList;
import java.util.List;
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
@Table(name="pasien")
public class Pasien extends Pengguna
{
    @Id
    @Column(name = "idPasien")
    private int idPasien;
    @Column(name = "tanggalLahirPasien")
    private String tanggalLahirPasien;
    @Column(name = "riwayatPenyakit")
    private String riwayatPenyakit;

    public Pasien() {
    }

    public Pasien(int idPasien, String tanggalLahirPasien, String riwayatPenyakit, String nama, String alamat, String jenisKelamin) {
        super(nama, alamat, jenisKelamin);
        this.idPasien = idPasien;
        this.tanggalLahirPasien = tanggalLahirPasien;
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getTanggalLahir() {
        return tanggalLahirPasien;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahirPasien = tanggalLahir;
    }

    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }
    
    
}
