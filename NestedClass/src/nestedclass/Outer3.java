package nestedclass;

/**
 *
 * @author Jayuk
 */
public class Outer3 
{
    private int a;
    static int b;
    
    public Outer3()
    {
        a = 0;
        b = 2;
    }
    //lengkapi kosntruktornya
    
    //Deklarasi static nested class
    static class StaticNestedClass
    {
        static int c = 0;
        
        public String toString()
        {
        b = 4;
        return("Static Nested Class: " + b);
        }
    }
    //deklarasi inner class
    class InnerClass
    {
        public String toString()
        {
            b = 4;
            return ("Inner Class: " +b);
        }
    }
}

class DemoOuter3
{
    public static void main(String[] args)
    {
        Outer3.StaticNestedClass snc = new Outer3.StaticNestedClass();
        Outer3 o = new Outer3();
        System.out.println(snc);//1
        //System.out.println(Outer3.StaticNestedClass.toString()); //2
        //System.out.println(o.StaticNestedClass.c);//3
        //System.out.println(Outer3.StaticNestedClass.b);//4
        //System.out.println(o.InnerClass.toString());//5
        //Outer3.InnerClass ic = new Outer3.InnerClass();//6
    }
}