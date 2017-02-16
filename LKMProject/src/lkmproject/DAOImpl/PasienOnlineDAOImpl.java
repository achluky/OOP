/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.PasienOnlineDAOInterface;
import lkmproject.model.PasienOnline;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author gracia
 */
public class PasienOnlineDAOImpl implements PasienOnlineDAOInterface
{

    @Override
    public void savePasienOnline(PasienOnline pasienOnline) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pasienOnline);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean deletePasienOnline(int idPasienOnline) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PasienOnline pasienOnline = (PasienOnline) session.get(PasienOnline.class, idPasienOnline);
        if(pasienOnline == null)
            return false;
        session.delete(pasienOnline);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }
    public void deletePasienOnline(PasienOnline pasienOnline)
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(pasienOnline);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
   }

    @Override
    public Boolean editPasienOnline(PasienOnline pasienOnline) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(pasienOnline);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<PasienOnline> getAllPasienOnline() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<PasienOnline> listPasienOnline = session.createCriteria(PasienOnline.class).list();
        session.getTransaction().commit();
        session.close();
        return listPasienOnline;
    }

    @Override
    public PasienOnline getDataPasienOnline(int idPasienOnline) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PasienOnline pasienOnline = (PasienOnline) session.get(PasienOnline.class, idPasienOnline);
        session.getTransaction().commit();
        session.close();
        return pasienOnline;
    }
    
}
