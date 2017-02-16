/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

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
@Table(name = "dokter")
public class Dokter extends Pengguna
{
    @Id
    private int idDokter;
    @Column(name="tarif")
    private double tarif;
    @Column(name="tugas")
    private String tugas;
    @Column(name="ruangKerja")
    private String ruangKerja;
    @Column(name="email")
    private String email;
    @Column(name ="noTelp")
    private int noTelp;

    public Dokter() {
    }

    public Dokter(int idDokter, double tarif, String tugas, String ruangKerja, String email, int noTelp, String nama, String alamat, String jenisKelamin) {
        super(nama, alamat, jenisKelamin);
        this.idDokter = idDokter;
        this.tarif = tarif;
        this.tugas = tugas;
        this.ruangKerja = ruangKerja;
        this.email = email;
        this.noTelp = noTelp;
    }

    public int getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(int noTelp) {
        this.noTelp = noTelp;
    }

    

    

    

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) 
    {
        this.tarif =  tarif;
    }
    public void setEmail(String email)
    {
        this.email =  email;
    }
    public String getEmail()
    {
        return email;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getRuangKerja() {
        return ruangKerja;
    }

    public void setRuangKerja(String ruangKerja) {
        this.ruangKerja = ruangKerja;
    }
    
    
    
        
    
}
