/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.PasienDaftar;

/**
 *
 * @author Jayuk
 */
public interface PasienDaftarDAOInterface 
{
    public void save(PasienDaftar pasienDaftar);
    public  Boolean delete(int idPasienDaftar);
    public Boolean edit(PasienDaftar pasienDaftar);
    public List<PasienDaftar> getAllPasienDaftar();
    public PasienDaftar getDataPasienDaftar(int idPasienDaftar);
}
