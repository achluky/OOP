/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao;

import absensi.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface MahasiswaDao 
{
    public void saveDataMahasiswa(Mahasiswa mahasiswa);
    public void deleteMahasiswa(Mahasiswa mahasiswa);
    public void updateDataMahasiswa(Mahasiswa mahasiswa);
    public Mahasiswa getDataMahasiswa(String nim);
    public List<Mahasiswa> getAllMahasiswa(); 
}
