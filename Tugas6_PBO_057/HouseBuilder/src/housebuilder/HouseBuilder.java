package housebuilder;

/**
 *
 * @author Jayuk
 */
public class HouseBuilder 
{
    public Perabotan prepareFuture()
    {
        Perabotan perabotan = new Perabotan();
        perabotan.addItem(new Television());
        return perabotan;
    }
    public Perabotan prepareClassic()
    {
        Perabotan perabotan =  new Perabotan();
        perabotan.addItem(new Lemari());
        return perabotan;
    }
}
