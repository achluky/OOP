package designpatern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class ManusiaCache 
{
    public static final int MAHASISWA = 0;
    public static final int DOSEN = 1;
    private static List<Manusia> listManusia = new ArrayList<>();
    
    public static void loadCache()
    {
        listManusia.add(new Mahasiswa());
        listManusia.add(new Dosen());
    }
    public static Manusia getManusiaFromCache(int pilihan) throws CloneNotSupportedException
    {
        if(pilihan == MAHASISWA)
        {
            return (Manusia)listManusia.get(MAHASISWA).clone();
        }
        if(pilihan == DOSEN)
        {
            return (Manusia)listManusia.get(DOSEN).clone();
        }
        return null;
    }
}
