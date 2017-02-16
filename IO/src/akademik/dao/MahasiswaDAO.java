/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akademik.dao;

import akademik.Mahasiswa;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface MahasiswaDAO 
{
    Mahasiswa getMahasiswa(String nim);
    List<Mahasiswa> getAllMahasiswa();
    void insertMahasiswa(Mahasiswa m);
    
}
