package factorypatern1;

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
        NameFactory factory = new NameFactory();
        Namer jj = factory.getNamer("jaya manik");
        
        System.out.println(jj);
    }
    
}
