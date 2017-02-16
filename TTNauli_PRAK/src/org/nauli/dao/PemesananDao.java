
package org.nauli.dao;

import java.util.List;
import org.nauli.model.Pemesanan;
/**
 *
 * @author Jayuk
 */

public interface PemesananDao {
    public void saveDataPesanan(Pemesanan pemesanan);
    public List<Pemesanan> getAllPemesanan();
    public void deletePemesanan(int id);
    public String getTujuanPesanan(int id);
    public int getTotalPemesanan(String tujuan);
    
    
}
