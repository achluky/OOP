package perpustakaan;
import java.util.*;

/**
 *
 * @author Jayuk
 */
public class Buku 
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
    void tampilkanBuku()
    {
        System.out.println("");
        System.out.println("ISBN\t:"+isbn);
        System.out.println("Judul\t:"+judulBuku);
        System.out.println("Pengarang\t:"+pengarang);
        System.out.println("Penerbit\t:"+penerbit);
        System.out.println("Tipe\t:"+tipeBuku);
        System.out.println("Jumlah\t:"+jumlahBuku);
        System.out.println("Stok\t:"+stok);
        System.out.println("Available\t:"+checkAvailability());
        System.out.println("Loanable\t:"+checkLoanAble());
        System.out.println("");
    }
}
