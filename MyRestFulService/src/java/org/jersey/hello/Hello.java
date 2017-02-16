package org.jersey.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jayuk
 */
@Path("/hello")
public class Hello 
{
    @GET 
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello()
    {
        return "Hello Dapot";
    }
    
    @GET 
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello()
    {
        return "<?xml version=\"1.0\"?>"+"<hello> Hello Dapot "+"</hello>";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello()
    {
        return "<html><title>Hello Dapot </title><body><h1>Hello Dapot</h1></body></html>";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayJSONHello()
    {
        return "{\"Hello\" : \"Dapot\"}";
    }
}
