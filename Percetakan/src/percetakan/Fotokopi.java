package percetakan;


/**
 *
 * @author Jayuk
 */
public class Fotokopi extends Mesin implements Printable
{
    String ukuranKertas = "A4";

    public Fotokopi() {
    }
    public Fotokopi(String nama, String deksripsi, String ukuran)
    {
        super(nama, deksripsi);
        this.ukuranKertas = ukuran;
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
