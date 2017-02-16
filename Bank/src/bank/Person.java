package bank;



/**
 *
 * @author Jayuk
 */
public class Person 
{
    private String nama;
    private String id;
    private String password;
    
    
    
    public Person(String nama,String id, String password)
    {
        this.nama =  nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public void aksesAkun(String id, String password)
    {
        
    }
}
