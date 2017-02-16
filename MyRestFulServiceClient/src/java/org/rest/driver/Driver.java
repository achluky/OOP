/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rest.driver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static final String ALAMAT_WEB_SERVICE = "http://localhost:8080/MahasiswaRestService";
    public static void main(String[] args) {
        ClientConfig config =  new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(UriBuilder.fromUri(ALAMAT_WEB_SERVICE).build());
        System.out.println("Memanggil Rest Tipe Text Plain :");
        String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(plainAnswer + "\n");
        System.out.println("Memanggil Rest Tipe XML :");
        String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
        System.out.println(xmlAnswer +"\n");
        System.out.println("Memanggil Rest Tipe HTML :");
        String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
        System.out.println(htmlAnswer+"\n");
        System.out.println("Memanggil Rest Tipe JSON :");
        String jsonAnswer = target.path("rest").path("hello").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(jsonAnswer+"\n");
    }
}
