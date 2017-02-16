/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanDAO;

import Perpustakaan.Buku;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public interface BukuDAO 
{
    public Buku getBuku(String id);
    public List<Buku> getAllBuku();
    public void insertBuku(Buku buku);
}
