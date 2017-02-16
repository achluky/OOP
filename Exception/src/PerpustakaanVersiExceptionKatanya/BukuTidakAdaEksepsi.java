/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanVersiExceptionKatanya;

/**
 *
 * @author Jayuk
 */
public class BukuTidakAdaEksepsi extends Exception
{
    public String id;
    
    public BukuTidakAdaEksepsi(String id)
    {
        this.id = id;
    }

    public BukuTidakAdaEksepsi(String id,String message) {
        super(message);
        this.id = id;
    }
    
    
}
