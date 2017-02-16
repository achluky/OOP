package designpatern.prototype;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Manusia
{
    private String nim;
    
    public Mahasiswa()
    {
        delayObjekCreation();
    }
    
    public Mahasiswa(String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
    }

    public Mahasiswa(String nim, String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public void infoData() 
    {
        System.out.println("Mahasiswa   :" + getNama() + "\n" + "Nim  :" + getNim());
    }
    
    public void delayObjekCreation()
    {
        System.out.println("Pendiptaan Objeck Mahasiswa mengalami delay");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }
}
