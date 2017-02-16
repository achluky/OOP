package genericversi3;

/**
 *
 * @author Jayuk
 */
public class Tabung extends BangunRuang
{
    double jariJari;
    double tinggi;
    
    @Override
    public double luasPermukaan()
    {
        double luasPermukaan = tinggi * jariJari;
        return luasPermukaan;
    }
    @Override
    public double volume()
    {
        double volume = Math.PI * jariJari * jariJari * tinggi;
        return volume;
    }
    @Override
    public void info()
    {
        System.out.println("Jari - jari \t:\n"+jariJari);
        System.out.println("Tinggi\t:\n"+ tinggi);
    }
}
