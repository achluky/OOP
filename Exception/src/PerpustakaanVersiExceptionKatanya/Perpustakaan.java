package PerpustakaanVersiExceptionKatanya;
import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Perpustakaan
{
    static ArrayList<Buku> listBuku =  new ArrayList<>();
    
    
    public Perpustakaan()
    {
        
    }

    public static void tambahBuku(Buku buku)
    {
        listBuku.add(buku);
    }
    
    public static Buku cariBuku(String id) throws BukuTidakAdaEksepsi
    {
        for(Buku buku : listBuku)
        {
            if(id.equalsIgnoreCase(buku.id))
            {
                return buku;
            }
            else
            {
                throw new BukuTidakAdaEksepsi(id);
            }
        }
        return null;
    }
}
