package uts2;

import java.util.ArrayList;

/**
 *
 * @author Bernando Lumban Raja
 */
public class PerusahaanXYZ {
    String nama;
    String alamat;
    int i;
   
    public PerusahaanXYZ() {
    }

    ArrayList<Pegawai> listPegawai = new ArrayList<>();
    
    public Pegawai getPegawai(int i)
    {
        return listPegawai.get(i);
    }
    public void tampilkanSemuaKomponen()
    {
        for(int i=0;i < listPegawai.size();i++)
        {
            int urutan = i +1;
            System.out.println("Urutan ke : "+urutan);
            System.out.println("\tNik          : "+listPegawai.get(i).getNik());
            System.out.println("\tNama         : "+listPegawai.get(i).getNama());
            System.out.println("\tDurasi kerja : "+listPegawai.get(i).getDurasiKerja());
        }
    } 
    
    

    public PerusahaanXYZ(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
    
    
    
}
