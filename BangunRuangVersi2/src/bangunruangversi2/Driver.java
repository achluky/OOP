package bangunruangversi2;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args)
    {
        BangunRuang bangunRuang = BangunRuang.getFactory().getBangunRuang(4d,6d,7d,BangunRuang.LIMAS);
        System.out.println("Volume : "+ bangunRuang.getVolume());
        bangunRuang = BangunRuang.getFactory().getBangunRuang(4d, 6d, 7d, BangunRuang.PRISMA);
        System.out.println("Volume : "+ bangunRuang.getVolume());
        
    }
}
