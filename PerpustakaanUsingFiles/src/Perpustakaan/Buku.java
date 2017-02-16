/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpustakaan;

import java.io.Serializable;

/**
 *
 * @author Jayuk
 */
public class Buku implements Serializable
{
    private String isbn;
    private String judulBuku;
    private String pengarang;
    private String penerbit;
    private int jumlahEkslampar;
    private int jumlahBuku;
    private int stokTersedia;
    private String tipeBuku;
    private boolean availability;
    private boolean loanable;
    static int stok;
    
    
    public Buku()
    {
        
    }
    
    public Buku(String isbn, String judulBuku, String pengarang, String penerbit, String tipeBuku)
    {
        this.isbn = isbn;
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tipeBuku = tipeBuku;
    }
    
    public String getISBN()
    {
        return isbn;
    }
    
    public String getJudulBuku()
    {
        return judulBuku;
    }
    
    public String getPengarang()
    {
        return pengarang;
    }
    
    public String getPenerbit()
    {
        return penerbit;
    }
    
    public String getTipeBuku()
    {
        return tipeBuku;
    }
    
    public void setISBN(String ISBN)
    {
        this.isbn = ISBN;
    }
    
    public void setJudulBuku(String judulBuku)
    {
        this.judulBuku = judulBuku;
    }
    
    public void setPengarang(String pengarang)
    {
        this.pengarang = pengarang;
    }
    
    public void setPenerbit(String penerbit)
    {
        this.penerbit = penerbit;
    }
    
    public void setTipeBuku(String tipeBuku)
    {
        this.tipeBuku = tipeBuku;
    }
    
    public void setJumlahBuku(int jumlahBuku)
    {
        this.jumlahBuku = jumlahBuku;
    }
    public boolean checkBookType()
    {
        switch(tipeBuku)
        {
            case "Teks" :
                return true;
            case "Majalah" :
                return true;
            case "Koran":
                return true;
            case "Novel":
                return true;
            default :
                return false;
        }
    }
    
    public String checkAvailability()
    {
       if(stok>0)
           return "true";
       else
           return "false";
    }
    
    public String checkLoanAble()
    {
        switch(tipeBuku)
        {
            case"Novel":
                return "true";
            case"Teks" :
                return "true";
            case"Majalah":
                return "false";
            case"Koran":
                return "false";
            default:
                return "false";
        }
    }
    @Override
    public String toString()
    {
        return "ISBN\t:"+isbn+
        "Judul\t:"+judulBuku+
        "Pengarang\t:"+pengarang+
        "Penerbit\t:"+penerbit+
        "Tipe\t:"+tipeBuku+
        "Jumlah\t:"+jumlahBuku+
        "Stok\t:"+stok+
        "Available\t:"+checkAvailability()+
        "Loanable\t:"+checkLoanAble();
    }
}

