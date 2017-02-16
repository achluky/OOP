package akademik.model;

/**
 *
 * @author Jayuk
 */
public class Matakuliah 
{
    private int id;
    private String namaMataKuliah;
    private int sks;

    public Matakuliah(int id, String namaMataKuliah, int sks) {
        this.id = id;
        this.namaMataKuliah = namaMataKuliah;
        this.sks=sks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    
    
}
