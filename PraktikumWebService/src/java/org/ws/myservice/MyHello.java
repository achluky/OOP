/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ws.myservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.ws.entity.Mahasiswa;
import org.ws.myexception.MyDataException;

/**
 *
 * @author Jayuk
 */
@WebService(serviceName = "MyHello")
public class MyHello {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "kali")
    public double kali(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a*b;
    }

    @WebMethod(operationName = "getDataMahasiswa")
    public Mahasiswa getDataMahasiswa(@WebParam(name = "nim") String nim) throws MyDataException {
        if(nim == null)
        {
            throw new MyDataException("Nim Kosong");
        }
        return new Mahasiswa("dapot","123");
    }
}
