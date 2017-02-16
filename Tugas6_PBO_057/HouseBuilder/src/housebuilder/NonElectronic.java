package housebuilder;

/**
 *
 * @author Jayuk
 */
public abstract class NonElectronic implements Item
{
    @Override
    public Jenis jenis()
    {
        return new Classic();
    }
}
