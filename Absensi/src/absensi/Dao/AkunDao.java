/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao;

import absensi.model.Akun;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface AkunDao 
{
    public void saveDataAkun(Akun akun);
    public void updateDataAkun (String username, String passwordBaru);
    public Akun getDataBuku(String username);
    public List<Akun> getAllAkun(); 
    public String login(String username, String password);
    public void deleteMahasiswa (Akun akun);
}
