/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sia.dao;

import java.util.List;
import org.sia.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public interface MahasiswaDao 
{
    public void saveDataMahasiswa(Mahasiswa m);
    public Mahasiswa getDataMahasiswa(int nim);
    public List<Mahasiswa> getAllMahasiswa();
}
