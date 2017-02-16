package ti1_uts_057;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Pekerjaan
{
    String nim;

    public Mahasiswa(String nama, String alamat, String jenisKelamin, String nomorTelepon,String nim) {
        super(nama, alamat, jenisKelamin,nomorTelepon);
        this.nim = nim;
    }
    public void profil()
    {
        System.out.println("Nama    :"+nama);
        System.out.println("Alamat  :"+alamat);
        System.out.println("Jenis Kelamin   :" +jenisKelamin);
        System.out.println("Nomor Telepon   :" +nomorTelepon);
    }
    
}
