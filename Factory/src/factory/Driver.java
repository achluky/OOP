package factory;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Manusia manusia = ManusiaFactory.getManusia("dapot", Manusia.LELAKI);
        System.out.println(manusia.getNama());
        manusia = ManusiaFactory.getManusia("DapotWati", Manusia.PEREMPUAN);
        System.out.println(manusia.getNama());
    }
    
}
