/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkom;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Jayuk
 */
public class WebServer 
{
    public static void main(String[] args) throws Exception
    {
        int port = 2048;
        ServerSocket serverSocket = new ServerSocket(port);
        
        while(true)
        {
            Socket connection = serverSocket.accept();
            HttpRequest request = new HttpRequest(connection);
            Thread thread = new Thread(request);
            thread.start();
        }
    }
}
