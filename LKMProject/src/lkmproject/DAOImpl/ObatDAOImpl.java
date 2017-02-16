/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.ObatDAOInterface;
import lkmproject.model.Obat;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class ObatDAOImpl implements ObatDAOInterface
{

    @Override
    public void save(Obat obat) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(obat);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idObat) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Obat obat = (Obat) session.get(Obat.class, idObat);
        if(obat == null)
            return false;
        session.delete(obat);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean edit(Obat obat) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(obat);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Obat> getAllObat() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Obat> listObat = session.createCriteria(Obat.class).list();
        session.getTransaction().commit();
        session.close();
        return listObat;
    }

    @Override
    public Obat getDataObat(int idObat) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Obat obat = (Obat) session.get(Obat.class, idObat);
        session.getTransaction().commit();
        session.close();
        return obat;
    }
    
}
