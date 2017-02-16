package ti1_uts_057;

/**
 *
 * @author Jayuk
 */
public abstract class Pekerjaan 
{
    String nama;
    String alamat;
    String jenisKelamin;
    String nomorTelepon;

    public Pekerjaan(String nama, String alamat, String jenisKelamin, String nomorTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.nomorTelepon = nomorTelepon;
    }
}
