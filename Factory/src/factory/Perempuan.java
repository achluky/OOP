package factory;

/**
 *
 * @author Jayuk
 */
public class Perempuan extends Manusia
{
    private final String GELAR = "Mrs. ";
    
    protected Perempuan(String nama)
    {
        super(nama);
    }
    @Override 
    public String getNama()
    {
        return GELAR + super.getNama();
    }
}
