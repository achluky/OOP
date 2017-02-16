/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.PasienOnline;

/**
 *
 * @author gracia
 */
public interface PasienOnlineDAOInterface
{
    public void savePasienOnline(PasienOnline pasienOnline);
    public Boolean deletePasienOnline(int idPasienOnline);
    public Boolean editPasienOnline(PasienOnline pasienOnline);
    public List<PasienOnline> getAllPasienOnline();
    public PasienOnline getDataPasienOnline(int idPasienOnline);
}
