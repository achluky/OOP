package percetakan;

/**
 *
 * @author Jayuk
 */
public class MesinFactory extends AbstractFactory
{
    protected MesinFactory()
    {
        
    }
    @Override
    public Mesin getMesin(String nama, String deksripsi, double i)
    {
        return new Printer(nama, deksripsi, i);
    }
    @Override
    public Mesin getMesin(String nama, String deksripsi, String ukuran)
    {
        return new Fotokopi(nama, deksripsi, ukuran);
    }
}
