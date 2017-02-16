package genericmethod.pkgclass;

/**
 *
 * @author Jayuk
 */
public class Kubus extends BangunRuang
{
    private double panjang,lebar,tinggi;

    public Kubus(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    

    @Override
    public double luasPermukaan() 
    {
        double luasPermukaan = (panjang * lebar) * 2 + ((panjang * tinggi) *2) + (lebar * tinggi) *2;
        return luasPermukaan;
    }

    @Override
    public double volume() 
    {
        double volume = panjang * lebar * tinggi;
        return volume;
    }

    @Override
    public void info() 
    {
        System.out.println("Panjang :"+panjang);
        System.out.println("Lebar   :"+lebar);
        System.out.println("Tinggi  :"+tinggi);
        System.out.println("Luas Permukaan :"+luasPermukaan());
        System.out.println("Volume         :"+volume());
    }
    
}
