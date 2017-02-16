/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Penyakit;

/**
 *
 * @author Jayuk
 */
public interface PenyakitDAOInterface 
{
    public void save(Penyakit penyakit);
    public  Boolean delete(int idPasien);
    public Boolean edit(Penyakit penyakit);
    public List<Penyakit> getAllPenyakit();
    public Penyakit  getDataPenyakit(int idPasien);
}
