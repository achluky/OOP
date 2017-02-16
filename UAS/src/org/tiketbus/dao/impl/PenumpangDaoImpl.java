/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tiketbus.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.tiketbus.dao.PenumpangDao;
import org.tiketbus.model.Penumpang;
import org.tiketbus.util.HibernateUtil;

/**
 *
 * @author Jayuk
 */
public class PenumpangDaoImpl implements PenumpangDao
{

    @Override
    public void saveDataPenumpang(Penumpang penumpang) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(penumpang);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Penumpang getDataPenumpang(int id) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Penumpang penumpang = (Penumpang)session.get(Penumpang.class,id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return penumpang;
    }

    @Override
    public List<Penumpang> getAllPenumpang() 
    {
        List<Penumpang> listPenumpang = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        listPenumpang = session.createCriteria(Penumpang.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return listPenumpang;
    }
    public List<Penumpang> getAllPenumpangBelumbayar() 
    {
        List<Penumpang> listPenumpang = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        
        listPenumpang = session.createCriteria(Penumpang.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return listPenumpang;
    }
    

    @Override
    public boolean updateDataPenumpang(int id) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Penumpang penumpang = (Penumpang) session.get(Penumpang.class, id);
        if(penumpang == null)
            return false;
        session.update(penumpang);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }
    @Override
    public boolean updateDataPenumpang(Penumpang penumpang) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(penumpang);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public boolean deleteDataPenumpang(int id) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Penumpang penumpang = (Penumpang) session.get(Penumpang.class, id);
        if(penumpang == null)
            return false;
        session.delete(penumpang);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }
    
}
