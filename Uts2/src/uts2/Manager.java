
package uts2;

/**
 *
 * @author Bernando Lumban Raja 
 */
public abstract class Manager extends Pegawai {
    private double tunjangan;
    private double gaji;

    public Manager() {
    }

    public Manager(double tunjangan, double gaji, String nik, String nama, int durasiKerja) {
        super(nik, nama, durasiKerja);
        this.tunjangan = tunjangan;
        this.gaji = gaji;
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
