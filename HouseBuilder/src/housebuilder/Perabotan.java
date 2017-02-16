package housebuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class Perabotan 
{
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    public double getCost()
    {
        double cost = 0.0d;
        for(Item item :items)
        {
            cost +=item.price();
        }
        return cost;
    }
    public void showItems()
    {
        for(Item item : items)
        {
            System.out.println("Item : " + item.nama());
            System.out.println(", Jenis : " + item.jenis());
            System.out.println(", Price" + item.price());
        }
    }    
}
