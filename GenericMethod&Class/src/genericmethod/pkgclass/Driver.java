package genericmethod.pkgclass;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Box<BangunRuang> box = new Box<>();
        box.setObj(new Tabung(2));
        box.getObj().info();
    }
    
}
