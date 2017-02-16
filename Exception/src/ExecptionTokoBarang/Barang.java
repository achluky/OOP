/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecptionTokoBarang;

/**
 *
 * @author Jayuk
 */
public class Barang 
{
    private String idBarang;
    private double harga;
    private int stok;

    public Barang(String idBarang, double harga, int stok) {
        this.idBarang = idBarang;
        this.harga = harga;
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    @Override
    public String toString()
    {
        return ("ID      :"+idBarang +"\tHarga   :"+harga+"\tStok    :"+stok);
    }
}
