package person;

/**
 *
 * @author Jayuk
 */
public abstract class Person 
{
    String nama;
    String alamat;
    String jenisKelamin;
    int umur;

    public Person(String nama, String alamat, String jenisKelamin, int umur) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
    public void info()
    {
        System.out.println("Nama    "+nama);
        System.out.println("Alamat  :"+alamat);
        System.out.println("umur    :"+umur);
    }
}
