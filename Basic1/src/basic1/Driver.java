package basic1;

import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args)
    {
        Kubus kubus = new Kubus();
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah sisi");
        kubus.setSisi(input.nextInt());
        System.out.println("Luas permukaan = "+ kubus.getLuasPermukaan());
        System.out.println("Keliling kubus = "+ kubus.getKelilingKubus());
        System.out.println("Volume kubus = "+ kubus.getVolume());
    }
}
