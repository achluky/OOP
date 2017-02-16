package ti1_uts_057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Jayuk
 */
public class Dosen extends Pekerjaan
{
    private final double gaji;
    String nid;
    int indexNilai;
    private final ArrayList<Projek> listProjek = new ArrayList<>();
    private final ArrayList<MataKuliah> listMataKuliah = new ArrayList<>();
    private final ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
    private final ArrayList<Nilai> listNilai = new ArrayList<>();
    private int i = 0,j = 0,k = 0;
   
    
    Dosen(String nama, String alamat, String jenisKelamin, String nomorTelepon, double gaji)
    {
        super(nama, alamat,jenisKelamin,nomorTelepon);
        if (gaji > 0)
        this.gaji = gaji;
        else
        {
            this.gaji = 1000000;
            System.out.println("inputan Tidak Valid Gaji di Set ke Default");
        }
    }
    
    public void tambahMahasiswa(Mahasiswa mahasiswa)
    {
        listMahasiswa.add(i, mahasiswa);
        i++;
    }
    public void tambahMataKuliah(MataKuliah mataKuliah)
    {
        listMataKuliah.add(j, mataKuliah);
        j++;
    }
    public void tambahPenelitian(Projek projek)
    {
        listProjek.add (k,projek);
        k++;
    }
    public MataKuliah getMataKuliah(int index)
    {
        return listMataKuliah.get(index);
    }
    public Mahasiswa getMahasiswa(int index)
    {
        return listMahasiswa.get(index);
    }
    public void menilai(Nilai nilai)
    {
        listNilai.add(indexNilai, nilai);
        indexNilai++;
    }
    public void listNilaiMahasiswa()
    {
        for(int jl=0 ; jl<listNilai.size() ; jl++){
            System.out.print(listNilai.get(jl).mataKuliah.namaMataKuliah+"\t"+listNilai.get(jl).mahasiswa.nama+ "\t" + listNilai.get(jl).nilai+"\n");
        }
    }
    public void profil()
    {
        System.out.println("\n\nNama    :"+nama);
        System.out.println("Alamat  :"+alamat);
        System.out.println("Jenis Kelamin   :" +jenisKelamin);
        System.out.println("Nomor Telepon   :" +nomorTelepon+"\n\n");
    }
    public void lihatNilaiMahasiswa(Mahasiswa mahasiswa)
    {
        System.out.println("Mencari nilai dari mahasiswa yang bernama  :"+ mahasiswa.nama);
        int flag = 0;
        for(int m =0;m<listNilai.size();m++)
        {
            if(listNilai.get(m).mahasiswa.nama.equals(mahasiswa.nama))
            {
                System.out.println("Mata Kuliah :" +listNilai.get(m).mataKuliah.namaMataKuliah+"\t" + "Nilai   :" + listNilai.get(m).nilai);
                flag++;
            }
                
        }
        if (flag == 0) 
        System.out.println("Nilai "+mahasiswa.nama+ " tidak tersedia");
            
    }
        
    public void listPenelitian()
    {
        for(int jk=0 ; jk<listProjek.size() ; jk++){
            System.out.println("Projek "+(jk+1));
            System.out.println(listProjek.get(jk).nama+"\t"+listProjek.get(jk).id);
        }
    }
    public void meneliti(Projek projek)
    {
        if(listProjek.contains(projek))
        System.out.println("Penelitian Projek :"+projek.nama+ "\tHarga  :"+projek.hargaProjek  + " Berhasil");
        else
        System.out.println("penelitian projek "+projek.nama+" tidak berhasil");
    }
    public Projek getProjek(int index)
    {
        return listProjek.get(index);
    }
}
