
package org.nauli.model;

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
@Table(name = "pemesanan")
public class Pemesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tujuan")
    private String tujuan;
    @Column(name = "jumlah")
    private int jumlah;
    @Column(name = "totalPemesanan")
    private int totalPemesanan;

    public Pemesanan() {
    }

    public Pemesanan(String nama, String tujuan, int jumlah, int totalPemesanan) {
        this.nama = nama;
        this.tujuan = tujuan;
        this.jumlah = jumlah;
        this.totalPemesanan = totalPemesanan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalPemesanan() {
        return totalPemesanan;
    }

    public void setTotalPemesanan(int totalPemesanan) {
        this.totalPemesanan = totalPemesanan;
    }
    
}
