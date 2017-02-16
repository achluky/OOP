package org.rest.driver;

import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    private final static String ALAMAT_WEB_SERVICE = "http://localhost:8080/MahasiswaRestService";
    public static void main(String[] args) {
        ClientConfig config =  new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget service = client.target(UriBuilder.fromUri(ALAMAT_WEB_SERVICE).build());
        System.out.println("Get Data Seluruh Mahasiswa Versi TEXT_XML");
        System.out.println(service.path("rest").path("mahasiswas").request().accept(MediaType.TEXT_XML).get(String.class)+"\n");
        System.out.println("GET DATA SELURUH MAHASISWA VERSI JSON");
        System.out.println(service.path("rest").path("mahasiswas").request().accept(MediaType.APPLICATION_JSON).get(String.class)+"\n");   
        System.out.println("GET DATA SELURUH MAHASISWA VERSI APPLICATION_XML");
        System.out.println(service.path("rest").path("mahasiswas").request().accept(MediaType.APPLICATION_XML).get(String.class)+"\n");   
        System.out.println("MENCOBA HAPUS DATA MAHASISWA NIM 2");
        service.path("rest").path("mahasiswas/2").request().delete();   
        System.out.println("DATA MAHASISWA SAAT INI");
        System.out.println(service.path("rest").path("mahasiswas").request().accept(MediaType.APPLICATION_XML).get(String.class));
        
    }
}
