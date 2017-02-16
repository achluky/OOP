package basic1;

/**
 *
 * @author Jayuk
 */
public class Persegi 
{
    private int sisi = 0;
    
   
    public Persegi()
    {
        System.out.println("Class Persegi");
    }
    public void setSisi(int sisi)
    {
        this.sisi = sisi;
    }
    
    public int getSisi()
    {
        return sisi;
    }
    
    public int getKeliling()
    {
        return (4 * this.sisi);
    }
    public int getLuas()
    {
        return (this.sisi * this.sisi);
    }
}
