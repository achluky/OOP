/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ws.tiketService;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.ws.entity.Tiket;

/**
 *
 * @author Jayuk
 */
@WebService(serviceName = "TiketService")
public class TiketService {

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
    @WebMethod(operationName = "getDataTiket")
    public String getDataTiket(@WebParam(name = "asal") String asal, @WebParam(name = "tujuan") String tujuan) {
        Tiket tiketTemp =  new Tiket (asal,tujuan,200000);
        //System.out.println(tiketTemp.getAsal() +"  "+tiketTemp.getTujuan());
        return tiketTemp.getAsal() +"  "+tiketTemp.getTujuan();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDataAllTiket")
    public List<Tiket> getDataAllTiket() {
        List<Tiket> listTiket =  new ArrayList<>();
        Tiket tiketTemp =  new Tiket ("laguboti","balige",200000);
        listTiket.add(tiketTemp);
        tiketTemp =  new Tiket ("balige","laguboti",200000);
        listTiket.add(tiketTemp);
        return listTiket;
    }
    
}
