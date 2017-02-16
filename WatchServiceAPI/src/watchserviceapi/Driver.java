/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watchserviceapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static watchserviceapi.MonitoringFolder.cekPerubahan;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Path folder = Paths.get("C:\\Users\\Jayuk\\Documents\\TXT\\Cek");
        cekPerubahan(folder);
        
    }
    
}
