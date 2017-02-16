package inheritance;

/**
 *
 * @author Jayuk
 */
public class Student extends Person
{
    private String id;
    private String stuClass;
    private int semester;
    private StudentReport report;
    
    public Student(String name, String address, String city, int age, char gender, String id, String stuClass, int semester, StudentReport Report)
    {
        super();
        setName(name);
        setAddress(address);
        setCity(city);
        setAge(age);
        setGender(gender);
        this.id = id;
        this.semester = semester;
        this.stuClass = stuClass;
        report = new StudentReport(Report);
    }
        public void setId(String id)
        {
            this.id = id;
        }
        public void setStuClass(String stuClass)
        {
            this.stuClass = stuClass;
        }
        public void setSemester(int semester)
        {
            this.semester = semester;
        }
        public void setReport(StudentReport report)
        {
            this.report = report;
        }
        public String getId()
        {
            return id;
        }
        public String getStuClass()
        {
            return stuClass;
        }
        public int getSemester()
        {
            return semester;
        }
        public StudentReport getReport()
        {
            return report;
        }
        public String toString()
        {
            String str = 
                    super.toString() + "\t Information from Student\n"+
                    "Id     :"+ id +"\n"+
                    "Kelas  :"+ stuClass +"\n"+
                    "Semester   :"+ semester + report.toString();
            return str;
        }
 }
