package factorypatern1;

/**
 *
 * @author Jayuk
 */
public class LastFirst extends Namer
{
    public LastFirst(String s)
    {
        int i = s.indexOf(" ");
        if(i>0)
        {
            //left is last name
            last = s.substring(0,i).trim();
            //right is first name
            first = s.substring(i+1).trim();
        }
        else
        {
            last = s;
            first = " ";
        }
    }
}
