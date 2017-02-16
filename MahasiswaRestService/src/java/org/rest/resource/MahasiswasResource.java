package org.rest.resource;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import org.rest.dao.MahasiswaDAO;
import org.rest.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
@Path("/mahasiswas")
public class MahasiswasResource 
{
    @Context
    UriInfo uriInfo;
    @Context
    Request resquest;
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Mahasiswa> getAllMahasiswas()
    {
        List<Mahasiswa> mahasiswas =  new ArrayList<Mahasiswa>();
        mahasiswas.addAll(MahasiswaDAO.intance.getModel());
        return mahasiswas;
    }
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Mahasiswa> getMahasiswas()
    {
        List<Mahasiswa> mahasiswas =  new ArrayList<Mahasiswa>();
        mahasiswas.addAll(MahasiswaDAO.intance.getModel());
        return mahasiswas;
    }
    
    @GET
    @Path("jumlah")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJumlahMahasiswa()
    {
        int jumlah = MahasiswaDAO.intance.getModel().size();
        return String.valueOf(jumlah);
    }
    @Path("{mahasiswa}")
    public MahasiswaResource getMahasiswa(@PathParam("mahasiswa") String nim)
    {
        return new MahasiswaResource(uriInfo, resquest, nim);
    }
}
