package uts2;

/**
 *
 * @author Jayuk
 */
public abstract class Pegawai {
    private String nik;
    private String nama;
    //private double gaji;
    private int durasiKerja;

    
    
    public Pegawai()
    {
    }

    public Pegawai(String nik, String nama, int durasiKerja) {
        this.nik = nik;
        this.nama = nama;
       //this.gaji = gaji;
        this.durasiKerja = durasiKerja;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

   /* public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    */
    
    public int getDurasiKerja() {
        return durasiKerja;
    }

    public void setDurasiKerja(int durasiKerja) {
        this.durasiKerja = durasiKerja;
    }
    
    
    
    
    
}
