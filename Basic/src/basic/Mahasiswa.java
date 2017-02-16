package basic;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa 
{
    String nama;
    String nim;
    static String dosenWali;
    
    Mahasiswa()
    {
        
    }
    Mahasiswa(String myNama)
    {
        nama = myNama;
    }
    Mahasiswa (String myNama, String myNim)
    {
        nama = myNama;
        nim = myNim;
    }
    Mahasiswa(int myNim)
    {
        nim = Integer.toString(myNim);
    }
    void ubahNama(String namaBaru)
    {
        nama = namaBaru;
    }
    static void ubahNamaDosenWali(String namaDosenWali)
    {
        dosenWali = namaDosenWali;
    }
    
}
