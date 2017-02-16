/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;


import java.util.List;
import lkmproject.DAO.DokterDAOInterface;
import lkmproject.model.Dokter;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;



public class DokterDAOImpl implements DokterDAOInterface
{

    @Override
    public void save(Dokter dokter) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(dokter);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idDokter) 
    {
        try
        {
            Session session = HibernateUtil.getSession();
            session.getTransaction().begin();
            Dokter dokter = (Dokter) session.get(Dokter.class, idDokter);
            if(dokter == null)
            return false;
            session.delete(dokter);
            session.getTransaction().commit();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return true;
    }

    @Override
    public Boolean edit(Dokter dokter) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(dokter);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Dokter> getAllDokter() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Dokter> listDokter = session.createCriteria(Dokter.class).list();
        session.getTransaction().commit();
        session.close();
        return listDokter;
    }

    @Override
    public Dokter getDataDokter(int idDokter) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Dokter dokter = (Dokter) session.get(Dokter.class, idDokter);
        session.getTransaction().commit();
        session.close();
        return dokter;
    }
    
}
