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
@Table(name = "penyakit")
public class Penyakit 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPenyakit;
    @Column(name="namaPenyakit")
    private String namaPenyakit;
    @Column(name="daftarIdObatPenawar")
    private String daftarIdObatPenawar;

    public Penyakit() {
    }

    public Penyakit(int idPenyakit, String namaPenyakit, String daftarIdObatPenawar) {
        this.idPenyakit = idPenyakit;
        this.namaPenyakit = namaPenyakit;
        this.daftarIdObatPenawar = daftarIdObatPenawar;
    }

    public String getDaftarIdObatPenawar() {
        return daftarIdObatPenawar;
    }

    public void setDaftarIdObatPenawar(String daftarIdObatPenawar) {
        this.daftarIdObatPenawar = daftarIdObatPenawar;
    }

    

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(int idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }
    
    
    
}
