package bank;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Bank 
{
    ArrayList<Person> listPerson = new ArrayList<>();
    ArrayList<Object> listAkun = new ArrayList<>();
    
    public void login(String id,String password)
    {
        for(Person person :listPerson)
            if(person.getId().equalsIgnoreCase(id)||person.getPassword().equalsIgnoreCase(password))
            {
                System.out.println("");
            }
    }
    
    public void tambahPerson(Person person)
    {
        ArrayList<Akun> akun = new ArrayList<>();
        listAkun.add(akun);
        listPerson.add(person);
    }
    public void tambahAkun(String id, String password, Akun akun)
    {
        for(Person person : listPerson)
        {
            if(person.getId().equalsIgnoreCase(id)||person.getPassword().equalsIgnoreCase(password))
            {
                
            }
        }
    }
    public Akun aksesAkun(String id, String password)
    {
        for(Akun akun :listAkun)
        {
            if(akun.getId().equalsIgnoreCase(id)||akun.getPassword().equalsIgnoreCase(password))
            {
                return akun;
            }
        }
        return null;
    }
        
}
