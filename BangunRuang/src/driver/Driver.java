package driver;

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
        Box<Tabung> box1 = new Box<>();
        box1.setObj(new Tabung(1,2));
        System.out.println("Tabung");
        box1.getObj().info();
        System.out.println("Luas Permukaan dari fungsi permukaan():" +box1.getObj().permukaan());
        System.out.println("Volume dari fungsi permukaan():" +box1.getObj().volume());
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Kerucut");
        Box<Kerucut> box2 = new Box<>();
        box2.setObj(new Kerucut(1,2,3));
        box2.getObj().info();
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Box<Kubus> box3 = new Box<>();
        box3.setObj(new Kubus(1));
        System.out.println("Kubus");
        box3.getObj().info();
        System.out.println("Luas Permukaan : "+ box3.getObj().permukaan());
        System.out.println("Volume : " + box3.getObj().volume());
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Box<Balok> box4 = new Box<>();
        box4.setObj(new Balok(1,2,3));
        System.out.println("Balok");
        System.out.println("Permukaan : " + box4.getObj().permukaan());
        System.out.println("Volume : " + box4.getObj().volume());
    }
    
}
