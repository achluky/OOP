package bangunruangversi2;

/**
 *
 * @author Jayuk
 */
public abstract class BangunRuang 
{
    public static final char LIMAS = 'L';
    public static final char PRISMA = 'P';
    private static BangunRuangFactory bangunRuangFactory = new BangunRuangFactory();
    
    public double tinggi;
    public double panjang;
    public double lebar;
    
    public BangunRuang(double panjang,double lebar, double tinggi)
    {
        this.tinggi = tinggi;
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public abstract double getVolume();
    
    public double getLuasAlas()
    {
        return panjang * lebar;
    }
    public double getTinggi()
    {
        return tinggi;
    }
    public static BangunRuangFactory getFactory()
    {
        return bangunRuangFactory;
    }
    
}
