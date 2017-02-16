package akademik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jayuk
 */
public class FileUtil 
{
    static String alamatFile = "C:\\Users\\Jayuk\\Documents\\TXT\\Object\\Object.txt";
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public ObjectOutputStream getOutputStream() throws IOException
    {
        oos = new ObjectOutputStream(new FileOutputStream(new File(alamatFile)));
        return oos;
    }
    public ObjectInputStream getInputStream() throws IOException
    {
        ois = new ObjectInputStream(new FileInputStream(new File(alamatFile)));
        return ois;
    }
    public void closeObjectInputStream() throws IOException
    {
        ois.close();
    }
    public void closeOnjectOutputStream() throws IOException
    {
        oos.close();
    }
}
