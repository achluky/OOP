/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author Jayuk
 */
public class Student 
{
    private String rollNo;
    private String name;
    
    public String getRollNo()
    {
        return rollNo;
    }
    public void setRollNo(String rollNo)
    {
        this.rollNo =  rollNo;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name =  name;
    }
    
}
