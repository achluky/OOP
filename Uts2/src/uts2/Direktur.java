
package uts2;

/**
 *
 * @author Bernando Lumban Raja
 */
public class Direktur extends Pegawai{
    private double tunjangan;
    private double gaji;
    int berkerja;

    public Direktur() {
    }

    public Direktur(double tunjangan, double gaji, String nik, String nama, int durasiKerja) {
        super(nik, nama, durasiKerja);
        this.tunjangan = tunjangan;
        this.gaji = gaji;
    }

    public double getTunjangan() {
        double totalTunjangan = 0;
        if(berkerja >= 3)
        {
            
            totalTunjangan = gaji*0.1;
        }
        else
        {
            totalTunjangan = gaji* 0.3;
        }
        return totalTunjangan;
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
