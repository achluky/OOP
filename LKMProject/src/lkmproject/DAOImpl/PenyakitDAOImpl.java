/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.PenyakitDAOInterface;
import lkmproject.model.Penyakit;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class PenyakitDAOImpl implements PenyakitDAOInterface
{

    @Override
    public void save(Penyakit penyakit) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(penyakit);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idPenyakit) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Penyakit penyakit = (Penyakit) session.get(Penyakit.class, idPenyakit);
        if(penyakit == null)
            return false;
        session.delete(penyakit);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean edit(Penyakit penyakit) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(penyakit);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Penyakit> getAllPenyakit() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Penyakit> listPenyakit = session.createCriteria(Penyakit.class).list();
        session.getTransaction().commit();
        session.close();
        return listPenyakit;
    }

    @Override
    public Penyakit getDataPenyakit(int idPenyakit) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Penyakit penyakit = (Penyakit) session.get(Penyakit.class, idPenyakit);
        session.getTransaction().commit();
        session.close();
        return penyakit;
    }
    
}
