
package person;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DatabasePerson dataBase = new DatabasePerson();
        Mahasiswa m1 = new Mahasiswa("dapot","1","2",3,4);
        Mahasiswa m2 = new Mahasiswa("dopat","1","2",3,4);
        Mahasiswa m3 = new Mahasiswa("dapit","1","2",3,4);
        
        Dosen d1 = new Dosen("dipat","jalajdfnd","jsbdbb",20, 40);
        Dosen d2 = new Dosen("dupat","jalajdfnd","jsbdbb",20, 40);
        
        dataBase.tambahPerson(m1);
        dataBase.tambahPerson(m2);
        dataBase.tambahPerson(m3);
        dataBase.tambahPerson(d1);
        dataBase.tambahPerson(d2);
        
        dataBase.cetakData("dapot");
    }
    
}
