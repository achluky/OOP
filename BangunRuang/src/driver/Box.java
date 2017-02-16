package driver;

/**
 *
 * @author Jayuk
 */
public class Box <T extends BangunRuang>
{
    private T obj;
    
    public Box()
    {
        
    }
    public Box(T obj)
    {
        this.obj = obj;
    }
    public T getObj()
    {
        return obj;
    }
    public void setObj(T obj)
    {
        this.obj = obj;
    }
}
