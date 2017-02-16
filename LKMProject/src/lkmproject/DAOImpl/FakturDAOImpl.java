/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.FakturDAOInterface;
import lkmproject.model.Faktur;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class FakturDAOImpl implements FakturDAOInterface
{

    @Override
    public void save(Faktur faktur) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(faktur);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idFaktur) 
    {
        try
        {
            Session session = HibernateUtil.getSession();
            session.getTransaction().begin();
            Faktur faktur = (Faktur) session.get(Faktur.class, idFaktur);
            if(faktur == null)
            return false;
            session.delete(faktur);
            session.getTransaction().commit();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return true;
    }

    @Override
    public Boolean edit(Faktur faktur) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(faktur);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Faktur> getAllFaktur() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Faktur> listFaktur = session.createCriteria(Faktur.class).list();
        session.getTransaction().commit();
        session.close();
        return listFaktur;
    }

    @Override
    public Faktur getDataFaktur(int idFaktur) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Faktur faktur = (Faktur) session.get(Faktur.class, idFaktur);
        session.getTransaction().commit();
        session.close();
        return faktur;
    }
    
}
