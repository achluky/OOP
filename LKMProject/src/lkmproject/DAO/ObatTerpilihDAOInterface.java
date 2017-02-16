/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAO;

import java.util.List;
import lkmproject.model.ObatTerpilih;

/**
 *
 * @author Jayuk
 */
public interface ObatTerpilihDAOInterface
{
    public void saveObatTerpilih(ObatTerpilih obatTerpilih);
    public  Boolean deleteObatTerpilih(int idObatTerpilih);
    public Boolean editObatTerpilih(ObatTerpilih obatTerpilih);
    public List<ObatTerpilih> getAllObatTerpilih();
    public ObatTerpilih getDataObatTerpilih(int idObatTerpilih);
}
