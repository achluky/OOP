package org.perpus.controller.impl;

import java.util.List;
import org.hibernate.Session;
import org.perpus.dao.BukuDao;
import org.perpus.model.Buku;
import org.perpus.util.HibernateUtil;

/**
 *
 * @author Wira
 */
public class BukuDaoImplHibernate implements BukuDao
{
    @Override
    public void saveDataBuku(Buku b) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(b);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Buku getDataBuku(int isbn) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Buku b = (Buku)session.get(Buku.class,isbn);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return b;
    }

    @Override
    public List<Buku> getAllBuku() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Buku> bukus = session.createCriteria(Buku.class).list();
        session.getTransaction().commit();
        session.flush();
        session.close();
        return bukus;
    }   
}
