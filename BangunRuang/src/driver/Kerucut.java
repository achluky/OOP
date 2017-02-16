package driver;

/**
 *
 * @author Jayuk
 */
public class Kerucut extends BangunRuang
{
    private final double phi = 3.14;
    public int jari,tinggi,sisi;
    
    Kerucut()
    {
        
    }
    Kerucut(int jari,int tinggi,int sisi)
    {
        this.jari = jari;
        this.sisi = sisi;
        this.tinggi = tinggi;
    }
    
    @Override
    public double permukaan()
    {
        return ((phi * jari * jari) + (phi*jari*sisi));
    }
    @Override
    public double volume()
    {
        return (1/3*phi*jari*jari*tinggi);
    }
    @Override
    public void info()
    {
        System.out.println("Jari - Jari : "+ jari);
        System.out.println("Tinggi : "+ tinggi);
        System.out.println("Sisi : "+sisi);
        System.out.println("LuasPermukaan : "+ permukaan());
        System.out.println("volume : "+ volume());
    }
}
