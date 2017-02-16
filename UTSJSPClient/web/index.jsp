<%-- 
    Document   : index
    Created on : Nov 7, 2016, 3:50:01 PM
    Author     : Jayuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>    
        <%-- start web service invocation --%><hr/>
    <%
    try {
	org.ws.tiketservice.TiketService_Service service = new org.ws.tiketservice.TiketService_Service();
	org.ws.tiketservice.TiketService port = service.getTiketServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String asal = "";
	java.lang.String tujuan = "";
	// TODO process result here
	org.ws.tiketservice.Tiket result = port.getDataTiket(asal, tujuan);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
