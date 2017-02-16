/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jayuk
 */
@Entity
@Table(name="petugas")        
public class Petugas extends Pengguna
{
    @Id
    @Column(name ="idPetugas")
    int idPetugas;
    @Column(name ="emailPetugas")
    private String emailPetugas;
    @Column(name ="nomorTelepon")
    private int nomorTelepon;

    public Petugas() {
    }

    public Petugas(int idPetugas, String emailPetugas, int nomorTelepon, String nama, String alamat, String jenisKelamin) {
        super(nama, alamat, jenisKelamin);
        this.idPetugas = idPetugas;
        this.emailPetugas = emailPetugas;
        this.nomorTelepon = nomorTelepon;
    }

    public int getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(int idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getEmailPetugas() {
        return emailPetugas;
    }

    public void setEmailPetugas(String emailPetugas) {
        this.emailPetugas = emailPetugas;
    }

    public int getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(int nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    
    
}
