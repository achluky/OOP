/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretestuts;

import static pretestuts.Pabrik.listKomputer;

/**
 *
 * @author Jayuk
 */
public class Marketing extends Pekerja
{
    Komputer komputerPesanan;
    int jumlah=0;
    
    public Marketing(String nik, String nama, double tunjangan, double bonus) {
        super(nik, nama, tunjangan, bonus);
    }
    
    public Komputer setPesanan(String merek, String tipe, int jumlahPesanan)
    {
        jumlah = jumlahPesanan;
        for(Komputer komputer : listKomputer)
        {
            if(komputer.getMerek().equalsIgnoreCase(merek) && komputer.getTipe().equalsIgnoreCase(tipe))
            {
                komputerPesanan = komputer;
                return komputerPesanan;
            }
        }
        return null;
    }
    
    @Override 
    public void run()
    {
        for(int i = 0; i <jumlah;i++)
        {
            komputerPesanan.kurangiStok();
        }
        for(int i=0;i<listKomputer.size();i++)
        {
            if(listKomputer.get(i).getMerek().equalsIgnoreCase(komputerPesanan.getMerek())|| listKomputer.get(i).getTipe().equalsIgnoreCase(komputerPesanan.getTipe()))
            {
                Pabrik.listKomputer.add(komputerPesanan);
                break;
            }
        }
    }
}
