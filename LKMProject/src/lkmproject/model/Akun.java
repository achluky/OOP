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
 * @author gracia
 */
@Entity
@Table(name = "akun")
public class Akun 
{
    @Id
    @Column(name = "idPengguna")
    private int idPengguna;
    @Column(name = "passwordPengguna")
    private String passwordPengguna;
    @Column(name = "golongan")
    private String golongan;

    public Akun() {
    }

    public Akun(int idPengguna, String passwordPengguna, String golongan) {
        this.idPengguna = idPengguna;
        this.passwordPengguna = passwordPengguna;
        this.golongan = golongan;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getPasswordPengguna() {
        return passwordPengguna;
    }

    public void setPasswordPengguna(String passwordPengguna) {
        this.passwordPengguna = passwordPengguna;
    }
    
    
}
