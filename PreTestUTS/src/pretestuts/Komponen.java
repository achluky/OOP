package pretestuts;

/**
 *
 * @author Tampan
 */
public class Komponen 
{
    private String merek;
    private String tipe;
    private double harga;

    public Komponen() {
    }

    public Komponen(String merek, String tipe, double harga) {
        this.merek = merek;
        this.tipe = tipe;
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if(harga >10)
        {
            this.harga = harga;
        }
        else
        {
            this.harga = 10;
        }
    }
    
    
}
