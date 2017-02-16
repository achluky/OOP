package housebuilder;

/**
 *
 * @author Jayuk
 */
public abstract class Electronic implements Item
{
    @Override
    public Jenis jenis()
    {
        return new Futuristic();
    }
}
