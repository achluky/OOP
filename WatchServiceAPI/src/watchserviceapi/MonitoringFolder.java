/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watchserviceapi;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 *
 * @author Jayuk
 */
public class MonitoringFolder 
{
    public static void cekPerubahan(Path path)
    {
        try
        {
            Boolean isFolder = (boolean) Files.getAttribute(path,"basic:isDirectory",NOFOLLOW_LINKS);
            if(!isFolder)
            {
                throw new IllegalArgumentException("Path :"+path+" is not folder");
            }
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("Monitoring path :"+path);
        FileSystem fs = path.getFileSystem();
        try(WatchService service = fs.newWatchService())
        {
            path.register(service, ENTRY_CREATE, ENTRY_MODIFY,ENTRY_DELETE);
            
            WatchKey key = null;
            while(true)
            {
                key = service.take();
                Kind<?> kind = null;
                for(WatchEvent<?> watchEvent :key.pollEvents())
                {
                    kind = watchEvent.kind();
                    if(OVERFLOW == kind)
                    {
                        continue;
                    }
                    else if(ENTRY_CREATE == kind)
                    {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        System.out.println("Path tercipta :"+newPath);
                    }
                    else if(ENTRY_MODIFY==kind)
                    {
                        Path newPath = ((WatchEvent<Path>)watchEvent).context();
                        System.out.println("path dirubah :"+newPath);
                    }
                    else if(ENTRY_DELETE==kind)
                    {
                        Path newPath = ((WatchEvent<Path>)watchEvent).context();
                        System.out.println("Path dihapus :"+newPath);
                    }
                }
                if(!key.reset())
                {
                    break;
                }
            }
        }
        catch(IOException ioe)
        {
            
        }
        catch(InterruptedException ie)
        {
            
        }
    }
}
