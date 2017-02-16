package nestedclass;

/**
 *
 * @author Jayuk
 */
public class Outer1 
{
    private int outer_x = 100;
    
    //Lengkapi constructor di sini
    
    //instansiasi inner class
    public void  test()
    {
        Inner inner = new Inner();
        inner.display();
    }
    
    //deklarasi inner class
    class Inner
    {
        void display()
        {
            System.out.println("display : outer_x = " + outer_x);
        }
    }
}
class DemoOuter1
{
    public static void main(String[] args)
    {
        Outer1  outer = new Outer1();
        outer.test();
    }
}
