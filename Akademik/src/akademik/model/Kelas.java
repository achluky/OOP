package akademik.model;

/**
 *
 * @author Jayuk
 */
public class Kelas 
{
    private int id;
    private String nama;
    private String dosenWali = "Jaya";
    
    public Kelas()
    {
        
    }

    public Kelas(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getDosenWali()
    {
        return dosenWali;
    }
    
}
