package bank;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Jayuk
 */
public class MyThreadFactory implements ThreadFactory
{
    private String namaThread;
    
    public MyThreadFactory(String namaThread)
    {
        this.namaThread=namaThread;
    }
    
    @Override
    public Thread newThread(Runnable r) 
    {
        Thread myThread =  new Thread(r);
        return myThread;
    }
    
}
