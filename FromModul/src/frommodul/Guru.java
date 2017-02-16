/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frommodul;

/**
 *
 * @author Jayuk
 */
public class Guru  extends Manusia
{
    private String nik;
    
    
    public Guru()
    {
        
    }
    
    public Guru(String nik, String nama, char jenisKelamin)
    {
        super(nama, jenisKelamin);
        this.nik = nik;
    }
    public Guru(String nik)
{
this.nik = nik;
}
public String getNik()
{
return nik;
}
public void setNik(String nik)
{
this.nik = nik;
}
}
