/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Petugas;

/**
 *
 * @author Jayuk
 */
public interface PetugasDAOInterface 
{
    public void save(Petugas petugas);
    public Boolean delete(int idPetugas);
    public Boolean edit(Petugas petugas);
    public List<Petugas> getAllPetugas();
    public Petugas getDataPetugas(int idPetugas);
}
