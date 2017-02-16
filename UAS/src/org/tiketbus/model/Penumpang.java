/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tiketbus.model;

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
public class Penumpang 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private int id;
    @Column (name = "Nama")
    private String nama;
    @Column (name = "Tujuan")
    private String tujuan;
    @Column (name = "Jumlah")
    private int jumlah;
    @Column (name = "TotalPembayaran")
    private double totalPembayaran;
    @Column (name = "SudahBayar")
    private int sudahBayar=0;

    public Penumpang() {
    }
    
    

    public Penumpang(int id, String nama, String tujuan, int jumlah, double totalPembayaran, int sudahBayar) {
        this.id = id;
        this.nama = nama;
        this.tujuan = tujuan;
        this.jumlah = jumlah;
        this.totalPembayaran = totalPembayaran;
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

    public double getTotalPembayaran() {
        return jumlah * 10000;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public int getSudahBayar() {
        return sudahBayar;
    }

    public void setSudahBayar(int sudahBayar) {
        this.sudahBayar = sudahBayar;
    }

    
    
    
    
}
