/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Obat;

/**
 *
 * @author Jayuk
 */
public interface ObatDAOInterface 
{
    public void save(Obat obat);
    public  Boolean delete(int idObat);
    public Boolean edit(Obat obat);
    public List<Obat> getAllObat();
    public Obat getDataObat(int idObat);
}
