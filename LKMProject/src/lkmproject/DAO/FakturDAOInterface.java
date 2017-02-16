/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Faktur;

/**
 *
 * @author Jayuk
 */
public interface FakturDAOInterface 
{
    public void save(Faktur faktur);
    public Boolean delete(int idFaktur);
    public Boolean edit(Faktur faktur);
    public List<Faktur> getAllFaktur();
    public Faktur getDataFaktur(int idFaktur);
}
