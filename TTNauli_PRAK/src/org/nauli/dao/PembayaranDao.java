package org.nauli.dao;

import java.util.List;
import org.nauli.model.Pembayaran;
/**
 *
 * @author Jayuk
 */

public interface PembayaranDao {
    public List<Pembayaran> getAllPembayaran();
    public int getTotalPemesanan(int id);
    public void konfirmasi(String tujuan,int id);
    public int getTotalPembayaran(int id);
}
