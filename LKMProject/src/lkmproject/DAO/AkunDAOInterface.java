/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.Akun;

/**
 *
 * @author gracia
 */
public interface AkunDAOInterface 
{
    public void saveAkun(Akun akun);
    public Boolean deleteAkun(int idPengguna);
    public Boolean editAkun(Akun akun);
    public List<Akun> getAllAkun();
    public String getPasswordAkun(int idPengguna);
    public String login(int idPengguna, String passwordPengguna);
}
