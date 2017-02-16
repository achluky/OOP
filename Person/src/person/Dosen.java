package person;

/**
 *
 * @author Jayuk
 */
public class Dosen extends Person
{
    int nik;

    public Dosen(String nama, String alamat, String jenisKelamin, int umur, int nik) 
    {
        super(nama, alamat, jenisKelamin, umur);
        this.nik= nik;
    }
    @Override
    public void info()
    {
        System.out.println("Nama    "+nama);
        System.out.println("Nik     :"+nik);
        System.out.println("Alamat  :"+alamat);
        System.out.println("umur    :"+umur);
    }
}
