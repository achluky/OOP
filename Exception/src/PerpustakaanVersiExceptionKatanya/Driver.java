package PerpustakaanVersiExceptionKatanya;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args)
    {
        Buku buku;
        Mahasiswa mahasiswa;
        buku =  new Buku("101");
        Perpustakaan.tambahBuku(buku);
        buku =  new Buku("102");
        Perpustakaan.tambahBuku(buku);
        buku = new Buku("103");
        Perpustakaan.tambahBuku(buku);
        
        mahasiswa= new Mahasiswa();
        try
        {
            mahasiswa.bacaBuku("101");
            mahasiswa.cariBuku("101");
            mahasiswa.bacaBuku("101");
        }

        catch(BukuBelumDiambilEksepsi bbde)
        {
            System.out.println("Buku belum Diambil");
            System.out.println(bbde);
        }
        catch(BukuTidakAdaEksepsi btae)
        {
            System.out.println("Buku Belum Tersedia");
            System.out.println(btae);
        }
        finally
        {
            
        }
        
        
    }
}
