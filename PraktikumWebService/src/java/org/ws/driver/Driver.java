package org.ws.driver;

import org.ws.client.MyDataException_Exception;
import org.ws.entity.*;
import org.ws.myexception.MyDataException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) {
        
//        String pesanServer = hello("Dapot");
//        System.out.println("Pesan Server :" + pesanServer);
//        
//        double hasil = kali(5,7);
//        System.out.println("Hasil kali 5 x 7 : "+hasil);
            try
            {
                org.ws.client.Mahasiswa m = getDataMahasiswa("123");
                System.out.println("MHS Nama: " + m.getNama()+"\tNim : " +m.getNim());
                m = getDataMahasiswa(null);
            }
            catch(MyDataException e)
            {
                System.out.println("Pesan Error dari Server "+e.getMessage());
            }
            catch( MyDataException_Exception e)
            {
                
            }
    }
    private static org.ws.client.Mahasiswa getDataMahasiswa(java.lang.String nim) throws MyDataException, MyDataException_Exception
    {
        org.ws.client.MyHello_Service service = new org.ws.client.MyHello_Service();
        org.ws.client.MyHello port = service.getMyHelloPort();
        return port.getDataMahasiswa(nim);
    }
    
    private static String hello(java.lang.String name)
    {
        org.ws.client.MyHello_Service  service=  new org.ws.client.MyHello_Service();
        org.ws.client.MyHello port =  service.getMyHelloPort();
        return port.hello(name);
    }
    
    private static double kali(int a, int b)
    {
        org.ws.client.MyHello_Service service = new org.ws.client.MyHello_Service();
        org.ws.client.MyHello port = service.getMyHelloPort();
        return port.kali(a, b);
    }
}
