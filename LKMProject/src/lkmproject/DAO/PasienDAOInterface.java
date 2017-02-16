/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Pasien;
import lkmproject.model.PasienDaftar;

/**
 *
 * @author Jayuk
 */
public interface PasienDAOInterface 
{
    public void save(Pasien pasien);
    public  Boolean delete(int idPasien);
    public Boolean edit(Pasien pasien);
    public List<Pasien> getAllPasien();
    public Pasien getDataPasien(int idPasien);
}