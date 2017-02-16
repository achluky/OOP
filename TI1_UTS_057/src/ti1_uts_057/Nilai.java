package ti1_uts_057;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Nilai
{
    MataKuliah mataKuliah;
    Mahasiswa mahasiswa;
    int nilai;

    public Nilai(MataKuliah mataKuliah, Mahasiswa mahasiswa, int nilai) 
    {
        this.mataKuliah = mataKuliah;
        this.mahasiswa = mahasiswa;
        this.nilai = nilai;
    }
}
