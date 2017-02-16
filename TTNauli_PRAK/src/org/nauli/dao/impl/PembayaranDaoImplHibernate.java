package org.nauli.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.nauli.dao.PembayaranDao;
import org.nauli.dao.PemesananDao;
import org.nauli.model.Pembayaran;
import org.nauli.model.Pemesanan;
import org.nauli.util.HibernateUtil;
/**
 *
 * @author Jayuk
 */

public class PembayaranDaoImplHibernate implements PembayaranDao {

    @Override
    public List<Pembayaran> getAllPembayaran() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pembayaran> pembayaran = session.createCriteria(Pembayaran.class).list();
        session.getTransaction().commit();
        return pembayaran;
    }

    @Override
    public int getTotalPemesanan(int id) {
        PemesananDao pesanDao = new PemesananDaoImplHibernate();
        int total = 0;
        for (Pemesanan pesanan : pesanDao.getAllPemesanan()) {
            if (pesanan.getId() == id) {
                total = pesanan.getTotalPemesanan();
                break;
            }
        }
        return total;
    }

    @Override
    public void konfirmasi(String tujuan, int id) {
        for (Pembayaran pembayaran : getAllPembayaran()) {
            if (pembayaran.getTujuan().equalsIgnoreCase(tujuan)) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                pembayaran.setId(pembayaran.getId());
                pembayaran.setTotalPembayaran(pembayaran.getTotalPembayaran() + getTotalPemesanan(id));
                pembayaran.setTujuan(pembayaran.getTujuan());
                session.update(pembayaran);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public int getTotalPembayaran(int id) {
        int total = 0;
        List<Pembayaran> pembayarans = getAllPembayaran();
        for(Pembayaran pembayaran : pembayarans){
            if(pembayaran.getId() == id){
                total = pembayaran.getTotalPembayaran();
                break;
            }
        }
        return total;
    }

}
