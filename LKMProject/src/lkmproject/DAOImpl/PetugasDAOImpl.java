/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.PetugasDAOInterface;
import lkmproject.model.Petugas;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class PetugasDAOImpl implements PetugasDAOInterface
{

    @Override
    public void save(Petugas petugas) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(petugas);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idPetugas) 
    {  
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Petugas petugas = (Petugas) session.get(Petugas.class, idPetugas);
        if(petugas == null)
            return false;
        session.delete(petugas);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean edit(Petugas petugas) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(petugas);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Petugas> getAllPetugas() 
    {
        
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Petugas> listPetugas = session.createCriteria(Petugas.class).list();
        session.getTransaction().commit();
        session.close();
        return listPetugas;
    
    }

    @Override
    public Petugas getDataPetugas(int idPetugas) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Petugas petugas = (Petugas) session.get(Petugas.class, idPetugas);
        session.getTransaction().commit();
        session.close();
        return petugas;
    }
    
}
