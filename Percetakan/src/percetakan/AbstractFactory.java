package percetakan;

/**
 *
 * @author Jayuk
 */
public abstract class AbstractFactory 
{
    abstract Mesin getMesin(String nama, String deksripsi, double i);
    abstract Mesin getMesin(String nama, String deksripsi, String ukuran);
}
