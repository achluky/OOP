package uts2;

/**
 *
 * @author Bernando Lumban Raja
 */
public class PresidenDirektur {
    private String nama;
    private double tunjangan;
    private double gaji;
    private double durasiKerja;

    public PresidenDirektur() {
    }

    public PresidenDirektur(String nama, double tunjangan, double gaji,double durasiKerja)
    {
        this.nama = nama;
        this.tunjangan = tunjangan;
        this.gaji = gaji;
        this.durasiKerja = durasiKerja;
    }

    public double getDurasiKerja() {
        return durasiKerja;
    }

    public void setDurasiKerja(double durasiKerja) {
        this.durasiKerja = durasiKerja;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
    
    
}