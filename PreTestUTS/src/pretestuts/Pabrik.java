
package pretestuts;

import java.util.ArrayList;

/**
 *
 * @author Tampan
 */
public class Pabrik 
{
    static ArrayList<Komputer> listKomputer =  new ArrayList<>();
    ArrayList<Pekerja> listPekerja =  new ArrayList<>();

    public Pabrik() {
    }
    
    
    
    public void tambahPekerja(Pekerja pekerja)
    {
        listPekerja.add(pekerja);
    }
}
