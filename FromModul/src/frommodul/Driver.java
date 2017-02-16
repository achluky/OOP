package frommodul;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jayuk
 */
public class Driver
{
    
    public static void main(String[] args)
{
    List<String> myList = new ArrayList<>();
    myList.add("1234");
    //dua baris penambahan data int dan double akan error saat compilasi
    //myList.add(123);
    //myList.add(123.0);
    String data = (String)myList.get(0);
    data = (String)myList.get(1);
    data = (String)myList.get(2);
}
}