package prak02;
import java.util.*;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Jari - jari = ");
        int r = in.nextInt();
        System.out.print("Tinggi = ");
        int t = in.nextInt();
        Tabung T = new Tabung(r,t);
        System.out.println("Luas Lingkaran = " + T.getLuas(r));
        System.out.println("Volume Tabung = " + T.getVolume(r,t));
        System.out.println("Luas Permukaan Tabung = "+ T.getLuasPermukaan(r,t));
    }   
}