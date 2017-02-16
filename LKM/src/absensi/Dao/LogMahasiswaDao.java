/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao;

import absensi.model.Logmahasiswa;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface LogMahasiswaDao 
{
    public void saveLogMahasiswa(Logmahasiswa logMahasiswa);
    public Logmahasiswa getDataLogMahasiswa (String nim);
    public List<Logmahasiswa> getAllLogMahasiswa();
}
