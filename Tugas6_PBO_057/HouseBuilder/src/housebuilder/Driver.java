package housebuilder;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args)
    {
        HouseBuilder perabotanBuilder = new HouseBuilder();
        Perabotan Future = perabotanBuilder.prepareFuture();
        Future.showItems();
        System.out.println("Total Cost : " + Future.getCost());
        
        Perabotan Classic = perabotanBuilder.prepareClassic();
        Classic.showItems();
        System.out.println("Total Cost : " + Classic.getCost());
    }
}
