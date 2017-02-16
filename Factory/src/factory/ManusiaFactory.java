package factory;

/**
 *
 * @author Jayuk
 */
public class ManusiaFactory 
{
    public static Manusia getManusia(String nama, String jenisKelamin)
    {
        if (jenisKelamin.equalsIgnoreCase(Manusia.LELAKI))
            return new Lelaki(nama);
        if  (jenisKelamin.equalsIgnoreCase(Manusia.PEREMPUAN))
            return new Perempuan(nama);
        return null;
    }
}
