package ExceptionBilangan;
import java.util.Scanner;
/**
 *
 * @author Jayuk
 */
public class Bilangan 
{
    private static int listBilangan[]={5,5,5,3,6,4,8};

    public Bilangan() {
    }
    
    
    public static void jumlahTotal()
    {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Bilangan pembagi");
        double bilanganPembagi = in.nextDouble();
        System.out.println("Batas atas indeks");
        int index = in.nextInt();
        double total=0.0;
        for(int i=0;i<index;i++)
        {
            total += listBilangan[i];
        }
        System.out.println("Jumlah Hasil penambahan array dari 0 sampai "+ index +" = " + total);
        double totalBilangan = total/bilanganPembagi;
        System.out.println("Hasil   :"+totalBilangan);
    }
}
