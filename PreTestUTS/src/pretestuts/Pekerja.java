package pretestuts;

import static pretestuts.Pabrik.listKomputer;

/**
 *
 * @author Tampan
 */
public class Pekerja implements Runnable
{
    private String nik;
    private String nama;
    private double tunjangan;
    private double bonus;
    private final double UMR = 100;
    Komputer komputerMasuk;
    int jumlahKomputerMasuk;

    public Pekerja(String nik, String nama, double tunjangan, double bonus)
    {
        this.nik = nik;
        this.nama = nama;
        this.tunjangan= tunjangan;
        this.bonus =  bonus;
    }
    
    public void addKomputer(Komputer komputer)
    {
        jumlahKomputerMasuk = komputer.getStok();
        komputerMasuk=komputer;
        Pabrik.listKomputer.add(komputer);

    }
    

    @Override
    public void run() 
    {
        for(int i=0;i<jumlahKomputerMasuk;i++)
        {
            komputerMasuk.tambahStok();
        }
        for(int i=0;i<listKomputer.size();i++)
        {
            if((listKomputer.get(i).getMerek() == null ? (komputerMasuk.getMerek()) == null : listKomputer.get(i).getMerek().equals(komputerMasuk.getMerek())) || listKomputer.get(i).getTipe()==(komputerMasuk.getTipe()))
            {
                Pabrik.listKomputer.add(i, komputerMasuk);
                break;
            }
        }
    }
    
}

