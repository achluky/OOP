package inheritance;

/**
 *
 * @author Jayuk
 */
public class StudentReport 
{
    private static int nbSubject;
    private String subject1;
    private String subject2;
    private int credit1;
    private int credit2;
    private int grade1;
    private int grade2;
    
    StudentReport()
    {
        
    }
    StudentReport(String subject1, String subject2, int credit1, int credit2, int grade1, int grade2)
    {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.credit1 = credit1;
        this.credit2 = credit2;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }
    public static int getNbSubject() {
        return nbSubject;
    }

    public static void setNbSubject(int mSubject) {
        StudentReport.nbSubject = mSubject;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public int getCredit1() {
        return credit1;
    }

    public void setCredit1(int credit1) {
        this.credit1 = credit1;
    }

    public int getCredit2() {
        return credit2;
    }

    public void setCredit2(int credit2) {
        this.credit2 = credit2;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }
    StudentReport(StudentReport sp)
    {
        subject1 = sp.getSubject1();
        subject2 = sp.getSubject2();
        credit1 = sp.getCredit1();
        credit2 = sp.getCredit2();
        grade1 = sp.getGrade1();
        grade2 = sp.getGrade2();
    }
    public float countNR()
    {
        return (getGrade1() * getCredit1() + getGrade2() * getCredit2())/ (getCredit1()+getCredit2());
    }
    public String toString()
    {
        return new String(
        "\n\tinformation from StudentReport\n"+
        "Subject1   :" + getSubject1() +
        "\nCredit1  :" + getCredit1() +
        "\nGrade    :" + getGrade1()+
        "Subject2   :" + getSubject2() +
        "\nCredit2  :" + getCredit2() +
        "\nGrade    :" + getGrade2());
        //(((getCredit1() != 0) || (getCredit2() != 0)) ? (countNR() + "\nNilai Akhir  :");           
    }
}
