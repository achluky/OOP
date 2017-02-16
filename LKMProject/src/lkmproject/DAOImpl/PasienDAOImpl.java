/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.PasienDAOInterface;
import lkmproject.model.Pasien;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class PasienDAOImpl implements PasienDAOInterface
{
    @Override
    public  void save(Pasien pasien) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pasien);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idPasien) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Pasien pasien = (Pasien) session.get(Pasien.class, idPasien);
        if(pasien == null)
            return false;
        session.delete(pasien);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean edit(Pasien pasien) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(pasien);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Pasien> getAllPasien() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pasien> listPasien = session.createCriteria(Pasien.class).list();
        session.getTransaction().commit();
        session.close();
        return listPasien;
    }

    @Override
    public Pasien getDataPasien(int idPasien) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Pasien pasien = (Pasien) session.get(Pasien.class, idPasien);
        session.getTransaction().commit();
        session.close();
        return pasien;
    }
}
