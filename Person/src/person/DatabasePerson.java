package person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jayuk
 */
public class DatabasePerson<T extends Person>
{
    int index;
    private ArrayList<T> databasePerson = new ArrayList<>();
    
    public void tambahPerson(T t)
    {
        databasePerson.add(index, t);
        index++;
    }
    public T getPerson(int index)
    {
        return databasePerson.get(index);
    } 
    public T getPerson(String nama)
    {
        for(int i=0; i <= databasePerson.size();i++)
        {
            if(databasePerson.get(i).nama == nama)
            {
                return databasePerson.get(i);
            }
        }
        return null;
    }
    public void cetakData(String nama)
    {
        T t =getPerson(nama);
        t.info();
    }
}
