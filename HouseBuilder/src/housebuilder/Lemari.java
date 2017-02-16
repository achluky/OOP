package housebuilder;

/**
 *
 * @author Jayuk
 */
public class Lemari extends NonElectronic
{

    @Override
    public String nama() 
    {
        return "lemari";
    }

    @Override
    public float price() {
        return 8;
    }
    
}
