package nestedclass;

/**
 *
 * @author Jayuk
 */
public class Outer2 
{
    private int outer_x = 100;
    //Lengkapi constructornya
    
    //instansiasi inner class
    public void test()
    {
        Inner inner = new Inner();
        inner.display();
    }
    public void showY()
    {
        Inner inner = new Inner();
        System.out.println(inner.getY());
    }
    //deklarasi inner class
    class Inner
    {
        //deklarasi dan inisialisasi variable lokal y
        int y = 10;
        void display()
        {
            System.out.println("display : outer_x = " + outer_x);
        }
        int getY()
        {
            return y;
        }
    }
}
class DemoOuter2
{
    public static void main(String[] args)
    {
        Outer2 outer = new Outer2();
        outer.test();
    }
}
