package ExecptionTokoBarang;

/**
 *
 * @author Jayuk
 */
public class PembelianBarangEksepsi extends Exception
{
    String idBarang;


    public PembelianBarangEksepsi(String message, String idBarang) {
        super(message);
        this.idBarang = idBarang;
    }
    
}
