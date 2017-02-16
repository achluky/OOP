package akademik.model;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa 
{
    private String nim;
    private String nama;
    private double indekPrestasi;
    private Kelas kelas;
    
    public Mahasiswa()
    {
        
    }

    public Mahasiswa(String nim, String nama, double indekPrestasi, Kelas kelas) {
        this.nim = nim;
        this.nama = nama;
        this.indekPrestasi = indekPrestasi;
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getIndeksPrestasi() {
        return indekPrestasi;
    }

    public void setIndeksPrestasi(double indekPrestasi) {
        this.indekPrestasi = indekPrestasi;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }
    
    @Override
    public String toString()
    {
        return "MHS NIM :"+nim+"\tNAMA  :"+nama+"\tKELAS    :"+kelas.getNama();
    }
}
