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
public class Driver 
{
    
    public static void main(String[] args) 
    {
        double uang = 2000;
        Toko toko = new Toko();
        Barang barang;
        barang = new Barang("001", 200,10);
        toko.tambahBarang(barang);
        barang = new Barang("002",100,10);
        toko.tambahBarang(barang);
        barang = new Barang("003",50,200);
        toko.tambahBarang(barang);
        try
        {
           barang = toko.cariBarang("001");
            System.out.println("Pencarian Berhasil dilakukan "+ barang);
            System.out.println("Pembelian akan dilakukan");
           toko.beliBarang("001", 10, uang);
            System.out.println("Pembelian berhasil dilakukan");
        }
        catch(BarangTidakAdaEksepsi btae)
        {
            System.out.println(btae);
        }
        catch(PembelianBarangEksepsi pbe)
        {
            System.out.println(pbe);
        }
        
        
    }
}
