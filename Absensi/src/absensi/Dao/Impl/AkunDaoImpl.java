/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao.Impl;

import absensi.Dao.AkunDao;
import absensi.model.Akun;
import absensi.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class AkunDaoImpl implements AkunDao
{

    @Override
    public void saveDataAkun(Akun akun) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateDataAkun(String username, String passwordBaru) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Akun akun = (Akun) session.get(Akun.class, username);
        akun.setPassword(passwordBaru);
        session.update(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Akun getDataBuku(String username) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Akun akun = (Akun) session.get(Akun.class, username);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return akun;
    }

    @Override
    public List<Akun> getAllAkun() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Akun> akun = session.createCriteria(Akun.class).list();
        session.getTransaction().commit();
        return akun;
    }

    @Override
    public String login(String username, String password) 
    {
        List<Akun> listAkun = getAllAkun();
        for(Akun akun  : listAkun)
        {
            if(akun.getUsername().equalsIgnoreCase(username))
            {
                if(akun.getPassword().equalsIgnoreCase(password))
                {
                    return akun.getRole();
                }
            }
        }
        return "Kosong";
    }

    @Override
    public void deleteMahasiswa(Akun akun)
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
                
    }
    
}
