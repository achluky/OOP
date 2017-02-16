package driver;

/**
 *
 * @author Jayuk
 */
public class Tabung extends BangunRuang
{
    private final double phi = 3.14;
    int jari, tinggi;
    
    Tabung()
    {
        
    }
    Tabung(int jari, int tinggi)
    {
        this.jari = jari;
        this.tinggi = tinggi;
    }

    @Override
    public double permukaan() 
    {
        
        double luasPermukaanAlas = phi *jari *jari;
        double luasPermukaanSisi = 2 * phi *jari * tinggi;
        double luasPermukaan = (2 * luasPermukaanAlas) + luasPermukaanSisi;
        return luasPermukaan;
    }

    @Override
    public double volume() 
    {
        double luasPermukaan = phi *jari *jari;
        double volume = tinggi * luasPermukaan;
        return volume;
    }

    @Override
    public void info() 
    {
        System.out.println("Jari - Jari : "+ jari);
        System.out.println("Tinggi : "+ tinggi);
        System.out.println("LuasPermukaan : "+ permukaan());
        System.out.println("volume : "+ volume());
    }
    
}
