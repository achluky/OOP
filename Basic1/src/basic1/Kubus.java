package basic1;

/**
 *
 * @author Jayuk
 */
public class Kubus extends Persegi
{
    public void setSisiKubus(int sisi)
    {
        setSisi(sisi);
    }
    public int getKelilingKubus()
    {
        int keliling;
        keliling = 12 * getSisi();
        return keliling;
    }
    public int getLuasPermukaan()
    {
        int luasPermukaan;
        luasPermukaan = 6 * getSisi();
        return luasPermukaan;
    }
    public int getVolume()
    {
        int volume;
        volume = getSisi() * getSisi() * getSisi();
        return volume;
    }
}
