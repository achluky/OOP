package percetakan;

/**
 *
 * @author Jayuk
 */
public abstract class Mesin
{
    String nama;
    String deksripsi;
    
    public Mesin()
    {
        
    }

    public Mesin(String nama, String deksripsi) {
        this.nama = nama;
        this.deksripsi = deksripsi;
    }
    
    
    public abstract void info();
   
}
