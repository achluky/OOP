/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretestuts;

import java.util.ArrayList;

/**
 *
 * @author Tampan
 */
public class Pembeli
{
    private double uang;
    private String nama;
    private String asal;
    
    ArrayList<Komputer> listKomputerBeli =  new ArrayList<>();
    int i;
    public Pembeli(double uang, String nama, String asal) {
        if(uang >10)
        {
            this.uang = uang;
        }
        else
        {
            this.uang = 10;
        }
        this.nama = nama;
        this.asal = asal;
    }
    
    public void faktur()
    {
        System.out.println("Komputer yang di beli :");
        for(int i = 0; i< listKomputerBeli.size();i++)
        {
            int urutanKomputer = i+1;
            System.out.println("Komputer : "+urutanKomputer);
            Komputer komputer = listKomputerBeli.get(i);
            System.out.print("Merek   :"+komputer.getMerek()+"\t");
            System.out.print("Tipe    :"+komputer.getTipe()+"\t");
            System.out.println("Harga   :"+komputer.getHarga());
            System.out.println("Dengan spesifikasi  :");
            komputer.tampilkanSemuaKomponen();
        }
        
    }
    
    public void membeli(Marketing marketing, String merek, String tipe, int jumlah)
    {
        Komputer komputer = marketing.setPesanan(merek, tipe, jumlah);
        if(komputer == null)
        {
            System.out.println("Komputer tidak tersedia");
        }
        else
        {
        if (komputer.getHarga() <= this.uang)
        {
            
            listKomputerBeli.add(i, komputer);
            i++;
            this.uang -= komputer.getHarga();
        }
        else
        {
            System.out.println("Uang tidak mencukupi");
        }
        }
    }
    
}
