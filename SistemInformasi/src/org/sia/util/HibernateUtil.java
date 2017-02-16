/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sia.util;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Jayuk
 */
public class HibernateUtil 
{

    private static final SessionFactory sessionFactory =   createSessionFactory();
    private static ThreadLocal<Session> session = new ThreadLocal<Session>();
    
     public static SessionFactory createSessionFactory()     
     {
         Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
         return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
     }
    
    public static Session getSession() 
    {
        session.set(sessionFactory.openSession());
        return session.get();
    }
    public static void closeSession()
    {
        Session s = session.get();
        if (s == null)
        {
            s.close();
            session.remove();
        }
    }
}
