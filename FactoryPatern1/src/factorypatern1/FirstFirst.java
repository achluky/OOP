package factorypatern1;

/**
 *
 * @author Jayuk
 */
public class FirstFirst extends Namer
{
    public FirstFirst(String s)
    {
    int i = s.lastIndexOf(" ");
    if (i > 0)
    {
        //left is first name
        first = s.substring(0,i).trim();
        //right is last name
        last =  s.substring(i+1).trim();
    }
    else
    {
        first = "";
        last = s;
    }
    }
}
