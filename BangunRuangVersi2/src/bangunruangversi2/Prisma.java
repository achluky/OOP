package bangunruangversi2;

/**
 *
 * @author Jayuk
 */
public class Prisma extends BangunRuang
{
    public Prisma(double panjang, double lebar, double tinggi)
    {
        super(panjang, lebar, tinggi);
    }
    @Override
    public double getVolume()
    {
        return getLuasAlas() * getTinggi();
    }
}
