package genericversi3;

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
        Box box = new Box(); 
        box.setObj(new Tabung());
        box.getObj().info();
        //box.setObj(new Kerucut());
    }
    
}
