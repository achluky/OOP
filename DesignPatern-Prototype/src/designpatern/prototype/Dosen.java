package designpatern.prototype;

/**
 *
 * @author Jayuk
 */
public class Dosen extends Manusia
{
    private String nidn;
    
    public Dosen()
    {
        delayObjekCreation();
    }

    public Dosen(String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
    }

    public Dosen(String nidn, String nama, char jenisKelamin) {
        super(nama, jenisKelamin);
        this.nidn = nidn;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }
    

    @Override
    public void infoData() 
    {
        System.out.println("Dosen   :"+getNama()+"\n" + "NIDN   :" +getNidn());
    }
    public void delayObjekCreation()
    {
        System.out.println("penciptaan Objek Dosen mengalami Delay");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }
    
}
