package inheritance;

/**
 *
 * @author Jayuk
 */
public class Person 
{
    private String name;
    private String address;
    private String city;
    private int age;
    private char gender;
    
    void setName(String name)
    {
        this.name = name;
    }
    void setAddress(String address)
    {
        this.address = address;
    }
    void setCity(String city)
    {
        this.city = city;
    }
    void setAge(int age)
    {
        if(age>0)
        {
            this.age = age;
        }
        else
        {
            System.out.println("Masukan salah, age di set ke 1");
        }
    }
    void setGender(char gender)
    {
        if(gender == 'L' || gender == 'l')
        {
            this.gender = 'L';
        }
        else if(gender == 'P' || gender == 'P')
        {
            this.gender = 'P';
        }
        else
        {
            System.out.println("Inputan salah");
        }
    }
    String getName()
    {
        return name;
    }
    String getAddress()
    {
        return address;
    }
    String getCity()
    {
        return city;
    }
    int getAge()
    {
        return age;
    }
    char getGender()
    {
        return gender;
    }
    public String toString()
    {
        String str =
                "name       :" + name +"\n" +
                "address    :" +address+ "\n"+
                "city       :" +city+ "\n"+
                "age        :" +age+ "\n";
        return str;
    }
}
