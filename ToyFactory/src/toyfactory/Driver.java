package toyfactory;

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
        AbstractFactory toyFactory = FactoryProducer.getFactory("Toy");
        Toy mainan = toyFactory.getProduct("Boneka");
        mainan.product();
        
        
    }
    
}
