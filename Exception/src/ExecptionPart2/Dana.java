package ExecptionPart2;

/**
 *
 * @author Jayuk
 */
public class Dana 
{
    private int jumlahUang;

    public Dana(int jumlahUang) {
        this.jumlahUang = jumlahUang;
    }
    
    

    public int getJumlahUang() {
        return jumlahUang;
    }

    public void setJumlahUang(int jumlahUang) {
        this.jumlahUang = jumlahUang;
    }
    
    public int mintaDuluSumbangan(int sumbangan) throws UangKurangEksepsi
    {
        if(jumlahUang > sumbangan)
        {
            this.jumlahUang -= sumbangan;
            return sumbangan;
        }
        else
        {
            throw new UangKurangEksepsi(jumlahUang);
        }
    }
    
    @Override
    public String toString()
    {
        return ("Dana Saat ini   :"+jumlahUang);
    }
}
