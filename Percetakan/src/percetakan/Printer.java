package percetakan;

/**
 *
 * @author Jayuk
 */
public class Printer extends Mesin implements Printable
{
    double kecepatan;
    
    public Printer()
    {
        
    }
    public Printer(String nama, String deksripsi, double kecepatan)
    {
        super(nama, deksripsi);
        this.kecepatan = kecepatan;
    }
    
    
    @Override
    public void info() 
    {    
        System.out.println(deksripsi);
    }

    @Override
    public void cetakDokumen() 
    {
        System.out.println("Ketuhanan yang maha esa");
    }
    
}
