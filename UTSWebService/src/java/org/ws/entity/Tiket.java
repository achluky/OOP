/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ws.entity;

import java.io.Serializable;

/**
 *
 * @author Jayuk
 */
public class Tiket implements  Serializable
{
    private String asal;
    private String tujuan;
    private double harga;

    public Tiket() {
    }

    public Tiket(String asal, String tujuan, double harga) {
        this.asal = asal;
        this.tujuan = tujuan;
        this.harga = harga;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    } 
}
