package ti1_uts_057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    Dosen dosen;
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    Nilai nilai;
    Programer programer;
    Projek projek;
    
    //menambah mahasiswa ke dosen
    dosen = new Dosen("Pandapotan","Sidikkalang","L","085359144245",2000000);
    mahasiswa = new Mahasiswa("Siti","Medan","L","081259144246","11S14020");
    dosen.tambahMahasiswa(mahasiswa);
    mahasiswa = new Mahasiswa("Adi","Pekanbaru","P","081259144247","11S14057");
    dosen.tambahMahasiswa(mahasiswa);
    mahasiswa = new Mahasiswa("Budi","Dolok Sanggul","P","081259144248", "11S14060");
    dosen.tambahMahasiswa(mahasiswa);
    //menambah matakuliah ke dosen
    mataKuliah = new MataKuliah(121,"PBO",3);
    dosen.tambahMataKuliah(mataKuliah);
    mataKuliah = new MataKuliah(122,"SRUDAT",4);
    dosen.tambahMataKuliah(mataKuliah);
    mataKuliah = new MataKuliah(123,"BASDAT",3);
    dosen.tambahMataKuliah(mataKuliah);
    //mhs 1
    nilai = new Nilai(dosen.getMataKuliah(0),dosen.getMahasiswa(0),80);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(1),dosen.getMahasiswa(0),70);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(2),dosen.getMahasiswa(0),75);
    dosen.menilai(nilai);
    //mhs 2
    nilai = new Nilai(dosen.getMataKuliah(0),dosen.getMahasiswa(1),80);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(1),dosen.getMahasiswa(1),70);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(2),dosen.getMahasiswa(1),75);
    dosen.menilai(nilai);
    //mhs 3
    nilai = new Nilai(dosen.getMataKuliah(0),dosen.getMahasiswa(2),80);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(1),dosen.getMahasiswa(2),70);
    dosen.menilai(nilai);
    nilai = new Nilai(dosen.getMataKuliah(2),dosen.getMahasiswa(2),75);
    dosen.menilai(nilai);
    dosen.listNilaiMahasiswa();
    dosen.profil();
    dosen.lihatNilaiMahasiswa(dosen.getMahasiswa(0));
    dosen.lihatNilaiMahasiswa(mahasiswa);
    mahasiswa = new Mahasiswa("Perdana","Sibolga","L","081259144247","11S14022");
    dosen.lihatNilaiMahasiswa(mahasiswa);
    projek = new Projek(101,"Sistem Informasi",2000);
    dosen.tambahPenelitian(projek);
    projek = new Projek(102,"Sistem Keuangan",1000);
    dosen.tambahPenelitian(projek);
    projek = new Projek(103,"Sistem Sumberdaya",1500);
    dosen.tambahPenelitian(projek);
    dosen.listPenelitian();
    dosen.meneliti(projek);
    projek = new Projek(104,"Sistem Inventory",3000);
    dosen.meneliti(dosen.getProjek(0));
    dosen.meneliti(projek);
    programer= new Programer("Novalina","Tarutung","P","085359144249",500000);
    projek = new Projek(201,"Sistem Security",4000);
    programer.tambahProjek(projek);
    projek = new Projek(202,"Sistem Gudang",5000);
    programer.tambahProjek(projek);
    projek = new Projek(203,"Sistem Kantin",6000);
    programer.tambahProjek(projek);
    programer.listProjek();
    programer.testing(projek);
    dosen.listNilaiMahasiswa();
    
    }
}
