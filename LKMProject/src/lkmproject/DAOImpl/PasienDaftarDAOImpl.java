/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.PasienDaftarDAOInterface;
import lkmproject.model.PasienDaftar;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class PasienDaftarDAOImpl implements PasienDaftarDAOInterface
{
    @Override
    public  void save(PasienDaftar pasienDaftar) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pasienDaftar);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean delete(int idPasienDaftar) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PasienDaftar pasienDaftar = (PasienDaftar) session.get(PasienDaftar.class, idPasienDaftar);
        if(pasienDaftar == null)
            return false;
        session.delete(pasienDaftar);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean edit(PasienDaftar pasienDaftar) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(pasienDaftar);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<PasienDaftar> getAllPasienDaftar() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<PasienDaftar> listPasienDaftar = session.createCriteria(PasienDaftar.class).list();
        session.getTransaction().commit();
        session.close();
        return listPasienDaftar;
    }

    @Override
    public PasienDaftar getDataPasienDaftar(int idPasienDaftar) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        PasienDaftar pasienDaftar = (PasienDaftar) session.get(PasienDaftar.class, idPasienDaftar);
        session.getTransaction().commit();
        session.close();
        return pasienDaftar;
    }
}
