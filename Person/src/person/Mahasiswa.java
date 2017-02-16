package person;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Person
{
    int nim;

    public Mahasiswa(String nama, String alamat, String jenisKelamin, int umur,int nim) 
    {
        super(nama, alamat, jenisKelamin, umur);
        this.nim = nim;
    }
    @Override
    public void info()
    {
        System.out.println("Nama    "+nama);
        System.out.println("Nim     :"+nim);
        System.out.println("Alamat  :"+alamat);
        System.out.println("umur    :"+umur);
    }
}
