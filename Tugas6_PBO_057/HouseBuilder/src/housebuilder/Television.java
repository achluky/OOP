package housebuilder;

/**
 *
 * @author Jayuk
 */
public class Television extends Electronic
{

    @Override
    public String nama() {
        return "Television";
    }

    @Override
    public float price() {
        return 20;
    }
    
}
