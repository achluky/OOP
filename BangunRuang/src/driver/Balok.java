package driver;

/**
 *
 * @author Jayuk
 */
public class Balok extends BangunRuang
{
    int panjang, lebar, tinggi;
    
    Balok()
    {
        
    }
    Balok(int panjang, int lebar, int tinggi)
    {
        this.lebar = lebar;
        this.panjang = panjang;
        this.tinggi = tinggi;
    }
    @Override
    public double permukaan()
    {
        double luasPermukaanAlas = panjang * lebar;
        double luasPermukaanAtap = panjang * lebar;
        double luasPermukaanSisi = panjang * tinggi;
        double LuasPermukaanBalok = luasPermukaanAlas + luasPermukaanAtap +(4 * luasPermukaanSisi);
        return LuasPermukaanBalok;
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
        System.out.println("Panjang : " + panjang);
        System.out.println("Lebar : " + lebar);
        System.out.println("Tinggi : "+ tinggi);
    }
}
