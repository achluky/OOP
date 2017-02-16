package toyfactory;

/**
 *
 * @author Jayuk
 */
public class FactoryProducer 
{
    public static AbstractFactory getFactory(String choice)
    {
        if (choice.equalsIgnoreCase("Toy"))
            return new ToyFactory();
        else
            return null;
    }
}
