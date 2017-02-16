/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akademik;

import akademik.dao.KelasDAO;
import akademik.dao.MahasiswaDAO;
import akademik.model.Kelas;
import akademik.model.Mahasiswa;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException 
    {
        Mahasiswa mahasiswa =  new Mahasiswa("12","dapot",3.5, new Kelas(1,"INFORMATIKA"));
        MahasiswaDAO mahasiswaDao =  new MahasiswaDAO();
        mahasiswaDao.addMahasiswa(mahasiswa);
        Kelas kelas = new Kelas (1,"INFORMATIKA");
        KelasDAO kelasDao = new KelasDAO();
        kelasDao.addKelas(kelas);
        mahasiswaDao.deleteMahasiswa("12");
        System.out.println(mahasiswaDao.getMahasiswaByNim("12"));
        
        //List<Mahasiswa> ms = mahasiswaDao.getAllMahasiswa();
        //for(Mahasiswa m : ms)
        //{
        //    System.out.println(m);
        //}
    }
    
}
