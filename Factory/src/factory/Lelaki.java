package factory;

/**
 *
 * @author Jayuk
 */
public class Lelaki extends Manusia
{
    private final String GELAR = "MR. ";
    protected Lelaki(String nama)
    {
        super(nama);
    }
    @Override
    public String getNama()
    {
        return GELAR + super.getNama();
    }
}
