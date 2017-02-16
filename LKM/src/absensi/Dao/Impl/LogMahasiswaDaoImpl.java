/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao.Impl;

import absensi.Dao.LogMahasiswaDao;
import absensi.model.Logmahasiswa;
import absensi.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class LogMahasiswaDaoImpl implements LogMahasiswaDao
{

    @Override
    public void saveLogMahasiswa(Logmahasiswa logMahasiswa) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(logMahasiswa);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Logmahasiswa getDataLogMahasiswa(String nim) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Logmahasiswa logMahasiswa = (Logmahasiswa) session.get(Logmahasiswa.class,nim);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return logMahasiswa;
    }

    @Override
    public List<Logmahasiswa> getAllLogMahasiswa() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Logmahasiswa> listLogMahasiswa =  session.createCriteria(Logmahasiswa.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return listLogMahasiswa;
    }
    
}
