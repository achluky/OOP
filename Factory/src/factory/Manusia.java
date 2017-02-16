package factory;

/**
 *
 * @author Jayuk
 */
public abstract class Manusia 
{
    public static final String LELAKI = "L";
    public static final String PEREMPUAN = "P";
    private String nama;
    private String jenisKelamin;
    
    public Manusia(String nama)
    {
        this.nama = nama;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public String getJenisKelamin()
    {
        return jenisKelamin;
    }
}
