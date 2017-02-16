package org.rest.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import org.rest.dao.MahasiswaDAO;
import org.rest.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public class MahasiswaResource 
{
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String nim;
    public MahasiswaResource(UriInfo uriInfo, Request request, String nim)
    {
        this.uriInfo = uriInfo;
        this.request = request;
        this.nim = nim;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Mahasiswa getMahasiswa()
    {
        Mahasiswa mahasiswa = getMahasiswa(nim,MahasiswaDAO.intance.getModel());
        System.out.println("Data Mahasiswa :"+mahasiswa.getNama() + "\t"+mahasiswa.getNim());
        if(mahasiswa == null)
        {
            throw new RuntimeException("GET : Mahasiswa "+nim+" tidak ditemukan");
        }
        return mahasiswa;
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Mahasiswa getMahasiswaHTML()
    {
        Mahasiswa mahasiswa =  getMahasiswa(nim,MahasiswaDAO.intance.getModel());
        if(mahasiswa == null)
        {
            throw new RuntimeException("GET: Mahasiswa "+nim+"tidak ditemukan");
        }
        return mahasiswa;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response setDataMahasiswa(JAXBElement<Mahasiswa> mahasiswaXML)
    {
        Mahasiswa c = mahasiswaXML.getValue();
        return putAndResponse(c);
    }
    @DELETE
    public void deleteMahasiswa()
    {
        Mahasiswa mahasiswa = deleteMahasiswa(nim,MahasiswaDAO.intance.getModel());
        if(mahasiswa == null)
        {
            throw new RuntimeException("Delete : Mahasiswa "+nim+"tidak ditemukan");
        }
    }
    
    private Response putAndResponse(Mahasiswa mahasiswa)
    {
        Response res;
        if(getMahasiswa(mahasiswa.getNim(),MahasiswaDAO.intance.getModel())!= null)
        {
            res = Response.noContent().build();
        }
        else
        {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        MahasiswaDAO.intance.getModel().add(mahasiswa);
        return res;
    }
    
    public Mahasiswa getMahasiswa(String nim, List<Mahasiswa> mahasiswas)
    {
        for(Mahasiswa m:mahasiswas)
        {
            if(m.getNim().equalsIgnoreCase(nim))
            {
                return m;
            }
        }
        return null;
    }
    public Mahasiswa deleteMahasiswa(String nim,List<Mahasiswa> mahasiswas)
    {
        int indeks =0;
        int indeksMahasiswaDiDelete = -1;
        for(Mahasiswa m :mahasiswas)
        {
            if(m.getNim().equalsIgnoreCase(nim))
            {
                indeksMahasiswaDiDelete = indeks;
                break;
            }
            indeks++;
        }
        if(indeksMahasiswaDiDelete != -1)
        {
            mahasiswas.remove(indeksMahasiswaDiDelete);
            return mahasiswas.get(indeksMahasiswaDiDelete);
        }
        return null;
    }
}
