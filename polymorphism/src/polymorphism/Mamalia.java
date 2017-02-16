package polymorphism;

/**
 *
 * @author Jayuk
 */
public class Mamalia extends Animal
{
    Mamalia()
    {
        
    }
    
    @Override
    public void bergerak()
    {
        System.out.println("Kiri kanan, kiri kanan..");
    }
    @Override
    public void bernapas()
    {
        System.out.println("huuu... haaa...");
    }
    @Override
    public void makan()
    {
        System.out.println("nyam - nyam.....");
    }
    @Override
    public void bersuara()
    {
        System.out.println("bernapas melalui paru - paru");
    }
    public void menyusui()
    {
        System.out.println("Censored");
    }
}
