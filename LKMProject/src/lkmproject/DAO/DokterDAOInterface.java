/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Dokter;

/**
 *
 * @author Jayuk
 * @param <T>
 */
public interface DokterDAOInterface
{
    public void save(Dokter deokter);
    public Boolean delete(int idDokter);
    public Boolean edit(Dokter dokter);
    public List<Dokter> getAllDokter();
    public Dokter getDataDokter(int idDokter);
}
