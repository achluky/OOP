package bangunruangversi2;

/**
 *
 * @author Jayuk
 */
public class BangunRuangFactory 
{
    protected BangunRuangFactory()
    {
        
    }
    public BangunRuang getBangunRuang(double panjang, double lebar, double tinggi, char bangunRuang)
    {
        if(bangunRuang == BangunRuang.LIMAS)
        {
            return new Limas(panjang,lebar, tinggi);
        }
        if(bangunRuang == BangunRuang.PRISMA)
        {
            return new Prisma(panjang,lebar,tinggi);
        }
        return null;
    }
}
