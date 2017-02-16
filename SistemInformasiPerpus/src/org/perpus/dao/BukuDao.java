package org.perpus.dao;

import java.util.List;
import org.perpus.model.Buku;

/**
 *
 * @author Wira
 */
public interface BukuDao 
{
   public void saveDataBuku(Buku b);
   public Buku getDataBuku(int isbn);
   public List<Buku> getAllBuku(); 
}
