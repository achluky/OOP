/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_diploma;

/**
 *
 * @author Jayuk
 */
public class Buku extends Materi
{
    private String ISBN;
    private String penerbit;
    private String pengarang;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    @Override
    public void openFile() 
    {
        System.out.println("Tampilkan dengan menggunakan  Adobe Reader");
    }
    
    
}
