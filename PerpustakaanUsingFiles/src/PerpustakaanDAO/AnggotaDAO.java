/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanDAO;

import Perpustakaan.Anggota;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface AnggotaDAO 
{
    public Anggota getAnggota(String id);
    public List<Anggota> getAllAnggota();
    public void insertAnggota(Anggota anggota);
}
