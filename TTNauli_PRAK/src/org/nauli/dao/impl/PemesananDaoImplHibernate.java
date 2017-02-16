package org.nauli.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.nauli.dao.PemesananDao;
import org.nauli.model.Pemesanan;
import org.nauli.util.HibernateUtil;
/**
 *
 * @author Jayuk
 */

public class PemesananDaoImplHibernate implements PemesananDao {

    @Override
    public void saveDataPesanan(Pemesanan pemesanan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pemesanan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pemesanan> getAllPemesanan() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pemesanan> pesanan = session.createCriteria(Pemesanan.class).list();
        session.getTransaction().commit();
        return pesanan;
    }

    @Override
    public void deletePemesanan(int id) {
        for (Pemesanan pesanan : getAllPemesanan()) {
            if (pesanan.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.delete(pesanan);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public String getTujuanPesanan(int id) {
        String str = null;
        for (Pemesanan pesanan : getAllPemesanan()) {
            if (pesanan.getId() == id) {
                str = pesanan.getTujuan();
                break;
            }
        }
        return str;
    }

    @Override
    public int getTotalPemesanan(String tujuan) {
        int total = 0;
        List<Pemesanan> pesanans = getAllPemesanan();
        for(Pemesanan pesanan : pesanans){
            if(pesanan.getTujuan().equalsIgnoreCase(tujuan)){
                total+=pesanan.getTotalPemesanan();
            }
        }
        return total;
    }

}
