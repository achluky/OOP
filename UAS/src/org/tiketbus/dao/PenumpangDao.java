/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tiketbus.dao;

import static java.util.Collections.list;
import java.util.List;
import org.tiketbus.model.Penumpang;

/**
 *
 * @author Jayuk
 */
public interface PenumpangDao 
{
    public void saveDataPenumpang(Penumpang penumpang);
    public Penumpang getDataPenumpang(int id);
    public List<Penumpang> getAllPenumpang();
    public boolean updateDataPenumpang(int id);
    public boolean updateDataPenumpang(Penumpang penumpang);
    public boolean deleteDataPenumpang(int id);
    
}
