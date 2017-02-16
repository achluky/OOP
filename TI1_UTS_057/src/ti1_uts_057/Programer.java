package ti1_uts_057;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public class Programer extends Pekerjaan
{
    private final double gaji;
    private final ArrayList<Projek> listProjek = new ArrayList<>();
    int i;

    public Programer(String nama, String alamat, String jenisKelamin, String nomorTelepon, double gaji) {
        super(nama, alamat,jenisKelamin,nomorTelepon);
        if (gaji > 0)
        this.gaji = gaji;
        else
        {
            this.gaji = 1000000;
            System.out.println("inputan Tidak Valid Gaji di Set ke Default");
        }
    }
    
    public void tambahProjek(Projek projek)
    {
        listProjek.add(i, projek);
        i++;
    }
    
    public void profil()
    {
        System.out.println("Nama    :"+nama);
        System.out.println("Alamat  :"+alamat);
        System.out.println("Jenis Kelamin   :" +jenisKelamin);
        System.out.println("Nomor Telepon   :" +nomorTelepon+"\n\n");
    }
    public void listProjek()
    {
        for(int i=0 ; i<listProjek.size() ; i++){
            System.out.println("Projek "+(i+1));
            System.out.print(listProjek.get(i).nama+"\t"+listProjek.get(i).id+ "\n");
        }
    }
 
    public void testing(Projek projek)
    {
        if(listProjek.contains(projek))
        System.out.println("Testing Projek :"+projek.nama  + " Berhasil");
        else
        System.out.println("Testing projek tidak berhasil");
    }
}