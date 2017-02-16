package Teknologi;

/**
 *
 * @author Jayuk
 */
public abstract class Smartphone implements Teknologi
{
    int aplikasi;
    String harga;
    
    public Smartphone()
    {
        
    }
    @Override
    public abstract void upgrade();
    
    @Override
    public abstract void install();
    
    public abstract void download(String namaApp);
}
