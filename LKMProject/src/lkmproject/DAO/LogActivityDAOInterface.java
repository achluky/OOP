/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.LogActivity;

/**
 *
 * @author Jayuk
 */
public interface LogActivityDAOInterface 
{
    public void saveLogActivity(LogActivity logActivity);
    public Boolean deleteLogActivity(int idLogActivity);
    public List<LogActivity> getAllLogActivity();
    public LogActivity getDataLogActivity(int idLogActivity);
}
