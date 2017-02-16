package driver;

/**
 *
 * @author Jayuk
 */
public class Kubus extends BangunRuang
{
    int sisi;
    
    Kubus()
    {
        
    }
    Kubus(int sisi)
    {
        this.sisi = sisi;
    }
    @Override
    public double permukaan()
    {
        double luasPermukaan = sisi *sisi;
        double luasPermukaanKubus = 6 * luasPermukaan;
        return luasPermukaanKubus;
    }
    @Override
    public double volume()
    {
        double volume = sisi * sisi *sisi;
        return volume;
    }
    @Override
    public void info()
    {
        System.out.println("Sisi : "+ sisi);
    }
}
