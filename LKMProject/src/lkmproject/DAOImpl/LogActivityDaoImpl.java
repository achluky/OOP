/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.LogActivityDAOInterface;
import lkmproject.model.LogActivity;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class LogActivityDaoImpl implements LogActivityDAOInterface
{

    @Override
    public void saveLogActivity(LogActivity logActivity) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(logActivity);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean deleteLogActivity(int idLogActivity) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        LogActivity logActivity;
        try
        {
            logActivity = (LogActivity) session.get(LogActivity.class, idLogActivity);
            session.delete(logActivity);
        }
        catch(NullPointerException npe)
        {
            return false;
        }
        finally
        {
            session.getTransaction().commit();
            HibernateUtil.closeSession();
        }
        return true;
    }

    @Override
    public List<LogActivity> getAllLogActivity() 
    {
        List<LogActivity> listLogActivity = null;
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        try
        {
            listLogActivity =  session.createCriteria(LogActivity.class).list();
        }
        catch(NullPointerException npe)
        {
            
        }
        finally
        {
            session.getTransaction().commit();
            HibernateUtil.closeSession();
        }
        return listLogActivity;
    }

    @Override
    public LogActivity getDataLogActivity(int idLogActivity) 
    {
        LogActivity logActivity = null;
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        try
        {
            logActivity = (LogActivity) session.get(LogActivity.class, idLogActivity);
        }
        catch(NullPointerException npe)
        {
            
        }
        finally
        {
            session.getTransaction().begin();
            HibernateUtil.closeSession();
        }
        return logActivity;
    }
    
}
