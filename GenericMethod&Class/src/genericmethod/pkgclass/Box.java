/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethod.pkgclass;

/**
 *
 * @author Jayuk
 */
public class Box<T> 
{
    private BangunRuang obj;
    public Box()
    {
        
    }
    public Box(BangunRuang obj)
    {
        this.obj = obj;
    }

    public BangunRuang getObj() {
        return obj;
    }

    public void setObj(BangunRuang obj) {
        this.obj = obj;
    }
    
}
