package inheritance;

/**
 *
 * @author Jayuk
 */
public class Instructor extends Person
{
    private String subject;
    private String title;
    private int salary;
    
    public Instructor(String name,String address,String city,int age,char gender, String subject,String title, int salary)
    {
        super();
        setName(name);
        setAddress(address);
        setCity(city);
        setAge(age);
        setGender(gender);
        if (salary > 0)
                this.salary = salary;
        else
            this.salary = 1;
        this.subject = subject;
        this.title = title;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public void setTitle(String tittle)
    {
        this.title = title;
    }
    public void setSalary(int salary)
    {
        if (salary>0)
            this.salary = salary;
        else
            this.salary = 1;
    }
    public String toString()
    {
        String str = 
               super.toString() + "\n" +
                "Subject    :"+ subject +"\n"+
                "Title      :"+ title +"\n"+
                "Salary     :"+ salary + "\n";
        return str;
    }
}
