package thread.Sinkronisasi;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Bilangan bilangan = new Bilangan(0);
        MyThread a =  new MyThread(bilangan);
        MyThread b =  new MyThread(bilangan);
        a.start();
        b.start();
        try
        {
            a.join();
            b.join();
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("bilangan = "+bilangan.getAngka());
    }
    
    
}
