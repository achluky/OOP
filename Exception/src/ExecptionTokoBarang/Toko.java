package ExecptionTokoBarang;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Toko 
{
    ArrayList<Barang> listBarang = new ArrayList<>(); 
    
    public Barang cariBarang(String id) throws BarangTidakAdaEksepsi
    {
        int i = 0;
        for(Barang barang : listBarang)
        {
            if(barang.getIdBarang().equalsIgnoreCase(id))
            {
                
                i++;
                return barang;
            }
        }
        if(i==0)
        {
            throw new BarangTidakAdaEksepsi("Barang tidak ada");
        }
        return null;
    }
    public void beliBarang(String id, int jumlahBeli, double uang) throws PembelianBarangEksepsi,BarangTidakAdaEksepsi
    {
        Barang cekBarang = cariBarang(id);
        if(cekBarang != null)
        {
        double hargaTotalBarang = 0.0;
        for (Barang barang : listBarang)
        {
            if(barang.getIdBarang().equalsIgnoreCase(id))
            {
                hargaTotalBarang = jumlahBeli * barang.getHarga();
                if(jumlahBeli>barang.getStok())
                {
                    throw new PembelianBarangEksepsi("Stok tidak cukup",id);
                }
                else
                {
                    if(hargaTotalBarang > uang)
                    {
                        throw new PembelianBarangEksepsi("Uang tidak cukup",id);
                    }
                    else if(hargaTotalBarang < uang)
                    {
                        uang -= hargaTotalBarang;
                        throw new PembelianBarangEksepsi("Uang lebih, kembalian di berikan senilai  : "+uang,id);
                    }
                    else if(hargaTotalBarang==uang)
                    {
                        System.out.println("Barang "+barang.getIdBarang()+ " telah dibeli dengan uang pas");
                    }
                    else
                    {
                        System.out.println("Salah");
                    }
                } 
            }
            
        }
        }
        else
        {
            throw new BarangTidakAdaEksepsi("Barang tidak tersedia");
        }
        
            
    }
    public void tambahBarang(Barang barang)
    {
        listBarang.add(barang);
    }
}
