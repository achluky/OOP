package pretestuts;

import java.util.ArrayList;

/**
 *
 * @author Tampan
 */
public class Komputer 
{
    private String merek;
    private String tipe;
    private double harga;
    private int stok;
    int i=0;
    private ArrayList<Komponen> listKomponen =  new ArrayList<>();
    
    public Komputer(String merek, String tipe,int stok) {
        this.merek = merek;
        this.tipe = tipe;
        this.stok=stok;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public void kurangiStok()
    {
        synchronized(this)
        {
            stok--;
        }
    }
    public void tambahStok()
    {
        synchronized(this)
        {
            stok++;
        }
    }

    
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getHarga() {
        double totalHarga = 0;
        for(int i =0; i< listKomponen.size();i++)
        {
            totalHarga += listKomponen.get(i).getHarga();
        }
        double hargaPajak = totalHarga * 0.1;
        this.harga = totalHarga;
        return totalHarga;
    }

    public void setHarga(double harga) {
        if(harga >10)
        {
            this.harga = harga;
        }
        else
        {
            this.harga = 10;
        }
    }
    public void tambahKomponen(Komponen komponen)
    {
        listKomponen.add(i, komponen);
        i++;
    }
    public Komponen getKomponen(int i)
    {
        return listKomponen.get(i);
    }
    public void tampilkanSemuaKomponen()
    {
        for(int jaya=0;jaya < listKomponen.size();jaya++)
        {
            int ke=jaya +1;
            System.out.println("Komponen ke : "+ke);
            System.out.println("\tMerek   : "+listKomponen.get(jaya).getMerek());
            System.out.println("\tTipe    : "+listKomponen.get(jaya).getTipe());
            System.out.println("\tHarga   : "+listKomponen.get(jaya).getHarga());
        }
    }   
}