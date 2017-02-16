package ExecptionPart2;

/**
 *
 * @author Jayuk
 */
public class UangKurangEksepsi extends Exception
{
    private int jumlahUangSekarang;

    public UangKurangEksepsi(int jumlahUang)
    {
        this.jumlahUangSekarang = jumlahUang;
    }
    
    public UangKurangEksepsi(int jumlahUang, String message) {
        super(message);
        this.jumlahUangSekarang = jumlahUang;
    }
    
    

    public int getJumlahUangSekarang() {
        return jumlahUangSekarang;
    }

    public void setJumlahUangSekarang(int jumlahUangSekarang) {
        this.jumlahUangSekarang = jumlahUangSekarang;
    }
    
    
}
