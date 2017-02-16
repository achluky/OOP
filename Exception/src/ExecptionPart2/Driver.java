package ExecptionPart2;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Dana myDana = new Dana(5000);
        
        try
        {
            myDana.mintaDuluSumbangan(10000000);
        }
        catch(UangKurangEksepsi uke)
        {
            System.out.println("Uang tidak cukup");
        }
        
    }
}
